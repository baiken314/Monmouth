# Read command arguments
# @Bradley Aiken 
# 04/02/2020 dd/mm/yyyy

##### SUBROUTINES #####

# print help menu
sub help {
	
	$message = "
Usage: perl -w perlex.pl <option> rosterfile

	where <option> is one of the following:
	
		-help:  display help text
		-first: sort by first name
		-last:  sort by last name
		-id:    sort by id
	";

	print $message;

}

# add student to roster
# first param determines sort oder
# inputs args:
#	0-sort order, 1-first name, 2-last name, 3-id
sub add_student {
	
	# get sort order
	my $sort_by = $_[0];
	
	if ($sort_by =~ /-f/) {
		$student_to_add = "$_[1] $_[2] $_[3]"; # first last id
	}
	elsif ($sort_by =~ /-l/) {
		$student_to_add = "$_[2], $_[1] $_[3]"; # last, first id
	}
	else {
		$student_to_add = "$_[3] $_[1] $_[2]"; # id first last
	}
	
	push @roster, $student_to_add;
	
}

##### MAIN ######

# run help() if not eonugh command line args or if 1st arg contains -h:
$number_of_args = $#ARGV + 1;
if ($number_of_args < 2 || $ARGV[0] =~ /-h/) {
	help();
	exit(1);
}

# get sortby argument from first command line
my $sort_by = shift @ARGV;

# look for command line args
while ($student_line = <>) {
	($last, $first, $email) = split /\s*,\s*/, $student_line;
	chomp($email);
	$email =~ s/\@monmouth.edu//; # delete @monmouth.edu
	add_student($sort_by, $first, $last, $email);
}

# print roster
foreach my $student (sort @roster) {
	print "$student\n";
}
