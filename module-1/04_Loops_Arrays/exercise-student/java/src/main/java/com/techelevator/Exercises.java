package com.techelevator;

public class Exercises {

	/*
	 1. Given an array of ints, return true if 6 appears as either the first or last element in the array. 
	 The array will be length 1 or more.
	 firstLast6([1, 2, 6]) → true
	 firstLast6([6, 1, 2, 3]) → true
	 firstLast6([13, 6, 1, 2, 3]) → false
	 */
	public boolean firstLast6(int[] nums) {

		// where is the first element?
		// where is the last element?
		// if either are 6, return true

		if ((nums[0] == 6) || nums[nums.length-1] == 6) {

			return true;
		}

		return false;
	}

	/*
	 2. Given an array of ints, return true if the array is length 1 or more, and the first element and
	 the last element are equal.
	 sameFirstLast([1, 2, 3]) → false
	 sameFirstLast([1, 2, 3, 1]) → true
	 sameFirstLast([1, 2, 1]) → true
	 */
	public boolean sameFirstLast(int[] nums) {

		if ((nums.length >= 1) && (nums[0] == nums[nums.length-1])) {

			return true;
		}

		return false;
	}

	/*
	 3. Return an int array length 3 containing the first 3 digits of pi, {3, 1, 4}.
	 makePi() → [3, 1, 4]
	 */
	public int[] makePi() {


		return new int[] {3, 1, 4};
	}

	/*
	 4. Given 2 arrays of ints, a and b, return true if they have the same first element or they have 
	 the same last element. Both arrays will be length 1 or more.
	 commonEnd([1, 2, 3], [7, 3]) → true
	 commonEnd([1, 2, 3], [7, 3, 2]) → false
	 commonEnd([1, 2, 3], [1, 3]) → true
	 */
	public boolean commonEnd(int[] a, int[] b) {

		if ((a[0] == b[0]) || (a[a.length-1] == b[b.length-1])) {

			return true;
		}

		return false;
	}

	/*
	 5. Given an array of ints length 3, return the sum of all the elements.
	 sum3([1, 2, 3]) → 6
	 sum3([5, 11, 2]) → 18
	 sum3([7, 0, 0]) → 7
	 */
	public int sum3(int[] nums) {

		return nums[0] + nums[1] + nums[2];
	}

	/*
	 6. Given an array of ints length 3, return an array with the elements "rotated left" so {1, 2, 3} 
	 yields {2, 3, 1}.
	 rotateLeft3([1, 2, 3]) → [2, 3, 1]
	 rotateLeft3([5, 11, 9]) → [11, 9, 5]
	 rotateLeft3([7, 0, 0]) → [0, 0, 7]
	 */
	public int[] rotateLeft3(int[] nums) {
		return new int[] {nums[1], nums[2], nums[0]};
	}

	/*
	 7. Given an array of ints length 3, return a new array with the elements in reverse order, so 
	 {1, 2, 3} becomes {3, 2, 1}.
	 reverse3([1, 2, 3]) → [3, 2, 1]
	 reverse3([5, 11, 9]) → [9, 11, 5]
	 reverse3([7, 0, 0]) → [0, 0, 7]
	 */
	public int[] reverse3(int[] nums) {
		return new int[] {nums[2], nums[1], nums[0]};
	}

	/*
	 8. Given an array of ints length 3, figure out which is larger between the first and last elements 
	 in the array, and set all the other elements to be that value. Return the changed array.
	 maxEnd3([1, 2, 3]) → [3, 3, 3]
	 maxEnd3([11, 5, 9]) → [11, 11, 11]
	 maxEnd3([2, 11, 3]) → [3, 3, 3]
	 */
	public int[] maxEnd3(int[] nums) {

		int largerNumber = Math.max(nums[0],nums[2]);

		return new int[] {largerNumber, largerNumber, largerNumber};
	}

	/*
	 9. Given an array of ints, return the sum of the first 2 elements in the array. If the array length
	  is less than 2, just sum up the elements that exist, returning 0 if the array is length 0.
	 sum2([1, 2, 3]) → 3
	 sum2([1, 1]) → 2
	 sum2([1, 1, 1, 1]) → 2
	 */
	public int sum2(int[] nums) {
		int sum = 0;

		if (nums.length == 1) {
			return nums[0];
		}

		else if (nums.length > 0) {
			for (int i = 0; i <= 1; i++) {
				 sum = sum + nums[i];


			}
			return sum;

		}


		return 0;
	}


