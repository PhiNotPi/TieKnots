One category of knot I'm interested in is the "cape knot" style: tied with the narrow end, but tucks downwards behind the knot instead of up and around the collar.  These knots must have a small odd weight (w < 10 in order to reach the loop on the back of my tie blade), and therefore they must also be symmetrical.

A quick search with some other reasonable bounds turns up the following list of knots (bottom of page).  Some of these knots may have "unneeded tucks" which make no difference in the final knot appearance.

One of my favorites is #13, the simplest form of a caped trinity knot (simpler than the caped trinity knot I have seen before).  I believe this knot is indexed C-85.4.

    {[L, R, C, L, R, C, L, U, R, C, U] w:9 sy:0 sh:3 tw:0 sw:0 (1 1 1, 1 1 2 | -1 -1 -1, 2 2 1)->(trin) cm:3 fs:1 awk:0 [W, W, W, W, W, W, U, W, W, U]}
    
The normal Cape Knot (C-46) appears as #27 in this list, while the Atlantic Knot (C-3) does not appear because it is not symmetric (sy:-1).

It's also neat to look at the knots with the highest face complexity, which are the following:

    {[L, R, L, C, R, U, C, L, R, C, U] w:9 sy:0 sh:3 tw:0 sw:1 (2 1 -2, 1 1 2 | 1 -1 1, 2 1 2)->(eld) cm:5 fs:2 awk:0 [W, T, T, T, U, W, W, W, W, U]}
    {[L, C, L, R, C, U, R, L, R, C, U] w:9 sy:0 sh:3 tw:0 sw:2 (2 -1 -2, 1 1 2 | 2 -2 1, 2 1 2)->(diag) cm:5 fs:2 awk:0 [T, W, W, W, U, T, T, W, W, U]}
    {[L, R, C, U, L, R, U, C, L, R, C, U] w:9 sy:0 sh:3 tw:0 sw:0 (2 2 -1, 1 1 2 | 1 -2 1, 2 1 2)->(eld) cm:5 fs:2 awk:0 [W, W, U, W, W, U, W, W, W, W, U]}
    {[L, R, C, U, L, R, U, C, L, U, R, C, U] w:9 sy:0 sh:3 tw:0 sw:0 (2 2 1, 1 1 2 | -2 -1 -1, 2 2 1)->(trin) cm:5 fs:2 awk:0 [W, W, U, W, W, U, W, W, U, W, W, U]}

