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
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smit
 */
public class DropPercentEditor {
    
    public static void main(String[] args) {
        System.out.println("Aion drop editor v0.3 by SmiT. Starting...");
        System.out.println("Enter path for folder with files (Enter to skip):");
        
        File folder = getFolderWithXmlFiles(readInput());
        
        System.out.println("Enter percent for replace: ");
        String percent = readInput();
        System.out.println("Enter new percent: ");
        String newPercent = readInput();
        
        ArrayList<File> xmlFiles = getXmlFiles(folder);
        
        XmlEditor3 editor = new XmlEditor3(percent, newPercent, xmlFiles);
        
        System.out.println("Complete and exit!");
 
    }

    public static String readInput() {
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
            return "";
        }

    }

    private static File getFolderWithXmlFiles(String path) {
        File folder = new File(path);
        if (!folder.exists()) {
            System.out.println("Folder not found! Trying to find files in current folder...");
            boolean result = xmlFilesExist();
            if (!result){
                System.err.println("Xml files fon found. Exit...");
                System.exit(1);
            } else {
                return getCurrentPath();
            }
        }
        throw new RuntimeException();
    }
    
    private static ArrayList<File> getXmlFiles(File folder){
        ArrayList<File> xmlFiles = new ArrayList();
        ArrayList<File> filesInFolder = FilesUtil.getFilesInFolder(folder);
        
        for (File file:filesInFolder){
            if (file.getName().contains(".xml")){
                xmlFiles.add(file);
            }
        }
        
        return xmlFiles;
    }

    private static boolean xmlFilesExist() {
        File folder = getCurrentPath();
        System.out.println("Current folder: " + folder.getAbsolutePath());
        ArrayList<File> files = FilesUtil.getFilesInFolder(folder);
        for (File file:files){
            if (file.getName().contains(".xml")){
                return true;
            }
        }
        return false;
    }
    
    private static File getCurrentPath(){
        try {
            return new File(DropPercentEditor.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile();
        } catch (URISyntaxException ex) {
            Logger.getLogger(DropPercentEditor.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException();
        }
    }
    
}
