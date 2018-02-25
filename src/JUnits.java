import static org.junit.jupiter.api.Assertions.assertFalse;

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

}
