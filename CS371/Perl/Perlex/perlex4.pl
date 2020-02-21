# Bradley Aiken
# perlex4.pl
# Read roster file, assign students into a hash
#  key:   student id
#  value: name
#  - used with roster.txt
#  - perl perlex4.pl < roster.txt

while ($studentLine = <STDIN>) {
	
	# split delimiter
	($last, $first, $email) = split /, /, $studentLine;
	
	# swap first and last name
	$student = "$first $last $email";
	
	# insert student into %roster hash with $id as key
	# get $id from $email first
	($id, $domain) = split /@/, $email;
	$roster{$id} = "$last, $first";
	
}

# print roster hash
foreach $id (sort keys %roster) {
	print "$id: $roster{$id}\n";
}
