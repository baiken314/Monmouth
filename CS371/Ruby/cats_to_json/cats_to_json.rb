html = File.new("cats.html").read

puts html.scan /title=".*?">\w+?<\/a>/