/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aionxmlparser.tmp2;

import java.io.File;

/**
 *
 * @author smit
 */
class XmlEditor {

    XmlEditor(String itemId, String percent, File file) {
        System.out.println("XmlEditor inited! Reading file..");
        
        int id = Integer.valueOf(itemId);
        NpcDrops drops = XMLConverterUtil.toObject(file);
        System.out.println("Data success readed!");
        
        System.out.println("Start searching!");
        boolean found = false;
        for (NpcDrop npcDrop:drops.npc_drop){
            for (DropGroup dropGroup:npcDrop.drop_group){
                for (Drop drop:dropGroup.drop){
                    if (drop.item_id==id){
                        
                        System.out.println("Found item_id in npc_id - " + npcDrop.npc_id + " old value '" + drop.chance + "' replaced to '" + percent + "'");
                        drop.chance = percent;
                        found = true;
                    }
                }
            }
        }
        
        if (found){
            System.out.println("Searching complete!");
            System.out.println("Start saving data to file!");
            XMLConverterUtil.toXml(drops, file);
            System.out.println("Data success saved! Complete and exit!");
        } else {
            System.out.println("item_id not found in file! Exit...");
        }
    }
    
}
