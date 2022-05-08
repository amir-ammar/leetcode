public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length> nums2.length){
            return findMedianSortedArrays(nums2 , nums1);
        }

        int x = nums1.length;
        int y = nums2.length;
        
        
        int low = 0;
        int high = x;

        while(low <=high){
            int PartionX = (low+high)/2;
            int PartionY = (x+y+1)/2 - PartionX;


            int MaxLeftX = (PartionX==0)?Integer.MIN_VALUE:nums1[PartionX-1];
            int MinRightX = (PartionX==x)?Integer.MAX_VALUE:nums1[PartionX];


            int MaxLeftY = (PartionY==0)?Integer.MIN_VALUE:nums2[PartionY-1];
            int MinRightY = (PartionY==y)?Integer.MAX_VALUE:nums2[PartionY];

            if(MaxLeftX <= MinRightY && MaxLeftY <= MinRightX){
                if((x+y)%2 == 0){
                    return (double)(Math.max(MaxLeftX , MaxLeftY) + Math.min(MinRightX , MinRightY) )/2;
                }else{
                    return (double)Math.max(MaxLeftX , MaxLeftY);
                }
            }else if(MaxLeftX > MinRightY){
                high = PartionX-1;
            }else{
                low = PartionX+1 ;
            }
        }

        return 0.0;
    }
}
