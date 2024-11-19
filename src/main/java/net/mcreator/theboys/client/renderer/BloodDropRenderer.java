
package net.mcreator.theboys.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.theboys.entity.BloodDropEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class BloodDropRenderer extends HumanoidMobRenderer<BloodDropEntity, HumanoidModel<BloodDropEntity>> {
	public BloodDropRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	protected void scale(BloodDropEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.1f, 0.1f, 0.1f);
	}

	@Override
	public ResourceLocation getTextureLocation(BloodDropEntity entity) {
		return new ResourceLocation("the_boys:textures/entities/a2ie_layer_2.png");
	}
}
