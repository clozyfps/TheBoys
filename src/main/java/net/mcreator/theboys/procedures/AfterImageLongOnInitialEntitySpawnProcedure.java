package net.mcreator.theboys.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.theboys.TheBoysMod;

public class AfterImageLongOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		TheBoysMod.queueServerWork(24, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.WHITE_STAINED_GLASS_PANE.defaultBlockState()));
		});
	}
}
