package cconfetti.happyreward.eventos;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import cconfetti.happyreward.HappyReward;

public class MobKill implements Listener{
	
	private HappyReward plugin;
	
	public MobKill(HappyReward plugin){
		this.plugin = plugin;
	}
	String mobkillmessage = "messages.Mob-reward.mob-reward-message-text";
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarCreeper(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.CREEPER)){
			String path = "Config.KillMob.creeper.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.creeper.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarSkeleton(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.SKELETON)){
			String path = "Config.KillMob.skeleton.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.skeleton.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarSpider(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.SPIDER)){
			String path = "Config.KillMob.spider.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.spider.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarZombie(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.ZOMBIE)){
			String path = "Config.KillMob.zombie.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.zombie.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarSlime(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.SLIME)){
			String path = "Config.KillMob.slime.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.slime.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarGhast(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.GHAST)){
			String path = "Config.KillMob.ghast.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.ghast.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarPigman(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.PIG_ZOMBIE)){
			String path = "Config.KillMob.pigman.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.pigman.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarEnderman(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.ENDERMAN)){
			String path = "Config.KillMob.enderman.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.enderman.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarCSpider(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.CAVE_SPIDER)){
			String path = "Config.KillMob.cave-spider.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.cave-spider.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarSilverFish(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.SILVERFISH)){
			String path = "Config.KillMob.silverfish.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.silverfish.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarBlaze(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.BLAZE)){
			String path = "Config.KillMob.blaze.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.blaze.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarMagmaC(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.MAGMA_CUBE)){
			String path = "Config.KillMob.magma-cube.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.magma-cube.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarWitch(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.WITCH)){
			String path = "Config.KillMob.witch.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.witch.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarEndermite(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.ENDERMITE)){
			String path = "Config.KillMob.endermite.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.endermite.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarGuardian(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.GUARDIAN)){
			String path = "Config.KillMob.guardian.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.guardian.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarBat(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.BAT)){
			String path = "Config.KillMob.bat.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.bat.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarPig(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.PIG)){
			String path = "Config.KillMob.pig.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.pig.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarSheep(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.SHEEP)){
			String path = "Config.KillMob.sheep.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.sheep.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarCow(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.COW)){
			String path = "Config.KillMob.cow.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.cow.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarChicken(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.CHICKEN)){
			String path = "Config.KillMob.chicken.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.chicken.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarSquid(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.SQUID)){
			String path = "Config.KillMob.squid.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.squid.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarWolf(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.WOLF)){
			String path = "Config.KillMob.wolf.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.wolf.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarMushroom(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.MUSHROOM_COW)){
			String path = "Config.KillMob.mushroom.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.mushroom.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarOcelot(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.OCELOT)){
			String path = "Config.KillMob.ocelot.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.ocelot.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarHorse(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.HORSE)){
			String path = "Config.KillMob.horse.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.horse.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarRabbit(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.RABBIT)){
			String path = "Config.KillMob.rabbit.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.rabbit.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void matarVillager(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.VILLAGER)){
			String path = "Config.KillMob.villager.reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.KillMob.villager.commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
				if(config.getString("Config.KillMob.mob-reward-message").equals("true")){
					killer.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(mobkillmessage).replaceAll("%mob%", victima.getName())));
				}else if(config.getString("Config.KillMob.mob-reward-message").equals("false")){
					return;
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
	}
}
