package me.Ikeetjeop.hypixel.utilities.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
public class Mysqldata implements Listener{
	
	private static Mysqldata instance;
	public Mysqldata() {
		instance = this;
	}
	public static Mysqldata getInstance() {
		return instance;
	}
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player player = e.getPlayer();
		
		createPlayer(player.getUniqueId(), player);
	}
	
	
	
	public boolean playerExists(UUID uuid){
		try {
			PreparedStatement statement = MysqlInfo.getInstance().getConnection().prepareStatement("SELECT * FROM " + MysqlInfo.getInstance().table + "WHERE UUID=?");
			statement.setString(1, uuid.toString());
			
			ResultSet results = statement.executeQuery();
			if(results.next()){
				Bukkit.broadcastMessage(ChatColor.YELLOW + "Player found");
				return true;
			}
			Bukkit.broadcastMessage(ChatColor.YELLOW + "Player not found");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void createPlayer(final UUID uuid, Player player){
		try{
			PreparedStatement statement = MysqlInfo.getInstance().getConnection().prepareStatement("SELECT * FROM " + MysqlInfo.getInstance().table + " WHERE UUID=?");
			statement.setString(1, uuid.toString());
			ResultSet results = statement.executeQuery();
			results.next();
			if(playerExists(uuid) != true){
				PreparedStatement insert = MysqlInfo.getInstance().getConnection()
						.prepareStatement("INSERT INTO " + MysqlInfo.getInstance().table + "(UUID,NAME,COINS) VALUE (?,?,?)");
				insert.setString(1, uuid.toString());
				insert.setString(2, player.getName().toString());
				insert.setInt(3, 500);
				insert.executeUpdate();
				
				Bukkit.broadcastMessage(ChatColor.YELLOW + "Player INSETRTED");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
    public void createTable() {
        try {
 
            Statement statement = MysqlInfo.getInstance().getConnection().createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS (UUID varchar(32), NAME varchar(16), tokens INT(10))");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
