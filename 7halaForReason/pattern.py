
size=4
cnt= size*2*size -1

for i in range(size, -1, -1):
	print("  " * (size - i), end="")
	for j in range((i * 2) - 1, 0, -1):
		print(f"{cnt} ", end="")
		cnt -= 2
	print()

print()


