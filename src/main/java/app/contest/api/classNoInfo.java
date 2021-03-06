/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.contest.api;

import app.contest.model.ClassInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author igogo
 */
@RestController
public class classNoInfo {

//    @Value("${name}")
//    private String name;
    private static final Logger logger = LoggerFactory.getLogger(classNoInfo.class);
    private ArrayList<ClassInfo> classCollections = new ArrayList<>();

    private ObjectMapper mapper = new ObjectMapper();

    //年級別 3,4,5,6
    @Value("#{'${classinfo.grades}'.split(',')}")
    private String[] classinfoGrades;

    //班別 甲乙丙丁
    @Value("#{'${classinfo.numbers}'.split(',')}")
    private String[] classinfoNos;

    //座號
    @Value("#{'${classinfo.seats}'}")
    private int classinfoSeats;

    @RequestMapping("/classinfo")
    public ArrayList<ClassInfo> getClassNo() throws JsonProcessingException {
//        logger.info("get name:" + this.name);
        classCollections.clear();
//        String[] classnos = new String[7];
//        classnos[0] = "甲";
//        classnos[1] = "乙";
//        classnos[2] = "丙";
//        classnos[3] = "丁";
//        classnos[4] = "戊";
//        classnos[5] = "己";
//        classnos[6] = "庚";

        String classname;

        //每班估30人
        ArrayList<String> seatCollections = new ArrayList<>();
        for (int x = 1; x < classinfoSeats + 1; x++) {
            String seatno = String.format("%02d", x);

            seatCollections.add(seatno);
        }

        for (String classinfoGrade : classinfoGrades) {
            for (String classinfoNo : classinfoNos) {
                ClassInfo classinfo = new ClassInfo();
                classname = String.format("%s年%s班", classinfoGrade, classinfoNo);

                classinfo.setClassName(classname);
                classinfo.setClassNo(String.format("%s", classname));

                classinfo.setSeatCollections(seatCollections);
                classCollections.add(classinfo);
                classinfo = null;
            }
        }

//        for (int i = 5; i <= 6; i++) {
//            int j = 1;
//            for (String classno : classinfoNos) {
//                ClassInfo classinfo = new ClassInfo();
//
//                classname = String.format("%s年%s班", i, classno);
//
//                classinfo.setClassName(classname);
//                classinfo.setClassNo(String.format("%s%s", i, j));
////                logger.info(classname);
////                logger.info(mapper.writeValueAsString(classinfo));
//
//                classinfo.setSeatCollections(seatCollections);
//                j++;
//                classCollections.add(classinfo);
//
//                classinfo = null;
//
//            }
//
//        }
        for (ClassInfo classinfo : classCollections) {
//            logger.info(classinfo.getClassName());

        }

        return classCollections;
    }

}
