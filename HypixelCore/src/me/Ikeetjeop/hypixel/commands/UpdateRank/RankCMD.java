package me.Ikeetjeop.hypixel.commands.UpdateRank;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Ikeetjeop.hypixel.JavaShit.Rank;
import me.Ikeetjeop.hypixel.JavaShit.Text;
import me.Ikeetjeop.hypixel.JavaShit.Text.text;

public class RankCMD implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("rank")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				Rank ranks = Rank.getRank(p);
				if(ranks.piority >= 190){
					if(args.length == 0){
						Text.message(p, text.sendMessage, ChatColor.STRIKETHROUGH + "-------------------");
						Text.message(p, text.sendMessage, "/rank set <Rank> <Player>");
						Text.message(p, text.sendMessage, "/rank update <Rank> <Player>");
						Text.message(p, text.sendMessage, "/rank fake <Rank> <Player>");
						Text.message(p, text.sendMessage, "/rank list");
						Text.message(p, text.sendMessage, ChatColor.STRIKETHROUGH + "-------------------");
					}else if(args.length == 1){
						if(args[0].equalsIgnoreCase("set")){
							Text.message(p, text.incorrect, "/rank set <Rank>");
						}
					}else if(args.length == 2){
						if(args[0].equalsIgnoreCase("set")){
							Rank.setRank(p, Rank.valueOf(args[1].toUpperCase()));
							Text.message(p, text.Alert, "Your rank has been set!");
						}
					}else if(args.length == 3){
						Player target = Bukkit.getPlayer(args[2]);
						if(target == null){
							Text.message(p, text.sendMessage,"OFFLINE PLAYER:" + args[2]);
						}else{
							try{
								Rank.setRank(target, Rank.valueOf(args[1].toUpperCase()));
								Text.message(sender, text.Alert, target.getName() + " is now rank: " + args[1]);
							}catch (IllegalArgumentException e) {
								Text.message(p, text.sendMessage ,"UNKNOW RANK");
							}
						}
					}
				} else {
					Text.message(p, text.Noaccess);
				}
			} else {
				if(args.length == 0){
					Text.message(sender, text.sendMessage, ChatColor.STRIKETHROUGH + "-------------------");
					Text.message(sender, text.sendMessage, "/rank set <Rank> <Player>");
					Text.message(sender, text.sendMessage, "/rank update <Rank> <Player>");
					Text.message(sender, text.sendMessage, "/rank fake <Rank> <Player>");
					Text.message(sender, text.sendMessage, "/rank list");
					Text.message(sender, text.sendMessage, ChatColor.STRIKETHROUGH + "-------------------");
				}else if(args.length == 1){
					if(args[0].equalsIgnoreCase("set")){
						Text.message(sender, text.incorrect, "/rank set <Rank> <player>");
					}
				}else if(args.length == 2){
					Text.message(sender, text.incorrect, "/rank set " + args[1] + " <player>");
				}else if(args.length == 3){
					Player target = Bukkit.getPlayer(args[2]);
					if(target == null){
						sender.sendMessage("OFFLINE PLAYER:" + args[2] + " MISSING RANK: " + args[1]);
					}else{
						try{
							Rank.setRank(target, Rank.valueOf(args[1].toUpperCase()));
							Text.message(sender, text.Alert, target.getName() + " is now rank: " + args[1]);
						}catch (IllegalArgumentException e) {
							sender.sendMessage("UNKNOW RANK");
						}
					}
				}
			}
		}
		return false;
	}

}
