package me.drunkenmeows.worldannouncer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public class World {
	
	public String Name;
	public long Repeat;
	public int Nextmsg;
	public List<String> messages = new ArrayList<String>();
	public BukkitTask task;
	
	
	public World(final Plugin plugin, Logger logger, String world)
	{
		Name = world;
		Repeat = plugin.getConfig().getLong(world+".Repeat");
		Nextmsg = 0;
		messages = plugin.getConfig().getStringList(world+".Messages");
		
		logger.info(world+" Messages loaded");
		
		task = plugin.getServer().getScheduler().runTaskTimer(plugin, new Runnable()
		{
			public void run(){
				plugin.getServer().broadcast(messages.get(Nextmsg), "announce."+Name);
				
				Nextmsg++;
				
				if(Nextmsg > messages.size()){
					Nextmsg = 0;				}
			}
		},0L, this.Repeat*20);
	}
	
	public void cancelTask()
	{
		task.cancel();
	}
}
