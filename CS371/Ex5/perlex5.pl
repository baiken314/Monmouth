# Read command arguments
# @Bradley Aiken 
# 04/02/2020 dd/mm/yyyy

sub help {
	
	$message = "

Usage: perl -w perlex.pl <option> rosterfile

	where <option> is one of the following:
	
		-help:  display help text
		-first: sort by first name
		-last:  sort by last name
		-id:    sort by id

	";

	print $message;

}

help();
