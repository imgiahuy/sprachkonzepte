// Generated from C:/sem7/SPR-KZ/SPRKZ/src/main/java/aufgabe2/aufgabe2a/bestellungsparser.g4 by ANTLR 4.13.2
package gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link bestellungsparser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface bestellungsparserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link bestellungsparser#bestellung}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBestellung(bestellungsparser.BestellungContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsparser#tischInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTischInfo(bestellungsparser.TischInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsparser#kind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKind(bestellungsparser.KindContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsparser#bestellungsdetails}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBestellungsdetails(bestellungsparser.BestellungsdetailsContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsparser#gericht}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGericht(bestellungsparser.GerichtContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsparser#sauce}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSauce(bestellungsparser.SauceContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsparser#gebraten}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGebraten(bestellungsparser.GebratenContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsparser#fleisch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFleisch(bestellungsparser.FleischContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsparser#beilage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeilage(bestellungsparser.BeilageContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsparser#box}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBox(bestellungsparser.BoxContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsparser#abholung}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbholung(bestellungsparser.AbholungContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsparser#anmerkung}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnmerkung(bestellungsparser.AnmerkungContext ctx);
}