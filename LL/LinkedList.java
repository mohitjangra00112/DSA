public class LinkedList {
    
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node Head;
    public static Node Tail;
    public static int size;     /// for size of LL

        public void addFirst(int data){

            // Step 1 Create new node 
            size++;
            Node newNode = new Node(data);
            if(Head == null){
                 Head =Tail = newNode;
                 return;
            }

            // Step 2 new Node next = Head 

            newNode.next = Head ; 

            // Step 3  Head = new Node 

            Head = newNode ; 
        }

        public void addLast(int data){
            
            size++;

            //  Step 1  create new Node
            
            Node newNode = new Node(data);

            if(Head == null){
                Head = Tail = newNode;
            }

            // Step 2 Tail.next = newNode

            Tail.next = newNode;

            // Step 3 Tail = newNode

            Tail = newNode;

        }

        //// Add Middle ( 0  based indexing )
        
        public void add(int index , int data){
            
            if(index ==0 ){         // if index is 0 , then we need to update the head . 
                addFirst(data);
            }
            
            size++;
            Node newNode = new Node(data);
            Node temp = Head;
            int i = 0;

            while( i < index-1 ){
                temp = temp.next;
                i++;
            }

            newNode.next = temp.next;
            temp.next = newNode;

        }

        public int removeFirst(){
            if(size==0){
                System.out.print("LL is empty");
                return 0; 
            }else if (size==1){
                int val = Head.data;
                Head=Tail=null;
                size=0;
                return val;
            }
            int val = Head.data;
            Head = Head.next;
            size--;
            return val;
        }

        public int removeLast(){
             if(size==0){
                System.out.print("LL is empty");
                return 0; 
            }else if (size==1){
                int val = Head.data;
                Head=Tail=null;
                size=0;
                return val;
            }
            // prev : i = size -2
            Node prev = Head;

            for(int i=0;i<size-2 ; i++){
                prev = prev.next;
            }

            int val = prev.data;   // Tail data
            prev.next = null;
            Tail = prev;
            size--;
            return val;
        }

        public int itrSearch(int key){
            Node temp = Head;
            int index=0;

            while(temp.next != null){
                if(temp.data == key){
                    return index;
                }

                temp = temp.next;
                index++;
            }

            // key not found 

            return (-1);

        }

        public int helper(Node Head , int key){
                if(Head == null ){
                    return -1;
                }

                if(Head.data == key){
                    return 0;
                }

                int index = helper(Head.next, key);

                if(index == -1){
                    return -1;
                }

                return index+1;
        }

        public int recSearch(int key){
              
            return helper(Head , key);

        }

        public void reverse(){
            // prev  , curr , next 
            Node prev = null;
            Node curr = Tail = Head;
            Node next;

            while(curr !=null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Head = prev;
        }

        public void deleteNthEnd(int index){
            // find size
            int sz=0;
            Node temp = Head;
            while(temp!=null){
                temp=temp.next;
                sz++;
            }

            // if index == sz  // remove head so 
            if(index == sz){
                Head = Head.next;  // remove first
                return;
            }

            // nth from last means size-index+1 from starting 

             int i=1;
             int indexFromStart = sz-index;
             Node prev = Head;

             while(i<indexFromStart){
                prev=prev.next;
                i++;
             }

             prev.next = prev.next.next;
             return;

        }

        // Slow - Fast Approach
        public Node findMiddle(Node Head){   // Slow - Fast Method using 2 pointers ( +1 and +2 )
            Node slow = Head;
            Node fast = Head;

            while(fast != null && fast.next != null){
                slow = slow.next;   // +1
                fast = fast.next.next;  // +2
            }

            return slow;
        }

        public boolean checkPalindrome(){
             
            if( Head == null || Head.next == null){
                return true;
            }

            // Step 1 Find mid

            Node midNode = findMiddle(Head);
            
            // Step 2  Reverse Right LL

            Node prev = null;
            Node curr = midNode;
            Node next;

            while(curr!=null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            Node right = prev;  // right half Head
            Node left = Head;   // left half Head
            
            // Step 3  compare Left and Right Nodes

            while(right != null){
                if(left.data != right.data){
                    return false;
                }

                left= left.next;
                right = right.next;
            }

            return true;

        }
           // Floyds Cycle Finding Algorithm || Slow - Fast Algorithm
        public boolean isCycle(){  
            Node slow = Head;
            Node fast = Head;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    return true;   // cycle detected
                }
            }
            return false;
        }

        public void removeCycle(){
            // Step 1 Detect Cycle

            Node slow = Head;
            Node fast = Head;
            boolean cycle= false;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    cycle = true;
                    break;
                }
            }

            if(cycle == false){
                return;
            }

            // step 2  Find Last node 

            Node prev = null;
            slow = Head;

            while(slow != fast){
                prev=fast;
                slow=slow.next;
                fast = fast.next;
            }

            // Step 3  Remove Cycle

            prev.next = null;
            

        }

        public void print(){
            Node temp = Head;

            while(temp != null){
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println();
        }

    public static void main(String args[]){
         
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);   // 1 -> 2 -> 3 -> 4
        ll.add(2,6);  // 1 -> 2 -> 6 -> 3 -> 4
        
        ll.print();
        System.out.println();
        System.out.println(size);
        ll.removeFirst();      // 2 -> 6 -> 3 -> 4
        ll.removeLast();       // 2 -> 6 -> 3
        ll.print();
        System.out.println("Result of Search " + ll.itrSearch(5));   //// search 
        System.out.println("Result of Search " + ll.itrSearch(6));   //// search 
    }

}
