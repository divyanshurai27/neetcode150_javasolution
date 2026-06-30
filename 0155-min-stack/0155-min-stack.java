import java.util.Stack;

class MinStack {

    Stack<Long> stack;
    long min;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int value) {

        if (stack.isEmpty()) {
            min = value;
            stack.push((long) value);
        }
        else if (value >= min) {
            stack.push((long) value);
        }
        else {
            stack.push(2L * value - min);
            min = value;
        }
    }

    public void pop() {

        long top = stack.pop();

        if (top < min) {
            min = 2 * min - top;
        }
    }

    public int top() {

        long top = stack.peek();

        if (top < min) {
            return (int) min;
        }

        return (int) top;
    }

    public int getMin() {
        return (int) min;
    }
}