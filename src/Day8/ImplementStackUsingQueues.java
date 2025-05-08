package Day8;

import java.util.LinkedList;
import java.util.Queue;

class ImplementStackUsingQueues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public ImplementStackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        if (q1.isEmpty()) return -1;

        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        int top = q1.poll();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    public int top() {
        if (q1.isEmpty()) return -1;

        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        int top = q1.poll();
        q2.add(top);

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
    	ImplementStackUsingQueues stack = new ImplementStackUsingQueues();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Popped element: " + stack.pop()); 
        System.out.println("Top after pop: " + stack.top()); 
        System.out.println("Is stack empty? " + stack.empty()); 

        stack.pop();
        stack.pop();
        System.out.println("Is stack empty after popping all? " + stack.empty()); 
    }
}
