package simple;

import java.util.ArrayList;

public class Knot {
	ArrayList<M> moves = new ArrayList<M>();
	ArrayList<M> twm = new ArrayList<M>();

	public Knot() {

	}

	public Knot(ArrayList<M> moves) {
		this.moves.addAll(moves);
	}

	public Knot(M[] moves) {
		for (M move : moves) {
			this.moves.add(move);
		}
	}

	public void addAll(M[] moves) {
		for (M move : moves) {
			this.moves.add(move);
		}
	}

	public void remove(int count) {
		for (int i = 0; i < count; i++) {
			this.moves.remove(this.moves.size() - 1);
		}
	}

	public void calcTW() {
		twm = new ArrayList<M>();
		M side = moves.get(0);
		for (int i = 1; i < moves.size(); i++) {
			if (moves.get(i) == M.U) {
				twm.add(M.U);
			} else {
				if (side == M.L) {
					if (moves.get(i) == M.C) {
						twm.add(M.T);
					} else {
						twm.add(M.W);
					}
				} else if (side == M.R) {
					if (moves.get(i) == M.L) {
						twm.add(M.T);
					} else {
						twm.add(M.W);
					}
				} else if (side == M.C) {
					if (moves.get(i) == M.R) {
						twm.add(M.T);
					} else {
						twm.add(M.W);
					}
				}
				side = moves.get(i);
			}
		}
	}

	public M lastSide() {
		for (int i = moves.size() - 1; i >= 0; i--) {
			M move = moves.get(i);
			if (move != M.Lti && move != M.Lto && move != M.Rti && move != M.Rto && move != M.Cti && move != M.Cto
					&& move != M.U) {
				return move;
			}
		}
		return null;
	}

	public int symmetry() {
		int res = 0;
		for (M move : moves) {
			if (move == M.L || move == M.Li || move == M.Lo) {
				res--;
			}
			if (move == M.R || move == M.Ri || move == M.Ro) {
				res++;
			}
		}
		return res;
	}

	public int shape() {
		int res = 0;
		for (M move : moves) {
			if (move == M.C || move == M.Ci || move == M.Co) {
				res++;
			}
		}
		return weight() / res;
	}

	public int weight() {
		int res = 0;
		for (M move : moves) {
			if (move != M.Lti && move != M.Lto && move != M.Rti && move != M.Rto && move != M.Cti && move != M.Cto
					&& move != M.U) {
				res++;
			}
		}
		return res;
	}

	public int twirl() {
		int res = 0;
		for (int i = 3; i < moves.size(); i++) {
			if (moves.get(i) == moves.get(i - 2) && moves.get(i - 1) == moves.get(i - 3)) {
				res++;
			}
		}
		return res;
	}

	public int switchback() {
		int res = 0;
		for (int i = 2; i < moves.size(); i++) {
			if (moves.get(i) == moves.get(i - 2)) {
				res++;
			}
		}
		return res;
	}

	public Knot clone() {
		return new Knot(moves);
	}

	@Override
	public String toString() {
		calcTW();
		return "{" + moves.toString() + " w:" + weight() + " sy:" + symmetry() + " sh:" + shape() + " tw:" + twirl()
				+ " sw:" + switchback() + " " + faces() + " cm:" + styleComplexity() + " fs:" + facesym() + " awk:"
				+ awkwardtucks + " " + twm.toString() + "}";
	}

	public S frontstyle;
	public S backstyle;

	int[] cf = new int[2];
	int[] lf = new int[2];
	int[] rf = new int[2];

	int[] ce = new int[2];
	int[] le = new int[2];
	int[] re = new int[2];

	int awkwardtucks = 0;

	public String faces() {
		String res = "";
		res += "(" + cf[0] + " " + lf[0] + " " + rf[0] + ", " + ce[0] + " " + le[0] + " " + re[0] + " | ";
		res += cf[1] + " " + lf[1] + " " + rf[1] + ", " + ce[1] + " " + le[1] + " " + re[1] + ")";
		res += "->(" + frontstyle + ")";
		return res;
	}

	public int styleComplexity() {
		int res = 0;
		res += Math.abs(cf[0]);// + Math.abs(cf[1]);
		res += Math.abs(lf[0]);// + Math.abs(lf[1]);
		res += Math.abs(rf[0]);// + Math.abs(rf[1]);
		return res;
	}

	public int facesym() {
		return Math.abs(Math.abs(lf[0]) - Math.abs(rf[0])) + Math.abs(le[0] - re[0]);
	}

	public static boolean countbackawks = true;

