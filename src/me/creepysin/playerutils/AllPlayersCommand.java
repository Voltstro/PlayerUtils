package me.creepysin.playerutils;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AllPlayersCommand implements CommandExecutor {

	private Main plugin;
	
	public AllPlayersCommand(Main _main) {
		plugin = _main;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		
		String allPlayers = "";
		
		// Get all the players and add them to the string
		for(OfflinePlayer p : plugin.getServer().getOfflinePlayers()) {
			if(p.hasPlayedBefore()) {
				allPlayers += p.getName() + "\n";
			}
		}
		
		player.sendMessage(ChatColor.GOLD + "Here is a list of all players:\n======================\n" + ChatColor.WHITE + allPlayers);
		return true;
	}

}
