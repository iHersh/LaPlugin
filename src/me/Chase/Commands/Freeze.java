package me.Chase.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Chase.Main.Main;

public class Freeze implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		if(commandLabel.equalsIgnoreCase("freeze"))
		{
			if(sender.hasPermission("LV.freeze"))
			{
				if(args.length == 1)
				{
					for(Player p : Bukkit.getOnlinePlayers())
					{
						if(Bukkit.getPlayer(args[0]) == p)
						{
							if(!Main.frozen.contains(p))
							{
								Main.frozen.add(p);
								p.teleport(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 0F, 0F));
								sender.sendMessage(Main.color("&9[Staff] &7You have frozen &e" + p.getName()));
								p.sendMessage(Main.color("&c&l&nYou have been frozen by " + sender.getName()));
								return true;
							}
							else
							{
								Main.frozen.remove(p);
								sender.sendMessage(Main.color("&9[Staff] &7You have thawed &e" + p.getName()));
								p.sendMessage(Main.color("&a&l&nYou have been thawed by " + sender.getName()));
								return true;
							}
						}
					}
				}
				else
				{
					sender.sendMessage(Main.color("&9[Staff] &eUsage: /freeze <player>"));
					return true;
				}
			}
			else
			{
				sender.sendMessage(Main.color(Main.noperms + Main.mod));
				return true;
			}
		}
		return true;
	}
}
