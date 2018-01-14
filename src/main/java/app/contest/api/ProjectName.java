/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.contest.api;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author igogo
 */
@RestController
public class ProjectName {

    @Value("#{'${project.names}'.split(',')}")
    private String[] projectNames;

    @RequestMapping("/projectnames")
    public ArrayList<String> getProjectNames() {
        return new ArrayList<>(Arrays.asList(projectNames));
    }
}
