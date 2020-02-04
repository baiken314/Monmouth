while ($word = <STDIN>) {
	
	chomp($word);
	$length = length($word);
	
	# if current word is between 1 and 7 characters
	if ($word =~ /^.+[A-Z]+.+$/) {
		print "$word", "\n";
	}
	
}
