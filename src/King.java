public class King extends ChessPiece {

    public King(String color) {
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

        return (dLine == 1 && dColumn == 0) || (dLine == 0 && dColumn == 1) || (dLine == 1 && dColumn == 1);
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        int[][] directions = { {-1, -1}, {-1, 1}, {1, -1}, {1, 1} };
        for (int[] direction : directions) {
            int i = line + direction[0];
            int j = column + direction[1];
            while (chessBoard.checkPos(i) && chessBoard.checkPos(j)) {
                ChessPiece piece = chessBoard.board[i][j];
                if (piece != null) {
                    if ((piece instanceof Bishop || piece instanceof Queen) && piece.getColor() != color) {
                        return true;
                    }
                    break;
                }
                i += direction[0];
                j += direction[1];
            }
        }

        directions = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        for (int[] direction : directions) {
            int i = line + direction[0];
            int j = column + direction[1];
            while (chessBoard.checkPos(i) && chessBoard.checkPos(j)) {
                ChessPiece piece = chessBoard.board[i][j];
                if (piece != null) {
                    if ((piece instanceof Rook || piece instanceof Queen) && piece.getColor() != color) {
                        return true;
                    }
                    break;
                }
                i += direction[0];
                j += direction[1];
            }
        }

        int[][] pawnDirections = color.equals("White") ? new int[][] { {-1, -1}, {-1, 1} } : new int[][] { {1, -1}, {1, 1} };
        for (int[] direction : pawnDirections) {
            int i = line + direction[0];
            int j = column + direction[1];
            if (chessBoard.checkPos(i) && chessBoard.checkPos(j)) {
                ChessPiece piece = chessBoard.board[i][j];
                if (piece instanceof Pawn && piece.getColor() != color) {
                    return true;
                }
            }
        }

        int[][] knightMoves = { {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1} };
        for (int[] move : knightMoves) {
            int i = line + move[0];
            int j = column + move[1];
            if (chessBoard.checkPos(i) && chessBoard.checkPos(j)) {
                ChessPiece piece = chessBoard.board[i][j];
                if (piece instanceof Horse && piece.getColor() != color) {
                    return true;
                }
            }
        }

        return false;
    }
}
