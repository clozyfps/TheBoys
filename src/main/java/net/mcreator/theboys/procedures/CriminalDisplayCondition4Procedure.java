package net.mcreator.theboys.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.theboys.entity.CriminalEntity;

public class CriminalDisplayCondition4Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof CriminalEntity _datEntI ? _datEntI.getEntityData().get(CriminalEntity.DATA_Skin) : 0) == 4) {
			return true;
		}
		return false;
	}
}