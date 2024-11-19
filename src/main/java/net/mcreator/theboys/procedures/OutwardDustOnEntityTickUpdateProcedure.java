package net.mcreator.theboys.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class OutwardDustOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xRadius = 0;
		double zRadius = 0;
		double degree = 0;
		double x_pos = 0;
		double y_pos = 0;
		double z_pos = 0;
		entity.getPersistentData().putDouble("xRadiustag", (entity.getPersistentData().getDouble("xincrease")));
		entity.getPersistentData().putDouble("zRadiustag", (entity.getPersistentData().getDouble("zincrease")));
		entity.getPersistentData().putDouble("degreetag", Math.toRadians(entity.getYRot()));
		for (int index0 = 0; index0 < 36; index0++) {
			entity.getPersistentData().putDouble("xpostag", (x + Math.cos(entity.getPersistentData().getDouble("degreetag")) * entity.getPersistentData().getDouble("xRadiustag")));
			entity.getPersistentData().putDouble("ypostag", (y + 0.1));
			entity.getPersistentData().putDouble("zpostag", (z + Math.sin(entity.getPersistentData().getDouble("degreetag")) * entity.getPersistentData().getDouble("zRadiustag")));
			entity.getPersistentData().putDouble("zpostag", (z + Math.sin(entity.getPersistentData().getDouble("degreetag")) * entity.getPersistentData().getDouble("zRadiustag")));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, (entity.getPersistentData().getDouble("xRadiustag")), (entity.getPersistentData().getDouble("ypostag")), (entity.getPersistentData().getDouble("zRadiustag")), 1, 0.1, 0.1, 0.1,
						0.2);
			entity.getPersistentData().putDouble("degreetag", (entity.getPersistentData().getDouble("degreetag") + Math.toRadians(5)));
		}
		entity.getPersistentData().putDouble("degreetag", Math.toRadians(entity.getYRot()));
		entity.getPersistentData().putDouble("xRadiustag", (entity.getPersistentData().getDouble("xdecrease")));
		entity.getPersistentData().putDouble("zRadiustag", (entity.getPersistentData().getDouble("zdecrease")));
		for (int index1 = 0; index1 < 36; index1++) {
			entity.getPersistentData().putDouble("xpostag", (x + Math.cos(entity.getPersistentData().getDouble("degreetag")) * entity.getPersistentData().getDouble("xRadiustag")));
			entity.getPersistentData().putDouble("ypostag", (y + 0.1));
			entity.getPersistentData().putDouble("zpostag", (z + Math.sin(entity.getPersistentData().getDouble("degreetag")) * entity.getPersistentData().getDouble("zRadiustag")));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, (entity.getPersistentData().getDouble("xpostag")), (entity.getPersistentData().getDouble("ypostag")), (entity.getPersistentData().getDouble("zpostag")), 1, 0.1, 0.1, 0.1, 0.2);
			entity.getPersistentData().putDouble("degreetag", (entity.getPersistentData().getDouble("degreetag") + Math.toRadians(5)));
		}
		entity.getPersistentData().putDouble("xincrease", (entity.getPersistentData().getDouble("xincrease") + 0.6));
		entity.getPersistentData().putDouble("zincrease", (entity.getPersistentData().getDouble("zincrease") + 0.6));
		entity.getPersistentData().putDouble("zdecrease", (entity.getPersistentData().getDouble("zdecrease") - 0.6));
		entity.getPersistentData().putDouble("xdecrease", (entity.getPersistentData().getDouble("xdecrease") - 0.6));
	}
}
