package net.mcreator.theboys.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.theboys.entity.CivilianEntity;

public class CivilianDisplayCondition6Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof CivilianEntity _datEntI ? _datEntI.getEntityData().get(CivilianEntity.DATA_skincivilian) : 0) == 6) {
			return true;
		}
		return false;
	}
}
