# Bradley Aiken
# rubyex1.rb

file = File.new "monmouth_news.html", "r"
html = file.read

title_re = %r|aria-label="Article (.+?)">|
titles = html.scan title_re

link_re = %r|<a href=\'(.+?)\' title="|
links = html.scan link_re

puts titles

puts links