/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author smit
 */
@XmlRootElement
public class DropGroup {
    String name;
    ArrayList<Drop> drop = new ArrayList();

    public ArrayList<Drop> getDrop() {
        return drop;
    }

    @XmlElement
    public void setDrop(ArrayList<Drop> drop) {
        this.drop = drop;
    }
    
    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }
    
    
}
