# interact with webadviser

use WWW::Mechanize;

$url = "https://www2.monmouth.edu/muwebadv/wa3/search/SearchClassesV2.aspx";
$mech = WWW::Mechanize->new();
$mech->get($url);

# select term
$term = "20/SP - 2020 Spring";
$mech->field("_ctl0:MainContent:ddlTerm", $term); # populates field

# click the Submit button
$mech->click_button(name => "_ctl0:MainContent:btnSubmit"); # takes a hash param

# get html result
$page = $mech->content();

print $page;
