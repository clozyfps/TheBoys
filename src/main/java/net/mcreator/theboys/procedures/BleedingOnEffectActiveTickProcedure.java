package net.mcreator.theboys.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.theboys.init.TheBoysModParticleTypes;
import net.mcreator.theboys.init.TheBoysModMobEffects;

public class BleedingOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheBoysModParticleTypes.BLOOD_PARTICLE.get()), x, (entity.getEyeHeight()), z,
					(int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) - (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
							+ (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheBoysModMobEffects.BLEEDING.get()) ? _livEnt.getEffect(TheBoysModMobEffects.BLEEDING.get()).getAmplifier() : 0)),
					0.01, 0.01, 0.01, 0.01);
		entity.getPersistentData().putDouble("bleedingtimer", (entity.getPersistentData().getDouble("bleedingtimer") + 1));
		if (entity.getPersistentData().getDouble("bleedingtimer") >= 40) {
			entity.getPersistentData().putDouble("bleedingtimer", 0);
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_boys:bleed")))),
					entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheBoysModMobEffects.BLEEDING.get()) ? _livEnt.getEffect(TheBoysModMobEffects.BLEEDING.get()).getAmplifier() : 0);
		}
	}
}
