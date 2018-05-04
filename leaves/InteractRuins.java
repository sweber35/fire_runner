package net.thunderpvp.bots.fire_runner.leaves;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

import net.thunderpvp.bots.goldfarmer.Constants;

public class InteractRuins extends LeafTask	{

	@Override
	public void execute() {
		GameObject ruins = GameObjects.newQuery().on(Constants.fireAltarRuins).names("Mysterious ruins").actions("Enter").results().first();
    	if(ruins != null) {
			if(ruins.isVisible()) {
    			if(ruins.interact("Enter")) {
    				Execution.delayUntil(() -> (Players.getLocal().getAnimationId() == -1), 200, 500);
    			}
    			else System.out.println("SHIT");
			}
			else {
				Camera.turnTo(ruins);
			}
		}
	}
}
