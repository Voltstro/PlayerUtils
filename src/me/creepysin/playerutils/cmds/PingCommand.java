package me.creepysin.playerutils.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import me.creepysin.playerutils.Main;

public class PingCommand implements CommandExecutor {

	private Main plugin;
	
	public PingCommand(Main _main) {
		plugin = _main;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// If there is an arg then use that as the player
		if(args.length == 1) {
		
			if((sender instanceof Player)) { // If it is a player looking at another players ping check to see if they have the permission playerutils.ping.others
				Player excute = (Player) sender;
				if(!excute.hasPermission("playerutils.ping.others")) {
					excute.sendMessage(ChatColor.RED + "You do not have access to see other players ping!");
					return true;
				}
			}
			
			Player target = plugin.getServer().getPlayer(args[0]);
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
