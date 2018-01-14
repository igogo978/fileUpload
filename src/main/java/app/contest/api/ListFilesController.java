/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.contest.api;

import app.contest.model.UserFilesList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author igogo
 */
@RequestMapping("/{userid}/listfiles")
@RestController
public class ListFilesController {
    
    private static final Logger logger = LoggerFactory.getLogger(ListFilesController.class);
    
    @Value("${storage.location}")
    private String storageLocation;
    
    @Value("#{'${project.names}'.split(',')}")
    private String[] projectNames;
    
    @RequestMapping(method = RequestMethod.GET)
    public UserFilesList listFiles(@PathVariable String userid) {
        logger.info("file location:" + this.storageLocation);
        
        for (String projectName : projectNames) {
            logger.info("projectName:" + projectName);
        }
        
        UserFilesList userFilesList = new UserFilesList(userid, this.storageLocation,projectNames);
//        userFilesList.getFilesCollection();
        return userFilesList;
    }
    
}
