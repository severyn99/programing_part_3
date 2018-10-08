class Lighter:
    comparing_number = 0
    change_number = 0

    @staticmethod
    def compare_count():
        Lighter.comparing_number += 1
        return Lighter.comparing_number

    @staticmethod
    def change_count():
        Lighter.change_number += 1
        return Lighter.change_number

    @staticmethod
    def reset_count():
        Lighter.comparing_number = 0
        Lighter.change_number = 0

    @staticmethod
    def work_time(start_time, finish_time):
        return finish_time - start_time

    def __init__(self, type, power, lamps_number, manufacturer):
        self.type = type
        self.power = power
        self.lamps_number = lamps_number
        self.manufacturer = manufacturer

    def __repr__(self):
        return "Type = " + self.type + ", power = " + str(self.power) + ", number of lamps = " + str(self.lamps_number) + ", manufacturer = " + self.manufacturer
