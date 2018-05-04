package net.thunderpvp.bots.fire_runner.branches;

import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import net.thunderpvp.bots.fire_runner.leaves.RunToAltar;
import net.thunderpvp.bots.goldfarmer.Location;

/**
 * NOTES:
 * Is this bot already in the duel arena?
 */
public class InDuelArena extends BranchTask {

    private RunToAltar runToAltar = new RunToAltar();
    private InCastleWars inCastleWars = new InCastleWars();

    @Override
    public boolean validate() {
    	return Location.DUEL_ARENA.inArea();
    }

    @Override
    public TreeTask failureTask() {
        return inCastleWars;
    }

    @Override
    public TreeTask successTask() {
        return runToAltar;
    }
}
