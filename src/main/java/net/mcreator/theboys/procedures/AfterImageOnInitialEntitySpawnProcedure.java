package net.mcreator.theboys.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.theboys.TheBoysMod;

public class AfterImageOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		TheBoysMod.queueServerWork(15, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
