class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        if(numRows==0){
            return listOfLists;
        }
        
        
        List<Integer>  list1 = new ArrayList<>();
        list1.add(1);
        listOfLists.add(list1);
        
        
        if(numRows==1){
            return listOfLists;
        }
        
        
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        listOfLists.add(list2);
        
        
        if(numRows==2){
            return listOfLists;
        }

        for(int i = 3 ; i<=numRows ; i++){
            List tmp = new ArrayList();
            tmp.add(1);
            for(int j = 0 ; j<i-2 ; j++){
                int a = listOfLists.get(i-2).get(j);
                int b = listOfLists.get(i-2).get(j+1);
                tmp.add(a+b);
            }
            tmp.add(1);
            listOfLists.add(tmp);
        }
        return listOfLists;
    }
}