package com.example.demo.controller;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {


    private PersonDao dao;

    @Autowired
    public MainController(PersonDao dao) {
        this.dao = dao;
    }

    @RequestMapping("")
    public String index(){

        return "index";
    }

    @RequestMapping("/personform")
    public String showform(Model m){
        m.addAttribute("command", new Person());
        return "personform";
    }


    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("per") Person per){
        dao.save(per);
        return "redirect:/viewperson";//will redirect to viewperson request mapping
    }
    /* It provides list of personloyees in model object */
    @RequestMapping("/viewperson")
    public String viewperson(Model m){
        List<Person> list=dao.getPeople();
        m.addAttribute("list",list);
        return "viewperson";
    }
    /* It displays object data into form for the given id.
     * The @PathVariable puts URL data into variable.*/
    @RequestMapping(value="/editperson/{id}")
    public String edit(@PathVariable int id, Model m){
        Person person=dao.getPersonById(id);
        m.addAttribute("command",person);
        return "personeditform";
    }
    /* It updates model object. */
    @RequestMapping(value="/editperson/editsave",method = RequestMethod.POST)
    public String editsave(@ModelAttribute("person") Person person){
        dao.update(person);
        return "redirect:/viewperson";
    }
    /* It deletes record for the given id in URL and redirects to /viewperson */
    @RequestMapping(value="/deleteperson/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        dao.delete(id);
        return "redirect:/viewperson";
    }
}