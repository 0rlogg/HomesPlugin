package me.orlogg.homesplugin.commands;

import me.orlogg.homesplugin.HomesPlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class HomeCommand implements CommandExecutor {
    private final HomesPlugin plugin;

    public HomeCommand (HomesPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {

            File file = new File("plugins/HomesPlugin", "configuration.yml");

            YamlConfiguration fm = YamlConfiguration.loadConfiguration(file);

            int test = fm.getInt("name");

        }else {

            System.out.println("uwu");
        }
        return true;
    }
}