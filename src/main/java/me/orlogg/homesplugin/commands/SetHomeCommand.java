package me.orlogg.homesplugin.commands;


import me.orlogg.homesplugin.HomesPlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import javax.annotation.Nonnull;
import java.util.Objects;

public class SetHomeCommand implements CommandExecutor{

    private final HomesPlugin Plugin;

    public SetHomeCommand (HomesPlugin Plugin){
        this.Plugin = Plugin;

    }

    @Override
    public boolean onCommand(@Nonnull CommandSender sender,@Nonnull  Command command,@Nonnull  String label,@Nonnull  String[] args) {

        if (!(sender instanceof Player player)){
            sender.sendMessage("Player only command!");
            return false;

        }
        if (!player.hasPermission("HomesPlugin.SetHomePlugin")){
            player.sendMessage("no tienes permisos");
        }
        if(args.length == 0){
            player.sendMessage("You need to give a name");
            return false;
        }
        String name = args[0].toLowerCase();
        if (Plugin.getConfig().get(name) != null){
            player.sendMessage("Ya hay un home con ese nombre");
            return false;

        }

        Location location = player.getLocation();
        Plugin.getConfig().set(name + ".World", Objects.requireNonNull(location.getWorld()).getName());
        Plugin.getConfig().set(name + ".X", location.getX());
        Plugin.getConfig().set(name + ".Y", location.getY());
        Plugin.getConfig().set(name + ".Z", location.getZ());
        Plugin.getConfig().set(name + ".Pitch", location.getPitch());
        Plugin.getConfig().set(name + ".Yaw", location.getYaw());
        Plugin.saveConfig();
        player.sendMessage("Home set");

        return true;
    }
}

