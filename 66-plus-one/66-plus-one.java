import java.util.Arrays;

public class Solution {
    public int [] plusOne(int [] arr){
        int i;
        Boolean flag = false;
        int carry = 0;
        int sum = 1 ;
        for(i = arr.length-1 ; i>=0 ; i--){
            sum += carry + arr[i];
            if(sum<=9){
                arr[i] = sum;
                flag = true;
                break;
            }else{
                arr[i] = sum%10;
                carry = 1;
                sum = 0;
            }
        }
        if(!flag){
            int [] arr2 = new int[arr.length+1];
            arr2[0] = 1;
            return arr2;
        }else{
            return arr;
        }
    }
}