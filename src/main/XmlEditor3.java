/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author smit
 */
class XmlEditor3 {

    XmlEditor3(String percentForReplace, String newPercent, ArrayList<File> xmlFiles) {
        int count = 0;
        System.out.println("Starting replacing...");
        for (File file:xmlFiles){
            NpcDrops drops = XMLConverterUtil.toObject(file);
            
            boolean found = false;
            for (NpcDrop npcDrop:drops.npc_drop){
                for (DropGroup dropGroup:npcDrop.drop_group){
                    for (Drop drop:dropGroup.drop){
                        if (drop.chance.equalsIgnoreCase(percentForReplace)){
                            drop.chance = newPercent;
                            System.out.println("npc_id: " + npcDrop.npc_id+ " item_id:" + drop.item_id + " chance: " + percentForReplace + " replaced to: " + drop.chance);
                            found = true;
                            count++;
                        }
                    }
                }
            }
            
            if (found){
                System.out.println(file.getName()+ " Starting save files...");
                XMLConverterUtil.toXml(drops, file);
                System.out.println("Files success saved!");
            }
            
        }
        
        System.out.println("Result: " + count + " has been replaced!");
        System.out.println("Replacing complete!");
    }
    
}
