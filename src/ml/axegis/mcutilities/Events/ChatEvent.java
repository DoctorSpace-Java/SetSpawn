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

public class ChatEvent implements Listener {



    @EventHandler
    public void onPlayerChatPost(AsyncPlayerChatEvent chatevent) {

        if (!McUtilities.getInstance().getConfig().getBoolean("settings.can-chat")) {
            chatevent.setCancelled(true);
        }

    }


}