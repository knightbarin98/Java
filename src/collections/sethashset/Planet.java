package collections.sethashset;

public class Planet extends HeavenlyBody{

	public Planet(String name, double orbitalPeriod) {
		super(name, orbitalPeriod, BodyType.PLANET);
		
	}

	@Override
	public boolean addSatellite(HeavenlyBody moon) {
		if(moon.getKey().getBodyType() == BodyType.MOON) {
			return super.addSatellite(moon);
		}
		
		return false;
	}
	
	

}
