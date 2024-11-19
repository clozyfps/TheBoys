
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theboys.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.theboys.item.TestItem;
import net.mcreator.theboys.item.PhoneItemItem;
import net.mcreator.theboys.item.EmptySyringeItem;
import net.mcreator.theboys.item.CompoundVSyringeItem;
import net.mcreator.theboys.item.CompoundVItem;
import net.mcreator.theboys.item.BladeItem;
import net.mcreator.theboys.TheBoysMod;

public class TheBoysModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TheBoysMod.MODID);
	public static final RegistryObject<Item> COMPOUND_V = REGISTRY.register("compound_v", () -> new CompoundVItem());
	public static final RegistryObject<Item> COMPOUND_V_SYRINGE = REGISTRY.register("compound_v_syringe", () -> new CompoundVSyringeItem());
	public static final RegistryObject<Item> TEST = REGISTRY.register("test", () -> new TestItem());
	public static final RegistryObject<Item> REDSTONE_LAMP_ON = block(TheBoysModBlocks.REDSTONE_LAMP_ON);
	public static final RegistryObject<Item> BLADE = REGISTRY.register("blade", () -> new BladeItem());
	public static final RegistryObject<Item> PHONE_ITEM = REGISTRY.register("phone_item", () -> new PhoneItemItem());
	public static final RegistryObject<Item> EMPTY_SYRINGE = REGISTRY.register("empty_syringe", () -> new EmptySyringeItem());
	public static final RegistryObject<Item> CIVILIAN_SPAWN_EGG = REGISTRY.register("civilian_spawn_egg", () -> new ForgeSpawnEggItem(TheBoysModEntities.CIVILIAN, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> CRIMINAL_SPAWN_EGG = REGISTRY.register("criminal_spawn_egg", () -> new ForgeSpawnEggItem(TheBoysModEntities.CRIMINAL, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> A_TRAIN_SPAWN_EGG = REGISTRY.register("a_train_spawn_egg", () -> new ForgeSpawnEggItem(TheBoysModEntities.A_TRAIN, -16737793, -15527121, new Item.Properties()));

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
