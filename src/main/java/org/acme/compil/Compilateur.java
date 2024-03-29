package org.acme.compil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class Compilateur {

    public static void main(String... args) {

        Logger logger = Logger.getLogger(Compilateur.class.getName());

        String absolutePath = Paths.get(".").toAbsolutePath().normalize().toString();
        absolutePath += "\\src\\main\\java\\org\\acme\\";

        String inputFileName = "compiler.vroumvroum";
        String outputFileName = "Compile.java";
        String inputFilePath = absolutePath + inputFileName;
        String outputFilePath = absolutePath + outputFileName;
        String beginning = """
            package org.acme;

            public class Compile {
                int positionX = 0;
                int positionY = 0;

                public void move(String direction) {
                    switch (direction) {
        """;

        String ending = """
            default:
                System.out.println("Mauvaise direction");
                break;
          }
        }
        }
        """;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            writer.write(beginning);
            reader.lines().forEach(line -> {
                try {
                    compileLine(line, writer);
                } catch (IOException e) {
                    logger.info("Erreur lors de la compilation : " + e.getMessage());
                }
            });
            writer.write(ending);

        } catch (IOException e) {
            logger.info("Erreur lors de la compilation : " + e.getMessage());
        }
    }

    public static void compileLine(String line, BufferedWriter writer) throws IOException {
        String[] words = line.split(" ");
        String key = words[0];
        String instruction = "";
        switch (key) {
            case "droite":
                instruction = "case \"droite\":\npositionX = positionX + 1;\nbreak;\n";
                break;
            case "gauche":
                instruction = "case \"gauche\":\npositionX = positionX - 1;\nbreak;\n";
                break;
            case "haut":
                instruction = "case \"haut\":\npositionY = positionY - 1;\nbreak;\n";
                break;
            case "bas":
                instruction = "case \"bas\":\npositionY = positionY + 1;\nbreak;\n";
                break;
            default:
                break;
        }
        writer.write(instruction);
    }
}
