package me.Chase.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Chase.Main.Main;

public class Weather implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{

		if(commandLabel.equalsIgnoreCase("weather"))
		{
			if(sender.hasPermission("LV.weather"))
			{
				if(args.length == 1)
				{
					if(args[0].equalsIgnoreCase("rain") || args[0].equalsIgnoreCase("storm"))
					{
						Player p = (Player) sender;
						p.getWorld().setStorm(true);
						p.getWorld().setThundering(true);
						p.sendMessage(Main.color("&9[Perks] &7You set the weather to rainy."));
						return true;
					}
					else if(args[0].equalsIgnoreCase("sun") || args[0].equalsIgnoreCase("sunny") || args[0].equalsIgnoreCase("clear"))
					{
						Player p = (Player) sender;
						p.getWorld().setStorm(false);
						p.getWorld().setThundering(false);
						p.sendMessage(Main.color("&9[Perks] &7You set the weather to clear."));
						return true;
					}
				}
				else
				{
					sender.sendMessage(Main.color("&9[Perks] &7Syntax: /weather <clear | storm>"));
					return true;
				}
			}
			else
			{
				sender.sendMessage(Main.color(Main.noperms + Main.premium));
				return true;
			}
		}
		return true;
	}
}
