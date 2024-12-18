package net.mcreator.theboys.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.theboys.network.TheBoysModVariables;
import net.mcreator.theboys.init.TheBoysModEntities;
import net.mcreator.theboys.entity.StarlightBlastEntity;

public class StarlightChargeEffectExpiresProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _shootFrom = entity;
			Level projectileLevel = _shootFrom.level();
			if (!projectileLevel.isClientSide()) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
						AbstractArrow entityToSpawn = new StarlightBlastEntity(TheBoysModEntities.STARLIGHT_BLAST.get(), level);
						entityToSpawn.setOwner(shooter);
						entityToSpawn.setBaseDamage(damage);
						entityToSpawn.setKnockback(knockback);
						entityToSpawn.setSilent(true);
						return entityToSpawn;
					}
				}.getArrow(projectileLevel, entity, (float) (15 + (entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).LightPower),
						(int) (4 + (entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).LightPower / 3));
				_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
				_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 7, 0);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
		}
		if (entity instanceof LivingEntity _entity)
			_entity.swing(InteractionHand.MAIN_HAND, true);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		{
			double _setval = 0;
			entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.LightPower = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		entity.getPersistentData().putDouble("xstarlight", 0);
		entity.getPersistentData().putDouble("ystarlight", 0);
		entity.getPersistentData().putDouble("zstarlight", 0);
	}
}
