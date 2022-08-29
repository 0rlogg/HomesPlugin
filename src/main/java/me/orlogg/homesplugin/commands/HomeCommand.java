package me.orlogg.homesplugin.commands;

import me.orlogg.homesplugin.HomesPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {
    private final HomesPlugin plugin;

    public HomeCommand (HomesPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {
            FileConfiguration Home = plugin.getConfig();
            Home.getLocation("config.yml");
            player.sendMessage(String.valueOf(Home));

        }else {

             System.out.println("uwu");
        }
        return true;
    }
}