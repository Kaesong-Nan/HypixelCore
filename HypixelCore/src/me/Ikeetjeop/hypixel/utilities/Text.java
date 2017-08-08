package me.Ikeetjeop.hypixel.utilities;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import me.Ikeetjeop.hypixel.HypixelCore;

public class Text {
	public static enum text{
		Noaccess, RankAccess, PlayerOffline, Alert, sendMessage, incorrect
	}
	public static void message(CommandSender p, Enum<text> type, String rank){
		if(type.equals(text.RankAccess)){
			p.sendMessage(ChatColor.RED + "You must be " + rank + ChatColor.RED + " to use this.");
		}
		if(type.equals(text.Alert)){
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', HypixelCore.getInstance().getConfig().getString("Hypixel.Messages.Server.Prefix")) + " " + rank);
		}
		if(type.equals(text.sendMessage)){
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.GOLD + rank));
		}
		if(type.equals(text.incorrect)){
			p.sendMessage(ChatColor.RED + "Missing arguments! Usage: " + rank);
		}
		
	}
	public static void message(CommandSender p, Enum<text> type){
		if(type.equals(text.Noaccess)){
			p.sendMessage(ChatColor.RED + "You must be admin or higher to use this command!");
		}
	}

}
