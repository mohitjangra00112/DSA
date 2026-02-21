
#  Add in Linked List 

# add First O(1)

steps 
1. create new node
2. new node next = head 
3. head = new node

// if there is no new node then 
1. create new node 
2. Head = Tail  = new Node

# add Last 

steps
1. create new node
2. tail.next = new node
3. Tail = new Node

// if there is no new node then 
1. create new node 
2. Head = Tail  = new Node

# Print Linked List

steps
1. created temp Node  Node temp = Head;
2. Run while loop while( temp != null )
3. print temp.data  
4. temp = temp.next

#  Print Function   
public void print(){
            Node temp = Head;

            while(temp != null){
                System.out.println(temp.data);
                temp = temp.next;
            }
        }

#  Add Middle 

steps
1. Create new Node
2. create temp node , temp = Head
3. int i = 0 ;  run while loop until we reach prev node  while( i < index-1)
4. in loop ->  temp = temp.next  ,  i++
5. After loop  newNode next  =  temp.next   and  temp.next = newNode

# Add Function  
public void add(int index , int data){

            if(index ==0 ){         // if index is 0 , then we need to update the head . 
                addFirst(data);
            }

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

# Remove First 
steps
1. If size == 0 , return 
2. If size == 1  head=Tail=null
3. Else Head = Head.next;

# Remove Last
steps
1. If size == 0 , return 
2. If size == 1  head=Tail=null
3. Else  Temp -> Treverse till size-2
4. Temp.next = null ,  Tail = Temp  
5. See function removeLast for more understanding
