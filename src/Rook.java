public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column)) return false;

        int dLine = Math.abs(toLine - line);
        int dColumn = Math.abs(toColumn - column);

        if ((dLine == 0 && dColumn > 0) || (dLine > 0 && dColumn == 0)) {
            int directionLine = toLine > line ? 1 : (toLine < line ? -1 : 0);
            int directionColumn = toColumn > column ? 1 : (toColumn < column ? -1 : 0);
            int currentLine = line + directionLine;
            int currentColumn = column + directionColumn;

            while (currentLine != toLine || currentColumn != toColumn) {
                if (chessBoard.board[currentLine][currentColumn] != null) {
                    return false;
                }
                currentLine += directionLine;
                currentColumn += directionColumn;
            }

            return chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(getColor());
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
