package org.developer.elbetasal.examples.spel.operators;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Getter
public class ArithmeticsService {

	@Value("#{1 + 2}")
	private double add;

	@Value("#{'Hello' + 'World'}")
	private String concat;

	@Value("#{(2 + 2) * 2 + 9}")
	private double withBrackets;

	@Value("#{10 div 5}") //igual que /
	private double div;

	@Value("#{123 mod 5}") // igual que %
	private double mod;

	@Value("#{5 ^ 6}")
	private double power;

	@Value("#{${spel.numbertwo} + 2}")
	private double withProperty;

}
