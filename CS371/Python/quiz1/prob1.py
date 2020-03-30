# Bradley Aiken
# prob1.py

import re

for match in re.findall(r"CS-[A-Z0-9]+-[A-Z0-9]+", open("sp08cs.txt", "r").read()):
    print(match)