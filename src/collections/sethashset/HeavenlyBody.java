package collections.sethashset;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
//	private final String name;
	private final double orbitalPeriod;
	private final Set<HeavenlyBody> satellites;
//	private final BodyType bodyType;
	private final Key key;
	
//	public static final int STAR=1;
//	public static final int PLANET=2;
//	public static final int DWARF_PLANET=3;
//	public static final int MOON=4;
//	public static final int COMET=5;
//	public static final int ASTERIOD=6;
	
	public enum BodyType{
		STAR,PLANET,DWARF_PLANET,MOON,COMET,ASTERIOD
	}
	
	
	public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType) {
		this.key = new Key(name, bodyType);
//		this.name = name;
		this.orbitalPeriod = orbitalPeriod;
		this.satellites = new HashSet<HeavenlyBody>();
//		this.bodyType = bodyType;
	}

//	public String getName() {
//		return name;
//	}

	public double getOrbitalPeriod() {
		return orbitalPeriod;
	}
	
//	public BodyType getBodyType() {
//		return bodyType;
//	}
	
	public boolean addSatellite(HeavenlyBody moon) {
		return this.satellites.add(moon);
	}
	
	public Set<HeavenlyBody> getSatellites(){
		return new HashSet<HeavenlyBody>(this.satellites);
	}
	
	@Override
	public final boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
//		System.out.println("obj.getClass() is "+ obj.getClass());
//		System.out.println("this.getClass() is "+ this.getClass());
//		
//		if((obj == null)||(obj.getClass() != this.getClass())) {
//			return false;
//		}
		
//		if(obj instanceof HeavenlyBody) {
//			HeavenlyBody theObject = (HeavenlyBody) obj;
//			if(this.name.equals(theObject.getName())) {
//				return this.bodyType == theObject.getBodyType();
//			}
//		}
		
		if(obj instanceof HeavenlyBody) {
			HeavenlyBody theObject = (HeavenlyBody) obj;
			return this.key.equals(theObject.getKey());
		}
		
//		String objName = ((HeavenlyBody) obj).getName();
//		return this.name.equals(objName);
		return false;
	}

	@Override
	public final int hashCode() {
		// TODO Auto-generated method stub
		return this.getKey().hashCode();
	}
	
	public static Key makeKey(String name, BodyType bodyType) {
		return new Key(name,bodyType);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getKey().name + " : " + this.getKey().bodyType + ", " + this.orbitalPeriod ;
	}
	
	public Key getKey() {
		return key;
	}

	public static final class Key{
		private String name;
		private BodyType bodyType;
		
		private Key(String name, BodyType bodyType) {
			this.name = name;
			this.bodyType = bodyType;
		}

		public String getName() {
			return name;
		}

		public BodyType getBodyType() {
			return bodyType;
		}

		@Override
		public boolean equals(Object obj) {
			Key key = (Key) obj;
			if(this.name.equals(key.getName())) {
				return (this.bodyType == key.getBodyType());
			}
			
			return false;
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return this.name.hashCode() + 57 +  this.bodyType.hashCode();
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.name + " : " + this.bodyType;
		}
		
		
		
		
	}
	
}
