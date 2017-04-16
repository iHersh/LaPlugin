package me.Chase.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Chase.Main.Main;
import me.Chase.Main.Kits;

public class KitsCmd implements CommandExecutor
{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("kit"))
		{
			if (args.length == 0)
			{
				sender.sendMessage(Main.color(Main.kits + "&cArguments are: /kit <starter : vip : vip+ : premium>"));
				return true;
			}
			
			Player p = (Player) sender;
			if (args.length == 1)
			{
				if (args[0].equalsIgnoreCase("starter"))
				{
					Kits.starter(p);
					return true;
				}
				
				if (args[0].equalsIgnoreCase("vip"))
				{
					if (!sender.hasPermission("LV.kits.vip"))
					{
						sender.sendMessage(Main.color(Main.noperms + Main.vip));
						return true;
					}
					
					Kits.vip(p);
					return true;
				}
				
				if (args[0].equalsIgnoreCase("vip+"))
				{
					if (!sender.hasPermission("LV.kits.vipplus"))
					{
						sender.sendMessage(Main.color(Main.noperms + Main.vipplus));
						return true;
					}
					
					Kits.vipplus(p);
					return true;
				}
				
				if (args[0].equalsIgnoreCase("premium"))
				{
					if (!sender.hasPermission("LV.kits.premium"))
					{
						sender.sendMessage(Main.color(Main.noperms + Main.premium));
						return true;
					}
					
					Kits.premium(p);
					return true;
				}
			}
		}
		return true;
	}
}
