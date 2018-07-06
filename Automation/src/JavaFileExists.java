import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JavaFileExists
{
  public JavaFileExists() {}
  
  public static void main(String[] args) throws IOException, FileNotFoundException
  {
    try
    {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter File Path:");
      String input = scanner.nextLine();
      
      File file = new File(input);
      boolean success = file.exists();
      if (success) {
        System.out.println("The file exists");
        reader(file);
      }
      reader(file);
      scanner.close();
    } catch (java.io.FileNotFoundException e) {
      System.out.println("The file does not exist.");
    }
  }
  
private static void reader(File file) throws java.io.IOException
  {
    BufferedReader reader = null;
    
    reader = new BufferedReader(new FileReader(file));
    String inputLine = null;
    while((inputLine = reader.readLine()) != null)
    {
      String[] words = inputLine.split("-");
      for(String word: words) {
      word = word.replace("-", "\n");
      word = word.replace(",", "\n");
      System.out.println(word);
    }
  }
  reader.close();

  }
}
