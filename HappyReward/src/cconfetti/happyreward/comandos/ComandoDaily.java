package cconfetti.happyreward.comandos;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import cconfetti.happyreward.HappyReward;
import cconfetti.happyreward.eventos.Cooldown;

public class ComandoDaily implements CommandExecutor{
	private HappyReward plugin;
	
	public ComandoDaily(HappyReward plugin){
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command comando, String label,String[] args) {
		if(!(sender instanceof Player)){
			Bukkit.getConsoleSender().sendMessage(plugin.nombre+ChatColor.RED+" Este comando es solo para jugadores");
			return false;
		}else{
		    Player jugador = (Player) sender;
			FileConfiguration config = plugin.getConfig();
			String path = "Config.Daily.daily-reward";
			if(config.getString(path).equals("true")){
				Cooldown c = new Cooldown(plugin);
				if(c.getCooldown(jugador).equals("-1")){
					String pathtime = "Players."+jugador.getUniqueId()+".cooldown-daily";
					FileConfiguration players = plugin.getPlayers();
				    long millis = System.currentTimeMillis();   
				    players.set(pathtime, millis);
				    plugin.savePlayers();
				}else {
					String cooldown = "messages.Cooldown.cooldown-message";
					jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(cooldown)).replaceAll("%time%", c.getCooldown(jugador)));
					return false;
				}
				List<String> comandos = config.getStringList("Config.Daily.daily-commands");
				for(int i=0;i<comandos.size();i++){
					String comand = comandos.get(i);
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comand.replaceAll("%player%", jugador.getName()));
				}
				String bcenable = "Config.Daily.daily-broadcast";
				String bctext = "messages.Daily-reward.daily-broadcast-text";
				if(config.getString(bcenable).equals("true")){
					Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(bctext)).replaceAll("%player%", jugador.getName()));
				}
				String texto = "messages.Daily-reward.daily-claim-text";
				jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(texto)).replaceAll("%player%", jugador.getName()));
			}else if(config.getString(path).equals("false")){
				String cooldowntext = "messages.Daily-reward.daily-false-text";
				jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(cooldowntext)).replaceAll("%player%", jugador.getName()));
			}
			
			return true;
		}
	}

}
