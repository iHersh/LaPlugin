package me.Chase.Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.Chase.Commands.Commands;
import me.Chase.Main.Auth.AuthMain;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Main extends JavaPlugin implements Listener {

	public static ArrayList<Player> chat = new ArrayList<Player>();
	public static ArrayList<Player> instant = new ArrayList<Player>();
	public static ArrayList<Player> fall = new ArrayList<Player>();
	public static ArrayList<Player> staff = new ArrayList<Player>();
	public static ArrayList<Player> frozen = new ArrayList<Player>();
	public static ArrayList<Player> vanish = new ArrayList<Player>();

	public static final String vip = "&5VIP&r";
	public static final String vipplus = "&5VIP+&r";
	public static final String premium = "&9Premium&r";
	public static final String mod = "&6Mod&r";
	public static final String admin = "&cAdmin&r";
	public static final String owner = "&4Owner&r";

	public static final String noperms = "&9[Permissions] &7You don't have permission! ";
	public static String warp = color("&9[Warp]&7 ");
	public static String spawn = color("&9[Spawn]&7 ");
	public static String teleportation = color("&9[Teleportation]&7 ");
	public static String adminP = color("&9[Admin]&7 ");
	public static String health = color("&9[Health]&7 ");
	public static String kits = color("&9[Kits]&7 ");
	public static String time = color("&9[Time]&7 ");
	public static String auth = color("&9[Auth]&7 ");

	public static String path = "plugins//LaPlugin//";

	@Override
	public void onEnable() {
		Commands.registerAllCommands(this);
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getServer().getPluginManager().registerEvents(new AuthMain(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new StaffModeEvents(), this);

	}

	@Override
	public void onDisable()
	{
		for (Player p : vanish)
		{
			for (Player p1 : Bukkit.getOnlinePlayers())
			{
				p1.showPlayer(p);
			}
			p.sendMessage(color("&6A reload has forced you to unvanish."));
		}
	}

	// TODO: /staff or /staffmode - kinda done - inventory saving
	// TODO: /updaterank - done
	// TODO: /freeze - done
	// TODO: Personal Vaults (external plugin???)
	// TODO: Chat formatting with name

	// TODO: Vanish? - done

	// TODO: Hard code kits?
	// TODO: Set time
	// TODO: invsee
	// TODO: admin silent join
	// TODO: tptoggle
	// TODO: nicknames
	// TODO: heal and feed SEPERATELY
	// TODO: tpa, tpaccept, and tpdeny

	public static void staff(Player p) 
	{
		if (staff.contains(p)) 
		{
			p.setGameMode(GameMode.CREATIVE);
			vanish(p, true);
			p.sendMessage("&9[Staff] &7You have vanished!");
		} 
		else 
		{
			p.setGameMode(GameMode.SURVIVAL);
			vanish(p, false);
			p.sendMessage("&9[Staff] &7You have been revealed.");
		}
	}

	public static void vanish(Player p) 
	{
		// if you ARE vanished and you use the command
		if (vanish.contains(p))
		{
			for (Player p1 : Bukkit.getOnlinePlayers()) 
			{
				if (!p1.hasPermission("LV.vanish.see")) 
				{
					p1.hidePlayer(p);
				}
			}
		} 
		else 
		{
			for (Player p1 : Bukkit.getOnlinePlayers()) 
			{
				p1.showPlayer(p);
			}
		}
	}

	// b is to enable or disable manually
	public static void vanish(Player p, boolean b) 
	{
		// true to vanish the player
		if (b)
		{
			for (Player p1 : Bukkit.getOnlinePlayers())
			{
				if (!p1.hasPermission("LV.vanish.see"))
				{
					p1.hidePlayer(p);
				}
			}
		} else {
			for (Player p1 : Bukkit.getOnlinePlayers()) {
				p1.showPlayer(p);
			}
		}
	}

	public static boolean perks(CommandSender sender, int i)
	{
		if (i == 1) {
			sender.sendMessage(color("&9[Info] &ePerks for rank: &7Default"));
			sender.sendMessage(color("&9/spawn        &7- Teleport to spawn."));
			sender.sendMessage(color("&9/sethome      &7- Sets a home, teleport to it with /home."));
			sender.sendMessage(color("&9/tpa <player> &7- Request to teleport to another player."));
			sender.sendMessage(color("&9/tpaccept     &7- Accept a request to teleport to you."));
			sender.sendMessage(color("&9/tpdeny       &7- Deny a request to teleport to you."));
			return true;
		}

		if (i == 2) {
			sender.sendMessage(color("&9[Info] &ePerks for rank: " + vip));
			sender.sendMessage(color("&9/kit vip &7- Gives player kit pvp."));
			sender.sendMessage(color("&9/heal    &7- Heals player."));
			sender.sendMessage(color("&9/feed    &7- Restores player's hunger."));
			sender.sendMessage(color("&9/fall    &7- Disable fall damage."));
			return true;
		}

		if (i == 3) {
			sender.sendMessage(color("&9[Info] &ePerks for rank: " + vipplus));
			sender.sendMessage(color("&9/kit vip  &7- Gives player kit pvp."));
			sender.sendMessage(color("&9/kit vip+ &7- Gives player kit pvp+."));
			sender.sendMessage(color("&9/heal     &7- Restores life and hunger."));
			sender.sendMessage(color("&9/feed     &7- Restores hunger."));
			sender.sendMessage(color("&9/fall     &7- Disable fall damage."));
			sender.sendMessage(color("&9/nick     &7- Changes user's chat name."));
			return true;
		}

		if (i == 4) {
			sender.sendMessage(color("&9[Info] &ePerks for rank: " + premium));
			sender.sendMessage(color("&9/kit vip  &7- Gives player kit pvp."));
			sender.sendMessage(color("&9/kit vip+ &7- Gives player kit pvp+."));
			sender.sendMessage(color("&9/kit premium &7- Gives player kit pvp+."));
			sender.sendMessage(color("&9/heal     &7- Restores life and hunger."));
			sender.sendMessage(color("&9/feed     &7- Restores hunger."));
			sender.sendMessage(color("&9/nick     &7- Changes user's chat name."));
			sender.sendMessage(color("&9/fly      &7- Toggles fly mode."));
			sender.sendMessage(color("&9/instant  &7- Toggles instant mining."));
			return true;
		}

		if (i == 5) {
			sender.sendMessage(color("&9[Info] &ePerks for rank: " + mod));
			sender.sendMessage(color("&9/warn <player> <reason> &7- Warns player."));
			sender.sendMessage(color("&9/kick <player> <reason> &7- Removes player from server."));
			sender.sendMessage(color("&9/mute <player> <time> <reason> &7- Disables chat for player."));
			sender.sendMessage(color("&9/ban <player> <time> <reason> &7- Prevents player from joining server."));
			sender.sendMessage(color("&9/tp <player> &7- Teleport to another player."));
			sender.sendMessage(color("&9/co i &7- Toggles block inspector."));
			sender.sendMessage(color("&9/staffchat or /sc &7- Toggles staff mode."));
			sender.sendMessage(color("&9/staff &7- Toggles staff mode."));
			sender.sendMessage(color("&9/vanish or /v &7- Toggles flight."));
			return true;
		}

		sender.sendMessage(color("&7You should know what your perks are. &9(Admins and Owners)"));
		return true;
	}

	public static void sendStaffChatMessage(Player p, String s)
	{
		for (Player p1 : Bukkit.getOnlinePlayers()) {
			if (PermissionsEx.getUser(p1).getPrefix().equalsIgnoreCase("&6&lMOD&f ")
					|| PermissionsEx.getUser(p1).getPrefix().equalsIgnoreCase("&c&lADMIN&r ")
					|| PermissionsEx.getUser(p1).getPrefix().equalsIgnoreCase("&4&lOWNER&r ")) {
				String prefix = ChatColor.stripColor(PermissionsEx.getUser(p).getPrefix());
				p1.sendMessage(color("&9[Staff Chat] &r" + prefix + p.getName() + ": &d" + s));
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin1(PlayerJoinEvent e) {
		File f = PlayersYaml.getFile(e.getPlayer());
		YamlConfiguration yaml = PlayersYaml.getYaml(f);
		
		if (PermissionsEx.getUser(e.getPlayer()).getPrefix().equalsIgnoreCase("&c&lADMIN&r ")
				|| PermissionsEx.getUser(e.getPlayer()).getPrefix().equalsIgnoreCase("&4&lOWNER&r ")) {
			System.out.println("Rank success");
			if (yaml.getBoolean("silentjoin") == true) {
				System.out.println(e.getPlayer().getName() + " silently joined.");
				e.setJoinMessage(null);
			}
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) 
	{
		if (e.getPlayer().hasPlayedBefore()) 
		{
			AuthMain.newJoinMessage(e.getPlayer());
		}
		AuthMain.firstJoinMessage(e.getPlayer());
		PlayersYaml.createPlayerYaml(e.getPlayer());
		for (Player p : vanish) 
		{
			if (!e.getPlayer().hasPermission("LV.vanish.see")) 
			{
				e.getPlayer().hidePlayer(p);
			}
		}
	}

	@EventHandler
	public void onLogout(PlayerQuitEvent e) 
	{
		File f = new File("plugins//LaPlugin//players//" + e.getPlayer().getName() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		yaml.set("online", false);
		try 
		{
			yaml.save(f);
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
		if (chat.contains(e.getPlayer())) chat.remove(e.getPlayer());
		if (instant.contains(e.getPlayer())) instant.remove(e.getPlayer());
		if (vanish.contains(e.getPlayer())) vanish.remove(e.getPlayer());
		for (Player p : Bukkit.getOnlinePlayers()) e.getPlayer().showPlayer(p);
	}

	@EventHandler
	public void onFallDamage(EntityDamageEvent e) 
	{
		if (e.getEntity() instanceof Player) 
		{
			Player p = (Player) e.getEntity();
			if (e.getCause() == DamageCause.FALL && fall.contains(p)) 
			{
				e.setCancelled(true);
				p.sendMessage(color("&9[Perks] &7/fall has prevented you from taking fall damage!"));
			}
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) 
	{
		if (e.getAction().equals(Action.LEFT_CLICK_BLOCK) && instant.contains(e.getPlayer())) 
		{
			if (e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) 
			{
				if (e.getClickedBlock().getLocation().getY() > 0.0D) 
				{
					if (!e.getClickedBlock().getType().equals(Material.BEDROCK)) 
					{
						e.getClickedBlock().setType(Material.AIR);
					} 
					else 
					{
						e.getPlayer().sendMessage(color("&9[Perks] &7You may not break bedrock with instant."));
						e.setCancelled(true);
					}
				} 
				else 
				{
					e.getPlayer()
							.sendMessage(color("&9[Perks] &7You may not break blocks at or below Y: 0 with instant."));
					e.setCancelled(true);
				}
			}
			else 
			{
				e.getPlayer().sendMessage(color("&9[Perks] &7You must be in survival mode to use instant."));
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) 
	{
		if (chat.contains(e.getPlayer())) 
		{
			e.setCancelled(true);
			sendStaffChatMessage(e.getPlayer(), e.getMessage());
		}
	}

	public static String color(String msg) 
	{
		msg = ChatColor.translateAlternateColorCodes('&', msg);
		return msg;
	}
}
