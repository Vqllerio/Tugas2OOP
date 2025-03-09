public class Stack<T> { // <T> makes the stack generic
    private T[] stackArray;
    private int top;
    private int capacity;

    @SuppressWarnings("unchecked")
    public Stack(int size){
        capacity = size;
        stackArray = (T[]) new Object[capacity]; // Creating a generic array
        top = -1;
    }

    public void push(T value){
        if (top == capacity - 1) {
            throw new StackOverflowError("Stack Overflow: Cannot push " + value);
        }
        stackArray[++top] = value;
    }

    public T pop(){
        if (isEmpty()) {
            throw new IllegalStateException("Stack Underflow: Cannot pop from an empty stack.");
        }
        return stackArray[top--];
    }

    public T peek(){
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return stackArray[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }
}
