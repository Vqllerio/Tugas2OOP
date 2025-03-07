public class Stack {
    private int[] stackArray;
    private int top;
    private int capacity;

    public Stack(int size){
        capacity = size;
        stackArray = new int[capacity];
        top = -1;
    }

    public void push(int value){
        if (top == capacity - 1){
            System.out.println("Stack Overflow");
            return;
        }
        stackArray[++top] = value;
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("Stack Underflow");
            return -1;
        }
        return stackArray[top--];
    }

    public int peek(){
        if (isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
    public static void main(String[] args){
        
    }
}