public class RedBlackTreeImpl {

    public static class Node {
        private int data;
        private Node parentNode;
        private Node left;
        private Node right;
        private Color color;

        public Node getParentNode() {
            return parentNode;
        }

        public void setParentNode(Node parentNode) {
            this.parentNode = parentNode;
        }

        public int getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public Color getColor() {
            return color;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        enum Color {
            RED("RED") , BLACK("BLACK");

            String colorVal;

            Color(String colorVal) {
                this.colorVal = colorVal;
            }

            public String getColorVal() {
                return colorVal;
            }
        }
    }

    private Node head;

    private boolean isEmpty() {
        return head == null;
    }

    private Node createNewNode(int value) {
        Node newNode = new Node();
        newNode.setColor(Node.Color.RED);
        newNode.setData(value);
        return newNode;
    }
    // Rules
    // 1. If new node is root , change color
    // 2. If Uncle is red , change color of parent, gp, uncle
    // 3. if uncle is black , and forms a triangle , rotate parent opp direction of new node
    // 4. if uncle is black , and forms a straight line , rotate GP and change color of original GP and parent
    private void insert(int nodeValue) {
        Node newNode = createNewNode(nodeValue);
        if(isEmpty()) {
            // 1. If new node is root , change color
            head = newNode;
            newNode.setColor(Node.Color.BLACK);
//            return head;
        }
        initialInsertByBinarySearch(head,newNode);
        // Check for violation

        try {
            Node uncle = determineUncle(newNode);
            if(uncle == null || uncle.getColor().equals(Node.Color.BLACK)) {
                // consider the uncle to be black node.
                // check point 3 and 4 recursively
            } else {
                // 2. If Uncle is red , change color of parent, gp, uncle
                // change color parent
                Node parent = newNode.getParentNode();
                changeColor(parent);
                // change color GP
                Node grandParent = parent.getParentNode();
                changeColor(parent);
                // change color uncle
                changeColor(uncle);
            }
        } catch (RuntimeException e) {
            System.out.println("NO uncles.. Leave the binary as is");
            return;
        }
    }

    private void changeColor(Node node) {
        if(node.getColor().equals(Node.Color.BLACK)) {
            node.setColor(Node.Color.RED);
        } else {
            node.setColor(Node.Color.BLACK);
        }
    }

    private Node determineUncle(Node meNode) {
        Node parent = meNode.getParentNode();
        if(parent != null) {
            Node grandParent = parent.getParentNode();
            if(grandParent != null) {
                if(grandParent.getLeft() != parent) {
                    return grandParent.getLeft();
                }
                if(grandParent.getRight() != parent) {
                    return grandParent.getRight();
                }
            }
        }
        throw new RuntimeException("No Uncles");
    }

    // binary search location for the new node
    private void initialInsertByBinarySearch(Node headNode,Node newNode) {
        if(headNode.getData() < newNode.getData()) {
            if(headNode.getRight() != null) {
                initialInsertByBinarySearch(headNode.getRight(),newNode);
            } else {
                headNode.setRight(newNode);
                newNode.setParentNode(headNode);
                return;
            }
        } else {
            if(headNode.getLeft() != null) {
                initialInsertByBinarySearch(headNode.getLeft(),newNode);
            } else {
                headNode.setLeft(newNode);
                newNode.setParentNode(headNode);
                return;
            }
        }
    }




    public static void main(String[] args) {

    }







}