	/*
	 10. Given 2 int arrays, a and b, each length 3, return a new array length 2 containing their middle 
	 elements.
	 middleWay([1, 2, 3], [4, 5, 6]) → [2, 5]
	 middleWay([7, 7, 7], [3, 8, 0]) → [7, 8]
	 middleWay([5, 2, 9], [1, 4, 5]) → [2, 4]
	 */
	public int[] middleWay(int[] a, int[] b) {
		return new int[] {a[1], b[1]};
	}

	/*
	 11. Return the number of even ints in the given array. Note: the % "mod" operator computes the 
	 remainder, e.g. 5 % 2 is 1.

	 // number % 2 == 0 it's an even number, if it's 1 it's an odd number

	 countEvens([2, 1, 2, 3, 4]) → 3
	 countEvens([2, 2, 0]) → 3
	 countEvens([1, 3, 5]) → 0
	 */
	public int countEvens(int[] nums) {

		int numberOfEvens = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i]%2 == 0) {
				numberOfEvens = numberOfEvens + 1;
			}

		}
		return numberOfEvens;




	}

	/*
	 12. Return the sum of the numbers in the array, returning 0 for an empty array.
	     Except the number 13 is very unlucky, so it does not count
	       and numbers that come immediately after a 13 also do not count.

	 sum13([1, 2, 2, 1]) → 6
	 sum13([1, 1]) → 2
	 sum13([1, 2, 2, 1, 13]) → 6
	    i  =0  1  2  3   4   5
	 sum13([1, 2, 2, 1, 13, 3]) → 6
	    i  =0  1  2  3   4  5  6
	 sum13([1, 2, 2, 1, 13, 3, 4]) → 10
	 */
	public int sum13(int[] nums) {

<<<<<<< HEAD
		int sum = 0;

		if (nums.length > 0) {

			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != 13) {
					sum = sum + nums[i];
				}
				else if ((nums[i] == 13) && (i < nums.length-1)) {
					nums[i] = 0; nums[i+1] = 0;
				}
				else if ((nums[i] == 13) && (i == nums.length-1)) {
					nums[i] = 0;
				}
			}
			return sum;
		}
		 return 0;
=======
		int sum = 0;  // define a variable to hold the sum to be returned

		if (nums.length == 0) { // check for an empty array (.length=0)
			return 0;           // return 0 if it's empty
		}
		for (int i=0; i < nums.length; i++) { //loop through the array one element at a time
			if (nums[i] != 13) {       // check to see if the number in the element is not equal 13
				sum = sum + nums[i];   //     adding the element to sum
			}
			else {      // we get here when the number is 13
				  i++;  //      skip the number after this one by incrementing loop variable
			}
		}

		return sum;
>>>>>>> 1152982d0a6cf926cf096a9519e620723f1f1d09
	}



	/*
	 13. Given an array of ints, return true if the array contains a 2 next to a 2 somewhere.
	 has22([1, 2, 2]) → true
	 has22([1, 2, 1, 2]) → false
	 has22([2, 1, 2]) → false
	 */
	public boolean has22(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			if (i < nums.length-1) {

				if ((nums[i] == 2) && (nums[i + 1] == 2)) {
					return true;
				}
			}
		}

		return false;
	}
	
	/*
	 14. Given an array of ints, return true if the array contains no 1's and no 3's.
	 lucky13([0, 2, 4]) → true
	 lucky13([1, 2, 3]) → false
	 lucky13([1, 2, 4]) → false
	 */
	public boolean lucky13(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] == 1) || (nums[i] == 3)) {
				return false;
			}
		}



		return true;
	}

	/*
	 15. Given an array of ints, return true if the sum of all the 2's in the array is exactly 8.
	 sum28([2, 3, 2, 2, 4, 2]) → true
	 sum28([2, 3, 2, 2, 4, 2, 2]) → false
	 sum28([1, 2, 3, 4]) → false
	 */
	public boolean sum28(int[] nums) {

		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 2) {
				sum = sum +2;
			}
		}
		if (sum == 8) {
			return true;
		}

		return false;
	}

}
