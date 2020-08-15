package ml.axegis.setspawn.commands;

import ml.axegis.setspawn.Helper;
import ml.axegis.setspawn.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Spawn implements CommandExecutor {

    private Plugin plugin = Main.getPlugin(Main.class);

    private String pathLocation = "SetSpawn.Location.";
    private String pathMessages = "SetSpawn.Messages.";
    private String pathPermissions = "SetSpawn.Permissions.";

    Helper helper = new Helper();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String spawnPermission = plugin.getConfig().getString(pathPermissions + "spawn");
        String noPermissionsMessage = helper.getConfigMessage(pathMessages + "no_permissions");
        String noConsoleCommandMessage = helper.getConfigMessage(pathMessages + "no_console_command");

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(spawnPermission)) {
                teleportPlayer(player);
            } else {
                player.sendMessage(noPermissionsMessage);
            }
        } else {
            sender.sendMessage(noConsoleCommandMessage);
        }
        return true;
    }

    public boolean validateConfigLocation() {
        Boolean hasX = plugin.getConfig().isSet(pathLocation + "X");
        Boolean hasY = plugin.getConfig().isSet(pathLocation + "Y");
        Boolean hasZ = plugin.getConfig().isSet(pathLocation + "Z");

        Boolean hasYaw = plugin.getConfig().isSet(pathLocation + "Yaw");
        Boolean hasPitch = plugin.getConfig().isSet(pathLocation + "Pitch");

        if (hasX && hasY && hasZ && hasYaw && hasPitch) {
            return true;
        }
        return false;
    }

    public void teleportPlayer(Player player) {
        String noSpawnLocationMessage = helper.getConfigMessage(pathMessages + "no_spawn_location");
        String teleportingSpawnMessage = helper.getConfigMessage(pathMessages + "teleporting_spawn");

        Boolean isValidConfig = validateConfigLocation();

        if (!isValidConfig) {
            player.sendMessage(noSpawnLocationMessage);
            return;
        }

        // Get location from config
        Double x = plugin.getConfig().getDouble(pathLocation + "X");
        Double y = plugin.getConfig().getDouble(pathLocation + "Y");
        Double z = plugin.getConfig().getDouble(pathLocation + "Z");

        // Get yaw and pitch from config
        Integer yaw = plugin.getConfig().getInt(pathLocation + "Yaw");
        Integer pitch = plugin.getConfig().getInt(pathLocation + "Pitch");

        // Create spawn location from config data
        Location spawn = new Location(player.getWorld(), x, y, z);

        // Convert intBitsToFloat
        Float fYaw = Float.intBitsToFloat(yaw);
        Float fPitch = Float.intBitsToFloat(pitch);

        // Set the yaw and pitch on the location
        spawn.setYaw(fYaw);
        spawn.setPitch(fPitch);

        // Teleport player to location
        player.teleport(spawn);

        player.sendMessage(teleportingSpawnMessage);
    }

}
