package collections.sethashset;

import java.util.*;

import collections.sethashset.HeavenlyBody.BodyType;

/**
 * -Ordering chaotic, not duplicate elements
 * -Allow mathematical operations such as union an intersection
 * 
 * 
 * @author mrbarin
 *
 */
public class Main {
	private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
	private static Set<HeavenlyBody> planets = new HashSet<HeavenlyBody>();
	public static void main(String[] args) {
		
		HeavenlyBody temp = new Planet("Mercury", 88);
		solarSystem.put(temp.getKey(),temp);
		planets.add(temp);
		
		temp = new Planet("Venus", 255);
		solarSystem.put(temp.getKey(),temp);
		planets.add(temp);
		
		temp = new Planet("Earth", 365);
		solarSystem.put(temp.getKey(),temp);
		planets.add(temp);
		
		HeavenlyBody tempMoon = new Moon("Moon", 27);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addSatellite(tempMoon);
		
		temp = new Planet("Mars",687);
		solarSystem.put(temp.getKey(),temp);
		planets.add(temp);
		
		tempMoon = new Moon("Deimos", 1.3);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addSatellite(tempMoon);
		
		tempMoon = new Moon("Phobos", 0.3);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addSatellite(tempMoon);
		
		temp = new Planet("Jupiter",4332);
		solarSystem.put(temp.getKey(),temp);
		planets.add(temp);
		
		tempMoon = new Moon("Io", 1.8);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addSatellite(tempMoon);

		tempMoon = new Moon("Europa", 3.5);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addSatellite(tempMoon);

		tempMoon = new Moon("Ganymede", 7.1);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addSatellite(tempMoon);
		
		tempMoon = new Moon("Callisto", 16.7);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addSatellite(tempMoon);
		
		tempMoon = new Moon("Io", 1.8);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addSatellite(tempMoon);
		
		temp = new Planet("Saturn",10759);
		solarSystem.put(temp.getKey(),temp);
		planets.add(temp);
		
		temp = new Planet("Uranus",30660);
		solarSystem.put(temp.getKey(),temp);
		planets.add(temp);
		
		temp = new Planet("Neptune",165);
		solarSystem.put(temp.getKey(),temp);
		planets.add(temp);
		
		temp = new Planet("Pluto",248);
		solarSystem.put(temp.getKey(),temp);
		planets.add(temp);
		
		
		System.out.println("Planets");
		for(HeavenlyBody planet: planets) {
			System.out.println("\t"+planet.getKey());
		}
		
		HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey("Mars", BodyType.PLANET));
		System.out.println("Moons of " + body.getKey());
		for(HeavenlyBody jupiterMoon: body.getSatellites()) {
			System.out.println("\t"+ jupiterMoon.getKey());
		}
		
		body = solarSystem.get(HeavenlyBody.makeKey("Mars", BodyType.PLANET));
		System.out.println("Moons of " + body.getKey());
		for(HeavenlyBody jupiterMoon: body.getSatellites()) {
			System.out.println("\t"+ jupiterMoon.getKey());
		}
		
		Set<HeavenlyBody> moons = new HashSet<HeavenlyBody>();
		for(HeavenlyBody planet: planets) {
			moons.addAll(planet.getSatellites());
		}
		
		System.out.println("All moons");
		for(HeavenlyBody moon: moons) {
			System.out.println("\t" + moon.getKey());
		}
		
		HeavenlyBody pluto = new DwarfPlanet("Pluto", 842);
		planets.add(pluto);
		
		System.out.println("Planets");
		for(HeavenlyBody planet: planets) {
			System.out.println(planet);
		}
		
//		Object o = new Object();
//		o.equals(o);
//		"pluto".equals("");
		
		HeavenlyBody earth1 = new Planet("Earth", 365);
		HeavenlyBody earth2 = new Planet("Earth", 365);
		System.out.println(earth1.equals(earth2));
		System.out.println(earth2.equals(earth1));
		System.out.println(earth1.equals(pluto));
		System.out.println(pluto.equals(earth1));
		
		solarSystem.put(pluto.getKey(), pluto);
		System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", BodyType.PLANET)));
		System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", BodyType.DWARF_PLANET)));
		
		System.out.println();
		System.out.println("Solar system contains");
		for(HeavenlyBody heavenlyBody: solarSystem.values()) {
			System.out.println(heavenlyBody);
		}

	}

}
