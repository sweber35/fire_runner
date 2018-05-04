package net.thunderpvp.bots.fire_runner.leaves;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.location.navigation.basic.BresenhamPath;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

import net.thunderpvp.bots.goldfarmer.Constants;

/**
 * NOTES: Make the bot craft all runes and return to the duel arena.
 */
public class CraftFireRunes extends LeafTask {

	Player player = Players.getLocal();

	@Override
	public void execute() {
		GameObject altar = GameObjects.newQuery()./*on(Constants.fireAltar).*/names("Altar")
				.results().first();
		BresenhamPath path = null;
		 
		if (altar != null) {
			path = BresenhamPath.buildTo(altar);
			if (altar.isVisible()) {
				if (altar.click()) {
					
				}

			} else {
				if (path != null) { // Although BresenhamPath technically always builds a path, it is recommended to nullcheck rather than having the bot crash
		           path.step();
		        }
				Camera.turnTo(altar);
			}
		}
		Execution.delayUntil(() -> !Inventory.isFull() && player.getAnimationId() == -1, 200, 500);
	}
}
