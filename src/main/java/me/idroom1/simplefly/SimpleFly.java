package me.idroom1.simplefly;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleFly extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        getLogger().info("SimpleFly has been enabled");

        // Register the /fly command
        this.getCommand("fly").setExecutor(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("SimpleFly has been disabled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("fly")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("simplefly.fly")) {
                    if (player.getAllowFlight()) {
                        player.setAllowFlight(false);
                        player.sendMessage("Flying mode disabled.");
                    } else {
                        player.setAllowFlight(true);
                        player.sendMessage("Flying mode enabled.");
                    }
                    return true;
                } else {
                    player.sendMessage("You do not have permission to use this command.");
                    return true;
                }
            } else {
                sender.sendMessage("This command can only be run by a player.");
            }
        }
        return false;
    }
}