def find_common_time(list):
    left = 0
    right = 1
    list_len = list.__len__()

    # сортуємо
    for iterator in range(1, list_len):
        index = iterator - 1

        while index > -1 and list[index] > list[index + 1]:
            list[index], list[index + 1] = list[index + 1], list[index]
            index -= 1

    temp_i = 0  # індекс першого елемента
    while temp_i < list_len - 1:
        temp_j = temp_i + 1  # індекс другого
        while temp_j < list_len:
            if list[temp_i][right] > list[temp_j][right]:
                list.pop(temp_j)
                # коли ми втдаляємо temp_j-ий елемент - розмір списку зменшується
                list_len -= 1
            else:
                if list[temp_i][right] < list[temp_j][left]:
                    temp_j += 1
                    continue
                else:
                    #  ліпимо до купи лівий елемент першого списку і правий елемент другого списку
                    merged_element = (list[temp_i][left], list[temp_j][right])
                    list[temp_i] = merged_element
                    list.pop(temp_j)
                    list_len -= 1
        temp_i += 1
    return list


time_list = [(1, 3), (7, 9), (2,6), (12, 16)]

print(find_common_time(time_list))