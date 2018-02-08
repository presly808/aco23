package week4;

public class testCB {
    public static void main(String[] args) {
        int start = 0;
        int[] nums = {2, 4, 4, 8};
        int target = 14;

        boolean expected = false;

        System.out.println(groupSum5(start, nums, target) == expected);
    }

    public static boolean groupSum5(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;

        boolean branch1 = false;
        boolean branch2 = false;

        if(start + 1 < nums.length && nums[start] != nums[start + 1]) {
            branch1 = groupSum5(start + 1, nums, target);
            branch2 = groupSum5(start + 1, nums, target - nums[start]);
        }

        if(start + 1 < nums.length && nums[start] == nums[start + 1]) {
            while(start + 1 < nums.length && nums[start] == nums[start + 1]) {
                branch1 = branch2 = groupSum5(start + 1, nums, target - nums[start]);
            }
        }


        return branch1 || branch2;
    }


}
