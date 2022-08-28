package me.orlogg.homesplugin.commands;

import me.orlogg.homesplugin.HomesPlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHomeCommand implements CommandExecutor {

    private final HomesPlugin plugin;

    public SetHomeCommand(HomesPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {

            Location location = player.getLocation();
            plugin.getConfig().set("Home", location);
            plugin.saveConfig();
            player.sendMessage("Home location set!");

        }else {

            System.out.println("uwu");
        }
        return true;
    }
}
