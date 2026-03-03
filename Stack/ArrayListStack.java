package Stack;

import java.util.*;

public class ArrayListStack {
    
    public class Stack{
          
        static ArrayList <Integer> list = new ArrayList<>();
        
        public static boolean isEmpty(){
            return list.size() == 0;
        }

        // push
        public static void push(int data){
             list.add(data);    
        }

        // pop
        public static int pop(){
            if(isEmpty()){
                return -1;  // empty stack
            }
            int val = list.get(list.size()-1);
            list.remove(list.size()-1);
            return val;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }

            return list.get(list.size()-1);
        }


    }
          
    public static void main(String args[]){

    }
}
