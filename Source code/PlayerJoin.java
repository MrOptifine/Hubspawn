package interhub.plugin.hub_spawn;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;

public class Playerjoin implements Listener{
	
private Main instance;
	
	public Playerjoin(Main instance) {
		this.instance = instance;
	}
	
	
	@EventHandler
	void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		double x = instance.getConfig().getDouble("X");
		double y = instance.getConfig().getDouble("Y");
		double z = instance.getConfig().getDouble("Z");
		World world = player.getWorld();
		if(x == 0.0 && y == 0.0 && z == 0.0 && player.hasPermission("hubspawn.sethub")) {
			player.sendMessage(ChatColor.RED + "YOU NEED TO SET THE SPAWNPOINT IN ORDER FOR THIS PLUGIN TO WORK!");
			player.sendMessage(ChatColor.RED + "USE /sethub !!!!");
		}else if(x != 0.0 && y != 0.0 && z != 0.0){
			Location location = new Location(world,x,y,z);
			player.teleport(location);
		}
	}
}
