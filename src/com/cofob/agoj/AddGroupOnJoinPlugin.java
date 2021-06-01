package com.cofob.agoj;

import com.cofob.agoj.listener.PlayerFirstJoinListener;
import net.luckperms.api.LuckPerms;
import org.bukkit.plugin.java.JavaPlugin;

public class AddGroupOnJoinPlugin extends JavaPlugin {
    public String version;

    @Override
    public void onEnable() {
        version = "v0.0.1";
        LuckPerms luckPerms = getServer().getServicesManager().load(LuckPerms.class);
        System.out.println();
        System.out.println("      ___           ___           ___                ");
        System.out.println("     /\\  \\         /\\__\\         /\\  \\        ___    ");
        System.out.println("    /::\\  \\       /:/ _/_       /::\\  \\      /\\__\\   ");
        System.out.println("   /:/\\:\\  \\     /:/ /\\  \\     /:/\\:\\  \\    /:/__/   ");
        System.out.println("  /:/ /::\\  \\   /:/ /::\\  \\   /:/  \\:\\  \\  /::\\  \\   ");
        System.out.println(" /:/_/:/\\:\\__\\ /:/__\\/\\:\\__\\ /:/__/ \\:\\__\\ \\/\\:\\  \\  ");
        System.out.println(" \\:\\/:/  \\/__/ \\:\\  \\ /:/  / \\:\\  \\ /:/  /  ~~\\:\\  \\ ");
        System.out.println("  \\::/__/       \\:\\  /:/  /   \\:\\  /:/  /      \\:\\__\\");
        System.out.println("   \\:\\  \\        \\:\\/:/  /     \\:\\/:/  /       /:/  /");
        System.out.println("    \\:\\__\\        \\::/  /       \\::/  /       /:/  / ");
        System.out.println("     \\/__/         \\/__/         \\/__/        \\/__/  ");
        System.out.println();
        System.out.println("|      AGOJ by cofob");
        System.out.println("|      Updates here https://git.3301.su/cofob/addGroupOnJoin");
        System.out.println("|      VERSION: "+version);
        new PlayerFirstJoinListener(this, luckPerms).register();
        System.out.println();
    }
}
