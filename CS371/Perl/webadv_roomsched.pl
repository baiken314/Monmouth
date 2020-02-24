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
Usage: perl -w webadv_roomsched.pl <term> <room number>
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

my $current_course; # keeps index on current course in the foreach
my $found_course = 0;

print "Schedule for $room:\n";

# regex check each <td> line and collect information on every course
foreach my $td (@tds) {
	
	# course name
	if ($td =~ /[A-Z]+-[0-9]+[A-Z]?-[A-Z0-9]+/) {
		my @course_array = $td =~ /[A-Z]+-[0-9]+[A-Z]?-[A-Z0-9]+/g;
		$current_course =  $course_array[0];
	}
	
	# get schedule and room, print course output
	if ($td =~ /[MTWHF]+\s+[0-9]+:[0-9]+[AMP]+/ and $current_course) {
		# split classes with extra sections
		foreach my $br (split /<br>/, $td) {
			# get room number, type, and days of week
			(my $current_room, my $current_days) = 
				$br =~ /[A-Z]+\s+[A-Z0-9]+\s+/g;
			# get course time
			(my $current_schedule) = 
				$br =~ /[0-9]+:[0-9]+[APM]+\s+[0-9]+:[0-9]+[APM]+/g;
			$current_room =~ s/\s+/ /g; # remove extra spaces
			# print course information if in $room
			if ($current_room =~ $room) {
				print "$current_course\t$current_days$current_schedule\n";
				$found_course = 1; # set that a course has been found
			}
		}
		# reset $current_course, do not check more $td s
		$current_course = 0;
	}
	
}

# print if no course found
if (not $found_course) { print "No courses were found for $room.\n"; }
