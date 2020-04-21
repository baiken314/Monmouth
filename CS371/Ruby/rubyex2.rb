# Bradley Aiken
# rubyex2.rb

class Fortune
    attr_accessor :content

    def word_count
        @content.scan(/\w+/).size
    end
end

cookie = Fortune.new

cookie.content = 
    "test fortune as windows does not support `fortune`" #`fortune`

puts cookie.content

puts "\nThat fortune contained #{cookie.word_count} words"