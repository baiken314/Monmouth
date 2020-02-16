# Bradley Aiken
# perlex3.pl
# Take input from roster, swap first and last name, sort by first name
#  - used with roster.txt
#  - perl perlex3.pl < roster.txt

while ($student_line = <STDIN>) {

	# split line, assign to multiple variables
	($last, $first, $email) = split / *, */, $student_line; 
	
	# swap fields
	$student = "$first $last $email";
	
	# add to roster
	push @roster, $student;
	
}

# print roster array sorted by first name:
foreach $student (sort @roster) {
	print $student;
}
