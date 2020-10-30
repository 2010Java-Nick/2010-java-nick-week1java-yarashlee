package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j = 0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		char letter;

		String acronym = "";

		for (int i = 0; i < phrase.length(); i++) {
			letter = phrase.charAt(i);
			if (i == 0) {
				acronym += Character.toUpperCase(phrase.charAt(i));
			}
			if (letter == ' ' || letter == '-') {
				acronym += Character.toUpperCase(phrase.charAt(i + 1));

			}
		}
		return acronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if (sideOne == sideTwo && sideTwo == sideThree && sideOne == sideThree) {
				return true;
			} else {
				return false;
			}
		}

		public boolean isIsosceles() {
			if (sideOne == sideTwo || sideTwo == sideThree || sideOne == sideThree) {
				return true;
			} else {
				return false;
			}
		}

		public boolean isScalene() {
			if (sideOne != sideTwo && sideTwo != sideThree && sideOne != sideThree) {
				return true;
			} else {
				return false;
			}
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		int score = 0;

		for (int i = 0; i < string.length(); i++) {
			char letter = string.charAt(i);

			switch (letter) {
			case 'A':
			case 'a':
			case 'E':
			case 'e':
			case 'I':
			case 'i':
			case 'O':
			case 'o':
			case 'U':
			case 'u':
			case 'L':
			case 'l':
			case 'N':
			case 'n':
			case 'R':
			case 'r':
			case 'S':
			case 's':
			case 'T':
			case 't':
				score += 1;
				break;
			case 'D':
			case 'd':
			case 'G':
			case 'g':
				score += 2;
				break;
			case 'B':
			case 'b':
			case 'C':
			case 'c':
			case 'M':
			case 'm':
			case 'P':
			case 'p':
				score += 3;
				break;
			case 'F':
			case 'f':
			case 'H':
			case 'h':
			case 'V':
			case 'v':
			case 'W':
			case 'w':
			case 'Y':
			case 'y':
				score += 4;
				break;
			case 'K':
			case 'k':
				score += 5;
				break;
			case 'J':
			case 'j':
			case 'X':
			case 'x':
				score += 8;
				break;
			case 'Q':
			case 'q':
			case 'Z':
			case 'z':
				score += 10;
				break;
			}
		}
		// return all the points added up from the strings
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		string = string.replace(" ", "").replace(".", "").replace(",", "").replace("(", "").replace(")", "").replace("-", "")
				.replace("_", "").replace("[", "").replace("]", "");

		if (string.length() > 11) {
			throw new IllegalArgumentException("Phone number cannot have more than 11 digits.");
		} else if (string.contains("!") || string.contains("@") || string.contains("#") || string.contains("$")
				|| string.contains("%") || string.contains("^") || string.contains("&") || string.contains("*")
				|| string.contains("-") || string.contains(":") || string.contains(".") || string.contains(",")
				|| string.contains("N") || string.contains("X")) {
			throw new IllegalArgumentException("Phone number cannot contain non numeric values.");
		} else {
			return string;
		}
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		String[] word = string.split(" ");

		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

		int count = 1;
		for (int x = 0; x < word.length; x++) {
			for (int w = x + 1; w < word.length; w++) {
				if (word[x].equals(word[w])) {
					count++;
				}
			}
			wordCount.put(word[x], count);
		}
		return wordCount;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
//			int length = this.sortedList.size();
//			int center = (length+1)/2;
//			
//			if(t.equals(this.sortedList.get(center))) {
//				return center;
//			}
//			
			//while(length <= center) {
			
			//}
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		String temp = "";
		String returnString = "";
		int i = 0;
		
		if(string.toUpperCase().startsWith("A") || string.toUpperCase().startsWith("E") || string.toUpperCase().startsWith("I") 
				|| string.toUpperCase().startsWith("O") || string.toUpperCase().startsWith("U")) {
				return string += "ay";
		}
		else {
			while (!(string.toUpperCase().charAt(i) == 'A') && !(string.toUpperCase().charAt(i) == 'E') && 
					!(string.toUpperCase().charAt(i) == 'I') && !(string.toUpperCase().charAt(i) == 'O') 
					&& !(string.toUpperCase().charAt(i) == 'U')) {
				temp += string.charAt(i);
				i++;
			}
			while (i<string.length()) {
				returnString += string.charAt(i);
				i++;
			}
			returnString += temp;
			return returnString += "ay";
		}
	}


	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		int  pwr = 0;
		for (int i = input; i != 0; i /= 10) {
			pwr++;
		}

		int sum = 0;
		for (int i = input; i != 0; i /= 10) {
			sum += Math.pow(i % 10, pwr);
		}

		return (sum == input);
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		long num = 2;

		List<Long> primeList = new ArrayList<>();

		while (l != 1) {
			if (l % num == 0 && (num % 2 != 0 || num == 2)) {

				boolean prime = true;

				for (int n = 2; n <= (num / 2); n++) {

					if (num % n == 0)
						prime = false;
				}

				if (prime)
					primeList.add(num);
				l = l / num;
				num = 1;
			}

			num++;
		}

		return primeList;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			return null;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		int number = 0;
		int count = 0;
		int n;

		if (i <= 0) {
			throw new IllegalArgumentException("Zero or negative numbers are not Nth Prime numbers.");
		}
		while (count < i) {
			number += 1;
			for (n = 2; n <= number; n++) {
				if (number % n == 0) {
					break;
				}
			}
			if (n == number) {
				count += 1;
			}
		}
		return number;

	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			
			String encode = "";
			
			string = string.replaceAll(" ", "");			
			char[] charArr = string.toCharArray();
			
			for(char c : charArr) {
				
				switch (c) {
					case 'a':
					case 'A': encode = encode.concat("z");
						continue;	
					case 'b':
					case 'B': encode = encode.concat("y");
						continue;
					case 'c':
					case 'C': encode = encode.concat("x");
						continue;
					case 'd': 
					case 'D': encode = encode.concat("w");
						continue;
					case 'e': 
					case 'E': encode = encode.concat("v");
						continue;						
					case 'f': 
					case 'F': encode = encode.concat("u");
						continue;
					case 'g': 
					case 'G': encode = encode.concat("t");												
						continue;
					case 'h': 
					case 'H': encode = encode.concat("s");
						continue;	
					case 'i': 
					case 'I': encode = encode.concat("r");
						continue;
					case 'j': 
					case 'J': encode = encode.concat("q");
						continue;					
					case 'k': 	
					case 'K': encode = encode.concat("p");
						continue;						
					case 'l': 
					case 'L': encode = encode.concat("o");
						continue;					
					case 'm': 
					case 'M': encode = encode.concat("n");
						continue;					
					case 'n': 
					case 'N': encode = encode.concat("m");
						continue;								
					case 'o': 
					case 'O': encode = encode.concat("l");
						continue;		
					case 'p': 
					case 'P': encode = encode.concat("k");
						continue;	
					case 'q': 
					case 'Q': encode = encode.concat("j");
						continue;
					case 'r':
					case 'R': encode = encode.concat("i");
						continue;	
					case 's': 
					case 'S': encode = encode.concat("h");
						continue;
					case 't': 
					case 'T': encode = encode.concat("g");
						continue;
					case 'u': 
					case 'U': encode = encode.concat("f");
						continue;
					case 'v': 
					case 'V': encode = encode.concat("e");
						continue;			
					case 'w': 
					case 'W': encode = encode.concat("d");
						continue;
					case 'x': 
					case 'X': encode = encode.concat("c");
						continue;
					case 'y': 
					case 'Y': encode = encode.concat("b");
						continue;
					case 'z': 
					case 'Z': encode = encode.concat("a");
						continue;
					case '0': encode = encode.concat("0");
						continue;
					case '1': encode = encode.concat("1");
						continue;
					case '2': encode = encode.concat("2");
						continue;
					case '3': encode = encode.concat("3");
						continue;
					case '4': encode = encode.concat("4");
						continue;
					case '5': encode = encode.concat("5");
						continue;
					case '6': encode = encode.concat("6");
						continue;
					case '7': encode = encode.concat("7");
						continue;
					case '8': encode = encode.concat("8");
						continue;
					case '9': encode = encode.concat("9");
				}
				
			}
			
			return encode;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			
			String decode = "";	
			char[] charArr = string.toCharArray();
			
			for(char d : charArr) {
				
				switch (d) {
					case 'a':
					case 'A': decode = decode.concat("z");
						continue;	
					case 'b':
					case 'B': decode = decode.concat("y");
						continue;
					case 'c':
					case 'C': decode = decode.concat("x");
						continue;
					case 'd': 
					case 'D': decode = decode.concat("w");
						continue;
					case 'e': 
					case 'E': decode = decode.concat("v");
						continue;						
					case 'f': 
					case 'F': decode = decode.concat("u");
						continue;
					case 'g': 
					case 'G': decode = decode.concat("t");												
						continue;
					case 'h': 
					case 'H': decode = decode.concat("s");
						continue;	
					case 'i': 
					case 'I': decode = decode.concat("r");
						continue;
					case 'j': 
					case 'J': decode = decode.concat("q");
						continue;					
					case 'k': 	
					case 'K': decode = decode.concat("p");
						continue;						
					case 'l': 
					case 'L': decode = decode.concat("o");
						continue;					
					case 'm': 
					case 'M': decode = decode.concat("n");
						continue;					
					case 'n': 
					case 'N': decode = decode.concat("m");
						continue;								
					case 'o': 
					case 'O': decode = decode.concat("l");
						continue;		
					case 'p': 
					case 'P': decode = decode.concat("k");
						continue;	
					case 'q': 
					case 'Q': decode = decode.concat("j");
						continue;
					case 'r':
					case 'R': decode = decode.concat("i");
						continue;	
					case 's': 
					case 'S': decode = decode.concat("h");
						continue;
					case 't': 
					case 'T': decode = decode.concat("g");
						continue;
					case 'u': 
					case 'U': decode = decode.concat("f");
						continue;
					case 'v': 
					case 'V': decode = decode.concat("e");
						continue;			
					case 'w': 
					case 'W': decode = decode.concat("d");
						continue;
					case 'x': 
					case 'X': decode = decode.concat("c");
						continue;
					case 'y': 
					case 'Y': decode = decode.concat("b");
						continue;
					case 'z': 
					case 'Z': decode = decode.concat("a");
						continue;
					case '0': decode = decode.concat("0");
						continue;
					case '1': decode = decode.concat("1");
						continue;
					case '2': decode = decode.concat("2");
						continue;
					case '3': decode = decode.concat("3");
						continue;
					case '4': decode = decode.concat("4");
						continue;
					case '5': decode = decode.concat("5");
						continue;
					case '6': decode = decode.concat("6");
						continue;
					case '7': decode = decode.concat("7");
						continue;
					case '8': decode = decode.concat("8");
						continue;
					case '9': decode = decode.concat("9");
				}
			}		
			return decode;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		int sum = 0;
		int mult = 10;

		for (int i = 0; i < string.length(); i++) {
			switch (string.charAt(i)) {
			case '0':
				sum += (0 * mult);
				mult -= 1;
				break;
			case '1':
				sum += (1 * mult);
				mult -= 1;
				break;
			case '2':
				sum += (2 * mult);
				mult -= 1;
				break;
			case '3':
				sum += (3 * mult);
				mult -= 1;
				break;
			case '4':
				sum += (4 * mult);
				mult -= 1;
				break;
			case '5':
				sum += (5 * mult);
				mult -= 1;
				break;
			case '6':
				sum += (6 * mult);
				mult -= 1;
				break;
			case '7':
				sum += (7 * mult);
				mult -= 1;
				break;
			case '8':
				sum += (8 * mult);
				mult -= 1;
				break;
			case '9':
				sum += (9 * mult);
				mult -= 1;
				break;
			case 'X':
				sum += (10 * mult);
				mult -= 1;
				break;
			case '-':
				break;
			default:
				// Invalid Input
				break;
			}
		}
		if (sum % 11 == 0) {
			return true;
		} else
			return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		int letters = 26; 
		
        if(string.length() < letters){
           return false;
        }
        for(char a = 'A'; a <= 'Z' ; a++){
            if((string.indexOf(a) < 0) && (string.indexOf((char)(a + 32)) < 0)){
               return false;
            }
        }
        return true;
    }


	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		if(given instanceof LocalDateTime) { 
			return ((LocalDateTime) given).plusSeconds(1000000000);
		} else {
			LocalDate localDate = (LocalDate) given;
			LocalDateTime localDateTime = LocalDateTime.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth(), 0, 0, 0);
			return (Temporal) localDateTime.plusSeconds(1000000000);
		}
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		int sum = 0;
		
		Set<Integer> setMultiples = new HashSet<Integer>();
			
			for (int m: set)
				for (int k = 1; k*m < i; k++)
					setMultiples.add(k*m);
			
			for (Integer c: setMultiples)
				sum +=c;
			
			return sum;

		}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		if (!string.replaceAll("\\s+", "").matches("[0-9]+"))
			return false;

		int LVal = 0;

		char[] chars = string.replaceAll("[\\s+]", "").toCharArray();
		int count = chars.length - 2;

		for (int i = chars.length - 1; i >= 0; i--) {

			if (i == count) {

				if ((Character.getNumericValue(chars[i]) * 2) > 9) {
					LVal += ((Character.getNumericValue(chars[i]) * 2) - 9);
				} else {
					LVal += (Character.getNumericValue(chars[i]) * 2);
				}

				count -= 2;
			} else {
				LVal += Character.getNumericValue(chars[i]);
			}
		}
		if (LVal % 10 == 0)
			return true;

		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		string = string.replace("What is ", "").replace("?", "").replaceAll("^[a-zA-Z]+\\s[a-zA-Z]+\\s", "").replaceAll("by\\s", "");
		String[] strArr = string.split("\\s");
		String operations = strArr[1];

		int one = Integer.parseInt(strArr[0]);
		int two = Integer.parseInt(strArr[2]);
		
		
		switch(operations) {
		case "plus":
			return one + two;
		case "minus":
			return one - two;
		case "multiplied":
			return one * two;
		case "divided":
			return one / two;
		}
		
		return 0;
	}
}
