class LinkedList<AnyType> { 
    static class Node<AnyType> { 
        AnyType data;
        Node<AnyType> next;

        public Node(AnyType data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node<AnyType> head;

    public void insert(AnyType data) {
        Node<AnyType> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<AnyType> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void traverse() {
        Node<AnyType> current = head;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void printlist() {
        Node<AnyType> current = head;
        int counter = 1;
        while (current != null) {
            System.out.println(counter+". "+current.data);
            counter ++;
            current = current.next;
        }
    }
}
