
package SaraFinalProject;

public class QueuePatient {
    
     private Node front;
     private Node rear;
     private int size;
     
     public QueuePatient()
     {
         front = null;
         rear = null;
         size = 0;
     }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty()
    {
        if (front == null && rear == null )  // size == 0
            return true;
        else return false;
    }
    
    
    public void enqueue(Node e){
        if (isEmpty()) {
            front = e;
            rear = e;
            size++;
        }
        else{
            rear.next = e;
            rear = rear.next;
            size++;
        }
    }
    
     public Node dequeue(){
        if(isEmpty())
            return null;
        else if(size == 1){
            Node temp = null;
            temp = front; // or tail مش رح تفرق;
            rear= null;
            front = null;
            size --;
            return temp;
        }
        else {
            Node temp = null;
            temp = front;
            front = front.next;
            temp.next = null;
            size--;
            return temp;
        }
        
    }
}
