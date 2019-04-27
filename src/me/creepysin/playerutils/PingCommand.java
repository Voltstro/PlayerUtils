package me.creepysin.playerutils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {

	private Main plugin;
	
	public PingCommand(Main _main) {
		plugin = _main;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// If there is an arg then use that as the player
		if(args.length == 1) {
		
			@SuppressWarnings("deprecation")
			Player target = plugin.getServer().getPlayerExact(args[0]);
			if(!target.isOnline()) {
				sender.sendMessage(ChatColor.RED + "That player is not online!");
			}
			else {
				sender.sendMessage(ChatColor.GOLD + target.getName() + "'s ping is: " + getPing(target));
			}
		}
		else {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "You are not a player! You need to input a player name.");
			}
			else {
				Player target = (Player) sender;
				
				target.sendMessage(ChatColor.GOLD + "Your ping is: " + getPing(target));
			}
		}
		
		return true;
	}
	
	
	public int getPing(Player player) {
	    return ((CraftPlayer) player).getHandle().ping;
	}

}
