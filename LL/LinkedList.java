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

        public void print(){
            Node temp = Head;

            while(temp != null){
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
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
    }

}
