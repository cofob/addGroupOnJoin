package com.cofob.agoj;

import com.cofob.agoj.listener.PlayerFirstJoinListener;
import com.cofob.agoj.yaml.PluginConfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import net.luckperms.api.LuckPerms;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;


public class AddGroupOnJoinPlugin extends JavaPlugin {
    public String version;

    @Override
    public void onEnable() {
        File test = new File("!/plugin.yml");
        BufferedReader f = null;
        try {
            f = new BufferedReader(new FileReader( test.getAbsoluteFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            assert f != null;
            System.out.println(f.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        creating folders
        File plugins_folder = new File("plugins");
        File home_folder = new File(plugins_folder, "cofob");
        if (!home_folder.exists()){home_folder.mkdir();}
        File base_folder = new File(home_folder, "agoj");
        if (!base_folder.exists()){base_folder.mkdir();}
        File config_file = new File(base_folder, "config.yml");
        if (!config_file.exists()){
            try {
                config_file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        reading config
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        mapper.findAndRegisterModules();
        PluginConfig config = null;
        try {
            config = mapper.readValue(config_file, PluginConfig.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert config != null;
        System.out.println(ReflectionToStringBuilder.toString(config, ToStringStyle.MULTI_LINE_STYLE));

//        defining variables
        version = "v0.0.1";
        LuckPerms luckPerms = getServer().getServicesManager().load(LuckPerms.class);
        System.out.println();
        System.out.println("      ___           ___           ___                             ");
        System.out.println("     /\\  \\         /\\__\\         /\\  \\        ___           ");
        System.out.println("    /::\\  \\       /:/ _/_       /::\\  \\      /\\__\\          ");
        System.out.println("   /:/\\:\\  \\     /:/ /\\  \\     /:/\\:\\  \\    /:/__/        ");
        System.out.println("  /:/ /::\\  \\   /:/ /::\\  \\   /:/  \\:\\  \\  /::\\  \\       ");
        System.out.println(" /:/_/:/\\:\\__\\ /:/__\\/\\:\\__\\ /:/__/ \\:\\__\\ \\/\\:\\  \\ ");
        System.out.println(" \\:\\/:/  \\/__/ \\:\\  \\ /:/  / \\:\\  \\ /:/  /    \\:\\  \\  ");
        System.out.println("  \\::/__/       \\:\\  /:/  /   \\:\\  /:/  /      \\:\\__\\     ");
        System.out.println("   \\:\\  \\        \\:\\/:/  /     \\:\\/:/  /       /:/  /      ");
        System.out.println("    \\:\\__\\        \\::/  /       \\::/  /       /:/  /         ");
        System.out.println("     \\/__/         \\/__/         \\/__/        \\/__/           ");
        System.out.println();
        System.out.println("|      AGOJ by cofob");
        System.out.println("|      Updates here https://git.3301.su/cofob/addGroupOnJoin");
        System.out.println("|      VERSION: "+version);
        new PlayerFirstJoinListener(this, luckPerms).register();
        System.out.println();
    }
}
