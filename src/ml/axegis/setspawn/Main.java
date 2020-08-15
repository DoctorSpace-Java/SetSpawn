package ml.axegis.setspawn;

import ml.axegis.setspawn.commands.SetSpawn;
import ml.axegis.setspawn.commands.Spawn;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        getCommand("setspawn").setExecutor(new SetSpawn());
        getCommand("spawn").setExecutor(new Spawn());

        loadConfig();

        getLogger().info(ChatColor.GREEN + "Enabled");
    }

    public void onDisable() {
        getLogger().info(ChatColor.RED + "Disabled");
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

}
