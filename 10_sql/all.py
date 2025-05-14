import sqlite3
import threading
import time
import random

# Database setup
def create_table():
    try:
        conn = sqlite3.connect('students.db')
        cursor = conn.cursor()
        cursor.execute('''
            CREATE TABLE IF NOT EXISTS students (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                marks INTEGER NOT NULL
            )
        ''')
        conn.commit()
        conn.close()
        print("Table created successfully.")
    except Exception as e:
        print("Error creating table:", e)

# Function to insert student into DB
def insert_student(name, marks):
    try:
        # Simulate random error
        if marks < 0:
            raise ValueError("Marks cannot be negative")

        conn = sqlite3.connect('students.db')
        cursor = conn.cursor()
        cursor.execute("INSERT INTO students (name, marks) VALUES (?, ?)", (name, marks))
        conn.commit()
        conn.close()
        print(f"Inserted: {name} with marks {marks}")
    except ValueError as ve:
        print("ValueError:", ve)
    except sqlite3.Error as db_err:
        print("Database error:", db_err)
    except Exception as e:
        print("Unexpected error:", e)

# Thread function
def student_thread(name):
    marks = random.randint(-10, 100)  # Random marks (can be negative to test exception)
    insert_student(name, marks)


# Main
create_table()

names = ["Alice", "Bob", "Charlie", "Diana", "Ethan"]

threads = []
for name in names:
    t = threading.Thread(target=student_thread, args=(name,))
    threads.append(t)
    t.start()

# Wait for all threads to finish
for t in threads:
    t.join()

print("All threads finished. Fetching data...")

# Fetch all records
try:
    conn = sqlite3.connect('students.db')
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM students")
    rows = cursor.fetchall()
    for row in rows:
        print(row)
    conn.close()
except Exception as e:
    print("Error reading data:", e)

