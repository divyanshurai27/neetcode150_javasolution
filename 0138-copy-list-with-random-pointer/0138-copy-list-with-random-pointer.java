class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        // Step 1: Insert copy after every original node
        Node curr = head;

        while (curr != null) {

            Node copy = new Node(curr.val);

            copy.next = curr.next;
            curr.next = copy;

            curr = curr.next.next;
        }

        // Step 2: Copy random pointers
        curr = head;

        while (curr != null) {

            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        // Step 3: Separate original and copied lists
        Node dummyNode = new Node(-1);
        Node res = dummyNode;

        curr = head;

        while (curr != null) {

            // Take copied node
            res.next = curr.next;
            res = res.next;

            // Restore original list
            curr.next = curr.next.next;
            curr = curr.next;
        }

        return dummyNode.next;
    }
}