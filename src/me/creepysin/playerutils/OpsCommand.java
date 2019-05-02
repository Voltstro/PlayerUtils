package me.creepysin.playerutils;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class OpsCommand implements CommandExecutor {

private Main plugin;
	
	public OpsCommand(Main _main) {
		plugin = _main;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		String operators = "";
		
		// Get all the operators
		for(OfflinePlayer p : plugin.getServer().getOperators()) {
			if(p.hasPlayedBefore()) {
				
				String offline = ChatColor.WHITE + "[" + ChatColor.DARK_RED + "Offline" + ChatColor.WHITE + "] ";
				
				if(p.isOnline()) {
					offline = ChatColor.WHITE + "[" + ChatColor.GREEN + "Online" + ChatColor.WHITE + "] ";
				}
				
				operators += offline + p.getName() + "\n";
			}
		}
		
		sender.sendMessage(ChatColor.GOLD + "Here is a list of all ops:\n======================\n" + ChatColor.WHITE + operators);
		
		return true;
	}

}
