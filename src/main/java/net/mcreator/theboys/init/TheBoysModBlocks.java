
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theboys.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.theboys.block.RedstoneLampOnBlock;
import net.mcreator.theboys.TheBoysMod;

public class TheBoysModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TheBoysMod.MODID);
	public static final RegistryObject<Block> REDSTONE_LAMP_ON = REGISTRY.register("redstone_lamp_on", () -> new RedstoneLampOnBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
