As an Entry Level developer, this is a Coding Challenge that was issued to me after an Interview I participated in 
on March 3, 2022. 

Without going into too much detail:
* Provide a Summary of what I was supposed to do.
* The Tech Stack used.
* Program Breakdown:
  * Branch One: Master (Stable)
  * Branch Two: Frontend Start (Unstable)
* What was accomplished & failed.
* Where I am at a two-week sprint later...
  * Conclusion

**Summary:**

The challenge is to utilize any Technology to develop a backend API method call, a simple form page that handles 
User input, and display the results. Some requirements within the Document were left up to interpretation to test the 
ability of the developer in making correct assumptions. The API has to conform to the REST architecture, be encoded in
JSON, be authorised in JWT tokens and include two required HTTP headers.

Will be judged on Three things
* Correct use of coding standards & practices
* Overall implementation of the solution.
* Ability to understand the requirements.


**Tech Stack & Dependencies**
* Spring Boot 2.6.4
* Java 17
* Gradle
* JUnit 5
* H2
* io.jsonwebtoken jjwt 0.9.1
* jakarta.xml.bind-api 2.3.2
* jetbrains:annotations: 23.0.0
* spring-boot-devtools
* spring-boot-starter-data-jpa
* spring-boot-starter-hateoas
* spring-boot-starter-security
* spring-boot-starter-test
* spring-boot-starter-thymeleaf
* spring-boot-starter-validation
* spring-boot-starter-web
* spring-security-test


**Program Breakdown**

I have two branches created: Master and Frontend Start. Here, I will break down both the classes and unit tests that
were created and to save space will organize them unconventionally instead of breaking them down via Java & Test with 
all their sub folders.

**Branch One: Master (Stable)**
* Controller
  * Person Controller Test
    * Used Mockito Annotations
    * First Test, *Should Get Person By ID* 
      * Chose to utilize String.valueOf since it returns a string representation of the Object argument that would either equal null or return a value object toString().
    * Second Test, *Should Get All Persons*
      * Figured out writing the test a certain way would present a Build Failure which I found odd so when flipped it passed.
    * Third Test, *Should Return Cannot Find Exception For Person ID*
      * Came across where an import would not import to the top of the file with the rest of the imports but would instead do 'Class.CannotFindException'.
    * **Note:** There are more detailed notes within the Test file as well as notes where I go over a Quotation Model where I thought about creating a Quotation Class along with the Person Class.
  * Person Controller
    * Auto Wired Person Repository.
    * Mappings:
      * Post Mapping ("/persons") for *Create Person*
      * Get Mapping ("/persons") for *Get All Persons*
      * Get Mapping ("/persons/{id}") for *Get Person By ID*
      * Put Mapping ("/persons/{id}") for *Update Person*
      * @Delete Mapping ("/persons/{id}") for *Delete Person*
      * @Delete Mapping ("/persons") for *Delete All Persons*
      * Custom *Cannot Find Exception*
    * **Note:** Detailed notes within the file about what I would be doing if I added a Quotation Class.
  * Person MVC Test
    * Used Mockito Annotations to mock the Person Controller to test for Mock MVC Result Handlers.


* Data
  * Person Repository
    * Extends the Jpa Repository
    * Lists the Person Class to *Find Person By Name*
    
* Model
  * Person Test
    * Unit Tests
      * Instantiated Person Class
      * Started out the constructor
      * Slowly added the Getters/Setters
  * Person
    * This was new for me but..
      * Used Annotations to 
        * Create a Table for the Database.
        * Create Columns for each variable.
    * Explained why a Default Constructor was added.
    * Explained the importance of toString.
    * Explained how to return a hash code for Long ID.
    * Explained how comparing objects to specified objects to return true for if objects are the same and false if otherwise.
    

* Data 
  * Travel Agency MV Database
    * This is a file database that was created through Applications Properties via *Spring Datasource URL*. 
    

