package me.Chase.Commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import me.Chase.Main.Main;

public class Silentjoin implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		File f = new File("plugins//LaPlugin//players//" + sender.getName() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		if (cmd.getName().equalsIgnoreCase("silentjoin")) {
			if (args.length == 0) {
				sender.sendMessage(Main.color(Main.adminP + "&eRepeat the command, but use Yes or No to toggle."));
				return true;
			}
			
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("yes")) {
					yaml.set("silentjoin", true);
					try {
						yaml.save(f);
						sender.sendMessage(Main.color(Main.adminP + "&aJoin messages for you have been disabled!"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					return true;
				}
				
				if (args[0].equalsIgnoreCase("no")) {
					yaml.set("silentjoin", false);
					try {
						yaml.save(f);
						sender.sendMessage(Main.color(Main.adminP + "&aJoin messages for you have been enabled!"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				return true;
			}
		}
		return true;
	}
}
