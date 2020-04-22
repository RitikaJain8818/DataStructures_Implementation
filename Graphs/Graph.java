package Lecture19and20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Graph {
	private class Vertex {
		String name;
		HashMap<Vertex, Integer> nbrs;

		Vertex(String name) {
			this.name = name;
			this.nbrs = new HashMap<>();
		}

		public boolean equals(Object other) {
			Vertex ov = (Vertex) other;
			return this.name.equals(ov.name);
		}

		public int hashCode() {
			return this.name.hashCode();
		}

		public void display() {
			String str = "";
			str = this.name + "=>";
			Set<Map.Entry<Vertex, Integer>> nbrs = this.nbrs.entrySet();
			for (Map.Entry<Vertex, Integer> nbr : nbrs) {
				str = str + nbr.getKey().name + "(" + nbr.getValue() + "),";
			}
			str = str + "END";
			System.out.println(str);

		}
	}

	HashMap<String, Vertex> vtces;

	public Graph() {
		this.vtces = new HashMap<>();
	}

	public int numvertices() {
		return this.vtces.size();
	}

	public void addVertex(String name) {
		if (this.vtces.containsKey(name)) {
			return;
		}

		Vertex vtx = new Vertex(name);
		this.vtces.put(name, vtx);
	}

	public void removeVertex(String name) {
		if (!this.vtces.containsKey(name)) {
			return;
		}

		Vertex vtx = this.vtces.get(name);
		Set<Vertex> nbrs = vtx.nbrs.keySet();
		for (Vertex nbr : nbrs) {
			nbr.nbrs.remove(vtx);
		}

		this.vtces.remove(name);

	}

	public int numedges() {
		int rv = 0;
		Collection<Vertex> vtces = this.vtces.values();
		for (Vertex vtx : vtces) {
			rv = rv + vtx.nbrs.size();
		}
		rv = rv / 2;
		return rv;
	}

	public void addEdge(String name1, String name2, int cost) {
		Vertex vtx1 = this.vtces.get(name1);
		Vertex vtx2 = this.vtces.get(name2);
		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vtx2)) {
			return;
		}

		vtx1.nbrs.put(vtx2, cost);
		vtx2.nbrs.put(vtx1, cost);

	}

	public void removeEdge(String name1, String name2) {
		Vertex vtx1 = this.vtces.get(name1);
		Vertex vtx2 = this.vtces.get(name2);
		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vtx2)) {
			return;
		}

		vtx1.nbrs.remove(vtx2);
		vtx2.nbrs.remove(vtx1);

	}

	public void display() {
		Collection<Vertex> vtces = this.vtces.values();
		for (Vertex vtx : vtces) {
			vtx.display();
		}
		System.out.println("*****************");
	}

	public boolean hasPath(String name1, String name2) {
		Vertex vtx1 = this.vtces.get(name1);
		Vertex vtx2 = this.vtces.get(name2);
		if (vtx1 == null || vtx2 == null) {
			return false;
		}
		HashMap<Vertex, Boolean> explored = new HashMap<>();
		return this.hasPathBFS(vtx1, vtx2, explored);
	}

	private boolean hasPathDFS(Vertex vtx1, Vertex vtx2, HashMap<Vertex, Boolean> explored) {
		if (!explored.containsKey(vtx1)) {
			explored.put(vtx1, true);
		} else {
			return false;
		}

		if (vtx1.nbrs.containsKey(vtx2)) {
			return true;
		}

		Set<Vertex> nbrs = vtx1.nbrs.keySet();
		for (Vertex nbr : nbrs) {
			if (hasPathDFS(nbr, vtx2, explored)) {
				return true;
			}
		}

		return false;
	}

	private boolean hasPathBFS(Vertex vtx1, Vertex vtx2, HashMap<Vertex, Boolean> explored) {
		LinkedList<Vertex> queue = new LinkedList<>();
		queue.add(vtx1);
		while (!queue.isEmpty()) {
			Vertex rvtx = queue.removeFirst();
			if (!explored.containsKey(rvtx)) {
				explored.put(rvtx, true);
				if (rvtx.nbrs.containsKey(vtx2)) {
					return true;
				} else {
					Set<Vertex> nbrs = rvtx.nbrs.keySet();
					for (Vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							queue.addLast(nbr);
						}
					}
				}
			}
		}
		return false;
	}

	public void bft() {
		LinkedList<Vertex> queue = new LinkedList<>();
		Collection<Vertex> vtces = this.vtces.values();
		HashMap<Vertex, Boolean> explored = new HashMap<>();
		for (Vertex vtx : vtces) {
			if (!explored.containsKey(vtx)) {
				queue.add(vtx);
			}
			while (!queue.isEmpty()) {
				Vertex rvtx = queue.removeFirst();
				if (!explored.containsKey(rvtx)) {
					explored.put(rvtx, true);
					System.out.print(rvtx.name + " ");
					Set<Vertex> nbrs = rvtx.nbrs.keySet();
					for (Vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							queue.addLast(nbr);
						}
					}
				}
			}
		}
	}

	public void dft() {
		LinkedList<Vertex> stack = new LinkedList<>();
		Collection<Vertex> vtces = this.vtces.values();
		HashMap<Vertex, Boolean> explored = new HashMap<>();
		for (Vertex vtx : vtces) {
			if (!explored.containsKey(vtx)) {
				stack.addFirst(vtx);
			}
			while (!stack.isEmpty()) {
				Vertex rvtx = stack.removeFirst();
				if (!explored.containsKey(rvtx)) {
					explored.put(rvtx, true);
					System.out.print(rvtx.name + " ");
					Set<Vertex> nbrs = rvtx.nbrs.keySet();
					for (Vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							stack.addFirst(nbr);
						}
					}
				}
			}
		}
	}

	public boolean isConnected() {
		LinkedList<Vertex> queue = new LinkedList<>();
		Collection<Vertex> vtces = this.vtces.values();
		HashMap<Vertex, Boolean> explored = new HashMap<>();
		queue.add((Vertex) vtces.toArray()[0]);
		while (!queue.isEmpty()) {
			Vertex rvtx = queue.removeFirst();
			if (!explored.containsKey(rvtx)) {
				explored.put(rvtx, true);
				// System.out.print(rvtx.name + " ");
				Set<Vertex> nbrs = rvtx.nbrs.keySet();
				for (Vertex nbr : nbrs) {
					if (!explored.containsKey(nbr)) {
						queue.addLast(nbr);
					}
				}
			}
		}

		return this.vtces.size() == explored.size();

	}

	public ArrayList<ArrayList<String>> getCC() {
		LinkedList<Vertex> queue = new LinkedList<>();
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		Collection<Vertex> vtces = this.vtces.values();
		HashMap<Vertex, Boolean> explored = new HashMap<>();
		for (Vertex vtx : vtces) {
			if (!explored.containsKey(vtx)) {
				queue.add(vtx);
			}
			ArrayList<String> cc = new ArrayList<>();
			while (!queue.isEmpty()) {
				Vertex rvtx = queue.removeFirst();
				if (!explored.containsKey(rvtx)) {
					explored.put(rvtx, true);
					cc.add(rvtx.name);
					Set<Vertex> nbrs = rvtx.nbrs.keySet();
					for (Vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							queue.addLast(nbr);
						}
					}
				}
			}
			if (cc.size() != 0) {
				list.add(cc);
			}
		}
		return list;
	}

	public boolean isBipartite() {
		LinkedList<Pair> stack = new LinkedList<>();
		Collection<Vertex> vtces = this.vtces.values();
		HashMap<Vertex, String> explored = new HashMap<>();
		for (Vertex vtx : vtces) {
			if (!explored.containsKey(vtx)) {
				Pair p = new Pair();
				p.vtx = vtx;
				p.reasonvertex = null;
				p.vtxcolor = "Red";
				stack.add(p);
			}
			while (!stack.isEmpty()) {
				Pair rp = stack.removeFirst();
				if (!explored.containsKey(rp.vtx)) {
					explored.put(rp.vtx, rp.vtxcolor);
					Set<Vertex> nbrs = rp.vtx.nbrs.keySet();
					for (Vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							Pair p = new Pair();
							p.vtx = nbr;
							p.reasonvertex = rp.vtx;
							p.vtxcolor = rp.vtxcolor.equals("Red") ? "Green" : "Red";
							stack.addFirst(p);
						} else {
							String nbrcolor = explored.get(nbr);
							if (nbrcolor.equals(rp.vtxcolor)) {
								return false;
							}
						}
					}
				}
			}

		}

		return true;
	}

	private class Pair {
		Vertex vtx;
		Vertex reasonvertex;
		String vtxcolor;

	}

}
