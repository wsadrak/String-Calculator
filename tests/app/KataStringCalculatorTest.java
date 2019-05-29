package app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KataStringCalculatorTest {

		/*
		 * null => 0 
		 * "" => 0 
		 * "0" => 0 
		 * "1" => 1 
		 * "1+2" => 3 
		 * "1 + 2" => 3 
		 * "2+4-1" => 5
		 * "-10+3+1-2" => -8 
		 */

		@Test
		public void should_return_0_when_argument_null() {
			assertEquals(0, KataStringCalculator.calculate(null));
		}

		@Test
		public void should_return_0_when_argument_is_empty() {
			assertEquals(0, KataStringCalculator.calculate(""));
		}

		@Test
		public void should_return_0_when_argument_is_zero() {
			assertEquals(0, KataStringCalculator.calculate("0"));
		}

		@Test
		public void should_return_1_when_argument_is_1() {
			assertEquals(1, KataStringCalculator.calculate("1"));
		}

		@Test
		public void should_return_3_when_argument_is_1_plus_2() {
			assertEquals(3, KataStringCalculator.calculate("1+2"));
		}

		@Test
		public void should_return_3_when_argument_is_1_plus_2_with_blankspaces() {
			assertEquals(3, KataStringCalculator.calculate("1 + 2"));
		}

		@Test
		public void should_return_5_when_argument_is_2_plus_4_minus_1() {
			assertEquals(5, KataStringCalculator.calculate("2+4-1"));
		}

		@Test
		public void should_return_minus_8_when_argument_is_minus_10plus_3_plus1_minus2() {
			assertEquals(-8, KataStringCalculator.calculate("-10+3+1-2"));
		}

}
