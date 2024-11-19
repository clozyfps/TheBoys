
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theboys.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.theboys.TheBoysMod;

public class TheBoysModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TheBoysMod.MODID);
	public static final RegistryObject<SoundEvent> ZOOM = REGISTRY.register("zoom", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("the_boys", "zoom")));
	public static final RegistryObject<SoundEvent> DICESTEAK = REGISTRY.register("dicesteak", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("the_boys", "dicesteak")));
	public static final RegistryObject<SoundEvent> HEARTBEAT = REGISTRY.register("heartbeat", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("the_boys", "heartbeat")));
	public static final RegistryObject<SoundEvent> BOOM = REGISTRY.register("boom", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("the_boys", "boom")));
	public static final RegistryObject<SoundEvent> LIGHTFLICKER = REGISTRY.register("lightflicker", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("the_boys", "lightflicker")));
	public static final RegistryObject<SoundEvent> ATTACK = REGISTRY.register("attack", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("the_boys", "attack")));
	public static final RegistryObject<SoundEvent> HEATRAY = REGISTRY.register("heatray", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("the_boys", "heatray")));
	public static final RegistryObject<SoundEvent> HEATRAYACTIVE = REGISTRY.register("heatrayactive", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("the_boys", "heatrayactive")));
	public static final RegistryObject<SoundEvent> CLAP = REGISTRY.register("clap", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("the_boys", "clap")));
	public static final RegistryObject<SoundEvent> WEB = REGISTRY.register("web", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("the_boys", "web")));
}
