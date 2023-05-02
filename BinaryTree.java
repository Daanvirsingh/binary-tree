public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(String value) {
        Node newNode = new Node(value,0);

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;

        while (true) {
            parent = current;
            if (value.equalsIgnoreCase(current.word)){
                current.setCount(current.getCount()+1);
                return;
            }else if (value.compareToIgnoreCase(current.word) < 0) {
                current = current.left;

                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;

                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    public void printAlphabetically() {
        printAlphabetically(root);
    }

    private void printAlphabetically(Node node) {
        if (node == null) {
            return;
        }

        printAlphabetically(node.left);
        System.out.println(node.word+" -> "+node.count);
        printAlphabetically(node.right);
    }

    public void printPreorder(int n) {
        printPreorder(root, n);
    }

    private int printPreorder(Node node, int n) {
        if (node == null || n == 0) {
            return n;
        }

        System.out.print(node.word + " ");
        n--;

        n = printPreorder(node.left, n);
        n = printPreorder(node.right, n);

        return n;
    }

    public void printInorder(int n) {
        printInorder(root, n);
    }

    private int printInorder(Node node, int n) {
        if (node == null || n == 0) {
            return n;
        }

        n = printInorder(node.left, n);

        if (n > 0) {
            System.out.print(node.word + " ");
            n--;
        }

        n = printInorder(node.right, n);

        return n;
    }

    public void printPostorder(int n) {
        printPostorder(root, n);
    }

    private int printPostorder(Node node, int n) {
        if (node == null || n == 0) {
            return n;
        }

        n = printPostorder(node.left, n);
        n = printPostorder(node.right, n);

        if (n > 0) {
            System.out.print(node.word + " ");
            n--;
        }

        return n;
    }
}
