# Bradley Aiken
# docxview.rb
#
# use:
# ruby docxview.rb <filename>
# where <filename> is the .docx file
#
# ruby docxview.rb -outfile <output_filename> <filename>
# where <output_filename> is the .txt file to output to
# where <filename> is the .docx file

require "zip"

class Docx
    attr_accessor :content
end

docx = Docx.new

puts docx.content = Zip::File.open(ARGV.pop)  # open file
    .read("word/document.xml")  # file name is last arg
    .scan(/<w:p.*?>.*?<\/w:p>/)  # break paragraphs
    .join("\n")  # add newlines
    .gsub(/(<wp.*?<\/wp.*?>|<.*?>)/, "")  # remove all xml
    .gsub("&lt;", "<")  # replace special characters
    .gsub("&gt;", ">")

if output_filename = ARGV.pop  # write content to file if output file name exists
    File.write output_filename, docx.content
end