package net.testaholic.brewery.controller.rest_controller;

import net.testaholic.brewery.domain.visit.Visit;
import net.testaholic.brewery.service.visit.VisitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Collection;


/**
 * Created by williamrussell on 6/18/16.
 */

@Controller
@EnableWebMvc
@RequestMapping("/v1/")
public class TotalVisitController {

    private VisitService visitService;




    @Autowired
    public TotalVisitController(VisitService visitService) {
        this.visitService = visitService;
    }


    @ResponseBody
    @RequestMapping("/enter")
    public Visit addVisitEnter() {
        Visit visit = new Visit();
        visit.setEnter("enter");
        return visitService.create(visit);
    }

    @ResponseBody
    @RequestMapping("/exit")
    public Visit addVisitExit() {
        Visit visit = new Visit();
        visit.setExit("exit");
        return visitService.create(visit);
    }

    @ResponseBody
    @RequestMapping("/totalEnters")
    public Collection<Visit> getAllEnters() {
        return visitService.getAllEnters("enter");
    }

    @ResponseBody
    @RequestMapping("/totalExits")
    public Collection<Visit> getAllExits() {
        return visitService.getAllExits("exit");
    }

}