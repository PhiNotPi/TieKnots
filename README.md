# TieKnots
generating, enumerating, and filtering tie knots

-

This program currently supports the 24,882+ knots of the regular sub-category of knots (described in [More ties than we thought](https://arxiv.org/abs/1401.8242)).  These knots are typically tied with the narrow end, and can have multiple tucks, but the main restriction is that you can only tuck under the most recent loop, and you can't tuck under multiple loops at once.

Other important resources are the [random tieknots page](http://tieknots.johanssons.org/) (which describes the grammar/notation used to produce these knots, and has a list of some of the "exotic" knots) and [encyclopedia of knots](http://www.tcm.phy.cam.ac.uk/~tmf20/tieknots.shtml) (which focuses on the traditional 85).

This software goes beyond previous work in that it is capable of determining what a given knot will *look like* given its move sequence.  Knots are sorted into four main categories: flat-like, eldredge-like, trinity-like, and diagonal-like.  It is also capable of detecting the "complexity" of the knot face (number of pieces of fabric visible) as well as detecting move sequences that are awkward or impractical in reality (these moves typically create irregular-looking knots outside of the above categories, but their shapes are hard to predict).
