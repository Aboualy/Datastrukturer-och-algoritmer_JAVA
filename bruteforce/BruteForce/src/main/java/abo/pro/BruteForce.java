package abo.pro;
import java.util.ArrayList;


public class BruteForce {
	ArrayList<ArrayList<City>> k = new ArrayList<ArrayList<City>>();

	public ArrayList<City> PermSolver(ArrayList<City> a, int b) {
		ArrayList<City> colist = new ArrayList<City>();
		ArrayList<City> RouteOr = new ArrayList<City>();
		CopyList(colist, a);
		int kk = b;
		RouteOr.add(colist.get(0));
		colist.remove(0);
		for (int i = colist.size() - 1; i > 0; i--) {
			RouteOr.add(colist.get(kk / ff(i)));
			colist.remove(kk / ff(i));
			kk = kk % ff(i);
		}
		RouteOr.add(colist.get(0));
		RouteOr.add(a.get(0));
		return RouteOr;
	}

	public double FinderDi(ArrayList<City> c) {
		double length = 0;
		for (int i = 1; i < c.size(); i++) {
			length = c.get(i).Length(c.get(i - 1)) + length;
		}
		length = length + c.get(c.size() - 1).Length(c.get(0));
		return length;
	}

	public void CopyList(ArrayList<City> n, ArrayList<City> m) {
		n.clear();
		for (int i = 0; i < m.size(); i++) {
			n.add(m.get(i));
		}
	}

	public int ff(int nr) {
		int fact = 1;
		for (int i = nr; i > 0; i--) {
			fact = fact * i;
		}
		return fact;
	}

	public ArrayList<ArrayList<City>> Solution(ArrayList<City> c) {
		int size = c.size() - 1;
		ArrayList<ArrayList<City>> routeli = new ArrayList<ArrayList<City>>();
		double ccr = FinderDi(c);
		for (int i = 0; i < ff(size) / 2; i++) {
			double compare = FinderDi(PermSolver(c, i));
			if (compare < ccr) {
				routeli.clear();
				routeli.add(PermSolver(c, i));
				ccr = compare;
			} else if (compare == ccr) {
				routeli.add(PermSolver(c, i));
			}
		}
		k = routeli;
		return routeli;
	}

}