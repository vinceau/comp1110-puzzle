package comp1110.ass1;

/**
 * This enumeration defines the eight different possible edges
 * a card may have.
 */
public enum Edge {
	/* define each of the eight possible edges */
	BLUEHEAD   (Color.BLUE, true),
	BLUETAIL   (Color.BLUE, false),
	REDHEAD    (Color.RED, true),
	REDTAIL    (Color.RED, false),
	GREENHEAD  (Color.GREEN, true),
	GREENTAIL  (Color.GREEN, false),
	YELLOWHEAD (Color.YELLOW, true),
	YELLOWTAIL (Color.YELLOW, false);
	
	/* the color of the edge */
	private final Color color;
	
	/* is the edge a head or a tail? */
	private final boolean head;
	
	/**
	 * Constructor for an edge
	 * 
	 * @param color The color of the edge
	 * @param head True of the edge is a head
	 */
	Edge(Color color, boolean head) {
		this.color = color;
		this.head = head;
	}
	
	/**
	 * Determine whether two edges are compatible
	 * 
	 * @param other The edge to compare with
	 * @return true if this edge and the other edge are
	 * compatible (same color, opposite ends).
	 */
	public boolean compatible(Edge other) {
		return this.color == other.color && this.head != other.head;
	}
}
