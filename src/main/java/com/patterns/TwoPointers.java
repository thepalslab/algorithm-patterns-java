package com.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointers {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Step 1: Sort the array

        for (int j = 0; j < nums.length - 2; j++) {
            if (j > 0 && nums[j] == nums[j - 1]) continue;  // Skip duplicates

            int start = j + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[j] + nums[start] + nums[end];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[j], nums[start], nums[end]));

                    // Skip duplicates for start and end
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[end - 1]) end--;

                    start++;
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;

        /*Time complexity analysis:
            Sorting the array: O(n log n)
            Two nested loops with two pointers: O(n^2)
            Overall time complexity: O(n^2)
        */
        /*Space complexity analysis:
            The space complexity is O(1) if we don't count the output list.
            If we count the output list, the space complexity is O(k),
            where k is the number of triplets found.
        */
    }
}
