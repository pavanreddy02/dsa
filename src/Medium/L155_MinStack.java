package Medium;

import java.util.ArrayList;
import java.util.List;

public class L155_MinStack {
    class MinStack {
        int start;
        int min = Integer.MAX_VALUE;
        int end;
        List<Integer> list ;
        int size = 0;
        public MinStack() {
            list = new ArrayList();
        }

        public void push(int val) {
            list.add(val);
            size++;
            min = Math.min(min, val);
        }

        public void pop() {
            list.remove(-1 + size--);
            min = Integer.MAX_VALUE;
            calMin();
        }

        public int top() {
            return list.get(size-1);
        }

        public int getMin() {
            return min;
        }

        private void calMin(){
            for(int each :list){
                min = Math.min(min , each);
            }
        }
    }
}
