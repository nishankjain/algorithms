import math


def sort_ints(int_array):
    array_length = len(int_array)
    if array_length == 1:
        return int_array
    mid_point = math.floor(array_length / 2)
    left_split = int_array[:mid_point]
    right_split = int_array[mid_point:]
    sorted_left_split = sort_ints(left_split)
    sorted_right_split = sort_ints(right_split)
    return merge_splits(sorted_left_split, sorted_right_split)


def merge_splits(left_split, right_split):
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
        k += 1
    return sorted_array


def main(input_array):
    sorted_array = sort_ints(input_array)
    print("Given Array: ", input_array)
    print("Sorted Array: ", sorted_array)

if __name__ == "__main__":
    int_array = [25, 87, 2, 96, 10, 44, 1, 3, 77, 64]
    main(int_array)
