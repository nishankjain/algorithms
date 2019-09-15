import math


def multiply_ints(int1, int2):
    if int1 < 10 or int2 < 10:
        return int1 * int2

    str1 = str(int1)
    str2 = str(int2)
    len1 = len(str1)
    len2 = len(str2)

    power = math.floor(min(len1, len2) / 2)

    a = int(str1[:len1-power])
    b = int(str1[len1-power:])
    c = int(str2[:len2-power])
    d = int(str2[len2-power:])

    ac = multiply_ints(a, c)
    ad_plus_bc = multiply_ints(a+b, c+d)
    bd = multiply_ints(b, d)

    return (10 ** (power * 2)) * ac + (10 ** power) * (ad_plus_bc - ac - bd) + bd

int1 = 3141592653589793238462643383279502884197169399375105820974944592
int2 = 2718281828459045235360287471352662497757247093699959574966967627

result = multiply_ints(int1, int2)
built_in = int1 * int2
print('Using Karatsuba: ', result)
print('Using built-in: ', built_in)
if result == built_in:
    print('Results match')
else:
    print('Results do not match')
