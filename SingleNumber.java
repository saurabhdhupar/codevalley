package leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;

public class SingleNumber {
	
	/*
	 * Given a non-empty array of integers, every element appears twice except
	 * for one. Find that single one.
	 * 
	 * Note:
	 * 
	 * Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 * 
	 * Example 1:
	 * 
	 * Input: [2,2,1] Output: 1 Example 2:
	 * 
	 * Input: [4,1,2,1,2] Output: 4
	 */
	
	public int solution1(int[] numbers) {
		Map<Integer, Integer> singleNumberMap = new HashMap<>();
		//Iterate through each element if an element occurs more than once then remove it else keep it		
		for(int number : numbers) {
			if(singleNumberMap.containsKey(number)) {
				singleNumberMap.remove(number);
			}
			else {
				singleNumberMap.put(number, 1);
			}
		}
		return singleNumberMap.keySet().iterator().next();
	}
	
	public int solution2(int[] numbers) {
		int singleNumber = 0;
		for(int number : numbers) {
			singleNumber  ^= number; 
		}
		return singleNumber;
	}
	
	public int solution3(int[] numbers) {
		Set<Integer> uniqueNumberSet = new HashSet<>();
		int totalSum = 0;
		for(int numb : numbers) {
			uniqueNumberSet.add(numb);
			totalSum += numb;
		}
		
		int sumUnique = 2 * uniqueNumberSet.stream().reduce( new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer t, Integer u) {
				return t + u;
			}
		}).get();
		
		return sumUnique - totalSum;
	}
	
	public static void main(String args[]) {
		SingleNumber solutionObj = new SingleNumber();
		int[] numbers = new int[]{4,1,2,1,2};
		System.out.println(solutionObj.solution1(numbers));
		System.out.println(solutionObj.solution2(numbers));
		System.out.println(solutionObj.solution3(numbers));
	}
}
