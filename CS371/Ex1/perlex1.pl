# Bradley Aiken

# read lines
while ($word = <STDIN>) {
	
	# get length of each word
	chomp($word); # remove trailing \n
	$length = length($word);
	
	# increment corect world length array element
	$word_lengths[$length] += 1;
	
}

# print result
print "Word lengths\t\tOccurances\n\n";

for (my $i = 1; $i <= $#word_lengths; $i++) {
	if (not exists $word_lengths[$i]) {
		print $i, "\t\t\t", 0, "\n";
	}
	else {
		print $i, "\t\t\t", $word_lengths[$i], "\n";
	}
}
