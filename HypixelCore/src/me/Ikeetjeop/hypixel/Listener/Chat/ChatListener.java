package me.Ikeetjeop.hypixel.Listener.Chat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import me.Ikeetjeop.hypixel.HypixelCore;
import me.Ikeetjeop.hypixel.configManagement.RankConfig;
import me.Ikeetjeop.hypixel.utilities.Rank;
@SuppressWarnings("deprecation")
public class ChatListener implements Listener{
	private HypixelCore Main;
	public ChatListener(HypixelCore Main){
		this.Main = Main;
	}

	private RankConfig RankConfig;

	@EventHandler
	public void OnChat(PlayerChatEvent e){
		Player p = e.getPlayer();
		this.RankConfig = new RankConfig(Main);
		e.setFormat(ChatColor.translateAlternateColorCodes('&', RankConfig.GetString("Hypixel.Ranks." + Rank.getRank(p) + ".Chat").replace("{username}", p.getName())) + e.getMessage().replace("%", "%%"));
	}

}
