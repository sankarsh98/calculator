package com.sankarsh.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sankarsh.beans.CalculatorBean;
import com.sankarsh.service.CalculatorService;



@RestController
public class CalculatorController {
	
	@Autowired
	CalculatorService service;

	@RequestMapping(value="/",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> get(){
		return new ResponseEntity<String>("Welcome to calculator",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/calculate",method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map> calculate(@RequestBody CalculatorBean bean){
		double ans;
		Map<String,Number> result=new HashMap<>();
		Map<String,String> error=new HashMap<String, String>();
		try {
		  ans=service.result(bean);
		  if(bean.getType().equalsIgnoreCase("integer")) {
			  result.put("result",(int)ans);
		  }else {
			  result.put("result",ans);
		  }
		}catch(Exception e) {
			error.put("error",e.getMessage());
			return new ResponseEntity<Map>(error,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Map>(result,HttpStatus.OK);
	}


}
