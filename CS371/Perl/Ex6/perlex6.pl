# Bradley Aiken
# perlex6.pl
# Read file into variable and read all ids into @id array
#  - used with roster.txt
#  - perl perlex6.pl

# open file in directory, < used as in command line
open FILE, "<roster.txt";
$roster = do { local $/; <FILE> }; # put file into variable

# extract all student ids
@ids = $roster =~ /s[0-9]+/g;

# print array as list
print "@ids";
