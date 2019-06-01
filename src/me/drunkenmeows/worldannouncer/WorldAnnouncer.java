package me.drunkenmeows.worldannouncer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class WorldAnnouncer extends JavaPlugin {
	
	public List<World> worlds = new ArrayList<World>();
	public final Logger logger = Logger.getLogger("Minecraft");
	
	@Override
	public void onDisable()
	{
		for(World w : worlds)
			w.cancelTask();
	}
	
	@Override
	public void onEnable()
	{
		List<String> worlds = getConfig().getStringList("worlds");
		for(String world : worlds) {
			this.worlds.add(new World(this, logger, world));
		}
	}

}
