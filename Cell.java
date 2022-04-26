import java.util.*;
import java.io.*;
import java.math.*;

class Cell{
    private int x;
    private int y;
    private boolean occupied;

    public boolean isOccupied(){
        return occupied;
    }
    public void setOccupied(boolean occupied){
        this.occupied = occupied;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Cell(){

    }
    public Cell(int x,int y){
        this.x = x;
        this.y = y;
    }
    public Cell(int x, int y,boolean occupied){
        this.x = x;
        this.y = y;
        this.occupied = occupied;
    }
    
    public int getColumnCoordinate(char firstChar){
    switch(firstChar){
        case 'a' : return 0;
        case 'b' : return 1;
        case 'c' : return 2;
        case 'd' : return 3;
        case 'e' : return 4;
        case 'f' : return 5;
        case 'g' : return 6;
        case 'h' : return 7;
    }
        return -1;
    }
    public int getRowCoordinate(){
        return Character.getNumericValue(y);
    } 
    
    public String toString(){
        return "x: "+x+" ; y: "+y+" ; occupied: "+occupied+"\n";
    }
} 
class Square{
    /***
     * Describe the name of a cell
     */
    char colName;
    char rowName;
    
    public Square(char colName,char rowName){
        this.colName = colName;
        this.rowName = rowName;
    }
    
    public String toString(){
        return ""+colName+rowName;
    }
}
class Piece{
    protected Cell cell ;
    protected int color;
    //rajouter protected String onePiece;    ?

    public Piece(){

    }
    public Piece(Cell cell,  int color){ //rajouter protected String onePiece;    ?
        this.cell = cell;
        this.color = color;
    }
    public Piece(Cell cell){
        this.cell = cell;
    }

    public String toString(){ //rajouter protected String onePiece;    ?
        return "cell: "+cell+" ; color: "+color;
    }
    
}
class Rook extends Piece{
    
    public Rook(Cell cell){
        super();
        this.cell = cell;
    }
    //all possible rook movements --- del : without another piece
    public List<Cell> rookMovements(Cell rookPos){
        List<Cell> rookPositions = new ArrayList<Cell>();
        int x_rook = rookPos.getX();
        int y_rook = rookPos.getY();
        boolean isOccupied_cell = rookPos.isOccupied();
        //List of positions , to the right
        for(int i= x_rook ; i< 8 ; i++){
            rookPositions.add(new Cell(i,y_rook,isOccupied_cell));
        }
        //List of positions , to the left
        for(int i= x_rook ; i>0; i--){
            rookPositions.add(new Cell(i,y_rook,isOccupied_cell));
        }
        //List of positions , to the top
        for(int j= y_rook ; j< 8 ; j++){
            rookPositions.add(new Cell(x_rook,j,isOccupied_cell));
        }
        //List of positions , to the bottom
        for(int j= x_rook ; j>0; j--){
            rookPositions.add(new Cell(x_rook,j,isOccupied_cell));
        }
        return rookPositions;
    }
    /***
     * Given the rook position and the List of Cell where the
     * rook can move, it returns all the rook movements in the
     * desired format: ie : Rd5-a5 , Rd5-b5 etc...
     */ 
    public List<RookMovement> rookMovements(List<Cell> rookMovements){
        //List<String> rookMvts = new ArrayList<>();
        
        int x_rook = this.cell.getX();
        int y_rook = this.cell.getY();
        //i need to create a class "RookMovement"
        //to stock the rook position(or x and y rook position), and the destination Cell
        
        char colName;
        char rowName;
        Square initSquare = new Square(colName,rowName);
        RookMovement rookMvt = new RookMovement(initSquare,finalSquare);
    
        return null;
    } 

} 
class RookMovement{
    Square initialSquare;
    Square finalSquare;
    
    public RookMovement(Square initialSquare,Square finalSquare){
        this.initialSquare=initialSquare;
        this.finalSquare=finalSquare;
    }
    
    /***
     * Only "-" for the moment
     */
    public String toString(){
        return "R"+initialSquare+"-"+finalSquare;
    }
    
}
class Board{
    List<Cell> cellules;
    List<Piece> pieces;
    
    public Board(List<Piece> pieces){
        cellules = new ArrayList<Cell>();
        //pieces = new ArrayList<Piece>();
        
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                cellules.add(new Cell(i,j) );
            }
        }
    }
   
}

class Solution {
    
    public static Square toSquare(String onePiece){
        return new Square(onePiece.charAt(0),onePiece.charAt(1));
    }
    public static Cell getCell(Square square){
        char col = square.colName;
        char row = square.rowName;
        
        Cell cell = new Cell();
        cell = new Cell(cell.getColumnCoordinate(col),cell.getRowCoordinate());
       //la cellule de la piece est occupee:
        cell.setOccupied(true);
        return cell;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String rookPosition = in.next();
        int nbPieces = in.nextInt();
        //System.err.println(nbPieces);
        //a implementer : tester si les Cell du plateau sont occupées.
        //Board b = new Board();
        
        for (int i = 0; i < nbPieces; i++) {
            int colour = in.nextInt();
            String onePiece = in.next();
            Square square = toSquare(onePiece);
            //TO DO : prendre une Square et retourner une Cell 
            Cell cellPiece = getCell(square);
            Piece piece = new Piece(cellPiece,colour);
            System.out.println(piece);
        }
        
    }
}
