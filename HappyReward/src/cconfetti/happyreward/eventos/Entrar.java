package cconfetti.happyreward.eventos;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import cconfetti.happyreward.HappyReward;

public class Entrar implements Listener{
	
private HappyReward plugin;
	
	public Entrar(HappyReward plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void alEntrar(PlayerJoinEvent event){
		Player jugador = event.getPlayer();
		
		FileConfiguration config = plugin.getConfig();
		//String path = "Config.mensaje-bienvenida";
		//if(config.getString(path).equals("true")){
			//String texto = "Config.mensaje-bienvenida-texto";
			//jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(texto)).replaceAll("%player%", jugador.getName()));
		//}
		if(jugador.isOp() && !(plugin.getVersion()).equals(plugin.getLatestVersion())){
			String path = "Config.check-update";
			if(config.getString(path).equals("true")){
				jugador.sendMessage(plugin.nombre+ChatColor.translateAlternateColorCodes('&', " &cThere is a new version available."));
				jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou can download it at: &fhttps://www.spigotmc.org/resources/104928/"));
			}else if(config.getString(path).equals("false")){
				return;
			}
		}
		return;
	}

}
