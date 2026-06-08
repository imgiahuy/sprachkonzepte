// Generated from C:/sem7/SPR-KZ/SPRKZ/src/main/java/aufgabe2/aufgabe2a/bestellungsparser.g4 by ANTLR 4.13.2
package gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link bestellungsparser}.
 */
public interface bestellungsparserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link bestellungsparser#bestellung}.
	 * @param ctx the parse tree
	 */
	void enterBestellung(bestellungsparser.BestellungContext ctx);
	/**
	 * Exit a parse tree produced by {@link bestellungsparser#bestellung}.
	 * @param ctx the parse tree
	 */
	void exitBestellung(bestellungsparser.BestellungContext ctx);
	/**
	 * Enter a parse tree produced by {@link bestellungsparser#tischInfo}.
	 * @param ctx the parse tree
	 */
	void enterTischInfo(bestellungsparser.TischInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link bestellungsparser#tischInfo}.
	 * @param ctx the parse tree
	 */
	void exitTischInfo(bestellungsparser.TischInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link bestellungsparser#kind}.
	 * @param ctx the parse tree
	 */
	void enterKind(bestellungsparser.KindContext ctx);
	/**
	 * Exit a parse tree produced by {@link bestellungsparser#kind}.
	 * @param ctx the parse tree
	 */
	void exitKind(bestellungsparser.KindContext ctx);
	/**
	 * Enter a parse tree produced by {@link bestellungsparser#bestellungsdetails}.
	 * @param ctx the parse tree
	 */
	void enterBestellungsdetails(bestellungsparser.BestellungsdetailsContext ctx);
	/**
	 * Exit a parse tree produced by {@link bestellungsparser#bestellungsdetails}.
	 * @param ctx the parse tree
	 */
	void exitBestellungsdetails(bestellungsparser.BestellungsdetailsContext ctx);
	/**
	 * Enter a parse tree produced by {@link bestellungsparser#gericht}.
	 * @param ctx the parse tree
	 */
	void enterGericht(bestellungsparser.GerichtContext ctx);
	/**
	 * Exit a parse tree produced by {@link bestellungsparser#gericht}.
	 * @param ctx the parse tree
	 */
	void exitGericht(bestellungsparser.GerichtContext ctx);
	/**
	 * Enter a parse tree produced by {@link bestellungsparser#sauce}.
	 * @param ctx the parse tree
	 */
	void enterSauce(bestellungsparser.SauceContext ctx);
	/**
	 * Exit a parse tree produced by {@link bestellungsparser#sauce}.
	 * @param ctx the parse tree
	 */
	void exitSauce(bestellungsparser.SauceContext ctx);
	/**
	 * Enter a parse tree produced by {@link bestellungsparser#gebraten}.
	 * @param ctx the parse tree
	 */
	void enterGebraten(bestellungsparser.GebratenContext ctx);
	/**
	 * Exit a parse tree produced by {@link bestellungsparser#gebraten}.
	 * @param ctx the parse tree
	 */
	void exitGebraten(bestellungsparser.GebratenContext ctx);
	/**
	 * Enter a parse tree produced by {@link bestellungsparser#fleisch}.
	 * @param ctx the parse tree
	 */
	void enterFleisch(bestellungsparser.FleischContext ctx);
	/**
	 * Exit a parse tree produced by {@link bestellungsparser#fleisch}.
	 * @param ctx the parse tree
	 */
	void exitFleisch(bestellungsparser.FleischContext ctx);
	/**
	 * Enter a parse tree produced by {@link bestellungsparser#beilage}.
	 * @param ctx the parse tree
	 */
	void enterBeilage(bestellungsparser.BeilageContext ctx);
	/**
	 * Exit a parse tree produced by {@link bestellungsparser#beilage}.
	 * @param ctx the parse tree
	 */
	void exitBeilage(bestellungsparser.BeilageContext ctx);
	/**
	 * Enter a parse tree produced by {@link bestellungsparser#box}.
	 * @param ctx the parse tree
	 */
	void enterBox(bestellungsparser.BoxContext ctx);
	/**
	 * Exit a parse tree produced by {@link bestellungsparser#box}.
	 * @param ctx the parse tree
	 */
	void exitBox(bestellungsparser.BoxContext ctx);
	/**
	 * Enter a parse tree produced by {@link bestellungsparser#abholung}.
	 * @param ctx the parse tree
	 */
	void enterAbholung(bestellungsparser.AbholungContext ctx);
	/**
	 * Exit a parse tree produced by {@link bestellungsparser#abholung}.
	 * @param ctx the parse tree
	 */
	void exitAbholung(bestellungsparser.AbholungContext ctx);
	/**
	 * Enter a parse tree produced by {@link bestellungsparser#anmerkung}.
	 * @param ctx the parse tree
	 */
	void enterAnmerkung(bestellungsparser.AnmerkungContext ctx);
	/**
	 * Exit a parse tree produced by {@link bestellungsparser#anmerkung}.
	 * @param ctx the parse tree
	 */
	void exitAnmerkung(bestellungsparser.AnmerkungContext ctx);
}