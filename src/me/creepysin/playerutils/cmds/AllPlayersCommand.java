package me.creepysin.playerutils.cmds;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.creepysin.playerutils.Main;

public class AllPlayersCommand implements CommandExecutor {

	private Main plugin;
	
	public AllPlayersCommand(Main _main) {
		plugin = _main;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		String allPlayers = "";
		int playerCount = 0;
		
		// Get all the players and add them to the string
		for(OfflinePlayer p : plugin.getServer().getOfflinePlayers()) {
			if(p.hasPlayedBefore()) {
				
				String offline = ChatColor.WHITE + "[" + ChatColor.DARK_RED + "Offline" + ChatColor.WHITE + "] ";
				
				if(p.isOnline()) {
					offline = ChatColor.WHITE + "[" + ChatColor.GREEN + "Online" + ChatColor.WHITE + "] ";
				}
				
				allPlayers += offline + p.getName() + "\n";
				playerCount++;
			}
		}
		
		sender.sendMessage(ChatColor.GOLD + "So far " + ChatColor.YELLOW + playerCount + ChatColor.GOLD + " players have played! Here is a list of all the players:\n======================\n" + ChatColor.WHITE + allPlayers);
		return true;
	}
}
