package comp1110.ass1;

/**
 * This enumeration defines the nine cards used to play the game.
 */
public enum Card  {	
	/* define each of the nine cards */
	A (new Edge[] { Edge.REDTAIL, Edge.BLUETAIL, Edge.YELLOWHEAD, Edge.REDHEAD}),
	B (new Edge[] { Edge.YELLOWTAIL, Edge.BLUEHEAD, Edge.GREENHEAD, Edge.GREENTAIL }),
	C (new Edge[] { Edge.GREENHEAD, Edge.REDTAIL, Edge.BLUETAIL, Edge.BLUEHEAD }),
	D (new Edge[] { Edge.REDHEAD, Edge.GREENHEAD, Edge.REDHEAD, Edge.BLUETAIL }),
	E (new Edge[] { Edge.GREENHEAD, Edge.YELLOWHEAD, Edge.YELLOWHEAD, Edge.BLUEHEAD }),
	F (new Edge[] { Edge.GREENTAIL, Edge.REDTAIL, Edge.YELLOWTAIL, Edge.YELLOWTAIL }),
	G (new Edge[] { Edge.YELLOWHEAD, Edge.BLUETAIL, Edge.YELLOWTAIL, Edge.GREENTAIL }),
	H (new Edge[] { Edge.REDTAIL, Edge.BLUETAIL, Edge.REDHEAD, Edge.GREENTAIL }),
	I (new Edge[] { Edge.BLUEHEAD, Edge.YELLOWHEAD, Edge.REDTAIL, Edge.GREENHEAD });
	
	/* the four edges of the card */
	private Edge[] edges;
	
	/**
	 * Constructor for the card
	 * 
	 * @param edges The edges for the card
	 */
	Card(Edge[] edges) {
		this.edges = edges;
	}

	/**
	 * Rotate the card to the right by 90 degrees.  This means changing
	 * the order of the edges within the edge array.
	 */
	public void rotateRight() {
		Edge last = this.edges[3];
		this.edges[3] = this.edges[2];
		this.edges[2] = this.edges[1];
		this.edges[1] = this.edges[0];
		this.edges[0] = last;
	}

	/**
	 * Determine whether the card below this one is compatible
	 * with it (do they make a pair?).
	 * 
	 * @param below The card above this one
	 * @return true if the card below is compatible with this one
	 */
	public boolean compatableBelow(Card below) {
		return this.edges[2].compatible(below.edges[0]);
	}
	
	/**
	 * Determine whether the card to the right of this one is
	 * compatible with it (do they make a pair?).
	 * 
	 * @param right The card to the right of this one.
	 * @return true if the card above is compatible with this one
	 */
	public boolean compatableRight(Card right) {
		return this.edges[1].compatible(right.edges[3]);
	}
}
