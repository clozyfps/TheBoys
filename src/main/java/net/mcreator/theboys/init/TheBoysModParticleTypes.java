
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theboys.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.theboys.TheBoysMod;

public class TheBoysModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, TheBoysMod.MODID);
	public static final RegistryObject<SimpleParticleType> BLOOD = REGISTRY.register("blood", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> BLOOD_PARTICLE = REGISTRY.register("blood_particle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> FIRE_PARTICLE = REGISTRY.register("fire_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> WIND = REGISTRY.register("wind", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> WEB_PARTICLE = REGISTRY.register("web_particle", () -> new SimpleParticleType(false));
}
