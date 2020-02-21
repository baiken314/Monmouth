use warnings;

my %hash;

my $course = "anthro";
my $room = "room";
my $time = "time";

$hash{"$course"."room"} = "E 220A";
$hash{"$course$time"} = "10AM";

print $hash{"$course"."room"};
