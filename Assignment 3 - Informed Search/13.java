import java.util.*;


/**
 * 
 * Cover topright and bottomleft point
 * 
 * 
 * HOD
 * 3:30 - RSS
 * BHUTKAR
 * 5-6
 * 
 */


class BestFirstSearch
{

    // Function to find manhatten dist
    public static int getHeuristic(int crntX,int goalX, int crntY, int goalY){
        return Math.abs(crntX-goalX) + Math.abs(crntY-goalY);
    }

    // Function to find smallest dist among all neighbours
    public static int[] getNextCoordinates(int y, int x, int maze[][], int heu[][])
    {
        int ans[] = new int[]{-1,-1};
        // neighbour co-ordinates
        int leftN[] = new int[]{x-1, y};
        int rightN[] = new int[]{x+1, y};
        int topN[] = new int[]{x, y-1};
        int bottomN[] = new int[]{x, y+1};

        if(x == 0 && y == 0) // Your on topleft | don't check for left and top
        {
            int rightDist = -1;
            int bottomDist = -1;

            if(heu[rightN[1]][rightN[0]] == -1) // checking if right is wall
            { 
                ans[0] = bottomN[1];
                ans[1] = bottomN[0];
                return ans;
            }
            else if(heu[bottomN[1]][bottomN[0]] == -1) // checking if bottom is wall
            {
                ans[0] = rightN[1];
                ans[1] = rightN[0];
                return ans;
            }
            else // keeping if no wall
            {
                rightDist = heu[rightN[1]][rightN[0]];
                bottomDist = heu[bottomN[1]][bottomN[0]];

                // Taking minimal cost as ans
                if(rightDist <= bottomDist)
                {
                    // Complete this function.....
                    ans[0] = rightN[1];
                    ans[1] = rightN[0];
                    return ans;
                }
                else
                {
                    // Complete this function.....
                    ans[0] = bottomN[1];
                    ans[1] = bottomN[0];
                    return ans;
                }
            }
        }
        else if(x == maze[0].length-1 && y == maze.length-1) // // Your on bottomRight | don't check for right and bottom
        {
            int topDist = -1;
            int leftDist = -1;

            if(heu[leftN[1]][leftN[0]] == -1) // checking if left is wall
            { 
                ans[0] = topN[1];
                ans[1] = topN[0];
                return ans;
            }
            else if(heu[topN[1]][topN[0]] == -1) // checking if top is wall
            {
                ans[0] = leftN[1];
                ans[1] = leftN[0];
                return ans;
            }
            else // keeping if no wall
            {
                leftDist = heu[leftN[1]][leftN[0]];
                topDist = heu[topN[1]][topN[0]];

                // Taking minimal cost as ans
                if(leftDist <= topDist)
                {
                    // Complete this function.....
                    ans[0] = leftN[1];
                    ans[1] = leftN[0];
                    return ans;
                }
                else
                {
                    // Complete this function.....
                    ans[0] = topN[1];
                    ans[1] = topN[0];
                    return ans;
                }
            }
        }
        else if(x == maze[0].length-1 && y == 0) // Your on toprightt | don't check for left and top
        {
            int leftDist = -1;
            int bottomDist = -1;

            if(heu[leftN[1]][leftN[0]] == -1) // checking if right is wall
            { 
                ans[0] = bottomN[1];
                ans[1] = bottomN[0];
                return ans;
            }
            else if(heu[bottomN[1]][bottomN[0]] == -1) // checking if bottom is wall
            {
                ans[0] = leftN[1];
                ans[1] = leftN[0];
                return ans;
            }
            else // keeping if no wall
            {
                leftDist = heu[leftN[1]][leftN[0]];
                bottomDist = heu[leftN[1]][leftN[0]];

                // Taking minimal cost as ans
                if(leftDist <= bottomDist)
                {
                    // Complete this function.....
                    ans[0] = leftN[1];
                    ans[1] = leftN[0];
                    return ans;
                }
                else
                {
                    // Complete this function.....
                    ans[0] = bottomN[1];
                    ans[1] = bottomN[0];
                    return ans;
                }
            }
        }
        else if(x == 0 && y == maze.length-1) // // Your on bottomLeft | don't check for right and bottom
        {
            int topDist = -1;
            int rightDist = -1;

            if(heu[rightN[1]][rightN[0]] == -1) // checking if left is wall
            { 
                ans[0] = topN[1];
                ans[1] = topN[0];
                return ans;
            }
            else if(heu[topN[1]][topN[0]] == -1) // checking if top is wall
            {
                ans[0] = rightN[1];
                ans[1] = rightN[0];
                return ans;
            }
            else // keeping if no wall
            {
                rightDist = heu[rightN[1]][rightN[0]];
                topDist = heu[topN[1]][topN[0]];

                // Taking minimal cost as ans
                if(rightDist <= topDist)
                {
                    // Complete this function.....
                    ans[0] = rightN[1];
                    ans[1] = rightN[0];
                    return ans;
                }
                else
                {
                    // Complete this function.....
                    ans[0] = topN[1];
                    ans[1] = topN[0];
                    return ans;
                }
            }
        }
        else if(x == 0) // don't check for left, because its already on first col
        {
            int topDist = -1;
            int rightDist = -1;
            int bottomDist = -1;
            
            // Setting heuValues
            if(heu[topN[1]][topN[0]] != -1)
            {
                topDist = heu[topN[1]][topN[0]];
            }
            if(heu[rightN[1]][rightN[0]] != -1)
            {
                rightDist = heu[rightN[1]][rightN[0]];
            }
            if(heu[bottomN[1]][bottomN[0]] != -1)
            {
                bottomDist = heu[bottomN[1]][bottomN[0]];
            }

            // moving to minimal cost
            if(topDist != -1 && topDist <= rightDist && topDist <= bottomDist)
            {   
                ans[0] = topN[1];
                ans[1] = topN[0];
                return ans;
            }
            else if(rightDist != -1 && rightDist <= topDist && rightDist <= bottomDist)
            {   
                ans[0] = rightN[1];
                ans[1] = rightN[0];
                return ans;
            }
            else if(bottomDist != -1 && bottomDist <= topDist && bottomDist <= rightDist)
            {   
                ans[0] = bottomN[1];
                ans[1] = bottomN[0];
                return ans;
            }
        }
        else if(y == 0) // don't check for top, because its already on first row
        {
            int leftDist = -1;
            int rightDist = -1;
            int bottomDist = -1;
            
            // Setting heuValues
            if(heu[leftN[1]][leftN[0]] != -1)
            {
                leftDist = heu[leftN[1]][leftN[0]];
            }
            if(heu[rightN[1]][rightN[0]] != -1)
            {
                rightDist = heu[rightN[1]][rightN[0]];
            }
            if(heu[bottomN[1]][bottomN[0]] != -1)
            {
                bottomDist = heu[bottomN[1]][bottomN[0]];
            }

            // moving to minimal cost
            if(leftDist != -1 && leftDist <= rightDist && leftDist <= bottomDist)
            {   
                ans[0] = leftN[1];
                ans[1] = leftN[0];
                return ans;
            }
            else if(rightDist != -1 && rightDist <= leftDist && rightDist <= bottomDist)
            {   
                ans[0] = rightN[1];
                ans[1] = rightN[0];
                return ans;
            }
            else if(bottomDist != -1 && bottomDist <= leftDist && bottomDist <= rightDist)
            {   
                ans[0] = bottomN[1];
                ans[1] = bottomN[0];
                return ans;
            }
        }
        
    }



