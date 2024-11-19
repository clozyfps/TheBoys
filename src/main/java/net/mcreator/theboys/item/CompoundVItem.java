
package net.mcreator.theboys.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CompoundVItem extends Item {
	public CompoundVItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
	}
}
