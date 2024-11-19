package net.mcreator.theboys.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.theboys.init.TheBoysModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BleedAttackProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity entity, double amount) {
		execute(null, entity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, double amount) {
		if (entity == null)
			return;
		if (amount >= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 10) {
			if (entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(TheBoysModMobEffects.BLEEDING.get())) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(TheBoysModMobEffects.BLEEDING.get(),
							(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheBoysModMobEffects.BLEEDING.get()) ? _livEnt.getEffect(TheBoysModMobEffects.BLEEDING.get()).getDuration() : 0) + 60), 0));
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(TheBoysModMobEffects.BLEEDING.get(), 60, 0));
			}
		}
	}
}
