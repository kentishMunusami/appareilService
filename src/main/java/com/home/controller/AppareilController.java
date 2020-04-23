package com.home.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.bean.Appareil;
import com.home.service.IAppareilService;

@RestController
@RequestMapping("/appareil")
public class AppareilController {
	
	@Autowired
	private IAppareilService appareilService;
	
	@GetMapping("/all")
	 public ResponseEntity findAbonnes() {
		 return ResponseEntity.ok(appareilService.getAppareils());
		 
	 }
	
	@ResponseBody
    @PostMapping()
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public ResponseEntity insertAppareil(@RequestBody Appareil appareil){
    	appareilService.saveAppareil(appareil);
    	return ResponseEntity.ok(appareil);       
    }
	
	@ResponseBody
    @PutMapping()
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public ResponseEntity updateAppareil(@RequestBody Appareil appareil){
    	appareilService.saveAppareil(appareil);
    	return ResponseEntity.ok(appareil);       
    }
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public ResponseEntity deleteAppareil(@PathVariable("id") int id){
    	appareilService.delete(id);
    	return ResponseEntity.ok(appareilService.getAppareils());      
    }

}
