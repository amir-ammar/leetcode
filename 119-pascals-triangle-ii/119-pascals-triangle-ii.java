class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
         long number =1;
        for (int j = 0;j<rowIndex+1;j++)
        {
             res.add(Integer.valueOf((int)number));
                number = number*(rowIndex-j)/(j+1); 
        }
        return res;
    }
}