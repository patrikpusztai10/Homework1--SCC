package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static char encrypt(char character, int k) {

        return (char)((character+k)%256);

    }

    public static char decrypt(char character, int k) {
        return (char)((character-k)%256);
    }

    public static void main(String[] args) {

        if(args.length!=7) {
            System.out.println("Usage");
            return;
        }
        String operation="";
        String input_filename="";
        String output_filename="";
        int k=0;
        for(int i=0;i<args.length;i++)
        {
            if(args[i].equals("-e") || args[i].equals("-d"))
            {
                operation=args[i];
                input_filename=args[i+1];

            }
            if(args[i].equals("-o"))
            {
                output_filename=args[i+1];
            }
            if(args[i].equals("-k"))
            {

                k=Integer.parseInt(args[i+1]);
            }
        }
        String input_path="C:\\Users\\Patrik P\\IdeaProjects\\SCC_Homework_1\\src\\main\\java\\org\\example\\"+input_filename;
        File input = new File(input_path);
        String output_path="C:\\Users\\Patrik P\\IdeaProjects\\SCC_Homework_1\\src\\main\\java\\org\\example\\"+output_filename;

        if (args[0].equals("app")) {
            try (Scanner reader = new Scanner(input)) {
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    StringBuilder modified_line = new StringBuilder();
                    for (int i = 0; i < line.length(); i++) {
                        char init_char = line.charAt(i);
                        if(operation.equals("-e"))
                            modified_line.append(encrypt(init_char, k));
                        if(operation.equals("-d"))
                            modified_line.append(decrypt(init_char, k));
                    }
                    try {
                        FileWriter writer = new FileWriter(output_path,true);
                        writer.write(modified_line.toString() +'\n');
                        writer.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        throw new RuntimeException(e);
                    }

                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                throw new RuntimeException(e);
            }

        }
        else{
            System.out.println("No <<app>> argument received");
        }
    }
}