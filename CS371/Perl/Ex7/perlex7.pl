# Bradley Aiken
# perlex7.pl
# Parse a webpage
# Put headlines and anchor names into arrays
# Print information from arrays
#  - used with news.html

# news.html is the locally downloaded HTML file
open FILE, "<news.html";
$news = do { local $/; <FILE> };

# get all headlines between strong tags
# use (.+) to exclude tags in headlines
@headlines = $news =~ /<strong>(.+)<\/strong>/g;

foreach my $headline (@headlines) {
	print "$headline\n";
}

print "Amount of headlines: ", $#headlines + 1, "\n";

# read all anchor names into @anchor_names
@anchor_names = $news =~ /<a class="anchorMargin" name="(.+)"><\/a>/g;

foreach my $anchor_name (@anchor_names) {
	print $anchor_name, "\n";
}
