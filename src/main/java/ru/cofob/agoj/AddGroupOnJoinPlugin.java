package ru.cofob.agoj;

import ru.cofob.agoj.listener.PlayerFirstJoinListener;
import ru.cofob.agoj.yaml.PluginConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.nio.file.Files;
import java.util.Collections;


public class AddGroupOnJoinPlugin extends JavaPlugin {
    public String version;

    @Override
    public void onEnable() {
//        creating folders
        File plugins_folder = new File("plugins");
        File home_folder = new File(plugins_folder, "cofob");
        if (!home_folder.exists()){home_folder.mkdir();}
        File base_folder = new File(home_folder, "agoj");
        if (!base_folder.exists()){base_folder.mkdir();}
        File config_file = new File(base_folder, "config.yml");

        InputStream local_config_file = getClass().getResourceAsStream("/ru/cofob/agoj/config.yml");
        assert local_config_file != null;
        BufferedReader local_config = new BufferedReader(new InputStreamReader(local_config_file));
        StringBuilder local_config_text = new StringBuilder();
        String line = null;
        try {
            line = local_config.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true){
            if (line == null){
                break;
            }
            if (line.equals("")) break;
            local_config_text.append(line);
            try {
                line = local_config.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!config_file.exists()){
            try {
                config_file.createNewFile();
                Files.write(config_file.toPath(), Collections.singleton(local_config_text));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        reading config
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        PluginConfig config = null;
        try {
            config = mapper.readValue(config_file, PluginConfig.class);
        } catch (UnrecognizedPropertyException e) {
            System.out.println("|----- AGOJ ERROR -----\n|\n| ERROR ERROR ERROR ERROR ERROR\n| ERROR ERROR ERROR ERROR ERROR\n| ERROR ERROR ERROR ERROR ERROR\n| ");
            System.out.println("| INVALID CONFIG. YOU CAN GET LATEST HERE - \n|- https://git.3301.su/cofob/addGroupOnJoin/src/branch/master/src/com/cofob/agoj/config.yml\n|");
            System.out.println("| ERROR ERROR ERROR ERROR ERROR\n| ERROR ERROR ERROR ERROR ERROR\n| ERROR ERROR ERROR ERROR ERROR\n| \n|----------------------");
            Bukkit.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert config != null;

//        defining variables
        version = "v0.0.2";
        LuckPerms luckPerms = getServer().getServicesManager().load(LuckPerms.class);
        new PlayerFirstJoinListener(this, luckPerms, config.getPermission()).register();
        System.out.println("|");
        System.out.println("|         ___           ___           ___                             ");
        System.out.println("|        /\\  \\         /\\__\\         /\\  \\        ___           ");
        System.out.println("|       /::\\  \\       /:/ _/_       /::\\  \\      /\\__\\          ");
        System.out.println("|      /:/\\:\\  \\     /:/ /\\  \\     /:/\\:\\  \\    /:/__/        ");
        System.out.println("|     /:/ /::\\  \\   /:/ /::\\  \\   /:/  \\:\\  \\  /::\\  \\       ");
        System.out.println("|    /:/_/:/\\:\\__\\ /:/__\\/\\:\\__\\ /:/__/ \\:\\__\\ \\/\\:\\  \\ ");
        System.out.println("|    \\:\\/:/  \\/__/ \\:\\  \\ /:/  / \\:\\  \\ /:/  /    \\:\\  \\  ");
        System.out.println("|     \\::/__/       \\:\\  /:/  /   \\:\\  /:/  /      \\:\\__\\     ");
        System.out.println("|      \\:\\  \\        \\:\\/:/  /     \\:\\/:/  /       /:/  /      ");
        System.out.println("|       \\:\\__\\        \\::/  /       \\::/  /       /:/  /         ");
        System.out.println("|        \\/__/         \\/__/         \\/__/        \\/__/           ");
        System.out.println("|");
        System.out.println("|      AGOJ by cofob");
        System.out.println("|      Updates here https://git.3301.su/cofob/addGroupOnJoin");
        System.out.println("|      VERSION: "+version);
        System.out.println("|      PERMISSION: "+config.getPermission());
        System.out.println("|");
    }
}
