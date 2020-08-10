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
                        sender.sendMessage("§7---------------");
                        sender.sendMessage("§6    McUtilities  ");
                        sender.sendMessage("§e    Version 1.0  ");
                        sender.sendMessage("§7---------------");

                } else if (args[0].equals("reload") && sender.hasPermission("utilities.reload")) {
                        sender.sendMessage("§6McUtilities §8>> §aConfig reloaded!");
                        McUtilities.getInstance().reloadConfig();
                        McUtilities.getInstance().initConfig();
                } else {
                        sender.sendMessage("§cNo permissions!");
                        return true;
                }

                    return true;
            }else {
                    sender.sendMessage("§cNo permissions!");
                    return true;
            }


        }



        return false;
    }
}