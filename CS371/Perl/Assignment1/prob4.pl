# prob4.pl, push all words that start with an uppercase consonant into an array and print from the array
while ($word = <STDIN>) {

	# regex for only uppercase consonants
	if ($word =~ /\A[^a-zAEIOU]/) {
		# insert into array
		push @uppercase, $word;
	}

}

# print all words
foreach $word (@uppercase) {
	print $word;
}
