package com.cofob.agoj;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import net.luckperms.api.*;

public class EventsListener implements Listener {
    private final LuckPerms luckPerms;

    public void addPermission(User user, String permission) {
        // Add the permission
        user.data().add(Node.builder(permission).build());

        // Now we need to save changes.
        LuckPerms luckPerms = LuckPerms().;
        luckPerms.getUserManager().saveUser(user);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        this.addPermission(e.getPlayer());
    }
}
