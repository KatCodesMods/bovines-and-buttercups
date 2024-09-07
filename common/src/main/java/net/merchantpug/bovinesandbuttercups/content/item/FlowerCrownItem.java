package net.merchantpug.bovinesandbuttercups.content.item;

import net.merchantpug.bovinesandbuttercups.registry.BovinesArmorMaterials;
import net.merchantpug.bovinesandbuttercups.registry.BovinesDataComponents;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.List;

public class FlowerCrownItem extends ArmorItem {
    private static final ItemAttributeModifiers EMPTY_NO_TOOLTIP = new ItemAttributeModifiers(List.of(), false);

    public FlowerCrownItem(Properties properties) {
        super(BovinesArmorMaterials.FLOWER_CROWN, Type.HELMET, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("item.bovinesandbuttercups.flower_crown.equippable").withStyle(ChatFormatting.GRAY));
        if (stack.has(BovinesDataComponents.FLOWER_CROWN))
            stack.get(BovinesDataComponents.FLOWER_CROWN).addToTooltip(context, tooltipComponents::add, tooltipFlag);
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        return EMPTY_NO_TOOLTIP;
    }
}