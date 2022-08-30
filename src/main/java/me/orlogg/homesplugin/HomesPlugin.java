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
        //TODO Change the commands names
        //TODO Add a getcommand for delete homes
        //TODO Add a getcommand for see a list of locations created by the player
        //TODO ASAP Apply hashmap instead of using configuration files for the treatment of the data
    }

    private void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}




