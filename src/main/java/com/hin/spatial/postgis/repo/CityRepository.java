package com.hin.spatial.postgis.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hin.spatial.postgis.model.City;
import com.vividsolutions.jts.geom.Point;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

	// ERROR: function distancesphere(geometry, geometry) does not exist
	@Query(value="SELECT c from com.hin.spatial.postgis.model.City c where DistanceSphere(geom, :p) < :distanceM")
	List<City> findNearWithinDistance(Point p, double distanceM);
}
