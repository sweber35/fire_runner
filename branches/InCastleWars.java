package net.thunderpvp.bots.fire_runner.branches;

import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import net.thunderpvp.bots.fire_runner.leaves.TeleportToCastleWars;
import net.thunderpvp.bots.goldfarmer.Location;

public class InCastleWars extends BranchTask{
	
	private HasGearEquipped hasGearEquipped = new HasGearEquipped();
	private TeleportToCastleWars teleportToCastleWars = new TeleportToCastleWars();


	@Override
	public boolean validate() {
//		System.out.println("[IN CWARS] " + Location.CASTLE_WARS.inArea());
		return Location.CASTLE_WARS.inArea();
	}

	@Override
	public TreeTask failureTask() {
		return teleportToCastleWars;
	}

	@Override
	public TreeTask successTask() {
		return hasGearEquipped;
	}
}
