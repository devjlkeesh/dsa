public class SLL<T> {

    Node<T> head;

    public void add(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null)
            this.head = newNode;

        Node<T> currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void display(){
        
    }

    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node [data=" + data + ", next=" + next + "]";
        }

    }

}
