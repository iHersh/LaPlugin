package me.Chase.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Chase.Main.Main;

public class Fall implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		
		if(commandLabel.equalsIgnoreCase("fall"))
		{
			if(sender.hasPermission("LV.fall"))
			{
				if(!Main.fall.contains((Player) sender))
				{
					Main.fall.add((Player) sender);
					sender.sendMessage(Main.color("&9[Perks] &7You have disabled fall damage for yourself."));
					return true;
				}
				else
				{
					Main.fall.remove((Player) sender);
					sender.sendMessage(Main.color("&9[Perks] &7You have enabled fall damage for yourself."));
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
