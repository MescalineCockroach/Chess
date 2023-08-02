public class Bishop extends ChessPiece {

    public Bishop(String color) {
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

        if (dLine == dColumn) {
            int directionLine = toLine > line ? 1 : -1;
            int directionColumn = toColumn > column ? 1 : -1;
            int currentLine = line + directionLine;
            int currentColumn = column + directionColumn;

            while (currentLine != toLine && currentColumn != toColumn) {
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
        return "B";
    }
}