	public void calcStyle() {
		int index = 0;
		int p = 0;
		cf = new int[2];
		lf = new int[2];
		lf[0] = 1;
		rf = new int[2];
		ce = new int[2];
		le = new int[2];
		re = new int[2];
		awkwardtucks = 0;
		while (index < moves.size() - 1) {
			M prevtuck = null;
			M prevdir = null;
			if (index >= 2) {
				prevtuck = moves.get(index - 1);
				prevdir = moves.get(index - 2);
			}
			M curmove = moves.get(index);
			M nextmove = moves.get(index + 1);
			if (curmove == M.L || curmove == M.R || curmove == M.C) {
				p = 1 - p;
			}
			if (curmove == M.L) {
				if (nextmove == M.C) {
					cf[p] = Math.min(cf[p] - 1, -1);
					if (prevtuck == M.U && prevdir == M.R && lf[p] < 0) {
						lf[p] = -1;
					} else {
						lf[p] = Math.max(lf[p] + 1, 1);
						if (countbackawks && prevtuck == M.U) {
							awkwardtucks++;
						}
					}
					le[p]++;
				} else if (nextmove == M.R) {
					if (prevtuck == M.U && prevdir == M.C && lf[p] > 0) {
						lf[p] = 1;
					} else {
						lf[p] = Math.min(lf[p] - 1, -1);
						if (countbackawks && prevtuck == M.U) {
							awkwardtucks++;
						}
					}
					rf[p] = Math.max(rf[p] + 1, 1);
					ce[p]++;
				} else if (nextmove == M.U) {
					M tuckdir = null;
					if (rf[p] < 0 && cf[p] < 0) {
						tuckdir = M.R;
					} else if (rf[p] > 0 && cf[p] > 0) {
						tuckdir = M.C;
					} else if (index < moves.size() - 2) {
						tuckdir = moves.get(index + 2);
					} else {
						tuckdir = moves.get(index - 1);
					}
					if (index < moves.size() - 2 && tuckdir != moves.get(index + 2)) {
						awkwardtucks++;
					}
					if (tuckdir == M.C) {
						cf[p] = 1;
						lf[p] = Math.max(lf[p] + 1, 1);
						le[p]++;
					} else if (tuckdir == M.R) {
						lf[p] = Math.min(lf[p] - 1, -1);
						rf[p] = -1;
						ce[p]++;
					}
				}
			} else if (curmove == M.R) {
				if (nextmove == M.L) {
					lf[p] = Math.min(lf[p] - 1, -1);
					if (prevtuck == M.U && prevdir == M.C && rf[p] < 0) {
						rf[p] = -1;
					} else {
						rf[p] = Math.max(rf[p] + 1, 1);
						if (countbackawks && prevtuck == M.U) {
							awkwardtucks++;
						}
					}
					ce[p]++;
				} else if (nextmove == M.C) {
					if (prevtuck == M.U && prevdir == M.L && rf[p] > 0) {
						rf[p] = 1;
					} else {
						rf[p] = Math.min(rf[p] - 1, -1);
						if (countbackawks && prevtuck == M.U) {
							awkwardtucks++;
						}
					}
					cf[p] = Math.max(cf[p] + 1, 1);
					re[p]++;
				} else if (nextmove == M.U) {
					M tuckdir = null;
					if (cf[p] < 0 && lf[p] < 0) {
						tuckdir = M.C;
					} else if (cf[p] > 0 && lf[p] > 0) {
						tuckdir = M.L;
					} else if (index < moves.size() - 2) {
						tuckdir = moves.get(index + 2);
					} else {
						tuckdir = moves.get(index - 1);
					}
					if (index < moves.size() - 2 && tuckdir != moves.get(index + 2)) {
						awkwardtucks++;
					}
					if (tuckdir == M.L) {
						lf[p] = 1;
						rf[p] = Math.max(rf[p] + 1, 1);
						ce[p]++;
					} else if (tuckdir == M.C) {
						rf[p] = Math.min(rf[p] - 1, -1);
						cf[p] = -1;
						re[p]++;
					}
				}
			} else if (curmove == M.C) {
				if (nextmove == M.R) {
					rf[p] = Math.min(rf[p] - 1, -1);
					if (prevtuck == M.U && prevdir == M.L && cf[p] < 0) {
						cf[p] = -1;
					} else {
						cf[p] = Math.max(cf[p] + 1, 1);
						if (countbackawks && prevtuck == M.U) {
							awkwardtucks++;
						}
					}
					re[p]++;
				} else if (nextmove == M.L) {
					if (prevtuck == M.U && prevdir == M.R && cf[p] > 0) {
						cf[p] = 1;
					} else {
						cf[p] = Math.min(cf[p] - 1, -1);
						if (countbackawks && prevtuck == M.U) {
							awkwardtucks++;
						}
					}
					lf[p] = Math.max(lf[p] + 1, 1);
					le[p]++;
				} else if (nextmove == M.U) {
					M tuckdir = null;
					if (lf[p] < 0 && rf[p] < 0) {
						tuckdir = M.L;
					} else if (lf[p] > 0 && rf[p] > 0) {
						tuckdir = M.R;
					} else if (index < moves.size() - 2) {
						tuckdir = moves.get(index + 2);
					} else {
						tuckdir = moves.get(index - 1);
					}
					if (index < moves.size() - 2 && tuckdir != moves.get(index + 2)) {
						awkwardtucks++;
					}
					if (tuckdir == M.R) {
						rf[p] = 1;
						cf[p] = Math.max(cf[p] + 1, 1);
						re[p]++;
					} else if (tuckdir == M.L) {
						cf[p] = Math.min(cf[p] - 1, -1);
						lf[p] = -1;
						le[p]++;
					}
				}
			}
			index++;
		}
		frontstyle = S.calcFace(cf[0], lf[0], rf[0]);
	}

}
