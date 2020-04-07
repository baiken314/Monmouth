# Bradley Aiken
# prob2.py

import re

print(len(re.findall(r"[Cc]{2}[A-z0-9']*\n", open("english.sorted", "r").read())))
