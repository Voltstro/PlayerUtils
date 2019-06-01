package me.creepysin.playerutils.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.creepysin.playerutils.Main;

public class PlayersCommand implements CommandExecutor {

	private Main plugin;
	
	public PlayersCommand(Main _main) {
		plugin = _main;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		String onlinePlayers = "";
		
		// Get all the online players and add them to the string
		for(Player p : plugin.getServer().getOnlinePlayers()) {
			onlinePlayers += p.getDisplayName() + "\n";
		}
		
		sender.sendMessage(ChatColor.GOLD + "Here is a list of all current online players:\n======================\n" + ChatColor.WHITE + onlinePlayers);
		
		return true;
	}

}
