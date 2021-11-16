package com.example.assgn2.controller;

import com.example.assgn2.service.BSTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BSTController {
  @Autowired
  private BSTService bstService;

  @RequestMapping(method = RequestMethod.GET, value="/")
  public String greet() {
    return "Home Page for BST!";
  }

  @RequestMapping(method = RequestMethod.POST, value="/add/{key}")
  public String add(@PathVariable("key") int key) {
    bstService.add(key);
    return "Added " + key + " to BST.";
  }

  @RequestMapping(method = RequestMethod.DELETE, value="/delete/{key}")
  public String delete(@PathVariable("key") int key) {
    bstService.delete(key);
    return "Removed " + key + " from BST.";
  }

  @RequestMapping(method = RequestMethod.GET, value="/read")
  public List<Integer> read() {
    return bstService.read();
  }
}
