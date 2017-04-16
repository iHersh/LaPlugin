package me.Chase.Main;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class PlayersYaml
{
	public static void createPlayerYaml(Player p)
	{
		File fo = new File(Main.path + "//players//" + p.getName() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(fo);
		
		if (fo.exists()) return;
		
		//TODO Mess with this later if needed.
		
		yaml.createSection("Auth");
		yaml.createSection("Auth.password");
		yaml.createSection("muted");
		yaml.createSection("nick");
		yaml.createSection("online");
		yaml.createSection("tptoggle");
		yaml.createSection("silentjoin");
		yaml.createSection("home");
		yaml.createSection("home.world");
		yaml.createSection("home.x");
		yaml.createSection("home.y");
		yaml.createSection("home.z");
		
		yaml.set("muted", false);
		yaml.set("online", false);
		yaml.set("tptoggle", true);
		yaml.set("silentjoin", false);
		yaml.set("Auth.password", "");
		
		try
		{
			yaml.save(fo);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static File getFile(Player p)
	{
		File f = new File("plugins//LaPlugin//players//" + p.getName() + ".yml");
		return f;
	}
	
	public static YamlConfiguration getYaml(File f)
	{
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		return yaml;
	}
}
