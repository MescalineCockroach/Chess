public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column)) return false;

        int direction = getColor().equals("White") ? 1 : -1;
        int dLine = toLine - line;
        int dColumn = Math.abs(toColumn - column);

        if (dColumn == 0 && dLine == direction && chessBoard.board[toLine][toColumn] == null) {
            return true;
        } else if (dColumn == 0 && dLine == 2 * direction && line == (getColor().equals("White") ? 1 : 6)
                && chessBoard.board[line + direction][column] == null && chessBoard.board[toLine][toColumn] == null) {
            return true;
        } else if (dColumn == 1 && dLine == direction && chessBoard.board[toLine][toColumn] != null
                && !chessBoard.board[toLine][toColumn].getColor().equals(getColor())) {
            return true;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
