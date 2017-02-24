package simple;

public enum M {
	Co, Ci, Cto, Cti, Lo, Li, Lto, Lti, Ro, Ri, Rto, Rti, L, R, C, U, T, W;

	public static M[] stringToMoves(String str) {
		str = str.toUpperCase();
		M[] res = new M[str.length()];
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch (c) {
			case 'C':
				res[i] = M.C;
				break;
			case 'L':
				res[i] = M.L;
				break;
			case 'R':
				res[i] = M.R;
				break;
			case 'U':
				res[i] = M.U;
				break;
			}
		}
		return res;
	}
}
