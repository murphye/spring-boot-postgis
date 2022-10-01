package com.hin.spatial.postgis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import org.locationtech.jts.geom.Point;

import lombok.Data;

@Data
@Entity(name = "us_cities")
public class City {

	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="`POP_2010`")
	private long population2010;
	
	@Column(name="`ELEV_IN_FT`")
	private long altitude;
	
	@Column(name="`geom`", columnDefinition = "Geometry(Point,4326)")
	private Point geom;

}
