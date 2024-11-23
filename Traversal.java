import java.util.Stack;

public class Traversal {

    public static void Preorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
    }

    public static void Inorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;

        while (true) {

            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }

                node = stack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }

    public static void Postorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.val + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.val + " ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.right = new TreeNode(5);
        root.left.left.right.right.right = new TreeNode(6);
        root.right.left = new TreeNode(8);

        // Traversal.Preorder(root);
        // Traversal.Inorder(root);
        Traversal.Postorder(root);
    }
}
