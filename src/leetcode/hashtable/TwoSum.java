package leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
	
	/*
	 * Given an array of integers, return indices of the two numbers such that
	 * they add up to a specific target.
	 * 
	 * You may assume that each input would have exactly one solution, and you
	 * may not use the same element twice.
	 * 
	 * Example:
	 * 
	 * Given nums = [2, 7, 11, 15], target = 9,
	 * 
	 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
	 * 
	 * 
	 * Interesting Case to Look For : 
	 * Output :- Return indexes or actual value Pairs
	 * If need to return indexes then have to following gotchas 
	 * In this case a regular hashmap implementation fails - if we are storing <number , index> as entries
	 * [3,2,4] Target = 6 : Dont want to return (3,3) - Check if it is returning same index
	 * [3,3,2] Target = 6 : This is tricky and wont work if doing 2 passes
	 * One pass solution handles above cases 
	 * 
	 */
	
	static class Pair {
		int num1;
		int num2;
		
		Pair(int num1, int num2) {
			this.num1 = num1;
			this.num2 = num2;
		}
		
		@Override
		public String toString() {
			return "(" + num1 + "," + num2 + ")";
		}
	}
	
	/*
	 * Take more time but does not take extra space
	 */
	public List<Pair> solution1(int[] numbers, int target) {
		//Output list for solution
		List<Pair> output = new ArrayList<Pair>();
		//Create a bit map to track if he have already used element
		BitSet trackNumbers = new BitSet(numbers.length);
		//Step 1 : Sort this array
		Arrays.sort(numbers);
		for (int i = 0 ; i < numbers.length; i++) {
			if(!trackNumbers.get(i)) {
				int index = Arrays.binarySearch(numbers, target - numbers[i]);
				if(index != -1 && !trackNumbers.get(index) && index != i) {
					trackNumbers.set(index);
					trackNumbers.set(i);
					Pair p = new Pair(numbers[i], numbers[index]);
					output.add(p);
				}
			}
		}
		return output;		
	}
	
	public List<Pair> solution2(int[] numbers, int target) {
		//Output list for solution
		List<Pair> output = new ArrayList<Pair>();
		//Step 1: Create a hashmap
		Map<Integer, Integer> numbersMap = new HashMap<>();
		for(int i = 0 ; i < numbers.length; i++) {
			numbersMap.put(numbers[i], i);
		}
		
		for(int i = 0 ; i < numbers.length; i++) {
			int numToSearch = target - numbers[i];
			if(numbersMap.containsKey(numToSearch) && numbersMap.get(numToSearch) != i) {
				output.add(new Pair(numbers[i], numToSearch));
				numbersMap.remove(numbers[i]);
				numbersMap.remove(numToSearch);
			}
		}
		return output;
	}
	
	public int[] twoSum(int[] nums, int target) {
		//Output list for solution
		int[] output = new int[2];
		//Step 1: Create a hashmap
		Map<Integer, Integer> numbersMap = new HashMap<>();
		for(int i = 0 ; i < nums.length; i++) {
			int numToSearch = target - nums[i];
			if(numbersMap.containsKey(numToSearch)) {
				output[0] = numbersMap.get(numToSearch);
				output[1] = i;
				return output;
			}
			numbersMap.put(nums[i], i);
		}
		return output;
    }
	
	public static void main(String args[]) {
		TwoSum solution = new TwoSum();
		int[] numbers = new int[]{3, 3, 4};
		int target = 6;
		List<Pair> outputSolution1 = solution.solution1(numbers, target);
		List<Pair> outputSolution2 = solution.solution2(numbers, target);
		System.out.println(outputSolution1.toString());
		System.out.println(outputSolution2.toString());
		int[] output = solution.twoSum(numbers, target);
		System.out.println(output[0] + "," + output[1]);
	}

}
