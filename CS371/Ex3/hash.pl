# hash.pl hashes

my $who = "Ian";

my %where = (
	Gary => "Dallas",
	Lucy => "Austin",
	Ian => "Mahwah",
	Samantha => "Hoboken"
);

print "Gary lives in ", $where{Gary}, "\n";
print "$who lives in $where{$who}\n";

$where{Eva} = "Howell";

delete $where{Gary};

foreach $who (sort(keys %where)) {
	print "$who lives in $where{$who}\n";
}

foreach $town (values %where) {
	print "Someone lives in $town\n";
}

my ($name, $town);
while (($name, $town) = each %where) {
	print "$name lives in $town\n";
}
