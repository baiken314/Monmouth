while ($word = <STDIN>) {
	
	if ($word =~ /.+[A-Z].+/) {
		print($word);
	}
	
}
