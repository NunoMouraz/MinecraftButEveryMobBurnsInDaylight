package com.gmail.nunomouraxd.plugin;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        // List of burnable mobs by default
        EntityType[] burnableMobs = new EntityType[]{EntityType.SKELETON, EntityType.ZOMBIE, EntityType.PHANTOM};

        // Every second
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {

            // Get every entity in every world
            for (World world : Bukkit.getWorlds()) {
                for (Entity entity : world.getLivingEntities()) {

                    // If is a mob, isn't burnable by default, and it is in daylight
                    if (entity instanceof Mob && !Arrays.asList(burnableMobs).contains(entity.getType()) && entity.getLocation().getBlock().getLightFromSky() == 15) {
                        entity.setFireTicks(20);
                    }

                }
            }
        }, 0, 20L);
    }

}
