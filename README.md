# TieKnots
generating, enumerating, and filtering tie knots

-

This program currently supports the 24,882+ knots of the regular sub-category of knots (described in [More ties than we thought](https://arxiv.org/abs/1401.8242)).  These knots are typically tied with the narrow end, and can have multiple tucks, but the main restriction is that you can only tuck under the most recent loop, and you can't tuck under multiple loops at once.

Other important informational resources are the [random tieknots page](http://tieknots.johanssons.org/) (which describes the grammar/notation used to produce these knots, and has a list of some of the "exotic" knots) and [encyclopedia of knots](http://www.tcm.phy.cam.ac.uk/~tmf20/tieknots.shtml) (which focuses on the traditional 85).

This software goes beyond previous work in that it is capable of determining what a given knot will *look like* given its move sequence.  Knots are sorted into four main categories: flat-like, eldredge-like, trinity-like, and diagonal-like.  It is also capable of detecting the "complexity" of the knot face (number of pieces of fabric visible) as well as detecting move sequences that are awkward or impractical in reality (these moves typically create irregular-looking knots outside of the above categories, but their shapes are hard to predict).

This program does not currently have any "interactivitity," as in all filtering is done by editing a couple lines of the source code (that's just been the easy way to do it).

Here's a list of the knot "properties" which are calculated in the process of knot evaluation.  Several of the names are subject to change as I figure out better things to call them by.
- CLRU move notation.  Most of the current code uses this notation system.
- TWU move notation.  In the future, the project will probably focus more on this notation.
- Weight.  Represents the amount of material used, and is equal to the number of steps minus the number of tucks.
- Symmetry.  Is the difference of R moves minus L moves, a result of 0 says that an equal amount of material is used in both halves.  Small knots (weight < 10) should typically have perfect symmetry, while larger knots can tolerate a asymmetry of +/- 1.
- Shape.  Is the total weight devided by the number of center moves.  A value of 3 is normal, 2 means wider, 4 means narrower.
- Twirl.  Counts the number of occurances of an LRLR/CLCL/etc. move pattern, where the thin blade circles all the way around one of the corners of the knot.  This leads to a less secure knot and should typically be avoided unless necessary for the design of the knot.
- Switchbacks.  Counts the number of LRL/RCR/etc. move patterns.  These also weaken the structure of the knot but are typically needed to make the design.  I typically set an upper limit of 2.
- Face category.  One of "flat", "eld", "trin", or "diag". This is determined based on the assumption that the thin end is used. These are further described by a set of numbers such as `(2 -1 -1, 1 1 2 |` to give number/direction of inner edges (visible on the face of the knot) and number of outer edges (visible between the knot and the rest of the tie).
- Complexity.  Number of pieces of fabric visible on the face of the knot.  This also assumes a thin-blade knot.  The minimum is 3, while the eldredge has 5.
- Face symmetry.  Looks at the differences of both external and internal edges for the left/right side of the knot face.  Inequality of any type increases this value, with a score of 0 meaning a visually balanced knot.  Most complex knots have some amount of facial asymmetry depending on the design.  For example, a trinity knot has a score of 0, while an eldredge knot has a score of 1.
- Awkwardness.  This is a catch-all counter for any move sequence which might be difficult to realize physically, or which may cause the knot to adopt some shape other than the generalized hexagonal shape.  Awkwardly shaped knots may be difficult to tie, but may occasionally lead to interesting designs (much more difficult to predict).  Awkwardness may be induced by midtucks which require the end to be tucked through a loop which doesn't physically line up with where the end has to go next, requiring some contortion of the knot.  I typically filter out all awkward knots.

Face Calculation
-

The face of the knot is modeled as a hexagon, like this.

            \  _________  /
             \/\       /\/
             /  \     /  \
         \  /    \   /    \  /
          \/      \ /      \/
          (--------X--------)
           \      / \      /
            \    /   \    /
             \  /     \  /
              \/_______\/
               |       |
               |       |
               
Each edge is assigned a name.


            \  _________  /
             \/\       /\/
             / cf+   cf- \
         \  le   \   /    re /
          \/      \ /      \/
          (-lf(-)--X---rf+--)
           \      / \      /
            \    /   \    /
             \ lf+   rf- /
              \/___ce__\/
               |       |
               |       |

The face is calculated by keeping track of which edges are present and in which number.  There are four main categories of faces, as shown below.  These can also be mirrored left-to-right, but that still counts as part of the same category.

               
         Flat (++-/-+-)
            \  _________  /
             \/\        \/
             /  \        \
         \  /    \        \  /
          \/      \        \/
          (--------X--------)
           \               /
            \             /
             \           /
              \ _______ /
               |       |
               |       |
               
         Eldredge (+-+/--+)
            \  _________  /
             \/\        \/
             /  \        \
         \  /    \        \  /
          \/      \        \/
          (        X        )
           \      / \      /
            \    /   \    /
             \  /     \  /
              \/_______\/
               |       |
               |       |
               
         Trinity (+++/---)
            \  _________  /
             \/\        \/
             /  \        \
         \  /    \        \  /
          \/      \        \/
          (        X--------)
           \      /        /
            \    /        /
             \  /        /
              \/_______ /
               |       |
               |       |
               
         Diagonal (+--/-++)
            \  _________  /
             \/\        \/
             /  \        \
         \  /    \        \  /
          \/      \        \/
          (--------X        )
           \        \      /
            \        \    /
             \        \  /
              \ _______\/
               |       |
               |       |
               