Also, the knots which lack an outer edge (such as  `0 0 1 |` and `0 1 2 |`) typically don't look as good.

    1:   {[L, R, C, U] w:3 sy:0 sh:3 tw:0 sw:0 (1 1 -1, 0 0 1 | 1 -1 1, 1 0 1)->(eld) cm:3 fs:1 awk:0 [W, W, U]}
    2:   {[L, C, R, C, L, R, C, U] w:7 sy:0 sh:2 tw:0 sw:1 (1 2 -2, 0 1 2 | 2 -1 1, 1 1 2)->(eld) cm:5 fs:1 awk:0 [T, T, W, W, W, W, U]}
    3:   {[L, C, R, U, C, L, R, C, U] w:7 sy:0 sh:2 tw:0 sw:0 (2 2 -2, 0 1 2 | 1 -1 1, 1 1 2)->(eld) cm:6 fs:1 awk:0 [T, T, U, W, W, W, W, U]}
    4:   {[L, R, L, C, R, C, L, R, C, U] w:9 sy:0 sh:3 tw:0 sw:2 (1 1 -2, 1 1 2 | 2 -1 1, 2 1 2)->(eld) cm:4 fs:2 awk:0 [W, T, T, T, W, W, W, W, U]}
    5:   {[L, R, L, C, R, U, C, L, R, C, U] w:9 sy:0 sh:3 tw:0 sw:1 (2 1 -2, 1 1 2 | 1 -1 1, 2 1 2)->(eld) cm:5 fs:2 awk:0 [W, T, T, T, U, W, W, W, W, U]}
    6:   {[L, C, L, R, C, R, L, R, C, U] w:9 sy:0 sh:3 tw:0 sw:3 (2 -1 -1, 1 1 2 | 2 -2 1, 2 1 2)->(diag) cm:4 fs:1 awk:0 [T, W, W, W, T, T, W, W, U]}
    7:   {[L, C, L, R, C, R, L, U, R, C, U] w:9 sy:0 sh:3 tw:0 sw:2 (2 -1 1, 1 1 2 | -1 -1 -1, 2 2 1)->(flat) cm:4 fs:1 awk:0 [T, W, W, W, T, T, U, W, W, U]}
    8:   {[L, C, L, R, C, U, R, L, R, C, U] w:9 sy:0 sh:3 tw:0 sw:2 (2 -1 -2, 1 1 2 | 2 -2 1, 2 1 2)->(diag) cm:5 fs:2 awk:0 [T, W, W, W, U, T, T, W, W, U]}
    9:   {[L, R, C, L, C, R, L, R, C, U] w:9 sy:0 sh:3 tw:0 sw:2 (1 -1 -1, 1 1 2 | 2 -1 1, 2 1 2)->(diag) cm:3 fs:1 awk:0 [W, W, W, T, T, T, W, W, U]}
    10:   {[L, R, C, L, C, R, L, U, R, C, U] w:9 sy:0 sh:3 tw:0 sw:1 (1 -1 1, 1 1 2 | -1 -1 -1, 2 2 1)->(flat) cm:3 fs:1 awk:0 [W, W, W, T, T, T, U, W, W, U]}
    11:   {[L, R, C, L, R, C, R, L, C, U] w:9 sy:0 sh:3 tw:0 sw:1 (-1 1 -1, 1 1 2 | -1 -1 1, 2 2 1)->(eld) cm:3 fs:1 awk:0 [W, W, W, W, W, T, T, T, U]}
    12:   {[L, R, C, L, R, C, L, R, C, U] w:9 sy:0 sh:3 tw:0 sw:0 (1 1 -1, 1 1 2 | 2 -1 1, 2 1 2)->(eld) cm:3 fs:1 awk:0 [W, W, W, W, W, W, W, W, U]}
    13:   {[L, R, C, L, R, C, L, U, R, C, U] w:9 sy:0 sh:3 tw:0 sw:0 (1 1 1, 1 1 2 | -1 -1 -1, 2 2 1)->(trin) cm:3 fs:1 awk:0 [W, W, W, W, W, W, U, W, W, U]}
    14:   {[L, R, C, L, R, U, C, L, R, C, U] w:9 sy:0 sh:3 tw:0 sw:0 (2 1 -1, 1 1 2 | 1 -1 1, 2 1 2)->(eld) cm:4 fs:1 awk:0 [W, W, W, W, U, W, W, W, W, U]}
    15:   {[L, R, C, L, R, U, C, L, U, R, C, U] w:9 sy:0 sh:3 tw:0 sw:0 (2 1 1, 1 1 2 | -2 -1 -1, 2 2 1)->(trin) cm:4 fs:1 awk:0 [W, W, W, W, U, W, W, U, W, W, U]}
    16:   {[L, R, C, R, L, C, L, R, C, U] w:9 sy:0 sh:3 tw:0 sw:2 (1 1 -1, 1 1 2 | 1 -1 1, 2 1 2)->(eld) cm:3 fs:1 awk:0 [W, W, T, T, T, W, W, W, U]}
    17:   {[L, R, C, R, L, C, R, L, C, U] w:9 sy:0 sh:3 tw:0 sw:1 (-1 1 -1, 1 1 2 | -2 -1 1, 2 2 1)->(eld) cm:3 fs:1 awk:0 [W, W, T, T, T, T, T, T, U]}
    18:   {[L, R, C, R, L, C, R, U, L, C, U] w:9 sy:0 sh:3 tw:0 sw:1 (-1 -1 -1, 1 1 2 | 1 1 1, 2 1 2)->(trin) cm:3 fs:1 awk:0 [W, W, T, T, T, T, U, T, T, U]}
    19:   {[L, R, C, U, L, R, C, R, L, C, U] w:9 sy:0 sh:3 tw:0 sw:1 (-1 2 -1, 1 1 2 | -1 -1 1, 2 2 1)->(eld) cm:4 fs:2 awk:0 [W, W, U, W, W, W, T, T, T, U]}
    20:   {[L, R, C, U, L, R, C, L, R, C, U] w:9 sy:0 sh:3 tw:0 sw:0 (1 2 -1, 1 1 2 | 2 -2 1, 2 1 2)->(eld) cm:4 fs:2 awk:0 [W, W, U, W, W, W, W, W, W, U]}
    21:   {[L, R, C, U, L, R, C, L, U, R, C, U] w:9 sy:0 sh:3 tw:0 sw:0 (1 2 1, 1 1 2 | -1 -1 -1, 2 2 1)->(trin) cm:4 fs:2 awk:0 [W, W, U, W, W, W, W, U, W, W, U]}
    22:   {[L, R, C, U, L, R, U, C, L, R, C, U] w:9 sy:0 sh:3 tw:0 sw:0 (2 2 -1, 1 1 2 | 1 -2 1, 2 1 2)->(eld) cm:5 fs:2 awk:0 [W, W, U, W, W, U, W, W, W, W, U]}
    23:   {[L, R, C, U, L, R, U, C, L, U, R, C, U] w:9 sy:0 sh:3 tw:0 sw:0 (2 2 1, 1 1 2 | -2 -1 -1, 2 2 1)->(trin) cm:5 fs:2 awk:0 [W, W, U, W, W, U, W, W, U, W, W, U]}
    24:   {[L, R, C, U, R, L, C, L, R, C, U] w:9 sy:0 sh:3 tw:0 sw:1 (1 1 -2, 1 1 2 | 1 -1 1, 2 1 2)->(eld) cm:4 fs:2 awk:0 [W, W, U, T, T, T, W, W, W, U]}
    25:   {[L, R, C, U, R, L, C, R, L, C, U] w:9 sy:0 sh:3 tw:0 sw:0 (-1 1 -2, 1 1 2 | -2 -1 2, 2 2 1)->(eld) cm:4 fs:2 awk:0 [W, W, U, T, T, T, T, T, T, U]}
    26:   {[L, R, C, U, R, L, C, R, U, L, C, U] w:9 sy:0 sh:3 tw:0 sw:0 (-1 -1 -2, 1 1 2 | 1 1 1, 2 1 2)->(trin) cm:4 fs:2 awk:0 [W, W, U, T, T, T, T, U, T, T, U]}
    27:   {[L, C, R, L, R, C, R, L, C, U] w:9 sy:0 sh:3 tw:0 sw:2 (-1 1 -1, 1 1 2 | -1 -1 1, 2 2 1)->(eld) cm:3 fs:1 awk:0 [T, T, T, W, W, T, T, T, U]}
    28:   {[L, C, R, L, R, C, L, R, C, U] w:9 sy:0 sh:3 tw:0 sw:1 (1 1 -1, 1 1 2 | 2 -2 1, 2 1 2)->(eld) cm:3 fs:1 awk:0 [T, T, T, W, W, W, W, W, U]}
    29:   {[L, C, R, L, R, C, L, U, R, C, U] w:9 sy:0 sh:3 tw:0 sw:1 (1 1 1, 1 1 2 | -1 -1 -1, 2 2 1)->(trin) cm:3 fs:1 awk:0 [T, T, T, W, W, W, U, W, W, U]}
    30:   {[L, C, R, L, C, R, L, R, C, U] w:9 sy:0 sh:3 tw:0 sw:1 (1 -1 -1, 1 1 2 | 2 -2 1, 2 1 2)->(diag) cm:3 fs:1 awk:0 [T, T, T, T, T, T, W, W, U]}
    31:   {[L, C, R, L, C, R, L, U, R, C, U] w:9 sy:0 sh:3 tw:0 sw:0 (1 -1 1, 1 1 2 | -1 -1 -1, 2 2 1)->(flat) cm:3 fs:1 awk:0 [T, T, T, T, T, T, U, W, W, U]}
    32:   {[L, C, R, L, C, U, R, L, R, C, U] w:9 sy:0 sh:3 tw:0 sw:1 (1 -1 -2, 1 1 2 | 2 -2 1, 2 1 2)->(diag) cm:4 fs:2 awk:0 [T, T, T, T, U, T, T, W, W, U]}
