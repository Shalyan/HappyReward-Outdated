package cconfetti.happyreward.eventos;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import cconfetti.happyreward.HappyReward;

public class KillReward implements Listener {
	
	private HappyReward plugin;
	
	public KillReward(HappyReward plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void matarJugador(EntityDeathEvent event){
		FileConfiguration config = plugin.getConfig();
		Player killer = event.getEntity().getKiller();
		EntityType victima = event.getEntityType();
		if(killer != null && killer.getType().equals(EntityType.PLAYER) && victima.equals(EntityType.PLAYER)){
			String path = "Config.Kill.kill-reward";
			if(config.getString(path).equals("true")){
				List<String> comandos = config.getStringList("Config.Kill.kill-commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%killer%", killer.getName()));
				}
			}else if(config.getString(path).equals("false")){
				return;
			}
			
		}
	}
}
