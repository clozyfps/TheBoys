package net.mcreator.theboys.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.theboys.network.TheBoysModVariables;

public class ATrainDisplayProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (((entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).Power).equals("Super Speed")) {
			return true;
		}
		return false;
	}
}