public class Doublell {
    
    public static class Node{
             
        int data;
        Node next;
        Node prev;
        
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node Head;
    public static Node Tail;
    public static int size;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;

        if(Head == null){
            Head=Tail=newNode;
            return;
        }
        
        newNode.next = Head;
        Head.prev = newNode;
        Head = newNode;

    }

    public void print(){
        Node temp = Head;

        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int removeFirst(){
        if(Head == null){
            System.out.println("LL is Empty");
            return -1;
        }
        
        if(size == 1){
            int val = Head.data;
            Head = null;
            Tail = null;
            size--;
            return val;

        }

        int val = Head.data;
        Head = Head.next;
        Head.prev = null;
        size--;
        
        return val;
    }

    public void reversell(){
        // prev  , curr , next 
        Node prev = null;
        Node curr = Tail = Head;
        Node next;

         while(curr !=null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
            }
            Head = prev;
    }

    public static void main(String args[]){
        Doublell dll = new Doublell();
    }


}
