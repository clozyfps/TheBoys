package net.mcreator.theboys.procedures;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

public class HomelanderStopFightingProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			return false;
		}
		return true;
	}
}
