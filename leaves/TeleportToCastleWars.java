package net.thunderpvp.bots.fire_runner.leaves;

import com.runemate.game.api.script.framework.tree.LeafTask;

import net.thunderpvp.bots.goldfarmer.Location;

public class TeleportToCastleWars extends LeafTask {
	@Override
    public void execute() {
    	Location.CASTLE_WARS.teleport();
    }
}
 