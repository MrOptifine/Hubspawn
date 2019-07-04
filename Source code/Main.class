package interhub.plugin.hub_spawn;



import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin {
	
	private static Main instance;
	
	public Main() {
		instance = this;
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	
	 @Override
	 public void onEnable() {
		 
		 //config file
		 getConfig().options().copyDefaults();
		 saveDefaultConfig();
		 
		 //commands init
		 this.getCommand("sethub").setExecutor(new CommandSethub(Main.instance));
		 
		 //console messages
		 System.out.println("[HubSpawn] Has been enabled!");
		 System.out.println("[HubSpawn] By InterHub, MrOptifine");
		 
		 //playerJoinEvent
		 getServer().getPluginManager().registerEvents(new Playerjoin(Main.instance), this);	 
	 }
	   
	 @Override
	 public void onDisable() {  
		 
		 //console messages
		 System.out.println("[HubSpawn] Has been disabled");
		 System.out.println("[HubSpawn] THANK YOU! for using this plugin :)");
	 }
	 
	 public FileConfiguration getCon() {
		 return getConfig();
	 }
	 
	 public void saveCon() {
		 saveConfig();
		 reloadConfig();
	 }
	 
}