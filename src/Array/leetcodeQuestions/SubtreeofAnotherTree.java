package Array.leetcodeQuestions;


class TNode {
    int val;
    TNode left;
    TNode right;
    TNode(int x) { val = x; }
}


public class SubtreeofAnotherTree {
    // isSubtree method checks if subRoot is a subtree of root.
    // It does this by recursively traversing the root tree and for each node,
    // it checks if the subtree starting from this node is the same as subRoot using the isSame method.
    // If it finds a match, it returns true. If it doesn't find a match after traversing the whole tree, it returns false.
    public boolean isSubtree(TNode root, TNode subRoot) {
        if (root == null) return false;
        if (isSame(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // isSame method is a helper method that checks if two trees are identical.
    // It does this by recursively checking if the current nodes of both trees are the same
    // and if the left and right subtrees of the current nodes are also the same.
    // If all checks pass, it returns true. If any check fails, it returns false.
    private boolean isSame(TNode t1, TNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }
}
