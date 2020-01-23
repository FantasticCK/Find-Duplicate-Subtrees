package com.CK;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode> res;
    Map<String, Boolean> subTree;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        res = new ArrayList<>();
        subTree = new HashMap<>();
        dfs(root);
        return res;
    }

    private String dfs(TreeNode root) {
        if (root == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");
        String left = dfs(root.left), right = dfs(root.right);
        sb.append(left).append(",").append(right);
        String resString = sb.toString();
        if (subTree.containsKey(resString)) {
            if (!subTree.get(resString)) {
                subTree.put(resString, true);
                res.add(root);
            }
        } else
            subTree.put(resString, false);
        return resString;
    }
}