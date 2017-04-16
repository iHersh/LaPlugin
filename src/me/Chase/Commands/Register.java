package me.Chase.Commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.Chase.Main.Main;

public class Register implements CommandExecutor
{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Player p = (Player) sender;
		File f = new File("plugins//LaPlugin//players//" + p.getName() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		
		if (cmd.getName().equalsIgnoreCase("register"))
		{
			if (args.length == 0)
			{
				sender.sendMessage(Main.color(Main.auth + "&eYou must now enter your password after /register"));
				return true;
			}
			
			if (args.length == 1)
			{
				if (yaml.getBoolean("online"))
				{
					sender.sendMessage(Main.color(Main.auth + "&cYou have already registered! Use /auth to change your password!"));
					return true;
				}
				yaml.set("Auth.password", args[0]);
				yaml.set("online", true);
				try
				{
					yaml.save(f);
					sender.sendMessage(Main.color(Main.auth + "&aSaved new password! Enjoy the server!"));
				}
				catch (IOException e)
				{
					e.printStackTrace();
					
				}
			}
		}
		return true;
	}

}
