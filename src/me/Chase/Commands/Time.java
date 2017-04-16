package me.Chase.Commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Chase.Main.Main;

public class Time implements CommandExecutor
{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("settime"))
		{
			if (!sender.hasPermission("LV.settime"))
			{
				sender.sendMessage(Main.color(Main.noperms + Main.admin));
				return true;
			}
			
			if (args.length == 0)
			{
				sender.sendMessage(Main.color(Main.time + "&eWhat should the time (in ticks) be in the world that you are in?"));
				return true;
			}
			
			if (args.length == 1)
			{
				if (args[0].equalsIgnoreCase("day"))
				{
					Player p = (Player) sender;
					World w = p.getLocation().getWorld();
					w.setTime(1000);
					p.sendMessage(Main.color(Main.time + "&aYou have set the time to " + args[0] + "!"));
					return true;
				}
				
				if (args[0].equalsIgnoreCase("night"))
				{
					Player p = (Player) sender;
					World w = p.getLocation().getWorld();
					w.setTime(13000);
					p.sendMessage(Main.color(Main.time + "&aYou have set the time to " + args[0] + "!"));
					return true;
				}
				
				if (args[0].equalsIgnoreCase("noon"))
				{
					Player p = (Player) sender;
					World w = p.getLocation().getWorld();
					w.setTime(6000);
					p.sendMessage(Main.color(Main.time + "&aYou have set the time to " + args[0] + "!"));
					return true;
				}
				
				if (args[0].equalsIgnoreCase("morning"))
				{
					Player p = (Player) sender;
					World w = p.getLocation().getWorld();
					w.setTime(22925);
					p.sendMessage(Main.color(Main.time + "&aYou have set the time to " + args[0] + "!"));
					return true;
				}
				
				if (args[0].equalsIgnoreCase("afternoon"))
				{
					Player p = (Player) sender;
					World w = p.getLocation().getWorld();
					w.setTime(10000);
					p.sendMessage(Main.color(Main.time + "&aYou have set the time to " + args[0] + "!"));
					return true;
				}
				
				Player p = (Player) sender;
				World w = p.getLocation().getWorld();
				w.setTime(Long.parseLong(args[0]));
				p.sendMessage(Main.color(Main.time + "&aYou have set the time to " + args[0] + "!"));
				return true;
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("time"))
		{
			Player p = (Player) sender;
			World w = p.getLocation().getWorld();
			
			sender.sendMessage(Main.color(Main.time + "&eRight now, it is &a" + checkTime(p) + ", " + w.getTime() + " &ein server ticks!"));
			return true;
		}
		return true;
	}
	
	public static String checkTime(Player p)
	{
		World w = p.getLocation().getWorld();
		long l = w.getTime();
		
		if (l >= 6000 && l <= 7500) 
			return "noon";
		if (l >= 7501 && l <= 12999)
			return "afternoon";
		if (l >= 13000 && l <= 17999)
			return "night";
		if (l >= 18000 && l <= 22924)
			return "midnight";
		if (l >= 22925 && l <= 24000)
			return "morning";
		if (l >= 0 && l <= 5999)
			return "morning";
		return null;
	}
}
