/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.april2020;

import java.util.HashMap;
import java.util.Map;

public class CountingElements {
	public static void main(String[] args) {
		CountingElements solution = new CountingElements();
		int[] arr1 = { 1, 2, 3 };
		int result = solution.countElements(arr1);
		System.out.println(result);
		int[] arr2 = { 1, 1, 3, 3, 5, 5, 7, 7 };
		result = solution.countElements(arr2);
		System.out.println(result);
		int[] arr3 = { 1, 3, 2, 3, 5, 0 };
		result = solution.countElements(arr3);
		System.out.println(result);
		int[] arr4 = { 1, 1, 2, 2 };
		result = solution.countElements(arr4);
		System.out.println(result);

	}

	public int countElements(int[] arr) {
		if(arr == null || arr.length == 0){
			return 0;
		}
		Map<Integer, Integer> frequencyMap = new HashMap<>();

		for(int i = 0 ; i < arr.length ; i++){
			frequencyMap.merge(arr[i] , 1 , Integer::sum);
		}
		int count = 0;
		for(Integer key : frequencyMap.keySet()){
			if(frequencyMap.containsKey(key + 1)){
				count += frequencyMap.get(key);
			}
		}
		return count;
	}

}
