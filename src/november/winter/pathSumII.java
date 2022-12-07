package november.winter;

public class pathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        pathSum(root, result, new ArrayList<Integer>(), sum);
        return result;
    }

    private void pathSum(TreeNode root, List<List<Integer>> result, List<Integer> tmp, int sum)
    {
        if (root.left == null && root.right == null)
        {
            if (root.val == sum)
            {
                List<Integer> subList = new ArrayList<>(tmp);
                subList.add(root.val);
                result.add(subList);
            }
            return;
        }
        tmp.add(root.val);
        if (root.left != null) pathSum(root.left, result, tmp, sum - root.val);
        if (root.right != null) pathSum(root.right, result, tmp, sum - root.val);
        tmp.remove(tmp.size() - 1);
    }
}
