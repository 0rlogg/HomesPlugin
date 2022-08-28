package me.orlogg.homesplugin;

import me.orlogg.homesplugin.commands.HomeCommand;
import me.orlogg.homesplugin.commands.SetHomeCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class HomesPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        //Allows to use a .yml file to save the coords.
        getConfig().options().copyDefaults();
        saveConfig();

        Objects.requireNonNull(getCommand("sethome")).setExecutor(new SetHomeCommand(this));
        Objects.requireNonNull(getCommand("home")).setExecutor(new HomeCommand(this));



    }
}
