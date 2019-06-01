package me.drunkenmeows.worldannouncer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class waListener implements Listener {
	
	private final WorldAnnouncer plugin;
	
	public waListener(WorldAnnouncer wa) {
		plugin = wa;
	}
	
	@EventHandler
	public void onPlayerjoin(PlayerJoinEvent pje)
	{
		pje.getPlayer().addAttachment(this.plugin, "announce."+pje.getPlayer().getWorld().getName(), true);
	}
	
	@EventHandler
	public void onWorldChanger(Playr)

}
