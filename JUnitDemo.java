package cosc314.FinalProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class JUnitDemo {

	@Test
	@Order(1)
	public void testLinearComparison() {
		ComparisonsCipher compar = new ComparisonsCipher();
		//Array with numbers 1 to 100 in a random order
		int[] random2 = {100,21,43,46,83,17,58,6,92,34,50,19,95,45,47,70,27,79,60,18,44,65,30,85,3,72,9,91,12,37,31,52,53,74,36,88,22,25,29,81,7,76,48,68,78,71,28,51,39,87,41,99,62,55,1,49,98,8,13,35,10,82,80,2,54,23,11,63,24,61,86,33,32,40,77,16,15,56,38,73,66,42,26,57,59,89,90,96,4,20,97,75,64,93,5,94,14,67,69,84};
		
		ComparisonsCipher.linearSearch(50, random2);
		
		// Says how many comparisons were made in the search
		int result = ComparisonsCipher.numCompared;
		
		assertEquals(11, result);
	}
	
	@Test
	@Order(2)
	public void testBinaryComparison() {
		ComparisonsCipher compar = new ComparisonsCipher();
		//Array with numbers 1 to 100 in a random order
		int[] random2 = {100,21,43,46,83,17,58,6,92,34,50,19,95,45,47,70,27,79,60,18,44,65,30,85,3,72,9,91,12,37,31,52,53,74,36,88,22,25,29,81,7,76,48,68,78,71,28,51,39,87,41,99,62,55,1,49,98,8,13,35,10,82,80,2,54,23,11,63,24,61,86,33,32,40,77,16,15,56,38,73,66,42,26,57,59,89,90,96,4,20,97,75,64,93,5,94,14,67,69,84};

		ComparisonsCipher.binarySearch(50, random2);
		
		int result = ComparisonsCipher.numCompared;
		
		assertEquals(15, result);
	}
	
	@Test
	@Order(3)
	public void testEncryptCipher() {
		ComparisonsCipher compar = new ComparisonsCipher();
		
		String textToEncrypt = "Hello World How are you doing";
		
		String result = ComparisonsCipher.shiftCipher(4, textToEncrypt);
		
		assertEquals("Lipps Asvph Lsa evi csy hsmrk", result);
	}
	
	@Test
	@Order(4)
	public void testDecryptCipher() {
		ComparisonsCipher compar = new ComparisonsCipher();
		
		String textToDecrypt = "Lipps Asvph Lsa evi csy hsmrk";
		
		String result = ComparisonsCipher.decryptCipher(4, textToDecrypt);
		
		assertEquals("Hello World How are you doing", result);
	}

}
