/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l = 0;
        int r = mountainArr.length() - 1;
        int mountIndex = 0;
        
        while(l <= r) {
            int mid = l + (r-l)/2;
            int midValue = mountainArr.get(mid);
            int prevValue;
            if(mid-1 >= 0) {
                prevValue = mountainArr.get(mid-1);
            } else {
                prevValue = -1;
            }
            int nextValue;
            if(mid + 1 < mountainArr.length()) {
                nextValue = mountainArr.get(mid+1);
            } else {
                nextValue = -1;
            }
            
            if(midValue >= prevValue && midValue >= nextValue) {
                mountIndex = mid;
                break;
            } else if(midValue > prevValue && midValue < nextValue) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        // we have the mountIndex;
        int mountIndexValue = mountainArr.get(mountIndex);

        if(target == mountIndexValue) {
            return mountIndex;
        }
        int ans = Integer.MAX_VALUE;

        l = 0;
        r = mountIndex;
        int leftMinIndex = -1;
        int rightMinIndex = -1;

        while(l <= r) {
            int mid = l + (r-l)/2;
            int midValue = mountainArr.get(mid);
                
            if(midValue == target) {
                leftMinIndex = mid;
                break;
            } else if(midValue < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if(leftMinIndex != -1) {
            return leftMinIndex;
        }
        if(leftMinIndex == -1) { // cannot find in left side
            l = mountIndex;
            r = mountainArr.length() - 1;

            while(l <= r) {
                int mid = l + (r-l)/2;
                int midValue = mountainArr.get(mid);
                    
                if(midValue == target) {
                    rightMinIndex = mid;
                    break;
                } else if(midValue < target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        
        return rightMinIndex;
    }
}