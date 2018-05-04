package net.thunderpvp.bots.fire_runner.leaves;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import com.runemate.game.api.hybrid.location.navigation.web.WebPath;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

import net.thunderpvp.bots.goldfarmer.Location;

public class RunToAltar extends LeafTask{

	Player player = Players.getLocal();
	GameObject ruins = GameObjects.newQuery().names("Mysterious ruins").results().first();

	final WebPath path = Traversal.getDefaultWeb().getPathBuilder().buildTo(new Coordinate(3309,3251, 0).randomize(2, 2));
//	private static boolean alreadyClicked = false;
	
	
	//Execution.delayUntil(() -> player != null && DUEL_ARENA.inArea(), () -> player.getAnimationId() != -1 ,600, 1800);

	
	@Override
	public void execute() {
		if(ruins != null && ruins.isVisible()) {
			ruins.click();
			Execution.delayWhile(() -> Location.FIREALTAR_OUTER.inArea(), 800, 1200);
		}
		else {
			if(ruins!=null) Camera.turnTo(ruins);
			if(path != null) path.step();
		}
	}
		
		
//		 Execution.delayUntil(() -> {
//            if (!player.isMoving() || player.distanceTo(path.getNext()) < 17.5D) {
//                path.step(true);
////                Execution.delayUntil(player::isMoving, 1500, 2500);
//            }
//
//            ruins = GameObjects.newQuery().names("Mysterious ruins").results().first();
//            if(ruins != null && ruins.isVisible()) ruins.click();
//            return Location.FIREALTAR_OUTER.inArea() || (ruins != null && ruins.isVisible());
//            
//        }, 8000, 12000);
//		
//		else System.out.println("NULL");
//		Execution.delayUntil(() -> !player.isMoving(), 1500, 2500);
//	}
		
}