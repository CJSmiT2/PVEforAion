/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aionxmlparser.tmp2;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author smit
 */
public class XMLConverterUtil {
    
    public static void toXml(NpcDrops npcDrops, File file){
        
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(NpcDrops.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(npcDrops, file);
//            jaxbMarshaller.marshal(npcDrops, System.out);
        }catch(JAXBException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public static NpcDrops toObject(File file){
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(NpcDrops.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            NpcDrops npcDrops = (NpcDrops) jaxbUnmarshaller.unmarshal(file);
            return npcDrops;

	  } catch (JAXBException ex) {
		throw new RuntimeException(ex);
	  }
    }
}
