package entity;

import java.util.HashMap;

public class Mapinha {

	private HashMap<String, String> mapinha;
	
	public Mapinha() {
		mapinha = new HashMap<String, String>();
	}

	public HashMap<String, String> getMapinha() {
		return construirHashMap();
	}

	public void setMapinha(HashMap<String, String> mapinha) {
		this.mapinha = mapinha;
	}
	
	private HashMap<String, String> construirHashMap() {
		
		mapinha.put("a", "|1|");
		mapinha.put("b", "|2|");
		mapinha.put("c", "|3|");
		mapinha.put("d", "|4|");
		mapinha.put("e", "|5|");
		mapinha.put("f", "|6|");
		mapinha.put("g", "|7|");
		mapinha.put("h", "|8|");
		mapinha.put("i", "|9|");
		mapinha.put("j", "|10|");
		mapinha.put("k", "|11|");
		mapinha.put("l", "|12|");
		mapinha.put("m", "|13|");
		mapinha.put("n", "|14|");
		mapinha.put("o", "|15|");
		mapinha.put("p", "|16|");
		mapinha.put("q", "|17|");
		mapinha.put("r", "|18|");
		mapinha.put("s", "|19|");
		mapinha.put("t", "|20|");
		mapinha.put("u", "|21|");
		mapinha.put("v", "|22|");
		mapinha.put("w", "|23|");
		mapinha.put("x", "|24|");
		mapinha.put("y", "|25|");
		mapinha.put("z", "|26|");
		
		return mapinha;
	}
}
