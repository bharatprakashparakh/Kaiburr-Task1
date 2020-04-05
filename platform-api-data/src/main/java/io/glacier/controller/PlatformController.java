package io.glacier.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.glacier.exception.ServiceException;
import io.glacier.model.*;
import io.glacier.repository.PlatformRepository;
import io.glacier.service.PlatformService;

import io.glacier.exception.*;

@RestController
public class PlatformController {
    
	@Autowired
	private PlatformService platformservice;
   
    //Find All Platforms present in database
	 @GetMapping("/platforms")
    public List<Platform> getAllPlatforms()
    {
    	return platformservice.getAllPlatforms();
    }
    
	 
    //Find Platform with unique id mentioned in url	
    @GetMapping("/platforms/{id}")

    public Platform getTopic(@PathVariable int id) throws ServiceException
	{
	
    return platformservice.getPlatform(id);

	}
    
     //Find all platforms with name mentioned in url
   
    @GetMapping("/platformname/{name}")

    public List<Platform> getPlatformByName(@PathVariable String name) throws ServiceException
	{
	
    
	     return platformservice.getPlatformByName(name);
    	
	} 
	     
	
    //Create a platform in a database with data provided together with url as JSON.
    @PostMapping("/platforms")
    public String addPlatform(@RequestBody Platform platform)
    {
    	return platformservice.addPlatform(platform);
    }
    
    
    //Delete a platform from database having id equal to id present in url.
    @DeleteMapping("/platforms/{id}")
    public String deletePlatform(@PathVariable int id)
  	{
  	
       return platformservice.deletePlatform(id);
  	}
     
    //Update a platform in a database having id equal to id provided in url.The data to be updated is also present in url as JSON.
    @PutMapping("/platforms/{id}")
    public String updatePlatform(@RequestBody Platform platform,@PathVariable int id)
	{
	   return  platformservice.updatePlatform(platform, id);
		
	}


}