    public static void main(String[] args) {
        
        // Maze matrix
        char maze[][] = new char[][]{
            {'S','O','O','O','O'},
            {'X','X','O','X','O'},
            {'O','X','O','O','O'},
            {'O','O','O','X','O'},
            {'O','X','O','O','G'}
        };

        // Finding co-ordinates of goal state
        int goalX = -1, goalY = -1;
        for(int i=0; i<maze.length; i++)
        {
            for(int j=0; j<maze[0].length; j++)
            {
                if(maze[i][j] == 'G')
                {
                    goalX = i;
                    goalY = j;
                    break;
                }
            }
        }
        
        // storing and mapping all heuristic values of above maze
        int heuristic[][] = new int[maze.length][maze[0].length];
        for(int i=0; i<maze.length; i++)
        {
            for(int j=0; j<maze[0].length; j++)
            {
                // here i and j is crntX and crntY
                heuristic[i][j] = getHeuristic(i, goalX, j, goalY);
            }
        }

        // Making all obstacles as -1
        for(int i=0; i<maze.length; i++)
        {
            for(int j=0; j<maze[0].length; j++)
            {
                if(maze[i][j] == 'X')
                    heuristic[i][j] = -1;
            }
        }

        // Starting with Breadth FS
        ArrayList<Integer> openLs = new ArrayList<>();
        ArrayList<Integer> closeLs = new ArrayList<>();

        // utility function to print
        for(int i=0; i<maze.length; i++)
        {
            for(int j=0; j<maze[0].length; j++)
            {
                System.out.print(heuristic[i][j] + " ");
            }
            System.out.println();
        }





    }
}