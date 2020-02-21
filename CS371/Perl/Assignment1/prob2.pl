# prob2.pl, do perlex1.pl with a hash
# take input from file
while ($word = <STDIN>) {
	
	chomp($word);
	
	my $word_length = length($word);
	
	# make hash with $word as the key and length($word) as the value
	if (not exists $word_lengths{$word_length}) {
		$word_lengths{$word_length} = 1;
	}
	else {
		$word_lengths{$word_length} += 1;
	}
	
}

print "Length\t\tOccurrences\n";
$word_length = 0;

foreach $key (sort keys %word_lengths) {
	
	$word_length += 1;
	# make all not existent key values equal 0
	if (not exists $word_lengths{$word_length}) {
		$word_lengths{$word_length} = 0;
	}
	print $word_length, "\t\t", $word_lengths{$word_length}, "\n";
	
}
