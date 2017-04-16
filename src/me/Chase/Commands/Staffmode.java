package me.Chase.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.Chase.Main.Main;

public class Staffmode implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(commandLabel.equalsIgnoreCase("staff"))
		{
			if(sender.hasPermission("LV.staffmode"))
			{
				if(!Main.staff.contains((Player) sender))
				{
					Main.staff.add((Player) sender);
					Main.staff((Player) sender);
					sender.sendMessage(Main.color("&9[Staff] &7You have enabled staff mode."));
					return true;
				}
				else
				{
					Main.staff.remove((Player) sender);
					Main.staff((Player) sender);
					sender.sendMessage(Main.color("&9[Staff] &7You have disabled staff mode."));
					return true;
				}
			}
			else
			{
				sender.sendMessage(Main.color(Main.noperms + Main.mod));
				return true;
			}
		}
		return true;
	}
}
