package me.Ikeetjeop.hypixel.Listener.OnJoin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.Ikeetjeop.hypixel.utilities.Rank;

public class OnJoin implements Listener{
	
	@EventHandler
	public void Onjoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		Rank ranks = Rank.getRank(p);
		if(ranks.piority == 100){
			e.setJoinMessage(Rank.getRank(p).Color + Rank.getRank(p).Prefix.replace("{Mpluse}", ChatColor.RED + "+" + ChatColor.AQUA) + " " + p.getName() + ChatColor.GOLD + " joined the lobby!");
		} else {
			e.setJoinMessage("");
		}
	}

}
