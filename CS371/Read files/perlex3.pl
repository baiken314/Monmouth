# perlex3 read and process

while ($student_line = <STDIN>) {

	# split line
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
