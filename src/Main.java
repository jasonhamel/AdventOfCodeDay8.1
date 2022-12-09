import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            int[][] trees = scanRows();
            System.out.println(visibleTrees(trees));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static int[][] scanRows() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("input.txt");
        Scanner scan = new Scanner(fis);
        int trees[][] = new int[99][99];
        String[] rows = new String[99];
        for (int i = 0; i < 99; i++) {
            rows[i] = scan.nextLine();
        }
        for (int i = 0; i < 99; i++) {
            for (int j = 0; j < rows[0].length(); j++) {
                int height = Integer.parseInt(String.valueOf(rows[i].charAt(j)));
                trees[i][j] = height;
            }
        }
        return trees;
    }

    public static int visibleTrees(int[][] trees) {
        int visibleTrees = 0;
        for (int i = 0; i < trees.length; i++) {
            for (int j = 0; j < trees[0].length; j++) {
                boolean right = visibleRight(trees, i, j);
                boolean left = visibleLeft(trees, i, j);
                boolean up = visibleUp(trees, i, j);
                boolean down = visibleDown(trees, i, j);

                if (right || left || up ||down) {
                    visibleTrees++;
                }
            }
        }

        return visibleTrees;
    }

    public static boolean visibleRight(int[][] trees, int i, int j) {
        for (int k = j + 1; k < trees[0].length; k++) {
            if (trees[i][j] <= trees[i][k]) {
                return false;
            }
        }
        return true;
    }
    public static boolean visibleLeft(int[][] trees, int i, int j) {
        for (int k = j - 1; k >= 0; k--) {
            if (trees[i][j] == trees[i][k]) {
                return false;
            }
            if (trees[i][j] < trees[i][k]) {
                return false;
            }
        }
        return true;
    }
    public static boolean visibleUp(int[][] trees, int i, int j) {
        for (int k = i - 1; k >= 0; k--) {
            if (trees[i][j] <= trees[k][j]) {
                return false;
            }
        }
        return true;
    }
    public static boolean visibleDown(int[][] trees, int i, int j) {
        for (int k = i + 1; k < trees.length; k++) {
            if (trees[i][j] <= trees[k][j]) {
                return false;
            }
        }
        return true;
    }
}