* SRC
  * Application Properties
    * Enable H2 Console
    * Listed H2 Drivers
    * Have a commented out memory test database for testing purposes
    * Points to the file that gets created that in turns becomes the database on file.
    * Database Username
    * Database Password
    * Lists the H2 Dialect
    * DDL Auto allows for the creation, updating, dropping, and testing of databases
    * Commented out default url path to access the H2 Console
    * Shortcut path to H2 Console
  * Jpa Mapping Test
    * This is where I test any relationships for the Jpa Database
    

**Branch Two: Frontend Start (Unstable)**

This branch ended up being a bit tricky. I made commits after certain *milestones* rather then as often as one should when building out a program and 
this was because I knew lots and lots of my time would be engulfed in research, as well as plugging in data, wondering why it was broken, researching 
more and more just to realize I may have messed up my initial backend development. First, I started by adding these files to the new branch that lead 
to templates being created, and data being inserted and then shown. However, with Thymeleaf, it just was not connecting to the database 
where I had dummy info waiting.

Those files are:
* Person Controller
* Person REST Controller
* Persons HTML Template
* Quotations HTML Template

Eventually, I placed that on hold and tried to tackle a User Login in hopes that whatever I learned researching that would assist my thoughts with 
trying to figure out how to more efficiently utilize Thymeleaf, as well as better re-work my backend data if needed to which I already knew I would 
need to since variable fixed_rate, age_load, and total would technically need to be reworked on the backend if I was unable to figure out how to 
calculate correctly on the frontend. This would lead to the additions and expansion of packages to my program, as well as many, many files to be 
added and once it was all wired up. I somehow came face to face with an unknown Enemy. Unauthorized Access to the H2 Console,
as well as unable to load any of the Templates. Never faced this issue before. After hours researching I came to similar issues that 
were closely related but not enough to where it helped me, and then I did and ... Nothing. 


**Accomplishment & Failures**
* Accomplishments
  * Successfully Learned how to add the H2 Console correctly to where I could use either the Memory Test Database or have the program Create a File Database.
  * Learning to correctly set up the H2 Console allowed me to also see how PostgreSql and MySQL were also setup. 
    * Stuck with H2 since this was mainly for testing purposes.
  * Discovered and learned how to use Postman for JSON.
  * Learned more ways to Unit Test Response Handlers.

* Failures
  * Not to use Latest & Greatest versions of tech stack while using tutorials as guides.
    * Could run into depreciation's and be forced to research even longer.
  * Failed to complete the API in a Two-Week Sprint.
  * Lack of knowledge & experience towards APIs.
  * Unable to correctly set up a backend or frontend to meet the goals of the Coding Challenge.

    

**Two-Week Sprint Later & Conclusion**

Although I was unable to complete the Coding Challenge provided to me. I am not leaving this Challenge weaker than what I was but stronger in the sense of I 
gained more knowledge researching and writing out this project then before I had started Two Weeks ago. 
Two Weeks ago, 
* I didn't know how to successfully add a Database to Java Spring, let alone creating a physical file to store the database.
  * This also allowed me to learn how to set up and link PostgreSQL & MySQL
* I didn't understand much about REST Controllers when it came to using Response Handlers, let alone actually knowing how to test them differently.
* I didn't truly understand the different between @Resource & @AutoWired annotations. Honestly, thought I @AutoWired could only be used a limited amount of times not replace @Resource.
* I didn't know you don't need to add @Repository to your Interface when you use the extension JpaRepository<Object, Long>.
* I gained a better understanding of Thymeleaf.
* I learned how to turn my Class File into a Table itself referencing @Table(name = "table_name"), as well as variables into Columns using @Column.
* Learned that when it comes to setting up a secured User Login it takes quite a bit more files than originally thought.
* Gained a better understanding of Spring Security but still lack the knowledge & experience but can improve.
* Learned about adding table field to an ENUM file and then directly linking it to the Class File.
* Learned where to set up JWT properties within the Applications Properties.
* Learned how to set up a Web Security Configuration file but still lack the knowledge & experience but can improve.

All in all, just from all the above listed, I came into this Challenge not knowing much about secured APIs, 
but I am coming out of this project more knowledgeable than before. 