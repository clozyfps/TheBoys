
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theboys.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.theboys.entity.WebShotEntity;
import net.mcreator.theboys.entity.WebPullEntity;
import net.mcreator.theboys.entity.WebBombEntity;
import net.mcreator.theboys.entity.TimeStopEntity;
import net.mcreator.theboys.entity.StarlightBlastEntity;
import net.mcreator.theboys.entity.SonicEntity;
import net.mcreator.theboys.entity.OutwardDustEntity;
import net.mcreator.theboys.entity.KnockbackEntity;
import net.mcreator.theboys.entity.HomelanderEntity;
import net.mcreator.theboys.entity.FishShotEntity;
import net.mcreator.theboys.entity.CriminalEntity;
import net.mcreator.theboys.entity.CivilianEntity;
import net.mcreator.theboys.entity.BurstEntity;
import net.mcreator.theboys.entity.BloodProjectileEntity;
import net.mcreator.theboys.entity.BloodDropEntity;
import net.mcreator.theboys.entity.AfterImageLongEntity;
import net.mcreator.theboys.entity.AfterImageEntity;
import net.mcreator.theboys.entity.ATrainEntity;
import net.mcreator.theboys.TheBoysMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheBoysModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TheBoysMod.MODID);
	public static final RegistryObject<EntityType<AfterImageEntity>> AFTER_IMAGE = register("after_image", EntityType.Builder.<AfterImageEntity>of(AfterImageEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(AfterImageEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<OutwardDustEntity>> OUTWARD_DUST = register("outward_dust", EntityType.Builder.<OutwardDustEntity>of(OutwardDustEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OutwardDustEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<StarlightBlastEntity>> STARLIGHT_BLAST = register("starlight_blast",
			EntityType.Builder.<StarlightBlastEntity>of(StarlightBlastEntity::new, MobCategory.MISC).setCustomClientFactory(StarlightBlastEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BloodProjectileEntity>> BLOOD_PROJECTILE = register("blood_projectile", EntityType.Builder.<BloodProjectileEntity>of(BloodProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(BloodProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BloodDropEntity>> BLOOD_DROP = register("blood_drop", EntityType.Builder.<BloodDropEntity>of(BloodDropEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(BloodDropEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<CivilianEntity>> CIVILIAN = register("civilian",
			EntityType.Builder.<CivilianEntity>of(CivilianEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CivilianEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<CriminalEntity>> CRIMINAL = register("criminal",
			EntityType.Builder.<CriminalEntity>of(CriminalEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CriminalEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<HomelanderEntity>> HOMELANDER = register("homelander",
			EntityType.Builder.<HomelanderEntity>of(HomelanderEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HomelanderEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SonicEntity>> SONIC = register("sonic",
			EntityType.Builder.<SonicEntity>of(SonicEntity::new, MobCategory.MISC).setCustomClientFactory(SonicEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<TimeStopEntity>> TIME_STOP = register("time_stop",
			EntityType.Builder.<TimeStopEntity>of(TimeStopEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TimeStopEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BurstEntity>> BURST = register("burst",
			EntityType.Builder.<BurstEntity>of(BurstEntity::new, MobCategory.MISC).setCustomClientFactory(BurstEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AfterImageLongEntity>> AFTER_IMAGE_LONG = register("after_image_long", EntityType.Builder.<AfterImageLongEntity>of(AfterImageLongEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AfterImageLongEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<KnockbackEntity>> KNOCKBACK = register("knockback",
			EntityType.Builder.<KnockbackEntity>of(KnockbackEntity::new, MobCategory.MISC).setCustomClientFactory(KnockbackEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<WebShotEntity>> WEB_SHOT = register("web_shot",
			EntityType.Builder.<WebShotEntity>of(WebShotEntity::new, MobCategory.MISC).setCustomClientFactory(WebShotEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<WebBombEntity>> WEB_BOMB = register("web_bomb",
			EntityType.Builder.<WebBombEntity>of(WebBombEntity::new, MobCategory.MISC).setCustomClientFactory(WebBombEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<WebPullEntity>> WEB_PULL = register("web_pull",
			EntityType.Builder.<WebPullEntity>of(WebPullEntity::new, MobCategory.MISC).setCustomClientFactory(WebPullEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FishShotEntity>> FISH_SHOT = register("fish_shot",
			EntityType.Builder.<FishShotEntity>of(FishShotEntity::new, MobCategory.MISC).setCustomClientFactory(FishShotEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ATrainEntity>> A_TRAIN = register("a_train",
			EntityType.Builder.<ATrainEntity>of(ATrainEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ATrainEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			AfterImageEntity.init();
			OutwardDustEntity.init();
			BloodDropEntity.init();
			CivilianEntity.init();
			CriminalEntity.init();
			HomelanderEntity.init();
			TimeStopEntity.init();
			AfterImageLongEntity.init();
			ATrainEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(AFTER_IMAGE.get(), AfterImageEntity.createAttributes().build());
		event.put(OUTWARD_DUST.get(), OutwardDustEntity.createAttributes().build());
		event.put(BLOOD_DROP.get(), BloodDropEntity.createAttributes().build());
		event.put(CIVILIAN.get(), CivilianEntity.createAttributes().build());
		event.put(CRIMINAL.get(), CriminalEntity.createAttributes().build());
		event.put(HOMELANDER.get(), HomelanderEntity.createAttributes().build());
		event.put(TIME_STOP.get(), TimeStopEntity.createAttributes().build());
		event.put(AFTER_IMAGE_LONG.get(), AfterImageLongEntity.createAttributes().build());
		event.put(A_TRAIN.get(), ATrainEntity.createAttributes().build());
	}
}
