class LinkedList<DataType> { 
    static class Node<DataType> { 
        DataType data;
        Node<DataType> next;

        public Node(DataType data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node<DataType> head;

    public void insert(DataType data) {
        Node<DataType> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<DataType> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void traverse() {
        Node<DataType> current = head;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.println("null");
    }
}
