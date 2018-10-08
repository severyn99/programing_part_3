import csv
from lighter import Lighter
from sorting import selection_sort_by_lamps_number
from sorting import merge_sort_by_power
from datetime import datetime


def read_data_from_file():
    lighter_list = []
    try:
        with open('lighter_data.csv') as csvin:
            reader = csv.reader(csvin)
            for row in reader:
                new_lighter = Lighter(row[0], int(row[1]), int(row[2]), row[3])
                lighter_list.append(new_lighter)
    except FileNotFoundError:
        print("File with data does not exist")
    return lighter_list


if __name__ == "__main__":
    lighters_list = read_data_from_file()
    print("Initial lighter list:\n")
    for lighter in lighters_list:
        print(lighter)

    start = datetime.now().microsecond
    print("\nSorted by lamps number:\n")
    selection_sort_by_lamps_number(lighters_list)
    for lighter in lighters_list:
        print(lighter)
    finish = datetime.now().microsecond
    print("Working time: " + Lighter.work_time(start, finish).__str__())
    print("Comparisons done: " + str(Lighter.comparing_number) + "\nSwaps done: " + str(Lighter.change_number))

    Lighter.reset_count()

    start = datetime.now().microsecond
    print("\nSorted by power:\n")
    result2 = merge_sort_by_power(lighters_list)
    for lighter in result2:
        print(lighter)
    finish = datetime.now().microsecond
    print("Working time: " + Lighter.work_time(start, finish).__str__())
    print("Comparisons done: " + str(Lighter.comparing_number) + "\nSwaps done: " + str(Lighter.change_number))
