package com.gersonsosa.projecteuler;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * @author <a href="mailto:gg.sosa@transportsystems.co">Gerson Sosa</a>
 */
public class PackagesWeightTest {
	@Test
	public void shouldReturnMinimumNumberOfTrips() {

		PackagesWeight packagesWeight = new PackagesWeight();
		Assertions.assertThat(packagesWeight.findMinimumTrips(100, new int[]{70,10,20})).isEqualTo(2);
		Assertions.assertThat(packagesWeight.findMinimumTrips(100, new int[]{90,100,100,10})).isEqualTo(3);
		Assertions.assertThat(packagesWeight.findMinimumTrips(100, new int[]{90,70,30,10})).isEqualTo(2);
		Assertions.assertThat(packagesWeight.findMinimumTrips(30, new int[]{10,20,25,30,5,15,15})).isEqualTo(4);
	}
}