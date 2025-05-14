import os
import sys
from concurrent.futures import ThreadPoolExecutor, as_completed

def count_occurrences_in_file(file_path, search_text):
    count = 0
    try:
        with open(file_path, 'r', encoding='utf-8', errors='ignore') as f:
            for line in f:
                count += line.count(search_text)
        if count > 0:
            print(f"File: {file_path} | Occurrences: {count}")
    except Exception as e:
        print(f"Error reading file {file_path}: {e}")

def find_files(directory):
    for root, _, files in os.walk(directory):
        for name in files:
            yield os.path.join(root, name)

def main():
    if len(sys.argv) < 3:
        print("Usage: python search_files.py <directory-path> <search-text>")
        return

    directory = sys.argv[1]
    search_text = sys.argv[2]

    if not os.path.isdir(directory):
        print("Invalid directory:", directory)
        return

    files = list(find_files(directory))

    with ThreadPoolExecutor() as executor:
        futures = [executor.submit(count_occurrences_in_file, file, search_text) for file in files]

        for future in as_completed(futures):
            pass  # Already printing inside the function

if __name__ == "__main__":
    main()
