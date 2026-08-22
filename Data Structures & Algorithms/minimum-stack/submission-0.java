class MinStack {

    List<Integer> list = null;
    List<Integer> minList = null;

    public MinStack() {
        list = new LinkedList<Integer>();
        minList = new LinkedList<Integer>();
    }
    
    public void push(int val) {

        if(minList.isEmpty()) {
            minList.add(val);
        } else if(val <= minList.get(minList.size() - 1)){
            minList.add(val);
        }
        list.add(val);
    }
    
    public void pop() {
        if(list.size() > 0) {
            int removedItem = list.remove(list.size()-1);     
            if(!minList.isEmpty() && removedItem == minList.get(minList.size()-1)) {
                minList.remove(minList.size() - 1);
            }
        }
    }
    
    public int top() {
        if(list.size() > 0) {
           return  list.get(list.size()-1);        
        }     
        return Integer.MIN_VALUE;  
    }
    
    public int getMin() {
        return !minList.isEmpty()? minList.get(minList.size() - 1): -1;
    }
}
