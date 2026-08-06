class Solution {
    public static int[] leftMax(int arr[]) {
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }
        return prefix;
    }

    public static int[] rightMax(int arr[]) {
        int n = arr.length;
        int suffix[] = new int[n];
        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], arr[i]);
        }
        return suffix;
    }

    public int trap(int[] height) {
        int total = 0;
        int leftMax[] = leftMax(height);
        int rightMax[] = rightMax(height);

        for (int i = 0; i < height.length; i++) {
            if (leftMax[i] > height[i] && rightMax[i] > height[i]) {
                total += Math.min(leftMax[i], rightMax[i]) -height[i];
            }
        }

        return total;
    }
}
