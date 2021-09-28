package Inquiry.ArithmaticExpressionEvaluator;

import org.jetbrains.annotations.NotNull;
import java.util.Stack;

public class ExpressionEvaluator {
    public static int evaluate(@NotNull String infix) {
        Stack<Integer> num_stack = new Stack<>();
        Stack<String> op_stack = new Stack<>();

        if (infix.length() <=1)
            return Integer.parseInt(infix);
        for(int i = 0; i < infix.length()-1;i++) {
            if (infix.substring(i).equals(" "))
                i++;
            String sub_str = infix.substring(i);
            String digits = "1234567890";
            String top_op = "";

            if (digits.contains(sub_str)) {
                num_stack.push(Integer.parseInt(sub_str));
            } else {
                if (op_stack.isEmpty())
                    op_stack.push(sub_str);
                else
                    top_op = op_stack.peek();

                if (sub_str.equals("^")) {
                    op_stack.push("^");
                } else if (sub_str.equals("*") || sub_str.equals("/")) {
                    if (top_op.equals("^")) {
                        int num = num_stack.pop();
                        int num2 = num_stack.pop();
                        num_stack.push((int)(Math.pow(num2,num)));
                    } else {
                        switch(sub_str) {
                            case "*":
                                op_stack.push("*");
                            case "/":
                                op_stack.push("/");
                        }
                    }
                } else if (sub_str.equals("+") || top_op.equals("-")) {
                    if (top_op.equals("*") || top_op.equals("/")) {
                        int num;
                        int num2;
                        switch(top_op) {
                            case "*":
                                num = num_stack.pop();
                                num2 = num_stack.pop();
                                num_stack.push(num2*num);
                            case "/":
                                num = num_stack.pop();
                                num2 = num_stack.pop();
                                num_stack.push(num2/num);
                        }
                    } else {
                        switch(sub_str) {
                            case "+":
                                op_stack.push("+");
                            case "-":
                                op_stack.push("-");
                        }
                    }
                } else {
                    return -1;
                }
            }
        }
        if(op_stack.size() >= 1){
            for (int i = op_stack.size(); i > 0; i--) {
                int num = num_stack.pop();
                int num2 = num_stack.pop();
                switch(op_stack.peek()) {
                    case "^":
                        num_stack.push((int)(Math.pow(num2,num)));
                    case "*":
                        num_stack.push(num2*num);
                    case "/":
                        num_stack.push(num2/num);
                    case "+":
                        num_stack.push(num2+num);
                    case "-":
                        num_stack.push(num2-num);
                }
            }
        }
        return num_stack.peek();
    }
}
