package net.mcreator.theboys.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.theboys.entity.HomelanderEntity;

public class HomelanderOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof HomelanderEntity) {
			((HomelanderEntity) entity).setAnimation("homelanderland");
		}
	}
}
