package ml.axegis.mcutilities;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static net.md_5.bungee.api.ChatColor.translateAlternateColorCodes;

public class gmaCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {

        String gmchanged = McUtilities.getInstance().getConfig().getString("messages.gm-changed-to-adventure");

        if(sender instanceof Player) {

            Player p = (Player) sender;

            String placeholders = PlaceholderAPI.setPlaceholders(p.getPlayer(), gmchanged);

            if(cmd.getName().equalsIgnoreCase("gma")) {
                if (sender.hasPermission("utilities.gm")) {

                    if (p.getGameMode() == GameMode.ADVENTURE) {

                        sender.sendMessage(ChatColor.RED + "You're already in adventure mode!");
                    }else {
                        p.setGameMode(GameMode.ADVENTURE);
                        p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', placeholders));
                    }

                    return true;
                }else {
                    sender.sendMessage(ChatColor.RED + "No permissions!");
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