/* AVL 树节点类 */
class TreeNode {
  val; // 节点值
  height; //节点高度
  left; // 左子节点指针
  right; // 右子节点指针
  constructor(val, left, right, height) {
    this.val = val === undefined ? 0 : val;
    this.height = height === undefined ? 0 : height;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }

}
