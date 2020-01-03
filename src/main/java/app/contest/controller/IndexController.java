/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.contest.controller;

import app.contest.storage.StorageFileNotFoundException;
import app.contest.storage.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;

/**
 *
 * @author igogo
 */
@Controller
public class IndexController {
    
    private final StorageService storageService;
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    
    @Autowired
    public IndexController(StorageService storageService) {
        this.storageService = storageService;
    }
    
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("client", new File("/tmp/contest/exam.zip").exists());

        return "index";
    }
    
    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes, @RequestParam(value = "savedFileName", defaultValue = "unknown") String savedFileName, @RequestParam(value = "username", defaultValue = "unknown") String username, @RequestParam(value = "projectname", defaultValue = "unknown") String projectname) {
        
        logger.info("dirname:" + username);
        logger.info("project name:" + projectname);
        storageService.store(file, savedFileName, username);
        
        redirectAttributes.addFlashAttribute("message",
                "您已成功上傳檔案 " + savedFileName + file.getOriginalFilename());
        
        return "redirect:/";
    }
    
    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
    
}
