from lighter import Lighter


def selection_sort_by_lamps_number(lighter_list):
    for i in range(len(lighter_list)):
        for j in range(i, len(lighter_list)):
            if (j == i):
                minVal = lighter_list[j]
                minPos = j;
            if lighter_list[j].lamps_number < minVal.lamps_number:
                minVal = lighter_list[j]
                minPos=j;
                #lighter_list[i], lighter_list[j] = lighter_list[j], lighter_list[i]
                Lighter.compare_count()
        Lighter.change_count()
        lighter_list[i], lighter_list[minPos] = lighter_list[minPos], lighter_list[i]        
    return lighter_list


def merge_sort_by_power(lighter_list):
    if len(lighter_list) <= 1:
        return lighter_list
    list_mid = int(len(lighter_list) / 2)
    left_list = merge_sort_by_power(lighter_list[:list_mid])
    right_list = merge_sort_by_power(lighter_list[list_mid:])
    return merge(left_list, right_list)


def merge(left_list, right_list):
    result_list = []
    i = 0
    j = 0
    while i < len(left_list) and j < len(right_list):
        if left_list[i].power > right_list[j].power:
            result_list.append(left_list[i])
            i += 1
        else:
            result_list.append(right_list[j])
            j += 1
            Lighter.change_count()
            Lighter.compare_count()
    result_list += left_list[i:]
    result_list += right_list[j:]
    return result_list
