
package net.mcreator.theboys.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.theboys.procedures.CivilianDisplayConditionProcedure;
import net.mcreator.theboys.procedures.CivilianDisplayCondition8Procedure;
import net.mcreator.theboys.procedures.CivilianDisplayCondition7Procedure;
import net.mcreator.theboys.procedures.CivilianDisplayCondition6Procedure;
import net.mcreator.theboys.procedures.CivilianDisplayCondition5Procedure;
import net.mcreator.theboys.procedures.CivilianDisplayCondition4Procedure;
import net.mcreator.theboys.procedures.CivilianDisplayCondition3Procedure;
import net.mcreator.theboys.procedures.CivilianDisplayCondition2Procedure;
import net.mcreator.theboys.entity.CivilianEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CivilianRenderer extends HumanoidMobRenderer<CivilianEntity, HumanoidModel<CivilianEntity>> {
	public CivilianRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
		this.addLayer(new RenderLayer<CivilianEntity, HumanoidModel<CivilianEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_boys:textures/entities/civilian1.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CivilianEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (CivilianDisplayConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<CivilianEntity, HumanoidModel<CivilianEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_boys:textures/entities/civilian2.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CivilianEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (CivilianDisplayCondition2Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<CivilianEntity, HumanoidModel<CivilianEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_boys:textures/entities/civilian3.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CivilianEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (CivilianDisplayCondition3Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<CivilianEntity, HumanoidModel<CivilianEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_boys:textures/entities/civilian4.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CivilianEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (CivilianDisplayCondition4Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<CivilianEntity, HumanoidModel<CivilianEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_boys:textures/entities/civilian5.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CivilianEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (CivilianDisplayCondition5Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<CivilianEntity, HumanoidModel<CivilianEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_boys:textures/entities/civilian6.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CivilianEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (CivilianDisplayCondition6Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<CivilianEntity, HumanoidModel<CivilianEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_boys:textures/entities/civilian7.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CivilianEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (CivilianDisplayCondition7Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<CivilianEntity, HumanoidModel<CivilianEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_boys:textures/entities/civilian8.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CivilianEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (CivilianDisplayCondition8Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(CivilianEntity entity) {
		return new ResourceLocation("the_boys:textures/entities/a2ie_layer_2.png");
	}
}
