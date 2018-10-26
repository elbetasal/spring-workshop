package org.developer.elbetasal.examples.spel.location;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DistanceService {

	@Value("#{systemProperties['app.call.google'] ? google : haversine}")
	private LocationService locationService;

	public Double calculateDistance(Double lat , Double lon){
		return locationService.calculateDistance(lat , lon);
	}

	interface LocationService {
		Double calculateDistance(Double lat , Double lon);
	}

	@Service("haversine")
	public static class HaversineLocationService implements LocationService{

		@Override
		public Double calculateDistance(Double lat, Double lon) {
			System.out.println("Calling haversine");
			return new Random().nextDouble();
		}
	}

	@Service("google")
	public static class GoogleLocationService implements LocationService{

		@Override
		public Double calculateDistance(Double lat, Double lon) {
			System.out.println("Calling google");
			return new Random().nextDouble();
		}
	}

}
