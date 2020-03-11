# Bradley Aiken
# roster_fields.py
# used with cs176roster.webadvisor.txt

old_roster = open("cs176roster.webadvisor.txt", "r")
new_roster = open("roster.txt", "w")

# 0: name, 1: id, 2: email, 3: major, 4: year, 5: adviser, 6: credits
count = 0
for line in old_roster.readlines():
    line = line.rstrip()
    if count == 0:  # name
        print(line, end='', file=new_roster)
    elif count == 1:  # id
        print(',', line, end='', file=new_roster)
    elif count == 3:  # major
        print(',', line, end='', file=new_roster)
    elif count == 4:  # year
        print(',', line, end='', file=new_roster)
    elif count == 5:  # adviser
        print(',', line, file=new_roster)
    count += 1
    count %= 8
