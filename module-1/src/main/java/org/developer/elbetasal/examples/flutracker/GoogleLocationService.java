package org.developer.elbetasal.examples.flutracker;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;


import com.google.common.collect.ImmutableSet;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static com.google.common.collect.Sets.newHashSet;

@Service
public class GoogleLocationService {

	private static final Collection<AddressComponentType> ADDRESS_COMPONENT_TYPE_FOR_COUNTRY =
			ImmutableSet.of(AddressComponentType.COUNTRY, AddressComponentType.POLITICAL);

	private static final Collection<AddressComponentType> ADDRESS_COMPONENT_TYPE_FOR_STATE =
			ImmutableSet.of(AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_1, AddressComponentType.POLITICAL);

	private static final Collection<AddressType> ADDRESS_TYPE_FOR_STATES =
			ImmutableSet.of(AddressType.ADMINISTRATIVE_AREA_LEVEL_1, AddressType.POLITICAL);
	private final GeoApiContext geoApiContext;

	public GoogleLocationService() {
		geoApiContext =new GeoApiContext.Builder()
				.apiKey("AIzaSyA0dUoRLqEFe0Q_g2dH7xG3fyVRJgzpORk")
				.disableRetries()
				.build();
	}

	public Optional<Location> getLocation(float latitude , float longitude){
		Optional<Location> location = Optional.empty();
		LatLng latLong = new LatLng(latitude , longitude);
		try {
			GeocodingResult[] result = GeocodingApi
					.reverseGeocode(geoApiContext, latLong)
					.resultType(AddressType.ADMINISTRATIVE_AREA_LEVEL_1)
					.await();

			for(GeocodingResult geocodingResult : result){

				if(newHashSet(geocodingResult.types).containsAll(ADDRESS_TYPE_FOR_STATES)){
					String stateName = null;
					String stateShortName = null;
					String country = null;
					String countryCode = null;
					for(AddressComponent addressComponent : geocodingResult.addressComponents){

						if(isAddressComponentOfTypeOfState(addressComponent)){
							stateName = addressComponent.longName ;
							stateShortName = addressComponent.shortName;
						}

						if (isAddressComponentOfTypeCountry(addressComponent)) {
							country = addressComponent.longName;
							countryCode = addressComponent.shortName;
						}
					}

					if (StringUtils.hasText(stateName)
						&& StringUtils.hasText(stateShortName)
					  && StringUtils.hasText(country)
					  && StringUtils.hasText(countryCode)) {
						location = Optional.of(Location
								.builder()
								.stateName(stateName)
								.stateShortName(stateShortName)
								.country(country)
								.countryCode(countryCode)
								.build());
						break;
					}
				}
			}
		} catch (ApiException | InterruptedException | IOException e) {
		}
		return location;
	}

	private boolean isAddressComponentOfTypeOfState(AddressComponent addressComponent) {
		return newHashSet(addressComponent.types)
				.containsAll(ADDRESS_COMPONENT_TYPE_FOR_STATE);
	}

	private static boolean isAddressComponentOfTypeCountry(AddressComponent addressComponent) {
		return newHashSet(addressComponent.types)
				.containsAll(ADDRESS_COMPONENT_TYPE_FOR_COUNTRY);
	}
}
