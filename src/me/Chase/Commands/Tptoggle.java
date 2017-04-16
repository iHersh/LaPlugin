package me.Chase.Commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import me.Chase.Main.Main;

public class Tptoggle implements CommandExecutor
{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		File f = new File("plugins//LaPlugin//players//" + sender.getName() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		if (cmd.getName().equalsIgnoreCase("tptoggle"))
		{
			if (args.length == 0) {
				sender.sendMessage(Main.color(Main.teleportation + "Syntax: /tptoggle <on | off>"));
				return true;
			}
			
			if (args.length == 1)
			{
				if (args[0].equalsIgnoreCase("on"))
				{
					yaml.set("tptoggle", true);
					try
					{
						yaml.save(f);
						sender.sendMessage(Main.color(Main.teleportation + "People can teleport to your location now!"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					return true;
				}
				
				if (args[0].equalsIgnoreCase("off"))
				{
					yaml.set("tptoggle", false);
					try
					{
						yaml.save(f);
						sender.sendMessage(Main.color(Main.teleportation + "People wont be able to teleport to your location now!"));
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				}
				return true;
			}
		}
		return true;
	}
}
