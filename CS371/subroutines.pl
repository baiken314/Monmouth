greet("Jim", "Bob", "Ross");

sub greet {
	
	for ($i = 0; $i < 3; $i++) {
		print("Hello ", @_[$i], ", you are $i!\n");
	}
	
}
