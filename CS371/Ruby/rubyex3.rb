 # Bradley Aiken
 # rubyex3.rb

class Student
    def initialize first, last, email
        @first = first
        @last = last
        @email = email
    end

    def show
        puts "#{@first} #{@last} #{@email}"
    end
end

class Roster
    def initialize
        @students = []
    end

    def add_student student
        @students << student
    end

    def show
        @students.each do |student|
            student.show
        end
    end
end

cs371_roster = Roster.new

for each in $stdin.readlines do
    last, first, email = each.split /\s*,\s*/
    student = Student.new first, last, email
    cs371_roster.add_student student
end

cs371_roster.show