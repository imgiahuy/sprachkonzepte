// Generated from C:/sem7/SPR/sprachkonzepte/src/main/java/aufgabe2/aufgabe2ab/bestellungsParser.g4 by ANTLR 4.13.2
package aufgabe2.aufgabe2ab.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link bestellungsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface bestellungsParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link bestellungsParser#bestellung}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBestellung(bestellungsParser.BestellungContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsParser#tischInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTischInfo(bestellungsParser.TischInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsParser#kind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKind(bestellungsParser.KindContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsParser#bestellungsdetails}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBestellungsdetails(bestellungsParser.BestellungsdetailsContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsParser#gericht}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGericht(bestellungsParser.GerichtContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsParser#sauce}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSauce(bestellungsParser.SauceContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsParser#gebraten}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGebraten(bestellungsParser.GebratenContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsParser#fleisch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFleisch(bestellungsParser.FleischContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsParser#beilage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeilage(bestellungsParser.BeilageContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsParser#box}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBox(bestellungsParser.BoxContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsParser#abholung}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbholung(bestellungsParser.AbholungContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsParser#anmerkung}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnmerkung(bestellungsParser.AnmerkungContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsParser#itemAnmerkung}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItemAnmerkung(bestellungsParser.ItemAnmerkungContext ctx);
	/**
	 * Visit a parse tree produced by {@link bestellungsParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(bestellungsParser.TextContext ctx);
}