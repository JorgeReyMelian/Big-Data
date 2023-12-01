package org.example.matrix;

import java.util.ArrayList;
import java.util.List;

public class Tiles {
    public static List<long[][]> createTiles(DenseMatrix matrix, int n) {
        int blockSize = 2;
        if (n % blockSize != 0) {
            return null;
        }
        int tileN = (n / blockSize) * (n / blockSize);
        List<long[][]> tiles = new ArrayList<>();

        for (int k = 0; k < tileN; k++) {
            long[][] tile = new long[blockSize][blockSize];
            int startRow = (k / (n / blockSize)) * blockSize;
            int startCol = (k % (n / blockSize)) * blockSize;

            for (int i = 0; i < blockSize; i++) {
                for (int j = 0; j < blockSize; j++) {
                    tile[i][j] = matrix.getValues()[startRow + i][startCol + j];
                }
            }
            tiles.add(tile);
        }
        return tiles;
    }

    public static List<long[][]> switchTilesInRows(List<long[][]> tiles, int size) {
        int tilesPerRow = size/2;
        List<long[][]> switchedTiles = new ArrayList<>();

        for (int i = 0; i < tiles.size(); i += tilesPerRow) {
            int endIndex = Math.min(i + tilesPerRow, tiles.size());

            for (int j = i; j < endIndex; j++) {
                int newIndex = (j - i + 1) % tilesPerRow;
                switchedTiles.add(tiles.get(i + newIndex));
            }
        }

        return switchedTiles;
    }

    public static List<long[][]> shiftTilesInColumns(List<long[][]> tiles, int size) {
        int tilesPerColumn = size/2;
        List<long[][]> shiftedTilesCol = new ArrayList<>();
        List<long[][]> shiftedTiles = new ArrayList<>();
        List<long[][]> reversedTiles = new ArrayList<>(tiles.size());

        for (int i = 0; i < tilesPerColumn; i++) {
                for (int col = i; col < tiles.size(); col += tilesPerColumn) {
                    shiftedTilesCol.add(tiles.get(col));
                }
        }
        for (int i = 0; i < tiles.size(); i += tilesPerColumn) {
            int endIndex = Math.min(i + tilesPerColumn, tiles.size());

            for (int j = i; j < endIndex; j++) {
                int newIndex = (j - i + 1) % tilesPerColumn;
                shiftedTiles.add(shiftedTilesCol.get(i + newIndex));
            }
        }

        for (int i = 0; i < tilesPerColumn; i++) {
            for (int col = i; col < tiles.size(); col += tilesPerColumn) {
                reversedTiles.add(shiftedTiles.get(col));
            }
        }

        return reversedTiles;
    }

    public static List<long[][]> multiply(List<long[][]> a, List<long[][]> b) {
        int size = a.size();
        int n = (int) Math.sqrt(size);
        List<long[][]> result = new ArrayList<>();
        long[][] accumlated = new long[size][size];
        for (int round = 0; round < n; round++){
            long[][] multiplication = new long[size][size];
            for (int i = 0; i < a.size(); i++){
                long[][] matrix1 = a.get(i);
                long[][] matrix2 = b.get(i);
                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        multiplication[row][col] += matrix1[row][col] * matrix2[row][col];
                    }
                }
            }
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    accumlated[row][col] += multiplication[row][col];
                }
            }
            switchTilesInRows(a, size);
            shiftTilesInColumns(b, size);

        }
        result.add(accumlated);
        return result;
    }

}
