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
public class FilesUtil {
    public static ArrayList<File> getFilesInFolder(File folder){
        ArrayList<File> filesList = new ArrayList();
        
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                filesList.add(listOfFiles[i]);
            }
        }
        
        return filesList;
    }


}
