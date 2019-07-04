package interhub.plugin.hub_spawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CommandSethub implements CommandExecutor {
	
	
	private Main instance;
	
	public CommandSethub(Main instance) {
		this.instance = instance;
	}
	
	
	
	private double x;
	private double y;
	private double z;
	
	// This method is called, when somebody uses sethub
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("You need to be a player to use this command!");
			return false;
		}
		
		if(sender.hasPermission("hubspawn.sethub") || sender.hasPermission("permissions.*")) {
			if (command.getName().equalsIgnoreCase("sethub")) {
				Player player = (Player) sender;
				x = player.getLocation().getX();
				y = player.getLocation().getY();
				z = player.getLocation().getZ();
				
				instance.getCon().set("X",x);
				instance.saveCon();
				instance.getCon().set("Y",y);
				instance.saveCon();
				instance.getCon().set("Z",z);
				instance.saveCon();
				
				
	            sender.sendMessage(ChatColor.GREEN + "Spawn location has been set!");
	            sender.sendMessage("Location: x:" + x + ", y:" + y + ", z" + z);
	            return true;
	        }
		}else{
			sender.sendMessage(ChatColor.DARK_RED + "You do not have to permission te execute this command!");
		}
		return false;
    }
}