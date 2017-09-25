package com.gersonsosa.projecteuler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:gersonsosa@gmail.com">Gerson Sosa</a>
 */
public class DroneDelivery {
	public static class Drone {
		private final int id;
		private final int flightRange;

		Drone(int id, int flightRange) {

			this.id = id;
			this.flightRange = flightRange;
		}

		public int getId() {

			return id;
		}

		public int getFlightRange() {

			return flightRange;
		}

	}

	public List<Integer> findDronesWithGreaterFlightRange(int numberOfDronesNeeded, List<Drone> drones,
			List<Integer> unavailableDrones) {

		Map<Integer, Drone> droneMap = drones.stream().collect(Collectors.toMap(Drone::getId, drone -> drone));
		unavailableDrones.forEach(droneMap::remove);

		PriorityQueue<Drone> dronePriorityQueue = new PriorityQueue<>((o1, o2) -> {

			if (o2.getFlightRange() > o1.getFlightRange()) {
				return 1;
			}
			else if (o2.getFlightRange() < o1.getFlightRange()) {
				return -1;
			}
			return 0;
		});

		dronePriorityQueue.addAll(droneMap.values());

		List<Integer> resultDrones = new ArrayList<>();
		for (int i = 0; i < numberOfDronesNeeded; i++) {
			resultDrones.add(dronePriorityQueue.poll().getId());
		}
		return resultDrones;
	}
}
