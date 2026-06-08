// Generated from C:/sem7/SPR-KZ/SPRKZ/src/main/java/aufgabe2/aufgabe2a/bestellungsparser.g4 by ANTLR 4.13.2
package gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class bestellungsparser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KOMMA=1, PUNKT=2, DOPPELPUNKT=3, TISCH=4, NOTE=5, ABHOLUNG=6, KIND=7, 
		BOX=8, UHR=9, SAUCE=10, GEBRATEN=11, BEILAGE=12, FLEISCH=13, NUMMER=14, 
		QUANTITY=15, TIME=16, BESCHREIBUNG=17, WS=18;
	public static final int
		RULE_bestellung = 0, RULE_tischInfo = 1, RULE_kind = 2, RULE_bestellungsdetails = 3, 
		RULE_gericht = 4, RULE_sauce = 5, RULE_gebraten = 6, RULE_fleisch = 7, 
		RULE_beilage = 8, RULE_box = 9, RULE_abholung = 10, RULE_anmerkung = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"bestellung", "tischInfo", "kind", "bestellungsdetails", "gericht", "sauce", 
			"gebraten", "fleisch", "beilage", "box", "abholung", "anmerkung"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'.'", "':'", null, "'Anmerkung'", "'Abholung'", null, null, 
			"'Uhr'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KOMMA", "PUNKT", "DOPPELPUNKT", "TISCH", "NOTE", "ABHOLUNG", "KIND", 
			"BOX", "UHR", "SAUCE", "GEBRATEN", "BEILAGE", "FLEISCH", "NUMMER", "QUANTITY", 
			"TIME", "BESCHREIBUNG", "WS"
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
	public String getGrammarFileName() { return "bestellungsparser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public bestellungsparser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BestellungContext extends ParserRuleContext {
		public TischInfoContext tischInfo() {
			return getRuleContext(TischInfoContext.class,0);
		}
		public List<TerminalNode> KOMMA() { return getTokens(bestellungsparser.KOMMA); }
		public TerminalNode KOMMA(int i) {
			return getToken(bestellungsparser.KOMMA, i);
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
		public BoxContext box() {
			return getRuleContext(BoxContext.class,0);
		}
		public TerminalNode PUNKT() { return getToken(bestellungsparser.PUNKT, 0); }
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
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).enterBestellung(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).exitBestellung(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsparserVisitor ) return ((bestellungsparserVisitor<? extends T>)visitor).visitBestellung(this);
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
			setState(24);
			tischInfo();
			setState(25);
			match(KOMMA);
			setState(26);
			kind();
			setState(27);
			match(KOMMA);
			setState(28);
			bestellungsdetails();
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(29);
					match(KOMMA);
					setState(30);
					bestellungsdetails();
					}
					} 
				}
				setState(35);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(36);
			match(KOMMA);
			setState(37);
			box();
			setState(40);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(38);
				match(KOMMA);
				setState(39);
				abholung();
				}
				break;
			}
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KOMMA) {
				{
				setState(42);
				match(KOMMA);
				setState(43);
				anmerkung();
				}
			}

			setState(46);
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
		public TerminalNode TISCH() { return getToken(bestellungsparser.TISCH, 0); }
		public TerminalNode NUMMER() { return getToken(bestellungsparser.NUMMER, 0); }
		public TischInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tischInfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).enterTischInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).exitTischInfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsparserVisitor ) return ((bestellungsparserVisitor<? extends T>)visitor).visitTischInfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TischInfoContext tischInfo() throws RecognitionException {
		TischInfoContext _localctx = new TischInfoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_tischInfo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(TISCH);
			setState(49);
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
		public TerminalNode KIND() { return getToken(bestellungsparser.KIND, 0); }
		public KindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).enterKind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).exitKind(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsparserVisitor ) return ((bestellungsparserVisitor<? extends T>)visitor).visitKind(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KindContext kind() throws RecognitionException {
		KindContext _localctx = new KindContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_kind);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
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
		public TerminalNode QUANTITY() { return getToken(bestellungsparser.QUANTITY, 0); }
		public GerichtContext gericht() {
			return getRuleContext(GerichtContext.class,0);
		}
		public AnmerkungContext anmerkung() {
			return getRuleContext(AnmerkungContext.class,0);
		}
		public BestellungsdetailsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bestellungsdetails; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).enterBestellungsdetails(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).exitBestellungsdetails(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsparserVisitor ) return ((bestellungsparserVisitor<? extends T>)visitor).visitBestellungsdetails(this);
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
			setState(53);
			match(QUANTITY);
			setState(54);
			gericht();
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOTE) {
				{
				setState(55);
				anmerkung();
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
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).enterGericht(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).exitGericht(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsparserVisitor ) return ((bestellungsparserVisitor<? extends T>)visitor).visitGericht(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GerichtContext gericht() throws RecognitionException {
		GerichtContext _localctx = new GerichtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_gericht);
		try {
			setState(65);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SAUCE:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				sauce();
				setState(59);
				fleisch();
				}
				break;
			case GEBRATEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				gebraten();
				setState(62);
				fleisch();
				}
				break;
			case BEILAGE:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
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
		public TerminalNode SAUCE() { return getToken(bestellungsparser.SAUCE, 0); }
		public SauceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sauce; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).enterSauce(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).exitSauce(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsparserVisitor ) return ((bestellungsparserVisitor<? extends T>)visitor).visitSauce(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SauceContext sauce() throws RecognitionException {
		SauceContext _localctx = new SauceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sauce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
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
		public TerminalNode GEBRATEN() { return getToken(bestellungsparser.GEBRATEN, 0); }
		public GebratenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gebraten; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).enterGebraten(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).exitGebraten(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsparserVisitor ) return ((bestellungsparserVisitor<? extends T>)visitor).visitGebraten(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GebratenContext gebraten() throws RecognitionException {
		GebratenContext _localctx = new GebratenContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_gebraten);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
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
		public TerminalNode FLEISCH() { return getToken(bestellungsparser.FLEISCH, 0); }
		public FleischContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fleisch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).enterFleisch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).exitFleisch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsparserVisitor ) return ((bestellungsparserVisitor<? extends T>)visitor).visitFleisch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FleischContext fleisch() throws RecognitionException {
		FleischContext _localctx = new FleischContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fleisch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
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
		public TerminalNode BEILAGE() { return getToken(bestellungsparser.BEILAGE, 0); }
		public BeilageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beilage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).enterBeilage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).exitBeilage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsparserVisitor ) return ((bestellungsparserVisitor<? extends T>)visitor).visitBeilage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeilageContext beilage() throws RecognitionException {
		BeilageContext _localctx = new BeilageContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_beilage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
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
		public TerminalNode BOX() { return getToken(bestellungsparser.BOX, 0); }
		public TerminalNode QUANTITY() { return getToken(bestellungsparser.QUANTITY, 0); }
		public BoxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_box; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).enterBox(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).exitBox(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsparserVisitor ) return ((bestellungsparserVisitor<? extends T>)visitor).visitBox(this);
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
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUANTITY) {
				{
				setState(75);
				match(QUANTITY);
				}
			}

			setState(78);
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
		public TerminalNode ABHOLUNG() { return getToken(bestellungsparser.ABHOLUNG, 0); }
		public TerminalNode DOPPELPUNKT() { return getToken(bestellungsparser.DOPPELPUNKT, 0); }
		public TerminalNode TIME() { return getToken(bestellungsparser.TIME, 0); }
		public AbholungContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abholung; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).enterAbholung(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).exitAbholung(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsparserVisitor ) return ((bestellungsparserVisitor<? extends T>)visitor).visitAbholung(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbholungContext abholung() throws RecognitionException {
		AbholungContext _localctx = new AbholungContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_abholung);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(ABHOLUNG);
			setState(81);
			match(DOPPELPUNKT);
			setState(82);
			match(TIME);
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
		public TerminalNode NOTE() { return getToken(bestellungsparser.NOTE, 0); }
		public TerminalNode DOPPELPUNKT() { return getToken(bestellungsparser.DOPPELPUNKT, 0); }
		public TerminalNode BESCHREIBUNG() { return getToken(bestellungsparser.BESCHREIBUNG, 0); }
		public AnmerkungContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anmerkung; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).enterAnmerkung(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bestellungsparserListener ) ((bestellungsparserListener)listener).exitAnmerkung(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bestellungsparserVisitor ) return ((bestellungsparserVisitor<? extends T>)visitor).visitAnmerkung(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnmerkungContext anmerkung() throws RecognitionException {
		AnmerkungContext _localctx = new AnmerkungContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_anmerkung);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(NOTE);
			setState(85);
			match(DOPPELPUNKT);
			setState(86);
			match(BESCHREIBUNG);
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
		"\u0004\u0001\u0012Y\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0005\u0000 \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0003\u0000)\b\u0000\u0001\u0000\u0001"+
		"\u0000\u0003\u0000-\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u00039\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004B\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0003\tM\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0000\u0000\f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0000\u0000S\u0000\u0018\u0001\u0000\u0000\u0000\u00020\u0001\u0000\u0000"+
		"\u0000\u00043\u0001\u0000\u0000\u0000\u00065\u0001\u0000\u0000\u0000\b"+
		"A\u0001\u0000\u0000\u0000\nC\u0001\u0000\u0000\u0000\fE\u0001\u0000\u0000"+
		"\u0000\u000eG\u0001\u0000\u0000\u0000\u0010I\u0001\u0000\u0000\u0000\u0012"+
		"L\u0001\u0000\u0000\u0000\u0014P\u0001\u0000\u0000\u0000\u0016T\u0001"+
		"\u0000\u0000\u0000\u0018\u0019\u0003\u0002\u0001\u0000\u0019\u001a\u0005"+
		"\u0001\u0000\u0000\u001a\u001b\u0003\u0004\u0002\u0000\u001b\u001c\u0005"+
		"\u0001\u0000\u0000\u001c!\u0003\u0006\u0003\u0000\u001d\u001e\u0005\u0001"+
		"\u0000\u0000\u001e \u0003\u0006\u0003\u0000\u001f\u001d\u0001\u0000\u0000"+
		"\u0000 #\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000!\"\u0001"+
		"\u0000\u0000\u0000\"$\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000"+
		"$%\u0005\u0001\u0000\u0000%(\u0003\u0012\t\u0000&\'\u0005\u0001\u0000"+
		"\u0000\')\u0003\u0014\n\u0000(&\u0001\u0000\u0000\u0000()\u0001\u0000"+
		"\u0000\u0000),\u0001\u0000\u0000\u0000*+\u0005\u0001\u0000\u0000+-\u0003"+
		"\u0016\u000b\u0000,*\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000"+
		"-.\u0001\u0000\u0000\u0000./\u0005\u0002\u0000\u0000/\u0001\u0001\u0000"+
		"\u0000\u000001\u0005\u0004\u0000\u000012\u0005\u000e\u0000\u00002\u0003"+
		"\u0001\u0000\u0000\u000034\u0005\u0007\u0000\u00004\u0005\u0001\u0000"+
		"\u0000\u000056\u0005\u000f\u0000\u000068\u0003\b\u0004\u000079\u0003\u0016"+
		"\u000b\u000087\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009\u0007"+
		"\u0001\u0000\u0000\u0000:;\u0003\n\u0005\u0000;<\u0003\u000e\u0007\u0000"+
		"<B\u0001\u0000\u0000\u0000=>\u0003\f\u0006\u0000>?\u0003\u000e\u0007\u0000"+
		"?B\u0001\u0000\u0000\u0000@B\u0003\u0010\b\u0000A:\u0001\u0000\u0000\u0000"+
		"A=\u0001\u0000\u0000\u0000A@\u0001\u0000\u0000\u0000B\t\u0001\u0000\u0000"+
		"\u0000CD\u0005\n\u0000\u0000D\u000b\u0001\u0000\u0000\u0000EF\u0005\u000b"+
		"\u0000\u0000F\r\u0001\u0000\u0000\u0000GH\u0005\r\u0000\u0000H\u000f\u0001"+
		"\u0000\u0000\u0000IJ\u0005\f\u0000\u0000J\u0011\u0001\u0000\u0000\u0000"+
		"KM\u0005\u000f\u0000\u0000LK\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000"+
		"\u0000MN\u0001\u0000\u0000\u0000NO\u0005\b\u0000\u0000O\u0013\u0001\u0000"+
		"\u0000\u0000PQ\u0005\u0006\u0000\u0000QR\u0005\u0003\u0000\u0000RS\u0005"+
		"\u0010\u0000\u0000S\u0015\u0001\u0000\u0000\u0000TU\u0005\u0005\u0000"+
		"\u0000UV\u0005\u0003\u0000\u0000VW\u0005\u0011\u0000\u0000W\u0017\u0001"+
		"\u0000\u0000\u0000\u0006!(,8AL";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}