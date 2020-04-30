# Defines a Student
class Student
   def initialize( first, last, id )
      @first = first
      @last  = last
      @email = id 
   end

   def show
      puts "#{@first}  #{@last}  #{@email}"
   end

   def userid
      @first[0].downcase + @last.gsub(" ", "").downcase
   end
end

student1 = Student.new "Bradley", "Aiken", "s1175816@monmouth.edu"
student2 = Student.new "Test", "O Mc Van Testen", "s1234567@testing.com"

puts student1.userid
puts student2.userid