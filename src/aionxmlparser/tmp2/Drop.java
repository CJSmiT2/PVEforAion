/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aionxmlparser.tmp2;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author smit
 */
@XmlRootElement
public class Drop {
    String chance;
    int item_id;
    int max_amount;
    int min_amount;

    public String getChance() {
        return chance;
    }

    @XmlAttribute (name = "chance")
    public void setChance(String chance) {
        this.chance = chance;
    }

    public int getItem_id() {
        return item_id;
    }

    @XmlAttribute (name = "item_id")
    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getMax_amount() {
        return max_amount;
    }

    @XmlAttribute (name = "max_amount")
    public void setMax_amount(int max_amount) {
        this.max_amount = max_amount;
    }

    public int getMin_amount() {
        return min_amount;
    }

    @XmlAttribute (name = "min_amount")
    public void setMin_amount(int min_amount) {
        this.min_amount = min_amount;
    }
    
    
}
