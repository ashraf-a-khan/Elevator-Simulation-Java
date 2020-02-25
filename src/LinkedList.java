

public class LinkedList<T> {
    public Node<T>head, tail;
    public int size;

    public LinkedList(){
        head=null;
        tail=null;
        size=0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void addInHead(T data){
        if(isEmpty()){
            head=new Node<T>(data);
            tail=head;
        }
        else
            head=new Node<T>(data,head);
        size++;
    }


    public void add(T data){
        if(isEmpty())
            addInHead(data);
        else{
            tail.setNext(new Node<T>(data));
            tail=tail.getNext();
            size++;
        }

    }

    public T remove()throws Exception{
        if(isEmpty()){
            new Exception("Empty list");
            return null;
        }
        else if(size==1){
            T data=head.getData();
            head=null;
            size--;
            return data;
        }
        else{
            T data=head.getData();
            head=head.getNext();
            size--;
            return data;
        }
    }



    public String toString(){
        String ans = "";
        Node<T> n = head;
        ans += "(H)-->";
        while (n != null) {
            ans += n.getData();
            ans += "-->";
            n = n.getNext();
        }
        return ans + "(T)";
    }

}
