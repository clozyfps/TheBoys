package net.mcreator.theboys.procedures;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.theboys.init.TheBoysModMobEffects;
import net.mcreator.theboys.entity.HomelanderEntity;

public class HomelanderOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.onGround()) {
			if (entity instanceof HomelanderEntity) {
				((HomelanderEntity) entity).setAnimation("flight");
			}
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
				if (Math.random() < 0.01) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(TheBoysModMobEffects.LASER_HOMELANDER.get(), 40, 0, false, false));
				}
			}
		}
	}
}
