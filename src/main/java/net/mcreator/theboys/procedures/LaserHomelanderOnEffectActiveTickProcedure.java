package net.mcreator.theboys.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.theboys.init.TheBoysModParticleTypes;

import java.util.List;
import java.util.Comparator;

public class LaserHomelanderOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double distance3 = 0;
		double mag = 0;
		double distance2 = 0;
		double deltaz = 0;
		double distance = 0;
		double deltax = 0;
		double deltay = 0;
		entity.getPersistentData().putDouble("deltax",
				(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(30)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() - x));
		entity.getPersistentData().putDouble("deltay",
				(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(30)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() - y));
		entity.getPersistentData().putDouble("deltaz",
				(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(30)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() - z));
		entity.getPersistentData().putDouble("mag", Math.sqrt(entity.getPersistentData().getDouble("deltax") * entity.getPersistentData().getDouble("deltax")
				+ entity.getPersistentData().getDouble("deltay") * entity.getPersistentData().getDouble("deltay") + entity.getPersistentData().getDouble("deltaz") * entity.getPersistentData().getDouble("deltaz")));
		if (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(30)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getType() == HitResult.Type.BLOCK) {
			if (world
					.getBlockState(new BlockPos(
							entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(30)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
							entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(30)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
							entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(30)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()))
					.canOcclude()) {
				world.destroyBlock(
						new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(30)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(30)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(30)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
						false);
			}
		}
		entity.getPersistentData().putDouble("lasereyestimer", (entity.getPersistentData().getDouble("lasereyestimer") + 1));
		if (entity.getPersistentData().getDouble("lasereyestimer") >= 8) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null,
							BlockPos.containing(x + Math.sin(Math.toRadians(entity.getYRot())) * 0 + Math.cos(Math.toRadians(entity.getYRot())) * (-1) * 0.2 + entity.getLookAngle().x * entity.getPersistentData().getDouble("distance"),
									y + 1.55 + entity.getLookAngle().y * entity.getPersistentData().getDouble("distance"),
									z + Math.cos(Math.toRadians(entity.getYRot())) * (-1) * 0 - Math.sin(Math.toRadians(entity.getYRot())) * 0.2 + entity.getLookAngle().z * entity.getPersistentData().getDouble("distance")),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_boys:heatrayactive")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound((x + Math.sin(Math.toRadians(entity.getYRot())) * 0 + Math.cos(Math.toRadians(entity.getYRot())) * (-1) * 0.2 + entity.getLookAngle().x * entity.getPersistentData().getDouble("distance")),
							(y + 1.55 + entity.getLookAngle().y * entity.getPersistentData().getDouble("distance")),
							(z + Math.cos(Math.toRadians(entity.getYRot())) * (-1) * 0 - Math.sin(Math.toRadians(entity.getYRot())) * 0.2 + entity.getLookAngle().z * entity.getPersistentData().getDouble("distance")),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_boys:heatrayactive")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null,
							BlockPos.containing(x + Math.sin(Math.toRadians(entity.getYRot())) * 0 + Math.cos(Math.toRadians(entity.getYRot())) * (-1) * (-0.2) + entity.getLookAngle().x * entity.getPersistentData().getDouble("distancethree"),
									y + 1.55 + entity.getLookAngle().y * entity.getPersistentData().getDouble("distancethree"),
									z + Math.cos(Math.toRadians(entity.getYRot())) * (-1) * 0 - Math.sin(Math.toRadians(entity.getYRot())) * (-0.2) + entity.getLookAngle().z * entity.getPersistentData().getDouble("distancethree")),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_boys:heatrayactive")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound((x + Math.sin(Math.toRadians(entity.getYRot())) * 0 + Math.cos(Math.toRadians(entity.getYRot())) * (-1) * (-0.2) + entity.getLookAngle().x * entity.getPersistentData().getDouble("distancethree")),
							(y + 1.55 + entity.getLookAngle().y * entity.getPersistentData().getDouble("distancethree")),
							(z + Math.cos(Math.toRadians(entity.getYRot())) * (-1) * 0 - Math.sin(Math.toRadians(entity.getYRot())) * (-0.2) + entity.getLookAngle().z * entity.getPersistentData().getDouble("distancethree")),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_boys:heatrayactive")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			entity.getPersistentData().putDouble("lasereyestimer", 0);
		}
		for (int index0 = 0; index0 < (int) (entity.getPersistentData().getDouble("mag") * 5); index0++) {
			{
				final Vec3 _center = new Vec3((x + entity.getLookAngle().x * entity.getPersistentData().getDouble("distancetwo")), (y + entity.getLookAngle().y * entity.getPersistentData().getDouble("distancetwo")),
						(z + entity.getLookAngle().z * entity.getPersistentData().getDouble("distancetwo")));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity)) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ON_FIRE), entity), 10);
						entityiterator.setSecondsOnFire(1);
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (TheBoysModParticleTypes.BLOOD_PARTICLE.get()), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 25, 0.1, 0.1, 0.1, 0);
					}
				}
			}
			entity.getPersistentData().putDouble("distancetwo", (entity.getPersistentData().getDouble("distancetwo") + 0.2));
		}
		for (int index1 = 0; index1 < (int) (entity.getPersistentData().getDouble("mag") * 2); index1++) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands()
						.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
								new Vec3((x + Math.sin(Math.toRadians(entity.getYRot())) * 0 + Math.cos(Math.toRadians(entity.getYRot())) * (-1) * 0.2 + entity.getLookAngle().x * entity.getPersistentData().getDouble("distance")),
										(y + 1.55 + entity.getLookAngle().y * entity.getPersistentData().getDouble("distance")),
										(z + Math.cos(Math.toRadians(entity.getYRot())) * (-1) * 0 - Math.sin(Math.toRadians(entity.getYRot())) * 0.2 + entity.getLookAngle().z * entity.getPersistentData().getDouble("distance"))),
								Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "particle minecraft:dust 0.93 0.14 0.05 0.8 ^0 ^0 ^0 0.01 0.01 0.01 0 1");
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheBoysModParticleTypes.FIRE_PARTICLE.get()),
						(x + Math.sin(Math.toRadians(entity.getYRot())) * 0 + Math.cos(Math.toRadians(entity.getYRot())) * (-1) * 0.2 + entity.getLookAngle().x * entity.getPersistentData().getDouble("distance")),
						(y + 1.55 + entity.getLookAngle().y * entity.getPersistentData().getDouble("distance")),
						(z + Math.cos(Math.toRadians(entity.getYRot())) * (-1) * 0 - Math.sin(Math.toRadians(entity.getYRot())) * 0.2 + entity.getLookAngle().z * entity.getPersistentData().getDouble("distance")), 1, 0.01, 0.01, 0.01, 0);
			entity.getPersistentData().putDouble("distance", (entity.getPersistentData().getDouble("distance") + 0.5));
		}
		for (int index2 = 0; index2 < (int) (entity.getPersistentData().getDouble("mag") * 2); index2++) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands()
						.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
								new Vec3((x + Math.sin(Math.toRadians(entity.getYRot())) * 0 + Math.cos(Math.toRadians(entity.getYRot())) * (-1) * (-0.2) + entity.getLookAngle().x * entity.getPersistentData().getDouble("distancethree")),
										(y + 1.55 + entity.getLookAngle().y * entity.getPersistentData().getDouble("distancethree")),
										(z + Math.cos(Math.toRadians(entity.getYRot())) * (-1) * 0 - Math.sin(Math.toRadians(entity.getYRot())) * (-0.2) + entity.getLookAngle().z * entity.getPersistentData().getDouble("distancethree"))),
								Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "particle minecraft:dust 0.93 0.14 0.05 0.8 ^0 ^0 ^0 0.01 0.01 0.01 0 1");
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheBoysModParticleTypes.FIRE_PARTICLE.get()),
						(x + Math.sin(Math.toRadians(entity.getYRot())) * 0 + Math.cos(Math.toRadians(entity.getYRot())) * (-1) * (-0.2) + entity.getLookAngle().x * entity.getPersistentData().getDouble("distancethree")),
						(y + 1.55 + entity.getLookAngle().y * entity.getPersistentData().getDouble("distancethree")),
						(z + Math.cos(Math.toRadians(entity.getYRot())) * (-1) * 0 - Math.sin(Math.toRadians(entity.getYRot())) * (-0.2) + entity.getLookAngle().z * entity.getPersistentData().getDouble("distancethree")), 1, 0.01, 0.01, 0.01, 0);
			entity.getPersistentData().putDouble("distancethree", (entity.getPersistentData().getDouble("distancethree") + 0.5));
		}
	}
}
