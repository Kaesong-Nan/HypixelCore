package me.Ikeetjeop.hypixel.Listener.OnJoin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.Ikeetjeop.hypixel.HypixelCore;
import me.Ikeetjeop.hypixel.utilities.Rank;
import me.Ikeetjeop.hypixel.utilities.playerData.UserDataHandler;

public class OnJoin implements Listener{

	@SuppressWarnings("deprecation")
	@EventHandler(priority=EventPriority.MONITOR)
	public void Onjoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		Rank ranks = Rank.getRank(p);
		UserDataHandler.createPlayer(p);


		if(Rank.getRank(p) == Rank.DEFAULT){
			try{
				HypixelCore.getInstance().s.registerNewTeam("Non").setPrefix(ChatColor.GRAY + " ");
				HypixelCore.getInstance().s.registerNewTeam("Non").addPlayer(p.getPlayer());
				p.setPlayerListName(ChatColor.GRAY + p.getName());
			}catch (IllegalArgumentException a) {
				HypixelCore.getInstance().s.getTeam("Non").setPrefix(ChatColor.GRAY + "");
				HypixelCore.getInstance().s.getTeam("Non").addPlayer(p.getPlayer());
			}
		}else{
			try{
				HypixelCore.getInstance().s.registerNewTeam("Ranks").setPrefix(Rank.getRank(p).color + Rank.getRank(p).prefix.replace("{Mpluse}", ChatColor.RED + "+" + ChatColor.AQUA) + " ");
				HypixelCore.getInstance().s.registerNewTeam("Ranks").addPlayer(p.getPlayer());
				p.setPlayerListName(Rank.getRank(p).color + ChatColor.translateAlternateColorCodes('&', Rank.getRank(p).prefix.replace("{Mpluse}", UserDataHandler.getUserFile(p).getString("Pluse") + "&b").replace("{Vpluse}", "&6+&a")) + " " + p.getName());
			}catch (IllegalArgumentException a) {
				HypixelCore.getInstance().s.getTeam("Ranks").setPrefix(Rank.getRank(p).color + Rank.getRank(p).prefix.replace("{Mpluse}", ChatColor.RED + "+" + ChatColor.AQUA) + " ");
				HypixelCore.getInstance().s.getTeam("Ranks").addPlayer(p.getPlayer());
			}
		}

		if(ranks.piority == 100 || UserDataHandler.getUserFile(p).getBoolean("JoinAlert")){

			e.setJoinMessage(Rank.getRank(p).color + Rank.getRank(p).prefix.replace("{Mpluse}", ChatColor.RED + "+" + ChatColor.AQUA) + " " + p.getName() + ChatColor.GOLD + " joined the lobby!");
		} else {
			e.setJoinMessage(null);
		}
	}
}
