package net.merchantpug.bovinesandbuttercups.client;

import net.merchantpug.bovinesandbuttercups.access.SimpleTextureExceptionAccess;
import net.merchantpug.bovinesandbuttercups.api.CowType;
import net.merchantpug.bovinesandbuttercups.api.CowTypeConfiguration;
import net.merchantpug.bovinesandbuttercups.client.platform.BovinesClientHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;

import java.util.HashSet;

public class BovinesAndButtercupsClient {
    private static final HashSet<ResourceLocation> LOADED_COW_TEXTURES = new HashSet<>();
    private static final HashSet<ResourceLocation> FAILED_COW_TEXTURES = new HashSet<>();
    private static BovinesClientHelper clientHelper;

    public static void init(BovinesClientHelper helper) {
        clientHelper = helper;
    }

    public static void clearCowTextureCache() {
        LOADED_COW_TEXTURES.clear();
        FAILED_COW_TEXTURES.clear();
    }

    public static ResourceLocation getCachedTextures(Holder<CowType<?>> cowType, ResourceLocation original) {
        if (cowType.value().configuration().settings() == null || cowType.value().type().defaultConfig().settings() == null)
            return original;
        ResourceLocation remappedLocation = getTextureFromCowType(cowType.value().configuration(), cowType.value().type().fallbackTexturePath(), cowType.unwrapKey().orElse(cowType.value().type().defaultKey()).location());

        if (LOADED_COW_TEXTURES.contains(remappedLocation))
            return remappedLocation;
        if (FAILED_COW_TEXTURES.contains(remappedLocation)) {
            if (cowType.value().type().defaultConfig().settings() == null)
                return original;

            return getTextureFromCowType(cowType.value().type().defaultConfig(), cowType.value().type().fallbackTexturePath(), cowType.value().type().defaultKey().location());
        }

        if (!((SimpleTextureExceptionAccess)Minecraft.getInstance().getTextureManager().getTexture(remappedLocation)).bovinesandbuttercups$causedException()) {
            LOADED_COW_TEXTURES.add(remappedLocation);
            return remappedLocation;
        }
        else
            FAILED_COW_TEXTURES.add(remappedLocation);

        return getTextureFromCowType(cowType.value().type().defaultConfig(), cowType.value().type().fallbackTexturePath(), cowType.value().type().defaultKey().location());
    }

    private static ResourceLocation getTextureFromCowType(CowTypeConfiguration configuration, String fallbackTexturePath, ResourceLocation originalLocation) {
        return configuration.settings().cowTexture().map(texture -> ResourceLocation.fromNamespaceAndPath(texture.getNamespace(), "textures/entity/" + texture.getPath() + ".png")).orElseGet(() -> originalLocation.withPath(str -> "textures/entity/" + fallbackTexturePath.replace("%s", str) + ".png"));
    }

    public static BovinesClientHelper getHelper() {
        return clientHelper;
    }
}
