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
	print "$id, $roster{$id}\n";
}
