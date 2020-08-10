package ml.axegis.mcutilities;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static net.md_5.bungee.api.ChatColor.translateAlternateColorCodes;

public class gmspCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {

        String gmchanged = McUtilities.getInstance().getConfig().getString("messages.gm-changed-to-spectator");

        if(sender instanceof Player) {

            Player p = (Player) sender;

            String placeholders = PlaceholderAPI.setPlaceholders(p.getPlayer(), gmchanged);

            if(cmd.getName().equalsIgnoreCase("gmsp")) {
                if (sender.hasPermission("utilities.gm")) {

                    if (p.getGameMode() == GameMode.SPECTATOR) {

                        sender.sendMessage("§cYou're already in spectator mode!");
                    }else {
                        p.setGameMode(GameMode.SPECTATOR);
                        p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', placeholders));

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