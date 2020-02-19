# Bradley Aiken
# perlquiz1.pl
# perl -w perlquiz1.pl < english.sorted

while (<STDIN>) {
	if ($_ =~ /^[A-Z]+$/) { print $_; }
}
