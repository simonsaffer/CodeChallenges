/**
  * A top-secret algorithmic research facility has decided to up its security by hiring guards to keep watch over the premises.
  * After all, they don't want anyone sneaking in and learning the answers to questions such as "does P = NP?" and "what are
  * the solutions to the 2016 Facebook Hacker Cup problems?".

When viewed from above, the facility can be modeled as a grid G with 2 rows and N columns. The jth cell in the ith row is
either empty (represented by Gi,j = ".") or occupied by a building (Gi,j = "X"), and the grid includes at least one empty cell.

Guards may be potentially stationed in any of the empty cells. A guard can see not only their own cell, but also all contiguous
empty cells in each of the 4 compass directions (up, down, left, and right) until the edge of the grid or a building. For
example, in the grid below, the guard ("G") can see every cell marked with an asterisk ("*"):

.*.X.X..
  *G*****X
What is the minimum number of guards required such that every empty cell in the grid can be seen by at least one of them?

Input
Input begins with an integer T, the number of facilities that need guarding. For each facility, there is first a line
containing the integer N. The next line contains the grid cells G1,1 to G1,N in order. The third line contains the grid cells
G2,1 to G2,N in order.

Output
For the ith facility, print a line containing "Case #i: " followed by the number of guards required to guard the facility.

Constraints
1 ≤ T ≤ 200
1 ≤ N ≤ 1,000
Explanation of Sample
In the first case, one solution is to place three guards as follows:

.G.X.XG.
....G..X
Example input · DownloadExample output · Download
5
8
...X.X..
.......X
5
.X.X.
.XXX.
7
.....X.
.X.....
9
..X.X.X..
..X...X.X
15
.X..........X..
.X...XX.X.X....


Case #1: 3
Case #2: 3
Case #3: 2
Case #4: 5
Case #5: 6
  */
class HighSecurity {

}
