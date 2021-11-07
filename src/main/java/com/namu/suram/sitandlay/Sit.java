package com.namu.suram.sitandlay;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftLivingEntity;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class Sit implements Listener {

    JavaPlugin plugin;

    public Sit(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(PlayerInteractAtEntityEvent e){
        if (e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.OAK_STAIRS)){
            LivingEntity ent = (LivingEntity) e.getRightClicked();
            Arrow arrow = e.getPlayer().getWorld().spawnArrow(ent.getLocation().add(new Vector(0, -0.5, 0)), new Vector(0, 0, 0), 0, 0);
            arrow.addPassenger(ent);
        }
    }

    @EventHandler
    public void onClick2(PlayerInteractEvent e){
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.RED_BED)){
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        e.getPlayer().setGliding(true);
                        e.getPlayer().setFallDistance(0);
                    }
                }.runTaskTimer(plugin, 0, 0);
            }
        }
    }

}
