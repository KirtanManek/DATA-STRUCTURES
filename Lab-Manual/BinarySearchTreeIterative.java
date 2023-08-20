import java.util.Scanner;

class BinarySearchTreeIterative {
    public static void main(String[] args) {
        BST tree = new BST();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert a node");
            System.out.println("2. Delete a node");
            System.out.println("3. Display");
            System.out.println("4. Preorder Traversal");
            System.out.println("5. Postorder Traversal");
            System.out.println("6. Inorder Traversal");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value to insert: ");
                    int value = sc.nextInt();
                    tree.insert(value);
                }
                case 2 -> {
                    System.out.print("Enter value to delete: ");
                    int deleteValue = sc.nextInt();
                    tree.delete(deleteValue);
                }
                case 3 -> tree.print();
                case 4 -> {
                    System.out.print("Preorder Traversal: ");
                    tree.preorderTraversal(tree.root);
                    System.out.println();
                }
                case 5 -> {
                    System.out.print("Postorder Traversal: ");
                    tree.postorderTraversal(tree.root);
                    System.out.println();
                }
                case 6 -> {
                    System.out.print("Inorder Traversal: ");
                    tree.inorderTraversal(tree.root);
                    System.out.println();
                }
                case 7 -> {
                    System.out.println("Exiting......");
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Please select a valid option.");
            }
        }
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BST {
    Node root;

    void insert(int x) {
        Node node = new Node(x);
        if (root == null) {
            root = node;
            return;
        }
        Node previous = null;
        Node current = root;
        while (current != null) {
            if (current.data > x) {
                previous = current;
                current = current.left;
            } else if (current.data < x) {
                previous = current;
                current = current.right;
            } else {
                return;
            }
        }

        // here your previous node will be at last node where you want to insert, and
        // the current node will be null
        if (previous.data > x) {
            previous.left = node;
        } else {
            previous.right = node;
        }
    }

    public void delete(int data) {
        Node current = root;
        Node parent = null;
        boolean isLeftChild = false;

        // Search for the node to be deleted
        while (current != null && current.data != data) {
            parent = current;
            if (data < current.data) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
        }

        // If node isn't found
        if (current == null) {
            System.out.println("Node with data " + data + " not found");
            return;
        }

        // If node has no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        // If node has only one child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }

        // If node has two children
        else {
            // get successor method will find the minimum node from the right subtree of node to be deleted
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
    }
    
    // get successor method will find the minimum node from the right subtree of node to be deleted
    public Node getSuccessor(Node node) {
        Node current = node.right;
        Node successor = null;
        Node successorParent = null;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if (successor != node.right) {
            successorParent.left = successor.right;
            successor.right = node.right;
        }
        return successor;
    }

    void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    void postorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public void print() {
        print("", root, false);
    }

    public void print(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + n.data);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
        }
    }
}