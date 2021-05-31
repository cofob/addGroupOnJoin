package com.cofob.test;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public class Main extends JavaPlugin {
    public static void main (String[] string){
        System.out.println("Test");
    }

    @Override
    public void onEnable() {
        Logger log = getLogger();
        log.info("Мой первый плагин!");
        getServer().getPluginManager().registerEvents(new EventsListener(), this);
    }
}