package Day2;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList, new ArrayList<>(), nums);
        return resultList;
    }

    private void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums){
        if(tempList.size()==nums.length){
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for(int number : nums){
            if(tempList.contains(number))
            continue;

            tempList.add(number);
            backtrack(resultList,tempList,nums);
            tempList.remove(tempList.size()-1);
        }
    }
    public static void main(String[] args) {
    	Permutations solution = new Permutations();
    	int[] nums = {1,2,3};
    	
    	 System.out.print("Input array: ");
         for (int num : nums) {
             System.out.print(num + " ");
         }
         System.out.println();

         List<List<Integer>> result = solution.permute(nums);

         System.out.println("Output permutations:");
         for (List<Integer> permutation : result) {
             System.out.println(permutation);
         }	
    }
}
