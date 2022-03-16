import java.util.Arrays;

public class InsertionSort {

    // 核心思想：有序数组中 找位置 -- 给无序数组第一个 找位置
    public void myInsertSort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            // 查找位置插入 -- 可能存在二分查找进行优化
            int toInsert = arr[i];
            int toPos = 0;
            while (arr[toPos] <= toInsert && toPos < i) {
                toPos++;
            }
            // 插入到 toPos 位置
            if (toPos != i) {
                System.arraycopy(arr, toPos, arr, toPos + 1, i - toPos);
                arr[toPos] = toInsert;
            }

        }
    }

    // 针对位置插入 从后向前 边判断大小，边移动元素
    public void insertSortOpt(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            // 从后往前移动元素
            int toInsert = arr[i];
            for (int pos = i; pos >= 0; pos--) {
                if (pos > 0 && arr[pos - 1] > toInsert) {
                    arr[pos] = arr[pos - 1];
                } else {
                    arr[pos] = toInsert;
                    break;
                }
            }
            // 这种情况 解决不了插入位在第 0 位的情况
//            for (int pos = i - 1; pos >= 0; pos--) {
//                if (arr[pos] > toInsert) {
//                    arr[pos + 1] = arr[pos];
//                } else {
//                    arr[pos + 1] = toInsert;
//                    break;
//                }
//            }
        }
    }

    public void insertSortSwap(int[] arr) {
        // 此刻 i 标记的有序数组最后一位
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] >= arr[j - 1]) {
                    break;
                }
                // 交换
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
            }
        }
    }

    public void insertSortBinary(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 通过二分 查找插入位置

            // 边界 0、i两种情况，返回何值比较合适
            int toInset = arr[i];
            int pos = binarySearch(arr, i - 1, toInset);

            if (pos != i) {
                System.arraycopy(arr, pos, arr, pos + 1, i - pos);
                arr[pos] = toInset;
            }
        }
    }

    public int binarySearch(int[] arr, int end, int key) {
        int left = 0;
        int right = end;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (key >= arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        InsertionSort testClass = new InsertionSort();

        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        testClass.insertSortBinary(arr);
        System.out.println(Arrays.toString(arr));
    }
}

