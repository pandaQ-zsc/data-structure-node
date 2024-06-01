const map = new Map();
map.set(123, '小哈')
map.set(154, '小低')
map.set(167, '小痛')
map.set(233, '我哈')
map.set(893, '有哈')
map.set(1023, '想哈')


7
for (const [k, v] of map.entries()) {
  console.info(k + ' -> ' + v)
}

console.info('\n 单独遍历键 key')
for (const k of map.keys()) {
  console.info(k + '->' + k)
}
let i = Math.random()
console.log(i);
console.log(i);


class HashMapOpenAddressing {
  size;
  capacity;
  loadThres;

  constructor () {
    this.size = 0;
    this.capacity = 4;
    this.loadThres = 2.0;
  }
}

const nums = [1, 3, 2, 5, 4];
const nums1 = [6, 8, 7, 10, 9];
const nums2 = nums.push(nums1);
console.log(nums);
console.log('==============')
nums.push(...nums1);
console.log(nums);

function  levelOrder(root){
  const queue = [root];
  const list = [];
  while(queue.length){
    let node = queue.shift();
    list.push(node.val);
    if (node.left) queue.push(node.left);
    if (node.right)queue.push(node.right);
  }
  return  list;

}

class TreeNode{
  val;
  height;
  left;
  right;
  constructor (val,left,right, height) {
    this.val = val === undefined ? 0:val;
    this.height = height ===undefined ? 0 : height;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null:right;
  }


}
