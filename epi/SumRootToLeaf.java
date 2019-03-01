package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

// Consider a binary tree in which each node contains a binary digit. A root to leaf path
// can be associated with a binary number. The MSB at the root. Design an algorithm
// to compute the sum of the binary numbers represented by the root to leaf paths.

public class SumRootToLeaf {
    @EpiTest(testDataFile = "sum_root_to_leaf.tsv")

    public static int sumRootToLeaf(BinaryTreeNode<Integer> tree) {
        return sumUpFromRoot(tree, 0);
    }

    private static int sumUpFromRoot(BinaryTreeNode<Integer> tree, int partialSum) {
        if (tree == null) return 0;

        // for each digit of 1's, multiply the current sum by 2 and add current node data
        partialSum = partialSum * 2 + tree.data;
        if (tree.left == null && tree.right == null)
            return partialSum;

        return sumUpFromRoot(tree.left, partialSum) + sumUpFromRoot(tree.right, partialSum);

    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "SumRootToLeaf.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
