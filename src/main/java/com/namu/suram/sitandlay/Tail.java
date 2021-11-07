package com.namu.suram.sitandlay;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tail implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player){
            ((Player) commandSender).getWorld().createExplosion(((Player) commandSender).getLocation(), 1);
            return true;
        }
        return false;
    }
}
