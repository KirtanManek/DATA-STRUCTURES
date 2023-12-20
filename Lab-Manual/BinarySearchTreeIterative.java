import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BinarySearchTreeIterative {
    public static void main(String[] args) {
        BST tree = new BST();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert a Meaning in dictionary");
            System.out.println("2. Delete a Meaning from dictionary");
            System.out.println("3. Inorder Traversal");
            System.out.println("4. Search Word");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter word to insert: ");
                    String k = sc.next();
                    System.out.print("Enter its meaning: ");
                    String v = sc.next();
                    tree.insert(k, v);
                }
                case 2 -> {
                    System.out.print("Enter word to delete: ");
                    String deleteValue = sc.next();
                    tree.delete(deleteValue);
                }
                case 3 -> {
                    System.out.print("Inorder Traversal: ");
                    tree.inorderTraversal(tree.root);
                    System.out.println();
                }
                case 4 -> {
                    System.out.print("Enter word to search: ");
                    String searchValue = sc.next();
                    tree.searchWord(searchValue);
                }
                case 0 -> {
                    System.out.println("Exiting......");
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Please select a valid option.");
            }
        }
    }
}

class TreeNode {
    String key;
    String value;
    TreeNode left;
    TreeNode right;

    TreeNode(String key, String value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BST {
    TreeNode root;

    void insert(String key, String value) {
        String k = key.toLowerCase();
        String v = value.toLowerCase();
        TreeNode node = new TreeNode(k, v);
        if (root == null) {
            root = node;
            return;
        }
        TreeNode previous = null;
        TreeNode current = root;
        while (current != null) {
            if (current.key.compareTo(k) > 0) {
                previous = current;
                current = current.left;
            } else if (current.key.compareTo(k) < 0) {
                previous = current;
                current = current.right;
            } else {
                return;
            }
        }

        // here your previous node will be at last node where you want to insert, and
        // the current node will be null
        if (previous.key.compareTo(k) > 0) {
            previous.left = node;
        } else {
            previous.right = node;
        }
    }

    public void searchWord(String key) {
        String k = key.toLowerCase();
        TreeNode current = root;
        while (current != null) {
            if (current.key.compareTo(k) > 0) {
                current = current.left;
            } else if (current.key.compareTo(k) < 0) {
                current = current.right;
            } else {
                System.out.println("Meaning of " + key + " is " + current.value);
                return;
            }
        }
        System.out.println("Word not found");
    }

    public void delete(String key) {
        key = key.toLowerCase();
        TreeNode current = root;
        TreeNode parent = null;
        // Search for the node to be deleted
        while (current != null && current.key.compareTo(key) != 0) {
            parent = current;
            if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        // If node isn't found
        if (current == null) {
            System.out.println("Node with key " + key + " not found");
            return;
        }

        // If node has no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (key.compareTo(parent.key) < 0) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        // If node has only one child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (key.compareTo(parent.key) < 0) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (key.compareTo(parent.key) < 0) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }

        // If node has two children
        else {
            TreeNode successor = current.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            if (current == root) {
                root = current.right;
            } else if (key.compareTo(parent.key) < 0) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
            successor.left = current.left;
        }
    }

    void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.key + ": " + root.value + "\n");
        inorderTraversal(root.right);
    }
}