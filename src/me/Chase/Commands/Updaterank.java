package me.Chase.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.Chase.Main.Main;

public class Updaterank implements CommandExecutor
{
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		if(commandLabel.equalsIgnoreCase("updaterank"))
		{
			if(sender.hasPermission("LV.updaterank"))
			{
				//TODO: Manually update every time there's a new rank
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + args[0] + " group set " + args[1]);
				
				if(args[1].equalsIgnoreCase("Default")) Bukkit.getPlayer(args[0]).sendMessage(Main.color("&9[Ranks] &7You've recieved rank: Default"));
				else if(args[1].equalsIgnoreCase("VIP")) Bukkit.getPlayer(args[0]).sendMessage(Main.color("&9[Ranks] &7You've recieved rank: &5&lVIP"));
				else if(args[1].equalsIgnoreCase("VIP+")) Bukkit.getPlayer(args[0]).sendMessage(Main.color("&9[Ranks] &7You've recieved rank: &5&lVIP+"));
				else if(args[1].equalsIgnoreCase("Premium")) Bukkit.getPlayer(args[0]).sendMessage(Main.color("&9[Ranks] &7You've recieved rank: &9&lPREMIUM"));
				else if(args[1].equalsIgnoreCase("Mod")) Bukkit.getPlayer(args[0]).sendMessage(Main.color("&9[Ranks] &7You've recieved rank: &6&lMOD"));
				else if(args[1].equalsIgnoreCase("Admin")) Bukkit.getPlayer(args[0]).sendMessage(Main.color("&9[Ranks] &7You've recieved rank: &c&lADMIN"));
				else if(args[1].equalsIgnoreCase("Owner")) Bukkit.getPlayer(args[0]).sendMessage(Main.color("&9[Ranks] &7You've recieved rank: &4&lOWNER"));
				
				if(args[1].equalsIgnoreCase("Default")) sender.sendMessage(Main.color("&9[Ranks] &7You've given " + args[0] + " rank: Default"));
				else if(args[1].equalsIgnoreCase("VIP")) sender.sendMessage(Main.color("&9[Ranks] &7You've given " + args[0] + " rank: &5&lVIP"));
				else if(args[1].equalsIgnoreCase("VIP+")) sender.sendMessage(Main.color("&9[Ranks] &7You've given " + args[0] + " rank: &5&lVIP+"));
				else if(args[1].equalsIgnoreCase("Premium")) sender.sendMessage(Main.color("&9[Ranks] &7You've given " + args[0] + " rank: &9&lPREMIUM"));
				else if(args[1].equalsIgnoreCase("Mod")) sender.sendMessage(Main.color("&9[Ranks] &7You've given " + args[0] + " rank: &6&lMOD"));
				else if(args[1].equalsIgnoreCase("Admin")) sender.sendMessage(Main.color("&9[Ranks] &7You've given " + args[0] + " rank: &c&lADMIN"));
				else if(args[1].equalsIgnoreCase("Owner")) sender.sendMessage(Main.color("&9[Ranks] &7You've given " + args[0] + " rank: &4&lOWNER"));
				
				return true;
			}
			else
			{
				sender.sendMessage(Main.color(Main.noperms + Main.owner));
				return true;
			}
		}
		return true;
	}
}
