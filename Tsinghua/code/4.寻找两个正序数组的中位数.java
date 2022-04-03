/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {

  // 找到数组第 k 个值，k 值动态递减（二分，比较中间值）
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1 = nums1.length;
    int len2 = nums2.length;

    // 奇数时（len1 + len2 + 1）/ 2 和 (len1 + len2 + 2) / 2 是一样的
    int k1 = (len1 + len2 + 1) / 2;
    int k2 = (len1 + len2 + 2) / 2;

    return (
      (getKth(nums1, 0, nums2, 0, k1) + getKth(nums1, 0, nums2, 0, k2)) / 2.0
    );
  }

  public int getKth(int[] arr1, int p1, int[] arr2, int p2, int k) {
    // 剩余长度
    int r1 = arr1.length - p1;
    int r2 = arr2.length - p2;
    // 始终保证 arr1 是较短数组
    if (r1 > r2) {
      return getKth(arr2, p2, arr1, p1, k);
    }

    if (r1 == 0) return arr2[p2 + k - 1];
    if (k == 1) return Math.min(arr1[p1], arr2[p2]);

    // 各自比较第 k /2 个值，不够就拿出全部
    int i = p1 + Math.min(r1, k / 2) - 1;
    int j = p2 + Math.min(r2,k / 2) - 1;
    if (arr1[i] > arr2[j]){
        return getKth(arr1,p1,arr2,j + 1, k - (j + 1 - p2));
    }else{
        return getKth(arr1,i + 1, arr2,p2,k - (i + 1 - p1));
    }
  }

  // 遍历 len/2 次
  public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
    int len1 = nums1.length;
    int len2 = nums2.length;
    int len = len1 + len2;

    int left = -1;
    int right = -1;
    int p1 = 0;
    int p2 = 0;

    for (int i = 0; i <= len / 2; i++) {
      left = right;
      // 什么时候 nums1 数组后移
      // 1、保证 p1 没走到头 2、要是 p2 走到头 || 小于
      if (p1 < len1 && (p2 >= len2 || nums1[p1] < nums2[p2])) {
        right = nums1[p1++];
      } else {
        right = nums2[p2++];
      }
    }

    //奇偶不同
    if ((len & 1) == 0) {
      return (left + right) / 2.0;
    } else {
      return right;
    }
  }
}
// @lc code=end
