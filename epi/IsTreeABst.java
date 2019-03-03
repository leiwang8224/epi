package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

// Verify the binary is a BST
public class IsTreeABst {
    @EpiTest(testDataFile = "is_tree_a_bst.tsv")

    public static boolean isBinaryTreeBST(BinaryTreeNode<Integer> tree) {
        // TODO - you fill in here.
        if (tree == null) return true;
        return checkIfBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkIfBST(BinaryTreeNode<Integer> tree, int minValue, int maxValue) {
        if (tree == null) return true;

        // always check to see if current node value is within range for BST
        if (tree.data < minValue) {
            return false;
        }

        if (tree.data > maxValue) {
            return false;
        }

        //make sure left tree and right tree both follow the BST properties
        //left node is limited by the min value and right tree is limited by the max value
        return checkIfBST(tree.left, minValue, tree.data) && checkIfBST(tree.right, tree.data, maxValue);
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "IsTreeABst.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
