package net.mcreator.theboys.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.theboys.network.TheBoysModVariables;
import net.mcreator.theboys.init.TheBoysModMobEffects;

public class SecondTalentProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).Power).equals("Homelander")) {
			if (!(entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).Flight) {
				{
					boolean _setval = true;
					entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Flight = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).Flight) {
				{
					boolean _setval = false;
					entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Flight = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				Vec3 motion = entity.getDeltaMovement().scale(0);
				entity.setDeltaMovement(motion);
			}
		}
		if (((entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).Power).equals("Starlight")) {
			if (!(entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).Flight) {
				{
					boolean _setval = true;
					entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Flight = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).Flight) {
				{
					boolean _setval = false;
					entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Flight = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				Vec3 motion = entity.getDeltaMovement().scale(0);
				entity.setDeltaMovement(motion);
			}
		}
		if (((entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).Power).equals("Blood Manipulation")) {
			if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(TheBoysModMobEffects.COOLDOWN.get()))) {
				entity.getPersistentData().putBoolean("bloodhealing", true);
			}
		}
	}
}
