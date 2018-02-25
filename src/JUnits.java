// import static org.junit.jupiter.api.Assertions.assertFalse;
// import static org.junit.jupiter.api.Assertions.assertTrue;

// import org.junit.Test;
// /*******************************
//  * Junit testing for the Virtual Casino
//  * @author Brendan Caywood, Marc Cheesebro, Patrick McMahon
//  * @version 2/23/18
//  ******************************/
// public class JUnits {

// 	@Test
// 	public void testRouWheelSpin() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.spin();
// 		assertTrue(wheel.getValue() > 0 && wheel.getValue() < 37);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetCol1T() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(1);
// 		assertTrue(wheel.checkBet(2) == 2);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetCol1F() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(33);
// 		assertFalse(wheel.checkBet(2) == 2);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetCol2T() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(2);
// 		assertTrue(wheel.checkBet(3) == 2);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetCol2F() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(33);
// 		assertFalse(wheel.checkBet(3) == 2);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetCol3T() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(3);
// 		assertTrue(wheel.checkBet(4) == 2);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetCol3F() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(32);
// 		assertFalse(wheel.checkBet(4) == 2);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetDoz1T() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(1);
// 		assertTrue(wheel.checkBet(5) == 2);
// 		wheel.setValue(32);
// 		assertFalse(wheel.checkBet(5) == 2);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetDoz1F() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(32);
// 		assertFalse(wheel.checkBet(5) == 2);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetDoz2T() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(13);
// 		assertTrue(wheel.checkBet(6) == 2);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetDoz2F() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(1);
// 		assertFalse(wheel.checkBet(6) == 2);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetDoz3T() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(35);
// 		assertTrue(wheel.checkBet(7) == 2);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetDoz3F() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(1);
// 		assertFalse(wheel.checkBet(7) == 2);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetBlackT() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(2);
// 		assertTrue(wheel.checkBet(8) == 1);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetBlackF() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(1);
// 		assertFalse(wheel.checkBet(8) == 1);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetRedT() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(1);
// 		assertTrue(wheel.checkBet(9) == 1);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetRedF() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(2);
// 		assertFalse(wheel.checkBet(9) == 1);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetOddsT() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(1);
// 		assertTrue(wheel.checkBet(10) == 1);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetOddsF() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(2);
// 		assertFalse(wheel.checkBet(10) == 1);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetEvensT() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(2);
// 		assertTrue(wheel.checkBet(11) == 1);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetEvensF() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(1);
// 		assertFalse(wheel.checkBet(11) == 1);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetHalf1T() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(2);
// 		assertTrue(wheel.checkBet(12) == 1);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetHalf1F() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(34);
// 		assertFalse(wheel.checkBet(12) == 1);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetHalf2T() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(34);
// 		assertTrue(wheel.checkBet(13) == 1);
// 	}

// 	@Test
// 	public void testRouWheelCheckBetHalf2F() {
// 		RouWheel wheel = new RouWheel();
// 		wheel.setValue(2);
// 		assertFalse(wheel.checkBet(13) == 1);
// 	}
	
// 	@Test
// 	public void testCardgetValues1() {
// 		Card card = new Card(Card.Suit.club, 1);
// 		int[] expected = {1, 11};
// 		assertTrue(card.getValues() == expected);
// 	}

// 	@Test
// 	public void testCardgetValues2() {
// 		Card card = new Card(Card.Suit.club, 2);
// 		int[] expected = {2};
// 		assertTrue(card.getValues() == expected);
// 	}

// 	@Test
// 	public void testCardgetValues3() {
// 		Card card = new Card(Card.Suit.club, 3);
// 		int[] expected = {3};
// 		assertTrue(card.getValues() == expected);
// 	}

// 	@Test
// 	public void testCardgetValues4() {
// 		Card card = new Card(Card.Suit.club, 4);
// 		int[] expected = {4};
// 		assertTrue(card.getValues() == expected);
// 	}

// 	@Test
// 	public void testCardgetValues5() {
// 		Card card = new Card(Card.Suit.club, 5);
// 		int[] expected = {5};
// 		assertTrue(card.getValues() == expected);
// 	}

// 	@Test
// 	public void testCardgetValues6() {
// 		Card card = new Card(Card.Suit.club, 6);
// 		int[] expected = {6};
// 		assertTrue(card.getValues() == expected);
// 	}

// 	@Test
// 	public void testCardgetValues7() {
// 		Card card = new Card(Card.Suit.club, 7);
// 		int[] expected = {7};
// 		assertTrue(card.getValues() == expected);
// 	}

// 	@Test
// 	public void testCardgetValues8() {
// 		Card card = new Card(Card.Suit.club, 8);
// 		int[] expected = {8};
// 		assertTrue(card.getValues() == expected);
// 	}

// 	@Test
// 	public void testCardgetValues9() {
// 		Card card = new Card(Card.Suit.club, 9);
// 		int[] expected = {9};
// 		assertTrue(card.getValues() == expected);
// 	}

// 	@Test
// 	public void testCardgetValues10() {
// 		Card card = new Card(Card.Suit.club, 10);
// 		int[] expected = {10};
// 		assertTrue(card.getValues() == expected);
// 	}

// 	@Test
// 	public void testCardgetValuesJack() {
// 		Card card = new Card(Card.Suit.club, 11);
// 		int[] expected = {10};
// 		assertTrue(card.getValues() == expected);
// 	}

// 	@Test
// 	public void testCardgetValuesQueen() {
// 		Card card = new Card(Card.Suit.club, 12);
// 		int[] expected = {10};
// 		assertTrue(card.getValues() == expected);
// 	}

// 	@Test
// 	public void testCardgetValuesKing() {
// 		Card card = new Card(Card.Suit.club, 13);
// 		int[] expected = {10};
// 		assertTrue(card.getValues() == expected);
// 	}

// 	@Test
// 	public void testCardgetValuesDiamond() {
// 		Card card = new Card(Card.Suit.diamond, 1);
// 		int[] expected = {1, 11};
// 		assertTrue(card.getValues() == expected);
// 	}

// 	@Test
// 	public void testCardgetValuesHeart() {
// 		Card card = new Card(Card.Suit.heart, 1);
// 		int[] expected = {1, 11};
// 		assertTrue(card.getValues() == expected);
// 	}

// 	@Test
// 	public void testCardgetValuesSpade() {
// 		Card card = new Card(Card.Suit.spade, 1);
// 		int[] expected = {1, 11};
// 		assertTrue(card.getValues() == expected);
// 	}

// 	@Test
// 	public void testCardgetSuit1() {
// 		Card card = new Card(Card.Suit.spade, 1);
// 		Card.Suit expected = Card.Suit.spade;
// 		assertTrue(card.getSuit() == expected);
// 	}
// }
