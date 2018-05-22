/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aionxmlparser.tmp2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author smit
 */
public class DropPercentEditor {
    
    public static void main(String[] args) {
        System.out.println("Aion drop editor v0.1 by SmiT started!");
        System.out.println("Enter path for drop file:");
        
        String filePath = readInput();

        
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("File success found! " + file.getAbsolutePath());
        } else {
            System.err.println("File by path not found!" + file.getAbsolutePath());
            System.exit(1);
        }
        
        
        System.out.println("Enter item_id: ");
        String itemId = readInput();
        System.out.println("Enter percent: ");
        String percent = readInput();

        XmlEditor editor = new XmlEditor(itemId, percent, file);
 
    }

    private static String readInput() {
        String input = null;
        BufferedReader br = null;

        try {

            br = new BufferedReader(new InputStreamReader(System.in));
            input = br.readLine();


        } catch (IOException e) {
            e.printStackTrace();
        }
//        } finally {
//            if (br != null) {
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        
        if (input!=null){
            return input;
        } else {
            throw new RuntimeException("Input cannot be NULL!");
        }

    }
    
}
