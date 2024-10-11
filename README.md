Fancode Assignment - All the users of City "Fancode" should have more than half of their todos task completed.

Tools Used-
  1. JDK
  2. IDE (IntelliJ)
  3. Maven Build Tool
     
1. Clone the repository
   
    git clone https://github.com/akshat2812/FancodeAssignment.git
   
2.Run the project in the IDE with Maven to resolve dependencies

Project Setup:
1. src/main/java contains all the helper files and reusable methods.
     a. api contains the baseuri and helper functions to call the api and perform necessary task onto it.
     b. constants has the given required range for user lat-long.
     c. pojo has the required response pojo for the apis required to assess them.
     d. utils has the rest client connections and the test report helper functions.

2. test/java/assignment contains the test cases file that cover all the test cases and the required task.

Dependencies:
  Pom.xml contains all the dependencies and version control of the project.

TestReport:
  A comprehensive test report is generated that covers all the test cases execution and shows the results of them.
  It is generated everytime the entire test cases are executed.
  It is named : target/extent-reports/extent.html






     
