package me.Chase.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Invsee implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		
		if(commandLabel.equalsIgnoreCase("invsee"))
		{
			if(sender.hasPermission("LV.invsee"))
			{
				//TODO
			}
		}
		return true;
	}
}
