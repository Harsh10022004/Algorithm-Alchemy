
# README- KAKURO SOLVER

# About
Developed a full-fledged Kakuro puzzle solver in VS Code for custom board inputs. It is regarded as one of the most notoriously difficult logic puzzles ever created. With roots in Japan and a history of being labeled the “mathematical crossword,” Kakuro is known for its intense complexity and depth. 
Kakuro is notorious for its computational hardness, demanding that each puzzle satisfies complex sum and uniqueness constraints across intersecting rows and columns. Developed entirely in VS Code, the system takes a custom board input and outputs the solved puzzle using advanced backtracking, selective state evaporation and intelligent flow management elevating the problem to an advanced level of computational challenge. It was an intellectually stimulating and deeply challenging experience that significantly amplified my passion, curiosity, and proficiency in problem solving and data structures & algorithms.


# Sample Board:

Suppose this is our kakuro board:





## Screenshots

(https://www.researchgate.net/profile/Wiktor-Daniec/publication/344417396/figure/fig1/AS:941152291266561@1601399600326/Sample-kakuro-problem-of-size-5x5-with-its-unique-solution.ppm)

please open this link in another tab to see the board.

Puzzle and its corresponding solution is given here

# Input And Output Format: 

For this, the input which will be given to our board is:

First we need to specify the size of our board:

Than we need to input corresponding elements

Input for this board will be:

5

0 0  0 11  0 9  0 0  0 0

4 0  -5000 -5000  -5000 -5000  0 17  0 0

11 0  -5000 -5000  -5000 -5000  -5000 -5000  0 9

0 0  23 0  -5000 -5000  -5000 -5000  -5000 -5000

0 0  0 0  8 0  -5000 -5000 -5000 -5000

Output for this board will be:

true

0 0  0 11  0 9  0 0  0 0

4 0  -3 -5000  -1 -5000  0 17  0 0

11 0  -8 -5000  -2 -5000  -1 -5000  0 9

0 0  23 0  -6 -5000  -9 -5000  -8 -5000

0 0  0 0  8 0  -7 -5000  -1 -5000

ALL numbers with negative signs and which are not equal to -5000 are the filled spaces which were empty in input. Please ignore the '-' sign for these numbers as it was just for flagging purpous.

Congrats! the puzzle is solved now.

Similar conventions can be followed to give input for new kakuro board puzzle and we will get our corresponding output.






