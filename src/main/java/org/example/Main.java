package org.example;
import aufgabe1.rules;
import org.antlr.v4.runtime.*;

public class Main {

    public static void main(String[] args) throws Exception {

        CharStream input =
                CharStreams.fromStream(
                        new java.io.FileInputStream("C:\\sem7\\SPR-KZ\\SPRKZ\\src\\main\\resources\\mainau-gatronomie.txt"),
                        java.nio.charset.StandardCharsets.UTF_8
                );
        rules lexer = new rules(input);

        Token token;

        while ((token = lexer.nextToken()).getType() != Token.EOF) {

            String tokenName =
                    lexer.getVocabulary()
                            .getSymbolicName(token.getType());

            System.out.println(
                    tokenName + " -> " + token.getText()
            );
        }
    }
}