
class Matrix {
    private int[][] rows;
    private int[][] columns;

    Matrix(String matrixAsString) {
        String[] rowString = matrixAsString.split("\n");
        
        int rowLength = rowString.length;
        int columnLength = rowString[0].split(" ").length;

        rows = new int[rowLength][columnLength];
        columns = new int[columnLength][rowLength];

        for(int i = 0;i<rowLength;i++){
            String[] values = rowString[i].split(" ");
            for(int j = 0;j<columnLength;j++){
            int value = Integer.parseInt(values[j]);
            rows[i][j] = value;
            columns[j][i] = value;
            }
        }
    }

    int[] getRow(int rowNumber) {
        return rows[rowNumber-1];
    }

    int[] getColumn(int columnNumber) {
        return columns[columnNumber-1];
    }
}
