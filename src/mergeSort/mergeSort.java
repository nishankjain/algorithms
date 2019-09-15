package mergeSort;

import java.util.Arrays;

import static java.lang.Math.ceil;

public class mergeSort {
    public static int[] sortInts(int[] intArray) {
        int arrayLength = intArray.length;
        if (arrayLength == 1) {
            return intArray;
        }
        int midPoint = (int) ceil(arrayLength / 2);
        int[] leftSplit = Arrays.copyOfRange(intArray, 0, midPoint);
        int[] rightSplit = Arrays.copyOfRange(intArray, midPoint, arrayLength);
        int[] sortedLeftSplit = sortInts(leftSplit);
        int[] sortedRightSplit = sortInts(rightSplit);
        return mergeSplit(sortedLeftSplit, sortedRightSplit);
    }

    public static int[] mergeSplit(int[] leftSplit, int[] rightSplit) {
        int l = 0;
        int r = 0;
        int leftLength = leftSplit.length;
        int rightLength = rightSplit.length;
        int totalLength = leftLength + rightLength;
        int[] mergedArrays = new int[totalLength];
        for (int k = 0; k < totalLength; k++) {
            if (l != leftLength && r == rightLength) {
                mergedArrays[k] = leftSplit[l];
                l++;
            }
            else if (l == leftLength && r != rightLength) {
                mergedArrays[k] = rightSplit[r];
                r++;
            }
            else if (leftSplit[l] <= rightSplit[r]) {
                mergedArrays[k] = leftSplit[l];
                l++;
            }
            else if (leftSplit[l] > rightSplit[r]) {
                mergedArrays[k] = rightSplit[r];
                r++;
            }
        }
        return mergedArrays;
    }

    public static void main(String[] args) {
        int[] intArray = {25, 87, 2, 96, 10, 44, 1, 3, 77, 64};
        int[] sortedArray = sortInts(intArray);
        System.out.println("Given Array: " + Arrays.toString(intArray));
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
    }
}
