package ml.axegis.mcutilities;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static net.md_5.bungee.api.ChatColor.translateAlternateColorCodes;

public class FlyCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {


        String flydisabled = McUtilities.getInstance().getConfig().getString("messages.fly-disabled");
        String flyenabled = McUtilities.getInstance().getConfig().getString("messages.fly-enabled");


        if(sender instanceof Player) {

            Player p = (Player) sender;

            String placeholdersflydisabled = PlaceholderAPI.setPlaceholders(p.getPlayer(), flydisabled);
            String placeholdersflyenabled = PlaceholderAPI.setPlaceholders(p.getPlayer(), flyenabled);

            if(cmd.getName().equalsIgnoreCase("fly")) {
                if (sender.hasPermission("utilities.fly")) {

                    if (p.getAllowFlight()) {

                        p.setAllowFlight(false);
                        p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', placeholdersflydisabled));
                    }else {
                        p.setAllowFlight(true);
                        p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', placeholdersflyenabled));
                    }

                    return true;
                }else {
                    sender.sendMessage("§cNo permissions!");
                    return true;
                }


            }

        }else {
            System.out.println("Only players can do this!");
            return true;
        }

        return false;
    }
}