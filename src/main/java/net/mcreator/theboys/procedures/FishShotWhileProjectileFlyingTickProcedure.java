package net.mcreator.theboys.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.theboys.network.TheBoysModVariables;
import net.mcreator.theboys.TheBoysMod;

import java.util.List;
import java.util.Comparator;

public class FishShotWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entity == entityiterator)) {
					if (!(immediatesourceentity == entityiterator)) {
						if (entityiterator instanceof Cod) {
							entityiterator.getPersistentData().putDouble("randomcodx", (Mth.nextInt(RandomSource.create(), (int) (-0.5), (int) 0.5)));
							entityiterator.getPersistentData().putDouble("randomcody", (Mth.nextInt(RandomSource.create(), (int) (-0.5), (int) 0.5)));
							entityiterator.getPersistentData().putDouble("randomcodz", (Mth.nextInt(RandomSource.create(), (int) (-0.5), (int) 0.5)));
						}
					}
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entity == entityiterator)) {
					if (!(immediatesourceentity == entityiterator)) {
						if (!(entityiterator instanceof Cod)) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK), immediatesourceentity, entity),
									(float) (5 + (entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).Output / 10));
						}
					}
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entity == entityiterator)) {
					if (!(immediatesourceentity == entityiterator)) {
						if (entityiterator instanceof Cod) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 250));
							if (entity instanceof Player _player) {
								_player.getAbilities().invulnerable = true;
								_player.onUpdateAbilities();
							}
							{
								Entity _ent = entityiterator;
								_ent.setYRot(entity.getYRot());
								_ent.setXRot(entity.getXRot());
								_ent.setYBodyRot(_ent.getYRot());
								_ent.setYHeadRot(_ent.getYRot());
								_ent.yRotO = _ent.getYRot();
								_ent.xRotO = _ent.getXRot();
								if (_ent instanceof LivingEntity _entity) {
									_entity.yBodyRotO = _entity.getYRot();
									_entity.yHeadRotO = _entity.getYRot();
								}
							}
							{
								Entity _ent = entityiterator;
								_ent.teleportTo((immediatesourceentity.getX() + entityiterator.getPersistentData().getDouble("randomcodx")), (immediatesourceentity.getY() + entityiterator.getPersistentData().getDouble("randomcody")),
										(immediatesourceentity.getZ() + entityiterator.getPersistentData().getDouble("randomcodz")));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport((immediatesourceentity.getX() + entityiterator.getPersistentData().getDouble("randomcodx")),
											(immediatesourceentity.getY() + entityiterator.getPersistentData().getDouble("randomcody")), (immediatesourceentity.getZ() + entityiterator.getPersistentData().getDouble("randomcodz")), _ent.getYRot(),
											_ent.getXRot());
							}
						}
					}
				}
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.POOF, x, y, z, 1, 0.01, 0.01, 0.01, 0.1);
		TheBoysMod.queueServerWork(10, () -> {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		});
	}
}
