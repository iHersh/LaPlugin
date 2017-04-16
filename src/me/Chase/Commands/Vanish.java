package me.Chase.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Chase.Main.Main;

public class Vanish implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		
		if(commandLabel.equalsIgnoreCase("vanish") || commandLabel.equalsIgnoreCase("v"))
		{
			if(sender.hasPermission("LV.vanish"))
			{
				Player p = (Player) sender;
				if(!Main.vanish.contains(p))
				{
					Main.vanish.add(p);
					Main.vanish(p);
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "nte player " + p.getName() + " prefix &6");
					sender.sendMessage(Main.color("&9[Staff] &7You have vanished!"));
					return true;
				}
				else
				{
					Main.vanish.remove(p);
					Main.vanish(p);
					sender.sendMessage(Main.color("&9[Staff] &7You have been revealed."));
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "nte player " + p.getName() + " clear");
					return true;
				}
			}
			else
			{
				sender.sendMessage(Main.color(Main.noperms + Main.mod));
			}
		}
		return true;
	}
}
