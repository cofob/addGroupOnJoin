package com.cofob.agoj.listener;

import com.cofob.agoj.AddGroupOnJoinPlugin;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;

import net.luckperms.api.node.Node;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static org.bukkit.Bukkit.getServer;

public class PlayerFirstJoinListener{
    private final AddGroupOnJoinPlugin plugin;
    private final LuckPerms luckPerms;
    private final String perm;

    public PlayerFirstJoinListener(AddGroupOnJoinPlugin plugin, LuckPerms luckPerms, String permission) {
        this.plugin = plugin;
        this.luckPerms = luckPerms;
        this.perm = permission;
    }

    public void register() {
        getServer().getPluginManager().registerEvents(new EventsListener(), this.plugin);
    }

    private class EventsListener implements Listener {
        @EventHandler
        public void onPlayerJoin(PlayerJoinEvent e) {
            User user = luckPerms.getUserManager().getUser(e.getPlayer().getUniqueId());
            Node node = Node.builder(perm).build();
            user.data().add(node);
            luckPerms.getUserManager().saveUser(user);
        }
    }
}
