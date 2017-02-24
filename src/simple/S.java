package simple;

public enum S {
	eld, trin, flat, diag;

	public static S calcFace(int c, int l, int r) {
		if (c * l * r == 0) {
			return null;
		}
		if (c < 0) {
			c = -c;
			int temp = -l;
			l = -r;
			r = temp;
		}
		if (l > 0) {
			if (r > 0) {
				return trin;
			}
			return eld;
		}
		if (r > 0) {
			return flat;
		}
		return diag;
	}
}
