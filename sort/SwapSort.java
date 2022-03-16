package sort;

import java.util.Arrays;
import java.util.LinkedList;

public class SwapSort {

    // 核心思想： 每一次交换，都将此轮最大值放到末尾
    public void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] arr, int j, int i) {
        int tmp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = tmp;
    }

    // -----

    public void quickSort(int[] arr) {
        quickRecursive(arr, 0, arr.length - 1);
    }

    // 核心思想：每次选取一个基准值，一轮下来完成左小右大
    public void quickRecursive(int[] arr, int left, int right) {
        int pos = partition(arr, left, right);
        quickRecursive(arr, left, pos - 1);
        quickRecursive(arr, pos + 1, right);
    }

    // 使用非递归方法  -- 核心：递归其保存的是左右边界，通过栈保存边界值
    public void quickNoRecursive(int[] arr) {
        LinkedList<Integer> stack = new LinkedList<>();

        stack.push(0);
        stack.push(arr.length - 1);

        while (!stack.isEmpty()) {
            int high = stack.pop();
            int low = stack.pop();

            int pos = partition(arr, low, high);

            if (pos > low) {
                stack.push(low);
                stack.push(pos - 1);
            }
            if (pos < high && pos != -1){
                stack.push(pos + 1);
                stack.push(high);
            }

        }

    }

    // 每一轮相对排序，并返回pivot的最终位置
    public int partition(int[] arr, int left, int right) {
        if (arr.length <= 0 || left >= right) {
            return -1;
        }

        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            //  不判断 i j 大小也可以进行赋值 只是不能提前 i++
            //  if(i < j) { arr[i++] = arr[j]; }
            arr[i] = arr[j];

            while (i < j && arr[i] <= pivot) {
                i++;
            }
            arr[j] = arr[i];

        }
        arr[i] = pivot;
        return i;
    }


    public static void main(String[] args) {
        SwapSort swapSort = new SwapSort();

        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27, 49};
        swapSort.quickNoRecursive(arr);
        System.out.println(Arrays.toString(arr));
    }

}

