package me.Chase.Commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.Chase.Main.Main;

public class Spawn implements CommandExecutor
{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("setspawn"))
		{
			if (!sender.hasPermission("LV.setspawn"))
			{
				sender.sendMessage(Main.color(Main.noperms + Main.admin));
				return true;
			}

			Player p = (Player) sender;
			File f = new File("plugins//LaPlugin//spawn.yml");
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
			yaml.createSection("world");
			yaml.createSection("xPos");
			yaml.createSection("yPos");
			yaml.createSection("zPos");
			yaml.createSection("pitch");
			yaml.createSection("yaw");
			yaml.set("world", p.getLocation().getWorld().getName());
			yaml.set("xPos", p.getLocation().getX());
			yaml.set("yPos", p.getLocation().getY());
			yaml.set("zPos", p.getLocation().getZ());
			yaml.set("pitch", p.getLocation().getPitch());
			yaml.set("yaw", p.getLocation().getYaw());
			try
			{
				yaml.save(f);
				sender.sendMessage(Main.color(Main.spawn + "&aSpawn has been set! Use /spawn to get here!"));
			}
			catch (IOException e)
			{
				e.printStackTrace();
				sender.sendMessage(Main.color("&cThere seems to be an error for the spawn.yml"));
			}
		}

		if (cmd.getName().equalsIgnoreCase("spawn"))
		{
			Player p = (Player) sender;
			File f = new File("plugins//LaPlugin//spawn.yml");
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
			if (!f.exists())
			{
				p.sendMessage(Main.color(Main.spawn + "&cThe spawn hasn't been set yet!"));
				return true;
			}

			Location l = new Location(Bukkit.getWorld(yaml.getString("world")), yaml.getDouble("xPos"),
					yaml.getDouble("yPos"), yaml.getDouble("zPos"), yaml.getInt("yaw"), yaml.getInt("pitch"));
			try
			{
				p.teleport(l);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				p.sendMessage(Main.color("&cThere seems to be an issue with teleporting you to spawn!"));
			}
		}
		return true;
	}
}
