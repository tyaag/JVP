from datetime import date, datetime

def get_days_difference(date1, date2):
    return abs((date2 - date1).days)


local_date1 = date(2024, 5, 1)
local_date2 = date(2024, 5, 14)

print("LocalDate examples:")
print("Date 1:", local_date1)
print("Date 2:", local_date2)
print("Difference in days:", get_days_difference(local_date1, local_date2))

print("\nLocalDateTime examples:")

local_datetime1 = datetime(2024, 5, 1, 12, 0, 0)  
local_datetime2 = datetime(2024, 5, 14, 9, 30, 0) 

print("DateTime 1:", local_datetime1)
print("DateTime 2:", local_datetime2)
print("Difference in days:", get_days_difference(local_datetime1.date(), local_datetime2.date()))
