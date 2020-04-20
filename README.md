## Classic N Queens Solver

#### Description:

The application NQueensSolver solves the Classic N Queens problem which involves finding the different ways (if they exist) for placing N Queens on an NxN chess board.

The application takes one argument, a natural number N and prints a list of solutions, according to the following rules:

* By definition, queens attack along straight and diagonal lines,

* No three points in the solution are collinear with collinear meaning that the points lie on a straight line. The NQueensSolver class can be instantiated with this option off.


#### Requirements:

* Java 8
* Gradle 6.0 version or later.

#### How to run:

In the top-level repository directory, run

    ./gradlew run --args=BOARD_SIZE

where BOARD_SIZE is a natural number. For example for placing 4-queens on a 4x4 board,

  For Linux/Mac type:
  
  	./gradlew run --args=4

  For Windows type:
  
  	gradlew run --args=4


The program once run will produce the following:

    1 3 0 2
    2 0 3 1 
    
Each number represents the row on which a queen is placed in that respective column. Another way to represent the board with Qs representing the queens and .s are empty squares is as follows:

    1 3 0 2
    
    . . Q .
    Q . . .
    . . . Q
    . Q . .


#### Approach taken:

I spent a day researching how the problem has been solved by different experts in the field. I also had a go on trying to find a novel way myself by looking at the different solutions for different N, however although the solutions for odd and even values of N seem to be more related than sequential values of N, the solution does not seem to be trivial. 

Due to time limitations I followed the backtracking recursive solution similar to the one mentioned in <https://www.geeksforgeeks.org/n-queen-problem-backtracking-3> 

From the literature I found, these are the latest solutions along with their computational complexities:

1. Brute Force (checking all NxN rows for every queen) is the worst at O(N^N) [1],
2. Brute Force with no more than one queen in any column is O(N!) [1],
3. The Backtracking algorithm (the one followed by this application) is O(N!) [2],
4. Systematic Greedy search has polynomial complexity at O(N^k) (best O(N ^ 1.5)) [3],
5. Systematic Random Permutations has also a polynomial time complexity [4],
6. Optimised Smart Random Computations are trying to reach linear time O(N) [5].


#### Testing:

JUnit 5 was used for unit testing along with JaCoCo to provide neat web-page with results. To run testing please do the following: 

  For Linux/Mac type: 

	./gradlew test

  For Windows type: 
  
  	gradlew test
    
After this, for a neat test results and details display one can open the following file in the browser as provided by JaCoCo:

	build\reports\tests\test\index.html 


#### References:

1. <https://medium.com/@jmohon1986/timeout-the-story-of-n-queens-time-complexity-c80636d92f8b>

2. <https://www.codesdope.com/course/algorithms-backtracking/>

3. <https://sites.google.com/site/nqueensolver/home/algorithms/3systematic-greedy-algorithm>

4. R. Sosic and J. Gu. A Polynomial Time Algorithm for the N-Queens Problem. SIGART Bulletin, Vol. 1, 3, pp. 7-11, Oct, 1990

	PDF: <https://fizyka.umk.pl/~milosz/AlgIILab/10.1.1.57.4685.pdf>

5. <http://algolist.ru/maths/combinat/nqueens.php>












