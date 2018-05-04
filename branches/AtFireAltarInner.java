package net.thunderpvp.bots.fire_runner.branches;

import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import net.thunderpvp.bots.goldfarmer.Location;

public class AtFireAltarInner extends BranchTask{

	
    private HasAlreadyCraftedRunes hasAlreadyCraftedRunes = new HasAlreadyCraftedRunes();
    private AtFireAltarOuter atFireAltarOuter = new AtFireAltarOuter();
	
	@Override
	public boolean validate() {
//		System.out.println("Inner:" + Location.FIREALTAR_INNER.inArea());
		return Location.FIREALTAR_INNER.inArea();
	}
	
	@Override
	public TreeTask failureTask() {
		return atFireAltarOuter;
	}

	@Override
	public TreeTask successTask() {
		return hasAlreadyCraftedRunes;
	}

}
