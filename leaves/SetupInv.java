package net.thunderpvp.bots.fire_runner.leaves;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

import net.thunderpvp.bots.goldfarmer.BankUtil;
import net.thunderpvp.bots.goldfarmer.BankWithdrawal;

/**
 * NOTES: Make this bot retrieve the appropriate equipment from its bank.
 */
public class SetupInv extends LeafTask {

	boolean open = Bank.isOpen();
	
	public final String[] wanted = { "Stamina potion(1)", "Stamina potion(2)", "Stamina potion(3)", "Stamina potion(4)", "Pure essence" };

	@Override
	public void execute() {

		BankUtil.open();
		Bank.depositInventory();
		BankUtil.ensureWithdrawals(new BankWithdrawal(7936, -1));
		Execution.delayUntil(() -> Bank.close(), 200, 500);
	
	}
}
