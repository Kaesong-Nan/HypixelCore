package me.Ikeetjeop.hypixel.commands.Fly;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Ikeetjeop.hypixel.utilities.Rank;
import me.Ikeetjeop.hypixel.utilities.Text;
import me.Ikeetjeop.hypixel.utilities.Text.text;

public class Flycmd implements CommandExecutor{

	/*
	 * @ikeetjeop
	 * TODO: vliegt gwn weer Zonder dubble spatie.
	 */


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("fly")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				Rank ranks = Rank.getRank(p);
				if(ranks.piority >= 40){
					if(args.length == 0){
						if(p.getAllowFlight() == false){
							p.setAllowFlight(true);
							p.setFlying(true);
							p.sendMessage(ChatColor.GREEN + "Turned on flight!");
						} else {
							p.setAllowFlight(false);
							p.setFlying(false);
							p.sendMessage(ChatColor.GREEN + "Turned off flight!");
						}
					}
					if(args.length == 1){
						if(ranks.piority >= 190){
							Player target = Bukkit.getPlayer(args[0]);
							if(target == null){
								p.sendMessage("You cannot turn fly on/off for offline players!");
							}
							if(target.getAllowFlight() == false){
								target.setAllowFlight(true);
								target.setFlying(true);
								target.sendMessage(ChatColor.GREEN + "Turned on flight!");
							} else {
								target.setAllowFlight(false);
								target.setFlying(false);
								target.sendMessage(ChatColor.GREEN + "Turned off flight!");
							}
						}
					} 
				}else {
					Text.message(p, text.RankAccess, Rank.valueOf("VIP").Color + Rank.valueOf("VIP").GetPrefix());
				}
			}
		}
		return false;
	}
}