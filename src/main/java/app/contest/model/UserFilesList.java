/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.contest.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author igogo
 */
public class UserFilesList {

    private ArrayList<String> filesList = new ArrayList<String>();
    private String userid;
    private String storageLocation;
    private String[] projectNames;
    private static final Logger logger = LoggerFactory.getLogger(UserFilesList.class);

    public UserFilesList(String userid, String storageLocation, String[] projectNames) {
        this.userid = userid;
        this.storageLocation = storageLocation;
        this.projectNames = projectNames;
        //預計改為 /storageLocation/projectName/5201/files
        
        if (Files.exists(Paths.get(storageLocation, userid))) {
            logger.info("directory exists." + userid);
            try {
                Files.walk(Paths.get(storageLocation, userid))
                        .forEach(userfile -> {
                            if (Files.isRegularFile(userfile)) {
                                logger.info("files:" + userfile.getFileName().toString());
                                filesList.add(userfile.getFileName().toString());
                            }
                        });
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(UserFilesList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public ArrayList<String> getFilesList() {
        return filesList;
    }

    public void setFilesList(ArrayList<String> filesList) {
        this.filesList = filesList;
    }



}
