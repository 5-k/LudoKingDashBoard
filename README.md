# LudoKingDashBoard
This is a leader Board dashboard for Ludo. Daily Games, Matches and Results

 This Project is build on Java Spring Boot Framework on backend, and Angular JS and HTML on frontend. Database is Cloud AWS/ PCF.
 Hosted on PCF https://ludochampionship.cfapps.io/#!/ludoking
 
 Description:
 
    Simple Basic Angular JS and Java Application to display a leaderboard, upcomming matches and previous matches, user Profile. These operations are read only on UI (on purpose) and can be edited by Restful API Calls via Postman or Curl.
    These CRUD Operations can be integrated with UI to create and update score with UI in future as well.
  
  How to Build the App
    Requirements:
      Maven, Java , Spring Framework, Node js, Angular JS, npm, mysql (middleware DB)
    
    Build:
      mvn clean install
      npm install -g 
    
    Run: 
      mvn spring-boot:run
   
    Host on Pivitol Cloud Foundry (PCF): cf push ludochampionship -p .\SpringMVC-0.0.1-SNAPSHOT.jar

  Usage of API:
  
  1. Creating a new Match
     
         API: {{url}}/api/leaderBoard
         Type: POST
         Body:
          {
	          "user1":"Prateek",
	          "user2":"Aditya",
	          "user3":"Shubham",
	          "user4":"Nishant",
	          "matchDate":"2020-04-27 22:00:00"
          }
          
   2. Deleteing a existing Match
     
           API: {{url}}/api/Schedule/{{matchId}
           Type: DELETE
           Description: MatchId you can get from LeaderBoard
      
   3. Update Match Score
     
          API: {{url}}/api/createResult
          Type: POST
          Body:
            {
	              "winner": "Prateek",
                "firstrunnerunnerup": "Aditya",
                "secondrunnerup": "Shubham",
                 "lost": "Nishant",
	               "matchId":10
             }
             
   4. Deleteing a existing Result
     
           API: {{url}}/api/Result/{{matchId}
           Type: DELETE
           Description: MatchId you can get from LeaderBoard
      
   5. Upcomming Matches:
    
          API: {{url}}/api/upcommingMatches 
          Type: GET
          
   6. Previous Matches:
    
          API: {{url}}/api/previousMatches 
          Type: GET
          
   7. Get Leaderboard:
    
          API: {{url}}/api/leaderBoard 
          Type: GET
          

 @ApacheOpenSource License: 
