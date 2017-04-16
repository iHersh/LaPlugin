package me.Chase.Commands;

import me.Chase.Main.Main;
import me.Chase.Commands.Warp;
import me.Chase.Commands.Staffchat;
import me.Chase.Commands.Instant;
import me.Chase.Commands.Fall;
import me.Chase.Commands.Fly;
import me.Chase.Commands.Help;

public class Commands
{
	
	Main plugin;
	
	public Commands(Main p)
	{
		this.plugin = p;
	}
	
	public static void registerAllCommands(Main plugin)
	{
		plugin.getCommand("warp").setExecutor(new Warp());
		plugin.getCommand("delwarp").setExecutor(new Warp());
		plugin.getCommand("setwarp").setExecutor(new Warp());
		plugin.getCommand("staffchat").setExecutor(new Staffchat());
		plugin.getCommand("instant").setExecutor(new Instant());
		plugin.getCommand("fall").setExecutor(new Fall());
		plugin.getCommand("fly").setExecutor(new Fly());
		plugin.getCommand("help").setExecutor(new Help());
		plugin.getCommand("staff").setExecutor(new Staffmode());
		plugin.getCommand("freeze").setExecutor(new Freeze());
		plugin.getCommand("updaterank").setExecutor(new Updaterank());
		plugin.getCommand("weather").setExecutor(new Weather());
		plugin.getCommand("vanish").setExecutor(new Vanish());
		plugin.getCommand("invsee").setExecutor(new Invsee());
		plugin.getCommand("spawn").setExecutor(new Spawn());
		plugin.getCommand("setspawn").setExecutor(new Spawn());
		plugin.getCommand("sethome").setExecutor(new Home());
		plugin.getCommand("home").setExecutor(new Home());
		plugin.getCommand("tptoggle").setExecutor(new Tptoggle());
		plugin.getCommand("silentjoin").setExecutor(new Silentjoin());
		plugin.getCommand("heal").setExecutor(new Heal_Feed());
		plugin.getCommand("feed").setExecutor(new Heal_Feed());
		plugin.getCommand("kit").setExecutor(new KitsCmd());
		plugin.getCommand("settime").setExecutor(new Time());
		plugin.getCommand("time").setExecutor(new Time());
		plugin.getCommand("register").setExecutor(new Register());
	}

}
