package ml.axegis.mcutilities;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static net.md_5.bungee.api.ChatColor.translateAlternateColorCodes;

public class mcutilitiesCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {


        if(cmd.getName().equalsIgnoreCase("utilities")) {

            if (sender.hasPermission("utilities.utilities")) {

                if (args.length != 1) {
                        sender.sendMessage(ChatColor.GRAY + "---------------");
                        sender.sendMessage(ChatColor.GOLD + "  McUtilities  ");
                        sender.sendMessage(ChatColor.YELLOW + " Version 1.0.1  ");
                        sender.sendMessage(ChatColor.GRAY + "---------------");

                } else if (args[0].equals("reload") && sender.hasPermission("utilities.reload")) {
                        sender.sendMessage(ChatColor.GOLD + "McUtilities " + ChatColor.DARK_GRAY + ">> " + ChatColor.GREEN + "Config reloaded!");
                        McUtilities.getInstance().reloadConfig();
                        McUtilities.getInstance().initConfig();
                } else {
                        sender.sendMessage(ChatColor.RED + "No permissions or wrong syntax!");
                        return true;
                }

                    return true;
            }else {
                    sender.sendMessage(ChatColor.RED + "No permissions!");
                    return true;
            }


        }



        return false;
    }
}