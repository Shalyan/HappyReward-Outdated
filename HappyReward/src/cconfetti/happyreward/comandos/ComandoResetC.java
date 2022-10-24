package cconfetti.happyreward.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import cconfetti.happyreward.HappyReward;

public class ComandoResetC implements CommandExecutor{
	private HappyReward plugin;
	
	public ComandoResetC(HappyReward plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command comando, String label,String[] args) {
		if(!(sender instanceof Player)){
			return false;
		}else{
			String noperm = "messages.General.permission-message";
			Player jugador = (Player) sender;
			if(args.length >= 2){
				if(args[0].equalsIgnoreCase("cooldownreset")){
					if(jugador.hasPermission(plugin.getConfig().getString("Config.General.admin-permission"))){
						String cooldownmessage = "messages.Cooldown.no-cooldown-reset-message";
						Player jugadorc = Bukkit.getPlayer(args[1]);
						FileConfiguration players = plugin.getPlayers();
						String pathtime ="Players."+jugadorc.getUniqueId();
						if(players.contains(pathtime)){
							plugin.getPlayers().set(pathtime, null);
							plugin.savePlayers();
							String cooldownmessagey = "messages.Cooldown.reset-cooldown-message";
							jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(cooldownmessagey).replaceAll("%player%", jugadorc.getName())));
						}else{
							jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(cooldownmessage)));
						}
					}else{
						jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(noperm)));
					}
				}else{
					if(jugador.hasPermission(plugin.getConfig().getString("Config.General.admin-permission"))){
						jugador.sendMessage(ChatColor.RED+"/reward cooldownreset <user>");
					}else{
						jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(noperm)));
					}
				}
			}else{
				if(jugador.hasPermission(plugin.getConfig().getString("Config.General.admin-permission"))){
					jugador.sendMessage(ChatColor.RED+"/reward cooldownreset <user>");
				}else{
					jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(noperm)));
				}
			}
			return true;
		}
	}

}
