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

        public void addFirst(int data){

            // Step 1 Create new node 
           
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

    public static void main(String args[]){
         
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);



    }

}
