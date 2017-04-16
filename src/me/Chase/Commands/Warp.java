package me.Chase.Commands;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Chase.Main.Main;
import me.Chase.Main.Tp;

public class Warp implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("setwarp"))
		{
			if (!(sender instanceof Player)) {
				sender.sendMessage(Main.warp + ChatColor.RED + "You are not a player!");
				return true;
			}
			
			Player p = (Player) sender;
			
			if (!p.hasPermission("LV.warp.modify"))
			{
				p.sendMessage(Main.noperms + Main.admin);
				return true;
			}
			if (args.length == 0)
			{
				p.sendMessage(Main.warp + "Syntax: /setwarp <name>");
				return true;
			}

			if (args.length == 1)
			{
				Tp.setupWarp(p, args[0]);
				p.sendMessage(Main.warp + ChatColor.GREEN + "Successfully created warp!");
				return true;
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("delwarp"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(Main.warp + ChatColor.RED + "You are not a player!");
				return true;
			}
			
			Player p = (Player) sender;
			
			if (!p.hasPermission("LV.warp.modify"))
			{
				p.sendMessage(
						Main.warp + ChatColor.RED + "You dont have permission to delete a warp.");
				return true;
			}
			if (args.length == 0)
			{
				p.sendMessage(Main.warp + ChatColor.RED + "What is the name of the warp?");
				return true;
			}

			if (args.length == 1)
			{
				if (!Tp.isAWarp(args[0]))
				{
					p.sendMessage(Main.warp + ChatColor.RED + "This warp does not exist!");
					return true;
				}
				
				Tp.deleteWarp(args[0]);
				p.sendMessage(Main.warp + ChatColor.GREEN + "Successfully deleted warp!");
				return true;
			}
		}

		if (cmd.getName().equalsIgnoreCase("warp"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(Main.warp + ChatColor.RED + "You are not a player!");
				return true;
			}
			
			Player p = (Player) sender;

			if (args.length == 0)
			{
				p.sendMessage(Main.warp + ChatColor.RED + "Arguments are: /warp <name : list>");
				return true;
			}
			if (args.length == 1)
			{
				if (args[0].equalsIgnoreCase("list"))
				{
					File f1 = Tp.getFolder();
					String[] names = f1.list();
					StringBuilder sb = new StringBuilder();
	                for(int i = 0; i < names.length; i++)
	                {
	                    sb.append(names[i]).append(" ");
	                }
	                String msg = sb.toString().trim();
	                p.sendMessage(Main.warp + ChatColor.YELLOW + "Warps: " + ChatColor.GREEN + msg.replace(".yml", ","));
					return true;
				}
				
				if (!Tp.getYaml(args[0]).contains(args[0]))
				{
					p.sendMessage(Main.warp + ChatColor.RED + "Warp doesnt exist");
					return true;
				}

				p.sendMessage(Main.warp + ChatColor.GREEN + "Warp successful");
				p.teleport(new Location(Bukkit.getWorld(Tp.getYaml(args[0]).getString(args[0] + ".world")),
						Tp.getYaml(args[0]).getDouble(args[0] + ".xPos"), Tp.getYaml(args[0]).getDouble(args[0] + ".yPos"),
						Tp.getYaml(args[0]).getDouble(args[0] + ".zPos")));
			}
		}
		return true;
	}
}
