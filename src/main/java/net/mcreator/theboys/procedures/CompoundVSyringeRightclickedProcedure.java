package net.mcreator.theboys.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.theboys.init.TheBoysModItems;

public class CompoundVSyringeRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == TheBoysModItems.COMPOUND_V.get()) {
			CompoundVPlayerFinishesUsingItemProcedure.execute(entity);
		}
	}
}
