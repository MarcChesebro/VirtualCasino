package virtualcasino;

//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/*******************************
 * Junit testing for the Virtual Casino.
 * @author Brendan Caywood, Marc Cheesebro, Patrick McMahon
 * @version 2/23/18
 ******************************/
public class JUnits {
	//CHECKSTYLE:OFF
	@Test
	public void testRouWheelSpin() {
		RouWheel wheel = new RouWheel();
		wheel.spin();
		assertTrue(wheel.getValue() > 0 && wheel.getValue() < 37);
	}

	@Test
	public void testRouWheelCheckBetCol1T() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(1);
		assertTrue(wheel.checkBet(2, 0) == 2);
	}
	
	@Test
	public void testInvalidBet() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(1);
		assertTrue(wheel.checkBet(15, 0) == 0);
	}

	@Test
	public void testRouWheelCheckBetCol1F() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(33);
		assertFalse(wheel.checkBet(2, 0) == 2);
	}

	@Test
	public void testRouWheelCheckBetCol2T() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(2);
		assertTrue(wheel.checkBet(3, 0) == 2);
	}

	@Test
	public void testRouWheelCheckBetCol2F() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(33);
		assertFalse(wheel.checkBet(3, 0) == 2);
	}

	@Test
	public void testRouWheelCheckBetCol3T() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(3);
		assertTrue(wheel.checkBet(4, 0) == 2);
	}

	@Test
	public void testRouWheelCheckBetCol3F() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(32);
		assertFalse(wheel.checkBet(4, 0) == 2);
	}

	@Test
	public void testRouWheelCheckBetDoz1T() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(1);
		assertTrue(wheel.checkBet(5, 0) == 2);
		wheel.setValue(32);
		assertFalse(wheel.checkBet(5, 0) == 2);
	}

	@Test
	public void testRouWheelCheckBetDoz1F() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(32);
		assertFalse(wheel.checkBet(5, 0) == 2);
	}

	@Test
	public void testRouWheelCheckBetDoz2T() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(13);
		assertTrue(wheel.checkBet(6, 0) == 2);
	}

	@Test
	public void testRouWheelCheckBetDoz2F() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(1);
		assertFalse(wheel.checkBet(6, 0) == 2);
	}

	@Test
	public void testRouWheelCheckBetDoz3T() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(35);
		assertTrue(wheel.checkBet(7, 0) == 2);
	}

	@Test
	public void testRouWheelCheckBetDoz3F() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(1);
		assertFalse(wheel.checkBet(7, 0) == 2);
	}

	@Test
	public void testRouWheelCheckBetBlackT() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(2);
		assertTrue(wheel.checkBet(8, 0) == 1);
	}

	@Test
	public void testRouWheelCheckBetBlackF() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(1);
		assertFalse(wheel.checkBet(8, 0) == 1);
	}

	@Test
	public void testRouWheelCheckBetRedT() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(1);
		assertTrue(wheel.checkBet(9, 0) == 1);
	}

	@Test
	public void testRouWheelCheckBetRedF() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(2);
		assertFalse(wheel.checkBet(9, 0) == 1);
	}

	@Test
	public void testRouWheelCheckBetOddsT() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(1);
		assertTrue(wheel.checkBet(10, 0) == 1);
	}

	@Test
	public void testRouWheelCheckBetOddsF() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(2);
		assertFalse(wheel.checkBet(10, 0) == 1);
	}

	@Test
	public void testRouWheelCheckBetEvensT() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(2);
		assertTrue(wheel.checkBet(11, 0) == 1);
	}

	@Test
	public void testRouWheelCheckBetEvensF() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(1);
		assertFalse(wheel.checkBet(11, 0) == 1);
	}

	@Test
	public void testRouWheelCheckBetHalf1T() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(2);
		assertTrue(wheel.checkBet(12, 0) == 1);
	}

	@Test
	public void testRouWheelCheckBetHalf1F() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(34);
		assertFalse(wheel.checkBet(12, 0) == 1);
	}

	@Test
	public void testRouWheelCheckBetHalf2T() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(34);
		assertTrue(wheel.checkBet(13, 0) == 1);
	}

	@Test
	public void testRouWheelCheckBetHalf2F() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(2);
		assertFalse(wheel.checkBet(13, 0) == 1);
	}
	
	@Test
	public void testCardgetValues1() {
		Card card = new Card(Card.Suit.club, 1);
		int[] expected = {1, 11};
		assertTrue(Arrays.equals(card.getValues(), expected));
	}

	@Test
	public void testCardgetValues2() {
		Card card = new Card(Card.Suit.club, 2);
		int[] expected = {2};
		assertTrue(Arrays.equals(card.getValues(), expected));
	}

	@Test
	public void testCardgetValues3() {
		Card card = new Card(Card.Suit.club, 3);
		int[] expected = {3};
		assertTrue(Arrays.equals(card.getValues(), expected));
	}

	@Test
	public void testCardgetValues4() {
		Card card = new Card(Card.Suit.club, 4);
		int[] expected = {4};
		assertTrue(Arrays.equals(card.getValues(), expected));
	}

	@Test
	public void testCardgetValues5() {
		Card card = new Card(Card.Suit.club, 5);
		int[] expected = {5};
		assertTrue(Arrays.equals(card.getValues(), expected));
	}

	@Test
	public void testCardgetValues6() {
		Card card = new Card(Card.Suit.club, 6);
		int[] expected = {6};
		assertTrue(Arrays.equals(card.getValues(), expected));
	}

	@Test
	public void testCardgetValues7() {
		Card card = new Card(Card.Suit.club, 7);
		int[] expected = {7};
		assertTrue(Arrays.equals(card.getValues(), expected));
	}

	@Test
	public void testCardgetValues8() {
		Card card = new Card(Card.Suit.club, 8);
		int[] expected = {8};
		assertTrue(Arrays.equals(card.getValues(), expected));
	}

	@Test
	public void testCardgetValues9() {
		Card card = new Card(Card.Suit.club, 9);
		int[] expected = {9};
		assertTrue(Arrays.equals(card.getValues(), expected));
	}

	@Test
	public void testCardgetValues10() {
		Card card = new Card(Card.Suit.club, 10);
		int[] expected = {10};
		assertTrue(Arrays.equals(card.getValues(), expected));
	}

	@Test
	public void testCardgetValuesJack() {
		Card card = new Card(Card.Suit.club, 11);
		int[] expected = {10};
		assertTrue(Arrays.equals(card.getValues(), expected));
	}

	@Test
	public void testCardgetValuesQueen() {
		Card card = new Card(Card.Suit.club, 12);
		int[] expected = {10};
		assertTrue(Arrays.equals(card.getValues(), expected));
	}

	@Test
	public void testCardgetValuesKing() {
		Card card = new Card(Card.Suit.club, 13);
		int[] expected = {10};
		assertTrue(Arrays.equals(card.getValues(), expected));
	}

	@Test
	public void testCardgetValuesDiamond() {
		Card card = new Card(Card.Suit.diamond, 1);
		int[] expected = {1, 11};
		assertTrue(Arrays.equals(card.getValues(), expected));
	}

	@Test
	public void testCardgetValuesHeart() {
		Card card = new Card(Card.Suit.heart, 1);
		int[] expected = {1, 11};
		assertTrue(Arrays.equals(card.getValues(), expected));
	}

	@Test
	public void testCardgetValuesSpade() {
		Card card = new Card(Card.Suit.spade, 1);
		int[] expected = {1, 11};
		assertTrue(Arrays.equals(card.getValues(), expected));
	}

	@Test
	public void testCardgetSuit1() {
		Card card = new Card(Card.Suit.spade, 1);
		Card.Suit expected = Card.Suit.spade;
		assertTrue(card.getSuit() == expected);
	}

	@Test
	public void testCardgetSuit2() {
		Card card = new Card(Card.Suit.club, 1);
		Card.Suit expected = Card.Suit.club;
		assertTrue(card.getSuit() == expected);
	}

	@Test
	public void testCardgetSuit3() {
		Card card = new Card(Card.Suit.heart, 1);
		Card.Suit expected = Card.Suit.heart;
		assertTrue(card.getSuit() == expected);
	}

	@Test
	public void testCardgetSuit4() {
		Card card = new Card(Card.Suit.diamond, 1);
		Card.Suit expected = Card.Suit.diamond;
		assertTrue(card.getSuit() == expected);
	}

	@Test
	public void testCardgetNumber1() {
		Card card = new Card(Card.Suit.spade, 1);
		int expected = 1;
		assertTrue(card.getNumber() == expected);
	}

	@Test
	public void testCardgetNumber2() {
		Card card = new Card(Card.Suit.spade, 2);
		int expected = 2;
		assertTrue(card.getNumber() == expected);
	}

	@Test
	public void testCardgetNumber3() {
		Card card = new Card(Card.Suit.spade, 3);
		int expected = 3;
		assertTrue(card.getNumber() == expected);
	}

	@Test
	public void testCardgetNumber4() {
		Card card = new Card(Card.Suit.spade, 4);
		int expected = 4;
		assertTrue(card.getNumber() == expected);
	}

	@Test
	public void testCardsetNumber1() {
		Card card = new Card(Card.Suit.spade, 1);
		card.setNumber(4);
		int expected = 4;
		assertTrue(card.getNumber() == expected);
	}

	@Test
	public void testCardsetSuit1() {
		Card card = new Card(Card.Suit.diamond, 1);
		card.setSuit(Card.Suit.club);
		Card.Suit expected = Card.Suit.club;
		assertTrue(card.getSuit() == expected);
	}

	@Test
	public void testCardtoString1() {
		Card card = new Card(Card.Suit.diamond, 1);
		String expected = "Ace of diamond";
		assertTrue(card.toString().equals(expected));
	}
	@Test
	public void testCardtoString2() {
		Card card = new Card(Card.Suit.diamond, 2);
		String expected = "2 of diamond";
		assertTrue(card.toString().equals(expected));
	}
	@Test
	public void testCardtoString3() {
		Card card = new Card(Card.Suit.diamond, 11);
		String expected = "Jack of diamond";
		assertTrue(card.toString().equals(expected));
	}

	@Test
	public void testCardtoString4() {
		Card card = new Card(Card.Suit.diamond, 12);
		String expected = "Queen of diamond";
		assertTrue(card.toString().equals(expected));
	}

	@Test
	public void testCardtoString5() {
		Card card = new Card(Card.Suit.diamond, 13);
		String expected = "King of diamond";
		assertTrue(card.toString().equals(expected));
	}

	@Test
	public void testDeckConstructor(){
		Deck deck = new Deck();
		assertTrue(true);
	}

	@Test
	public void testDeckShuffle(){
		Deck deck = new Deck();
		deck.shuffle();
		deck.drawCard();
		deck.drawCard();
		deck.drawCard();
		deck.shuffle();
		deck.shuffle();
		assertTrue(true);
	}

	@Test
	public void testDeckdrawCard(){
		Deck deck = new Deck();
		deck.drawCard();
		deck.drawCard();
		deck.drawCard();
		deck.drawCard();
		assertTrue(true);
	}

	@Test
	public void testDecktotalValue1(){
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new Card(Card.Suit.spade, 1));
		hand.add(new Card(Card.Suit.club, 11));
		int expected = 21;
		assertTrue(Deck.totalValue(hand) == expected);
	}

	@Test
	public void testDecktotalValue2(){
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new Card(Card.Suit.spade, 1));
		hand.add(new Card(Card.Suit.club, 11));
		hand.add(new Card(Card.Suit.spade, 11));
		int expected = 21;
		assertTrue(Deck.totalValue(hand) == expected);
	}

	@Test
	public void testDecktotalValue3(){
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new Card(Card.Suit.spade, 1));
		hand.add(new Card(Card.Suit.club, 6));
		hand.add(new Card(Card.Suit.spade, 5));
		int expected = 12;
		assertTrue(Deck.totalValue(hand) == expected);
	}

	@Test
	public void testDecktotalValue4(){
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(new Card(Card.Suit.spade, 1));
		hand.add(new Card(Card.Suit.diamond, 1));
		hand.add(new Card(Card.Suit.spade, 6));
		int expected = 18;
		assertTrue(Deck.totalValue(hand) == expected);
	}
        
        @Test
        public void testWinLose1(){
            int temp = 5;
            Player player = new Player(100,"name");
            Slots SlotsPlayer = new Slots(player);
            SlotsPlayer.setBet(temp);
            String testVal = SlotsPlayer.winLose(6);
            
            assertTrue(testVal == "You Won $5");
            
        }
        
        @Test
        public void testWinLose2(){
            int temp = 5;
            Player player = new Player(100,"name");
            Slots SlotsPlayer = new Slots(player);
            SlotsPlayer.setBet(temp);
            String testVal = SlotsPlayer.winLose(5);
            
            assertTrue(testVal == "You kept your $5");
            
        }
        
        @Test
        public void testWinLose3(){
            int temp = 5;
            Player player = new Player(100,"name");
            Slots SlotsPlayer = new Slots(player);
            SlotsPlayer.setBet(temp);
            String testVal = SlotsPlayer.winLose(0);
            
            assertTrue(testVal == "You lost $5");
            
        }
        
        @Test
        public void testCheckBet1(){
            Player player = new Player(100,"name");
            Slots SlotsPlayer = new Slots(player);
            assertTrue(true == SlotsPlayer.checkBet(1));
        }
        
        @Test
        public void testCheckBet2(){
            Player player = new Player(100,"name");
            Slots SlotsPlayer = new Slots(player);
            assertTrue(false == SlotsPlayer.checkBet(-1));
        }
        
        @Test
        public void testCheckBet3(){
            Player player = new Player(100,"name");
            Slots SlotsPlayer = new Slots(player);
            assertTrue(false == SlotsPlayer.checkBet(200));
        }
        
/*
	@Test
	public void testPlayerConstructor(){
		Player player = new Player(100);
		assertTrue(true);
	}

	@Test
	public void testPlayergetMoney1(){
		Player player = new Player(100);
		int expected = 100;
		assertTrue(player.getMoney() == expected);
	}

	@Test
	public void testPlayergetMoney2(){
		Player player = new Player(1000);
		int expected = 1000;
		assertTrue(player.getMoney() == expected);
	}

	@Test
	public void testPlayersetMoney1(){
		Player player = new Player(100);
		player.setMoney(1000);
		int expected = 1000;
		assertTrue(player.getMoney() == expected);
	}

	@Test
	public void testPlayersetMoney2(){
		Player player = new Player(100);
		player.setMoney(1);
		int expected = 1;
		assertTrue(player.getMoney() == expected);
	}

	@Test
	public void testPlayerchangeMoney1(){
		Player player = new Player(100);
		player.changeMoney(100);
		int expected = 200;
		assertTrue(player.getMoney() == expected);
	}

	@Test
	public void testPlayerchangeMoney2(){
		Player player = new Player(100);
		player.changeMoney(-50);
		int expected = 50;
		assertTrue(player.getMoney() == expected);
	}
	*/
	//CHECKSTYLE:ON
}
