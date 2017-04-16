package me.Chase.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Chase.Main.Main;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Help implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(commandLabel.equalsIgnoreCase("help"))
		{
			//Bukkit.broadcastMessage(PermissionsEx.getUser((Player) sender).getPrefix() + "j");
			
			if(args.length == 0)
			{
				if(ChatColor.stripColor(PermissionsEx.getUser((Player) sender).getPrefix()).equalsIgnoreCase("")) 
					return Main.perks(sender, 1);
				if(ChatColor.stripColor(PermissionsEx.getUser((Player) sender).getPrefix()).equalsIgnoreCase("&5&lVIP&r ")) 
					return Main.perks(sender, 2);
				if(ChatColor.stripColor(PermissionsEx.getUser((Player) sender).getPrefix()).equalsIgnoreCase("&5&lVIP+&r ")) 
					return Main.perks(sender, 3);
				if(ChatColor.stripColor(PermissionsEx.getUser((Player) sender).getPrefix()).equalsIgnoreCase("&9&lPREMIUM&r ")) 
					return Main.perks(sender, 4);
				if(PermissionsEx.getUser((Player) sender).getPrefix().equalsIgnoreCase("&6&lMOD&f ")) 
					return Main.perks(sender, 5);
			}
			else
			{
				if(args[0].equalsIgnoreCase("Default")) return Main.perks(sender, 1);
				if(args[0].equalsIgnoreCase("VIP")) return Main.perks(sender, 2);
				if(args[0].equalsIgnoreCase("VIP+")) return Main.perks(sender, 3);
				if(args[0].equalsIgnoreCase("Premium")) return Main.perks(sender, 4);
				if(args[0].equalsIgnoreCase("Mod")) return Main.perks(sender, 5);
				
				sender.sendMessage(Main.color("&9[Info] &eThere is no rank with the defined prefix: &9" + args[0]));
				return true;
			}
		}
		return true;
	}
}
