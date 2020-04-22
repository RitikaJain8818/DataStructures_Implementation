package Lecture15;

import java.awt.datatransfer.SystemFlavorMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();
		map.put("India", 300);
		System.out.println(map);
		map.put("Russia", 250);
		map.put("USA", 150);
		map.put("China", 350);
		map.put("Nepal", 25);
		map.put("UK", 200);
		System.out.println(map);

		map.put("India", 325);
		System.out.println(map);

		System.out.println(map.get("Russia"));
		System.out.println(map.get("India"));
		System.out.println(map.get("Sweden"));

		// map.remove("Russia");
		// map.remove("Aus");
		// System.out.println(map);

		System.out.println("********************");
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key);
		}
		System.out.println("********************");
		Collection<Integer> values = map.values();
		for (Integer value : values) {
			System.out.println(value);
		}
		System.out.println("********************");
		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		for (Map.Entry<String, Integer> entry : entries) {
			System.out.println(entry.getKey() + "=>" + entry.getValue());
		}

		System.out.println(map.containsKey("Russia"));
		System.out.println(map.containsKey("Sweden"));

		String str = "abcbdbbbbbaaabcd";
		System.out.println(maxfreq(str));

	}

	public static char maxfreq(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			if (map.containsKey(cc)) {
				int ov = map.get(cc);
				ov = ov + 1;
				map.put(cc, ov);
			} else {
				map.put(cc, 1);
			}
		}

		Set<Map.Entry<Character, Integer>> entries = map.entrySet();
		char maxchar = '\0';
		int maxvalue = Integer.MIN_VALUE;
		for (Map.Entry<Character, Integer> entry : entries) {
			if (entry.getValue() > maxvalue) {
				maxvalue = entry.getValue();
				maxchar = entry.getKey();
			}
		}

		return maxchar;
	}

}
