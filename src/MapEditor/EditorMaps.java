package MapEditor;

import Level.Map;
import Maps.SummerMap;
import Maps.WinterMap;
import Maps.AnitaHouseInterior;
import Maps.FallMap;
import Maps.InteriorMap;
import Maps.TestMap;
import Maps.MourningWoodMap;
import Maps.SecretRoom;
import Maps.HauntedHouse;
import Maps.TitleScreenMap;

import java.util.ArrayList;

public class EditorMaps {
	public static ArrayList<String> getMapNames() {
		return new ArrayList<String>() {
			{
				add("TestMap");
				add("TitleScreen");
				add("SummerMap");
				add("WinterMap");
				add("FallMap");
				add("InteriorMap");
				add("HauntedHouse");
				add("AnitaHouseInterior");
				add("MourningWoodMap");
				add("SecretRoom");
			}
		};
	}

	public static Map getMapByName(String mapName) {
		switch (mapName) {
		case "TestMap":
			return new TestMap();
		case "TitleScreen":
			return new TitleScreenMap();
		case "SummerMap":
			return new SummerMap();
		case "WinterMap":
			return new WinterMap();
		case "FallMap":
			return new FallMap();
		case "InteriorMap":
			return new InteriorMap();
		case "HauntedHouse":
			return new HauntedHouse();
		case "AnitaHouseInterior":
			return new AnitaHouseInterior();
		case "MourningWoodMap":
			return new MourningWoodMap();
		case "SecretRoom":
			return new SecretRoom();
		default:
			throw new RuntimeException("Unrecognized map name");
		}
	}
}
