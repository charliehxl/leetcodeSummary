package sort;

import java.util.Arrays;

public class SelectionSort {

    // 核心思想：无序数值中 选 最小值，放到无序数组第一位
    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 找到最小值
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }

    // 核心：构建大顶堆，选 堆顶元素，放到数组边界处
    // 将无序数组建成大顶堆，将最大值（坐标 0）和 数组最后一位 交换，再将剩余元素重新调整成堆

    public void heapSort(int[] arr) {
        // 从第一个非叶子结点从下至上，从右至左调整结构
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapAdjust(arr, i, arr.length);
        }

        // 调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            // 将堆顶元素与末尾元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapAdjust(arr, 0, i);
        }
    }

    /**
     * 将指定范围内的数组调整成大顶堆
     *
     * @param arr
     * @param parent 需要调整的节点
     * @param limit  限定数组调整的边界
     */
    public void heapAdjust(int[] arr, int parent, int limit) {
        int root = arr[parent];
        int lChild = 2 * parent + 1;
        while (lChild < limit) {
            // 左右孩子选大值
            if (lChild + 1 < limit && arr[lChild + 1] > arr[lChild]) {
                lChild++;
            }
            // 这一块 arr[lChild] < arr[parent] 是不正确的 需要给 root 找位置
            if (arr[lChild] < root) {
                break;
            }
            // 将父节点覆盖
            arr[parent] = arr[lChild];
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        arr[parent] = root;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();

        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27};
        selectionSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}

