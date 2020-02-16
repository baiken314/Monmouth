	use warnings;

use WWW::Mechanize;

$url = "https://www2.monmouth.edu/muwebadv/wa3/search/SearchClassesV2.aspx";
$mech = WWW::Mechanize->new();
$mech->get($url);

$term = "20/SP - 2020 Spring";
$room = "BH 223";

$mech->field("_ctl0:MainContent:ddlTerm", $term);
$mech->click_button(name => "_ctl0:MainContent:btnSubmit");

$page = $mech->content();
@lines = split /\n/, $page;

foreach $line (@lines) {
	#if ($line =~ /BH *223/) {
		#$line =~ s/(?![A-Z]+-[0-9]+-[0-9]+)//g;
		print $line;
	#}
}
