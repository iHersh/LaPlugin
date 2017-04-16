package me.Chase.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Chase.Main.Main;

public class Fly implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		
		if(commandLabel.equalsIgnoreCase("fly"))
		{
			if(args.length == 0)
			{
				if(sender.hasPermission("LV.fly"))
				{
					Player p = (Player) sender;
					if(!p.getAllowFlight())
					{
						p.setAllowFlight(true);
						p.sendMessage(Main.color("&9[Perks] &7You have enabled flight."));
						return true;
					}
					else
					{
						p.setAllowFlight(false);
						p.sendMessage(Main.color("&9[Perks] &7You have disabled flight."));
						return true;
					}
				}
				else
				{
					sender.sendMessage(Main.color(Main.noperms + Main.premium));
					return true;
				}
			}
			else if(args.length == 1)
			{
				if(sender.hasPermission("LV.fly.others"))
				{
					if(Bukkit.getOfflinePlayer(args[0]).isOnline())
					{
						Player p = Bukkit.getPlayer(args[0]);
						if(!p.getAllowFlight())
						{
							p.setAllowFlight(true);
							p.sendMessage(Main.color("&9[Perks] &7Flight has been enabled."));
							sender.sendMessage(Main.color("&9[Perks] &7Enabled flight for &e" + p.getName()));
							return true;
						}
						else
						{
							p.setAllowFlight(false);
							p.sendMessage(Main.color("&9[Perks] &7Flight has been disabled."));
							sender.sendMessage(Main.color("&9[Perks] &7Disabled flight for &e" + p.getName()));
							return true;
						}
					}
					else
					{
						sender.sendMessage(Main.color("&9[Perks] &7The requested user is not online!"));
						return true;
					}
				}
				else
				{
					sender.sendMessage(Main.color(Main.noperms + Main.mod));
					return true;
				}
			}
			else
			{
				if(sender.hasPermission("LV.fly") && !sender.hasPermission("LV.fly.others"))
				{
					sender.sendMessage(Main.color("&9[Perks] &7Syntax: /fly"));
				}
				else if(sender.hasPermission("LV.fly.others"))
				{
					sender.sendMessage(Main.color("&9[Perks] &7Syntax: /fly or /fly <player>"));
				}
				else if(!sender.hasPermission("LV.fly"))
				{
					sender.sendMessage(Main.color(Main.noperms + Main.premium));
					return true;
				}
			}
		}
		return true;
	}
}
