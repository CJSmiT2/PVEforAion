/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author smit
 */
public class DropPercentEditor {
    
    public static void main(String[] args) {
        System.out.println("Aion drop editor v0.1 by SmiT started!");
        System.out.println("Enter path for folder with files:");
        
        String path = readInput();

        
        File folder = new File(path);
        if (!folder.exists()) {
            System.err.println("Folder not found!" + folder.getAbsolutePath());
            System.exit(1);
        }
        
        
        System.out.println("Enter item_id: ");
        String itemId = readInput();
        System.out.println("Enter percent: ");
        String percent = readInput();
        
        ArrayList<File> xmlFiles = FilesUtil.getFilesInFolder(folder.getAbsolutePath());
        
        for (File file:xmlFiles){
            if (file.getName().contains(".xml")){
                XmlEditor editor = new XmlEditor(itemId, percent, file);
            }
            
        }
        
        System.out.println("Complete and exit!");
 
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
