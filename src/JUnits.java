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
	public void testRouWheelSpin() {
		RouWheel wheel = new RouWheel();
		wheel.spin();
		assertTrue(wheel.getValue() > 0 && wheel.getValue() < 37);
	}
	
	@Test
	public void testRouWheelCheckBetCol1T() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(1);
		assertTrue(wheel.checkBet(2) == 2);
	}
	
	@Test
	public void testRouWheelCheckBetCol1F() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(33);
		assertFalse(wheel.checkBet(2) == 2);
	}
	
	@Test
	public void testRouWheelCheckBetCol2T() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(2);
		assertTrue(wheel.checkBet(3) == 2);
	}
	
	@Test
	public void testRouWheelCheckBetCol2F() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(33);
		assertFalse(wheel.checkBet(3) == 2);
	}
	
	@Test
	public void testRouWheelCheckBetCol3T() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(3);
		assertTrue(wheel.checkBet(4) == 2);
	}
	
	@Test
	public void testRouWheelCheckBetCol3F() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(32);
		assertFalse(wheel.checkBet(4) == 2);
	}
	
	@Test
	public void testRouWheelCheckBetDoz1T() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(1);
		assertTrue(wheel.checkBet(5) == 2);
		wheel.setValue(32);
		assertFalse(wheel.checkBet(5) == 2);
	}
	
	@Test
	public void testRouWheelCheckBetDoz1F() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(32);
		assertFalse(wheel.checkBet(5) == 2);
	}
	
	@Test
	public void testRouWheelCheckBetDoz2T() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(13);
		assertTrue(wheel.checkBet(6) == 2);
	}
	
	@Test
	public void testRouWheelCheckBetDoz2F() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(1);
		assertFalse(wheel.checkBet(6) == 2);
	}
	
	@Test
	public void testRouWheelCheckBetDoz3T() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(35);
		assertTrue(wheel.checkBet(7) == 2);
	}
	
	@Test
	public void testRouWheelCheckBetDoz3F() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(1);
		assertFalse(wheel.checkBet(7) == 2);
	}

	@Test
	public void testRouWheelCheckBetBlackT() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(2);
		assertTrue(wheel.checkBet(8) == 1);
	}
	
	@Test
	public void testRouWheelCheckBetBlackF() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(1);
		assertFalse(wheel.checkBet(8) == 1);
	}
	
	@Test
	public void testRouWheelCheckBetRedT() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(1);
		assertTrue(wheel.checkBet(9) == 1);
	}
	
	@Test
	public void testRouWheelCheckBetRedF() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(2);
		assertFalse(wheel.checkBet(9) == 1);
	}
	
	@Test
	public void testRouWheelCheckBetOddsT() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(1);
		assertTrue(wheel.checkBet(10) == 1);
	}
	
	@Test
	public void testRouWheelCheckBetOddsF() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(2);
		assertFalse(wheel.checkBet(10) == 1);
	}
	
	@Test
	public void testRouWheelCheckBetEvensT() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(2);
		assertTrue(wheel.checkBet(11) == 1);
	}
	
	@Test
	public void testRouWheelCheckBetEvensF() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(1);
		assertFalse(wheel.checkBet(11) == 1);
	}
	
	@Test
	public void testRouWheelCheckBetHalf1T() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(2);
		assertTrue(wheel.checkBet(12) == 1);
	}
	
	@Test
	public void testRouWheelCheckBetHalf1F() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(34);
		assertFalse(wheel.checkBet(12) == 1);
	}
	
	@Test
	public void testRouWheelCheckBetHalf2T() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(34);
		assertTrue(wheel.checkBet(13) == 1);
	}
	
	@Test
	public void testRouWheelCheckBetHalf2F() {
		RouWheel wheel = new RouWheel();
		wheel.setValue(2);
		assertFalse(wheel.checkBet(13) == 1);
	}
}
