package ml.axegis.mcutilities.Events;

import me.clip.placeholderapi.PlaceholderAPI;
import ml.axegis.mcutilities.McUtilities;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class JoinEvent implements Listener {



    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        String joinmessage = McUtilities.getInstance().getConfig().getString("others.join-message");

        String placeholdersjoin = PlaceholderAPI.setPlaceholders(e.getPlayer(), joinmessage);

        e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', placeholdersjoin));
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        String quitmessage = McUtilities.getInstance().getConfig().getString("others.quit-message");

        String placeholdersquit = PlaceholderAPI.setPlaceholders(event.getPlayer(), quitmessage);

        event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', placeholdersquit));
    }



}