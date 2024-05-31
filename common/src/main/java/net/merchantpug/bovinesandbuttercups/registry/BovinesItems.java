package net.merchantpug.bovinesandbuttercups.registry;

import net.merchantpug.bovinesandbuttercups.BovinesAndButtercups;
import net.merchantpug.bovinesandbuttercups.content.item.CustomFlowerItem;
import net.merchantpug.bovinesandbuttercups.content.item.CustomHugeMushroomItem;
import net.merchantpug.bovinesandbuttercups.content.item.CustomMushroomItem;
import net.merchantpug.bovinesandbuttercups.content.item.NectarBowlItem;
import net.merchantpug.bovinesandbuttercups.platform.BovinesRegistryHelper;
import net.merchantpug.bovinesandbuttercups.registry.internal.RegistrationCallback;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;

import java.util.function.Supplier;

public class BovinesItems {
    public static final NectarBowlItem NECTAR_BOWL = BovinesAndButtercups.getHelper().getRegistryHelper().createNectarBowlItem(new Item.Properties().stacksTo(1).craftRemainder(Items.BOWL));
    public static final Item MOOBLOOM_SPAWN_EGG = new SpawnEggItem(BovinesEntityTypes.MOOBLOOM, 0xfad200, 0x437f34, new Item.Properties());

    public static final BlockItem BUTTERCUP = new BlockItem(BovinesBlocks.BUTTERCUP, new Item.Properties());
    public static final BlockItem PINK_DAISY = new BlockItem(BovinesBlocks.PINK_DAISY, new Item.Properties());
    public static final BlockItem LIMELIGHT = new BlockItem(BovinesBlocks.LIMELIGHT, new Item.Properties());
    public static final BlockItem BIRD_OF_PARADISE = new BlockItem(BovinesBlocks.BIRD_OF_PARADISE, new Item.Properties());
    public static final BlockItem CHARGELILY = new BlockItem(BovinesBlocks.CHARGELILY, new Item.Properties());
    public static final BlockItem HYACINTH = new BlockItem(BovinesBlocks.HYACINTH, new Item.Properties());
    public static final BlockItem SNOWDROP = new BlockItem(BovinesBlocks.SNOWDROP, new Item.Properties());
    public static final BlockItem TROPICAL_BLUE = new BlockItem(BovinesBlocks.TROPICAL_BLUE, new Item.Properties());
    public static final BlockItem FREESIA = new BlockItem(BovinesBlocks.FREESIA, new Item.Properties());

    public static final CustomFlowerItem CUSTOM_FLOWER = BovinesAndButtercups.getHelper().getRegistryHelper().createCustomFlowerItem();
    public static final CustomMushroomItem CUSTOM_MUSHROOM = BovinesAndButtercups.getHelper().getRegistryHelper().createCustomMushroomItem();
    public static final CustomHugeMushroomItem CUSTOM_MUSHROOM_BLOCK = BovinesAndButtercups.getHelper().getRegistryHelper().createCustomHugeMushroomItem();

    public static void registerAll(RegistrationCallback<Item> callback) {
        callback.register(BuiltInRegistries.ITEM, BovinesAndButtercups.asResource("nectar_bowl"), NECTAR_BOWL);
        callback.register(BuiltInRegistries.ITEM, BovinesAndButtercups.asResource("moobloom_spawn_egg"), MOOBLOOM_SPAWN_EGG);

        callback.register(BuiltInRegistries.ITEM, BovinesAndButtercups.asResource("buttercup"), BUTTERCUP);
        callback.register(BuiltInRegistries.ITEM, BovinesAndButtercups.asResource("pink_daisy"), PINK_DAISY);
        callback.register(BuiltInRegistries.ITEM, BovinesAndButtercups.asResource("limelight"), LIMELIGHT);
        callback.register(BuiltInRegistries.ITEM, BovinesAndButtercups.asResource("bird_of_paradise"), BIRD_OF_PARADISE);
        callback.register(BuiltInRegistries.ITEM, BovinesAndButtercups.asResource("chargelily"), CHARGELILY);
        callback.register(BuiltInRegistries.ITEM, BovinesAndButtercups.asResource("hyacinth"), HYACINTH);
        callback.register(BuiltInRegistries.ITEM, BovinesAndButtercups.asResource("snowdrop"), SNOWDROP);
        callback.register(BuiltInRegistries.ITEM, BovinesAndButtercups.asResource("tropical_blue"), TROPICAL_BLUE);
        callback.register(BuiltInRegistries.ITEM, BovinesAndButtercups.asResource("freesia"), FREESIA);

        callback.register(BuiltInRegistries.ITEM, BovinesAndButtercups.asResource("custom_flower"), CUSTOM_FLOWER);
        callback.register(BuiltInRegistries.ITEM, BovinesAndButtercups.asResource("custom_mushroom"), CUSTOM_MUSHROOM);
        callback.register(BuiltInRegistries.ITEM, BovinesAndButtercups.asResource("custom_mushroom_block"), CUSTOM_MUSHROOM_BLOCK);
    }
}