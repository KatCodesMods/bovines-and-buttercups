package net.merchantpug.bovinesandbuttercups.client.renderer.block;

import com.mojang.blaze3d.vertex.PoseStack;
import net.merchantpug.bovinesandbuttercups.BovinesAndButtercups;
import net.merchantpug.bovinesandbuttercups.client.BovinesAndButtercupsClient;
import net.merchantpug.bovinesandbuttercups.client.bovinestate.BovineStatesAssociationRegistry;
import net.merchantpug.bovinesandbuttercups.client.bovinestate.BovineBlockstateTypes;
import net.merchantpug.bovinesandbuttercups.client.util.BovineStateModelUtil;
import net.merchantpug.bovinesandbuttercups.content.block.entity.CustomFlowerBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;

import java.util.Optional;

public class CustomFlowerRenderer implements BlockEntityRenderer<CustomFlowerBlockEntity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public CustomFlowerRenderer(BlockEntityRendererProvider.Context context) {
        this.blockRenderDispatcher = context.getBlockRenderDispatcher();
    }

    @Override
    @SuppressWarnings("ConstantConditions")
    public void render(CustomFlowerBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        ResourceLocation resourceLocation = BovinesAndButtercups.asResource("bovinesandbuttercups/missing_flower/" + BovineStateModelUtil.acceptedStateProperties(BlockModelShaper.statePropertiesToString(blockEntity.getBlockState().getValues())));

        if (blockEntity.getFlowerType() != null && blockEntity.getFlowerType().holder().isBound()) {
            Optional<ResourceLocation> modelLocationWithoutVariant = BovineStatesAssociationRegistry.getBlock(blockEntity.getFlowerType().holder().unwrapKey().get().location(), BovineBlockstateTypes.POTTED_FLOWER);
            if (modelLocationWithoutVariant.isPresent()) {
                resourceLocation = modelLocationWithoutVariant.get();
            }
        }

        BakedModel flowerModel = BovinesAndButtercupsClient.getHelper().getModel(resourceLocation);
        if (flowerModel == null)
            flowerModel = BovinesAndButtercupsClient.getHelper().getModel(BovinesAndButtercups.asResource("bovinesandbuttercups/missing_flower/" + BovineStateModelUtil.acceptedStateProperties(BlockModelShaper.statePropertiesToString(blockEntity.getBlockState().getValues()))));

        blockRenderDispatcher.getModelRenderer().tesselateBlock(blockEntity.getLevel(), flowerModel, blockEntity.getBlockState(), blockEntity.getBlockPos(), poseStack, bufferSource.getBuffer(RenderType.cutout()), false, RandomSource.create(), blockEntity.getBlockState().getSeed(blockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY);
    }
}
