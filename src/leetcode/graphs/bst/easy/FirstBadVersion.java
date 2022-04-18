package leetcode.graphs.bst.easy;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately,
 * the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
public class FirstBadVersion {

    // code implementation defined by leet code.. added to avoid compilation errors.
    boolean isBadVersion(int v) {
        return true;
    }

    public int firstBadVersion(int n) {

        long lastestGoodVersion = 0;
        long oldestBadVersion = n;
        long low = 1;
        long high = n;
        while((lastestGoodVersion + 1) < (oldestBadVersion)) {
            long mid = (low + high)/2;
            if(isBadVersion((int)mid)) {
                oldestBadVersion = mid;
                high = mid - 1;
            } else {
                lastestGoodVersion = mid;
                low = mid + 1;
            }
        }
        return (int)oldestBadVersion;
    }

}
