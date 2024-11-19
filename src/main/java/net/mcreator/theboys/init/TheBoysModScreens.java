
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theboys.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.theboys.client.gui.PhoneScreen;
import net.mcreator.theboys.client.gui.InstagramScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TheBoysModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(TheBoysModMenus.PHONE.get(), PhoneScreen::new);
			MenuScreens.register(TheBoysModMenus.INSTAGRAM.get(), InstagramScreen::new);
		});
	}
}
