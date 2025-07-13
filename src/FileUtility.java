import java.io.*;
import java.util.Scanner;

public class FileUtility 
{

    static Scanner scanner = new Scanner(System.in);

    public static void writeFile(String fileName) throws IOException 
    {
        FileWriter writer = new FileWriter(fileName);
        System.out.println("Enter text (type 'exit' to stop):");
        String line;
        while (!(line = scanner.nextLine()).equalsIgnoreCase("exit")) 
        {
            writer.write(line + "\n");
        }
        writer.close();
        System.out.println("Written successfully.");
    }

    public static void readFile(String fileName) throws IOException 
    {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        System.out.println("File content:");
        while ((line = reader.readLine()) != null) 
        {
            System.out.println(line);
        }
        reader.close();
    }

    public static void modifyFile(String fileName) throws IOException 
    {
        FileWriter writer = new FileWriter(fileName, true); 
        System.out.println("Enter text to append (type 'exit' to stop):");
        String line;
        while (!(line = scanner.nextLine()).equalsIgnoreCase("exit")) 
        {
            writer.write(line + "\n");
        }
        writer.close();
        System.out.println("Modified successfully.");
    }

    public static void main(String[] args) 
    {
        try 
        {
            System.out.print("Enter file name (with .txt): ");
            String fileName = scanner.nextLine();

            System.out.println("Choose operation:");
            System.out.println("1. Write");
            System.out.println("2. Read");
            System.out.println("3. Modify");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) 
            {
                case 1 -> writeFile(fileName);
                case 2 -> readFile(fileName);
                case 3 -> modifyFile(fileName);
                default -> System.out.println("Invalid choice.");
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
