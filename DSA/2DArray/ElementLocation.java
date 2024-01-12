import java.util.*;

public class ElementLocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input for the number of rows and columns
        int row = sc.nextInt();
        int col = sc.nextInt();

        // Initialize a 2D array
        int[][] numbers = new int[row][col];

        // Input for array elements
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                numbers[i][j] = sc.nextInt();
            }
        }

        // Output the array
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}
