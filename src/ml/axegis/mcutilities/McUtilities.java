package ml.axegis.mcutilities;

import ml.axegis.mcutilities.Events.ChatEvent;
import ml.axegis.mcutilities.Events.JoinEvent;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class McUtilities extends JavaPlugin {

    public static FileConfiguration fc;

    public static McUtilities plugin;

    {
        loadConfiguration();
        initConfig();
    }

    @Override
    public void onEnable() {
        plugin = this;


        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ChatEvent(), this);

        getLogger().info("Enabling...");

        if(!getServer().getPluginManager().isPluginEnabled("PlaceholderAPI")){
            getLogger().severe("This plugin requires PlaceholderAPI");
            getLogger().severe("Please install it for using the plugin");
            getLogger().severe("You can download it from here: https://www.spigotmc.org/resources/placeholderapi.6245/");
            getLogger().severe("Plugin disabled!!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        } else {
            getLogger().info("Plugin enabled!");
        }


        getCommand("fly").setExecutor((CommandExecutor) new FlyCommand());
        getCommand("gmc").setExecutor((CommandExecutor) new gmcCommand());
        getCommand("gms").setExecutor((CommandExecutor) new gmsCommand());
        getCommand("gma").setExecutor((CommandExecutor) new gmaCommand());
        getCommand("gmsp").setExecutor((CommandExecutor) new gmspCommand());
        getCommand("utilities").setExecutor((CommandExecutor) new mcutilitiesCommand());

    }

    @Override
    public void onDisable() {
        //nothing
    }



    private void loadConfiguration() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        getConfig().options().copyDefaults(false);
    }

    public void initConfig() {

        fc = getConfig();
    }



    public static McUtilities getInstance() {

        return plugin;
    }
}
