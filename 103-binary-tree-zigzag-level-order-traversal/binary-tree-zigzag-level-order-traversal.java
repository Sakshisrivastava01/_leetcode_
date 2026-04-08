
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       

        if(root == null) return new ArrayList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

    
        int level = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            for(int i =0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            
        
            if(level % 2 == 1) Collections.reverse(list);
            level++;
            result.add(list);
        }
            return result;
    }
}