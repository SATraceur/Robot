package robot;

public class Robot {

    private int currentx, currenty;
    private char current_dir;
        
    public Robot(int startx, int starty){
       this.current_dir = 'N';
       this.currentx = startx;
       this.currenty = starty;
    }
       
    public void moveForward() {
        switch(current_dir){
            case 'N':
                this.currenty++;
                break;
            case 'S':
                this.currenty--;
                break;
            case 'E':
                this.currentx++;
                break;
            case 'W':
                this.currentx--;
                break;
        }
    }
    
    public void turnLeft() {
           switch(this.current_dir){
            case 'N':
                this.current_dir = 'W';
                break;
            case 'S':
                this.current_dir = 'E';
                break;
            case 'E':
                this.current_dir = 'N';
                break;
            case 'W':
                this.current_dir = 'S';
                break;
        }
    }
    
    public void obstacleAvoid(char targetDir) { // Finds edge of obstacle and continues moving in targetDir
        // 1) Try move in targetDir
        // 2) If obstacle is in targetDir, turn left & move 1 step
        // 3) check if obstacle is still in targetDir
        // 4) YES? Move 1 more step, goto 3               
        //    NO? turn targetDir & move forward  
    }

    public int getCurrentx() {
        return currentx;
    }

    public int getCurrenty() {
        return currenty;
    }

    public char getCurrent_dir() {
        return current_dir;
    }
       
    public static void main(String[] args) {
        
        final int ARENA_WIDTH = 20;
        final int ARENA_HEIGHT = 20;   
        boolean obstacle = false;      
        Robot test = new Robot(ARENA_WIDTH/2, ARENA_HEIGHT/2);
        
        // Advance robot To North wall avoiding obstacles
        while (test.getCurrenty() < ARENA_HEIGHT) { 
            if (obstacle) {test.obstacleAvoid('N');}
            else {test.moveForward();}
        }
        
        // Turn West and advance robot to West wall avoiding obstacles.
        test.turnLeft();
        while (test.getCurrentx() > 0) {
            if (obstacle) {test.obstacleAvoid('W');}
            else {test.moveForward();}
        }
        
        // Finish in NorthWest corner facing South
        test.turnLeft();   
        
        System.out.println("X = " + test.getCurrentx() + " Y = " + test.getCurrenty() + " dir = " + test.getCurrent_dir());
    }  
}
