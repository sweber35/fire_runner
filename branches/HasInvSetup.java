package net.thunderpvp.bots.fire_runner.branches;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import net.thunderpvp.bots.fire_runner.leaves.SetupInv;
import net.thunderpvp.bots.fire_runner.leaves.TeleportToDuelArena;
import net.thunderpvp.bots.goldfarmer.Constants;

/**
 * NOTES: Does this bot have its inventory set up for fire rune runs?
 */
public class HasInvSetup extends BranchTask {

	private SetupInv setupInv = new SetupInv();
	private TeleportToDuelArena teleportDuelArena = new TeleportToDuelArena();

	@Override
	public boolean validate() {
		return Inventory.contains(Constants.PURE_ESSENCE);
	}

	@Override
	public TreeTask failureTask() {
		return setupInv;
	}

	@Override
	public TreeTask successTask() {
		return teleportDuelArena;
	}
}
