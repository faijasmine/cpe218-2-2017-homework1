public class Node {
    Node left;
    Node right;

    Character num_ope;

    Node(Character input) {
        num_ope = input;
    }

    public String toString() {
        return num_ope.toString();
    }

}

