package me.Ikeetjeop.hypixel.Listener.OnJoin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import me.Ikeetjeop.hypixel.utilities.Rank;
import me.Ikeetjeop.hypixel.utilities.playerData.UserDataHandler;

public class OnJoin implements Listener{
	
	Scoreboard s = Bukkit.getScoreboardManager().getMainScoreboard();

	@SuppressWarnings("deprecation")
	@EventHandler(priority=EventPriority.MONITOR)
	public void Onjoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		Rank ranks = Rank.getRank(p);
		UserDataHandler.createPlayer(p);
		
		
		if(Rank.getRank(p) == Rank.DEFAULT){
			p.setPlayerListName(ChatColor.GRAY + p.getName());
			p.setCustomNameVisible(true);
			registerNonTag(p);
			s.getTeam("Non").addPlayer(p.getPlayer());
		}else {
			registerRankTag(p);
			s.getTeam("Ranks").addPlayer(p.getPlayer());
			p.setPlayerListName(Rank.getRank(p).Color + ChatColor.translateAlternateColorCodes('&', Rank.getRank(p).Prefix.replace("{Mpluse}", UserDataHandler.getUserFile(p).getString("Pluse") + "&b").replace("{Vpluse}", "&6+&a")) + " " + p.getName());
		}
		
		
		if(ranks.piority == 100 || UserDataHandler.getUserFile(p).getBoolean("JoinAlert")){
			e.setJoinMessage(Rank.getRank(p).Color + Rank.getRank(p).Prefix.replace("{Mpluse}", ChatColor.RED + "+" + ChatColor.AQUA) + " " + p.getName() + ChatColor.GOLD + " joined the lobby!");
		} else {
			e.setJoinMessage(null);
		}
	}
	
	public void registerRankTag(Player p){
		if(s.getTeam("Ranks") != null){
			s.getTeam("ranks").unregister();
		}
		Team t = s.registerNewTeam("Ranks");
		t.setPrefix(Rank.getRank(p).Color + Rank.getRank(p).Prefix.replace("{Mpluse}", ChatColor.RED + "+" + ChatColor.AQUA) + " ");
		
	}
	public void registerNonTag(Player p){
		if(s.getTeam("Non") != null){
			s.getTeam("Non").unregister();
		}
		Team t = s.registerNewTeam("Non");
		t.setPrefix(ChatColor.GRAY + "");
		
	}

}
