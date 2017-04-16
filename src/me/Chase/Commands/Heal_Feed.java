package me.Chase.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Chase.Main.Main;

public class Heal_Feed implements CommandExecutor
{
	
	String prefix = Main.health;
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("heal"))
		{
			if (!sender.hasPermission("LV.heal"))
			{
				//TODO Modify later????
				sender.sendMessage(Main.color(Main.noperms + Main.admin));
				return true;
			}
			
			Player p = (Player) sender;
			if (args.length == 0)
			{
				p.setHealth(20);
				p.setFoodLevel(20);
				p.playSound(p.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1, 1);
				p.sendMessage(prefix +  "HEALED!");
				return true;
			}

			if (args.length == 1)
			{
				Player target = Bukkit.getServer().getPlayer(args[0]);
					if (target == null)
					{
						p.sendMessage(prefix + "That player isn't on the server!");
						return true;
					}
					if (target.getName().equalsIgnoreCase(args[0]))
					{
						if (target.getHealth() == 20D)
						{
							p.sendMessage(prefix + target.getName() + " is already at full health!");
						}
						else
						{
							target.setHealth(20);
							target.setFoodLevel(20);
							target.playSound(target.getLocation(), Sound.BLOCK_LEVER_CLICK, 10, 1);
							target.sendMessage(prefix + p.getName() + " healed you!");
							p.sendMessage(prefix + args[0] + " has been healed!");
							return true;
						}

					}
				}
			}
		
		if (cmd.getName().equalsIgnoreCase("feed"))
		{
			if (!sender.hasPermission("LV.feed"))
			{
				//TODO Modify later????
				sender.sendMessage(Main.color(Main.noperms + Main.admin));
				return true;
			}
			
			Player p = (Player) sender;
			if (args.length == 0)
			{
				p.setFoodLevel(20);
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_BURP, 1, 1);
				p.sendMessage(prefix + "HUNGER REPLENISHED!");
				return true;
			}

			if (args.length == 1)
			{
				Player target = Bukkit.getServer().getPlayer(args[0]);
					if (target == null)
					{
						p.sendMessage(prefix + "That player isn't on the server!");
						return true;
					}
					if (target.getName().equalsIgnoreCase(args[0]))
					{
						if (target.getFoodLevel() == 20D) p.sendMessage(prefix + target.getName() + " is full!");
						else
						{
							target.setFoodLevel(20);
							target.playSound(target.getLocation(), Sound.ENTITY_PLAYER_BURP, 10, 1);
							target.sendMessage(prefix + p.getName() + " fed you!");
							p.playSound(p.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1, 1);
							p.sendMessage(prefix + args[0] + " has been fed!");
							return true;
						}
					}
				}
			}
		return true;
	}
}
