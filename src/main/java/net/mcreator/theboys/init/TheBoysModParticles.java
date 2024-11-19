
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theboys.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.theboys.client.particle.WindParticle;
import net.mcreator.theboys.client.particle.WebParticleParticle;
import net.mcreator.theboys.client.particle.FireParticleParticle;
import net.mcreator.theboys.client.particle.BloodParticleParticle;
import net.mcreator.theboys.client.particle.BloodParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TheBoysModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(TheBoysModParticleTypes.BLOOD.get(), BloodParticle::provider);
		event.registerSpriteSet(TheBoysModParticleTypes.BLOOD_PARTICLE.get(), BloodParticleParticle::provider);
		event.registerSpriteSet(TheBoysModParticleTypes.FIRE_PARTICLE.get(), FireParticleParticle::provider);
		event.registerSpriteSet(TheBoysModParticleTypes.WIND.get(), WindParticle::provider);
		event.registerSpriteSet(TheBoysModParticleTypes.WEB_PARTICLE.get(), WebParticleParticle::provider);
	}
}
