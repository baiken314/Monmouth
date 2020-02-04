while ($word = <STDIN>) {
	
	if (length($word) <= 7) {
		
		chomp($word);
		
		# make hash with $word as the key and length($word) as the value
		if (not exists $word_lengths{$word}) {
			$word_lengths{$word} = length($word);
			print($word_lengths{$word}, "\n");
		}
		
	}
	
}
