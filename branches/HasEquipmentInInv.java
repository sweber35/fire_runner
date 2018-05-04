package net.thunderpvp.bots.fire_runner.branches;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import net.thunderpvp.bots.fire_runner.leaves.EquipGear;
import net.thunderpvp.bots.fire_runner.leaves.WithdrawEquipment;
import net.thunderpvp.bots.goldfarmer.Constants;

public class HasEquipmentInInv extends BranchTask{

	private WithdrawEquipment withdrawEquip = new WithdrawEquipment();
	private EquipGear equipGear = new EquipGear();
	
	@Override
	public TreeTask failureTask() {
		return withdrawEquip;
	}

	@Override
	public TreeTask successTask() {
		return equipGear;
	}

	@Override
	public boolean validate() {
		return Inventory.containsAnyOf(Constants.GRACEFUL) || Inventory.contains("Fire tiara")
				|| Inventory.containsAnyOf(Constants.RINGS);
	}

}
