package net.mcreator.theboys.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.theboys.network.TheBoysModVariables;

public class BloodUiProProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "\u00A7cBlood [" + new java.text.DecimalFormat("#").format((entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).Blood) + "]";
	}
}