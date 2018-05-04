package net.thunderpvp.bots.fire_runner.leaves;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Equipment;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

import net.thunderpvp.bots.goldfarmer.BankUtil;
import net.thunderpvp.bots.goldfarmer.BankWithdrawal;
import net.thunderpvp.bots.goldfarmer.Constants;
import net.thunderpvp.bots.goldfarmer.Util;

public class WithdrawEquipment extends LeafTask{

	@Override
	public void execute() {
		
		BankUtil.open();
		BankUtil.ensureWithdrawals(new BankWithdrawal(2552, 1));
		Execution.delayUntil(() -> Bank.close(), 200, 500);
	}
		
	private void withdrawItems() {
		if (!Equipment.containsAnyOf(Constants.GRACEFUL)) {
			SpriteItem hood = Bank.newQuery().names("Graceful hood").results().first();
			if (hood != null) {
				Bank.withdraw(hood, 1);
			}
			
			SpriteItem top = Bank.newQuery().names("Graceful top").results().first();
			if (top != null) {
				Bank.withdraw(top, 1);
			}
			
			SpriteItem legs = Bank.newQuery().names("Graceful legs").results().first();
			if (legs != null) {
				Bank.withdraw(legs, 1);
			}
			
			SpriteItem gloves = Bank.newQuery().names("Graceful gloves").results().first();
			if (gloves != null) {
				Bank.withdraw(gloves, 1);
			}
			
			SpriteItem boots = Bank.newQuery().names("Graceful boots").results().first() != null
							   ? Bank.newQuery().names("Graceful boots").results().first()
							   : Bank.newQuery().names("Boots of lightness").results().first();
			if (boots != null) {
				Bank.withdraw(boots, 1);
			}
		}
		
		if (!Equipment.containsAnyOf(Constants.RINGS)) {
			SpriteItem ring = Bank.newQuery().names("Ring of dueling(8)").results().first();
			if (ring != null) {
				Bank.withdraw(ring, 1);
			}
		}
		
		if (!Equipment.contains("Fire tiara")) {
			SpriteItem tiara = Bank.newQuery().names("Fire tiara").results().first();
			if (tiara != null) {
				Bank.withdraw(tiara, 1);
			}
		}
	}
}
