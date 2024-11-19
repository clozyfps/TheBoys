
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theboys.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.theboys.world.inventory.PhoneMenu;
import net.mcreator.theboys.world.inventory.InstagramMenu;
import net.mcreator.theboys.TheBoysMod;

public class TheBoysModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, TheBoysMod.MODID);
	public static final RegistryObject<MenuType<PhoneMenu>> PHONE = REGISTRY.register("phone", () -> IForgeMenuType.create(PhoneMenu::new));
	public static final RegistryObject<MenuType<InstagramMenu>> INSTAGRAM = REGISTRY.register("instagram", () -> IForgeMenuType.create(InstagramMenu::new));
}
