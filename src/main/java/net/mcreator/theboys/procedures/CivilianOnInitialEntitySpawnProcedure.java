package net.mcreator.theboys.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.theboys.entity.CivilianEntity;

public class CivilianOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof CivilianEntity _datEntSetI)
			_datEntSetI.getEntityData().set(CivilianEntity.DATA_skincivilian, Mth.nextInt(RandomSource.create(), 1, 8));
	}
}
