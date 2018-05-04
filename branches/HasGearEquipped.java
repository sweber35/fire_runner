package net.thunderpvp.bots.fire_runner.branches;

import com.runemate.game.api.hybrid.local.hud.interfaces.Equipment;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import net.thunderpvp.bots.goldfarmer.Constants;

public class HasGearEquipped extends BranchTask{

	private HasInvSetup hasInvSetup = new HasInvSetup();
	private HasEquipmentInInv equipInInv = new HasEquipmentInInv();
	
	@Override
	public TreeTask failureTask() {
		return equipInInv;
	}

	@Override
	public TreeTask successTask() {
		return hasInvSetup;
	}

	@Override
	public boolean validate() {
		return Equipment.contains("Fire tiara")
				&& Equipment.containsAnyOf(Constants.RINGS);
	}

}
