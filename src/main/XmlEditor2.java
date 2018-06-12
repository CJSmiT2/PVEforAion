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
class XmlEditor2 {

    XmlEditor2(String itemId, ArrayList<File> xmlFiles) {
        int id = Integer.valueOf(itemId);
        boolean found = scanning(id, xmlFiles);
        
        if (found){
            editing(id, xmlFiles);
        } else {
            System.out.println("The item_id not found!");
            System.exit(1);
        }
        
    }
    
    private boolean scanning(int id, ArrayList<File> xmlFiles){
        boolean found = false;
        int count = 0;
        
        System.out.println("Starting scanning...");
        for (File file:xmlFiles){
            NpcDrops drops = XMLConverterUtil.toObject(file);
            
            for (NpcDrop npcDrop:drops.npc_drop){
                for (DropGroup dropGroup:npcDrop.drop_group){
                    for (Drop drop:dropGroup.drop){
                        if (drop.item_id==id){

                            System.out.println("npc_id: " + npcDrop.npc_id + " chance: " + drop.chance + "%");
                            count++;
                            found = true;
                        }
                    }
                }
            }
        }
        
        System.out.println("Scanning complete! Npc count: " + count);
        
        return found;
    }

    private void editing(int id, ArrayList<File> xmlFiles) {
        System.out.println("Starting editing...");
        for (File file:xmlFiles){
            NpcDrops drops = XMLConverterUtil.toObject(file);
            
            boolean found = false;
            for (NpcDrop npcDrop:drops.npc_drop){
                for (DropGroup dropGroup:npcDrop.drop_group){
                    for (Drop drop:dropGroup.drop){
                        if (drop.item_id==id){

                            System.out.println("npc_id: " + npcDrop.npc_id + " chance: " + drop.chance + "%. Enter new percent: ");
                            String input = DropPercentEditor.readInput();
                            if (input.length()>0){
                                drop.chance = input;
                                System.out.println("Chance editet to - " + drop.chance + "%");
                            }
                            
                            found = true;
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
        
        System.out.println("Editing complete!");
        
    }
    
}
