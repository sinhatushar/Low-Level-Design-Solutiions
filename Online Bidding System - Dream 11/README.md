#Flipkart Premier League - Auction

Cricket fever is on and Flipkart is ready with their own league. FPL it is!!. To conduct the FPL, it needs to go through a fair auction process and we need your help on this. You need to build a platform for auction to take place with following requirements:
A player can register to participate in the auction with their base price. A new team can register to participate in the auction and build their squad with a fixed wallet amount. Once the auction starts for a player, teams can bid for them. Once the auction closes for that player, the highest bidder will get the player.

##Implement following commands:

**registerPlayer <player-name> <base-price>** : this command will register the player and will be available for auction

**registerTeam <team-name> <wallet-amount>** : will register the team who can participate in the auction

**auction start <player-name>** : auction starts for the players and now teams can bid for them

**bid <team> <price>** : a team bids for the player in the auction with a given price.

**auction close** : closes the auction and announce the highest bidder

**teamOverview** : displays all the players bought by the teams, wallet amount

**playerOverview** : displays status (sold/unsold/draft…), team, price etc for all the players.

**bidHistory <team|player> <team-name|player-name>** : displays all the bids placed for particular player or by the team

##Bonus:
Implement RTM(Right to match) card. If a team uses the RTM card for a sold player, the player will be finally sold to the team for the same amount for which player was earlier sold.

Conditions for RTM:

Player has to be associated with the same team in the previous auction.

Teams can use a maximum of 2 RTM.

Team has sufficient balance

Command: rtm <team> <player>

Implement constraints for the auction:

A team can have maximum of 25 players at a time

A team can have only 8 foreign players

A team can have only 3 wicket keepers

A team can have only 6 fast bowlers

Constraints:

Bid value has to be higher than current bid value
A player can be auctioned only once
Bid is accepted only when auction is started for the player
Only one auction can take place at a time
A team can bid only when they have sufficient balance in their wallet

Expectations
Code should be demo-able (very important).

Code should be functionally correct and complete.

At the end of this interview round, an interviewer will provide multiple inputs to your program for which it is expected to work
Code should be readable, modular, testable and use proper naming conventions. It should be easy to add/remove functionality without rewriting the entire codebase.
Create the sample data yourself.

You can put it into a file, test case or main driver program itself.

Code should handle edge cases properly and fail gracefully.

Add suitable exception handling, wherever applicable.

Avoid writing monolithic code.

Guidelines

Please discuss the solution with an interviewer

Input can be read from a file or STDIN or coded in a driver method.

Output can be written to a file or STDOUT.

Attempt the bonus only after everything else is working properly

Feel free to store all interim/output data in-memory.

Restrict internet usage to looking up syntax

You are free to use the language of your choice.

Save your code/project by your name and upload it to the provided link. Your program will be executed on another machine. So, explicitly specify dependencies, if any, in the readme file.

Do not use console input for test cases, everything can go through driver class.

Sample test cases:

Test-case:1

-> registerPlayer(“Virat”, 200)
-> registerPlayer(“Rohit”, 150)
-> registerPlayer(“Sachin”, 100)
-> registerPlayer(“Rahul”, 200)


-> registerTeam(“RCB”, 500)
-> registerTeam(“CSK”, 350)


-> auctionStart(“Virat”)
-> bid(“CSK”, 250)
-> bid(“RCB”, 300)
-> auctionClose()
“RCB”

-> auctionStart(“Rohit”)
-> auctionClose()
“UNSOLD”

-> auctionStart(“Sachin”)
-> bid(“RCB”, 150)
-> bid(“CSK”, 250)
-> auctionClose()
“CSK”

-> playerOverview()
“Virat”, 	“SOLD”, “RCB”, 300
“Rohit”, “UNSOLD”, NA, NA
“Sachin”, “SOLD”, “CSK”, 250
“Rahul”, “DRAFT”, NA, NA

-> auctionStart(“Rahul”)
-> bid(“RCB”, 200)
-> auctionClose()
“RCB”

-> teamOverview()
“CSK”, [“Sachin”], 100
“RCB”, [“Virat”, “Rahul”], 0

-> playerOverview()
“Virat”, 	“SOLD”, “RCB”, 300
“Rohit”, “UNSOLD”, NA, NA
“Sachin”, “SOLD”, “CSK”, 250
“Rahul”, “SOLD”, “RCB”, 200


-> bidHistory(“player”, “Virat”)
“RCB”, 300
“CSK”, 250

-> bidHistory(“team”, “RCB”)
“Virat”, 300
“Sachin”, 150
“Rahul”, 200

Test-case:2

-> registerPlayer(“Dhoni”, 200)
-> registerPlayer(“Raina”, 150)
-> registerPlayer(“Jadeja”, 100)
-> registerPlayer(“Ishan Kishan”, 200)


-> registerTeam(“RCB”, 500)
-> registerTeam(“CSK”, 550)
-> registerTeam(“LSG”, 500)
-> registerTeam(“MI”, 600)


-> auctionStart(“Ishan Kishan”)
-> bid(“RCB”, 300)
-> bid(“CSK”, 400)
-> bid(“MI”,500)
-> auctionClose()
“MI”

-> auctionStart(“Raina”)
-> auctionClose()
“UNSOLD”

-> auctionStart(“Jadeja”)
->bid(“MI”, 100)
-> bid(“RCB”, 250)
-> bid(“CSK”, 300)
-> auctionClose()
“CSK”

-> playerOverview()
“Ishan Kishan”, “SOLD”, “MI”, 500
“Raina”, “UNSOLD”, NA, NA
“Jadeja”, “SOLD”, “CSK”, 300
“Dhoni”, “DRAFT”, NA, NA

-> auctionStart(“Dhoni”)
-> bid(“CSK”, 200)
-> auctionClose()
“CSK”

-> teamOverview()
“CSK”, [“Dhoni”,”Jadeja”], 50
“RCB”, [ ], 500
“MI”, [“Ishan Kishan”], 100
“LSG”,[ ], 500

-> playerOverview()
“Jadeja”, “SOLD”, “CSK”, 300
“Raina”, “UNSOLD”, NA, NA
“Dhoni”, “SOLD”, “CSK”, 200
“Ishan Kishan”, “SOLD”, “MI”, 500


-> bidHistory(“player”, “Jadeja”)
“MI”, 100
“RCB”,250
“CSK”,300

-> bidHistory(“team”, “MI”)
“Ishan Kishan”,500
“Jadeja”,100



