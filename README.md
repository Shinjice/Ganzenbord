Coding a typical dutch board game named "Ganzenbord" in Java.

VERSION1:

-dice: (g)
-dice trow is: Random random = new Random(); int a = random.nextInt(6);
-After dice is trown, display info as: 
*youve trown 4, you hit spot 4, no sweat!, trow again(g)
*youve trown 6, you hit spot 10, Bonus jump!, you hit spot 16, trow again(g).
*youve trown 3, you are now at spot 19, no sweat!, trow again(g).
*etc, you get the idea :D
-Extra rules
-Spot 23, jail, game over!
-Spot 63, finish, you won the game! (64, 65, 66, 67 is also considered a win)
-Spot 25 and 45, restart game
-Spot 10,20,30,40,50,60, bonus jump, repeat last hit pips for free.


VERSION2:

-Multiplayer
-When passed finishing spot "63", go backwards with remaining pips. 
(so when ur on spot 62, and you trow 3 pips, you'll end at spot 61! Next player is up. Game finished if you trow the exact pips to spot 63.

VERSION3:

-Extra rules
-Spot 6, bridge, go to 12
-Spot 19, holidayinn, skip a turn
-Spot 31, pockmark, stay here till other player takes over the spot. Player who was allready on this spot may continue.
-Spot 42, maze, back to spot 39
-Spot 52, jail, skip 3 turns
-Spot 58, death, restart game
-Spot 63, finish, first to finish wins the game

***This is a learning process for me so dont mind the comments, enjoy!***