package countingInversions;

import java.util.Arrays;

import static java.lang.Math.ceil;

class ReturnValues {
    int numberOfInversions;
    int[] sortedArray;
    public ReturnValues(int numberOfInversions, int[] sortedArray) {
        this.numberOfInversions = numberOfInversions;
        this.sortedArray = sortedArray;
    }
}

public class countingInversions {
    public static ReturnValues countInversions(int[] intArray) {
        int arrayLength = intArray.length;
        int numberOfInversions = 0;
        if (arrayLength == 1) {
            return new ReturnValues(0, intArray);
        }
        int midPoint = (int) ceil(arrayLength / 2);
        int[] leftSplit = Arrays.copyOfRange(intArray, 0, midPoint);
        int[] rightSplit = Arrays.copyOfRange(intArray, midPoint, arrayLength);
        ReturnValues sortedLeftSplit = countInversions(leftSplit);
        numberOfInversions += sortedLeftSplit.numberOfInversions;
        ReturnValues sortedRightSplit = countInversions(rightSplit);
        numberOfInversions += sortedRightSplit.numberOfInversions;
        return mergeSplits(numberOfInversions, sortedLeftSplit.sortedArray, sortedRightSplit.sortedArray);
    }

    public static ReturnValues mergeSplits(int numberOfInversions, int[] leftSplit, int[] rightSplit) {
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
                numberOfInversions += leftLength - l;
            }
        }
        return new ReturnValues(numberOfInversions, mergedArrays);
    }

    public static void main(String[] args) {
        int[] intArray = {25, 87, 2, 96, 10, 44, 1, 3, 77, 64};
//        int[] intArray = {1, 3, 5, 2, 4, 6};
        ReturnValues sortedInts = countInversions(intArray);
        System.out.println("Given Array: " + Arrays.toString(intArray));
        System.out.println("Sorted Array: " + Arrays.toString(sortedInts.sortedArray));
        System.out.println("Number Of Inversions: " + sortedInts.numberOfInversions);
    }
}
