from functools import reduce
from typing import Optional

numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

squares = list(map(lambda x: x * x, numbers))
print("Squares:", squares)

even_numbers = list(filter(lambda x: x % 2 == 0, numbers))
print("Even numbers:", even_numbers)

total_sum = reduce(lambda x, y: x + y, numbers)
print("Sum of all numbers:", total_sum)

def get_optional_upper(value: Optional[str]) -> str:
    return value.upper() if value is not None else "DEFAULT"

name = "python"
none_name = None
print("Upper name:", get_optional_upper(name))        
print("Upper name (None):", get_optional_upper(none_name))  
