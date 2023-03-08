package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.tlentity;

import com.example.demo.service.tlservice;
@CrossOrigin
@RestController

public class tlcontroller {

@Autowired //extends another class

tlservice stuService;

@PostMapping("/add")

public tlentity addInfo(@RequestBody tlentity st) {

return stuService.saveDetails(st);

}

@GetMapping("/show")

public List<tlentity>fetchDetails()

{

return stuService.getDetails();

}

@PutMapping("/Update")

public tlentity UpdateInfo(@RequestBody tlentity st1)

{

return stuService.UpdateDetails(st1);

}

@DeleteMapping("/Delete/{id}")

public String deleteInfo (@PathVariable("id")int id) {

stuService.deleteDetails(id);

return "Deleted details";

}
@GetMapping("/product/{field}")
public List<tlentity> getWithSort(@PathVariable String field) {
return stuService.getSorted(field);
		}

// pagination
@GetMapping("/product/{offset}/{pageSize}")
public List<tlentity> productsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
return stuService.getWithPagination(offset,pageSize);
		}
}
