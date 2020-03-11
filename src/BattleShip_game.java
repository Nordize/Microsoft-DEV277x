import java.util.*;

public class BattleShip_game {

    //Create numbers on Grid
    public static int numRows = 10;
    public static int numCols = 10;
    public static String[][] grid = new String[numRows][numCols];
    //create object for player and computer
    public static int playerShips;
    public static int computerShips;

    public static void main(String[] args){

        System.out.println("**** Welcome to Battle Ships Game ****");
        System.out.println("Right now, the sea is empty");
        System.out.println(" ");

        //Step1- Create the ocean map using a SINGLE 2D Array
        printOceanMap();

        //Step2- Deploy player's ships
        deployPlayerShips();

        //step3- Deploy computer's ships
        deployComputerShips();

        //step4- Battle!
        do {
            Battle();
        }while ((BattleShip_game.playerShips != 0) && (BattleShip_game.computerShips !=0));  //if true, still looping

        //step5- GameOver
        gameOver();

    }

    public static void printOceanMap(){
        System.out.print("  ");
        for (int i=0;i<numCols;i++){
            System.out.print(i);
        }
        System.out.println();

        for(int row=0;row<grid.length;row++){
            System.out.print(row + "|");
            for(int col =0; col< grid[row].length;col++){
                if(grid[row][col] == null){
                    System.out.print(" ");
                }else{
                    System.out.print(grid[row][col]);
                }

            }
            System.out.println("|"+row);
        }

        System.out.print("  ");
        for (int i=0;i<numCols;i++){
            System.out.print(i);
        }
        System.out.println();

    }

    public static void deployPlayerShips(){
        Scanner input = new Scanner(System.in);

        System.out.println("Lets deploy your ships:");

        //Deploy 5 ships per player
        BattleShip_game.playerShips=5;
        for(int i=1;i<=BattleShip_game.playerShips;){
            System.out.print("Enter X coordinate for your ship: ");
            int x = input.nextInt();
            System.out.print("Enter y coordinate for your ship: ");
            int y= input.nextInt();


            if((x>=0 && x<numRows) && (y>=0 && y<numCols) && (grid[x][y] == null)){

                grid[x][y] = "@";
                i++;
            }
            else if((x>=0 && x<numRows) && (y>=0 && y<numCols) && (grid[x][y].equals("@"))){

                System.out.println("You can NOT place two or more ships on the same location.");
            }else if((x<0 || x>=numRows) || (y<0 || y>=numCols) ){
                System.out.println("You can't place ships outside the "+ numRows+" by " +numCols+" grid");
            }

        }

        printOceanMap();

    }

    public static void deployComputerShips(){
        System.out.println("Deploying computer's ships:");

        //Deploy 5 ships for computer
        BattleShip_game.computerShips = 5;

        for(int i=1;i<=BattleShip_game.computerShips;){

            //random generate coordinate x
            int x = (int)(Math.random() * (numRows - 0));  //from Math.random() * ( max - min ) returns a value in the range [0, max – min] where max is excluded.
            //random generate coordinate y
            int y = (int)(Math.random() * (numCols - 0));  //from Math.random() * ( max - min ) returns a value in the range [0, max – min] where max is excluded.

            if((x>=0 && x<numRows) && (y>=0 && y<numCols) && (grid[x][y] == null)){

                grid[x][y] = "C";  //Mark as Computer Ship

                System.out.println(i + ". ship DEPLOYED!");

                i++;
            }


        }
        //printOceanMap();  //Make computer ships invisible
    }

    public static void Battle(){

        System.out.println("Now you have "+ BattleShip_game.playerShips + " ships");
        System.out.println("Now computer have "+ BattleShip_game.computerShips + " ships");

        playerTurn();
        computerTurn();


        printOceanMap();

        System.out.println("==========================");
        System.out.println("Your ships: " + BattleShip_game.playerShips+" | Computer Ships: " + BattleShip_game.computerShips);
        System.out.println("==========================");
    }

    public static void playerTurn(){
        System.out.println("YOUR TURN");

        //default positions
        int x = -1;
        int y = -1;


        do{
            Scanner input = new Scanner(System.in);

            System.out.print("Enter X coordinate for target ship: ");
            x = input.nextInt();
            System.out.print("Enter y coordinate for target ship: ");
            y= input.nextInt();

            //Player correctly guessed coordinates of computer’s ship (computer loses ship).
            if((x>=0 && x<numRows) && (y>=0 && y<numCols)  ){

                if(grid[x][y] == null) {
                    System.out.println("Sorry, you missed");
                    grid[x][y] = "-";  //Hit missed mark
                }
                else if(grid[x][y].equals("C")){
                    System.out.println("Boom! You sunk the ship");
                    grid[x][y] = "!";  //Hit Mark
                    --BattleShip_game.computerShips;

                }else if(grid[x][y].equals("@")){
                    System.out.println("Oh no, you sunk your own ship :(");
                    grid[x][y] = "x";  //Hit your ship mark
                    --BattleShip_game.playerShips;

                }

            }else if((x<0 || x>=numRows) || (y<0 || y>=numCols) ){
                System.out.println("You can't place ships outside the "+ numRows+" by " +numCols+" grid");
            }

            //System.out.println("Now you have "+ BattleShip_game.playerShips + " ships");
            //System.out.println("Now computer have "+ BattleShip_game.computerShips + " ships");

            //System.out.println("Player Screen! -----------------------------------------------------------");
            //printOceanMap();

        }while((x < 0 || x >= numRows) || (y < 0 || y >= numCols));  //keep re-prompting till valid guess  //suppose to be fault then get out off the loop



    }

    public static void computerTurn(){
        System.out.println("Computer TURN");
        //default positions
        int x = -1;
        int y = -1;

        do{
            //random generate coordinate x
            x = (int)(Math.random() * (numRows - 0));  //from Math.random() * ( max - min ) returns a value in the range [0, max – min] where max is excluded.
            //random generate coordinate y
            y = (int)(Math.random() * (numCols - 0));  //from Math.random() * ( max - min ) returns a value in the range [0, max – min] where max is excluded.



            if(grid[x][y] == null) {
                System.out.println("Computer missed");
                grid[x][y] = "-";  //Hit missed mark
            }
            else if(grid[x][y].equals("C")){
                System.out.println("The Computer sunk one of its own ships");
                grid[x][y] = "!";  //Hit Mark
                --BattleShip_game.computerShips;

            }else if(grid[x][y].equals("@")){
                System.out.println("The Computer sunk one of your ships!");
                grid[x][y] = "x";  //Hit your ship mark
                --BattleShip_game.playerShips;

            }else if(grid[x][y].equals("-") ){
                System.out.println("Computer pick a duplicated cell, try again!");
                computerTurn();
            }


            //System.out.println("Computer Screen! -----------------------------------------------------------");
            //printOceanMap();

        }while((x < 0 || x >= numRows) || (y < 0 || y >= numCols));  //keep re-prompting till valid guess  //suppose to be fault then get out off the loop

    }

    public static void gameOver(){
        System.out.println();
        System.out.println();
        System.out.println("Show the last situation of the OceanMap!");
        printOceanMap();
        System.out.println();

        System.out.println("Game is Over!");

        if(BattleShip_game.computerShips == 0){
            System.out.println("Hooray! You win the battle :)");
        }else if(BattleShip_game.playerShips == 0){
            System.out.println("Oho! Computer win the battle");
        }

        System.out.println("Good game, thank you for playing!");

    }


}
