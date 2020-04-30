# This class stores information about people.
class Person
    attr_accessor :name, :age, :spirit_animal

    def initialize( name )
        @name = name
    end

    def get_all_str
        # return all Person attributes as a string
        "name: #{@name}, age: #{@age}, spirit_animal: #{@spirit_animal}"
    end

    def get_all_hash
        # return all Person attributes as a hash
        {
            name: name,
            age: age,
            spirit_animal: spirit_animal
        }
    end
end

person = Person.new "Jules"
person.age = 45
person.spirit_animal = "Pangolin"

puts person.get_all_str
puts person.get_all_hash

first = "James"
last = "Brown"

f = first.scan /^./
puts "f: #{f}"

la = last.scan /^../
puts "la: #{la}"

userid = f[0].downcase! + la[0].downcase
puts "userid: #{userid}"
puts "f: #{f}"
puts "la: #{la}"

puts f.class