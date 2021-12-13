package cosc314.FinalProject;

import java.util.Arrays;

// Do Question 11 too because this was too easy

public class ComparisonsCipher {
	static int numCompared = 0;
	
	/**
	 * 
	 * @param x - the number you want searched
	 * @param arr - the array that this number is in
	 * @return - the position of x
	 */
	public static int linearSearch(int x, int[] arr) {
		numCompared = 0;
		int i = 0;
		while(i <= arr.length && x != arr[i]) {
			numCompared++;
			i += 1;
		}
		numCompared++;
		if(i <= arr.length) 
			return i;
		else
			return -1;
	}
	
	/**
	 * 
	 * @param x - the number you want searched
	 * @param arr - the array that this number is in
	 * @return - the position of x
	 */
	public static int binarySearch(int x, int[] arr) {
		numCompared = 0;
		Arrays.sort(arr);
		int leftEnd = 0;
		int rightEnd = arr.length;
		
		while(leftEnd < rightEnd) {
			numCompared++;
			int m = (leftEnd + rightEnd)/2;
			if(x > arr[m]) {
				numCompared++;
				leftEnd = m + 1;
			} else {
				numCompared++;
				rightEnd = m;
			}	
		}
		if(x == arr[leftEnd]) {
			numCompared++;
			return leftEnd;
		} else {
			numCompared++;
			return -1;
		}
		
	}
	
	// This is just so that you can print arrays easier
	public static void printArray(char[] arr) {
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	/**
	 * The cipher that shifts letter left or right along the alphabet to encrypt a message
	 * @param key - how much the letters are shifted
	 * @param text - the text you want encrypted
	 * @return the encrypted text
	 */
	public static String shiftCipher(int key, String text) {
		String s = "";
		for(int i = 0; i < text.length(); i++) {
			//if the character is a space
			if(text.charAt(i) != ' ') {
				char c = (char)(text.charAt(i) + key);
				//if character isn't a letter and is lowercase
				if(c > 'z' && Character.isLowerCase(text.charAt(i))) {
					s += (char)(text.charAt(i) + (key-26));
					
				//if character isn't a letter and is uppercase	
				} else if(c > 'Z' && Character.isUpperCase(text.charAt(i))) {
					s += (char)(text.charAt(i) + (key-26));
					
				//if character is a letter then just shift it normally
				} else {
					s += (char)(text.charAt(i) + key);
				}
			}
			else
				//if character is a space then add a space to the string
				s += " ";
		}
		return s;
	}
	
	/**
	 * 
	 * @param key - how much the letters are shifted
	 * @param text - the text you want decrypted
	 * @return the decrypted text
	 */
	public static String decryptCipher(int key, String text) {
		String s = "";
		for(int i = 0; i < text.length(); i++) {
			if(text.charAt(i) != ' ') {
				char c = (char)(text.charAt(i) - key);
				
				if(c < 'a' && Character.isLowerCase(text.charAt(i))) {
					s += (char)(text.charAt(i) - (key-26));
					
				} else if(c < 'A' && Character.isUpperCase(text.charAt(i))) {
					s += (char)(text.charAt(i) - (key-26));
					
				} else {
				s += (char)(text.charAt(i) - key);
				
				}
			}
			else
				s += " ";
		}
		return s;
	}
	
	public static void main(String[] args) {
		int[] random = {90,96,4,20,97,75,64,93,5,94,14,67,69,84};
		int[] random2 = {100,21,43,46,83,17,58,6,92,34,50,19,95,45,47,70,27,79,60,18,44,65,30,85,3,72,9,91,12,37,31,52,53,74,36,88,22,25,29,81,7,76,48,68,78,71,28,51,39,87,41,99,62,55,1,49,98,8,13,35,10,82,80,2,54,23,11,63,24,61,86,33,32,40,77,16,15,56,38,73,66,42,26,57,59,89,90,96,4,20,97,75,64,93,5,94,14,67,69,84};
		
		
		int location = linearSearch(50, random2);
		System.out.println("The location of the number using linear search is: " + location);
		System.out.println("The number of comparisons made are " + numCompared + " (Not including checking if i is bigger than the array)");
		
		int location2 = binarySearch(50, random2);
		System.out.println("The location of the number using binary search is: " + location2);
		System.out.println("The number of comparisons made are " + numCompared + " (Not including checking if i is bigger than the array)");
		
		String textToEncrypt = "Hello World How are you doing";		
		System.out.println(shiftCipher(4, textToEncrypt));
		
		String textToDecrypt = "Lipps Asvph Lsa evi csy hsmrk";
		System.out.println(decryptCipher(4, textToDecrypt));
	}

}
