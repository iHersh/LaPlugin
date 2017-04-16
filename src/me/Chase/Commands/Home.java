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

public class Home implements CommandExecutor
{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("sethome"))
		{
			//TODO Add permission???
			Player p = (Player) sender;
			File f = new File("plugins//LaPlugin//players//" + p.getName() + ".yml");
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
			
			yaml.set("home.world", p.getLocation().getWorld().getName());
			yaml.set("home.x", p.getLocation().getX());
			yaml.set("home.y", p.getLocation().getY());
			yaml.set("home.z", p.getLocation().getZ());
			try
			{
				yaml.save(f);
				p.sendMessage(Main.color(Main.warp + "&aSuccessfully created home!"));
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("home"))
		{
			Player p = (Player) sender;
			File f = new File("plugins//LaPlugin//players//" + p.getName() + ".yml");
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
			
			if (yaml.getString("home").isEmpty())
			{
				p.sendMessage(Main.color(Main.warp + "&cThere is no home to be found."));
				return true;
			}
			
			Location l = new Location(Bukkit.getWorld(yaml.getString("home.world")), yaml.getDouble("home.x"),
					yaml.getDouble("home.y"), yaml.getDouble("home.z"));
			p.teleport(l);
			p.sendMessage(Main.color(Main.warp + "&aTeleport successful!"));
		}
		return true;
	}
}
