package comp1110.ass1;

import java.util.ArrayList;
import java.util.Arrays;

import comp1110.ass1.gui.Board;

/**
 * This class defines the puzzle.
 */
public class Puzzle {
	/* constants defining the basic parameters of the puzzle. */
	public static int GRID_SIDE = 3;
	public static int CARDS = GRID_SIDE * GRID_SIDE;

	/* this ArrayList represents the 3 x 3 grid of cards */
	private static ArrayList<Card> grid = new ArrayList<Card>(Arrays.asList(null, null, null, null, null, null, null, null, null));	
	
	/* this ArrayList represents the deck of unplaced cards */
	private static ArrayList<Card> deck = new ArrayList<Card>(Arrays.asList(Card.values()));

	/*
	 * The main() method for our puzzle class.   It simply
	 * starts the graphical user interface (GUI), which is
	 * implemented in the Board class, which is in the 
	 * comp1110.jar.
	 */
	public static void main(String[] args) {
		/* start the GUI which will start the game */
		Board.start();
	}
	
	/**
	 * Attempt to move a card to a new position.
	 * 
	 * @param c The card to be moved
	 * @param target The grid position into to move it
	 * @return True if the card can be moved into position
	 */
	public static boolean attemptToMove(Card c, int target) {
		/* return false if target is occupied by something other than itself */
		if (target != -1 && grid.get(target) != null && grid.get(target) != c)
			return false;
		else {
			/* remove card from current place */
			if (deck.contains(c)) {
				deck.remove(c);
			} else {
				grid.set(grid.indexOf(c), null);
			}
			/* add card to its new place */
			if (target == -1)
				deck.add(c);
			else 
				grid.set(target, c);
			return true;
		}
	}
	
	/**
	 * Return the card that is at the top of the deck.
	 * 
	 * @return The card on the top of the deck, or null if empty
	 */
	public static Card getTopOfDeck() {
		if (deck.isEmpty())
			return null;
		else 
			return deck.get(deck.size()-1);
	}

	/**
	 * Return the current grid position for a given card.
	 * 
	 * @param c The card whose position is being queried.
	 * @return The grid position for this card, or -1 if
	 * it is not in the grid
	 */
	public static int getGridPosition(Card c) {
		if (grid.contains(c))
			return grid.indexOf(c);
		else
			return -1;
	}
	
	/**
	 * Return the current deck position for a given card
	 * 
	 * @param c The card whose position is being queried
	 * @return The position within the deck for this card,
	 * or -1 if it is not in the deck
	 */
	public static int getDeckPosition(Card c) {
		if (deck.contains(c))
			return deck.indexOf(c);
		else 
			return -1;
	}
	
	/**
	 * Determine whether the current grid is valid.  This
	 * means checking whether all adjacent edges are 
	 * compatible.
	 * 
	 * @return True if all adjacent edges are compatible
	 * for all cards in the deck.
	 */
	public static boolean isValid() {
		Card g[] = new Card[CARDS];
		return isValid(grid.toArray(g));
	}
	
	/**
	 * Return a grid that solves the puzzle.
	 * 
	 * @return A grid with a solution to the puzzle.
	 */
	public static Card[] solve() {
		Card g[] = new Card[9];
		return solve(grid.toArray(g));
	}
	
	/**
	 * Given an input array of size 9 which may be empty
	 * (all cards null) or partially populated (some cards
	 * null) with cards, return an output array with a
	 * solution to the puzzle by filling in the empty cards
	 * with valid card placements.   If the puzzle can't be
	 * solved given the input, return null.
	 * 
	 * @param g An input array of cards (possibly empty)
	 * @return An array of cards that solves the puzzle or null.
	 */
	private static Card[] solve(Card[] g) {
		/* YOUR Q6 CODE REPLACES THE LINE BELOW - HARDER! */
		return null;
	}
	
	/**
	 * Determine whether the given array of Cards constitutes
	 * a valid grid.  This means that when cards are adjacent
	 * their edges must be compatible.  Edges with no neighbors
	 * (either because they are on the side of the grid, or
	 * because the grid is not full) are always valid.  Only
	 * edges with neighbors can be invalid.
	 * 
	 * @param g The grid to be checked.
	 * @return True if all adjacent edges in the grid are compatible.
	 */
	public static boolean isValid(Card g[]) {
		for (int i = 0; i < 9; i++) {
			if ((i + 1) % 3 != 0) {
				if (!g[i].compatableRight(g[i+1])) return false;
			}
			if (i < 6) {
				if (!g[i].compatableBelow(g[i+3])) return false;
			}
		}
		return true;
	}
}
