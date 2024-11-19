
package net.mcreator.theboys.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class EmptySyringeItem extends Item {
	public EmptySyringeItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
