package net.merchantpug.bovinesandbuttercups.content.item.neoforge;

import net.merchantpug.bovinesandbuttercups.client.BovinesBEWLR;
import net.merchantpug.bovinesandbuttercups.content.item.CustomFlowerItem;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class CustomFlowerItemNeoForge extends CustomFlowerItem {
    public CustomFlowerItemNeoForge(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return BovinesBEWLR.BLOCK_ENTITY_WITHOUT_LEVEL_RENDERER;
            }
        });
    }
}