package net.thunderpvp.bots.fire_runner.branches;

import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import net.thunderpvp.bots.fire_runner.leaves.InteractRuins;
import net.thunderpvp.bots.goldfarmer.Location;


/**
 * NOTES:
 * Checks if the bot is at the fire alter.
 */
public class AtFireAltarOuter extends BranchTask {

	
    private InteractRuins interactRuins = new InteractRuins();
    private InDuelArena inDuelArena = new InDuelArena();
    

    @Override
    public boolean validate() {
//		System.out.println("Outer:" + Location.FIREALTAR_INNER.inArea());
    	return Location.FIREALTAR_OUTER.inArea();
    }

    @Override
    public TreeTask failureTask() {
//    	System.out.println("[AT FIRE ALTAR OUTER] false");
        return inDuelArena;
    }

    @Override
    public TreeTask successTask() {
        return interactRuins;
    }
}
