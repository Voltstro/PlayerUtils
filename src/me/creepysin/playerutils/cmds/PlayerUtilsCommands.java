package me.creepysin.playerutils.cmds;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import me.creepysin.playerutils.Main;

public class PlayerUtilsCommands implements CommandExecutor, TabCompleter {

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
	
	public List<String> onTabComplete (CommandSender sender, Command cmd, String label, String[] args) {
		List<String> subCmds = new ArrayList<String>();
		
		subCmds.add("version");
		subCmds.add("about");
		
		return subCmds;
	}
	
	private void aboutMsg(CommandSender sender) {
		sender.sendMessage("----===== PlayerUtils =====----\nCreated by Creepysin\nVersion: " 
	    + plugin.getDescription().getVersion() + "\n\n§n" 
		+ ChatColor.BLUE + plugin.getDescription().getWebsite());
	}

}
