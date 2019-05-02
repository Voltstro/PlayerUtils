package me.creepysin.playerutils;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		
		getCommand("playerutils").setExecutor(new PlayerUtilsCommands(this));
		getCommand("players").setExecutor(new PlayersCommand(this));
		getCommand("allplayers").setExecutor(new AllPlayersCommand(this));
		getCommand("ping").setExecutor(new PingCommand(this));
		getCommand("uuid").setExecutor(new UUIDCommand());
		getCommand("health").setExecutor(new HealthCommand(this));		
		getCommand("ops").setExecutor(new OpsCommand(this));
		
		getLogger().info("PlayerUtils enabled!");
	}

}
