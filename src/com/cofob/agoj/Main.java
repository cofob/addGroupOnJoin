package com.cofob.agoj;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public class Main extends JavaPlugin {
    public static void main (String[] string){}

    @Override
    public void onEnable() {
        Logger log = getLogger();
        log.info("Loaded");
        getServer().getPluginManager().registerEvents(new EventsListener(), this);
    }
}