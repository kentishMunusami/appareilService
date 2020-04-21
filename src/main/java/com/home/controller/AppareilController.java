package com.home.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @PostMapping("new")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public ResponseEntity insertDocument(@RequestBody Appareil appareil){
    	appareilService.saveAppareil(appareil);
    	return ResponseEntity.ok(appareil);       
    }

}
