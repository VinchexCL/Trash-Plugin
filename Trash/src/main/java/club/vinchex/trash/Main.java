package club.vinchex.trash;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("trash").setExecutor(new club.vinchex.trash.TrashCommand(this));
    }
}