import math


def countInversions(int_array):
    array_length = len(int_array)
    number_of_inversions = 0
    if array_length == 1:
        return (0, int_array)
    mid_point = math.floor(array_length / 2)
    left_split = int_array[:mid_point]
    right_split = int_array[mid_point:]
    left_inversions, sorted_left_split = countInversions(left_split)
    number_of_inversions += left_inversions
    right_inversions, sorted_right_split = countInversions(right_split)
    number_of_inversions += right_inversions
    return merge_splits(number_of_inversions, sorted_left_split, sorted_right_split)


def merge_splits(number_of_inversions, left_split, right_split):
    l = 0
    r = 0
    k = 0
    left_length = len(left_split)
    right_length = len(right_split)
    total_length = left_length + right_length
    sorted_array = [None] * total_length
    while k < total_length:
        if l != left_length and r == right_length:
            sorted_array[k] = left_split[l]
            l += 1
        elif l == left_length and r != right_length:
            sorted_array[k] = right_split[r]
            r += 1
        elif left_split[l] <= right_split[r]:
            sorted_array[k] = left_split[l]
            l += 1
        elif left_split[l] > right_split[r]:
            sorted_array[k] = right_split[r]
            r += 1
            number_of_inversions += left_length - l
        k += 1
    return (number_of_inversions, sorted_array)


def main(input_array):
    number_of_inversions, sorted_array = countInversions(input_array)
    print("Given Array: ", input_array)
    print("Sorted Array: ", sorted_array)
    print("Number Of Inversions: ", number_of_inversions)

if __name__ == "__main__":
    int_array = [25, 87, 2, 96, 10, 44, 1, 3, 77, 64]
    # int_array = [1, 3, 5, 2, 4, 6]
    main(int_array)
