import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    int row;
    int col;
    String[][] mineMap;
    String[][] game;
    
    Minesweeper(int row, int col) {
        this.row = row ;
        this.col = col ;
        this.mineMap = new String[row][col];
        this.game = new String[row][col];
    }
    public void run() {
        Random rnd = new Random();
        int numberOfMines = (row * col) / 4 ;
        
        for( int i = 0 ; i < mineMap.length ; i ++ ) {
            for ( int j = 0 ; j < mineMap[0].length ; j ++ ) {
            	mineMap[i][j] = " - ";
            }    
        }
        while ( numberOfMines > 0 ) {
            int randRow = rnd.nextInt(this.row);
            int randCol = rnd.nextInt(this.col);
            if( mineMap [randRow] [randCol].equals(" - ")) {
                mineMap [randRow] [randCol] = " * ";
                numberOfMines--;
            } 
        }

        for( int i = 0 ; i < game.length ; i ++ ) {
            for ( int j = 0 ; j < game[0].length ; j ++ ) {
            	game[i][j] = " - ";
            }    
        }
        
        printGameMap();
        input();
        printMineMap();
    }
    
    public void printGameMap() {
        System.out.println("============== GAME MAP ===============");

        for (String i [] : game ) {
            for( String j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    
    public void printMineMap() {
        System.out.println("============== MINE MAP ==============");

        for (String i [] : mineMap ) {
            for( String j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public void input() {
    	Scanner input = new Scanner(System.in);
        int countMine = 0 ;

        while (isContinued(mineMap)) {
            System.out.print("Row: ");
            int r = input.nextInt();
            System.out.print("Column: ");
            int c = input.nextInt();

            if( r < 0 || r > mineMap.length-1 || c < 0 || c > mineMap[0].length-1 ) {
                System.out.println("Please enter a number within the game limits!");
                continue;
            }
        
            if ( mineMap[r][c].equals(" * ") ) {
                System.out.println("\nGAME OVER!");
                break;
            }
            
            
            if ( r == 0 && c == 0 && mineMap[r][c].equals(" - ") ) {
                if ( mineMap[r+1][c].equals(" * ") ) {
                    countMine++;
                }
                if( mineMap[r+1][c+1].equals(" * ") ) {
                    countMine++;
                }
                if( mineMap[r][c+1].equals(" * ") ) {
                    countMine++;
                }
                game[r][c] = " " + countMine +" ";
                mineMap[r][c] = " " + countMine +" ";
                countMine = 0;
            }
            
            if ( r == 0 && c == mineMap[0].length-1 && mineMap[r][c].equals(" - ") ) {
                if ( mineMap[r+1][c].equals(" * ") ) {
                    countMine++;
                }
                if( mineMap[r+1][c-1].equals(" * ") ) {
                    countMine++;
                }
                if( mineMap[r][c-1].equals(" * ") ) {
                    countMine++;
                }
                game[r][c] = " " + countMine +" ";
                mineMap[r][c] = " " + countMine +" ";
                countMine = 0;
            }

            if ( r == mineMap.length-1 && c == 0 && mineMap[r][c].equals(" - ") ) {
                if ( mineMap[r-1][c].equals(" * ") ) {
                    countMine++;
                }
                if( mineMap[r-1][c+1].equals(" * ") ) {
                    countMine++;
                }
                if( mineMap[r][c+1].equals(" * ") ) {
                    countMine++;
                }
                game[r][c] = " " + countMine +" ";
                mineMap[r][c] = " " + countMine +" ";
                countMine = 0;
            }

            if ( r == mineMap.length-1 && c == mineMap[0].length-1 && mineMap[r][c].equals(" - ") ) {
                if ( mineMap[r][c-1].equals(" * ") ) {
                    countMine++;
                }
                if( mineMap[r-1][c-1].equals(" * ") ) {
                    countMine++;
                }
                if( mineMap[r-1][c].equals(" * ") ) {
                    countMine++;
                }
                game[r][c] = " " + countMine +" ";
                mineMap[r][c] = " " + countMine +" ";
                countMine = 0;
            }
            
            if ( r == 0 && c > 0 && c < mineMap[0].length-1 ) {
                if ( mineMap[r][c-1].equals(" * ") ) {
                    countMine++;
                }
                if ( mineMap[r][c+1].equals(" * ")) {
                    countMine++;
                }
                if ( mineMap[r+1][c-1].equals(" * ")) {
                    countMine++;
                }
                if ( mineMap[r+1][c].equals(" * ")) {
                    countMine++;
                }
                if ( mineMap[r+1][c+1].equals(" * ")) {
                    countMine++;
                }
                game[r][c] = " " + countMine +" ";
                mineMap[r][c] = " " + countMine +" ";
                countMine = 0;
            }

            if ( r > 0 && r < mineMap.length-1 && c == 0 ) {
                if ( mineMap[r-1][c].equals(" * ") ) {
                    countMine++;
                }
                if ( mineMap[r-1][c+1].equals(" * ")) {
                    countMine++;
                }
                if ( mineMap[r][c+1].equals(" * ")) {
                    countMine++;
                }
                if ( mineMap[r+1][c].equals(" * ")) {
                    countMine++;
                }
                if ( mineMap[r+1][c+1].equals(" * ")) {
                    countMine++;
                }
                game[r][c] = " " + countMine +" ";
                mineMap[r][c] = " " + countMine +" ";
                countMine = 0;
            }

            if ( r == mineMap.length-1 && c > 0 && c < mineMap[0].length-1 ) {
                if ( mineMap[r][c-1].equals(" * ") ) {
                    countMine++;
                }
                if ( mineMap[r][c+1].equals(" * ")) {
                    countMine++;
                }
                if ( mineMap[r-1][c-1].equals(" * ")) {
                    countMine++;
                }
                if ( mineMap[r-1][c].equals(" * ")) {
                    countMine++;
                }
                if ( mineMap[r-1][c+1].equals(" * ")) {
                    countMine++;
                }
                game[r][c] = " " + countMine +" ";
                mineMap[r][c] = " " + countMine +" ";
                countMine = 0;
            }

            if ( r > 0 && r < mineMap.length-1 && c == mineMap[0].length-1 ) {
                if ( mineMap[r-1][c].equals(" * ") ) {
                    countMine++;
                }
                if ( mineMap[r-1][c-1].equals(" * ")) {
                    countMine++;
                }
                if ( mineMap[r][c-1].equals(" * ")) {
                    countMine++;
                }
                if ( mineMap[r+1][c-1].equals(" * ")) {
                    countMine++;
                }
                if ( mineMap[r+1][c].equals(" * ")) {
                    countMine++;
                }
                game[r][c] = " " + countMine +" ";
                mineMap[r][c] = " " + countMine +" ";
                countMine = 0;
            }
           
            if ( r > 0 && r < mineMap.length-1 && c > 0 && c < mineMap[0].length-1 && mineMap[r][c].equals(" - ") ) {
                if (mineMap[r-1][c].equals(" * "))   {
                    countMine++;    
                }
                if (mineMap[r+1][c].equals(" * ")) {
                    countMine++;
                }
                if (mineMap[r][c-1].equals(" * ")) {
                    countMine++;
                }
                if (mineMap[r][c+1].equals(" * ")) {
                    countMine++;
                }
                if (mineMap[r-1][c+1].equals(" * ")) {
                    countMine++;
                }
                if (mineMap[r-1][c-1].equals(" * ")) {
                    countMine++;
                }
                if (mineMap[r+1][c-1].equals(" * ")) {
                    countMine++;
                }
                if (mineMap[r+1][c+1].equals(" * ")) {
                    countMine++;
                }
           
                game[r][c] = " " + countMine +" ";
                mineMap[r][c] = " " + countMine +" ";
                countMine = 0;
            } 
            printGameMap();  
        }
        if(!isContinued(mineMap)) {
        System.out.println("\nCONGRATULATIONS, YOU WON!");
        }
    }

    public boolean isContinued ( String[][] finish ) {
        for (String[] a : finish ) {
            for ( String b : a ) {
                if ( b.equals(" - ") ) {
                    return true;
                } 
            } 
        }
        return false;
    }
}
