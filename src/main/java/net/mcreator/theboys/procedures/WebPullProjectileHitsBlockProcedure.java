package net.mcreator.theboys.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class WebPullProjectileHitsBlockProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("webx", x);
		entity.getPersistentData().putDouble("weby", y);
		entity.getPersistentData().putDouble("webz", z);
		entity.setDeltaMovement(new Vec3(((x - entity.getX()) / 3), ((y - entity.getY()) / 3), ((z - entity.getZ()) / 3)));
	}
}
