package org.developer.elbetasal.examples.flutracker;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Slf4j
public class GoogleLocationServiceTest {

	@Autowired
	private GoogleLocationService googleLocationService;

	@Test
	public void getLocation() {
		Optional<Location> location
				= googleLocationService.getLocation(21.05f, -89.64f);

		assertThat(location.isPresent() , is(true) );
		Location realLocation = location.get();
		assertThat(realLocation.getCountry() , is("Mexico"));
		assertThat(realLocation.getCountryCode() , is("MX"));
		assertThat(realLocation.getStateName() , is("Yucatan"));
		assertThat(realLocation.getStateShortName() , is("Yuc"));



	}

	@Test
	public void getSomethingElse (){
		log.info("Running something else");
	}
}