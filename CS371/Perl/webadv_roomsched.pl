# Bradley Aiken
# Noah Rottler-Gurley
# Brandon Henry
# 
# webadv_roomsched.pl
# 
# Compiles schedule for all courses in a given term and room by using
# the Monmouth Webadviser webpage.
#
# perl -w webadv_roomsched.pl <term> <room number>

use strict;
use warnings;
use WWW::Mechanize;

# show help if args incorrect or if requested, exit
my $number_of_args = $#ARGV + 1;
if (not $number_of_args == 2 or $ARGV[0] =~ /-h/) {
	print "
Usage: perl -w <term> <room number>
	where <term> is a quoted string
	where <room number> is a quoted string
	";
	exit 1;
}

# assign arguments
my $term = $ARGV[0];
my $room = $ARGV[1];

# get webpage
my $url = 
"https://www2.monmouth.edu/muwebadv/wa3/search/SearchClassesV2.aspx";
my $mech = WWW::Mechanize->new();
$mech->get($url);

# exit if term does not exist
my $search_page = $mech->content(); # HTML of search screen
if (index($search_page, $term) == -1) {
	print "Term $term does not exist.\n";
	exit 1;
}

# get to class information section
$mech->field("_ctl0:MainContent:ddlTerm", $term);
$mech->click_button(name => "_ctl0:MainContent:btnSubmit");

my $page = $mech->content(); # HTML of course screen
$page =~ s/\R//g; # remove all newline characters

# course information is stored in groups of <td> elements
# gets all table column elements in the page
my @tds = split /<td>/, $page;

my %course_hash; # stores all information on courses

my $current_course;

# regex check each <td> line and collect information on every course
foreach my $td (@tds) {
	
	# course name
	if ($td =~ /[A-Z]+-[A-Z0-9]+-[A-Z0-9]+/) {
		my @course_array = $td =~ /[A-Z]+-[A-Z0-9]+-[A-Z0-9]+/g;
		$current_course = $course_array[0];
	}
	
	# get schedule and room
	if ($current_course) {
		# split 
		foreach $br (split /<br>/ $td) {
			
		}
		$current_couse = 0;
	}
	
}
