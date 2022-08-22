package com.github.ytshiyugh.diamondrandomplace;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class FindDiamondPlace implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label,String[] args){
        if(!(sender instanceof Player)){
            return false;
        }

        String worldName;
        try{
            worldName = args[0];
        }catch (Exception e){
            sender.sendMessage("FDP Error:Arguments not enough.");
            return false;
        }
        //write here
        int total= 0;

        for(int y=0;y>-51;y--) {
            for (int x = -161; x < 161; x++) {
                for (int z = -161; z < 161; z++) {
                    String block = Bukkit.getWorld(worldName).getBlockAt(x,y,z).getType().toString();
                    if(block.toLowerCase(Locale.ROOT).contains("diamond")){
                        /*debug
                        System.out.println("x:"+x+"/y:"+y+"/z:"+z+"/block:"+block);
                        sender.sendMessage("x:"+x+"/y:"+y+"/z:"+z+"/block:"+block);
                         */
                        total += 1;
                    }
                }
            }
        }

        sender.sendMessage(total+" diamonds found from the region.");

        int not_enough = 5500 - total;

        not_enough = not_enough - (not_enough % 2);

        PlaceCommand PC = new PlaceCommand();
        sender.sendMessage(not_enough+" blocks will be placed.");
        PC.place(args,(Player)sender,not_enough);


        return true;
    }
}
