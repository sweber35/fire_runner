package net.thunderpvp.bots.fire_runner.leaves;

import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

import net.thunderpvp.bots.goldfarmer.Location;

/**
 * NOTES:
 * Teleport the bot to the duel arena.
 */
public class TeleportToDuelArena extends LeafTask {

    @Override
    public void execute() {
    	Location.DUEL_ARENA.teleport();
    	Execution.delayUntil(() -> Location.DUEL_ARENA.inArea(), 200, 500);
    }
}
 