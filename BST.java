public class BST <T> {

    Node root;

   //Returns True if item is found in tree
   public boolean find(Comparable item) {
        return find(item, root);
    }
   private boolean find(Comparable item, Node node) {
        if(node == null) {
            return false;
        }
        if(node.data == item) {
            return true;
        }
        if(item.compareTo(node.data) < 0) {
            return find(item, node.left);
        } else {
            return find(item, node.right);
        }
    }

    //Inserts Item to the appropriate place in BST , duplicates in their own node
    public void insert(Comparable item) {
        root = insert(item, root);
    }
    private Node insert(Comparable item, Node node) {
        if(node == null) {
            return new Node(item);
        }

       if(item.compareTo(node.data) < 0) {
            node.left = insert(item, node.left);
            return node;
        } else {
            node.right = insert(item, node.right);
            return node;
        }
    }

    // prints all elements in tree in order
    public void print() {
        print(root);
    }
    private void print(Node node) {
        if(node != null) {
            print(node.left);
            System.out.println(node.data);
            print(node.right);
        }
    }

    // Deletes node containing item as data
    public void delete(Comparable item) {
        root = delete(root,item);
    }
    private Node delete(Node node, Comparable item) {
        if(node == null) {
            return null;
        }

        if(item.compareTo(node.data) == 0) {
            if(node.left == null) {
                return node.right;
            }
            if(node.right == null) {
                return node.left;
            }
            if(node.right.left == null) {
                node.data = node.right.data;
                node.right = node.right.right;
                return node;
            } else {
                node.data = removeSmallest(node.right);
                return node;
            }
        }
        return node;
    }
    
    private Comparable removeSmallest(Node node) {
        if(node.left.left == null) {
            Comparable smallest = node.left.data;
            node.left = node.left.right;
            return smallest;
        } else {
            return removeSmallest(node.left);
        }
    }
}

