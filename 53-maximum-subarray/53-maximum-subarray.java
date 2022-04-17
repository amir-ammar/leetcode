class Solution {

	// if u like my solution #UP_VOTE for me...thanks
	public int maxSubArray(int[] nums) {

	    // Your code here
	        long MinSum =0;
		long MaxSum=0;
		int  count=0;
		int temp= Integer.MIN_VALUE;
		
		for(int i=0;i<nums.length;i++){
		    MinSum=MinSum+nums[i];

		    if(temp<nums[i])
			temp=nums[i];

		    if(MinSum>MaxSum){
			MaxSum=MinSum;
		    }
		    if(MinSum<0){
			MinSum=0;
		      	count++;
		    }


		    }
		    if(count==nums.length && MaxSum ==0){      // this case handled when all value in the array are negatives....
			MaxSum=temp;
		    }
		    return (int) MaxSum;


	}
}
