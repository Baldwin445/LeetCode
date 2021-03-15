public class Q1 {
    public int[] twoSum(int[] nums, int target) {
        //类似冒泡
        int a=0,b=0;
        for(a=0;a<nums.length-1;a++){
            for(b=a+1;b<nums.length-1;b++){
                if(nums[a]+nums[b]==target) break;
            }
            if(nums[a]+nums[b]==target) break;
        }

        int[] answer = {a, b};
        return answer;
    }
}
