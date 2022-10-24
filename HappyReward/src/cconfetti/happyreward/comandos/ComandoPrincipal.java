package cconfetti.happyreward.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cconfetti.happyreward.HappyReward;

public class ComandoPrincipal implements CommandExecutor {

	private HappyReward plugin;
	
	public ComandoPrincipal(HappyReward plugin){
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command comando, String label,String[] args) {
		if(!(sender instanceof Player)){
			Bukkit.getConsoleSender().sendMessage(plugin.nombre+ChatColor.RED+" Only for Players");
			return false;
		}else{
			String noperm = "messages.General.permission-message";
			Player jugador = (Player) sender;
			if(args.length > 0){
				if(args[0].equalsIgnoreCase("version")){
					jugador.sendMessage(plugin.nombre+ChatColor.WHITE+" Version: "+ChatColor.GOLD+plugin.version);
					return true;
				}else if(args[0].equalsIgnoreCase("reload")){
					if(jugador.hasPermission(plugin.getConfig().getString("Config.General.reload-permission"))){
						plugin.reloadConfig();
						jugador.sendMessage(plugin.nombre+ChatColor.RED+" has been reloaded");
					}else{
						jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(noperm)));
					}
					return true;
				}
				else{
					String utext = "messages.General.unknown-message";
					jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessages().getString(utext)));
					return true;
				}
			}else{
				if(jugador.hasPermission(plugin.getConfig().getString("Config.General.admin-permission"))){
					jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&m---------------"));
					jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lHappyReward"));
					jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&m---------------"));
					jugador.sendMessage(ChatColor.YELLOW+"/hreward reload");
					jugador.sendMessage(ChatColor.YELLOW+"/hreward version");
					jugador.sendMessage(ChatColor.YELLOW+"/reward");
					jugador.sendMessage(ChatColor.YELLOW+"/daily");
					jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&m---------------"));
				}else{
					jugador.sendMessage(ChatColor.RED+"/daily");
				}
				return true;
				
			}
		}
	}

}
