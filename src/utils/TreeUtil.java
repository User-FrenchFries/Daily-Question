package utils;

import java.util.ArrayList;
import java.util.List;

import questionBean.TreeNode;

public final class TreeUtil {
    public static final TreeUtil INSTANCE = new TreeUtil();

    private TreeUtil() {
        // empty
    }

    /**
     * 广度优先遍历
     * 二叉树的bfs就是层序遍历，使用队列或者list都可以实现
     *
     * @param root 根节点
     */
    public void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove(0);
            System.out.println(node);
            if (node.getLeft() != null) {
                nodes.add(node.getLeft());
            }
            if (node.getRight() != null) {
                nodes.add(node.getRight());
            }
        }
    }

    /**
     * 深度优先遍历
     * 二叉树的dfs就是前序遍历，使用递归实现
     *
     * @param root 根节点
     */
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        dfs(root.getLeft());
        dfs(root.getRight());
    }
}
