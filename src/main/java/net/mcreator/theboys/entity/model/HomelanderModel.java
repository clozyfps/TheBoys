package net.mcreator.theboys.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.theboys.entity.HomelanderEntity;

public class HomelanderModel extends GeoModel<HomelanderEntity> {
	@Override
	public ResourceLocation getAnimationResource(HomelanderEntity entity) {
		return new ResourceLocation("the_boys", "animations/homelander.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HomelanderEntity entity) {
		return new ResourceLocation("the_boys", "geo/homelander.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HomelanderEntity entity) {
		return new ResourceLocation("the_boys", "textures/entities/" + entity.getTexture() + ".png");
	}

}
