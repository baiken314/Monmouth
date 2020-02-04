while ($word = <STDIN>) {

	if ($word =~ /[B-DFGHJ-NP-TV-Z]/) {
		print($word);
	}

}
