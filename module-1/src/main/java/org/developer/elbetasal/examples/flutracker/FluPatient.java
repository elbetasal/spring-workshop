package org.developer.elbetasal.examples.flutracker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FluPatient {

	@JsonProperty("user_name")
	private String userName;

	@JsonProperty("tweet_text")
	private String tweetText;

	private Float latitude;

	private Float longitude;

	@JsonProperty("tweet_date")
	private String tweetDate;

	private Long aggravation;

	private Location location;
}
