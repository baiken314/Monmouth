# Bradley Aiken
# perlquiz3.pl
# perl -w perlquiz3.pl < roster2.txt

while (<STDIN>) {
	($last_name, $rest) = split /,\s+/g, $_;
	($first_name, $id) = split /\s+[A-z]*\.*\s+/g, $rest;
	@id = $id =~ /s\d+/g;
	$id = @id[0];
	$students{$id} = "$last_name, $first_name";
}

foreach (sort keys %students) { print "$_: $students{$_}\n"; }
