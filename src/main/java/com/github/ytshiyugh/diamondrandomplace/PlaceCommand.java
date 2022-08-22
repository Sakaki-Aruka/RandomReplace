package com.github.ytshiyugh.diamondrandomplace;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.Locale;
import java.util.Random;

public class PlaceCommand{

    public boolean place(String args[],Player sender,int blocks){

        String world;
        try{
            world = args[0].toLowerCase(Locale.ROOT);
            if(!(world.equalsIgnoreCase("test") || world.equalsIgnoreCase("everyone") || world.equalsIgnoreCase("world"))){
                sender.sendMessage("DRP Error:World Name argument Error.");
                return false;
            }
        }catch (Exception e){
            sender.sendMessage("DRP Error:Arguments not enough.");
            return false;
        }

        int Loops = blocks / 2;
        int LoopCounter = 0;


        for (int i=0;i<Loops;i++){
            //
            Random random = new Random();

            //x and z -> 10 to 160
            int xPlus = random.nextInt(161) + 10;
            int zPlus = random.nextInt(161) + 10;

            // y -> -1 to -50
            int y = -1 * (random.nextInt(50) + 1);

            String block = Bukkit.getWorld(world).getBlockAt(xPlus,y,zPlus).getType().toString();
            if(block.toLowerCase(Locale.ROOT).contains("air")){
                //if the block of target is air or void_air
                continue;
            }
            System.out.println("x:"+xPlus+"/y:"+y+"/z:"+zPlus+"/Replaced DeepDiamond");

            Location replace = new Location(sender.getWorld(),(double)xPlus,(double)y,(double)zPlus);
            replace.getBlock().setType(Material.DIAMOND_ORE);

            i += 1;
            LoopCounter += 1;
            //BlockData blockData = Bukkit.createBlockData(Material.DEEPSLATE_DIAMOND_ORE);
            //Bukkit.getWorld("everyone").setBlockData(xPlus,y,zPlus,blockData);
        }

        for (int i=0;i<Loops;i++){
            Random random = new Random();

            int xMinus = -1 *(random.nextInt(161)) -10;
            int zMinus = -1 *(random.nextInt(161)) -10;

            int y = -1 * (random.nextInt(50 ) + 1);
            String block = Bukkit.getWorld(world).getBlockAt(xMinus,y,zMinus).getType().toString();
            if(block.toLowerCase(Locale.ROOT).contains("air")){
                continue;
            }
            System.out.println("x:"+xMinus+"/y:"+y+"/z:"+zMinus+"/Replaced DeepDiamond");

            Location replace = new Location(sender.getWorld(),(double)xMinus,(double)y,(double)zMinus);
            replace.getBlock().setType(Material.DIAMOND_ORE);

            i += 1;
            LoopCounter += 1;
            //BlockData blockData = Bukkit.createBlockData(Material.DEEPSLATE_DIAMOND_ORE);
            //Bukkit.getWorld("everyone").setBlockData(xMinus,y,zMinus,blockData);
        }
        sender.sendMessage(LoopCounter+" loops done.");

        int difference = blocks - LoopCounter;
        for(int i=0;i <= difference;i++){
            Random random = new Random();

            int X = random.nextInt(161)+10;
            int Z = random.nextInt(161+10);

            int Y = -1 * (random.nextInt(50)+1);

            if(random.nextBoolean()){
                X = -1 * X;
                if(random.nextBoolean()){
                    Z = -1 * Z;
                }
            }else{
                if(random.nextBoolean()){
                    Z = -1 * Z;
                }
            }
            System.out.println("x:"+X+"/y:"+Y+"/z:"+Z+"/Replaced DeepDiamond");

            Location replace = new Location(sender.getWorld(),(double)X,(double)Y,(double)Z);
            replace.getBlock().setType(Material.DIAMOND_ORE);
        }

        sender.sendMessage("Extra process placed "+difference+" diamond blocks.");

        return false;
    }
}
