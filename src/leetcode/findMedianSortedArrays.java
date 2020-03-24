package leetcode;

public class findMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int mid = (len1 + len2) / 2;
        boolean flag = (len1 + len2) % 2 == 0;
        int left = 0;
        int right = 0;
        int cnt = 0;
        int ret =0;
        while (cnt <= mid) {
            if (nums1[left] > nums2[right]) {
                if (cnt == mid - 1 && flag) {
                    ret = ret +
                }
                if (cnt == mid) {

                }
                right++;
            }else {
                left++;
            }
            cnt++;
        }
    }
}
