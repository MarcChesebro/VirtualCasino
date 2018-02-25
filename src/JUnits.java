import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
/*******************************
 * Junit testing for the Virtual Casino
 * @author Brendan Caywood, Marc Cheesebro, Patrick McMahon
 * @version 2/23/18
 ******************************/
public class JUnits {

	@Test
	void testRouWheelSpin() {
		RouWheel wheel = new RouWheel();
		wheel.spin();
		assertFalse(wheel.getValue() > 0 && wheel.getValue() < 37);
	}

	@Test
	void testRouWheelCheckBet() {
		RouWheel wheel = new RouWheel();
		wheel.spin();

	}

	@Test
	public void testCardgetValues1() {
		Card card = new Card(Card.Suit.club, 1);
		int[] expected = {1, 11};
		assertTrue(card.getValues == expected);
	}

	@Test
	public void testCardgetValues2() {
		Card card = new Card(Card.Suit.club, 2);
		int[] expected = {2};
		assertTrue(card.getValues == expected);
	}

	@Test
	public void testCardgetValues3() {
		Card card = new Card(Card.Suit.club, 3);
		int[] expected = {3};
		assertTrue(card.getValues == expected);
	}

	@Test
	public void testCardgetValues4() {
		Card card = new Card(Card.Suit.club, 4);
		int[] expected = {4};
		assertTrue(card.getValues == expected);
	}

	@Test
	public void testCardgetValues5() {
		Card card = new Card(Card.Suit.club, 5);
		int[] expected = {5};
		assertTrue(card.getValues == expected);
	}

	@Test
	public void testCardgetValues6() {
		Card card = new Card(Card.Suit.club, 6);
		int[] expected = {6};
		assertTrue(card.getValues == expected);
	}

	@Test
	public void testCardgetValues7() {
		Card card = new Card(Card.Suit.club, 7);
		int[] expected = {7};
		assertTrue(card.getValues == expected);
	}

	@Test
	public void testCardgetValues8() {
		Card card = new Card(Card.Suit.club, 8);
		int[] expected = {8};
		assertTrue(card.getValues == expected);
	}

	@Test
	public void testCardgetValues9() {
		Card card = new Card(Card.Suit.club, 9);
		int[] expected = {9};
		assertTrue(card.getValues == expected);
	}

	@Test
	public void testCardgetValues10() {
		Card card = new Card(Card.Suit.club, 10);
		int[] expected = {10};
		assertTrue(card.getValues == expected);
	}

	@Test
	public void testCardgetValuesJack() {
		Card card = new Card(Card.Suit.club, 11);
		int[] expected = {10};
		assertTrue(card.getValues == expected);
	}

	@Test
	public void testCardgetValuesQueen() {
		Card card = new Card(Card.Suit.club, 12);
		int[] expected = {10};
		assertTrue(card.getValues == expected);
	}

	@Test
	public void testCardgetValuesKing() {
		Card card = new Card(Card.Suit.club, 13);
		int[] expected = {10};
		assertTrue(card.getValues == expected);
	}

	@Test
	public void testCardgetValuesDiamond() {
		Card card = new Card(Card.Suit.diamond, 1);
		int[] expected = {1, 11};
		assertTrue(card.getValues == expected);
	}

	@Test
	public void testCardgetValuesHeart() {
		Card card = new Card(Card.Suit.heart, 1);
		int[] expected = {1, 11};
		assertTrue(card.getValues == expected);
	}

	@Test
	public void testCardgetValuesSpade() {
		Card card = new Card(Card.Suit.spade, 1);
		int[] expected = {1, 11};
		assertTrue(card.getValues == expected);
	}

	@test
	public void testCardgetSuit1() {
		Card card = new Card(Card.Suit.spade, 1);
		Card.Suit expected = Card.Suit.spade;
		assertTrue(card.getSuit() == expected);
	}


}
