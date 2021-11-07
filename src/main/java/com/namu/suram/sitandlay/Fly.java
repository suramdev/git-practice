package com.namu.suram.sitandlay;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player){
            Player player = ((Player) commandSender);
            if (player.getAllowFlight()){
                player.setAllowFlight(false);
            }else {
                player.setAllowFlight(true);
            }
        }
        return false;
    }
}
