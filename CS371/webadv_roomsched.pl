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

##### SUBROUTINES #####

sub help {
	my $message = "
Usage: perl -w <term> <room number>

	where <term> is a quoted string
	where <room number> is a quoted string
	";
	print $message;
}

##### MAIN #####

# show help if args incorrect or if requested, exit
my $number_of_args = $#ARGV + 1;
if (not $number_of_args == 2 or $ARGV[0] =~ /-h/) {
	help;
	exit 1;
}

# assign arguments
my $term = $ARGV[0];
my $room = $ARGV[1];

# get webpage
my $url = "https://www2.monmouth.edu/muwebadv/wa3/search/SearchClassesV2.aspx";
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

# stores information on all courses
# key->course name, value->course information
my %course_hash;

# 0 is default value, until changed to add to course_hash
my $current_course = 0;
my $current_schedule = 0;
my $current_room = 0;

# regex check each <td> line
# only performs action if course information is present
foreach my $td (@tds) {
	
	# get schedule
	if ($td =~ /[0-9]+:[0-9]+[A-Z]+/) {
		my @schedule = $td =~ 
			/[A-Z ]+ +[0-9]+:[0-9]+[A-Z]+ +[0-9]+:[0-9]+[A-Z]+/g;
		$current_schedule = join "\n\t\t\t\t\t", @schedule;
	}
	
	# print course name
	if ($td =~ /[A-Z]+-[A-Z0-9]+-[A-Z0-9]+/) {
		my @course_name = $td =~ /[A-Z]+-[A-Z0-9]+-[A-Z0-9]+/g;
		$current_course = join "", @course_name;
	}
	
	# get room number
	if ($td =~ /[A-Z]+ +[0-9]+[A-Z]*/) {
		my @room = $td =~ /[A-Z]+ +[0-9]+[A-Z]*/g;
		$current_room = $room[0];
		$current_room =~ s/\s+/ /g;
	}
	
	# combine room number and schedule into one information variable
	# add this to course_hash
	# courses that do not have a course number are not added
	if ($current_course and $current_schedule and $current_room) {
		# add to hash	
		my $course_information = join ":\t\t\t", ($current_room,
			$current_schedule);
		$course_hash{$current_course} = $course_information;
		# reset values
		($current_course, $current_schedule, $current_room) = 
			(0, 0, 0);
	}
	
}

my @courses; # array for all classes in same room

# search for all classes in a room, push to courses
foreach my $key (sort keys %course_hash) {
	if ($course_hash{$key} =~ $room) {
		push @courses, $key;
	}
}

# format and print output of the schedule
print "Schedule for $room:\n";
if ($#courses + 1 > 0) { # if course found
	foreach my $course (@courses) {
		# get array of course hash information
		# [0] room number
		# [1] schedule
		my @course_hash_information = split /:\t\t\t/, 
			$course_hash{$course};
		# make new schedule string
		my @course_hash_schedule = split /\n\t\t\t\t\t/, 
			$course_hash_information[1];
		my $course_hash_schedule_string = join "\n\t\t",
			@course_hash_schedule;
		# display schedule information
		print "$course\t$course_hash_schedule_string\n";
	}
}
else {
	print "No results were found for this room.\n";
}
