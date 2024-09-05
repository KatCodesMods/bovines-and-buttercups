package net.merchantpug.bovinesandbuttercups.client.renderer.entity;

import net.merchantpug.bovinesandbuttercups.BovinesAndButtercups;
import net.merchantpug.bovinesandbuttercups.client.model.MoobloomModel;
import net.merchantpug.bovinesandbuttercups.client.registry.BovinesModelLayers;
import net.merchantpug.bovinesandbuttercups.client.renderer.entity.layer.MoobloomFlowerLayer;
import net.merchantpug.bovinesandbuttercups.client.renderer.entity.layer.CowLayersLayer;
import net.merchantpug.bovinesandbuttercups.content.entity.Moobloom;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MoobloomRenderer extends MobRenderer<Moobloom, MoobloomModel> {

    public MoobloomRenderer(EntityRendererProvider.Context context) {
        super(context, new MoobloomModel(context.bakeLayer(BovinesModelLayers.MOOBLOOM_MODEL_LAYER)), 0.7f);
        this.addLayer(new CowLayersLayer<>(this));
        this.addLayer(new MoobloomFlowerLayer<>(this, context.getBlockRenderDispatcher()));
    }

    @Override
    public ResourceLocation getTextureLocation(Moobloom entity) {
        return BovinesAndButtercups.asResource("textures/entity/bovinesandbuttercups/moobloom/missing_moobloom.png");
    }
}
