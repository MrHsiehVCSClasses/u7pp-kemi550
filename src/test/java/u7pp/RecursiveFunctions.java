package u7pp;

public class RecursiveFunctions {
    
//Calculates the factorial of a given number using recursion. 
    public static double factorial(double n){
        //Base case if n is less than or equal to 1, return 1.
        if (n <= 1.0) {
            return 1.0;
        } else {
        //Recursive case multiply n by the factorial of n - 1.
            return n * factorial(n - 1.0);
        }
    }
//Returns the result of raising the base to the given power 
    public static double pow(double base, int pow) {
        //Check if the power is not zero
        if (pow != 0) {
            //Recursively call the pow function with the same base and a power that is one less than the current power shis will multiply the base by itself pow number of times
            return (base * pow(base, pow - 1));
        }
        else {
            //If the power is zero return 1 
            return 1;
        }
    }
//Calculates the nth number in the Fibonacci sequence
    public static int fibonacci(int n) {
        if ((n == 0) || (n == 1))
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }
//Check whether a given string is a palindrome or not
    public static boolean isPalindrome(String str) {
        //Base case if the string has length 0 or 1, it is a palindrome
        if (str.length() <= 1) {
            return true;
        }
    //Get the first and last characters of the string
    char first = str.charAt(0);
    char last = str.charAt(str.length() - 1);
    //If the first and last characters are equal, recursively check whether the substring between them is also a palindrome
        if (first == last) {
            return isPalindrome(str.substring(1, str.length() - 1));
        } else {
            //If the first and last characters are not equal, the string is not a palindrome
            return false;
        }
    }
    public static int nextIsDouble(int[] arr, int index) {
        if (index >= arr.length - 1) {
            return 0;
        }
        if (arr[index] * 2 == arr[index + 1]) {
            return 1 + nextIsDouble(arr, index + 1);
        } else {
            return nextIsDouble(arr, index + 1);
        }   
    }
//Returns the number of times the value at the current index is twice the value at the next index in the given integer array
    public static String getBinary(int n) {
        //Base case index is at the last element of the array or beyond
        if (n == 0) {
            return "0";
        }
        //Recursive case checks if the value at the current index is twice the value at the next
        if (n == 1) {
            return "1";
        }
        if (n % 2 == 0) {
            return getBinary(n / 2) + "0";
        } else {
            return getBinary(n / 2) + "1";
        }
    }
//Binary search to find value 
    public static int binarySearch(int[] arr, int value, int low, int high) {
        if (low > high) {
            return -1; // Value not found
        }
        int mid = (low + high) / 2;
        if (arr[mid] == value) {
            return mid; // Value found
        } else if (arr[mid] < value) {
            return binarySearch(arr, value, mid + 1, high); // Search in right half
        } else {
            return binarySearch(arr, value, low, mid - 1); // Search in left half
        }
    }
//Checks if current cell can flow off map 
    public static boolean canFlowOffMap(int[][] map, int row, int col) {
        // Check if the current cell is on the border of the map
        if (row == 0 || row == map.length - 1 || col == 0 || col == map[0].length - 1) {
            return true;
        }
        
        // Check if the current cell can flow to any adjacent cell with a lower elevation
        int currElevation = map[row][col];
        if (row > 0 && map[row-1][col] < currElevation && canFlowOffMap(map, row-1, col)) {
            return true;
        }
        if (row < map.length - 1 && map[row+1][col] < currElevation && canFlowOffMap(map, row+1, col)) {
            return true;
        }
        if (col > 0 && map[row][col-1] < currElevation && canFlowOffMap(map, row, col-1)) {
            return true;
        }
        if (col < map[0].length - 1 && map[row][col+1] < currElevation && canFlowOffMap(map, row, col+1)) {
            return true;
        }
        
        // If the current cell cannot flow to any adjacent cell with a lower elevation
        // or reach the border, it cannot flow off the map
        return false;
    }
}
