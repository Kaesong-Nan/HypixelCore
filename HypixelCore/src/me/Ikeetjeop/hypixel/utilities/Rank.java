package me.Ikeetjeop.hypixel.utilities;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.Ikeetjeop.hypixel.utilities.playerData.UserDataHandler;

public enum Rank
{
	//STAFF
	OWNER("Owner", "[OWNER]", 200, ChatColor.RED),
	ADMIN("Admin", "[ADMIN]", 190, ChatColor.RED),
	MODERATOR("Mod", "[MOD]", 180, ChatColor.GREEN),
	HELPER("Helper", "[HELPER]", 170, ChatColor.BLUE),
	BUILDTEAM("Build team", "[BUILD TEAM]", 160, ChatColor.DARK_GREEN),
	//unless ranks
	SLOTH("Sloth", "[SLOTH]", 150, ChatColor.RED),
	APPLE("Apple", "[APPLE]", 140, ChatColor.GOLD),
	BEAM("Beam", "[BEAM]", 130, ChatColor.DARK_GREEN),
	//Jobs
	MOJANG("Mojang", "[MOJANG]", 120, ChatColor.GOLD),
	YT("YT", "[YT]", 110, ChatColor.GOLD),
	//DODODODODONATORRSS //0 - 100 Donators
	MVPP("MVP+", "[MVP{Mpluse}]", 100, ChatColor.AQUA),
	MVP("Mvp", "[MVP]", 80, ChatColor.AQUA),
	VIPP("Vip+", "[VIP{Vpluse}]", 60, ChatColor.GREEN),
	VIP("Vip", "[VIP]", 40,ChatColor.GREEN),
	DEFAULT("Default", "", 20, ChatColor.GRAY);

	public String name;
	public String prefix;
	public int piority;
	public ChatColor color;

	private Rank(String name, String prefix, int piority, ChatColor color)
	{
		this.name = name;
		this.prefix = prefix;
		this.piority = piority;
		this.color = color;
	}

	public String GetName() {
		return this.name;
	}
	public String GetPrefix() {
		return this.prefix;
	}
	public ChatColor getColor() {
		return this.color;
	}

	public static Rank getRank(Player player) {
		String val = UserDataHandler.getUserFile(player).getString("Rank");
		return (val == null ? Rank.DEFAULT : Rank.valueOf(val));
	}

	public static boolean hasRank(Player player, Rank rank) {
		return (Rank.getRank(player).compareTo(rank) <= 0);
	}

	public static void setRank(Player player, Rank rank) {
		UserDataHandler.setdata(player, "Rank", rank.toString());
		System.out.println("[Debug] Player: " + player.getName() + " has now rank: " + rank.GetName());
	}
	public int getPiority() {
		return piority;
	}
	public void setPiority(int piority) {
		this.piority = piority;
	}
}