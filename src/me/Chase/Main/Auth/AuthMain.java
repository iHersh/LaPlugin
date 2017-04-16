package me.Chase.Main.Auth;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import me.Chase.Main.Main;

public class AuthMain implements Listener {

	static Main plugin;

	public AuthMain(Main pl) {
		AuthMain.plugin = pl;
	}

	@EventHandler
	public void interaction(PlayerInteractEvent e) {
		File f = new File("plugins//LaPlugin//players//" + e.getPlayer().getName() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		if (yaml.getBoolean("online") == false) {
			e.setCancelled(true);
			return;
		}

		if (yaml.getBoolean("online") == true) {
			return;
		}
	}

	@EventHandler
	public void movement(PlayerMoveEvent e) {
		File f = new File("plugins//LaPlugin//players//" + e.getPlayer().getName() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		if (yaml.getBoolean("online") == false) {
			e.setCancelled(true);
			return;
		}

		if (yaml.getBoolean("online") == true) {
			return;
		}
	}

	@EventHandler
	public void chat(AsyncPlayerChatEvent e) {
		File f = new File("plugins//LaPlugin//players//" + e.getPlayer().getName() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		if (yaml.getBoolean("online") == false) {
			if (!e.getMessage().equals(yaml.getString("Auth.password"))) {
				e.setCancelled(true);
				e.getPlayer().sendMessage(Main.color(Main.auth + "That isnt the right password!"));
				return;
			}
			e.setCancelled(true);
			e.getPlayer().sendMessage(Main.color(Main.auth + "&aSuccess! Have fun!"));
			yaml.set("online", true);
			try {
				yaml.save(f);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static void firstJoinMessage(Player p) {
		File f = new File("plugins//LaPlugin//players//" + p.getName() + ".yml");
		if (!p.hasPlayedBefore() || !f.exists()) {
			Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
				public void run() {
					p.sendMessage(Main.color(
							Main.auth + "&eSince you are new to the server, we recommend setting a password for your account. "
							+ "Please type in &a/register&e, followed by your new password."));
				}
			}, 20);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void newJoinMessage(Player p) {
			Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
				public void run() {
					p.sendMessage(Main.color(
							Main.auth + "&ePlease type in your password as a message, not a command."));
				}
			}, 20);
	}

}
