import java.awt.image.BufferedImage;

public class Queen extends Piece{
    Queen(Board board, int col, int row, boolean isWhite){
        super(board);
        this.col = col;
        this.row = row;
        this.isWhite = isWhite;

        this.x_pos = col * board.title_size;
        this.y_pos = row * board.title_size;

        int y_pos_sprite;
        if (isWhite){
            y_pos_sprite = 0;
        } else {
            y_pos_sprite = scale;
        }
        this.sprite = sheet.getSubimage(scale * 1, y_pos_sprite, scale, scale).getScaledInstance(board.title_size, board.title_size, BufferedImage.SCALE_SMOOTH);

    }
    boolean isValidMovement(int col, int row){ //to check if a piece can reach a square: (col,row)
        if ((Math.abs(this.col - col) == Math.abs(this.row - row)) || (col == this.col || row == this.row) ){
            return true;
        }
        return false;
    }

    boolean collide(int col, int row){
        if (this.col == col || this.row == row){
            //left
            if (this.col > col) {
                for (int c = this.col - 1; c > col; c--){
                    if (board.getPiece(c,this.row) != null){
                        return true;
                    }
                }
            }

            //right
            if (this.col < col) {
                for (int c = this.col + 1; c < col; c++){
                    if (board.getPiece(c,this.row) != null){
                        return true;
                    }
                }
            }
            //up
            if (this.row < row) {
                for (int r = this.row + 1; r < row; r++){
                    if (board.getPiece(this.col,r) != null){
                        return true;
                    }
                }
            }

            //down
            if (this.row > row) {
                for (int r = this.row - 1; r > row; r--){
                    if (board.getPiece(this.col,r) != null){
                        return true;
                    }
                }
            }


        } else {
            if (this.col > col && this.row > row){
                for (int i = 1; i < Math.abs(this.col-col); i++){
                    if (board.getPiece(this.col - i, this.row-i ) != null){
                        return true;
                    }
                }
            }
            //up right
            if (this.col < col && this.row > row){
                for (int i = 1; i < Math.abs(this.col-col); i++){
                    if (board.getPiece(this.col + i, this.row-i ) != null){
                        return true;
                    }
                }
            }
            //down left
            if (this.col > col && this.row < row){
                for (int i = 1; i < Math.abs(this.col-col); i++){
                    if (board.getPiece(this.col - i, this.row+i ) != null){
                        return true;
                    }
                }
            }
            //down right
            if (this.col < col && this.row < row){
                for (int i = 1; i < Math.abs(this.col-col); i++){
                    if (board.getPiece(this.col + i, this.row+i ) != null){
                        return true;
                    }
                }
            }

        }
        return false;
    }
}
