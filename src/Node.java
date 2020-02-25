public class Node <T>{
    public T data;
    public Node<T> next;

    public Node(T d){
        data=d;
        next=null;
    }

    public Node(T d, Node<T> n){
        data=d;
        next=n;
    }
    public T getData(){
        return data;
    }

    public Node<T> getNext(){
        return next;
    }

    public void setNext(Node<T> n){
        next=n;
    }

    public void setData(T d){
        data=d;
    }

}
