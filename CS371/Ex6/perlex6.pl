open FILE, "<roster.txt";
$roster = do { local $/; <FILE> };

@ids = $roster =~ /s[0-9]+/g;

print "@ids\n";
