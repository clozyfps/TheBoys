package net.mcreator.theboys.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.theboys.entity.CriminalEntity;

public class CriminalOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof CriminalEntity _datEntSetI)
			_datEntSetI.getEntityData().set(CriminalEntity.DATA_Skin, Mth.nextInt(RandomSource.create(), 1, 6));
	}
}
