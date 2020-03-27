# Bradley Aiken
# pyex5.py
# uses roster.txt

import re

roster = {}

input_file = open('roster.txt', 'r')

for student in input_file.readlines():
    # split into last, first, email
    [last, first, email] = re.split('\s*,\s*', student)
    email = email.rstrip()  # remove newline
    student_id = re.sub('@monmouth.edu', '', email)  # substitution
    roster[student_id] = last + ', ' + first

for key in roster.keys():
    print(key, ', ', roster[key], sep='')
    