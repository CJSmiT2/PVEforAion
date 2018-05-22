/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aionxmlparser.tmp2;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author smit
 */
@XmlRootElement (name = "npc_drops")
public class NpcDrops {
    ArrayList<NpcDrop> npc_drop = new ArrayList();

    public ArrayList<NpcDrop> getNpc_drop() {
        return npc_drop;
    }

    @XmlElement
    public void setNpc_drop(ArrayList<NpcDrop> npc_drop) {
        this.npc_drop = npc_drop;
    }


    
    
    
}
