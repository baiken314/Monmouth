# prob3.pl, print all words with uppercase letter in the middle of the word
while ($word = <STDIN>) {
	
	# regex for uppercase letters surrounded by other characters
	chomp($word);
	if ($word =~ /.+[A-Z].+/) {
		print $word, "\n";
	}
	
}
