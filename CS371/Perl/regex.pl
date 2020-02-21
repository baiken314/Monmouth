my $name = "Joseph";

$name =~ s/[sph]//; # deletes first instance of s, p, or h

print $name, "\n";

$name =~ s/[sph]//g; # global instances

print $name, "\n";
