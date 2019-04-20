package me.creepysin.playerutils;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public void onEnable() {
		getCommand("players").setExecutor(new PlayersCommand(this));
		getCommand("allplayers").setExecutor(new AllPlayersCommand(this));
		getCommand("ping").setExecutor(new PingCommand(this));
		getCommand("uuid").setExecutor(new UUIDCommand());
		
		getLogger().info("PlayerUtils enabled!");
	}

}
