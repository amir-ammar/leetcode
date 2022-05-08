class Solution {
    public  int sumOddLengthSubarrays(int[] arr) {
        int size = 0;
        if(arr.length%2==0){
            size = arr.length-1;
        }else{
            size = arr.length;
        }
        int count = 0;
        for(int i = 1 ; i<=size ; i+=2){

            for(int j = 0 ; j<arr.length ; j++) {

                if (j + i <= arr.length) {
                    for (int z = j; z < i+j; z++) {

                        count += arr[z];
                    }
                } else {
                    break;
                }
            }


        }
        return count;
    }
}