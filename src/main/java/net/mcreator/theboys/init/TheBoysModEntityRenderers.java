
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theboys.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.theboys.client.renderer.TimeStopRenderer;
import net.mcreator.theboys.client.renderer.OutwardDustRenderer;
import net.mcreator.theboys.client.renderer.HomelanderRenderer;
import net.mcreator.theboys.client.renderer.CriminalRenderer;
import net.mcreator.theboys.client.renderer.CivilianRenderer;
import net.mcreator.theboys.client.renderer.BloodDropRenderer;
import net.mcreator.theboys.client.renderer.AfterImageRenderer;
import net.mcreator.theboys.client.renderer.AfterImageLongRenderer;
import net.mcreator.theboys.client.renderer.ATrainRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TheBoysModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(TheBoysModEntities.AFTER_IMAGE.get(), AfterImageRenderer::new);
		event.registerEntityRenderer(TheBoysModEntities.OUTWARD_DUST.get(), OutwardDustRenderer::new);
		event.registerEntityRenderer(TheBoysModEntities.STARLIGHT_BLAST.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TheBoysModEntities.BLOOD_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TheBoysModEntities.BLOOD_DROP.get(), BloodDropRenderer::new);
		event.registerEntityRenderer(TheBoysModEntities.CIVILIAN.get(), CivilianRenderer::new);
		event.registerEntityRenderer(TheBoysModEntities.CRIMINAL.get(), CriminalRenderer::new);
		event.registerEntityRenderer(TheBoysModEntities.HOMELANDER.get(), HomelanderRenderer::new);
		event.registerEntityRenderer(TheBoysModEntities.SONIC.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TheBoysModEntities.TIME_STOP.get(), TimeStopRenderer::new);
		event.registerEntityRenderer(TheBoysModEntities.BURST.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TheBoysModEntities.AFTER_IMAGE_LONG.get(), AfterImageLongRenderer::new);
		event.registerEntityRenderer(TheBoysModEntities.KNOCKBACK.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TheBoysModEntities.WEB_SHOT.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TheBoysModEntities.WEB_BOMB.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TheBoysModEntities.WEB_PULL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TheBoysModEntities.FISH_SHOT.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TheBoysModEntities.A_TRAIN.get(), ATrainRenderer::new);
	}
}
