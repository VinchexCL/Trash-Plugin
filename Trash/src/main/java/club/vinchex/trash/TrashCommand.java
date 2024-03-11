package club.vinchex.trash;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class TrashCommand implements CommandExecutor {
    private final JavaPlugin plugin;

    public TrashCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Inventory inv = createInventory(player);
            player.openInventory(inv);
        }
        return false;
    }

    private Inventory createInventory(Player player) {
        FileConfiguration config = plugin.getConfig();
        String inventoryTitle = config.getString("title", "Trash");
        int inventorySize = config.getInt("slot", 45);
        return Bukkit.createInventory(null, inventorySize, inventoryTitle);
    }
}