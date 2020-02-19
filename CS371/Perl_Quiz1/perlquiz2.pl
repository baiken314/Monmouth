# Bradley Aiken
# perlquiz2.pl
# perl -w perlquiz2.pl < roster.txt

while (<STDIN>) {
	($last_name) = split /\s*,\s*/g, $_;
	if ($last_name =~ /.*(is|i|o)\b/) { print "$last_name\n"; }
}
