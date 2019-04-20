package me.creepysin.playerutils;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UUIDCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 1) {
			@SuppressWarnings("deprecation")
			OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
			if(op.hasPlayedBefore()) {
				UUID uuid = op.getUniqueId();
				sender.sendMessage(ChatColor.GOLD + "The uuid of " + op.getName() + " is:\n" + uuid);
			}
			else {
				sender.sendMessage(ChatColor.RED + "That player hasn't played before!");
			}
		}
		else {
			sender.sendMessage(ChatColor.RED + "Too many or too little args!");
		}
		
		return true;
	}

}
