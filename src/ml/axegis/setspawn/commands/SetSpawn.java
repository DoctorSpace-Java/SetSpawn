package ml.axegis.setspawn.commands;

import ml.axegis.setspawn.Helper;
import ml.axegis.setspawn.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SetSpawn implements CommandExecutor {

    private Plugin plugin = Main.getPlugin(Main.class);
    private String pathLocation = "SetSpawn.Location.";
    private String pathMessages = "SetSpawn.Messages.";
    private String pathPermissions = "SetSpawn.Permissions.";

    Helper helper = new Helper();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String setSpawnPermission = plugin.getConfig().getString(pathPermissions + "setspawn");

        String spawnSetMessage = helper.getConfigMessage(pathMessages + "spawn_set");
        String noPermissionsMessage = helper.getConfigMessage(pathMessages + "no_permissions");
        String noConsoleCommandMessage = helper.getConfigMessage(pathMessages + "no_console_command");

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(setSpawnPermission)) {
                Location location = player.getLocation();
                saveLocation(location);
                player.sendMessage(spawnSetMessage);
            } else {
                player.sendMessage(noPermissionsMessage);
            }
        } else {
            sender.sendMessage(noConsoleCommandMessage);
        }
        return true;
    }

    public void saveLocation(Location location) {


        // Set the X, Y and Z location to config
        plugin.getConfig().set(pathLocation + "X", location.getX());
        plugin.getConfig().set(pathLocation + "Y", location.getY());
        plugin.getConfig().set(pathLocation + "Z", location.getZ());

        // Set the Yaw and Pitch to config
        plugin.getConfig().set(pathLocation + "Yaw", Float.floatToIntBits(location.getYaw()));
        plugin.getConfig().set(pathLocation + "Pitch", Float.floatToIntBits(location.getPitch()));

        // Save config
        plugin.saveConfig();
    }

}
