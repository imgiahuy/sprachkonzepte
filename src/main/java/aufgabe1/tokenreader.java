package aufgabe1;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import java.io.*;

public class tokenreader {
    public static void main(String[] args) throws IOException {
        // Text aus Datei lesen
        String text = readFile("src/main/java/aufgabe1/gleiche-art.txt");

        // CharStream erstellen
        CharStream input = CharStreams.fromString(text);

        // Lexer erstellen
        rules lexer = new rules(input);

        // Tokens ausgeben
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();

        // Tokenfolge ausgeben
        for (Token token : tokens.getTokens()) {
            String tokenName = rules.VOCABULARY.getSymbolicName(token.getType());
            String tokenText = token.getText();

            if (token.getType() != Token.EOF) {
                System.out.println(tokenName + "('" + tokenText + "')");
            }
        }
    }

    private static String readFile(String path) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}
