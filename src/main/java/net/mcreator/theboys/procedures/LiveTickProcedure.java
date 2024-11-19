package net.mcreator.theboys.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.theboys.network.TheBoysModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LiveTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).Live) {
			if (!(entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("the_boys:for_the_crowd"))).isDone())) {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("the_boys:for_the_crowd"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
			if (Math.random() < (entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).LiveGeneration / 15) {
				{
					double _setval = (entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).LiveViewers
							+ (entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheBoysModVariables.PlayerVariables())).LiveGeneration;
					entity.getCapability(TheBoysModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.LiveViewers = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
