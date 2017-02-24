package simple;

import java.util.Random;

public class Gen {

	public static void main(String[] args) {
		Knot k = new Knot(new M[] { M.L, M.R, M.C });
		k.calcStyle();
		System.out.println(k);
		k = new Knot(new M[] { M.L, M.R, M.C, M.R });
		k.calcStyle();
		System.out.println(k);
		k = new Knot(new M[] { M.L, M.R, M.C, M.R, M.L });
		k.calcStyle();
		System.out.println(k);
		k = new Knot(new M[] { M.L, M.R, M.C, M.R, M.L, M.C });
		k.calcStyle();
		System.out.println(k);
		k = new Knot(new M[] { M.L, M.R, M.C, M.R, M.L, M.C, M.U });
		k.calcStyle();
		System.out.println(k);

		k = new Knot(M.stringToMoves("LCLRCRLCURLU"));
		k.calcStyle();
		System.out.println(k);

		k = new Knot(M.stringToMoves("LCRLRCRLUCRCLU"));
		k.calcStyle();
		System.out.println(k);

		k = new Knot(M.stringToMoves("LCRLRCLRUCLCRU"));
		k.calcStyle();
		System.out.println(k);

		k = new Knot(M.stringToMoves("LRLCRUCLURCU"));
		k.calcStyle();
		System.out.println(k);

		k = new Knot(M.stringToMoves("LCLRCRLCRULCU"));
		k.calcStyle();
		System.out.println(k);

		k = genRand(8);
		k.calcStyle();
		System.out.println(k);

		for (int i = 6; i < 13; i += 2) {
			list(i);
		}
	}

	// http://tieknots.johanssons.org/explore-singly.html
	static M[][] tie = { { M.L }, { M.L, M.R }, { M.L, M.C } };
	static M[][] l = { { M.R, M.L }, { M.C, M.L }, { M.R, M.C }, { M.R, M.C, M.U }, { M.C, M.R }, { M.C, M.R, M.U } };
	static M[][] lu = { { M.R, M.C, M.U }, { M.C, M.R, M.U } };
	static M[][] r = { { M.L, M.R }, { M.C, M.R }, { M.L, M.C }, { M.L, M.C, M.U }, { M.C, M.L }, { M.C, M.L, M.U } };
	static M[][] ru = { { M.L, M.C, M.U }, { M.C, M.L, M.U } };
	static M[][] c = { { M.L, M.C }, { M.R, M.C }, { M.L, M.R }, { M.L, M.R, M.U }, { M.R, M.L }, { M.R, M.L, M.U } };
	static M[][] cu = { { M.L, M.R, M.U }, { M.R, M.L, M.U } };

	public static Random rand = new Random();

	public static Knot genRand(int size) {
		Knot res = new Knot();
		M[] suffix = tie[rand.nextInt(tie.length)];
		res.addAll(suffix);
		res = genRand(size, res);
		return res;
	}

	public static Knot genRand(int size, Knot k) {
		M lastside = k.lastSide();
		M[][] sel = null;
		M[][] selu = null;
		if (lastside == M.L) {
			sel = l;
			selu = lu;
		} else if (lastside == M.R) {
			sel = r;
			selu = ru;
		} else if (lastside == M.C) {
			sel = c;
			selu = cu;
		}
		if (k.weight() + 2 >= size) {
			M[] suffix = selu[rand.nextInt(selu.length)];
			k.addAll(suffix);
			return k;
		} else {
			M[] suffix = sel[rand.nextInt(sel.length)];
			k.addAll(suffix);
			k = genRand(size, k);
			return k;
		}
	}

	public static void list(int size) {
		Knot res = new Knot();
		for (int i = 0; i < tie.length; i++) {
			M[] suffix = tie[i];
			res.addAll(suffix);
			list(size, res);
			res.remove(suffix.length);
		}
	}

	public static void list(int size, Knot k) {
		M lastside = k.lastSide();
		M[][] sel = null;
		M[][] selu = null;
		if (lastside == M.L) {
			sel = l;
			selu = lu;
		} else if (lastside == M.R) {
			sel = r;
			selu = ru;
		} else if (lastside == M.C) {
			sel = c;
			selu = cu;
		}
		if (k.weight() + 2 >= size) {
			for (int i = 0; i < selu.length; i++) {
				M[] suffix = selu[i];
				k.addAll(suffix);
				register(k);
				k.remove(suffix.length);
			}
		} else {
			for (int i = 0; i < sel.length; i++) {
				M[] suffix = sel[i];
				k.addAll(suffix);
				list(size, k);
				k.remove(suffix.length);
			}
		}
	}

	public static int count = 0;

	public static void register(Knot k) {
		// if (Math.abs(k.symmetry()) <= 0 && k.shape() <= 5 && k.twirl() <= 0)
		// {
		// if (k.moves.get(k.moves.size() - 2) != M.C || k.weight() % 2 == 1) {
		// k.calcStyle();
		// if (k.frontstyle == S.trin && k.styleComplexity() >= 6 && k.ce[0] >
		// 0) {
		// count++;
		// System.out.println(count + ": " + k);
		// }
		// }
		// }

		// if (Math.abs(k.symmetry()) <= 1 && k.shape() == 3 && k.twirl() <= 0
		// && k.moves.size() - k.weight() <= 7) {
		// if (k.moves.get(k.moves.size() - 2) != M.C) {
		// k.calcStyle();
		// if (k.frontstyle == S.trin && k.facesym() <= 1 && k.styleComplexity()
		// >= 4 && k.switchback() <= 0
		// && k.awkwardtucks <= 0) {
		// count++;
		// System.out.println(count + ": " + k);
		// }
		// }
		// }
		if (Math.abs(k.symmetry()) <= 0 && k.shape() <= 3 && k.twirl() <= 0 && k.moves.size() - k.weight() == 2) {
			if (k.weight() <= 9 && k.moves.get(k.moves.size() - 2) == M.C && k.weight() % 2 == 1) {
				k.calcStyle();
				if (k.facesym() <= 3 && k.switchback() <= 3 && k.awkwardtucks <= 0) {
					count++;
					System.out.println(count + ":   " + k);
				}
			}
		}
	}
}
