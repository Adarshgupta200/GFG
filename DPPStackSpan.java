import java.util.ArrayList;
import java.util.Stack;

class DPPStackSpan {

    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> span = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                span.add(i + 1);
            } else {
                span.add(i - stack.peek());
            }

            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
       DPPStackSpan obj = new DPPStackSpan();

        int[] arr = {10, 4, 5, 90, 120, 80};

        ArrayList<Integer> result = obj.calculateSpan(arr);

        System.out.println(result);
    }
}
