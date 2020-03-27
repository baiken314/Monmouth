# Bradley Aiken
# pyex2.py
# remove newline character from stdin

import sys
for line in sys.stdin:
	print(line.rstrip())
