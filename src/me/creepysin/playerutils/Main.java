package me.creepysin.playerutils;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import me.creepysin.playerutils.cmds.AllPlayersCommand;
import me.creepysin.playerutils.cmds.HealthCommand;
import me.creepysin.playerutils.cmds.OpsCommand;
import me.creepysin.playerutils.cmds.PingCommand;
import me.creepysin.playerutils.cmds.PlayerUtilsCommands;
import me.creepysin.playerutils.cmds.PlayersCommand;
import me.creepysin.playerutils.cmds.UUIDCommand;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		getCommand("playerutils").setExecutor(new PlayerUtilsCommands(this));
		getCommand("players").setExecutor(new PlayersCommand(this));
		getCommand("allplayers").setExecutor(new AllPlayersCommand(this));
		getCommand("ping").setExecutor(new PingCommand(this));
		getCommand("uuid").setExecutor(new UUIDCommand());
		getCommand("health").setExecutor(new HealthCommand(this));		
		getCommand("ops").setExecutor(new OpsCommand(this));
		
		getLogger().info(ChatColor.GREEN + "PlayerUtils is now enabled!");
	}

}
