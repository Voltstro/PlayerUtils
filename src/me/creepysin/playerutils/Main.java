package me.creepysin.playerutils;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public void onEnable() {
		
		// Setup permissions
		Permission playersPerm = new Permission("playerutils.players");
		Permission allPlayersPerm = new Permission("playerutils.allplayers");
		Permission pingPerm = new Permission("playerutils.ping");
		Permission uuidPerm = new Permission("playerutils.uuid");
		Permission healthPerm = new Permission("playerutils.health");
		
		// Add permissions
		PluginManager pm = getServer().getPluginManager();
		pm.addPermission(playersPerm);
		pm.addPermission(allPlayersPerm);
		pm.addPermission(pingPerm);
		pm.addPermission(uuidPerm);
		pm.addPermission(healthPerm);
		
		// Add commands
		getCommand("players").setExecutor(new PlayersCommand(this));
		getCommand("allplayers").setExecutor(new AllPlayersCommand(this));
		getCommand("ping").setExecutor(new PingCommand(this));
		getCommand("uuid").setExecutor(new UUIDCommand());
		getCommand("health").setExecutor(new HealthCommand(this));		
		
		getLogger().info("PlayerUtils enabled!");
	}

}
