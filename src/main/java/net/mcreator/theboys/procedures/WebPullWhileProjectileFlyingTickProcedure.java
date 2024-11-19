package net.mcreator.theboys.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.theboys.init.TheBoysModParticleTypes;

import java.util.List;
import java.util.Comparator;

public class WebPullWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheBoysModParticleTypes.WEB_PARTICLE.get()), x, y, z, 5, 0.01, 0.01, 0.01, 0.01);
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entity == entityiterator)) {
					if (!(immediatesourceentity == entityiterator)) {
						if (entityiterator instanceof Player) {
							{
								Entity _ent = entityiterator;
								_ent.teleportTo((entity.getX()), (entity.getY()), (entity.getZ()));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
							}
						} else {
							entityiterator.setDeltaMovement(new Vec3(((entity.getX() - entityiterator.getX()) / 5), ((entity.getY() - entityiterator.getY()) / 5), ((entity.getZ() - entityiterator.getZ()) / 5)));
						}
					}
				}
			}
		}
	}
}
