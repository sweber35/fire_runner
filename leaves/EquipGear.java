package net.thunderpvp.bots.fire_runner.leaves;

import com.runemate.game.api.hybrid.local.hud.interfaces.Equipment;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.script.framework.tree.LeafTask;

import net.thunderpvp.bots.goldfarmer.Constants;

public class EquipGear extends LeafTask{

	public void execute() {
		
		SpriteItem ring = Inventory.newQuery().names("Ring of dueling(8)").results().first();
		if (ring != null) {
			Inventory.equip(ring);
		}
		
	}
	
	private void equipItems() {
		if (!Equipment.containsAnyOf(Constants.GRACEFUL)) {
			SpriteItem hood = Inventory.newQuery().names("Graceful hood").results().first();
			if (hood != null) {
				Inventory.equip(hood);
			}
			
			SpriteItem top = Inventory.newQuery().names("Graceful top").results().first();
			if (top != null) {
				Inventory.equip(top);
			}
			
			SpriteItem legs = Inventory.newQuery().names("Graceful legs").results().first();
			if (legs != null) {
				Inventory.equip(legs);
			}
			
			SpriteItem gloves = Inventory.newQuery().names("Graceful gloves").results().first();
			if (gloves != null) {
				Inventory.equip(gloves);
			}
			
			SpriteItem boots = Inventory.newQuery().names("Graceful boots").results().first() != null
							   ? Inventory.newQuery().names("Graceful boots").results().first()
							   : Inventory.newQuery().names("Boots of lightness").results().first();
			if (boots != null) {
				Inventory.equip(boots);
			}
		}
		
		if (!Equipment.containsAnyOf(Constants.RINGS)) {
			SpriteItem ring = Inventory.newQuery().names("Ring of dueling(8)").results().first();
			if (ring != null) {
				Inventory.equip(ring);
			}
		}
		
		if (!Equipment.contains("Fire tiara")) {
			SpriteItem tiara = Inventory.newQuery().names("Fire tiara").results().first();
			if (tiara != null) {
				Inventory.equip(tiara);
			}
		}
	}
}
