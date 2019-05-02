package me.creepysin.playerutils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PlayerUtilsCommands implements CommandExecutor {

private Main plugin;
	
	public PlayerUtilsCommands(Main _main) {
		plugin = _main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("version")) {
				sender.sendMessage(ChatColor.GOLD + "You are running version " + ChatColor.YELLOW + plugin.getDescription().getVersion());
			}
			if(args[0].equalsIgnoreCase("about")) {
				aboutMsg(sender);
			}
		}
		else {
			aboutMsg(sender);
		}
		
		return true;
	}
	
	private void aboutMsg(CommandSender sender) {
		sender.sendMessage("----===== PlayerUtils =====----\nCreated by Creepysin\nVersion: " 
	    + plugin.getDescription().getVersion() + "\n\n§n" 
		+ ChatColor.BLUE + plugin.getDescription().getWebsite());
	}

}
