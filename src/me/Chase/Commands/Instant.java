package me.Chase.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Chase.Main.Main;

public class Instant implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		if(commandLabel.equalsIgnoreCase("instant"))
		{
			if(sender.hasPermission("LV.instant"))
			{
				if(!Main.instant.contains((Player) sender))
				{
					Main.instant.add((Player) sender);
					sender.sendMessage(Main.color("&9[Perks] &7Instant mode activated."));
					sender.sendMessage(Main.color("&9[Perks] &eNote: You will not recieve blocks you break while in instant mode."));
					sender.sendMessage(Main.color("&9[Perks] &c&l&nWARNING: VERY FAST"));
					return true;
				}
				else
				{
					Main.instant.remove((Player) sender);
					sender.sendMessage(Main.color("&9[Perks] &7Instant mode deactivated."));
					return true;
				}
			}
			else
			{
				sender.sendMessage(Main.color(Main.noperms + Main.vipplus));
				return true;
			}
		}
		return true;
	}

}
