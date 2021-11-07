package com.namu.suram.sitandlay;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class SitAndLay extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new Sit(this), this);
        getCommand("fly").setExecutor(new Fly());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
