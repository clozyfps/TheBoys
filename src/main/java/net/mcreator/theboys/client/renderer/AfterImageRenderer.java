
package net.mcreator.theboys.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.theboys.entity.AfterImageEntity;
import net.mcreator.theboys.client.model.Modelafterimage;

public class AfterImageRenderer extends MobRenderer<AfterImageEntity, Modelafterimage<AfterImageEntity>> {
	public AfterImageRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelafterimage(context.bakeLayer(Modelafterimage.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(AfterImageEntity entity) {
		return new ResourceLocation("the_boys:textures/entities/blueafterimage.png");
	}

	@Override
	protected boolean isBodyVisible(AfterImageEntity entity) {
		return false;
	}
}
