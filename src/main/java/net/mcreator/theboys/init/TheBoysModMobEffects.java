
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theboys.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.theboys.potion.TrainingCooldownMobEffect;
import net.mcreator.theboys.potion.StunnedMobEffect;
import net.mcreator.theboys.potion.StarlightChargeMobEffect;
import net.mcreator.theboys.potion.SpeedBurstMobEffect;
import net.mcreator.theboys.potion.SlowTimeMobEffect;
import net.mcreator.theboys.potion.RandomSpeedBoostMobEffect;
import net.mcreator.theboys.potion.LaserHomelanderMobEffect;
import net.mcreator.theboys.potion.InvisPowerMobEffect;
import net.mcreator.theboys.potion.ImpactFrameMobEffect;
import net.mcreator.theboys.potion.HeartbeatMobEffect;
import net.mcreator.theboys.potion.FishFireMobEffect;
import net.mcreator.theboys.potion.DetectMobEffect;
import net.mcreator.theboys.potion.CooldownMobEffect;
import net.mcreator.theboys.potion.BloodHealingMobEffect;
import net.mcreator.theboys.potion.BleedingMobEffect;
import net.mcreator.theboys.TheBoysMod;

public class TheBoysModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TheBoysMod.MODID);
	public static final RegistryObject<MobEffect> INVIS_POWER = REGISTRY.register("invis_power", () -> new InvisPowerMobEffect());
	public static final RegistryObject<MobEffect> HEARTBEAT = REGISTRY.register("heartbeat", () -> new HeartbeatMobEffect());
	public static final RegistryObject<MobEffect> SLOW_TIME = REGISTRY.register("slow_time", () -> new SlowTimeMobEffect());
	public static final RegistryObject<MobEffect> COOLDOWN = REGISTRY.register("cooldown", () -> new CooldownMobEffect());
	public static final RegistryObject<MobEffect> STARLIGHT_CHARGE = REGISTRY.register("starlight_charge", () -> new StarlightChargeMobEffect());
	public static final RegistryObject<MobEffect> BLEEDING = REGISTRY.register("bleeding", () -> new BleedingMobEffect());
	public static final RegistryObject<MobEffect> BLOOD_HEALING = REGISTRY.register("blood_healing", () -> new BloodHealingMobEffect());
	public static final RegistryObject<MobEffect> LASER_HOMELANDER = REGISTRY.register("laser_homelander", () -> new LaserHomelanderMobEffect());
	public static final RegistryObject<MobEffect> DETECT = REGISTRY.register("detect", () -> new DetectMobEffect());
	public static final RegistryObject<MobEffect> STUNNED = REGISTRY.register("stunned", () -> new StunnedMobEffect());
	public static final RegistryObject<MobEffect> SPEED_BURST = REGISTRY.register("speed_burst", () -> new SpeedBurstMobEffect());
	public static final RegistryObject<MobEffect> IMPACT_FRAME = REGISTRY.register("impact_frame", () -> new ImpactFrameMobEffect());
	public static final RegistryObject<MobEffect> FISH_FIRE = REGISTRY.register("fish_fire", () -> new FishFireMobEffect());
	public static final RegistryObject<MobEffect> RANDOM_SPEED_BOOST = REGISTRY.register("random_speed_boost", () -> new RandomSpeedBoostMobEffect());
	public static final RegistryObject<MobEffect> TRAINING_COOLDOWN = REGISTRY.register("training_cooldown", () -> new TrainingCooldownMobEffect());
}
