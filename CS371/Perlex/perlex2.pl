# Bradley Aiken
# perlex2.pl
# Returns a list of words that are between 1 and 7 characters long
# Output can be directed to a file in the command line
#  - used with english.sorted
#  - perl perlex2.pl < english.sorted > short.words

while ($word = <STDIN>) {
	
	chomp($word);
	
	# if current word is between 1 and 7 characters
	if (length($word) <= 7) {
		print "$word", "\n";
	}
	
}
