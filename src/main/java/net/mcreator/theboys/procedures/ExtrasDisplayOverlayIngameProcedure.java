package net.mcreator.theboys.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.theboys.init.TheBoysModMobEffects;

public class ExtrasDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(TheBoysModMobEffects.COOLDOWN.get())) {
			return true;
		}
		return false;
	}
}
