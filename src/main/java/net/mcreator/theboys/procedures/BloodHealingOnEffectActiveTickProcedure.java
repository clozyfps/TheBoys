package net.mcreator.theboys.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.theboys.network.TheBoysModVariables;
import net.mcreator.theboys.init.TheBoysModParticleTypes;
import net.mcreator.theboys.init.TheBoysModMobEffects;

import java.util.List;
import java.util.Comparator;

public class BloodHealingOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double raytrace_distance = 0;
		double WebPower = 0;
		double T = 0;
		double Zo = 0;
		double Yo = 0;
		double Za = 0;
		double Xo = 0;
		double Ya = 0;
		double Xa = 0;
		raytrace_distance = 1;
		for (int index0 = 0; index0 < 14; index0++) {
			if (!world.getBlockState(new BlockPos(
					entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
					entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
					entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()))
					.canOcclude() || raytrace_distance < 14) {
				raytrace_distance = raytrace_distance + 1;
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("particle minecraft:dust 0.93 0.14 0.05 1 ^0 ^0 ^0 " + new java.text.DecimalFormat("#").format((Math.sin(Math.toRadians(entity.getYRot() + 180)) * raytrace_distance) / 2) + " "
									+ new java.text.DecimalFormat("#").format((Math.sin(Math.toRadians(0 - entity.getXRot())) * raytrace_distance) / 2) + " "
									+ new java.text.DecimalFormat("#").format((Math.cos(Math.toRadians(entity.getYRot())) * raytrace_distance) / 2) + " "
									+ new java.text.DecimalFormat("#").format((entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).Blood)));
			}
		}
		WebPower = 20;
		raytrace_distance = (x - entity.getX()) / WebPower;
		raytrace_distance = (y - entity.getY()) / WebPower;
		raytrace_distance = (z - entity.getZ()) / WebPower;
		raytrace_distance = 5;
		{
			final Vec3 _center = new Vec3(
					(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(15)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
					(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(15)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
					(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(15)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof LivingEntity && entityiterator instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(TheBoysModMobEffects.BLEEDING.get())) {
					if (!(entity == entityiterator)) {
						if (entity.isShiftKeyDown()) {
							if ((entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).Output
									/ 3 >= (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
								world.levelEvent(2001, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), Block.getId(Blocks.REDSTONE_BLOCK.defaultBlockState()));
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_boys:pop"))), entity),
										entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (TheBoysModParticleTypes.BLOOD_PARTICLE.get()), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 50, 0.01, 1.5, 0.01, 0.1);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_boys:dicesteak")),
												SoundSource.NEUTRAL, 1, (float) 0.6);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_boys:dicesteak")), SoundSource.NEUTRAL, 1,
												(float) 0.6, false);
									}
								}
							}
						} else {
							if (entityiterator instanceof LivingEntity _entity)
								_entity.setHealth((float) ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
										+ (entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).Output / 100));
						}
						if ((entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new TheBoysModVariables.PlayerVariables())).Blood >= (entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).Output / 100) {
							{
								double _setval = (entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).Blood
										- (entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).Output / 100;
								entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.Blood = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if ((entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new TheBoysModVariables.PlayerVariables())).Blood < (entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).Output / 100) {
							if (entity instanceof LivingEntity _entity)
								_entity.removeEffect(TheBoysModMobEffects.BLOOD_HEALING.get());
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(TheBoysModMobEffects.COOLDOWN.get(), 60, 0, false, false));
						}
						Xo = entity.getX() - entityiterator.getX();
						Yo = entity.getY() - entityiterator.getY();
						Zo = entity.getZ() - entityiterator.getZ();
						if (Math.floor(entity.getX()) <= Math.floor(entityiterator.getX())) {
							if (Math.floor(entity.getX()) == Math.floor(entityiterator.getX())) {
								if (Math.floor(entity.getY()) == Math.floor(entityiterator.getY())) {
									if (Math.floor(entity.getZ()) <= Math.floor(entityiterator.getZ())) {
										Za = Math.floor(entity.getZ()) + 0.2;
										while (Za <= Math.floor(entityiterator.getZ())) {
											T = (Za - entity.getZ()) / Zo;
											Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
											Xa = entity.getX() + Xo * T;
											if (world instanceof ServerLevel _level)
												_level.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, new Vec3(Xa, Ya, Za), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
														"particle minecraft:dust 0.93 0.14 0.05 1 ^0 ^0 ^0 0.01 0.01 0.01 0 1");
											Za = 0.2 + Za;
										}
									} else {
										Za = Math.floor(entityiterator.getZ()) + 0.2;
										while (Za <= Math.floor(entity.getZ())) {
											T = (Za - entity.getZ()) / Zo;
											Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
											Xa = entity.getX() + Xo * T;
											if (world instanceof ServerLevel _level)
												_level.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, new Vec3(Xa, Ya, Za), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
														"particle minecraft:dust 0.93 0.14 0.05 1 ^0 ^0 ^0 0.01 0.01 0.01 0 1");
											Za = 0.2 + Za;
										}
									}
								} else {
									if (Math.floor(entity.getY()) <= Math.floor(entityiterator.getY())) {
										Ya = Math.floor(entity.getY()) + 0.2;
										while (Ya <= Math.floor(entityiterator.getY())) {
											T = (Ya - entity.getY()) / Yo;
											Xa = entity.getX() + Xo * T;
											Za = entity.getZ() + Zo * T;
											if (world instanceof ServerLevel _level)
												_level.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, new Vec3(Xa, Ya, Za), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
														"particle minecraft:dust 0.93 0.14 0.05 1 ^0 ^0 ^0 0.01 0.01 0.01 0 1");
											Ya = 0.2 + Ya;
										}
									} else {
										Ya = Math.floor(entityiterator.getY()) + 0.2;
										while (Ya <= Math.floor(entity.getY())) {
											T = (Ya - entity.getY()) / Yo;
											Xa = entity.getX() + Xo * T;
											Za = entity.getZ() + Zo * T;
											if (world instanceof ServerLevel _level)
												_level.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, new Vec3(Xa, Ya, Za), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
														"particle minecraft:dust 0.93 0.14 0.05 1 ^0 ^0 ^0 0.01 0.01 0.01 0 1");
											Ya = 0.2 + Ya;
										}
									}
								}
							} else {
								Xa = Math.floor(entity.getX()) + 0.2;
								while (Xa <= Math.floor(entityiterator.getX())) {
									T = (Xa - entity.getX()) / Xo;
									Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
									Za = entity.getZ() + Zo * T;
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(Xa, Ya, Za), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"particle minecraft:dust 0.93 0.14 0.05 1 ^0 ^0 ^0 0.01 0.01 0.01 0 1");
									Xa = 0.2 + Xa;
								}
							}
						} else {
							Xa = entityiterator.getX() + 0.2;
							while (Xa < Math.floor(entity.getX())) {
								T = (Xa - entity.getX()) / Xo;
								Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
								Za = entity.getZ() + Zo * T;
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(Xa, Ya, Za), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"particle minecraft:dust 0.93 0.14 0.05 1 ^0 ^0 ^0 0.01 0.01 0.01 0 1");
								Xa = 0.2 + Xa;
							}
						}
					}
				}
			}
		}
	}
}
