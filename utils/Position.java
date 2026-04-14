/**
 * Contains position attributes, AKA board location
 */

package utils;
import java.io.Serializable;

/** 
 * Position on the chessboard
 */
public class Position implements Serializable {
    private int row;
    private int col;

    /** 
     * Constructor
     */
    public Position (int row, int col) {
        this.row = row;
        this.col = col;
    }

    /** 
     * Return row
     */
    public int getRow() {
        return row;
    }

    /** 
     * Return column
     */
    public int getCol() {
        return col;
    }

    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Convert Position to standard notation
     */
    @Override
    public String toString() {
        char colLetter = (char) ('A' + col);
        int rowNum = 8 - row;
        return colLetter + "" + rowNum;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) {
            return true;
        }
        if(!(object instanceof Position)) {
            return false;
        }

        Position other = (Position) object;
        return this.getRow() == other.getRow() && this.getCol() == other.getCol();
    }

    @Override
    public int hashCode() {
        return 31 * row + col;
    }
}