/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 //TC:O(N) SC:O(N) 87ms 
class Solution {
    private TreeNode findNode(TreeNode root,int key){
        if(root==null)return null;
        if(root.val==key){
            return root;
        }
        TreeNode leftc=findNode(root.left,key);
        if(leftc!=null)return leftc;
        TreeNode rightc=findNode(root.right,key);
        if(rightc!=null)return rightc;
        return null;

    }
    private void getAllParentNode(TreeNode root,Map<TreeNode,TreeNode> map){
        if(root==null)return;
        //if root has left child so root is the parent of left child
        if(root.left!=null){
            map.put(root.left,root);
        }
         //if root has right child so root is the parent of right child
        if(root.right!=null){
            map.put(root.right,root);
        }
        getAllParentNode(root.left,map);
        getAllParentNode(root.right,map);
    }
    public int amountOfTime(TreeNode root, int start) {
        //1.get the target node
        TreeNode src=findNode(root,start);
        //get parents of all nodes
        Map<TreeNode,TreeNode> map=new HashMap<>();
        getAllParentNode(root,map);
        //start DFS from Queue
        Queue<TreeNode> q=new LinkedList<>();
        q.add(src);
        //for visiting node
        HashSet<TreeNode> vis=new HashSet<>();
        vis.add(src);
        int time=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                TreeNode curr=q.poll();
                ///we can burn LEFT,RIGHT,Parent

                //left if not burned/visited
                if(curr.left!=null && vis.contains(curr.left)==false){
                    q.add(curr.left);
                    vis.add(curr.left);
                }


                //right if not burned/visited
                if(curr.right!=null && vis.contains(curr.right)==false){
                    q.add(curr.right);
                    vis.add(curr.right);
                }

                //parent if exists and not burned/visited
                if(map.containsKey(curr) && vis.contains(map.get(curr))==false){
                    q.add(map.get(curr));
                    vis.add(map.get(curr));
                }
            }
            time++;
            
        }
        return time-1;

    }
}