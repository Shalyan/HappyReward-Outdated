package cconfetti.happyreward;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import cconfetti.happyreward.comandos.ComandoDaily;
import cconfetti.happyreward.comandos.ComandoPrincipal;
import cconfetti.happyreward.comandos.ComandoResetC;
import cconfetti.happyreward.eventos.Entrar;
import cconfetti.happyreward.eventos.KillReward;
import cconfetti.happyreward.eventos.MobKill;

public class HappyReward extends JavaPlugin{
	private FileConfiguration players = null;
	private File playersFile = null;
	private FileConfiguration messages = null;
	private File messagesFile = null;
	
	public String rutaConfig;
	PluginDescriptionFile pdffile = getDescription();
	public String version = pdffile.getVersion();
	public String latestversion;
	public String nombre = ChatColor.YELLOW+pdffile.getName();
	
	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"==================================");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"Author: "+ChatColor.WHITE+"CConfetti");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+nombre+ChatColor.WHITE+" Actived");
		Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"Version: "+ChatColor.WHITE+version+"");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"==================================");
		comandosreg();
		registerConfig();
		registerEvents();
		registerPlayers();
		registerMessages();
		updateChecker();
	}
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"==================================");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"Author: "+ChatColor.WHITE+"CConfetti");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+nombre+ChatColor.WHITE+" Desactived");
		Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"Version: "+ChatColor.WHITE+version+"");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"==================================");
	}
	public String getVersion(){
		return this.version;
	}
	public String getLatestVersion(){
		return this.latestversion;
	}
	public void comandosreg(){
		this.getCommand("hreward").setExecutor(new ComandoPrincipal(this));
		this.getCommand("daily").setExecutor(new ComandoDaily(this));
		this.getCommand("reward").setExecutor(new ComandoResetC(this));
	}
	public void registerEvents(){
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new KillReward(this), this);
		pm.registerEvents(new Entrar(this), this);
		pm.registerEvents(new MobKill(this), (this));
	}
	public void registerConfig(){
		File config = new File(this.getDataFolder(),"config.yml");
		rutaConfig = config.getPath();
		if(!config.exists()){
			saveDefaultConfig();
		}
	}
	public FileConfiguration getPlayers(){
		if(players == null){
			reloadPlayers();
		}
		return players;
	}
	
	public void reloadPlayers(){
		if (players == null){
			playersFile = new File(getDataFolder(), "players.yml");
			
		}
		players = YamlConfiguration.loadConfiguration(playersFile);
		Reader defConfigStream;
		try{
			defConfigStream = new InputStreamReader(this.getResource("players.yml"), "UTF8");
			if(defConfigStream != null){
				YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
				players.setDefaults(defConfig);
			}
			
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
	}
	public void savePlayers(){
		try{
			players.save(playersFile);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void registerPlayers(){
		playersFile = new File(this.getDataFolder(), "players.yml");
		if(!playersFile.exists()){
			this.getPlayers().options().copyDefaults(true);
			savePlayers();
		}
	}
	public FileConfiguration getMessages(){
		if(messages == null){
			reloadMessages();
		}
		return messages;
	}
	public void reloadMessages(){
		if (messages == null){
			messagesFile = new File(getDataFolder(), "messages.yml");
		}
		messages = YamlConfiguration.loadConfiguration(messagesFile);
		Reader defConfigStream1;
		try{
			defConfigStream1 = new InputStreamReader(this.getResource("messages.yml"), "UTF8");
			if(defConfigStream1 != null){
				YamlConfiguration defConfig1 = YamlConfiguration.loadConfiguration(defConfigStream1);
				messages.setDefaults(defConfig1);
			}
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
	}
	public void saveMessages(){
		try{
			messages.save(messagesFile);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void registerMessages(){
		messagesFile = new File(this.getDataFolder(), "messages.yml");
		if(!messagesFile.exists()){
			this.getMessages().options().copyDefaults(true);
			saveMessages();
		}
	}
	
	 public void updateChecker(){		  
		  try {
			  HttpURLConnection con = (HttpURLConnection) new URL(
	                  "https://api.spigotmc.org/legacy/update.php?resource=104928").openConnection();
	          int timed_out = 1250;
	          con.setConnectTimeout(timed_out);
	          con.setReadTimeout(timed_out);
	          latestversion = new BufferedReader(new InputStreamReader(con.getInputStream())).readLine();
	          if (latestversion.length() <= 7) {
	        	  if(!version.equals(latestversion)){
	        		  Bukkit.getConsoleSender().sendMessage(nombre+ChatColor.RED +" There is a new version available. "+ChatColor.YELLOW+
	        				  "("+ChatColor.GRAY+latestversion+ChatColor.YELLOW+")");
	        		  Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"You can download it at: "+ChatColor.WHITE+"https://www.spigotmc.org/resources/104928/");  
	        	  }      	  
	          }
	      } catch (Exception ex) {
	    	  Bukkit.getConsoleSender().sendMessage(nombre + ChatColor.RED +"Error while checking update.");
	      }
	  }
}