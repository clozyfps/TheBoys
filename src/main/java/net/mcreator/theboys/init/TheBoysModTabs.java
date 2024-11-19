
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theboys.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.theboys.TheBoysMod;

public class TheBoysModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheBoysMod.MODID);
	public static final RegistryObject<CreativeModeTab> THE_BOYS_ITEMS = REGISTRY.register("the_boys_items",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.the_boys.the_boys_items")).icon(() -> new ItemStack(TheBoysModItems.COMPOUND_V_SYRINGE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TheBoysModItems.COMPOUND_V.get());
				tabData.accept(TheBoysModItems.COMPOUND_V_SYRINGE.get());
				tabData.accept(TheBoysModItems.BLADE.get());
				tabData.accept(TheBoysModItems.PHONE_ITEM.get());
				tabData.accept(TheBoysModItems.EMPTY_SYRINGE.get());
			}).withSearchBar().build());
	public static final RegistryObject<CreativeModeTab> THE_BOYS_MOBS = REGISTRY.register("the_boys_mobs",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.the_boys.the_boys_mobs")).icon(() -> new ItemStack(TheBoysModItems.A_TRAIN_SPAWN_EGG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TheBoysModItems.A_TRAIN_SPAWN_EGG.get());
			})

					.build());
}
