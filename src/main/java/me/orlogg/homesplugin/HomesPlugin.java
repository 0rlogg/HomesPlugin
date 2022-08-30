package me.orlogg.homesplugin;

import me.orlogg.homesplugin.commands.Home;
import me.orlogg.homesplugin.commands.SetHomeCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;


public class HomesPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        loadConfig();
        new SetHomeCommand(this);
        new Home(this);
        Objects.requireNonNull(getCommand("SetHome")).setExecutor(new SetHomeCommand(this));
        Objects.requireNonNull(getCommand("Home")).setExecutor(new Home(this));

    }

    private void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}




