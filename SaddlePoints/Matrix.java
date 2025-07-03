import java.util.*;

class Matrix {
    private List<List<Integer>> rows;
    private List<List<Integer>> columns;

    Matrix(List<List<Integer>> values) {
        if (values == null || values.isEmpty()) {
            return ;
        }
        
        this.rows = new ArrayList<>(values);
        this.columns = new ArrayList<>();
        
        int numOfCol = values.get(0).size();
        
        for (int col = 0; col < numOfCol; col++) {
            List<Integer> column = new ArrayList<>();
            for (List<Integer> row : values) {
                column.add(row.get(col));
            }
            columns.add(column);
        }
    }

    Set<MatrixCoordinate> getSaddlePoints() {
         Set<MatrixCoordinate> saddlePoints = new HashSet<>();
        if (rows == null || rows.isEmpty()) {
            return saddlePoints;
        }
        
        for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
            List<Integer> row = rows.get(rowIndex);
            int maxInRow = Collections.max(row);

            
            for (int colIndex = 0; colIndex < row.size(); colIndex++) {
                if (row.get(colIndex) == maxInRow) {
                    List<Integer> column = columns.get(colIndex);
                    int minInCol = Collections.min(column);
                    if (maxInRow == minInCol) {
                        saddlePoints.add(new MatrixCoordinate(rowIndex + 1, colIndex + 1));
                    }
                }
            }
        }

        return saddlePoints;
    }
}
