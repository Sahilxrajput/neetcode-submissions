class Solution {

    public int trap(int[] height) {
        int n = height.length;
        int total = 0, left = 0, right = n - 1, leftMax = 0, rightMax = 0;

        while (left < right) {

            if (height[left] < height[right]) {

                if (height[left] < leftMax) {
                    total += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }

                left++;

            } else {

                if (height[right] < rightMax) {
                    total += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }

                right--;
            }
        }

        return total;
    }
}