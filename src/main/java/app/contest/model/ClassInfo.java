/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.contest.model;

import java.util.List;

/**
 *
 * @author igogo
 */
public class ClassInfo {
    private String className;
    private String classNo;
    private List<String> seatCollections;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public List<String> getSeatCollections() {
        return seatCollections;
    }

    public void setSeatCollections(List<String> seatCollections) {
        this.seatCollections = seatCollections;
    }



  
    
}
