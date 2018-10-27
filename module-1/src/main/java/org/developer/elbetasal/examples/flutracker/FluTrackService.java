package org.developer.elbetasal.examples.flutracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FluTrackService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private GoogleLocationService googleLocationService;

	public List<FluPatient> getAllPatientsWithSoreThroat() {
		final String url ="http://api.flutrack.org/?s=headache&&limit=1";
		return Arrays.asList(restTemplate.getForObject(url , FluPatient[].class))
				.stream()
				.map(a -> FluPatient
						.builder()
						.location(googleLocationService
								.getLocation(a.getLatitude() , a.getLongitude())
								.orElse(Location.builder().build()))
						.aggravation(a.getAggravation())
						.latitude(a.getLatitude())
						.longitude(a.getLongitude())
						.userName(a.getUserName())
						.tweetDate(a.getTweetDate())
						.tweetText(a.getTweetText())
						.build())
				.collect(Collectors.toList());
	}

}
