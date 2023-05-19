import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Image.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Piece {
    public int col;
    public int row;
    public int x_pos;
    public int y_pos;
    public boolean isWhite;
    public int value;
    public String name;
    boolean isFirstmove = true;
    boolean isValidMovement(int col, int row){ //to check if a piece can reach a square: (col,row)
        return true;
    }

    boolean collide(int col, int row){
        return false;
    } //to check if is there any obstacle on the way from current position of the piece to square (col, row)
    BufferedImage sheet;
    {
        try {
            sheet = ImageIO.read(ClassLoader.getSystemResourceAsStream("pieces.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    int scale = sheet.getWidth()/6;
    Image sprite;
    Board board;
    Piece(Board board) {

        this.board = board;
    }

    public void printpiece(Graphics2D g2d){
        g2d.drawImage(sprite, x_pos, y_pos, null);
    }

}