package Lecture15;

public class Hashtable<K, V> {
	private class HTPair {
		K key;
		V value;

		public HTPair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public boolean equals(Object other) {
			HTPair op = (HTPair) other;
			return this.key.equals(op.key);
		}

		public String toString() {
			return "{" + this.key + "-" + this.value + "}";
		}

	}

	LinkedList<HTPair>[] bucketArray;
	int size;

	public static int DEFAULT_CAPACITY = 10;

	public Hashtable() {
		// TODO Auto-generated constructor stub
		this(DEFAULT_CAPACITY);
	}

	public Hashtable(int capacity) {
		this.bucketArray = (LinkedList<HTPair>[]) new LinkedList[capacity];
		this.size = 0;
	}

	public void put(K key, V value) throws Exception {
		int bi = hashFunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		HTPair pta = new HTPair(key, value);
		if (bucket == null) {
			bucket = new LinkedList<>();
			bucket.addLast(pta);
			this.size++;
			this.bucketArray[bi] = bucket;
		} else {
			int findAt = bucket.find(pta);
			if (findAt == -1) {
				bucket.addLast(pta);
				this.size++;
			} else {
				HTPair pair = bucket.getAt(findAt);
				pair.value = value;
			}
		}
		double lamda=(this.size*1.0)/this.bucketArray.length;
		if(lamda>0.75) {
			this.rehash();
		}
		
		
	}

	public V get(K key) throws Exception {
		int bi = hashFunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		HTPair ptf = new HTPair(key, null);
		if (bucket == null) {
			return null;
		} else {
			int findAt = bucket.find(ptf);
			if (findAt == -1) {
				return null;
			} else {
				HTPair pair = bucket.getAt(findAt);
				return pair.value;
			}
		}
	}

	public V remove(K key) throws Exception {
		int bi = hashFunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		HTPair ptf = new HTPair(key, null);
		if (bucket == null) {
			return null;
		} else {
			int findAt = bucket.find(ptf);
			if (findAt == -1) {
				return null;
			} else {
				HTPair pair = bucket.getAt(findAt);
				bucket.removeAt(findAt);
				this.size--;
				return pair.value;
			}
		}
	}

	private int hashFunction(K key) {
		int hc = key.hashCode();
		hc = Math.abs(hc);
		int bi = hc % this.bucketArray.length;
		return bi;
	}

	public void display() throws Exception {
		for (LinkedList<HTPair> bucket : this.bucketArray) {
			if (bucket != null && !bucket.isEmpty()) {
				bucket.display();
			} else {
				System.out.println("NULL");
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		System.out.println("**************************");
	}
	
	private void rehash() throws Exception {
		LinkedList<HTPair>[] oba=this.bucketArray;
		this.bucketArray = (LinkedList<HTPair>[]) new LinkedList[2*oba.length];
		this.size=0;
		for(LinkedList<HTPair> ob:oba) {
			while(ob!=null&&!ob.isEmpty()) {
				HTPair rp=ob.removeFirst();
				this.put(rp.key, rp.value);
			}
		}
	}
}
