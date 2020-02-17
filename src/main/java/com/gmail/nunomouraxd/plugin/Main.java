package com.gmail.nunomouraxd.plugin;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
            for (World world : Bukkit.getWorlds()) {
                for (Entity entity : world.getLivingEntities()) {
                    if (entity instanceof Mob && entity.getLocation().getBlock().getLightFromSky() == 15) {
                        entity.setFireTicks(20);
                    }
                }
            }
        }, 0, 20L);
    }

}
