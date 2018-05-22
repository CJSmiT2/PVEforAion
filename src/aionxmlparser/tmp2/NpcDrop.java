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
@XmlRootElement (name = "npc_drop")
public class NpcDrop {
    
    int npc_id;
    ArrayList<DropGroup> drop_group = new ArrayList();

    public ArrayList<DropGroup> getDrop_group() {
        return drop_group;
    }

    @XmlElement
    public void setDrop_group(ArrayList<DropGroup> drop_group) {
        this.drop_group = drop_group;
    }
    
    
    
    
    public int getNpc_id() {
        return npc_id;
    }

    @XmlAttribute (name = "npc_id")
    public void setNpc_id(int npc_id) {
        this.npc_id = npc_id;
    }
    
    
    
}
