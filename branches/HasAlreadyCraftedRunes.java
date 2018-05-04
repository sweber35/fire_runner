package net.thunderpvp.bots.fire_runner.branches;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import net.thunderpvp.bots.fire_runner.leaves.CraftFireRunes;
import net.thunderpvp.bots.fire_runner.leaves.TeleportToCastleWars;

public class HasAlreadyCraftedRunes extends BranchTask{

	private CraftFireRunes craftFireRunes = new CraftFireRunes();
	private TeleportToCastleWars teleportToCastleWars = new TeleportToCastleWars();
	
	@Override
	public boolean validate() {
		return Inventory.contains("Fire rune") && !Inventory.contains("Pure Essence");
	}
	
	@Override
	public TreeTask failureTask() {
		return craftFireRunes;
	}

	@Override
	public TreeTask successTask() {
		return teleportToCastleWars;
	}

}
