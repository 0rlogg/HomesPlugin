package me.orlogg.homesplugin.commands;

import me.orlogg.homesplugin.HomesPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import javax.annotation.Nonnull;


public class Home implements CommandExecutor {

    private final HomesPlugin plugin;

    public Home (HomesPlugin plugin){
        this.plugin = plugin;
    }

    @Override

    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command,@Nonnull  String label,@Nonnull  String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Player only command!");
            return false;

        }

        if(args.length == 0){
                player.sendMessage("You need to give a name");
                return false;

            }

            String name = args[0].toLowerCase();
            if (plugin.getConfig().get(name) == null){
                player.sendMessage("No hay ningun home con este number");
                return false;

            }
            double x = plugin.getConfig().getDouble(name + ".X");
            double y = plugin.getConfig().getDouble(name + ".Y");
            double z = plugin.getConfig().getDouble(name + ".Z");
            float pitch = (float) plugin.getConfig().getDouble(name + ".Pitch");
            float yaw = (float) plugin.getConfig().getDouble(name + ".Yaw");
            String world = plugin.getConfig().getString(name + "World");

            Location location;
            location = new Location(Bukkit.getWorld(name), x, y, z, yaw, pitch);
        player.sendMessage(ChatColor.RED + "Abres tu diario, en el ves un mapa y la ruta para llegar hasta tu destino");
        player.sendMessage(ChatColor.GREEN + "Tu destino: " + ChatColor.DARK_GRAY + name + ChatColor.GREEN + " esta en las coordenadas: ");
            player.sendMessage(ChatColor.GREEN + "X:" + x);
            player.sendMessage(ChatColor.GREEN + "Y: " + y);
            player.sendMessage(ChatColor.GREEN + "Z: " + z);


        return true;
    }
 }

