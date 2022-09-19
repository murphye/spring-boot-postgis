package com.hin.spatial.postgis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.hin.spatial.postgis.model.City;
import com.hin.spatial.postgis.service.CityService;

@RestController
@RequestMapping("city")
public class CityController {

	@Autowired
	CityService service;
	
	@GetMapping
	public Page<City> getCityPage(Pageable pageable){
		return service.findAll(pageable);
	}
	
	@GetMapping("{lat}/{lon}/{distanceM}")
	public List<City> getCityNear(
			@PathVariable double lat, 
			@PathVariable double lon, 
			@PathVariable double distanceM){
		return service.findAround(lat, lon, distanceM);
	}

	@Bean
	public JtsModule jtsModule() {
		// This module will provide a Serializer for geometries
		return new JtsModule();
	}
	
}
