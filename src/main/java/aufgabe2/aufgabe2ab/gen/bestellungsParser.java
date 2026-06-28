// Generated from C:/sem7/SPR/sprachkonzepte/src/main/java/aufgabe2/aufgabe2ab/bestellungsParser.g4 by ANTLR 4.13.2
package aufgabe2.aufgabe2ab.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class bestellungsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KOMMA=1, PUNKT=2, DOPPELPUNKT=3, TISCH=4, NOTE=5, ABHOLUNG=6, KIND=7, 
		BOX=8, SAUCE=9, GEBRATEN=10, BEILAGE=11, FLEISCH=12, QUANTITY=13, NUMMER=14, 
		TIME=15, UHR=16, WORD=17, WS=18;
	public static final int
		RULE_bestellung = 0, RULE_tischInfo = 1, RULE_kind = 2, RULE_bestellungsdetails = 3, 
		RULE_gericht = 4, RULE_sauce = 5, RULE_gebraten = 6, RULE_fleisch = 7, 
		RULE_beilage = 8, RULE_box = 9, RULE_abholung = 10, RULE_anmerkung = 11, 
		RULE_itemAnmerkung = 12, RULE_text = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"bestellung", "tischInfo", "kind", "bestellungsdetails", "gericht", "sauce", 
			"gebraten", "fleisch", "beilage", "box", "abholung", "anmerkung", "itemAnmerkung", 
			"text"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'.'", "':'", null, "'Anmerkung'", "'Abholung'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KOMMA", "PUNKT", "DOPPELPUNKT", "TISCH", "NOTE", "ABHOLUNG", "KIND", 
			"BOX", "SAUCE", "GEBRATEN", "BEILAGE", "FLEISCH", "QUANTITY", "NUMMER", 
			"TIME", "UHR", "WORD", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "bestellungsParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public bestellungsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BestellungContext extends ParserRuleContext {
		public TischInfoContext tischInfo() {
			return getRuleContext(TischInfoContext.class,0);
		}
		public List<TerminalNode> KOMMA() { return getTokens(bestellungsParser.KOMMA); }
		public TerminalNode KOMMA(int i) {
			return getToken(bestellungsParser.KOMMA, i);
		}
		public KindContext kind() {
			return getRuleContext(KindContext.class,0);
		}
		public List<BestellungsdetailsContext> bestellungsdetails() {
			return getRuleContexts(BestellungsdetailsContext.class);
		}
		public BestellungsdetailsContext bestellungsdetails(int i) {
			return getRuleContext(BestellungsdetailsContext.class,i);
		}
		public TerminalNode PUNKT() { return getToken(bestellungsParser.PUNKT, 0); }
		public BoxContext box() {
			return getRuleContext(BoxContext.class,0);
		}
		public AbholungContext abholung() {
			return getRuleContext(AbholungContext.class,0);
		}
		public AnmerkungContext anmerkung() {
			return getRuleContext(AnmerkungContext.class,0);
		}
		public BestellungContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bestellung; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).enterBestellung(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).exitBestellung(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsParserVisitor ) return ((bestellungsParserVisitor<? extends T>)visitor).visitBestellung(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BestellungContext bestellung() throws RecognitionException {
		BestellungContext _localctx = new BestellungContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_bestellung);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			tischInfo();
			setState(29);
			match(KOMMA);
			setState(30);
			kind();
			setState(31);
			match(KOMMA);
			setState(32);
			bestellungsdetails();
			setState(37);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(33);
					match(KOMMA);
					setState(34);
					bestellungsdetails();
					}
					} 
				}
				setState(39);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(40);
				match(KOMMA);
				setState(41);
				box();
				}
				break;
			}
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(44);
				match(KOMMA);
				setState(45);
				abholung();
				}
				break;
			}
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KOMMA) {
				{
				setState(48);
				match(KOMMA);
				setState(49);
				anmerkung();
				}
			}

			setState(52);
			match(PUNKT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TischInfoContext extends ParserRuleContext {
		public TerminalNode TISCH() { return getToken(bestellungsParser.TISCH, 0); }
		public TerminalNode NUMMER() { return getToken(bestellungsParser.NUMMER, 0); }
		public TischInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tischInfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).enterTischInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).exitTischInfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsParserVisitor ) return ((bestellungsParserVisitor<? extends T>)visitor).visitTischInfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TischInfoContext tischInfo() throws RecognitionException {
		TischInfoContext _localctx = new TischInfoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_tischInfo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(TISCH);
			setState(55);
			match(NUMMER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KindContext extends ParserRuleContext {
		public TerminalNode KIND() { return getToken(bestellungsParser.KIND, 0); }
		public KindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).enterKind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).exitKind(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsParserVisitor ) return ((bestellungsParserVisitor<? extends T>)visitor).visitKind(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KindContext kind() throws RecognitionException {
		KindContext _localctx = new KindContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_kind);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(KIND);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BestellungsdetailsContext extends ParserRuleContext {
		public TerminalNode QUANTITY() { return getToken(bestellungsParser.QUANTITY, 0); }
		public GerichtContext gericht() {
			return getRuleContext(GerichtContext.class,0);
		}
		public ItemAnmerkungContext itemAnmerkung() {
			return getRuleContext(ItemAnmerkungContext.class,0);
		}
		public BestellungsdetailsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bestellungsdetails; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).enterBestellungsdetails(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).exitBestellungsdetails(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsParserVisitor ) return ((bestellungsParserVisitor<? extends T>)visitor).visitBestellungsdetails(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BestellungsdetailsContext bestellungsdetails() throws RecognitionException {
		BestellungsdetailsContext _localctx = new BestellungsdetailsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_bestellungsdetails);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(QUANTITY);
			setState(60);
			gericht();
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOTE) {
				{
				setState(61);
				itemAnmerkung();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GerichtContext extends ParserRuleContext {
		public SauceContext sauce() {
			return getRuleContext(SauceContext.class,0);
		}
		public FleischContext fleisch() {
			return getRuleContext(FleischContext.class,0);
		}
		public GebratenContext gebraten() {
			return getRuleContext(GebratenContext.class,0);
		}
		public BeilageContext beilage() {
			return getRuleContext(BeilageContext.class,0);
		}
		public GerichtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gericht; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).enterGericht(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).exitGericht(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsParserVisitor ) return ((bestellungsParserVisitor<? extends T>)visitor).visitGericht(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GerichtContext gericht() throws RecognitionException {
		GerichtContext _localctx = new GerichtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_gericht);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SAUCE:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				sauce();
				setState(65);
				fleisch();
				}
				break;
			case GEBRATEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				gebraten();
				setState(68);
				fleisch();
				}
				break;
			case BEILAGE:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				beilage();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SauceContext extends ParserRuleContext {
		public TerminalNode SAUCE() { return getToken(bestellungsParser.SAUCE, 0); }
		public SauceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sauce; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).enterSauce(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).exitSauce(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsParserVisitor ) return ((bestellungsParserVisitor<? extends T>)visitor).visitSauce(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SauceContext sauce() throws RecognitionException {
		SauceContext _localctx = new SauceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sauce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(SAUCE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GebratenContext extends ParserRuleContext {
		public TerminalNode GEBRATEN() { return getToken(bestellungsParser.GEBRATEN, 0); }
		public GebratenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gebraten; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).enterGebraten(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).exitGebraten(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsParserVisitor ) return ((bestellungsParserVisitor<? extends T>)visitor).visitGebraten(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GebratenContext gebraten() throws RecognitionException {
		GebratenContext _localctx = new GebratenContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_gebraten);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(GEBRATEN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FleischContext extends ParserRuleContext {
		public TerminalNode FLEISCH() { return getToken(bestellungsParser.FLEISCH, 0); }
		public FleischContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fleisch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).enterFleisch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).exitFleisch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsParserVisitor ) return ((bestellungsParserVisitor<? extends T>)visitor).visitFleisch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FleischContext fleisch() throws RecognitionException {
		FleischContext _localctx = new FleischContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fleisch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(FLEISCH);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BeilageContext extends ParserRuleContext {
		public TerminalNode BEILAGE() { return getToken(bestellungsParser.BEILAGE, 0); }
		public BeilageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beilage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).enterBeilage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).exitBeilage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsParserVisitor ) return ((bestellungsParserVisitor<? extends T>)visitor).visitBeilage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeilageContext beilage() throws RecognitionException {
		BeilageContext _localctx = new BeilageContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_beilage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(BEILAGE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoxContext extends ParserRuleContext {
		public TerminalNode BOX() { return getToken(bestellungsParser.BOX, 0); }
		public TerminalNode QUANTITY() { return getToken(bestellungsParser.QUANTITY, 0); }
		public BoxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_box; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).enterBox(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).exitBox(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsParserVisitor ) return ((bestellungsParserVisitor<? extends T>)visitor).visitBox(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoxContext box() throws RecognitionException {
		BoxContext _localctx = new BoxContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_box);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUANTITY) {
				{
				setState(81);
				match(QUANTITY);
				}
			}

			setState(84);
			match(BOX);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AbholungContext extends ParserRuleContext {
		public TerminalNode ABHOLUNG() { return getToken(bestellungsParser.ABHOLUNG, 0); }
		public TerminalNode DOPPELPUNKT() { return getToken(bestellungsParser.DOPPELPUNKT, 0); }
		public TerminalNode TIME() { return getToken(bestellungsParser.TIME, 0); }
		public TerminalNode UHR() { return getToken(bestellungsParser.UHR, 0); }
		public AbholungContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abholung; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).enterAbholung(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).exitAbholung(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsParserVisitor ) return ((bestellungsParserVisitor<? extends T>)visitor).visitAbholung(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbholungContext abholung() throws RecognitionException {
		AbholungContext _localctx = new AbholungContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_abholung);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(ABHOLUNG);
			setState(87);
			match(DOPPELPUNKT);
			setState(88);
			match(TIME);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UHR) {
				{
				setState(89);
				match(UHR);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnmerkungContext extends ParserRuleContext {
		public TerminalNode NOTE() { return getToken(bestellungsParser.NOTE, 0); }
		public TerminalNode DOPPELPUNKT() { return getToken(bestellungsParser.DOPPELPUNKT, 0); }
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public AnmerkungContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anmerkung; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).enterAnmerkung(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).exitAnmerkung(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsParserVisitor ) return ((bestellungsParserVisitor<? extends T>)visitor).visitAnmerkung(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnmerkungContext anmerkung() throws RecognitionException {
		AnmerkungContext _localctx = new AnmerkungContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_anmerkung);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(NOTE);
			setState(93);
			match(DOPPELPUNKT);
			setState(94);
			text();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ItemAnmerkungContext extends ParserRuleContext {
		public TerminalNode NOTE() { return getToken(bestellungsParser.NOTE, 0); }
		public TerminalNode DOPPELPUNKT() { return getToken(bestellungsParser.DOPPELPUNKT, 0); }
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public ItemAnmerkungContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_itemAnmerkung; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).enterItemAnmerkung(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).exitItemAnmerkung(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsParserVisitor ) return ((bestellungsParserVisitor<? extends T>)visitor).visitItemAnmerkung(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemAnmerkungContext itemAnmerkung() throws RecognitionException {
		ItemAnmerkungContext _localctx = new ItemAnmerkungContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_itemAnmerkung);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(NOTE);
			setState(97);
			match(DOPPELPUNKT);
			setState(98);
			text();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TextContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(bestellungsParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(bestellungsParser.WORD, i);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsParserListener ) ((bestellungsParserListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsParserVisitor ) return ((bestellungsParserVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(WORD);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WORD) {
				{
				{
				setState(101);
				match(WORD);
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0012l\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000$\b\u0000\n\u0000\f\u0000"+
		"\'\t\u0000\u0001\u0000\u0001\u0000\u0003\u0000+\b\u0000\u0001\u0000\u0001"+
		"\u0000\u0003\u0000/\b\u0000\u0001\u0000\u0001\u0000\u0003\u00003\b\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003?\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004H\b\u0004\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0003\tS"+
		"\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n[\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0005\rg\b\r\n\r\f\rj\t\r\u0001\r\u0000\u0000\u000e"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u0000\u0000g\u0000\u001c\u0001\u0000\u0000\u0000\u00026\u0001\u0000\u0000"+
		"\u0000\u00049\u0001\u0000\u0000\u0000\u0006;\u0001\u0000\u0000\u0000\b"+
		"G\u0001\u0000\u0000\u0000\nI\u0001\u0000\u0000\u0000\fK\u0001\u0000\u0000"+
		"\u0000\u000eM\u0001\u0000\u0000\u0000\u0010O\u0001\u0000\u0000\u0000\u0012"+
		"R\u0001\u0000\u0000\u0000\u0014V\u0001\u0000\u0000\u0000\u0016\\\u0001"+
		"\u0000\u0000\u0000\u0018`\u0001\u0000\u0000\u0000\u001ad\u0001\u0000\u0000"+
		"\u0000\u001c\u001d\u0003\u0002\u0001\u0000\u001d\u001e\u0005\u0001\u0000"+
		"\u0000\u001e\u001f\u0003\u0004\u0002\u0000\u001f \u0005\u0001\u0000\u0000"+
		" %\u0003\u0006\u0003\u0000!\"\u0005\u0001\u0000\u0000\"$\u0003\u0006\u0003"+
		"\u0000#!\u0001\u0000\u0000\u0000$\'\u0001\u0000\u0000\u0000%#\u0001\u0000"+
		"\u0000\u0000%&\u0001\u0000\u0000\u0000&*\u0001\u0000\u0000\u0000\'%\u0001"+
		"\u0000\u0000\u0000()\u0005\u0001\u0000\u0000)+\u0003\u0012\t\u0000*(\u0001"+
		"\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+.\u0001\u0000\u0000\u0000"+
		",-\u0005\u0001\u0000\u0000-/\u0003\u0014\n\u0000.,\u0001\u0000\u0000\u0000"+
		"./\u0001\u0000\u0000\u0000/2\u0001\u0000\u0000\u000001\u0005\u0001\u0000"+
		"\u000013\u0003\u0016\u000b\u000020\u0001\u0000\u0000\u000023\u0001\u0000"+
		"\u0000\u000034\u0001\u0000\u0000\u000045\u0005\u0002\u0000\u00005\u0001"+
		"\u0001\u0000\u0000\u000067\u0005\u0004\u0000\u000078\u0005\u000e\u0000"+
		"\u00008\u0003\u0001\u0000\u0000\u00009:\u0005\u0007\u0000\u0000:\u0005"+
		"\u0001\u0000\u0000\u0000;<\u0005\r\u0000\u0000<>\u0003\b\u0004\u0000="+
		"?\u0003\u0018\f\u0000>=\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000"+
		"?\u0007\u0001\u0000\u0000\u0000@A\u0003\n\u0005\u0000AB\u0003\u000e\u0007"+
		"\u0000BH\u0001\u0000\u0000\u0000CD\u0003\f\u0006\u0000DE\u0003\u000e\u0007"+
		"\u0000EH\u0001\u0000\u0000\u0000FH\u0003\u0010\b\u0000G@\u0001\u0000\u0000"+
		"\u0000GC\u0001\u0000\u0000\u0000GF\u0001\u0000\u0000\u0000H\t\u0001\u0000"+
		"\u0000\u0000IJ\u0005\t\u0000\u0000J\u000b\u0001\u0000\u0000\u0000KL\u0005"+
		"\n\u0000\u0000L\r\u0001\u0000\u0000\u0000MN\u0005\f\u0000\u0000N\u000f"+
		"\u0001\u0000\u0000\u0000OP\u0005\u000b\u0000\u0000P\u0011\u0001\u0000"+
		"\u0000\u0000QS\u0005\r\u0000\u0000RQ\u0001\u0000\u0000\u0000RS\u0001\u0000"+
		"\u0000\u0000ST\u0001\u0000\u0000\u0000TU\u0005\b\u0000\u0000U\u0013\u0001"+
		"\u0000\u0000\u0000VW\u0005\u0006\u0000\u0000WX\u0005\u0003\u0000\u0000"+
		"XZ\u0005\u000f\u0000\u0000Y[\u0005\u0010\u0000\u0000ZY\u0001\u0000\u0000"+
		"\u0000Z[\u0001\u0000\u0000\u0000[\u0015\u0001\u0000\u0000\u0000\\]\u0005"+
		"\u0005\u0000\u0000]^\u0005\u0003\u0000\u0000^_\u0003\u001a\r\u0000_\u0017"+
		"\u0001\u0000\u0000\u0000`a\u0005\u0005\u0000\u0000ab\u0005\u0003\u0000"+
		"\u0000bc\u0003\u001a\r\u0000c\u0019\u0001\u0000\u0000\u0000dh\u0005\u0011"+
		"\u0000\u0000eg\u0005\u0011\u0000\u0000fe\u0001\u0000\u0000\u0000gj\u0001"+
		"\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000"+
		"i\u001b\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000\t%*.2>GRZh";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}