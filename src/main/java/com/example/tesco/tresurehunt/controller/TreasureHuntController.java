/**
 * 
 */
package com.example.tesco.tresurehunt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tesco.tresurehunt.service.TresurehuntService;

/**
 * @author SESA568846
 *
 */
@RestController
@RequestMapping("tresure-hunt")
public class TreasureHuntController {
	
	@Autowired
	private TresurehuntService tresurehuntService;
	
	//POST REST API WHICH ACCEPTS MULTIDIMENTIONAL INPUT ARRAY
	@PostMapping
	public ResponseEntity<Object>  findTresure(@RequestBody int[][] tresureArray) {
	    return new ResponseEntity<Object>(tresurehuntService.findTresure(tresureArray),HttpStatus.OK);
    }

}
