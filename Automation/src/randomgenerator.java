import java.util.Arrays;
import java.util.Scanner;
public class randomgenerator {
		  
		  public static int nthSmallest(int[] arr, int n) {
		    Arrays.sort(arr);
		    System.out.println("Array length " + arr.length);
		    System.out.println("Sorted Array " + Arrays.toString(arr));
		    
		    return arr[(n - 1)];
		  }
		  
		  public static void main(String[] args) {
		    int[] numbers = new int[500];
		    
		    for (int i = 0; i < numbers.length; i++) {
		      numbers[i] = ((int)(Math.random() * 1000 + 1));
		    }
		    System.out.println("Numbers Generated: " + Arrays.toString(numbers) + "\n");
		    Scanner scanner = new Scanner(System.in);
		    System.out.println("Enter nth smallest element");
		    String input = scanner.nextLine();
		    int k = Integer.parseInt(input);
		    scanner.close();
		    System.out.print(k + "'th smallest element is " + nthSmallest(numbers, k));
		  }
		}


