class LinkedList<AnyType> { 
    static class Node<AnyType> { 
        AnyType data;
        Node<AnyType> next;

        public Node(AnyType data){
            this.data = data;
            this.next = null;
        }
    }
    
    private Node<AnyType> head;

    public Node<AnyType> getHead() {
        return head;
    }    

    public void insert(AnyType data){
        Node<AnyType> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
            return;
        }
        Node<AnyType> current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertatHead(AnyType data){
        Node<AnyType> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAt(AnyType data, int index) {
        if (index == 0) {
            insertatHead(data);
            return;
        }
        Node<AnyType> current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        Node<AnyType> newNode = new Node<>(data);
        newNode.next = current.next;
        current.next = newNode;
    }

    public void removeAt(int index) {
        if (index == 0) {
            head = head.next;
            return;
        }
        Node<AnyType> current = head;
        int currentIndex = 0;
    
        while (current != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }
    
        if (current == null || current.next == null) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
    
        current.next = current.next.next;
    }
    
    

    public int checkLength(){
        Node<AnyType> current = head;
        int length = 0;
        while (current != null){
            length++;
            current = current.next;
        }
        return length;
    }

    public AnyType checkAt(int index) {
        Node<AnyType> current = head;
        int currentIndex = 0;

        while (current != null) {
            if (currentIndex == index) {
                return current.data; // Return the data of the node at the index
            }
            current = current.next;
            currentIndex++;
        }
        throw new IndexOutOfBoundsException("Index out of bounds.");
    }

    public void replaceAt(int index, AnyType newData) {
        Node<AnyType> current = head;
        int currentIndex = 0;

        while (current != null) {
            if (currentIndex == index) {
                current.data = newData;  // Replace the data
                return;
            }
            current = current.next;
            currentIndex++;
        }
        throw new IndexOutOfBoundsException("Index out of bounds.");
    }

    public void printlist(){
        System.out.println("Morning Routine:");
        Node<AnyType> current = head;
        int counter = 1;
        while (current != null){
            System.out.println(counter + ". " + current.data);
            counter ++;
            current = current.next;
        }
    }
}
