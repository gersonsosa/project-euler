package com.gersonsosa.projecteuler;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author <a href="mailto:gg.sosa@transportsystems.co">Gerson Sosa</a>
 */
public class DroneDeliveryTest {
	@Test
	public void shouldReturnGreaterFlightRangeAvailableDrones() {

		final List<DroneDelivery.Drone> drones = Arrays.asList(givenADrone(4, 11), givenADrone(5, 15), givenADrone(6, 16),
				givenADrone(3, 40), givenADrone(2, 12));
		DroneDelivery droneDelivery = new DroneDelivery();
		final List<Integer> dronesWithGreaterFlightRange = droneDelivery.findDronesWithGreaterFlightRange(3, drones,
				Arrays.asList(5, 2));
		Assert.assertEquals(dronesWithGreaterFlightRange.size(), 3);
		assert dronesWithGreaterFlightRange.get(0).equals(3);
		assert dronesWithGreaterFlightRange.get(1).equals(6);
		assert dronesWithGreaterFlightRange.get(2).equals(4);
	}

	@Test
	public void shouldPerformWell() {

		Random random = new Random();
		final List<DroneDelivery.Drone> drones = new ArrayList<>(100000);
		final List<Integer> unavailableDrones = new ArrayList<>(25000);
		for (int i = 0; i < 10000; i++) {
			final int id = random.nextInt();
			drones.add(givenADrone(id, random.nextInt()));
			if (i % 4 == 0) {
				unavailableDrones.add(id);
			}
		}

		DroneDelivery droneDelivery = new DroneDelivery();
		final List<Integer> dronesWithGreaterFlightRange = droneDelivery.findDronesWithGreaterFlightRange(4000, drones,
				unavailableDrones);
		assert dronesWithGreaterFlightRange.size() == 4000;

	}

	private DroneDelivery.Drone givenADrone(int id, int flightRange) {

		return new DroneDelivery.Drone(id, flightRange);
	}
}