package aufgabe2.aufgabe2ab.ast;

/**
 * Basisklasse für alle AST-Knoten
 */
public abstract class ASTNode {
    @Override
    public abstract String toString();

    public abstract void accept(ASTVisitor visitor);
}

