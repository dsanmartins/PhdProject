package br.ufscar.sas.xtext.sasdsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import br.ufscar.sas.xtext.sasdsl.services.SasDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSasDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Architecture'", "'{'", "'}'", "'Rules'", "'loopManager'", "'must-use'", "'must-not-use'", "';'", "'loop'", "'monitor'", "'analyzer'", "'planner'", "'executor'", "'knowledge'", "'sensor'", "'reference-input'", "'alternative'", "'effector'", "'measured-output'", "'Managing'", "'Managed'", "'LoopManager'", "'Loop'", "'withDomainRules'", "'Monitor'", "'Analyzer'", "'Planner'", "'Executor'", "'Knowledge'", "'Sensor'", "'Effector'", "'ReferenceInput'", "'MeasuredOutput'", "'Alternative'", "'layer'", "','", "'level'", "'inLayer: '", "'inSubSystem: '", "'inComponent: '", "'component'", "'interface'", "'ofComponent '", "'type: '", "'provided'", "'required'", "'subSystem'", "'module'", "'.'", "'only'", "'can-'", "'cannot-'", "'-only'", "'must-'", "'access'", "'declare'", "'handle'", "'create'", "'depend'", "'extend'", "'implement'", "'derive'", "'throw'", "'useannotation'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalSasDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSasDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSasDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSasDsl.g"; }



     	private SasDslGrammarAccess grammarAccess;

        public InternalSasDslParser(TokenStream input, SasDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "ArchitectureDefinition";
       	}

       	@Override
       	protected SasDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleArchitectureDefinition"
    // InternalSasDsl.g:64:1: entryRuleArchitectureDefinition returns [EObject current=null] : iv_ruleArchitectureDefinition= ruleArchitectureDefinition EOF ;
    public final EObject entryRuleArchitectureDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArchitectureDefinition = null;


        try {
            // InternalSasDsl.g:64:63: (iv_ruleArchitectureDefinition= ruleArchitectureDefinition EOF )
            // InternalSasDsl.g:65:2: iv_ruleArchitectureDefinition= ruleArchitectureDefinition EOF
            {
             newCompositeNode(grammarAccess.getArchitectureDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArchitectureDefinition=ruleArchitectureDefinition();

            state._fsp--;

             current =iv_ruleArchitectureDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArchitectureDefinition"


    // $ANTLR start "ruleArchitectureDefinition"
    // InternalSasDsl.g:71:1: ruleArchitectureDefinition returns [EObject current=null] : (otherlv_0= 'Architecture' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managing_3_0= ruleDSLManaging ) )+ ( (lv_managed_4_0= ruleDSLManaged ) )+ otherlv_5= '}' otherlv_6= 'Rules' otherlv_7= '{' ( (lv_rules_8_0= ruleDSLRules ) )* ( (lv_dCDecl_9_0= ruleDCDecl ) )* otherlv_10= '}' ) ;
    public final EObject ruleArchitectureDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        EObject lv_managing_3_0 = null;

        EObject lv_managed_4_0 = null;

        EObject lv_rules_8_0 = null;

        EObject lv_dCDecl_9_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:77:2: ( (otherlv_0= 'Architecture' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managing_3_0= ruleDSLManaging ) )+ ( (lv_managed_4_0= ruleDSLManaged ) )+ otherlv_5= '}' otherlv_6= 'Rules' otherlv_7= '{' ( (lv_rules_8_0= ruleDSLRules ) )* ( (lv_dCDecl_9_0= ruleDCDecl ) )* otherlv_10= '}' ) )
            // InternalSasDsl.g:78:2: (otherlv_0= 'Architecture' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managing_3_0= ruleDSLManaging ) )+ ( (lv_managed_4_0= ruleDSLManaged ) )+ otherlv_5= '}' otherlv_6= 'Rules' otherlv_7= '{' ( (lv_rules_8_0= ruleDSLRules ) )* ( (lv_dCDecl_9_0= ruleDCDecl ) )* otherlv_10= '}' )
            {
            // InternalSasDsl.g:78:2: (otherlv_0= 'Architecture' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managing_3_0= ruleDSLManaging ) )+ ( (lv_managed_4_0= ruleDSLManaged ) )+ otherlv_5= '}' otherlv_6= 'Rules' otherlv_7= '{' ( (lv_rules_8_0= ruleDSLRules ) )* ( (lv_dCDecl_9_0= ruleDCDecl ) )* otherlv_10= '}' )
            // InternalSasDsl.g:79:3: otherlv_0= 'Architecture' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managing_3_0= ruleDSLManaging ) )+ ( (lv_managed_4_0= ruleDSLManaged ) )+ otherlv_5= '}' otherlv_6= 'Rules' otherlv_7= '{' ( (lv_rules_8_0= ruleDSLRules ) )* ( (lv_dCDecl_9_0= ruleDCDecl ) )* otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getArchitectureDefinitionAccess().getArchitectureKeyword_0());
            		
            // InternalSasDsl.g:83:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:84:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:84:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:85:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getArchitectureDefinitionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArchitectureDefinitionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getArchitectureDefinitionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalSasDsl.g:105:3: ( (lv_managing_3_0= ruleDSLManaging ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==30) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalSasDsl.g:106:4: (lv_managing_3_0= ruleDSLManaging )
            	    {
            	    // InternalSasDsl.g:106:4: (lv_managing_3_0= ruleDSLManaging )
            	    // InternalSasDsl.g:107:5: lv_managing_3_0= ruleDSLManaging
            	    {

            	    					newCompositeNode(grammarAccess.getArchitectureDefinitionAccess().getManagingDSLManagingParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_managing_3_0=ruleDSLManaging();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getArchitectureDefinitionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"managing",
            	    						lv_managing_3_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLManaging");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            // InternalSasDsl.g:124:3: ( (lv_managed_4_0= ruleDSLManaged ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==31) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalSasDsl.g:125:4: (lv_managed_4_0= ruleDSLManaged )
            	    {
            	    // InternalSasDsl.g:125:4: (lv_managed_4_0= ruleDSLManaged )
            	    // InternalSasDsl.g:126:5: lv_managed_4_0= ruleDSLManaged
            	    {

            	    					newCompositeNode(grammarAccess.getArchitectureDefinitionAccess().getManagedDSLManagedParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_managed_4_0=ruleDSLManaged();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getArchitectureDefinitionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"managed",
            	    						lv_managed_4_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLManaged");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_5, grammarAccess.getArchitectureDefinitionAccess().getRightCurlyBracketKeyword_5());
            		
            otherlv_6=(Token)match(input,14,FOLLOW_4); 

            			newLeafNode(otherlv_6, grammarAccess.getArchitectureDefinitionAccess().getRulesKeyword_6());
            		
            otherlv_7=(Token)match(input,12,FOLLOW_9); 

            			newLeafNode(otherlv_7, grammarAccess.getArchitectureDefinitionAccess().getLeftCurlyBracketKeyword_7());
            		
            // InternalSasDsl.g:155:3: ( (lv_rules_8_0= ruleDSLRules ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15||(LA3_0>=19 && LA3_0<=25)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalSasDsl.g:156:4: (lv_rules_8_0= ruleDSLRules )
            	    {
            	    // InternalSasDsl.g:156:4: (lv_rules_8_0= ruleDSLRules )
            	    // InternalSasDsl.g:157:5: lv_rules_8_0= ruleDSLRules
            	    {

            	    					newCompositeNode(grammarAccess.getArchitectureDefinitionAccess().getRulesDSLRulesParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_rules_8_0=ruleDSLRules();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getArchitectureDefinitionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"rules",
            	    						lv_rules_8_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLRules");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalSasDsl.g:174:3: ( (lv_dCDecl_9_0= ruleDCDecl ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID||LA4_0==60) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalSasDsl.g:175:4: (lv_dCDecl_9_0= ruleDCDecl )
            	    {
            	    // InternalSasDsl.g:175:4: (lv_dCDecl_9_0= ruleDCDecl )
            	    // InternalSasDsl.g:176:5: lv_dCDecl_9_0= ruleDCDecl
            	    {

            	    					newCompositeNode(grammarAccess.getArchitectureDefinitionAccess().getDCDeclDCDeclParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_dCDecl_9_0=ruleDCDecl();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getArchitectureDefinitionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"dCDecl",
            	    						lv_dCDecl_9_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DCDecl");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_10=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getArchitectureDefinitionAccess().getRightCurlyBracketKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArchitectureDefinition"


    // $ANTLR start "entryRuleDSLRules"
    // InternalSasDsl.g:201:1: entryRuleDSLRules returns [EObject current=null] : iv_ruleDSLRules= ruleDSLRules EOF ;
    public final EObject entryRuleDSLRules() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRules = null;


        try {
            // InternalSasDsl.g:201:49: (iv_ruleDSLRules= ruleDSLRules EOF )
            // InternalSasDsl.g:202:2: iv_ruleDSLRules= ruleDSLRules EOF
            {
             newCompositeNode(grammarAccess.getDSLRulesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLRules=ruleDSLRules();

            state._fsp--;

             current =iv_ruleDSLRules; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLRules"


    // $ANTLR start "ruleDSLRules"
    // InternalSasDsl.g:208:1: ruleDSLRules returns [EObject current=null] : (this_DSLRuleController_0= ruleDSLRuleController | this_DSLRuleMonitor_1= ruleDSLRuleMonitor | this_DSLRuleAnalyzer_2= ruleDSLRuleAnalyzer | this_DSLRulePlanner_3= ruleDSLRulePlanner | this_DSLRuleExecutor_4= ruleDSLRuleExecutor | this_DSLRuleMO_5= ruleDSLRuleMO | this_DSLRuleMController_6= ruleDSLRuleMController | this_DSLRuleKnowledge_7= ruleDSLRuleKnowledge ) ;
    public final EObject ruleDSLRules() throws RecognitionException {
        EObject current = null;

        EObject this_DSLRuleController_0 = null;

        EObject this_DSLRuleMonitor_1 = null;

        EObject this_DSLRuleAnalyzer_2 = null;

        EObject this_DSLRulePlanner_3 = null;

        EObject this_DSLRuleExecutor_4 = null;

        EObject this_DSLRuleMO_5 = null;

        EObject this_DSLRuleMController_6 = null;

        EObject this_DSLRuleKnowledge_7 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:214:2: ( (this_DSLRuleController_0= ruleDSLRuleController | this_DSLRuleMonitor_1= ruleDSLRuleMonitor | this_DSLRuleAnalyzer_2= ruleDSLRuleAnalyzer | this_DSLRulePlanner_3= ruleDSLRulePlanner | this_DSLRuleExecutor_4= ruleDSLRuleExecutor | this_DSLRuleMO_5= ruleDSLRuleMO | this_DSLRuleMController_6= ruleDSLRuleMController | this_DSLRuleKnowledge_7= ruleDSLRuleKnowledge ) )
            // InternalSasDsl.g:215:2: (this_DSLRuleController_0= ruleDSLRuleController | this_DSLRuleMonitor_1= ruleDSLRuleMonitor | this_DSLRuleAnalyzer_2= ruleDSLRuleAnalyzer | this_DSLRulePlanner_3= ruleDSLRulePlanner | this_DSLRuleExecutor_4= ruleDSLRuleExecutor | this_DSLRuleMO_5= ruleDSLRuleMO | this_DSLRuleMController_6= ruleDSLRuleMController | this_DSLRuleKnowledge_7= ruleDSLRuleKnowledge )
            {
            // InternalSasDsl.g:215:2: (this_DSLRuleController_0= ruleDSLRuleController | this_DSLRuleMonitor_1= ruleDSLRuleMonitor | this_DSLRuleAnalyzer_2= ruleDSLRuleAnalyzer | this_DSLRulePlanner_3= ruleDSLRulePlanner | this_DSLRuleExecutor_4= ruleDSLRuleExecutor | this_DSLRuleMO_5= ruleDSLRuleMO | this_DSLRuleMController_6= ruleDSLRuleMController | this_DSLRuleKnowledge_7= ruleDSLRuleKnowledge )
            int alt5=8;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt5=1;
                }
                break;
            case 20:
                {
                alt5=2;
                }
                break;
            case 21:
                {
                alt5=3;
                }
                break;
            case 22:
                {
                alt5=4;
                }
                break;
            case 23:
                {
                alt5=5;
                }
                break;
            case 25:
                {
                alt5=6;
                }
                break;
            case 15:
                {
                alt5=7;
                }
                break;
            case 24:
                {
                alt5=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalSasDsl.g:216:3: this_DSLRuleController_0= ruleDSLRuleController
                    {

                    			newCompositeNode(grammarAccess.getDSLRulesAccess().getDSLRuleControllerParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_DSLRuleController_0=ruleDSLRuleController();

                    state._fsp--;


                    			current = this_DSLRuleController_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:225:3: this_DSLRuleMonitor_1= ruleDSLRuleMonitor
                    {

                    			newCompositeNode(grammarAccess.getDSLRulesAccess().getDSLRuleMonitorParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_DSLRuleMonitor_1=ruleDSLRuleMonitor();

                    state._fsp--;


                    			current = this_DSLRuleMonitor_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:234:3: this_DSLRuleAnalyzer_2= ruleDSLRuleAnalyzer
                    {

                    			newCompositeNode(grammarAccess.getDSLRulesAccess().getDSLRuleAnalyzerParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_DSLRuleAnalyzer_2=ruleDSLRuleAnalyzer();

                    state._fsp--;


                    			current = this_DSLRuleAnalyzer_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:243:3: this_DSLRulePlanner_3= ruleDSLRulePlanner
                    {

                    			newCompositeNode(grammarAccess.getDSLRulesAccess().getDSLRulePlannerParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_DSLRulePlanner_3=ruleDSLRulePlanner();

                    state._fsp--;


                    			current = this_DSLRulePlanner_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalSasDsl.g:252:3: this_DSLRuleExecutor_4= ruleDSLRuleExecutor
                    {

                    			newCompositeNode(grammarAccess.getDSLRulesAccess().getDSLRuleExecutorParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_DSLRuleExecutor_4=ruleDSLRuleExecutor();

                    state._fsp--;


                    			current = this_DSLRuleExecutor_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalSasDsl.g:261:3: this_DSLRuleMO_5= ruleDSLRuleMO
                    {

                    			newCompositeNode(grammarAccess.getDSLRulesAccess().getDSLRuleMOParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_DSLRuleMO_5=ruleDSLRuleMO();

                    state._fsp--;


                    			current = this_DSLRuleMO_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalSasDsl.g:270:3: this_DSLRuleMController_6= ruleDSLRuleMController
                    {

                    			newCompositeNode(grammarAccess.getDSLRulesAccess().getDSLRuleMControllerParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_DSLRuleMController_6=ruleDSLRuleMController();

                    state._fsp--;


                    			current = this_DSLRuleMController_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalSasDsl.g:279:3: this_DSLRuleKnowledge_7= ruleDSLRuleKnowledge
                    {

                    			newCompositeNode(grammarAccess.getDSLRulesAccess().getDSLRuleKnowledgeParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_DSLRuleKnowledge_7=ruleDSLRuleKnowledge();

                    state._fsp--;


                    			current = this_DSLRuleKnowledge_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLRules"


    // $ANTLR start "entryRuleDSLRuleMController"
    // InternalSasDsl.g:291:1: entryRuleDSLRuleMController returns [EObject current=null] : iv_ruleDSLRuleMController= ruleDSLRuleMController EOF ;
    public final EObject entryRuleDSLRuleMController() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleMController = null;


        try {
            // InternalSasDsl.g:291:59: (iv_ruleDSLRuleMController= ruleDSLRuleMController EOF )
            // InternalSasDsl.g:292:2: iv_ruleDSLRuleMController= ruleDSLRuleMController EOF
            {
             newCompositeNode(grammarAccess.getDSLRuleMControllerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLRuleMController=ruleDSLRuleMController();

            state._fsp--;

             current =iv_ruleDSLRuleMController; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLRuleMController"


    // $ANTLR start "ruleDSLRuleMController"
    // InternalSasDsl.g:298:1: ruleDSLRuleMController returns [EObject current=null] : (otherlv_0= 'loopManager' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loopManager' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) ;
    public final EObject ruleDSLRuleMController() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_access_2_1=null;
        Token lv_access_2_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalSasDsl.g:304:2: ( (otherlv_0= 'loopManager' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loopManager' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) )
            // InternalSasDsl.g:305:2: (otherlv_0= 'loopManager' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loopManager' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            {
            // InternalSasDsl.g:305:2: (otherlv_0= 'loopManager' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loopManager' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            // InternalSasDsl.g:306:3: otherlv_0= 'loopManager' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loopManager' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLRuleMControllerAccess().getLoopManagerKeyword_0());
            		
            // InternalSasDsl.g:310:3: ( (otherlv_1= RULE_ID ) )
            // InternalSasDsl.g:311:4: (otherlv_1= RULE_ID )
            {
            // InternalSasDsl.g:311:4: (otherlv_1= RULE_ID )
            // InternalSasDsl.g:312:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleMControllerRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(otherlv_1, grammarAccess.getDSLRuleMControllerAccess().getMcontroller1DSLManagerControllerCrossReference_1_0());
            				

            }


            }

            // InternalSasDsl.g:323:3: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
            // InternalSasDsl.g:324:4: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
            {
            // InternalSasDsl.g:324:4: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
            // InternalSasDsl.g:325:5: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
            {
            // InternalSasDsl.g:325:5: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            else if ( (LA6_0==17) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalSasDsl.g:326:6: lv_access_2_1= 'must-use'
                    {
                    lv_access_2_1=(Token)match(input,16,FOLLOW_12); 

                    						newLeafNode(lv_access_2_1, grammarAccess.getDSLRuleMControllerAccess().getAccessMustUseKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMControllerRule());
                    						}
                    						setWithLastConsumed(current, "access", lv_access_2_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:337:6: lv_access_2_2= 'must-not-use'
                    {
                    lv_access_2_2=(Token)match(input,17,FOLLOW_12); 

                    						newLeafNode(lv_access_2_2, grammarAccess.getDSLRuleMControllerAccess().getAccessMustNotUseKeyword_2_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMControllerRule());
                    						}
                    						setWithLastConsumed(current, "access", lv_access_2_2, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getDSLRuleMControllerAccess().getLoopManagerKeyword_3());
            		
            // InternalSasDsl.g:354:3: ( (otherlv_4= RULE_ID ) )
            // InternalSasDsl.g:355:4: (otherlv_4= RULE_ID )
            {
            // InternalSasDsl.g:355:4: (otherlv_4= RULE_ID )
            // InternalSasDsl.g:356:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleMControllerRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(otherlv_4, grammarAccess.getDSLRuleMControllerAccess().getMcontroller2DSLManagerControllerCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getDSLRuleMControllerAccess().getSemicolonKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLRuleMController"


    // $ANTLR start "entryRuleDSLRuleController"
    // InternalSasDsl.g:375:1: entryRuleDSLRuleController returns [EObject current=null] : iv_ruleDSLRuleController= ruleDSLRuleController EOF ;
    public final EObject entryRuleDSLRuleController() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleController = null;


        try {
            // InternalSasDsl.g:375:58: (iv_ruleDSLRuleController= ruleDSLRuleController EOF )
            // InternalSasDsl.g:376:2: iv_ruleDSLRuleController= ruleDSLRuleController EOF
            {
             newCompositeNode(grammarAccess.getDSLRuleControllerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLRuleController=ruleDSLRuleController();

            state._fsp--;

             current =iv_ruleDSLRuleController; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLRuleController"


    // $ANTLR start "ruleDSLRuleController"
    // InternalSasDsl.g:382:1: ruleDSLRuleController returns [EObject current=null] : (otherlv_0= 'loop' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loop' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) ;
    public final EObject ruleDSLRuleController() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_access_2_1=null;
        Token lv_access_2_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalSasDsl.g:388:2: ( (otherlv_0= 'loop' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loop' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) )
            // InternalSasDsl.g:389:2: (otherlv_0= 'loop' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loop' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            {
            // InternalSasDsl.g:389:2: (otherlv_0= 'loop' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loop' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            // InternalSasDsl.g:390:3: otherlv_0= 'loop' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loop' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLRuleControllerAccess().getLoopKeyword_0());
            		
            // InternalSasDsl.g:394:3: ( (otherlv_1= RULE_ID ) )
            // InternalSasDsl.g:395:4: (otherlv_1= RULE_ID )
            {
            // InternalSasDsl.g:395:4: (otherlv_1= RULE_ID )
            // InternalSasDsl.g:396:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleControllerRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(otherlv_1, grammarAccess.getDSLRuleControllerAccess().getController1DSLControllerCrossReference_1_0());
            				

            }


            }

            // InternalSasDsl.g:407:3: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
            // InternalSasDsl.g:408:4: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
            {
            // InternalSasDsl.g:408:4: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
            // InternalSasDsl.g:409:5: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
            {
            // InternalSasDsl.g:409:5: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            else if ( (LA7_0==17) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalSasDsl.g:410:6: lv_access_2_1= 'must-use'
                    {
                    lv_access_2_1=(Token)match(input,16,FOLLOW_14); 

                    						newLeafNode(lv_access_2_1, grammarAccess.getDSLRuleControllerAccess().getAccessMustUseKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleControllerRule());
                    						}
                    						setWithLastConsumed(current, "access", lv_access_2_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:421:6: lv_access_2_2= 'must-not-use'
                    {
                    lv_access_2_2=(Token)match(input,17,FOLLOW_14); 

                    						newLeafNode(lv_access_2_2, grammarAccess.getDSLRuleControllerAccess().getAccessMustNotUseKeyword_2_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleControllerRule());
                    						}
                    						setWithLastConsumed(current, "access", lv_access_2_2, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getDSLRuleControllerAccess().getLoopKeyword_3());
            		
            // InternalSasDsl.g:438:3: ( (otherlv_4= RULE_ID ) )
            // InternalSasDsl.g:439:4: (otherlv_4= RULE_ID )
            {
            // InternalSasDsl.g:439:4: (otherlv_4= RULE_ID )
            // InternalSasDsl.g:440:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleControllerRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(otherlv_4, grammarAccess.getDSLRuleControllerAccess().getController2DSLControllerCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getDSLRuleControllerAccess().getSemicolonKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLRuleController"


    // $ANTLR start "entryRuleDSLRuleMonitor"
    // InternalSasDsl.g:459:1: entryRuleDSLRuleMonitor returns [EObject current=null] : iv_ruleDSLRuleMonitor= ruleDSLRuleMonitor EOF ;
    public final EObject entryRuleDSLRuleMonitor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleMonitor = null;


        try {
            // InternalSasDsl.g:459:55: (iv_ruleDSLRuleMonitor= ruleDSLRuleMonitor EOF )
            // InternalSasDsl.g:460:2: iv_ruleDSLRuleMonitor= ruleDSLRuleMonitor EOF
            {
             newCompositeNode(grammarAccess.getDSLRuleMonitorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLRuleMonitor=ruleDSLRuleMonitor();

            state._fsp--;

             current =iv_ruleDSLRuleMonitor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLRuleMonitor"


    // $ANTLR start "ruleDSLRuleMonitor"
    // InternalSasDsl.g:466:1: ruleDSLRuleMonitor returns [EObject current=null] : ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'monitor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'monitor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'sensor' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) ) ;
    public final EObject ruleDSLRuleMonitor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_access_2_1=null;
        Token lv_access_2_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_access_8_1=null;
        Token lv_access_8_2=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_access_14_1=null;
        Token lv_access_14_2=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token lv_access_20_1=null;
        Token lv_access_20_2=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token lv_access_26_1=null;
        Token lv_access_26_2=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token lv_access_32_1=null;
        Token lv_access_32_2=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_35=null;


        	enterRule();

        try {
            // InternalSasDsl.g:472:2: ( ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'monitor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'monitor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'sensor' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) ) )
            // InternalSasDsl.g:473:2: ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'monitor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'monitor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'sensor' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) )
            {
            // InternalSasDsl.g:473:2: ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'monitor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'monitor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'sensor' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) )
            int alt14=6;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // InternalSasDsl.g:474:3: (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:474:3: (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:475:4: otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_0_0());
                    			
                    // InternalSasDsl.g:479:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:480:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:480:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:481:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:492:4: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:493:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:493:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    // InternalSasDsl.g:494:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:494:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==16) ) {
                        alt8=1;
                    }
                    else if ( (LA8_0==17) ) {
                        alt8=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalSasDsl.g:495:7: lv_access_2_1= 'must-use'
                            {
                            lv_access_2_1=(Token)match(input,16,FOLLOW_15); 

                            							newLeafNode(lv_access_2_1, grammarAccess.getDSLRuleMonitorAccess().getAccessMustUseKeyword_0_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_2_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:506:7: lv_access_2_2= 'must-not-use'
                            {
                            lv_access_2_2=(Token)match(input,17,FOLLOW_15); 

                            							newLeafNode(lv_access_2_2, grammarAccess.getDSLRuleMonitorAccess().getAccessMustNotUseKeyword_0_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_2_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_3=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_0_3());
                    			
                    // InternalSasDsl.g:523:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:524:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:524:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:525:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRuleMonitorAccess().getMonitor2DSLMonitorCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRuleMonitorAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:542:3: (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:542:3: (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:543:4: otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_1_0());
                    			
                    // InternalSasDsl.g:547:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:548:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:548:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:549:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:560:4: ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:561:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:561:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    // InternalSasDsl.g:562:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:562:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==16) ) {
                        alt9=1;
                    }
                    else if ( (LA9_0==17) ) {
                        alt9=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalSasDsl.g:563:7: lv_access_8_1= 'must-use'
                            {
                            lv_access_8_1=(Token)match(input,16,FOLLOW_16); 

                            							newLeafNode(lv_access_8_1, grammarAccess.getDSLRuleMonitorAccess().getAccessMustUseKeyword_1_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_8_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:574:7: lv_access_8_2= 'must-not-use'
                            {
                            lv_access_8_2=(Token)match(input,17,FOLLOW_16); 

                            							newLeafNode(lv_access_8_2, grammarAccess.getDSLRuleMonitorAccess().getAccessMustNotUseKeyword_1_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_8_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_9=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getDSLRuleMonitorAccess().getAnalyzerKeyword_1_3());
                    			
                    // InternalSasDsl.g:591:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:592:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:592:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:593:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRuleMonitorAccess().getAnalyzerDSLAnalyzerCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRuleMonitorAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:610:3: (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:610:3: (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:611:4: otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_2_0());
                    			
                    // InternalSasDsl.g:615:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:616:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:616:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:617:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:628:4: ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:629:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:629:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    // InternalSasDsl.g:630:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:630:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==16) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==17) ) {
                        alt10=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalSasDsl.g:631:7: lv_access_14_1= 'must-use'
                            {
                            lv_access_14_1=(Token)match(input,16,FOLLOW_17); 

                            							newLeafNode(lv_access_14_1, grammarAccess.getDSLRuleMonitorAccess().getAccessMustUseKeyword_2_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_14_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:642:7: lv_access_14_2= 'must-not-use'
                            {
                            lv_access_14_2=(Token)match(input,17,FOLLOW_17); 

                            							newLeafNode(lv_access_14_2, grammarAccess.getDSLRuleMonitorAccess().getAccessMustNotUseKeyword_2_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_14_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_15=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getDSLRuleMonitorAccess().getPlannerKeyword_2_3());
                    			
                    // InternalSasDsl.g:659:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:660:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:660:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:661:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRuleMonitorAccess().getPlannerDSLPlannerCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRuleMonitorAccess().getSemicolonKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:678:3: (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    {
                    // InternalSasDsl.g:678:3: (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    // InternalSasDsl.g:679:4: otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';'
                    {
                    otherlv_18=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_3_0());
                    			
                    // InternalSasDsl.g:683:4: ( (otherlv_19= RULE_ID ) )
                    // InternalSasDsl.g:684:5: (otherlv_19= RULE_ID )
                    {
                    // InternalSasDsl.g:684:5: (otherlv_19= RULE_ID )
                    // InternalSasDsl.g:685:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_19, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:696:4: ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:697:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:697:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    // InternalSasDsl.g:698:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:698:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==16) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==17) ) {
                        alt11=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 0, input);

                        throw nvae;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalSasDsl.g:699:7: lv_access_20_1= 'must-use'
                            {
                            lv_access_20_1=(Token)match(input,16,FOLLOW_18); 

                            							newLeafNode(lv_access_20_1, grammarAccess.getDSLRuleMonitorAccess().getAccessMustUseKeyword_3_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_20_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:710:7: lv_access_20_2= 'must-not-use'
                            {
                            lv_access_20_2=(Token)match(input,17,FOLLOW_18); 

                            							newLeafNode(lv_access_20_2, grammarAccess.getDSLRuleMonitorAccess().getAccessMustNotUseKeyword_3_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_20_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_21=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_21, grammarAccess.getDSLRuleMonitorAccess().getExecutorKeyword_3_3());
                    			
                    // InternalSasDsl.g:727:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSasDsl.g:728:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSasDsl.g:728:5: (otherlv_22= RULE_ID )
                    // InternalSasDsl.g:729:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_22, grammarAccess.getDSLRuleMonitorAccess().getExecutorDSLExecutorCrossReference_3_4_0());
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_23, grammarAccess.getDSLRuleMonitorAccess().getSemicolonKeyword_3_5());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalSasDsl.g:746:3: (otherlv_24= 'monitor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    {
                    // InternalSasDsl.g:746:3: (otherlv_24= 'monitor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    // InternalSasDsl.g:747:4: otherlv_24= 'monitor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';'
                    {
                    otherlv_24=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_24, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_4_0());
                    			
                    // InternalSasDsl.g:751:4: ( (otherlv_25= RULE_ID ) )
                    // InternalSasDsl.g:752:5: (otherlv_25= RULE_ID )
                    {
                    // InternalSasDsl.g:752:5: (otherlv_25= RULE_ID )
                    // InternalSasDsl.g:753:6: otherlv_25= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_25=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_25, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_4_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:764:4: ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:765:5: ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:765:5: ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) )
                    // InternalSasDsl.g:766:6: (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:766:6: (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==16) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==17) ) {
                        alt12=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalSasDsl.g:767:7: lv_access_26_1= 'must-use'
                            {
                            lv_access_26_1=(Token)match(input,16,FOLLOW_19); 

                            							newLeafNode(lv_access_26_1, grammarAccess.getDSLRuleMonitorAccess().getAccessMustUseKeyword_4_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_26_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:778:7: lv_access_26_2= 'must-not-use'
                            {
                            lv_access_26_2=(Token)match(input,17,FOLLOW_19); 

                            							newLeafNode(lv_access_26_2, grammarAccess.getDSLRuleMonitorAccess().getAccessMustNotUseKeyword_4_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_26_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_27=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_27, grammarAccess.getDSLRuleMonitorAccess().getKnowledgeKeyword_4_3());
                    			
                    // InternalSasDsl.g:795:4: ( (otherlv_28= RULE_ID ) )
                    // InternalSasDsl.g:796:5: (otherlv_28= RULE_ID )
                    {
                    // InternalSasDsl.g:796:5: (otherlv_28= RULE_ID )
                    // InternalSasDsl.g:797:6: otherlv_28= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_28=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_28, grammarAccess.getDSLRuleMonitorAccess().getKnowledgeDSLKnowledgeCrossReference_4_4_0());
                    					

                    }


                    }

                    otherlv_29=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_29, grammarAccess.getDSLRuleMonitorAccess().getSemicolonKeyword_4_5());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalSasDsl.g:814:3: (otherlv_30= 'monitor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'sensor' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' )
                    {
                    // InternalSasDsl.g:814:3: (otherlv_30= 'monitor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'sensor' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' )
                    // InternalSasDsl.g:815:4: otherlv_30= 'monitor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'sensor' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';'
                    {
                    otherlv_30=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_30, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_5_0());
                    			
                    // InternalSasDsl.g:819:4: ( (otherlv_31= RULE_ID ) )
                    // InternalSasDsl.g:820:5: (otherlv_31= RULE_ID )
                    {
                    // InternalSasDsl.g:820:5: (otherlv_31= RULE_ID )
                    // InternalSasDsl.g:821:6: otherlv_31= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_31=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_31, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_5_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:832:4: ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:833:5: ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:833:5: ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) )
                    // InternalSasDsl.g:834:6: (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:834:6: (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==16) ) {
                        alt13=1;
                    }
                    else if ( (LA13_0==17) ) {
                        alt13=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalSasDsl.g:835:7: lv_access_32_1= 'must-use'
                            {
                            lv_access_32_1=(Token)match(input,16,FOLLOW_20); 

                            							newLeafNode(lv_access_32_1, grammarAccess.getDSLRuleMonitorAccess().getAccessMustUseKeyword_5_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_32_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:846:7: lv_access_32_2= 'must-not-use'
                            {
                            lv_access_32_2=(Token)match(input,17,FOLLOW_20); 

                            							newLeafNode(lv_access_32_2, grammarAccess.getDSLRuleMonitorAccess().getAccessMustNotUseKeyword_5_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_32_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_33=(Token)match(input,25,FOLLOW_3); 

                    				newLeafNode(otherlv_33, grammarAccess.getDSLRuleMonitorAccess().getSensorKeyword_5_3());
                    			
                    // InternalSasDsl.g:863:4: ( (otherlv_34= RULE_ID ) )
                    // InternalSasDsl.g:864:5: (otherlv_34= RULE_ID )
                    {
                    // InternalSasDsl.g:864:5: (otherlv_34= RULE_ID )
                    // InternalSasDsl.g:865:6: otherlv_34= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_34=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_34, grammarAccess.getDSLRuleMonitorAccess().getSensorDSLSensorCrossReference_5_4_0());
                    					

                    }


                    }

                    otherlv_35=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_35, grammarAccess.getDSLRuleMonitorAccess().getSemicolonKeyword_5_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLRuleMonitor"


    // $ANTLR start "entryRuleDSLRuleAnalyzer"
    // InternalSasDsl.g:885:1: entryRuleDSLRuleAnalyzer returns [EObject current=null] : iv_ruleDSLRuleAnalyzer= ruleDSLRuleAnalyzer EOF ;
    public final EObject entryRuleDSLRuleAnalyzer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleAnalyzer = null;


        try {
            // InternalSasDsl.g:885:56: (iv_ruleDSLRuleAnalyzer= ruleDSLRuleAnalyzer EOF )
            // InternalSasDsl.g:886:2: iv_ruleDSLRuleAnalyzer= ruleDSLRuleAnalyzer EOF
            {
             newCompositeNode(grammarAccess.getDSLRuleAnalyzerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLRuleAnalyzer=ruleDSLRuleAnalyzer();

            state._fsp--;

             current =iv_ruleDSLRuleAnalyzer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLRuleAnalyzer"


    // $ANTLR start "ruleDSLRuleAnalyzer"
    // InternalSasDsl.g:892:1: ruleDSLRuleAnalyzer returns [EObject current=null] : ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'reference-input' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) | (otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'alternative' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';' ) ) ;
    public final EObject ruleDSLRuleAnalyzer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_access_2_1=null;
        Token lv_access_2_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_access_8_1=null;
        Token lv_access_8_2=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_access_14_1=null;
        Token lv_access_14_2=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token lv_access_20_1=null;
        Token lv_access_20_2=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token lv_access_26_1=null;
        Token lv_access_26_2=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token lv_access_32_1=null;
        Token lv_access_32_2=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_35=null;
        Token otherlv_36=null;
        Token otherlv_37=null;
        Token lv_access_38_1=null;
        Token lv_access_38_2=null;
        Token otherlv_39=null;
        Token otherlv_40=null;
        Token otherlv_41=null;


        	enterRule();

        try {
            // InternalSasDsl.g:898:2: ( ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'reference-input' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) | (otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'alternative' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';' ) ) )
            // InternalSasDsl.g:899:2: ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'reference-input' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) | (otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'alternative' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';' ) )
            {
            // InternalSasDsl.g:899:2: ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'reference-input' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) | (otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'alternative' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';' ) )
            int alt22=7;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // InternalSasDsl.g:900:3: (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:900:3: (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:901:4: otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_0_0());
                    			
                    // InternalSasDsl.g:905:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:906:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:906:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:907:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:918:4: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:919:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:919:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    // InternalSasDsl.g:920:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:920:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==16) ) {
                        alt15=1;
                    }
                    else if ( (LA15_0==17) ) {
                        alt15=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;
                    }
                    switch (alt15) {
                        case 1 :
                            // InternalSasDsl.g:921:7: lv_access_2_1= 'must-use'
                            {
                            lv_access_2_1=(Token)match(input,16,FOLLOW_15); 

                            							newLeafNode(lv_access_2_1, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustUseKeyword_0_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_2_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:932:7: lv_access_2_2= 'must-not-use'
                            {
                            lv_access_2_2=(Token)match(input,17,FOLLOW_15); 

                            							newLeafNode(lv_access_2_2, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustNotUseKeyword_0_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_2_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_3=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDSLRuleAnalyzerAccess().getMonitorKeyword_0_3());
                    			
                    // InternalSasDsl.g:949:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:950:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:950:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:951:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRuleAnalyzerAccess().getMonitorDSLMonitorCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:968:3: (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:968:3: (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:969:4: otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_1_0());
                    			
                    // InternalSasDsl.g:973:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:974:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:974:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:975:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:986:4: ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:987:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:987:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    // InternalSasDsl.g:988:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:988:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==16) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==17) ) {
                        alt16=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 0, input);

                        throw nvae;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalSasDsl.g:989:7: lv_access_8_1= 'must-use'
                            {
                            lv_access_8_1=(Token)match(input,16,FOLLOW_16); 

                            							newLeafNode(lv_access_8_1, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustUseKeyword_1_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_8_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1000:7: lv_access_8_2= 'must-not-use'
                            {
                            lv_access_8_2=(Token)match(input,17,FOLLOW_16); 

                            							newLeafNode(lv_access_8_2, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustNotUseKeyword_1_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_8_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_9=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_1_3());
                    			
                    // InternalSasDsl.g:1017:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:1018:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:1018:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:1019:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzer2DSLAnalyzerCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:1036:3: (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:1036:3: (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:1037:4: otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_2_0());
                    			
                    // InternalSasDsl.g:1041:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:1042:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:1042:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:1043:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1054:4: ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1055:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1055:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1056:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1056:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==16) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==17) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // InternalSasDsl.g:1057:7: lv_access_14_1= 'must-use'
                            {
                            lv_access_14_1=(Token)match(input,16,FOLLOW_17); 

                            							newLeafNode(lv_access_14_1, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustUseKeyword_2_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_14_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1068:7: lv_access_14_2= 'must-not-use'
                            {
                            lv_access_14_2=(Token)match(input,17,FOLLOW_17); 

                            							newLeafNode(lv_access_14_2, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustNotUseKeyword_2_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_14_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_15=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getDSLRuleAnalyzerAccess().getPlannerKeyword_2_3());
                    			
                    // InternalSasDsl.g:1085:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:1086:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:1086:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:1087:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRuleAnalyzerAccess().getPlannerDSLPlannerCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:1104:3: (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    {
                    // InternalSasDsl.g:1104:3: (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    // InternalSasDsl.g:1105:4: otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';'
                    {
                    otherlv_18=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_3_0());
                    			
                    // InternalSasDsl.g:1109:4: ( (otherlv_19= RULE_ID ) )
                    // InternalSasDsl.g:1110:5: (otherlv_19= RULE_ID )
                    {
                    // InternalSasDsl.g:1110:5: (otherlv_19= RULE_ID )
                    // InternalSasDsl.g:1111:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_19, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1122:4: ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1123:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1123:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1124:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1124:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==16) ) {
                        alt18=1;
                    }
                    else if ( (LA18_0==17) ) {
                        alt18=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        throw nvae;
                    }
                    switch (alt18) {
                        case 1 :
                            // InternalSasDsl.g:1125:7: lv_access_20_1= 'must-use'
                            {
                            lv_access_20_1=(Token)match(input,16,FOLLOW_18); 

                            							newLeafNode(lv_access_20_1, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustUseKeyword_3_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_20_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1136:7: lv_access_20_2= 'must-not-use'
                            {
                            lv_access_20_2=(Token)match(input,17,FOLLOW_18); 

                            							newLeafNode(lv_access_20_2, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustNotUseKeyword_3_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_20_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_21=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_21, grammarAccess.getDSLRuleAnalyzerAccess().getExecutorKeyword_3_3());
                    			
                    // InternalSasDsl.g:1153:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSasDsl.g:1154:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSasDsl.g:1154:5: (otherlv_22= RULE_ID )
                    // InternalSasDsl.g:1155:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_22, grammarAccess.getDSLRuleAnalyzerAccess().getExecutorDSLExecutorCrossReference_3_4_0());
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_23, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_3_5());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalSasDsl.g:1172:3: (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    {
                    // InternalSasDsl.g:1172:3: (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    // InternalSasDsl.g:1173:4: otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';'
                    {
                    otherlv_24=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_24, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_4_0());
                    			
                    // InternalSasDsl.g:1177:4: ( (otherlv_25= RULE_ID ) )
                    // InternalSasDsl.g:1178:5: (otherlv_25= RULE_ID )
                    {
                    // InternalSasDsl.g:1178:5: (otherlv_25= RULE_ID )
                    // InternalSasDsl.g:1179:6: otherlv_25= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_25=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_25, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_4_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1190:4: ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1191:5: ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1191:5: ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1192:6: (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1192:6: (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==16) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==17) ) {
                        alt19=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;
                    }
                    switch (alt19) {
                        case 1 :
                            // InternalSasDsl.g:1193:7: lv_access_26_1= 'must-use'
                            {
                            lv_access_26_1=(Token)match(input,16,FOLLOW_19); 

                            							newLeafNode(lv_access_26_1, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustUseKeyword_4_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_26_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1204:7: lv_access_26_2= 'must-not-use'
                            {
                            lv_access_26_2=(Token)match(input,17,FOLLOW_19); 

                            							newLeafNode(lv_access_26_2, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustNotUseKeyword_4_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_26_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_27=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_27, grammarAccess.getDSLRuleAnalyzerAccess().getKnowledgeKeyword_4_3());
                    			
                    // InternalSasDsl.g:1221:4: ( (otherlv_28= RULE_ID ) )
                    // InternalSasDsl.g:1222:5: (otherlv_28= RULE_ID )
                    {
                    // InternalSasDsl.g:1222:5: (otherlv_28= RULE_ID )
                    // InternalSasDsl.g:1223:6: otherlv_28= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_28=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_28, grammarAccess.getDSLRuleAnalyzerAccess().getKnowledgeDSLKnowledgeCrossReference_4_4_0());
                    					

                    }


                    }

                    otherlv_29=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_29, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_4_5());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalSasDsl.g:1240:3: (otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'reference-input' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' )
                    {
                    // InternalSasDsl.g:1240:3: (otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'reference-input' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' )
                    // InternalSasDsl.g:1241:4: otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'reference-input' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';'
                    {
                    otherlv_30=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_30, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_5_0());
                    			
                    // InternalSasDsl.g:1245:4: ( (otherlv_31= RULE_ID ) )
                    // InternalSasDsl.g:1246:5: (otherlv_31= RULE_ID )
                    {
                    // InternalSasDsl.g:1246:5: (otherlv_31= RULE_ID )
                    // InternalSasDsl.g:1247:6: otherlv_31= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_31=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_31, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_5_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1258:4: ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1259:5: ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1259:5: ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1260:6: (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1260:6: (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' )
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==16) ) {
                        alt20=1;
                    }
                    else if ( (LA20_0==17) ) {
                        alt20=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 0, input);

                        throw nvae;
                    }
                    switch (alt20) {
                        case 1 :
                            // InternalSasDsl.g:1261:7: lv_access_32_1= 'must-use'
                            {
                            lv_access_32_1=(Token)match(input,16,FOLLOW_21); 

                            							newLeafNode(lv_access_32_1, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustUseKeyword_5_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_32_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1272:7: lv_access_32_2= 'must-not-use'
                            {
                            lv_access_32_2=(Token)match(input,17,FOLLOW_21); 

                            							newLeafNode(lv_access_32_2, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustNotUseKeyword_5_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_32_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_33=(Token)match(input,26,FOLLOW_3); 

                    				newLeafNode(otherlv_33, grammarAccess.getDSLRuleAnalyzerAccess().getReferenceInputKeyword_5_3());
                    			
                    // InternalSasDsl.g:1289:4: ( (otherlv_34= RULE_ID ) )
                    // InternalSasDsl.g:1290:5: (otherlv_34= RULE_ID )
                    {
                    // InternalSasDsl.g:1290:5: (otherlv_34= RULE_ID )
                    // InternalSasDsl.g:1291:6: otherlv_34= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_34=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_34, grammarAccess.getDSLRuleAnalyzerAccess().getRreferenceDSLReferenceInputCrossReference_5_4_0());
                    					

                    }


                    }

                    otherlv_35=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_35, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_5_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalSasDsl.g:1308:3: (otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'alternative' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';' )
                    {
                    // InternalSasDsl.g:1308:3: (otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'alternative' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';' )
                    // InternalSasDsl.g:1309:4: otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'alternative' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';'
                    {
                    otherlv_36=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_36, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_6_0());
                    			
                    // InternalSasDsl.g:1313:4: ( (otherlv_37= RULE_ID ) )
                    // InternalSasDsl.g:1314:5: (otherlv_37= RULE_ID )
                    {
                    // InternalSasDsl.g:1314:5: (otherlv_37= RULE_ID )
                    // InternalSasDsl.g:1315:6: otherlv_37= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_37=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_37, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_6_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1326:4: ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1327:5: ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1327:5: ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1328:6: (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1328:6: (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==16) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==17) ) {
                        alt21=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;
                    }
                    switch (alt21) {
                        case 1 :
                            // InternalSasDsl.g:1329:7: lv_access_38_1= 'must-use'
                            {
                            lv_access_38_1=(Token)match(input,16,FOLLOW_22); 

                            							newLeafNode(lv_access_38_1, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustUseKeyword_6_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_38_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1340:7: lv_access_38_2= 'must-not-use'
                            {
                            lv_access_38_2=(Token)match(input,17,FOLLOW_22); 

                            							newLeafNode(lv_access_38_2, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustNotUseKeyword_6_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_38_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_39=(Token)match(input,27,FOLLOW_3); 

                    				newLeafNode(otherlv_39, grammarAccess.getDSLRuleAnalyzerAccess().getAlternativeKeyword_6_3());
                    			
                    // InternalSasDsl.g:1357:4: ( (otherlv_40= RULE_ID ) )
                    // InternalSasDsl.g:1358:5: (otherlv_40= RULE_ID )
                    {
                    // InternalSasDsl.g:1358:5: (otherlv_40= RULE_ID )
                    // InternalSasDsl.g:1359:6: otherlv_40= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_40=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_40, grammarAccess.getDSLRuleAnalyzerAccess().getShaltDSLAlternativeCrossReference_6_4_0());
                    					

                    }


                    }

                    otherlv_41=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_41, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_6_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLRuleAnalyzer"


    // $ANTLR start "entryRuleDSLRulePlanner"
    // InternalSasDsl.g:1379:1: entryRuleDSLRulePlanner returns [EObject current=null] : iv_ruleDSLRulePlanner= ruleDSLRulePlanner EOF ;
    public final EObject entryRuleDSLRulePlanner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRulePlanner = null;


        try {
            // InternalSasDsl.g:1379:55: (iv_ruleDSLRulePlanner= ruleDSLRulePlanner EOF )
            // InternalSasDsl.g:1380:2: iv_ruleDSLRulePlanner= ruleDSLRulePlanner EOF
            {
             newCompositeNode(grammarAccess.getDSLRulePlannerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLRulePlanner=ruleDSLRulePlanner();

            state._fsp--;

             current =iv_ruleDSLRulePlanner; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLRulePlanner"


    // $ANTLR start "ruleDSLRulePlanner"
    // InternalSasDsl.g:1386:1: ruleDSLRulePlanner returns [EObject current=null] : ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'planner' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) ) ;
    public final EObject ruleDSLRulePlanner() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_access_2_1=null;
        Token lv_access_2_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_access_8_1=null;
        Token lv_access_8_2=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_access_14_1=null;
        Token lv_access_14_2=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token lv_access_20_1=null;
        Token lv_access_20_2=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token lv_access_26_1=null;
        Token lv_access_26_2=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token lv_access_32_1=null;
        Token lv_access_32_2=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_35=null;


        	enterRule();

        try {
            // InternalSasDsl.g:1392:2: ( ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'planner' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) ) )
            // InternalSasDsl.g:1393:2: ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'planner' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) )
            {
            // InternalSasDsl.g:1393:2: ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'planner' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) )
            int alt29=6;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // InternalSasDsl.g:1394:3: (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:1394:3: (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:1395:4: otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_0_0());
                    			
                    // InternalSasDsl.g:1399:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:1400:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:1400:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:1401:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1412:4: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1413:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1413:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1414:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1414:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==16) ) {
                        alt23=1;
                    }
                    else if ( (LA23_0==17) ) {
                        alt23=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 0, input);

                        throw nvae;
                    }
                    switch (alt23) {
                        case 1 :
                            // InternalSasDsl.g:1415:7: lv_access_2_1= 'must-use'
                            {
                            lv_access_2_1=(Token)match(input,16,FOLLOW_15); 

                            							newLeafNode(lv_access_2_1, grammarAccess.getDSLRulePlannerAccess().getAccessMustUseKeyword_0_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_2_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1426:7: lv_access_2_2= 'must-not-use'
                            {
                            lv_access_2_2=(Token)match(input,17,FOLLOW_15); 

                            							newLeafNode(lv_access_2_2, grammarAccess.getDSLRulePlannerAccess().getAccessMustNotUseKeyword_0_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_2_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_3=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDSLRulePlannerAccess().getMonitorKeyword_0_3());
                    			
                    // InternalSasDsl.g:1443:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:1444:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:1444:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:1445:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRulePlannerAccess().getMonitorDSLMonitorCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:1462:3: (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:1462:3: (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:1463:4: otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_1_0());
                    			
                    // InternalSasDsl.g:1467:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:1468:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:1468:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:1469:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1480:4: ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1481:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1481:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1482:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1482:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==16) ) {
                        alt24=1;
                    }
                    else if ( (LA24_0==17) ) {
                        alt24=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 0, input);

                        throw nvae;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalSasDsl.g:1483:7: lv_access_8_1= 'must-use'
                            {
                            lv_access_8_1=(Token)match(input,16,FOLLOW_16); 

                            							newLeafNode(lv_access_8_1, grammarAccess.getDSLRulePlannerAccess().getAccessMustUseKeyword_1_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_8_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1494:7: lv_access_8_2= 'must-not-use'
                            {
                            lv_access_8_2=(Token)match(input,17,FOLLOW_16); 

                            							newLeafNode(lv_access_8_2, grammarAccess.getDSLRulePlannerAccess().getAccessMustNotUseKeyword_1_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_8_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_9=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getDSLRulePlannerAccess().getAnalyzerKeyword_1_3());
                    			
                    // InternalSasDsl.g:1511:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:1512:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:1512:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:1513:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRulePlannerAccess().getAnalyzerDSLAnalyzerCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:1530:3: (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:1530:3: (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:1531:4: otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_2_0());
                    			
                    // InternalSasDsl.g:1535:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:1536:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:1536:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:1537:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1548:4: ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1549:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1549:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1550:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1550:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==16) ) {
                        alt25=1;
                    }
                    else if ( (LA25_0==17) ) {
                        alt25=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 0, input);

                        throw nvae;
                    }
                    switch (alt25) {
                        case 1 :
                            // InternalSasDsl.g:1551:7: lv_access_14_1= 'must-use'
                            {
                            lv_access_14_1=(Token)match(input,16,FOLLOW_17); 

                            							newLeafNode(lv_access_14_1, grammarAccess.getDSLRulePlannerAccess().getAccessMustUseKeyword_2_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_14_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1562:7: lv_access_14_2= 'must-not-use'
                            {
                            lv_access_14_2=(Token)match(input,17,FOLLOW_17); 

                            							newLeafNode(lv_access_14_2, grammarAccess.getDSLRulePlannerAccess().getAccessMustNotUseKeyword_2_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_14_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_15=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_2_3());
                    			
                    // InternalSasDsl.g:1579:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:1580:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:1580:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:1581:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRulePlannerAccess().getPlanner2DSLPlannerCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:1598:3: (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    {
                    // InternalSasDsl.g:1598:3: (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    // InternalSasDsl.g:1599:4: otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';'
                    {
                    otherlv_18=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_3_0());
                    			
                    // InternalSasDsl.g:1603:4: ( (otherlv_19= RULE_ID ) )
                    // InternalSasDsl.g:1604:5: (otherlv_19= RULE_ID )
                    {
                    // InternalSasDsl.g:1604:5: (otherlv_19= RULE_ID )
                    // InternalSasDsl.g:1605:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_19, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1616:4: ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1617:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1617:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1618:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1618:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==16) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==17) ) {
                        alt26=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalSasDsl.g:1619:7: lv_access_20_1= 'must-use'
                            {
                            lv_access_20_1=(Token)match(input,16,FOLLOW_18); 

                            							newLeafNode(lv_access_20_1, grammarAccess.getDSLRulePlannerAccess().getAccessMustUseKeyword_3_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_20_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1630:7: lv_access_20_2= 'must-not-use'
                            {
                            lv_access_20_2=(Token)match(input,17,FOLLOW_18); 

                            							newLeafNode(lv_access_20_2, grammarAccess.getDSLRulePlannerAccess().getAccessMustNotUseKeyword_3_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_20_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_21=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_21, grammarAccess.getDSLRulePlannerAccess().getExecutorKeyword_3_3());
                    			
                    // InternalSasDsl.g:1647:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSasDsl.g:1648:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSasDsl.g:1648:5: (otherlv_22= RULE_ID )
                    // InternalSasDsl.g:1649:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_22, grammarAccess.getDSLRulePlannerAccess().getExecutorDSLExecutorCrossReference_3_4_0());
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_23, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_3_5());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalSasDsl.g:1666:3: (otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    {
                    // InternalSasDsl.g:1666:3: (otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    // InternalSasDsl.g:1667:4: otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';'
                    {
                    otherlv_24=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_24, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_4_0());
                    			
                    // InternalSasDsl.g:1671:4: ( (otherlv_25= RULE_ID ) )
                    // InternalSasDsl.g:1672:5: (otherlv_25= RULE_ID )
                    {
                    // InternalSasDsl.g:1672:5: (otherlv_25= RULE_ID )
                    // InternalSasDsl.g:1673:6: otherlv_25= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_25=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_25, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_4_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1684:4: ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1685:5: ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1685:5: ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1686:6: (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1686:6: (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' )
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==16) ) {
                        alt27=1;
                    }
                    else if ( (LA27_0==17) ) {
                        alt27=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 27, 0, input);

                        throw nvae;
                    }
                    switch (alt27) {
                        case 1 :
                            // InternalSasDsl.g:1687:7: lv_access_26_1= 'must-use'
                            {
                            lv_access_26_1=(Token)match(input,16,FOLLOW_19); 

                            							newLeafNode(lv_access_26_1, grammarAccess.getDSLRulePlannerAccess().getAccessMustUseKeyword_4_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_26_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1698:7: lv_access_26_2= 'must-not-use'
                            {
                            lv_access_26_2=(Token)match(input,17,FOLLOW_19); 

                            							newLeafNode(lv_access_26_2, grammarAccess.getDSLRulePlannerAccess().getAccessMustNotUseKeyword_4_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_26_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_27=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_27, grammarAccess.getDSLRulePlannerAccess().getKnowledgeKeyword_4_3());
                    			
                    // InternalSasDsl.g:1715:4: ( (otherlv_28= RULE_ID ) )
                    // InternalSasDsl.g:1716:5: (otherlv_28= RULE_ID )
                    {
                    // InternalSasDsl.g:1716:5: (otherlv_28= RULE_ID )
                    // InternalSasDsl.g:1717:6: otherlv_28= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_28=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_28, grammarAccess.getDSLRulePlannerAccess().getKnowledgeDSLKnowledgeCrossReference_4_4_0());
                    					

                    }


                    }

                    otherlv_29=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_29, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_4_5());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalSasDsl.g:1734:3: (otherlv_30= 'planner' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' )
                    {
                    // InternalSasDsl.g:1734:3: (otherlv_30= 'planner' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' )
                    // InternalSasDsl.g:1735:4: otherlv_30= 'planner' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';'
                    {
                    otherlv_30=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_30, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_5_0());
                    			
                    // InternalSasDsl.g:1739:4: ( (otherlv_31= RULE_ID ) )
                    // InternalSasDsl.g:1740:5: (otherlv_31= RULE_ID )
                    {
                    // InternalSasDsl.g:1740:5: (otherlv_31= RULE_ID )
                    // InternalSasDsl.g:1741:6: otherlv_31= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_31=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_31, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_5_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1752:4: ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1753:5: ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1753:5: ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1754:6: (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1754:6: (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==16) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==17) ) {
                        alt28=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 0, input);

                        throw nvae;
                    }
                    switch (alt28) {
                        case 1 :
                            // InternalSasDsl.g:1755:7: lv_access_32_1= 'must-use'
                            {
                            lv_access_32_1=(Token)match(input,16,FOLLOW_22); 

                            							newLeafNode(lv_access_32_1, grammarAccess.getDSLRulePlannerAccess().getAccessMustUseKeyword_5_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_32_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1766:7: lv_access_32_2= 'must-not-use'
                            {
                            lv_access_32_2=(Token)match(input,17,FOLLOW_22); 

                            							newLeafNode(lv_access_32_2, grammarAccess.getDSLRulePlannerAccess().getAccessMustNotUseKeyword_5_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_32_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_33=(Token)match(input,27,FOLLOW_3); 

                    				newLeafNode(otherlv_33, grammarAccess.getDSLRulePlannerAccess().getAlternativeKeyword_5_3());
                    			
                    // InternalSasDsl.g:1783:4: ( (otherlv_34= RULE_ID ) )
                    // InternalSasDsl.g:1784:5: (otherlv_34= RULE_ID )
                    {
                    // InternalSasDsl.g:1784:5: (otherlv_34= RULE_ID )
                    // InternalSasDsl.g:1785:6: otherlv_34= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_34=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_34, grammarAccess.getDSLRulePlannerAccess().getShaltDSLAlternativeCrossReference_5_4_0());
                    					

                    }


                    }

                    otherlv_35=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_35, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_5_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLRulePlanner"


    // $ANTLR start "entryRuleDSLRuleExecutor"
    // InternalSasDsl.g:1805:1: entryRuleDSLRuleExecutor returns [EObject current=null] : iv_ruleDSLRuleExecutor= ruleDSLRuleExecutor EOF ;
    public final EObject entryRuleDSLRuleExecutor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleExecutor = null;


        try {
            // InternalSasDsl.g:1805:56: (iv_ruleDSLRuleExecutor= ruleDSLRuleExecutor EOF )
            // InternalSasDsl.g:1806:2: iv_ruleDSLRuleExecutor= ruleDSLRuleExecutor EOF
            {
             newCompositeNode(grammarAccess.getDSLRuleExecutorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLRuleExecutor=ruleDSLRuleExecutor();

            state._fsp--;

             current =iv_ruleDSLRuleExecutor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLRuleExecutor"


    // $ANTLR start "ruleDSLRuleExecutor"
    // InternalSasDsl.g:1812:1: ruleDSLRuleExecutor returns [EObject current=null] : ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'executor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'executor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'effector' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) ) ;
    public final EObject ruleDSLRuleExecutor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_access_2_1=null;
        Token lv_access_2_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_access_8_1=null;
        Token lv_access_8_2=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_access_14_1=null;
        Token lv_access_14_2=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token lv_access_20_1=null;
        Token lv_access_20_2=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token lv_access_26_1=null;
        Token lv_access_26_2=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token lv_access_32_1=null;
        Token lv_access_32_2=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_35=null;


        	enterRule();

        try {
            // InternalSasDsl.g:1818:2: ( ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'executor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'executor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'effector' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) ) )
            // InternalSasDsl.g:1819:2: ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'executor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'executor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'effector' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) )
            {
            // InternalSasDsl.g:1819:2: ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'executor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'executor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'effector' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) )
            int alt36=6;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // InternalSasDsl.g:1820:3: (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:1820:3: (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:1821:4: otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_0_0());
                    			
                    // InternalSasDsl.g:1825:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:1826:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:1826:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:1827:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1838:4: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1839:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1839:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1840:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1840:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==16) ) {
                        alt30=1;
                    }
                    else if ( (LA30_0==17) ) {
                        alt30=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 0, input);

                        throw nvae;
                    }
                    switch (alt30) {
                        case 1 :
                            // InternalSasDsl.g:1841:7: lv_access_2_1= 'must-use'
                            {
                            lv_access_2_1=(Token)match(input,16,FOLLOW_15); 

                            							newLeafNode(lv_access_2_1, grammarAccess.getDSLRuleExecutorAccess().getAccessMustUseKeyword_0_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_2_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1852:7: lv_access_2_2= 'must-not-use'
                            {
                            lv_access_2_2=(Token)match(input,17,FOLLOW_15); 

                            							newLeafNode(lv_access_2_2, grammarAccess.getDSLRuleExecutorAccess().getAccessMustNotUseKeyword_0_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_2_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_3=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDSLRuleExecutorAccess().getMonitorKeyword_0_3());
                    			
                    // InternalSasDsl.g:1869:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:1870:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:1870:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:1871:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRuleExecutorAccess().getMonitorDSLMonitorCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRuleExecutorAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:1888:3: (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:1888:3: (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:1889:4: otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_1_0());
                    			
                    // InternalSasDsl.g:1893:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:1894:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:1894:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:1895:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1906:4: ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1907:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1907:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1908:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1908:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==16) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==17) ) {
                        alt31=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 31, 0, input);

                        throw nvae;
                    }
                    switch (alt31) {
                        case 1 :
                            // InternalSasDsl.g:1909:7: lv_access_8_1= 'must-use'
                            {
                            lv_access_8_1=(Token)match(input,16,FOLLOW_16); 

                            							newLeafNode(lv_access_8_1, grammarAccess.getDSLRuleExecutorAccess().getAccessMustUseKeyword_1_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_8_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1920:7: lv_access_8_2= 'must-not-use'
                            {
                            lv_access_8_2=(Token)match(input,17,FOLLOW_16); 

                            							newLeafNode(lv_access_8_2, grammarAccess.getDSLRuleExecutorAccess().getAccessMustNotUseKeyword_1_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_8_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_9=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getDSLRuleExecutorAccess().getAnalyzerKeyword_1_3());
                    			
                    // InternalSasDsl.g:1937:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:1938:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:1938:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:1939:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRuleExecutorAccess().getAnalyzerDSLAnalyzerCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRuleExecutorAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:1956:3: (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:1956:3: (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:1957:4: otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_2_0());
                    			
                    // InternalSasDsl.g:1961:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:1962:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:1962:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:1963:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1974:4: ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1975:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1975:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1976:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1976:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==16) ) {
                        alt32=1;
                    }
                    else if ( (LA32_0==17) ) {
                        alt32=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 32, 0, input);

                        throw nvae;
                    }
                    switch (alt32) {
                        case 1 :
                            // InternalSasDsl.g:1977:7: lv_access_14_1= 'must-use'
                            {
                            lv_access_14_1=(Token)match(input,16,FOLLOW_17); 

                            							newLeafNode(lv_access_14_1, grammarAccess.getDSLRuleExecutorAccess().getAccessMustUseKeyword_2_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_14_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1988:7: lv_access_14_2= 'must-not-use'
                            {
                            lv_access_14_2=(Token)match(input,17,FOLLOW_17); 

                            							newLeafNode(lv_access_14_2, grammarAccess.getDSLRuleExecutorAccess().getAccessMustNotUseKeyword_2_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_14_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_15=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getDSLRuleExecutorAccess().getPlannerKeyword_2_3());
                    			
                    // InternalSasDsl.g:2005:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:2006:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:2006:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:2007:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRuleExecutorAccess().getPlannerDSLPlannerCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRuleExecutorAccess().getSemicolonKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:2024:3: (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    {
                    // InternalSasDsl.g:2024:3: (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    // InternalSasDsl.g:2025:4: otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';'
                    {
                    otherlv_18=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_3_0());
                    			
                    // InternalSasDsl.g:2029:4: ( (otherlv_19= RULE_ID ) )
                    // InternalSasDsl.g:2030:5: (otherlv_19= RULE_ID )
                    {
                    // InternalSasDsl.g:2030:5: (otherlv_19= RULE_ID )
                    // InternalSasDsl.g:2031:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_19, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:2042:4: ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:2043:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:2043:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    // InternalSasDsl.g:2044:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:2044:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==16) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==17) ) {
                        alt33=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 0, input);

                        throw nvae;
                    }
                    switch (alt33) {
                        case 1 :
                            // InternalSasDsl.g:2045:7: lv_access_20_1= 'must-use'
                            {
                            lv_access_20_1=(Token)match(input,16,FOLLOW_18); 

                            							newLeafNode(lv_access_20_1, grammarAccess.getDSLRuleExecutorAccess().getAccessMustUseKeyword_3_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_20_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:2056:7: lv_access_20_2= 'must-not-use'
                            {
                            lv_access_20_2=(Token)match(input,17,FOLLOW_18); 

                            							newLeafNode(lv_access_20_2, grammarAccess.getDSLRuleExecutorAccess().getAccessMustNotUseKeyword_3_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_20_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_21=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_21, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_3_3());
                    			
                    // InternalSasDsl.g:2073:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSasDsl.g:2074:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSasDsl.g:2074:5: (otherlv_22= RULE_ID )
                    // InternalSasDsl.g:2075:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_22, grammarAccess.getDSLRuleExecutorAccess().getExecutor2DSLExecutorCrossReference_3_4_0());
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_23, grammarAccess.getDSLRuleExecutorAccess().getSemicolonKeyword_3_5());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalSasDsl.g:2092:3: (otherlv_24= 'executor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    {
                    // InternalSasDsl.g:2092:3: (otherlv_24= 'executor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    // InternalSasDsl.g:2093:4: otherlv_24= 'executor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';'
                    {
                    otherlv_24=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_24, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_4_0());
                    			
                    // InternalSasDsl.g:2097:4: ( (otherlv_25= RULE_ID ) )
                    // InternalSasDsl.g:2098:5: (otherlv_25= RULE_ID )
                    {
                    // InternalSasDsl.g:2098:5: (otherlv_25= RULE_ID )
                    // InternalSasDsl.g:2099:6: otherlv_25= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_25=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_25, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_4_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:2110:4: ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:2111:5: ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:2111:5: ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) )
                    // InternalSasDsl.g:2112:6: (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:2112:6: (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' )
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==16) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==17) ) {
                        alt34=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 34, 0, input);

                        throw nvae;
                    }
                    switch (alt34) {
                        case 1 :
                            // InternalSasDsl.g:2113:7: lv_access_26_1= 'must-use'
                            {
                            lv_access_26_1=(Token)match(input,16,FOLLOW_19); 

                            							newLeafNode(lv_access_26_1, grammarAccess.getDSLRuleExecutorAccess().getAccessMustUseKeyword_4_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_26_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:2124:7: lv_access_26_2= 'must-not-use'
                            {
                            lv_access_26_2=(Token)match(input,17,FOLLOW_19); 

                            							newLeafNode(lv_access_26_2, grammarAccess.getDSLRuleExecutorAccess().getAccessMustNotUseKeyword_4_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_26_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_27=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_27, grammarAccess.getDSLRuleExecutorAccess().getKnowledgeKeyword_4_3());
                    			
                    // InternalSasDsl.g:2141:4: ( (otherlv_28= RULE_ID ) )
                    // InternalSasDsl.g:2142:5: (otherlv_28= RULE_ID )
                    {
                    // InternalSasDsl.g:2142:5: (otherlv_28= RULE_ID )
                    // InternalSasDsl.g:2143:6: otherlv_28= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_28=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_28, grammarAccess.getDSLRuleExecutorAccess().getKnowledgeDSLKnowledgeCrossReference_4_4_0());
                    					

                    }


                    }

                    otherlv_29=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_29, grammarAccess.getDSLRuleExecutorAccess().getSemicolonKeyword_4_5());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalSasDsl.g:2160:3: (otherlv_30= 'executor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'effector' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' )
                    {
                    // InternalSasDsl.g:2160:3: (otherlv_30= 'executor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'effector' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' )
                    // InternalSasDsl.g:2161:4: otherlv_30= 'executor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'effector' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';'
                    {
                    otherlv_30=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_30, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_5_0());
                    			
                    // InternalSasDsl.g:2165:4: ( (otherlv_31= RULE_ID ) )
                    // InternalSasDsl.g:2166:5: (otherlv_31= RULE_ID )
                    {
                    // InternalSasDsl.g:2166:5: (otherlv_31= RULE_ID )
                    // InternalSasDsl.g:2167:6: otherlv_31= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_31=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_31, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_5_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:2178:4: ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:2179:5: ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:2179:5: ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) )
                    // InternalSasDsl.g:2180:6: (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:2180:6: (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' )
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==16) ) {
                        alt35=1;
                    }
                    else if ( (LA35_0==17) ) {
                        alt35=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 35, 0, input);

                        throw nvae;
                    }
                    switch (alt35) {
                        case 1 :
                            // InternalSasDsl.g:2181:7: lv_access_32_1= 'must-use'
                            {
                            lv_access_32_1=(Token)match(input,16,FOLLOW_23); 

                            							newLeafNode(lv_access_32_1, grammarAccess.getDSLRuleExecutorAccess().getAccessMustUseKeyword_5_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_32_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:2192:7: lv_access_32_2= 'must-not-use'
                            {
                            lv_access_32_2=(Token)match(input,17,FOLLOW_23); 

                            							newLeafNode(lv_access_32_2, grammarAccess.getDSLRuleExecutorAccess().getAccessMustNotUseKeyword_5_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_32_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_33=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_33, grammarAccess.getDSLRuleExecutorAccess().getEffectorKeyword_5_3());
                    			
                    // InternalSasDsl.g:2209:4: ( (otherlv_34= RULE_ID ) )
                    // InternalSasDsl.g:2210:5: (otherlv_34= RULE_ID )
                    {
                    // InternalSasDsl.g:2210:5: (otherlv_34= RULE_ID )
                    // InternalSasDsl.g:2211:6: otherlv_34= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_34=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_34, grammarAccess.getDSLRuleExecutorAccess().getEffectorDSLEffectorCrossReference_5_4_0());
                    					

                    }


                    }

                    otherlv_35=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_35, grammarAccess.getDSLRuleExecutorAccess().getSemicolonKeyword_5_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLRuleExecutor"


    // $ANTLR start "entryRuleDSLRuleKnowledge"
    // InternalSasDsl.g:2231:1: entryRuleDSLRuleKnowledge returns [EObject current=null] : iv_ruleDSLRuleKnowledge= ruleDSLRuleKnowledge EOF ;
    public final EObject entryRuleDSLRuleKnowledge() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleKnowledge = null;


        try {
            // InternalSasDsl.g:2231:57: (iv_ruleDSLRuleKnowledge= ruleDSLRuleKnowledge EOF )
            // InternalSasDsl.g:2232:2: iv_ruleDSLRuleKnowledge= ruleDSLRuleKnowledge EOF
            {
             newCompositeNode(grammarAccess.getDSLRuleKnowledgeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLRuleKnowledge=ruleDSLRuleKnowledge();

            state._fsp--;

             current =iv_ruleDSLRuleKnowledge; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLRuleKnowledge"


    // $ANTLR start "ruleDSLRuleKnowledge"
    // InternalSasDsl.g:2238:1: ruleDSLRuleKnowledge returns [EObject current=null] : ( (otherlv_0= 'knowledge' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'knowledge' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'knowledge' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'knowledge' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) ) ;
    public final EObject ruleDSLRuleKnowledge() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_access_2_1=null;
        Token lv_access_2_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_access_8_1=null;
        Token lv_access_8_2=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_access_14_1=null;
        Token lv_access_14_2=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token lv_access_20_1=null;
        Token lv_access_20_2=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2244:2: ( ( (otherlv_0= 'knowledge' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'knowledge' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'knowledge' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'knowledge' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) ) )
            // InternalSasDsl.g:2245:2: ( (otherlv_0= 'knowledge' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'knowledge' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'knowledge' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'knowledge' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) )
            {
            // InternalSasDsl.g:2245:2: ( (otherlv_0= 'knowledge' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'knowledge' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'knowledge' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'knowledge' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) )
            int alt41=4;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==24) ) {
                int LA41_1 = input.LA(2);

                if ( (LA41_1==RULE_ID) ) {
                    int LA41_2 = input.LA(3);

                    if ( (LA41_2==16) ) {
                        switch ( input.LA(4) ) {
                        case 22:
                            {
                            alt41=3;
                            }
                            break;
                        case 21:
                            {
                            alt41=2;
                            }
                            break;
                        case 20:
                            {
                            alt41=1;
                            }
                            break;
                        case 23:
                            {
                            alt41=4;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 41, 3, input);

                            throw nvae;
                        }

                    }
                    else if ( (LA41_2==17) ) {
                        switch ( input.LA(4) ) {
                        case 23:
                            {
                            alt41=4;
                            }
                            break;
                        case 22:
                            {
                            alt41=3;
                            }
                            break;
                        case 21:
                            {
                            alt41=2;
                            }
                            break;
                        case 20:
                            {
                            alt41=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 41, 4, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 41, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalSasDsl.g:2246:3: (otherlv_0= 'knowledge' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:2246:3: (otherlv_0= 'knowledge' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:2247:4: otherlv_0= 'knowledge' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRuleKnowledgeAccess().getKnowledgeKeyword_0_0());
                    			
                    // InternalSasDsl.g:2251:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:2252:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:2252:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:2253:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRuleKnowledgeAccess().getKnowledgeDSLKnowledgeCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:2264:4: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:2265:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:2265:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    // InternalSasDsl.g:2266:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:2266:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==16) ) {
                        alt37=1;
                    }
                    else if ( (LA37_0==17) ) {
                        alt37=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 37, 0, input);

                        throw nvae;
                    }
                    switch (alt37) {
                        case 1 :
                            // InternalSasDsl.g:2267:7: lv_access_2_1= 'must-use'
                            {
                            lv_access_2_1=(Token)match(input,16,FOLLOW_15); 

                            							newLeafNode(lv_access_2_1, grammarAccess.getDSLRuleKnowledgeAccess().getAccessMustUseKeyword_0_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_2_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:2278:7: lv_access_2_2= 'must-not-use'
                            {
                            lv_access_2_2=(Token)match(input,17,FOLLOW_15); 

                            							newLeafNode(lv_access_2_2, grammarAccess.getDSLRuleKnowledgeAccess().getAccessMustNotUseKeyword_0_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_2_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_3=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDSLRuleKnowledgeAccess().getMonitorKeyword_0_3());
                    			
                    // InternalSasDsl.g:2295:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:2296:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:2296:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:2297:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRuleKnowledgeAccess().getMonitorDSLMonitorCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRuleKnowledgeAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:2314:3: (otherlv_6= 'knowledge' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:2314:3: (otherlv_6= 'knowledge' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:2315:4: otherlv_6= 'knowledge' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRuleKnowledgeAccess().getKnowledgeKeyword_1_0());
                    			
                    // InternalSasDsl.g:2319:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:2320:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:2320:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:2321:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRuleKnowledgeAccess().getKnowledgeDSLKnowledgeCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:2332:4: ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:2333:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:2333:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    // InternalSasDsl.g:2334:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:2334:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==16) ) {
                        alt38=1;
                    }
                    else if ( (LA38_0==17) ) {
                        alt38=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 0, input);

                        throw nvae;
                    }
                    switch (alt38) {
                        case 1 :
                            // InternalSasDsl.g:2335:7: lv_access_8_1= 'must-use'
                            {
                            lv_access_8_1=(Token)match(input,16,FOLLOW_16); 

                            							newLeafNode(lv_access_8_1, grammarAccess.getDSLRuleKnowledgeAccess().getAccessMustUseKeyword_1_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_8_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:2346:7: lv_access_8_2= 'must-not-use'
                            {
                            lv_access_8_2=(Token)match(input,17,FOLLOW_16); 

                            							newLeafNode(lv_access_8_2, grammarAccess.getDSLRuleKnowledgeAccess().getAccessMustNotUseKeyword_1_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_8_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_9=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getDSLRuleKnowledgeAccess().getAnalyzerKeyword_1_3());
                    			
                    // InternalSasDsl.g:2363:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:2364:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:2364:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:2365:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRuleKnowledgeAccess().getAnalyzerDSLAnalyzerCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRuleKnowledgeAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:2382:3: (otherlv_12= 'knowledge' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:2382:3: (otherlv_12= 'knowledge' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:2383:4: otherlv_12= 'knowledge' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRuleKnowledgeAccess().getKnowledgeKeyword_2_0());
                    			
                    // InternalSasDsl.g:2387:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:2388:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:2388:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:2389:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRuleKnowledgeAccess().getKnowledgeDSLKnowledgeCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:2400:4: ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:2401:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:2401:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    // InternalSasDsl.g:2402:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:2402:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==16) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==17) ) {
                        alt39=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 0, input);

                        throw nvae;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalSasDsl.g:2403:7: lv_access_14_1= 'must-use'
                            {
                            lv_access_14_1=(Token)match(input,16,FOLLOW_17); 

                            							newLeafNode(lv_access_14_1, grammarAccess.getDSLRuleKnowledgeAccess().getAccessMustUseKeyword_2_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_14_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:2414:7: lv_access_14_2= 'must-not-use'
                            {
                            lv_access_14_2=(Token)match(input,17,FOLLOW_17); 

                            							newLeafNode(lv_access_14_2, grammarAccess.getDSLRuleKnowledgeAccess().getAccessMustNotUseKeyword_2_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_14_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_15=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getDSLRuleKnowledgeAccess().getPlannerKeyword_2_3());
                    			
                    // InternalSasDsl.g:2431:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:2432:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:2432:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:2433:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRuleKnowledgeAccess().getPlannerDSLPlannerCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRuleKnowledgeAccess().getSemicolonKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:2450:3: (otherlv_18= 'knowledge' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    {
                    // InternalSasDsl.g:2450:3: (otherlv_18= 'knowledge' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    // InternalSasDsl.g:2451:4: otherlv_18= 'knowledge' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';'
                    {
                    otherlv_18=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getDSLRuleKnowledgeAccess().getKnowledgeKeyword_3_0());
                    			
                    // InternalSasDsl.g:2455:4: ( (otherlv_19= RULE_ID ) )
                    // InternalSasDsl.g:2456:5: (otherlv_19= RULE_ID )
                    {
                    // InternalSasDsl.g:2456:5: (otherlv_19= RULE_ID )
                    // InternalSasDsl.g:2457:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_19, grammarAccess.getDSLRuleKnowledgeAccess().getKnowledgeDSLKnowledgeCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:2468:4: ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:2469:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:2469:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    // InternalSasDsl.g:2470:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:2470:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==16) ) {
                        alt40=1;
                    }
                    else if ( (LA40_0==17) ) {
                        alt40=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 40, 0, input);

                        throw nvae;
                    }
                    switch (alt40) {
                        case 1 :
                            // InternalSasDsl.g:2471:7: lv_access_20_1= 'must-use'
                            {
                            lv_access_20_1=(Token)match(input,16,FOLLOW_18); 

                            							newLeafNode(lv_access_20_1, grammarAccess.getDSLRuleKnowledgeAccess().getAccessMustUseKeyword_3_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_20_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:2482:7: lv_access_20_2= 'must-not-use'
                            {
                            lv_access_20_2=(Token)match(input,17,FOLLOW_18); 

                            							newLeafNode(lv_access_20_2, grammarAccess.getDSLRuleKnowledgeAccess().getAccessMustNotUseKeyword_3_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_20_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_21=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_21, grammarAccess.getDSLRuleKnowledgeAccess().getExecutorKeyword_3_3());
                    			
                    // InternalSasDsl.g:2499:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSasDsl.g:2500:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSasDsl.g:2500:5: (otherlv_22= RULE_ID )
                    // InternalSasDsl.g:2501:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_22, grammarAccess.getDSLRuleKnowledgeAccess().getExecutorDSLExecutorCrossReference_3_4_0());
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_23, grammarAccess.getDSLRuleKnowledgeAccess().getSemicolonKeyword_3_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLRuleKnowledge"


    // $ANTLR start "entryRuleDSLRuleMO"
    // InternalSasDsl.g:2521:1: entryRuleDSLRuleMO returns [EObject current=null] : iv_ruleDSLRuleMO= ruleDSLRuleMO EOF ;
    public final EObject entryRuleDSLRuleMO() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleMO = null;


        try {
            // InternalSasDsl.g:2521:50: (iv_ruleDSLRuleMO= ruleDSLRuleMO EOF )
            // InternalSasDsl.g:2522:2: iv_ruleDSLRuleMO= ruleDSLRuleMO EOF
            {
             newCompositeNode(grammarAccess.getDSLRuleMORule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLRuleMO=ruleDSLRuleMO();

            state._fsp--;

             current =iv_ruleDSLRuleMO; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLRuleMO"


    // $ANTLR start "ruleDSLRuleMO"
    // InternalSasDsl.g:2528:1: ruleDSLRuleMO returns [EObject current=null] : (otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) ;
    public final EObject ruleDSLRuleMO() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_access_2_1=null;
        Token lv_access_2_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2534:2: ( (otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) )
            // InternalSasDsl.g:2535:2: (otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            {
            // InternalSasDsl.g:2535:2: (otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            // InternalSasDsl.g:2536:3: otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLRuleMOAccess().getSensorKeyword_0());
            		
            // InternalSasDsl.g:2540:3: ( (otherlv_1= RULE_ID ) )
            // InternalSasDsl.g:2541:4: (otherlv_1= RULE_ID )
            {
            // InternalSasDsl.g:2541:4: (otherlv_1= RULE_ID )
            // InternalSasDsl.g:2542:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleMORule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(otherlv_1, grammarAccess.getDSLRuleMOAccess().getSensorDSLSensorCrossReference_1_0());
            				

            }


            }

            // InternalSasDsl.g:2553:3: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
            // InternalSasDsl.g:2554:4: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
            {
            // InternalSasDsl.g:2554:4: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
            // InternalSasDsl.g:2555:5: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
            {
            // InternalSasDsl.g:2555:5: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==16) ) {
                alt42=1;
            }
            else if ( (LA42_0==17) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalSasDsl.g:2556:6: lv_access_2_1= 'must-use'
                    {
                    lv_access_2_1=(Token)match(input,16,FOLLOW_24); 

                    						newLeafNode(lv_access_2_1, grammarAccess.getDSLRuleMOAccess().getAccessMustUseKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMORule());
                    						}
                    						setWithLastConsumed(current, "access", lv_access_2_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:2567:6: lv_access_2_2= 'must-not-use'
                    {
                    lv_access_2_2=(Token)match(input,17,FOLLOW_24); 

                    						newLeafNode(lv_access_2_2, grammarAccess.getDSLRuleMOAccess().getAccessMustNotUseKeyword_2_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMORule());
                    						}
                    						setWithLastConsumed(current, "access", lv_access_2_2, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_3=(Token)match(input,29,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getDSLRuleMOAccess().getMeasuredOutputKeyword_3());
            		
            // InternalSasDsl.g:2584:3: ( (otherlv_4= RULE_ID ) )
            // InternalSasDsl.g:2585:4: (otherlv_4= RULE_ID )
            {
            // InternalSasDsl.g:2585:4: (otherlv_4= RULE_ID )
            // InternalSasDsl.g:2586:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleMORule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(otherlv_4, grammarAccess.getDSLRuleMOAccess().getMeasuredDSLMeasuredOutputCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getDSLRuleMOAccess().getSemicolonKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLRuleMO"


    // $ANTLR start "entryRuleDSLManaging"
    // InternalSasDsl.g:2605:1: entryRuleDSLManaging returns [EObject current=null] : iv_ruleDSLManaging= ruleDSLManaging EOF ;
    public final EObject entryRuleDSLManaging() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLManaging = null;


        try {
            // InternalSasDsl.g:2605:52: (iv_ruleDSLManaging= ruleDSLManaging EOF )
            // InternalSasDsl.g:2606:2: iv_ruleDSLManaging= ruleDSLManaging EOF
            {
             newCompositeNode(grammarAccess.getDSLManagingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLManaging=ruleDSLManaging();

            state._fsp--;

             current =iv_ruleDSLManaging; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLManaging"


    // $ANTLR start "ruleDSLManaging"
    // InternalSasDsl.g:2612:1: ruleDSLManaging returns [EObject current=null] : (otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )* otherlv_5= '}' ) ;
    public final EObject ruleDSLManaging() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_managerController_3_0 = null;

        EObject lv_controller_4_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:2618:2: ( (otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )* otherlv_5= '}' ) )
            // InternalSasDsl.g:2619:2: (otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )* otherlv_5= '}' )
            {
            // InternalSasDsl.g:2619:2: (otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )* otherlv_5= '}' )
            // InternalSasDsl.g:2620:3: otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLManagingAccess().getManagingKeyword_0());
            		
            // InternalSasDsl.g:2624:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2625:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2625:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2626:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDSLManagingAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLManagingRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_25); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLManagingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalSasDsl.g:2646:3: ( (lv_managerController_3_0= ruleDSLManagerController ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==32) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalSasDsl.g:2647:4: (lv_managerController_3_0= ruleDSLManagerController )
            	    {
            	    // InternalSasDsl.g:2647:4: (lv_managerController_3_0= ruleDSLManagerController )
            	    // InternalSasDsl.g:2648:5: lv_managerController_3_0= ruleDSLManagerController
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagingAccess().getManagerControllerDSLManagerControllerParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_25);
            	    lv_managerController_3_0=ruleDSLManagerController();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSLManagingRule());
            	    					}
            	    					add(
            	    						current,
            	    						"managerController",
            	    						lv_managerController_3_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLManagerController");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            // InternalSasDsl.g:2665:3: ( (lv_controller_4_0= ruleDSLController ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==33) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalSasDsl.g:2666:4: (lv_controller_4_0= ruleDSLController )
            	    {
            	    // InternalSasDsl.g:2666:4: (lv_controller_4_0= ruleDSLController )
            	    // InternalSasDsl.g:2667:5: lv_controller_4_0= ruleDSLController
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagingAccess().getControllerDSLControllerParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_26);
            	    lv_controller_4_0=ruleDSLController();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSLManagingRule());
            	    					}
            	    					add(
            	    						current,
            	    						"controller",
            	    						lv_controller_4_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLController");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getDSLManagingAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLManaging"


    // $ANTLR start "entryRuleDSLManaged"
    // InternalSasDsl.g:2692:1: entryRuleDSLManaged returns [EObject current=null] : iv_ruleDSLManaged= ruleDSLManaged EOF ;
    public final EObject entryRuleDSLManaged() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLManaged = null;


        try {
            // InternalSasDsl.g:2692:51: (iv_ruleDSLManaged= ruleDSLManaged EOF )
            // InternalSasDsl.g:2693:2: iv_ruleDSLManaged= ruleDSLManaged EOF
            {
             newCompositeNode(grammarAccess.getDSLManagedRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLManaged=ruleDSLManaged();

            state._fsp--;

             current =iv_ruleDSLManaged; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLManaged"


    // $ANTLR start "ruleDSLManaged"
    // InternalSasDsl.g:2699:1: ruleDSLManaged returns [EObject current=null] : (otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )* ( (lv_effector_4_0= ruleDSLEffector ) )* ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )* ( (lv_structureElements_6_0= ruleDCLStructureElement ) )* otherlv_7= '}' ) ;
    public final EObject ruleDSLManaged() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_7=null;
        EObject lv_sensor_3_0 = null;

        EObject lv_effector_4_0 = null;

        EObject lv_measuredOutput_5_0 = null;

        EObject lv_structureElements_6_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:2705:2: ( (otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )* ( (lv_effector_4_0= ruleDSLEffector ) )* ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )* ( (lv_structureElements_6_0= ruleDCLStructureElement ) )* otherlv_7= '}' ) )
            // InternalSasDsl.g:2706:2: (otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )* ( (lv_effector_4_0= ruleDSLEffector ) )* ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )* ( (lv_structureElements_6_0= ruleDCLStructureElement ) )* otherlv_7= '}' )
            {
            // InternalSasDsl.g:2706:2: (otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )* ( (lv_effector_4_0= ruleDSLEffector ) )* ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )* ( (lv_structureElements_6_0= ruleDCLStructureElement ) )* otherlv_7= '}' )
            // InternalSasDsl.g:2707:3: otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )* ( (lv_effector_4_0= ruleDSLEffector ) )* ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )* ( (lv_structureElements_6_0= ruleDCLStructureElement ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLManagedAccess().getManagedKeyword_0());
            		
            // InternalSasDsl.g:2711:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2712:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2712:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2713:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDSLManagedAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLManagedRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_27); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLManagedAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalSasDsl.g:2733:3: ( (lv_sensor_3_0= ruleDSLSensor ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==40) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalSasDsl.g:2734:4: (lv_sensor_3_0= ruleDSLSensor )
            	    {
            	    // InternalSasDsl.g:2734:4: (lv_sensor_3_0= ruleDSLSensor )
            	    // InternalSasDsl.g:2735:5: lv_sensor_3_0= ruleDSLSensor
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagedAccess().getSensorDSLSensorParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_27);
            	    lv_sensor_3_0=ruleDSLSensor();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSLManagedRule());
            	    					}
            	    					add(
            	    						current,
            	    						"sensor",
            	    						lv_sensor_3_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLSensor");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            // InternalSasDsl.g:2752:3: ( (lv_effector_4_0= ruleDSLEffector ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==41) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalSasDsl.g:2753:4: (lv_effector_4_0= ruleDSLEffector )
            	    {
            	    // InternalSasDsl.g:2753:4: (lv_effector_4_0= ruleDSLEffector )
            	    // InternalSasDsl.g:2754:5: lv_effector_4_0= ruleDSLEffector
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagedAccess().getEffectorDSLEffectorParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_28);
            	    lv_effector_4_0=ruleDSLEffector();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSLManagedRule());
            	    					}
            	    					add(
            	    						current,
            	    						"effector",
            	    						lv_effector_4_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLEffector");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            // InternalSasDsl.g:2771:3: ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==43) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalSasDsl.g:2772:4: (lv_measuredOutput_5_0= ruleDSLMeasuredOutput )
            	    {
            	    // InternalSasDsl.g:2772:4: (lv_measuredOutput_5_0= ruleDSLMeasuredOutput )
            	    // InternalSasDsl.g:2773:5: lv_measuredOutput_5_0= ruleDSLMeasuredOutput
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagedAccess().getMeasuredOutputDSLMeasuredOutputParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_29);
            	    lv_measuredOutput_5_0=ruleDSLMeasuredOutput();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSLManagedRule());
            	    					}
            	    					add(
            	    						current,
            	    						"measuredOutput",
            	    						lv_measuredOutput_5_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLMeasuredOutput");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            // InternalSasDsl.g:2790:3: ( (lv_structureElements_6_0= ruleDCLStructureElement ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==45||(LA48_0>=51 && LA48_0<=52)||(LA48_0>=57 && LA48_0<=58)) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalSasDsl.g:2791:4: (lv_structureElements_6_0= ruleDCLStructureElement )
            	    {
            	    // InternalSasDsl.g:2791:4: (lv_structureElements_6_0= ruleDCLStructureElement )
            	    // InternalSasDsl.g:2792:5: lv_structureElements_6_0= ruleDCLStructureElement
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagedAccess().getStructureElementsDCLStructureElementParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_30);
            	    lv_structureElements_6_0=ruleDCLStructureElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSLManagedRule());
            	    					}
            	    					add(
            	    						current,
            	    						"structureElements",
            	    						lv_structureElements_6_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DCLStructureElement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

            otherlv_7=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getDSLManagedAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLManaged"


    // $ANTLR start "entryRuleDSLManagerController"
    // InternalSasDsl.g:2817:1: entryRuleDSLManagerController returns [EObject current=null] : iv_ruleDSLManagerController= ruleDSLManagerController EOF ;
    public final EObject entryRuleDSLManagerController() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLManagerController = null;


        try {
            // InternalSasDsl.g:2817:61: (iv_ruleDSLManagerController= ruleDSLManagerController EOF )
            // InternalSasDsl.g:2818:2: iv_ruleDSLManagerController= ruleDSLManagerController EOF
            {
             newCompositeNode(grammarAccess.getDSLManagerControllerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLManagerController=ruleDSLManagerController();

            state._fsp--;

             current =iv_ruleDSLManagerController; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLManagerController"


    // $ANTLR start "ruleDSLManagerController"
    // InternalSasDsl.g:2824:1: ruleDSLManagerController returns [EObject current=null] : (otherlv_0= 'LoopManager' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_controller_3_0= ruleDSLController ) )+ otherlv_4= '}' ) ;
    public final EObject ruleDSLManagerController() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_controller_3_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:2830:2: ( (otherlv_0= 'LoopManager' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_controller_3_0= ruleDSLController ) )+ otherlv_4= '}' ) )
            // InternalSasDsl.g:2831:2: (otherlv_0= 'LoopManager' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_controller_3_0= ruleDSLController ) )+ otherlv_4= '}' )
            {
            // InternalSasDsl.g:2831:2: (otherlv_0= 'LoopManager' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_controller_3_0= ruleDSLController ) )+ otherlv_4= '}' )
            // InternalSasDsl.g:2832:3: otherlv_0= 'LoopManager' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_controller_3_0= ruleDSLController ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLManagerControllerAccess().getLoopManagerKeyword_0());
            		
            // InternalSasDsl.g:2836:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2837:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2837:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2838:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDSLManagerControllerAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLManagerControllerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_31); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLManagerControllerAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalSasDsl.g:2858:3: ( (lv_controller_3_0= ruleDSLController ) )+
            int cnt49=0;
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==33) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalSasDsl.g:2859:4: (lv_controller_3_0= ruleDSLController )
            	    {
            	    // InternalSasDsl.g:2859:4: (lv_controller_3_0= ruleDSLController )
            	    // InternalSasDsl.g:2860:5: lv_controller_3_0= ruleDSLController
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagerControllerAccess().getControllerDSLControllerParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_26);
            	    lv_controller_3_0=ruleDSLController();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSLManagerControllerRule());
            	    					}
            	    					add(
            	    						current,
            	    						"controller",
            	    						lv_controller_3_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLController");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt49 >= 1 ) break loop49;
                        EarlyExitException eee =
                            new EarlyExitException(49, input);
                        throw eee;
                }
                cnt49++;
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getDSLManagerControllerAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLManagerController"


    // $ANTLR start "entryRuleDSLController"
    // InternalSasDsl.g:2885:1: entryRuleDSLController returns [EObject current=null] : iv_ruleDSLController= ruleDSLController EOF ;
    public final EObject entryRuleDSLController() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLController = null;


        try {
            // InternalSasDsl.g:2885:54: (iv_ruleDSLController= ruleDSLController EOF )
            // InternalSasDsl.g:2886:2: iv_ruleDSLController= ruleDSLController EOF
            {
             newCompositeNode(grammarAccess.getDSLControllerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLController=ruleDSLController();

            state._fsp--;

             current =iv_ruleDSLController; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLController"


    // $ANTLR start "ruleDSLController"
    // InternalSasDsl.g:2892:1: ruleDSLController returns [EObject current=null] : (otherlv_0= 'Loop' ( (lv_name_1_0= RULE_ID ) ) ( (lv_domain_2_0= ruleDSLDomainRule ) )? otherlv_3= '{' ( (lv_monitor_4_0= ruleDSLMonitor ) )* ( (lv_analyzer_5_0= ruleDSLAnalyzer ) )* ( (lv_planner_6_0= ruleDSLPlanner ) )* ( (lv_executor_7_0= ruleDSLExecutor ) )* ( (lv_knowledge_8_0= ruleDSLKnowledge ) )* otherlv_9= '}' ) ;
    public final EObject ruleDSLController() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_9=null;
        EObject lv_domain_2_0 = null;

        EObject lv_monitor_4_0 = null;

        EObject lv_analyzer_5_0 = null;

        EObject lv_planner_6_0 = null;

        EObject lv_executor_7_0 = null;

        EObject lv_knowledge_8_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:2898:2: ( (otherlv_0= 'Loop' ( (lv_name_1_0= RULE_ID ) ) ( (lv_domain_2_0= ruleDSLDomainRule ) )? otherlv_3= '{' ( (lv_monitor_4_0= ruleDSLMonitor ) )* ( (lv_analyzer_5_0= ruleDSLAnalyzer ) )* ( (lv_planner_6_0= ruleDSLPlanner ) )* ( (lv_executor_7_0= ruleDSLExecutor ) )* ( (lv_knowledge_8_0= ruleDSLKnowledge ) )* otherlv_9= '}' ) )
            // InternalSasDsl.g:2899:2: (otherlv_0= 'Loop' ( (lv_name_1_0= RULE_ID ) ) ( (lv_domain_2_0= ruleDSLDomainRule ) )? otherlv_3= '{' ( (lv_monitor_4_0= ruleDSLMonitor ) )* ( (lv_analyzer_5_0= ruleDSLAnalyzer ) )* ( (lv_planner_6_0= ruleDSLPlanner ) )* ( (lv_executor_7_0= ruleDSLExecutor ) )* ( (lv_knowledge_8_0= ruleDSLKnowledge ) )* otherlv_9= '}' )
            {
            // InternalSasDsl.g:2899:2: (otherlv_0= 'Loop' ( (lv_name_1_0= RULE_ID ) ) ( (lv_domain_2_0= ruleDSLDomainRule ) )? otherlv_3= '{' ( (lv_monitor_4_0= ruleDSLMonitor ) )* ( (lv_analyzer_5_0= ruleDSLAnalyzer ) )* ( (lv_planner_6_0= ruleDSLPlanner ) )* ( (lv_executor_7_0= ruleDSLExecutor ) )* ( (lv_knowledge_8_0= ruleDSLKnowledge ) )* otherlv_9= '}' )
            // InternalSasDsl.g:2900:3: otherlv_0= 'Loop' ( (lv_name_1_0= RULE_ID ) ) ( (lv_domain_2_0= ruleDSLDomainRule ) )? otherlv_3= '{' ( (lv_monitor_4_0= ruleDSLMonitor ) )* ( (lv_analyzer_5_0= ruleDSLAnalyzer ) )* ( (lv_planner_6_0= ruleDSLPlanner ) )* ( (lv_executor_7_0= ruleDSLExecutor ) )* ( (lv_knowledge_8_0= ruleDSLKnowledge ) )* otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLControllerAccess().getLoopKeyword_0());
            		
            // InternalSasDsl.g:2904:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2905:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2905:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2906:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDSLControllerAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLControllerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalSasDsl.g:2922:3: ( (lv_domain_2_0= ruleDSLDomainRule ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_ID||LA50_0==34) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalSasDsl.g:2923:4: (lv_domain_2_0= ruleDSLDomainRule )
                    {
                    // InternalSasDsl.g:2923:4: (lv_domain_2_0= ruleDSLDomainRule )
                    // InternalSasDsl.g:2924:5: lv_domain_2_0= ruleDSLDomainRule
                    {

                    					newCompositeNode(grammarAccess.getDSLControllerAccess().getDomainDSLDomainRuleParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_4);
                    lv_domain_2_0=ruleDSLDomainRule();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getDSLControllerRule());
                    					}
                    					set(
                    						current,
                    						"domain",
                    						lv_domain_2_0,
                    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLDomainRule");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,12,FOLLOW_33); 

            			newLeafNode(otherlv_3, grammarAccess.getDSLControllerAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalSasDsl.g:2945:3: ( (lv_monitor_4_0= ruleDSLMonitor ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==35) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalSasDsl.g:2946:4: (lv_monitor_4_0= ruleDSLMonitor )
            	    {
            	    // InternalSasDsl.g:2946:4: (lv_monitor_4_0= ruleDSLMonitor )
            	    // InternalSasDsl.g:2947:5: lv_monitor_4_0= ruleDSLMonitor
            	    {

            	    					newCompositeNode(grammarAccess.getDSLControllerAccess().getMonitorDSLMonitorParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_33);
            	    lv_monitor_4_0=ruleDSLMonitor();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSLControllerRule());
            	    					}
            	    					add(
            	    						current,
            	    						"monitor",
            	    						lv_monitor_4_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLMonitor");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

            // InternalSasDsl.g:2964:3: ( (lv_analyzer_5_0= ruleDSLAnalyzer ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==36) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalSasDsl.g:2965:4: (lv_analyzer_5_0= ruleDSLAnalyzer )
            	    {
            	    // InternalSasDsl.g:2965:4: (lv_analyzer_5_0= ruleDSLAnalyzer )
            	    // InternalSasDsl.g:2966:5: lv_analyzer_5_0= ruleDSLAnalyzer
            	    {

            	    					newCompositeNode(grammarAccess.getDSLControllerAccess().getAnalyzerDSLAnalyzerParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_34);
            	    lv_analyzer_5_0=ruleDSLAnalyzer();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSLControllerRule());
            	    					}
            	    					add(
            	    						current,
            	    						"analyzer",
            	    						lv_analyzer_5_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAnalyzer");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            // InternalSasDsl.g:2983:3: ( (lv_planner_6_0= ruleDSLPlanner ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==37) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalSasDsl.g:2984:4: (lv_planner_6_0= ruleDSLPlanner )
            	    {
            	    // InternalSasDsl.g:2984:4: (lv_planner_6_0= ruleDSLPlanner )
            	    // InternalSasDsl.g:2985:5: lv_planner_6_0= ruleDSLPlanner
            	    {

            	    					newCompositeNode(grammarAccess.getDSLControllerAccess().getPlannerDSLPlannerParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_35);
            	    lv_planner_6_0=ruleDSLPlanner();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSLControllerRule());
            	    					}
            	    					add(
            	    						current,
            	    						"planner",
            	    						lv_planner_6_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLPlanner");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            // InternalSasDsl.g:3002:3: ( (lv_executor_7_0= ruleDSLExecutor ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==38) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalSasDsl.g:3003:4: (lv_executor_7_0= ruleDSLExecutor )
            	    {
            	    // InternalSasDsl.g:3003:4: (lv_executor_7_0= ruleDSLExecutor )
            	    // InternalSasDsl.g:3004:5: lv_executor_7_0= ruleDSLExecutor
            	    {

            	    					newCompositeNode(grammarAccess.getDSLControllerAccess().getExecutorDSLExecutorParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_36);
            	    lv_executor_7_0=ruleDSLExecutor();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSLControllerRule());
            	    					}
            	    					add(
            	    						current,
            	    						"executor",
            	    						lv_executor_7_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLExecutor");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            // InternalSasDsl.g:3021:3: ( (lv_knowledge_8_0= ruleDSLKnowledge ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==39) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalSasDsl.g:3022:4: (lv_knowledge_8_0= ruleDSLKnowledge )
            	    {
            	    // InternalSasDsl.g:3022:4: (lv_knowledge_8_0= ruleDSLKnowledge )
            	    // InternalSasDsl.g:3023:5: lv_knowledge_8_0= ruleDSLKnowledge
            	    {

            	    					newCompositeNode(grammarAccess.getDSLControllerAccess().getKnowledgeDSLKnowledgeParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_37);
            	    lv_knowledge_8_0=ruleDSLKnowledge();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSLControllerRule());
            	    					}
            	    					add(
            	    						current,
            	    						"knowledge",
            	    						lv_knowledge_8_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLKnowledge");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            otherlv_9=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getDSLControllerAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLController"


    // $ANTLR start "entryRuleDSLDomainRule"
    // InternalSasDsl.g:3048:1: entryRuleDSLDomainRule returns [EObject current=null] : iv_ruleDSLDomainRule= ruleDSLDomainRule EOF ;
    public final EObject entryRuleDSLDomainRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLDomainRule = null;


        try {
            // InternalSasDsl.g:3048:54: (iv_ruleDSLDomainRule= ruleDSLDomainRule EOF )
            // InternalSasDsl.g:3049:2: iv_ruleDSLDomainRule= ruleDSLDomainRule EOF
            {
             newCompositeNode(grammarAccess.getDSLDomainRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLDomainRule=ruleDSLDomainRule();

            state._fsp--;

             current =iv_ruleDSLDomainRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLDomainRule"


    // $ANTLR start "ruleDSLDomainRule"
    // InternalSasDsl.g:3055:1: ruleDSLDomainRule returns [EObject current=null] : ( ( (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' ) ) ) ;
    public final EObject ruleDSLDomainRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_1=null;
        Token lv_value_0_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3061:2: ( ( ( (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' ) ) ) )
            // InternalSasDsl.g:3062:2: ( ( (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' ) ) )
            {
            // InternalSasDsl.g:3062:2: ( ( (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' ) ) )
            // InternalSasDsl.g:3063:3: ( (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' ) )
            {
            // InternalSasDsl.g:3063:3: ( (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' ) )
            // InternalSasDsl.g:3064:4: (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' )
            {
            // InternalSasDsl.g:3064:4: (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_ID) ) {
                alt56=1;
            }
            else if ( (LA56_0==34) ) {
                alt56=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // InternalSasDsl.g:3065:5: lv_value_0_1= RULE_ID
                    {
                    lv_value_0_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    					newLeafNode(lv_value_0_1, grammarAccess.getDSLDomainRuleAccess().getValueIDTerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDSLDomainRuleRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"value",
                    						lv_value_0_1,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:3080:5: lv_value_0_2= 'withDomainRules'
                    {
                    lv_value_0_2=(Token)match(input,34,FOLLOW_2); 

                    					newLeafNode(lv_value_0_2, grammarAccess.getDSLDomainRuleAccess().getValueWithDomainRulesKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDSLDomainRuleRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_2, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLDomainRule"


    // $ANTLR start "entryRuleDSLMonitor"
    // InternalSasDsl.g:3096:1: entryRuleDSLMonitor returns [EObject current=null] : iv_ruleDSLMonitor= ruleDSLMonitor EOF ;
    public final EObject entryRuleDSLMonitor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLMonitor = null;


        try {
            // InternalSasDsl.g:3096:51: (iv_ruleDSLMonitor= ruleDSLMonitor EOF )
            // InternalSasDsl.g:3097:2: iv_ruleDSLMonitor= ruleDSLMonitor EOF
            {
             newCompositeNode(grammarAccess.getDSLMonitorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLMonitor=ruleDSLMonitor();

            state._fsp--;

             current =iv_ruleDSLMonitor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLMonitor"


    // $ANTLR start "ruleDSLMonitor"
    // InternalSasDsl.g:3103:1: ruleDSLMonitor returns [EObject current=null] : (otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLMonitor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3109:2: ( (otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:3110:2: (otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:3110:2: (otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:3111:3: otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLMonitorAccess().getMonitorKeyword_0());
            		
            // InternalSasDsl.g:3115:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3116:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3116:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3117:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDSLMonitorAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLMonitorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLMonitorAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLMonitor"


    // $ANTLR start "entryRuleDSLAnalyzer"
    // InternalSasDsl.g:3141:1: entryRuleDSLAnalyzer returns [EObject current=null] : iv_ruleDSLAnalyzer= ruleDSLAnalyzer EOF ;
    public final EObject entryRuleDSLAnalyzer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLAnalyzer = null;


        try {
            // InternalSasDsl.g:3141:52: (iv_ruleDSLAnalyzer= ruleDSLAnalyzer EOF )
            // InternalSasDsl.g:3142:2: iv_ruleDSLAnalyzer= ruleDSLAnalyzer EOF
            {
             newCompositeNode(grammarAccess.getDSLAnalyzerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLAnalyzer=ruleDSLAnalyzer();

            state._fsp--;

             current =iv_ruleDSLAnalyzer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLAnalyzer"


    // $ANTLR start "ruleDSLAnalyzer"
    // InternalSasDsl.g:3148:1: ruleDSLAnalyzer returns [EObject current=null] : (otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLAnalyzer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3154:2: ( (otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:3155:2: (otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:3155:2: (otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:3156:3: otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLAnalyzerAccess().getAnalyzerKeyword_0());
            		
            // InternalSasDsl.g:3160:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3161:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3161:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3162:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDSLAnalyzerAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLAnalyzerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLAnalyzerAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLAnalyzer"


    // $ANTLR start "entryRuleDSLPlanner"
    // InternalSasDsl.g:3186:1: entryRuleDSLPlanner returns [EObject current=null] : iv_ruleDSLPlanner= ruleDSLPlanner EOF ;
    public final EObject entryRuleDSLPlanner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLPlanner = null;


        try {
            // InternalSasDsl.g:3186:51: (iv_ruleDSLPlanner= ruleDSLPlanner EOF )
            // InternalSasDsl.g:3187:2: iv_ruleDSLPlanner= ruleDSLPlanner EOF
            {
             newCompositeNode(grammarAccess.getDSLPlannerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLPlanner=ruleDSLPlanner();

            state._fsp--;

             current =iv_ruleDSLPlanner; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLPlanner"


    // $ANTLR start "ruleDSLPlanner"
    // InternalSasDsl.g:3193:1: ruleDSLPlanner returns [EObject current=null] : (otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLPlanner() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3199:2: ( (otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:3200:2: (otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:3200:2: (otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:3201:3: otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLPlannerAccess().getPlannerKeyword_0());
            		
            // InternalSasDsl.g:3205:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3206:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3206:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3207:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDSLPlannerAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLPlannerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLPlannerAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLPlanner"


    // $ANTLR start "entryRuleDSLExecutor"
    // InternalSasDsl.g:3231:1: entryRuleDSLExecutor returns [EObject current=null] : iv_ruleDSLExecutor= ruleDSLExecutor EOF ;
    public final EObject entryRuleDSLExecutor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLExecutor = null;


        try {
            // InternalSasDsl.g:3231:52: (iv_ruleDSLExecutor= ruleDSLExecutor EOF )
            // InternalSasDsl.g:3232:2: iv_ruleDSLExecutor= ruleDSLExecutor EOF
            {
             newCompositeNode(grammarAccess.getDSLExecutorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLExecutor=ruleDSLExecutor();

            state._fsp--;

             current =iv_ruleDSLExecutor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLExecutor"


    // $ANTLR start "ruleDSLExecutor"
    // InternalSasDsl.g:3238:1: ruleDSLExecutor returns [EObject current=null] : (otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLExecutor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3244:2: ( (otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:3245:2: (otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:3245:2: (otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:3246:3: otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLExecutorAccess().getExecutorKeyword_0());
            		
            // InternalSasDsl.g:3250:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3251:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3251:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3252:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDSLExecutorAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLExecutorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLExecutorAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLExecutor"


    // $ANTLR start "entryRuleDSLKnowledge"
    // InternalSasDsl.g:3276:1: entryRuleDSLKnowledge returns [EObject current=null] : iv_ruleDSLKnowledge= ruleDSLKnowledge EOF ;
    public final EObject entryRuleDSLKnowledge() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLKnowledge = null;


        try {
            // InternalSasDsl.g:3276:53: (iv_ruleDSLKnowledge= ruleDSLKnowledge EOF )
            // InternalSasDsl.g:3277:2: iv_ruleDSLKnowledge= ruleDSLKnowledge EOF
            {
             newCompositeNode(grammarAccess.getDSLKnowledgeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLKnowledge=ruleDSLKnowledge();

            state._fsp--;

             current =iv_ruleDSLKnowledge; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLKnowledge"


    // $ANTLR start "ruleDSLKnowledge"
    // InternalSasDsl.g:3283:1: ruleDSLKnowledge returns [EObject current=null] : (otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )* ( (lv_shalt_4_0= ruleDSLAlternative ) )* otherlv_5= '}' ) ;
    public final EObject ruleDSLKnowledge() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_referenceInput_3_0 = null;

        EObject lv_shalt_4_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:3289:2: ( (otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )* ( (lv_shalt_4_0= ruleDSLAlternative ) )* otherlv_5= '}' ) )
            // InternalSasDsl.g:3290:2: (otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )* ( (lv_shalt_4_0= ruleDSLAlternative ) )* otherlv_5= '}' )
            {
            // InternalSasDsl.g:3290:2: (otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )* ( (lv_shalt_4_0= ruleDSLAlternative ) )* otherlv_5= '}' )
            // InternalSasDsl.g:3291:3: otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )* ( (lv_shalt_4_0= ruleDSLAlternative ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLKnowledgeAccess().getKnowledgeKeyword_0());
            		
            // InternalSasDsl.g:3295:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3296:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3296:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3297:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDSLKnowledgeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLKnowledgeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_38); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLKnowledgeAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalSasDsl.g:3317:3: ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==42) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalSasDsl.g:3318:4: (lv_referenceInput_3_0= ruleDSLReferenceInput )
            	    {
            	    // InternalSasDsl.g:3318:4: (lv_referenceInput_3_0= ruleDSLReferenceInput )
            	    // InternalSasDsl.g:3319:5: lv_referenceInput_3_0= ruleDSLReferenceInput
            	    {

            	    					newCompositeNode(grammarAccess.getDSLKnowledgeAccess().getReferenceInputDSLReferenceInputParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_38);
            	    lv_referenceInput_3_0=ruleDSLReferenceInput();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSLKnowledgeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"referenceInput",
            	    						lv_referenceInput_3_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLReferenceInput");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            // InternalSasDsl.g:3336:3: ( (lv_shalt_4_0= ruleDSLAlternative ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==44) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalSasDsl.g:3337:4: (lv_shalt_4_0= ruleDSLAlternative )
            	    {
            	    // InternalSasDsl.g:3337:4: (lv_shalt_4_0= ruleDSLAlternative )
            	    // InternalSasDsl.g:3338:5: lv_shalt_4_0= ruleDSLAlternative
            	    {

            	    					newCompositeNode(grammarAccess.getDSLKnowledgeAccess().getShaltDSLAlternativeParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_39);
            	    lv_shalt_4_0=ruleDSLAlternative();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSLKnowledgeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"shalt",
            	    						lv_shalt_4_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAlternative");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getDSLKnowledgeAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLKnowledge"


    // $ANTLR start "entryRuleDSLSensor"
    // InternalSasDsl.g:3363:1: entryRuleDSLSensor returns [EObject current=null] : iv_ruleDSLSensor= ruleDSLSensor EOF ;
    public final EObject entryRuleDSLSensor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLSensor = null;


        try {
            // InternalSasDsl.g:3363:50: (iv_ruleDSLSensor= ruleDSLSensor EOF )
            // InternalSasDsl.g:3364:2: iv_ruleDSLSensor= ruleDSLSensor EOF
            {
             newCompositeNode(grammarAccess.getDSLSensorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLSensor=ruleDSLSensor();

            state._fsp--;

             current =iv_ruleDSLSensor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLSensor"


    // $ANTLR start "ruleDSLSensor"
    // InternalSasDsl.g:3370:1: ruleDSLSensor returns [EObject current=null] : (otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLSensor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3376:2: ( (otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:3377:2: (otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:3377:2: (otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:3378:3: otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLSensorAccess().getSensorKeyword_0());
            		
            // InternalSasDsl.g:3382:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3383:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3383:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3384:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDSLSensorAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLSensorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLSensorAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLSensor"


    // $ANTLR start "entryRuleDSLEffector"
    // InternalSasDsl.g:3408:1: entryRuleDSLEffector returns [EObject current=null] : iv_ruleDSLEffector= ruleDSLEffector EOF ;
    public final EObject entryRuleDSLEffector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLEffector = null;


        try {
            // InternalSasDsl.g:3408:52: (iv_ruleDSLEffector= ruleDSLEffector EOF )
            // InternalSasDsl.g:3409:2: iv_ruleDSLEffector= ruleDSLEffector EOF
            {
             newCompositeNode(grammarAccess.getDSLEffectorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLEffector=ruleDSLEffector();

            state._fsp--;

             current =iv_ruleDSLEffector; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLEffector"


    // $ANTLR start "ruleDSLEffector"
    // InternalSasDsl.g:3415:1: ruleDSLEffector returns [EObject current=null] : (otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLEffector() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3421:2: ( (otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:3422:2: (otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:3422:2: (otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:3423:3: otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLEffectorAccess().getEffectorKeyword_0());
            		
            // InternalSasDsl.g:3427:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3428:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3428:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3429:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDSLEffectorAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLEffectorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLEffectorAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLEffector"


    // $ANTLR start "entryRuleDSLReferenceInput"
    // InternalSasDsl.g:3453:1: entryRuleDSLReferenceInput returns [EObject current=null] : iv_ruleDSLReferenceInput= ruleDSLReferenceInput EOF ;
    public final EObject entryRuleDSLReferenceInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLReferenceInput = null;


        try {
            // InternalSasDsl.g:3453:58: (iv_ruleDSLReferenceInput= ruleDSLReferenceInput EOF )
            // InternalSasDsl.g:3454:2: iv_ruleDSLReferenceInput= ruleDSLReferenceInput EOF
            {
             newCompositeNode(grammarAccess.getDSLReferenceInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLReferenceInput=ruleDSLReferenceInput();

            state._fsp--;

             current =iv_ruleDSLReferenceInput; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLReferenceInput"


    // $ANTLR start "ruleDSLReferenceInput"
    // InternalSasDsl.g:3460:1: ruleDSLReferenceInput returns [EObject current=null] : (otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLReferenceInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3466:2: ( (otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:3467:2: (otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:3467:2: (otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:3468:3: otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLReferenceInputAccess().getReferenceInputKeyword_0());
            		
            // InternalSasDsl.g:3472:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3473:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3473:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3474:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDSLReferenceInputAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLReferenceInputRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLReferenceInputAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLReferenceInput"


    // $ANTLR start "entryRuleDSLMeasuredOutput"
    // InternalSasDsl.g:3498:1: entryRuleDSLMeasuredOutput returns [EObject current=null] : iv_ruleDSLMeasuredOutput= ruleDSLMeasuredOutput EOF ;
    public final EObject entryRuleDSLMeasuredOutput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLMeasuredOutput = null;


        try {
            // InternalSasDsl.g:3498:58: (iv_ruleDSLMeasuredOutput= ruleDSLMeasuredOutput EOF )
            // InternalSasDsl.g:3499:2: iv_ruleDSLMeasuredOutput= ruleDSLMeasuredOutput EOF
            {
             newCompositeNode(grammarAccess.getDSLMeasuredOutputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLMeasuredOutput=ruleDSLMeasuredOutput();

            state._fsp--;

             current =iv_ruleDSLMeasuredOutput; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLMeasuredOutput"


    // $ANTLR start "ruleDSLMeasuredOutput"
    // InternalSasDsl.g:3505:1: ruleDSLMeasuredOutput returns [EObject current=null] : (otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLMeasuredOutput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3511:2: ( (otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:3512:2: (otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:3512:2: (otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:3513:3: otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLMeasuredOutputAccess().getMeasuredOutputKeyword_0());
            		
            // InternalSasDsl.g:3517:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3518:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3518:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3519:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDSLMeasuredOutputAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLMeasuredOutputRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLMeasuredOutputAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLMeasuredOutput"


    // $ANTLR start "entryRuleDSLAlternative"
    // InternalSasDsl.g:3543:1: entryRuleDSLAlternative returns [EObject current=null] : iv_ruleDSLAlternative= ruleDSLAlternative EOF ;
    public final EObject entryRuleDSLAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLAlternative = null;


        try {
            // InternalSasDsl.g:3543:55: (iv_ruleDSLAlternative= ruleDSLAlternative EOF )
            // InternalSasDsl.g:3544:2: iv_ruleDSLAlternative= ruleDSLAlternative EOF
            {
             newCompositeNode(grammarAccess.getDSLAlternativeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLAlternative=ruleDSLAlternative();

            state._fsp--;

             current =iv_ruleDSLAlternative; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDSLAlternative"


    // $ANTLR start "ruleDSLAlternative"
    // InternalSasDsl.g:3550:1: ruleDSLAlternative returns [EObject current=null] : (otherlv_0= 'Alternative' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLAlternative() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3556:2: ( (otherlv_0= 'Alternative' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:3557:2: (otherlv_0= 'Alternative' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:3557:2: (otherlv_0= 'Alternative' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:3558:3: otherlv_0= 'Alternative' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLAlternativeAccess().getAlternativeKeyword_0());
            		
            // InternalSasDsl.g:3562:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3563:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3563:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3564:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDSLAlternativeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLAlternativeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLAlternativeAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDSLAlternative"


    // $ANTLR start "entryRuleDCLStructureElement"
    // InternalSasDsl.g:3588:1: entryRuleDCLStructureElement returns [EObject current=null] : iv_ruleDCLStructureElement= ruleDCLStructureElement EOF ;
    public final EObject entryRuleDCLStructureElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDCLStructureElement = null;


        try {
            // InternalSasDsl.g:3588:60: (iv_ruleDCLStructureElement= ruleDCLStructureElement EOF )
            // InternalSasDsl.g:3589:2: iv_ruleDCLStructureElement= ruleDCLStructureElement EOF
            {
             newCompositeNode(grammarAccess.getDCLStructureElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDCLStructureElement=ruleDCLStructureElement();

            state._fsp--;

             current =iv_ruleDCLStructureElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDCLStructureElement"


    // $ANTLR start "ruleDCLStructureElement"
    // InternalSasDsl.g:3595:1: ruleDCLStructureElement returns [EObject current=null] : (this_DCLLayer_0= ruleDCLLayer | this_DCLComponent_1= ruleDCLComponent | this_DCLSubSystem_2= ruleDCLSubSystem | this_DCLModule_3= ruleDCLModule | this_DCLComponentInterface_4= ruleDCLComponentInterface ) ;
    public final EObject ruleDCLStructureElement() throws RecognitionException {
        EObject current = null;

        EObject this_DCLLayer_0 = null;

        EObject this_DCLComponent_1 = null;

        EObject this_DCLSubSystem_2 = null;

        EObject this_DCLModule_3 = null;

        EObject this_DCLComponentInterface_4 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:3601:2: ( (this_DCLLayer_0= ruleDCLLayer | this_DCLComponent_1= ruleDCLComponent | this_DCLSubSystem_2= ruleDCLSubSystem | this_DCLModule_3= ruleDCLModule | this_DCLComponentInterface_4= ruleDCLComponentInterface ) )
            // InternalSasDsl.g:3602:2: (this_DCLLayer_0= ruleDCLLayer | this_DCLComponent_1= ruleDCLComponent | this_DCLSubSystem_2= ruleDCLSubSystem | this_DCLModule_3= ruleDCLModule | this_DCLComponentInterface_4= ruleDCLComponentInterface )
            {
            // InternalSasDsl.g:3602:2: (this_DCLLayer_0= ruleDCLLayer | this_DCLComponent_1= ruleDCLComponent | this_DCLSubSystem_2= ruleDCLSubSystem | this_DCLModule_3= ruleDCLModule | this_DCLComponentInterface_4= ruleDCLComponentInterface )
            int alt59=5;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt59=1;
                }
                break;
            case 51:
                {
                alt59=2;
                }
                break;
            case 57:
                {
                alt59=3;
                }
                break;
            case 58:
                {
                alt59=4;
                }
                break;
            case 52:
                {
                alt59=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // InternalSasDsl.g:3603:3: this_DCLLayer_0= ruleDCLLayer
                    {

                    			newCompositeNode(grammarAccess.getDCLStructureElementAccess().getDCLLayerParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_DCLLayer_0=ruleDCLLayer();

                    state._fsp--;


                    			current = this_DCLLayer_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:3612:3: this_DCLComponent_1= ruleDCLComponent
                    {

                    			newCompositeNode(grammarAccess.getDCLStructureElementAccess().getDCLComponentParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_DCLComponent_1=ruleDCLComponent();

                    state._fsp--;


                    			current = this_DCLComponent_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:3621:3: this_DCLSubSystem_2= ruleDCLSubSystem
                    {

                    			newCompositeNode(grammarAccess.getDCLStructureElementAccess().getDCLSubSystemParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_DCLSubSystem_2=ruleDCLSubSystem();

                    state._fsp--;


                    			current = this_DCLSubSystem_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:3630:3: this_DCLModule_3= ruleDCLModule
                    {

                    			newCompositeNode(grammarAccess.getDCLStructureElementAccess().getDCLModuleParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_DCLModule_3=ruleDCLModule();

                    state._fsp--;


                    			current = this_DCLModule_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalSasDsl.g:3639:3: this_DCLComponentInterface_4= ruleDCLComponentInterface
                    {

                    			newCompositeNode(grammarAccess.getDCLStructureElementAccess().getDCLComponentInterfaceParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_DCLComponentInterface_4=ruleDCLComponentInterface();

                    state._fsp--;


                    			current = this_DCLComponentInterface_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDCLStructureElement"


    // $ANTLR start "entryRuleDCLLayer"
    // InternalSasDsl.g:3651:1: entryRuleDCLLayer returns [EObject current=null] : iv_ruleDCLLayer= ruleDCLLayer EOF ;
    public final EObject entryRuleDCLLayer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDCLLayer = null;


        try {
            // InternalSasDsl.g:3651:49: (iv_ruleDCLLayer= ruleDCLLayer EOF )
            // InternalSasDsl.g:3652:2: iv_ruleDCLLayer= ruleDCLLayer EOF
            {
             newCompositeNode(grammarAccess.getDCLLayerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDCLLayer=ruleDCLLayer();

            state._fsp--;

             current =iv_ruleDCLLayer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDCLLayer"


    // $ANTLR start "ruleDCLLayer"
    // InternalSasDsl.g:3658:1: ruleDCLLayer returns [EObject current=null] : (otherlv_0= 'layer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ',' otherlv_3= 'level' ( (lv_level_4_0= RULE_INT ) ) ( (otherlv_5= ',' otherlv_6= 'inLayer: ' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= ',' otherlv_9= 'inSubSystem: ' ( (otherlv_10= RULE_ID ) ) ) | (otherlv_11= ',' otherlv_12= 'inComponent: ' ( (otherlv_13= RULE_ID ) ) ) )? otherlv_14= ';' ) ;
    public final EObject ruleDCLLayer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_level_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3664:2: ( (otherlv_0= 'layer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ',' otherlv_3= 'level' ( (lv_level_4_0= RULE_INT ) ) ( (otherlv_5= ',' otherlv_6= 'inLayer: ' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= ',' otherlv_9= 'inSubSystem: ' ( (otherlv_10= RULE_ID ) ) ) | (otherlv_11= ',' otherlv_12= 'inComponent: ' ( (otherlv_13= RULE_ID ) ) ) )? otherlv_14= ';' ) )
            // InternalSasDsl.g:3665:2: (otherlv_0= 'layer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ',' otherlv_3= 'level' ( (lv_level_4_0= RULE_INT ) ) ( (otherlv_5= ',' otherlv_6= 'inLayer: ' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= ',' otherlv_9= 'inSubSystem: ' ( (otherlv_10= RULE_ID ) ) ) | (otherlv_11= ',' otherlv_12= 'inComponent: ' ( (otherlv_13= RULE_ID ) ) ) )? otherlv_14= ';' )
            {
            // InternalSasDsl.g:3665:2: (otherlv_0= 'layer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ',' otherlv_3= 'level' ( (lv_level_4_0= RULE_INT ) ) ( (otherlv_5= ',' otherlv_6= 'inLayer: ' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= ',' otherlv_9= 'inSubSystem: ' ( (otherlv_10= RULE_ID ) ) ) | (otherlv_11= ',' otherlv_12= 'inComponent: ' ( (otherlv_13= RULE_ID ) ) ) )? otherlv_14= ';' )
            // InternalSasDsl.g:3666:3: otherlv_0= 'layer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ',' otherlv_3= 'level' ( (lv_level_4_0= RULE_INT ) ) ( (otherlv_5= ',' otherlv_6= 'inLayer: ' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= ',' otherlv_9= 'inSubSystem: ' ( (otherlv_10= RULE_ID ) ) ) | (otherlv_11= ',' otherlv_12= 'inComponent: ' ( (otherlv_13= RULE_ID ) ) ) )? otherlv_14= ';'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDCLLayerAccess().getLayerKeyword_0());
            		
            // InternalSasDsl.g:3670:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3671:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3671:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3672:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_40); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDCLLayerAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDCLLayerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,46,FOLLOW_41); 

            			newLeafNode(otherlv_2, grammarAccess.getDCLLayerAccess().getCommaKeyword_2());
            		
            otherlv_3=(Token)match(input,47,FOLLOW_42); 

            			newLeafNode(otherlv_3, grammarAccess.getDCLLayerAccess().getLevelKeyword_3());
            		
            // InternalSasDsl.g:3696:3: ( (lv_level_4_0= RULE_INT ) )
            // InternalSasDsl.g:3697:4: (lv_level_4_0= RULE_INT )
            {
            // InternalSasDsl.g:3697:4: (lv_level_4_0= RULE_INT )
            // InternalSasDsl.g:3698:5: lv_level_4_0= RULE_INT
            {
            lv_level_4_0=(Token)match(input,RULE_INT,FOLLOW_43); 

            					newLeafNode(lv_level_4_0, grammarAccess.getDCLLayerAccess().getLevelINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDCLLayerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"level",
            						lv_level_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalSasDsl.g:3714:3: ( (otherlv_5= ',' otherlv_6= 'inLayer: ' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= ',' otherlv_9= 'inSubSystem: ' ( (otherlv_10= RULE_ID ) ) ) | (otherlv_11= ',' otherlv_12= 'inComponent: ' ( (otherlv_13= RULE_ID ) ) ) )?
            int alt60=4;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==46) ) {
                switch ( input.LA(2) ) {
                    case 49:
                        {
                        alt60=2;
                        }
                        break;
                    case 50:
                        {
                        alt60=3;
                        }
                        break;
                    case 48:
                        {
                        alt60=1;
                        }
                        break;
                }

            }
            switch (alt60) {
                case 1 :
                    // InternalSasDsl.g:3715:4: (otherlv_5= ',' otherlv_6= 'inLayer: ' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalSasDsl.g:3715:4: (otherlv_5= ',' otherlv_6= 'inLayer: ' ( (otherlv_7= RULE_ID ) ) )
                    // InternalSasDsl.g:3716:5: otherlv_5= ',' otherlv_6= 'inLayer: ' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_5=(Token)match(input,46,FOLLOW_44); 

                    					newLeafNode(otherlv_5, grammarAccess.getDCLLayerAccess().getCommaKeyword_5_0_0());
                    				
                    otherlv_6=(Token)match(input,48,FOLLOW_3); 

                    					newLeafNode(otherlv_6, grammarAccess.getDCLLayerAccess().getInLayerKeyword_5_0_1());
                    				
                    // InternalSasDsl.g:3724:5: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:3725:6: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:3725:6: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:3726:7: otherlv_7= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getDCLLayerRule());
                    							}
                    						
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_13); 

                    							newLeafNode(otherlv_7, grammarAccess.getDCLLayerAccess().getLayerDCLStructureElementCrossReference_5_0_2_0());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:3739:4: (otherlv_8= ',' otherlv_9= 'inSubSystem: ' ( (otherlv_10= RULE_ID ) ) )
                    {
                    // InternalSasDsl.g:3739:4: (otherlv_8= ',' otherlv_9= 'inSubSystem: ' ( (otherlv_10= RULE_ID ) ) )
                    // InternalSasDsl.g:3740:5: otherlv_8= ',' otherlv_9= 'inSubSystem: ' ( (otherlv_10= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,46,FOLLOW_45); 

                    					newLeafNode(otherlv_8, grammarAccess.getDCLLayerAccess().getCommaKeyword_5_1_0());
                    				
                    otherlv_9=(Token)match(input,49,FOLLOW_3); 

                    					newLeafNode(otherlv_9, grammarAccess.getDCLLayerAccess().getInSubSystemKeyword_5_1_1());
                    				
                    // InternalSasDsl.g:3748:5: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:3749:6: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:3749:6: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:3750:7: otherlv_10= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getDCLLayerRule());
                    							}
                    						
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_13); 

                    							newLeafNode(otherlv_10, grammarAccess.getDCLLayerAccess().getSubSystemDCLStructureElementCrossReference_5_1_2_0());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:3763:4: (otherlv_11= ',' otherlv_12= 'inComponent: ' ( (otherlv_13= RULE_ID ) ) )
                    {
                    // InternalSasDsl.g:3763:4: (otherlv_11= ',' otherlv_12= 'inComponent: ' ( (otherlv_13= RULE_ID ) ) )
                    // InternalSasDsl.g:3764:5: otherlv_11= ',' otherlv_12= 'inComponent: ' ( (otherlv_13= RULE_ID ) )
                    {
                    otherlv_11=(Token)match(input,46,FOLLOW_46); 

                    					newLeafNode(otherlv_11, grammarAccess.getDCLLayerAccess().getCommaKeyword_5_2_0());
                    				
                    otherlv_12=(Token)match(input,50,FOLLOW_3); 

                    					newLeafNode(otherlv_12, grammarAccess.getDCLLayerAccess().getInComponentKeyword_5_2_1());
                    				
                    // InternalSasDsl.g:3772:5: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:3773:6: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:3773:6: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:3774:7: otherlv_13= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getDCLLayerRule());
                    							}
                    						
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_13); 

                    							newLeafNode(otherlv_13, grammarAccess.getDCLLayerAccess().getComponentDCLStructureElementCrossReference_5_2_2_0());
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_14=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getDCLLayerAccess().getSemicolonKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDCLLayer"


    // $ANTLR start "entryRuleDCLComponent"
    // InternalSasDsl.g:3795:1: entryRuleDCLComponent returns [EObject current=null] : iv_ruleDCLComponent= ruleDCLComponent EOF ;
    public final EObject entryRuleDCLComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDCLComponent = null;


        try {
            // InternalSasDsl.g:3795:53: (iv_ruleDCLComponent= ruleDCLComponent EOF )
            // InternalSasDsl.g:3796:2: iv_ruleDCLComponent= ruleDCLComponent EOF
            {
             newCompositeNode(grammarAccess.getDCLComponentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDCLComponent=ruleDCLComponent();

            state._fsp--;

             current =iv_ruleDCLComponent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDCLComponent"


    // $ANTLR start "ruleDCLComponent"
    // InternalSasDsl.g:3802:1: ruleDCLComponent returns [EObject current=null] : (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= ',' otherlv_3= 'inLayer: ' ( (otherlv_4= RULE_ID ) ) ) | (otherlv_5= ',' otherlv_6= 'inSubSystem: ' ( (otherlv_7= RULE_ID ) ) ) )? otherlv_8= ';' ) ;
    public final EObject ruleDCLComponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3808:2: ( (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= ',' otherlv_3= 'inLayer: ' ( (otherlv_4= RULE_ID ) ) ) | (otherlv_5= ',' otherlv_6= 'inSubSystem: ' ( (otherlv_7= RULE_ID ) ) ) )? otherlv_8= ';' ) )
            // InternalSasDsl.g:3809:2: (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= ',' otherlv_3= 'inLayer: ' ( (otherlv_4= RULE_ID ) ) ) | (otherlv_5= ',' otherlv_6= 'inSubSystem: ' ( (otherlv_7= RULE_ID ) ) ) )? otherlv_8= ';' )
            {
            // InternalSasDsl.g:3809:2: (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= ',' otherlv_3= 'inLayer: ' ( (otherlv_4= RULE_ID ) ) ) | (otherlv_5= ',' otherlv_6= 'inSubSystem: ' ( (otherlv_7= RULE_ID ) ) ) )? otherlv_8= ';' )
            // InternalSasDsl.g:3810:3: otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= ',' otherlv_3= 'inLayer: ' ( (otherlv_4= RULE_ID ) ) ) | (otherlv_5= ',' otherlv_6= 'inSubSystem: ' ( (otherlv_7= RULE_ID ) ) ) )? otherlv_8= ';'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDCLComponentAccess().getComponentKeyword_0());
            		
            // InternalSasDsl.g:3814:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3815:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3815:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3816:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_43); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDCLComponentAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDCLComponentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalSasDsl.g:3832:3: ( (otherlv_2= ',' otherlv_3= 'inLayer: ' ( (otherlv_4= RULE_ID ) ) ) | (otherlv_5= ',' otherlv_6= 'inSubSystem: ' ( (otherlv_7= RULE_ID ) ) ) )?
            int alt61=3;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==46) ) {
                int LA61_1 = input.LA(2);

                if ( (LA61_1==48) ) {
                    alt61=1;
                }
                else if ( (LA61_1==49) ) {
                    alt61=2;
                }
            }
            switch (alt61) {
                case 1 :
                    // InternalSasDsl.g:3833:4: (otherlv_2= ',' otherlv_3= 'inLayer: ' ( (otherlv_4= RULE_ID ) ) )
                    {
                    // InternalSasDsl.g:3833:4: (otherlv_2= ',' otherlv_3= 'inLayer: ' ( (otherlv_4= RULE_ID ) ) )
                    // InternalSasDsl.g:3834:5: otherlv_2= ',' otherlv_3= 'inLayer: ' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,46,FOLLOW_44); 

                    					newLeafNode(otherlv_2, grammarAccess.getDCLComponentAccess().getCommaKeyword_2_0_0());
                    				
                    otherlv_3=(Token)match(input,48,FOLLOW_3); 

                    					newLeafNode(otherlv_3, grammarAccess.getDCLComponentAccess().getInLayerKeyword_2_0_1());
                    				
                    // InternalSasDsl.g:3842:5: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:3843:6: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:3843:6: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:3844:7: otherlv_4= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getDCLComponentRule());
                    							}
                    						
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_13); 

                    							newLeafNode(otherlv_4, grammarAccess.getDCLComponentAccess().getLayerDCLStructureElementCrossReference_2_0_2_0());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:3857:4: (otherlv_5= ',' otherlv_6= 'inSubSystem: ' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalSasDsl.g:3857:4: (otherlv_5= ',' otherlv_6= 'inSubSystem: ' ( (otherlv_7= RULE_ID ) ) )
                    // InternalSasDsl.g:3858:5: otherlv_5= ',' otherlv_6= 'inSubSystem: ' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_5=(Token)match(input,46,FOLLOW_45); 

                    					newLeafNode(otherlv_5, grammarAccess.getDCLComponentAccess().getCommaKeyword_2_1_0());
                    				
                    otherlv_6=(Token)match(input,49,FOLLOW_3); 

                    					newLeafNode(otherlv_6, grammarAccess.getDCLComponentAccess().getInSubSystemKeyword_2_1_1());
                    				
                    // InternalSasDsl.g:3866:5: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:3867:6: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:3867:6: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:3868:7: otherlv_7= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getDCLComponentRule());
                    							}
                    						
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_13); 

                    							newLeafNode(otherlv_7, grammarAccess.getDCLComponentAccess().getSubSystemDCLStructureElementCrossReference_2_1_2_0());
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getDCLComponentAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDCLComponent"


    // $ANTLR start "entryRuleDCLComponentInterface"
    // InternalSasDsl.g:3889:1: entryRuleDCLComponentInterface returns [EObject current=null] : iv_ruleDCLComponentInterface= ruleDCLComponentInterface EOF ;
    public final EObject entryRuleDCLComponentInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDCLComponentInterface = null;


        try {
            // InternalSasDsl.g:3889:62: (iv_ruleDCLComponentInterface= ruleDCLComponentInterface EOF )
            // InternalSasDsl.g:3890:2: iv_ruleDCLComponentInterface= ruleDCLComponentInterface EOF
            {
             newCompositeNode(grammarAccess.getDCLComponentInterfaceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDCLComponentInterface=ruleDCLComponentInterface();

            state._fsp--;

             current =iv_ruleDCLComponentInterface; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDCLComponentInterface"


    // $ANTLR start "ruleDCLComponentInterface"
    // InternalSasDsl.g:3896:1: ruleDCLComponentInterface returns [EObject current=null] : (otherlv_0= 'interface' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ofComponent ' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'type: ' ( (lv_interfaceType_6_0= ruleInterfaceType ) ) ) otherlv_7= ';' ) ;
    public final EObject ruleDCLComponentInterface() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_interfaceType_6_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:3902:2: ( (otherlv_0= 'interface' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ofComponent ' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'type: ' ( (lv_interfaceType_6_0= ruleInterfaceType ) ) ) otherlv_7= ';' ) )
            // InternalSasDsl.g:3903:2: (otherlv_0= 'interface' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ofComponent ' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'type: ' ( (lv_interfaceType_6_0= ruleInterfaceType ) ) ) otherlv_7= ';' )
            {
            // InternalSasDsl.g:3903:2: (otherlv_0= 'interface' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ofComponent ' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'type: ' ( (lv_interfaceType_6_0= ruleInterfaceType ) ) ) otherlv_7= ';' )
            // InternalSasDsl.g:3904:3: otherlv_0= 'interface' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ofComponent ' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'type: ' ( (lv_interfaceType_6_0= ruleInterfaceType ) ) ) otherlv_7= ';'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDCLComponentInterfaceAccess().getInterfaceKeyword_0());
            		
            // InternalSasDsl.g:3908:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3909:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3909:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3910:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_47); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDCLComponentInterfaceAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDCLComponentInterfaceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,53,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getDCLComponentInterfaceAccess().getOfComponentKeyword_2());
            		
            // InternalSasDsl.g:3930:3: ( (otherlv_3= RULE_ID ) )
            // InternalSasDsl.g:3931:4: (otherlv_3= RULE_ID )
            {
            // InternalSasDsl.g:3931:4: (otherlv_3= RULE_ID )
            // InternalSasDsl.g:3932:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDCLComponentInterfaceRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_40); 

            					newLeafNode(otherlv_3, grammarAccess.getDCLComponentInterfaceAccess().getComponentDCLStructureElementCrossReference_3_0());
            				

            }


            }

            // InternalSasDsl.g:3943:3: (otherlv_4= ',' otherlv_5= 'type: ' ( (lv_interfaceType_6_0= ruleInterfaceType ) ) )
            // InternalSasDsl.g:3944:4: otherlv_4= ',' otherlv_5= 'type: ' ( (lv_interfaceType_6_0= ruleInterfaceType ) )
            {
            otherlv_4=(Token)match(input,46,FOLLOW_48); 

            				newLeafNode(otherlv_4, grammarAccess.getDCLComponentInterfaceAccess().getCommaKeyword_4_0());
            			
            otherlv_5=(Token)match(input,54,FOLLOW_49); 

            				newLeafNode(otherlv_5, grammarAccess.getDCLComponentInterfaceAccess().getTypeKeyword_4_1());
            			
            // InternalSasDsl.g:3952:4: ( (lv_interfaceType_6_0= ruleInterfaceType ) )
            // InternalSasDsl.g:3953:5: (lv_interfaceType_6_0= ruleInterfaceType )
            {
            // InternalSasDsl.g:3953:5: (lv_interfaceType_6_0= ruleInterfaceType )
            // InternalSasDsl.g:3954:6: lv_interfaceType_6_0= ruleInterfaceType
            {

            						newCompositeNode(grammarAccess.getDCLComponentInterfaceAccess().getInterfaceTypeInterfaceTypeParserRuleCall_4_2_0());
            					
            pushFollow(FOLLOW_13);
            lv_interfaceType_6_0=ruleInterfaceType();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getDCLComponentInterfaceRule());
            						}
            						set(
            							current,
            							"interfaceType",
            							lv_interfaceType_6_0,
            							"br.ufscar.sas.xtext.sasdsl.SasDsl.InterfaceType");
            						afterParserOrEnumRuleCall();
            					

            }


            }


            }

            otherlv_7=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getDCLComponentInterfaceAccess().getSemicolonKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDCLComponentInterface"


    // $ANTLR start "entryRuleInterfaceType"
    // InternalSasDsl.g:3980:1: entryRuleInterfaceType returns [EObject current=null] : iv_ruleInterfaceType= ruleInterfaceType EOF ;
    public final EObject entryRuleInterfaceType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceType = null;


        try {
            // InternalSasDsl.g:3980:54: (iv_ruleInterfaceType= ruleInterfaceType EOF )
            // InternalSasDsl.g:3981:2: iv_ruleInterfaceType= ruleInterfaceType EOF
            {
             newCompositeNode(grammarAccess.getInterfaceTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInterfaceType=ruleInterfaceType();

            state._fsp--;

             current =iv_ruleInterfaceType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInterfaceType"


    // $ANTLR start "ruleInterfaceType"
    // InternalSasDsl.g:3987:1: ruleInterfaceType returns [EObject current=null] : ( ( (lv_interfaceTypeName_0_1= 'provided' | lv_interfaceTypeName_0_2= 'required' ) ) ) ;
    public final EObject ruleInterfaceType() throws RecognitionException {
        EObject current = null;

        Token lv_interfaceTypeName_0_1=null;
        Token lv_interfaceTypeName_0_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3993:2: ( ( ( (lv_interfaceTypeName_0_1= 'provided' | lv_interfaceTypeName_0_2= 'required' ) ) ) )
            // InternalSasDsl.g:3994:2: ( ( (lv_interfaceTypeName_0_1= 'provided' | lv_interfaceTypeName_0_2= 'required' ) ) )
            {
            // InternalSasDsl.g:3994:2: ( ( (lv_interfaceTypeName_0_1= 'provided' | lv_interfaceTypeName_0_2= 'required' ) ) )
            // InternalSasDsl.g:3995:3: ( (lv_interfaceTypeName_0_1= 'provided' | lv_interfaceTypeName_0_2= 'required' ) )
            {
            // InternalSasDsl.g:3995:3: ( (lv_interfaceTypeName_0_1= 'provided' | lv_interfaceTypeName_0_2= 'required' ) )
            // InternalSasDsl.g:3996:4: (lv_interfaceTypeName_0_1= 'provided' | lv_interfaceTypeName_0_2= 'required' )
            {
            // InternalSasDsl.g:3996:4: (lv_interfaceTypeName_0_1= 'provided' | lv_interfaceTypeName_0_2= 'required' )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==55) ) {
                alt62=1;
            }
            else if ( (LA62_0==56) ) {
                alt62=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // InternalSasDsl.g:3997:5: lv_interfaceTypeName_0_1= 'provided'
                    {
                    lv_interfaceTypeName_0_1=(Token)match(input,55,FOLLOW_2); 

                    					newLeafNode(lv_interfaceTypeName_0_1, grammarAccess.getInterfaceTypeAccess().getInterfaceTypeNameProvidedKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getInterfaceTypeRule());
                    					}
                    					setWithLastConsumed(current, "interfaceTypeName", lv_interfaceTypeName_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:4008:5: lv_interfaceTypeName_0_2= 'required'
                    {
                    lv_interfaceTypeName_0_2=(Token)match(input,56,FOLLOW_2); 

                    					newLeafNode(lv_interfaceTypeName_0_2, grammarAccess.getInterfaceTypeAccess().getInterfaceTypeNameRequiredKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getInterfaceTypeRule());
                    					}
                    					setWithLastConsumed(current, "interfaceTypeName", lv_interfaceTypeName_0_2, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInterfaceType"


    // $ANTLR start "entryRuleDCLSubSystem"
    // InternalSasDsl.g:4024:1: entryRuleDCLSubSystem returns [EObject current=null] : iv_ruleDCLSubSystem= ruleDCLSubSystem EOF ;
    public final EObject entryRuleDCLSubSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDCLSubSystem = null;


        try {
            // InternalSasDsl.g:4024:53: (iv_ruleDCLSubSystem= ruleDCLSubSystem EOF )
            // InternalSasDsl.g:4025:2: iv_ruleDCLSubSystem= ruleDCLSubSystem EOF
            {
             newCompositeNode(grammarAccess.getDCLSubSystemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDCLSubSystem=ruleDCLSubSystem();

            state._fsp--;

             current =iv_ruleDCLSubSystem; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDCLSubSystem"


    // $ANTLR start "ruleDCLSubSystem"
    // InternalSasDsl.g:4031:1: ruleDCLSubSystem returns [EObject current=null] : (otherlv_0= 'subSystem' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ',' otherlv_3= 'inSubSystem: ' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= ';' ) ;
    public final EObject ruleDCLSubSystem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalSasDsl.g:4037:2: ( (otherlv_0= 'subSystem' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ',' otherlv_3= 'inSubSystem: ' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= ';' ) )
            // InternalSasDsl.g:4038:2: (otherlv_0= 'subSystem' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ',' otherlv_3= 'inSubSystem: ' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= ';' )
            {
            // InternalSasDsl.g:4038:2: (otherlv_0= 'subSystem' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ',' otherlv_3= 'inSubSystem: ' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= ';' )
            // InternalSasDsl.g:4039:3: otherlv_0= 'subSystem' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ',' otherlv_3= 'inSubSystem: ' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDCLSubSystemAccess().getSubSystemKeyword_0());
            		
            // InternalSasDsl.g:4043:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:4044:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:4044:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:4045:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_43); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDCLSubSystemAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDCLSubSystemRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalSasDsl.g:4061:3: (otherlv_2= ',' otherlv_3= 'inSubSystem: ' ( (otherlv_4= RULE_ID ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==46) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalSasDsl.g:4062:4: otherlv_2= ',' otherlv_3= 'inSubSystem: ' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,46,FOLLOW_45); 

                    				newLeafNode(otherlv_2, grammarAccess.getDCLSubSystemAccess().getCommaKeyword_2_0());
                    			
                    otherlv_3=(Token)match(input,49,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDCLSubSystemAccess().getInSubSystemKeyword_2_1());
                    			
                    // InternalSasDsl.g:4070:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:4071:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:4071:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:4072:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDCLSubSystemRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_4, grammarAccess.getDCLSubSystemAccess().getSubSystemDCLStructureElementCrossReference_2_2_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getDCLSubSystemAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDCLSubSystem"


    // $ANTLR start "entryRuleDCLModule"
    // InternalSasDsl.g:4092:1: entryRuleDCLModule returns [EObject current=null] : iv_ruleDCLModule= ruleDCLModule EOF ;
    public final EObject entryRuleDCLModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDCLModule = null;


        try {
            // InternalSasDsl.g:4092:50: (iv_ruleDCLModule= ruleDCLModule EOF )
            // InternalSasDsl.g:4093:2: iv_ruleDCLModule= ruleDCLModule EOF
            {
             newCompositeNode(grammarAccess.getDCLModuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDCLModule=ruleDCLModule();

            state._fsp--;

             current =iv_ruleDCLModule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDCLModule"


    // $ANTLR start "ruleDCLModule"
    // InternalSasDsl.g:4099:1: ruleDCLModule returns [EObject current=null] : (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDCLModule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:4105:2: ( (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:4106:2: (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:4106:2: (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:4107:3: otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDCLModuleAccess().getModuleKeyword_0());
            		
            // InternalSasDsl.g:4111:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:4112:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:4112:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:4113:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDCLModuleAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDCLModuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getDCLModuleAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDCLModule"


    // $ANTLR start "entryRuleDCDecl"
    // InternalSasDsl.g:4137:1: entryRuleDCDecl returns [EObject current=null] : iv_ruleDCDecl= ruleDCDecl EOF ;
    public final EObject entryRuleDCDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDCDecl = null;


        try {
            // InternalSasDsl.g:4137:47: (iv_ruleDCDecl= ruleDCDecl EOF )
            // InternalSasDsl.g:4138:2: iv_ruleDCDecl= ruleDCDecl EOF
            {
             newCompositeNode(grammarAccess.getDCDeclRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDCDecl=ruleDCDecl();

            state._fsp--;

             current =iv_ruleDCDecl; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDCDecl"


    // $ANTLR start "ruleDCDecl"
    // InternalSasDsl.g:4144:1: ruleDCDecl returns [EObject current=null] : ( ( ( (lv_only_0_0= ruleOnly ) ) ( ( ruleFQN ) ) ( (lv_can_2_0= ruleCan ) ) ( (lv_elementType_3_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_5= ';' ) | ( ( ( ruleFQN ) ) ( (lv_cannot_7_0= ruleCannot ) ) ( (lv_elementType_8_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_10= ';' ) | ( ( ( ruleFQN ) ) ( (lv_can_12_0= ruleCan ) ) ( (lv_elementType_13_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_15= ';' ) | ( ( ( ruleFQN ) ) ( (lv_can_17_0= ruleCan ) ) ( (lv_elementType_18_0= ruleElementType ) ) ( (lv_only2_19_0= ruleOnly2 ) ) ( ( ruleFQN ) ) otherlv_21= ';' ) | ( ( ( ruleFQN ) ) ( (lv_must_23_0= ruleMust ) ) ( (lv_entityType_24_0= ruleEntityType ) ) ( ( ruleFQN ) ) otherlv_26= ';' ) ) ;
    public final EObject ruleDCDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_5=null;
        Token otherlv_10=null;
        Token otherlv_15=null;
        Token otherlv_21=null;
        Token otherlv_26=null;
        EObject lv_only_0_0 = null;

        EObject lv_can_2_0 = null;

        EObject lv_elementType_3_0 = null;

        EObject lv_cannot_7_0 = null;

        EObject lv_elementType_8_0 = null;

        EObject lv_can_12_0 = null;

        EObject lv_elementType_13_0 = null;

        EObject lv_can_17_0 = null;

        EObject lv_elementType_18_0 = null;

        EObject lv_only2_19_0 = null;

        EObject lv_must_23_0 = null;

        EObject lv_entityType_24_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:4150:2: ( ( ( ( (lv_only_0_0= ruleOnly ) ) ( ( ruleFQN ) ) ( (lv_can_2_0= ruleCan ) ) ( (lv_elementType_3_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_5= ';' ) | ( ( ( ruleFQN ) ) ( (lv_cannot_7_0= ruleCannot ) ) ( (lv_elementType_8_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_10= ';' ) | ( ( ( ruleFQN ) ) ( (lv_can_12_0= ruleCan ) ) ( (lv_elementType_13_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_15= ';' ) | ( ( ( ruleFQN ) ) ( (lv_can_17_0= ruleCan ) ) ( (lv_elementType_18_0= ruleElementType ) ) ( (lv_only2_19_0= ruleOnly2 ) ) ( ( ruleFQN ) ) otherlv_21= ';' ) | ( ( ( ruleFQN ) ) ( (lv_must_23_0= ruleMust ) ) ( (lv_entityType_24_0= ruleEntityType ) ) ( ( ruleFQN ) ) otherlv_26= ';' ) ) )
            // InternalSasDsl.g:4151:2: ( ( ( (lv_only_0_0= ruleOnly ) ) ( ( ruleFQN ) ) ( (lv_can_2_0= ruleCan ) ) ( (lv_elementType_3_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_5= ';' ) | ( ( ( ruleFQN ) ) ( (lv_cannot_7_0= ruleCannot ) ) ( (lv_elementType_8_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_10= ';' ) | ( ( ( ruleFQN ) ) ( (lv_can_12_0= ruleCan ) ) ( (lv_elementType_13_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_15= ';' ) | ( ( ( ruleFQN ) ) ( (lv_can_17_0= ruleCan ) ) ( (lv_elementType_18_0= ruleElementType ) ) ( (lv_only2_19_0= ruleOnly2 ) ) ( ( ruleFQN ) ) otherlv_21= ';' ) | ( ( ( ruleFQN ) ) ( (lv_must_23_0= ruleMust ) ) ( (lv_entityType_24_0= ruleEntityType ) ) ( ( ruleFQN ) ) otherlv_26= ';' ) )
            {
            // InternalSasDsl.g:4151:2: ( ( ( (lv_only_0_0= ruleOnly ) ) ( ( ruleFQN ) ) ( (lv_can_2_0= ruleCan ) ) ( (lv_elementType_3_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_5= ';' ) | ( ( ( ruleFQN ) ) ( (lv_cannot_7_0= ruleCannot ) ) ( (lv_elementType_8_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_10= ';' ) | ( ( ( ruleFQN ) ) ( (lv_can_12_0= ruleCan ) ) ( (lv_elementType_13_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_15= ';' ) | ( ( ( ruleFQN ) ) ( (lv_can_17_0= ruleCan ) ) ( (lv_elementType_18_0= ruleElementType ) ) ( (lv_only2_19_0= ruleOnly2 ) ) ( ( ruleFQN ) ) otherlv_21= ';' ) | ( ( ( ruleFQN ) ) ( (lv_must_23_0= ruleMust ) ) ( (lv_entityType_24_0= ruleEntityType ) ) ( ( ruleFQN ) ) otherlv_26= ';' ) )
            int alt64=5;
            alt64 = dfa64.predict(input);
            switch (alt64) {
                case 1 :
                    // InternalSasDsl.g:4152:3: ( ( (lv_only_0_0= ruleOnly ) ) ( ( ruleFQN ) ) ( (lv_can_2_0= ruleCan ) ) ( (lv_elementType_3_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:4152:3: ( ( (lv_only_0_0= ruleOnly ) ) ( ( ruleFQN ) ) ( (lv_can_2_0= ruleCan ) ) ( (lv_elementType_3_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:4153:4: ( (lv_only_0_0= ruleOnly ) ) ( ( ruleFQN ) ) ( (lv_can_2_0= ruleCan ) ) ( (lv_elementType_3_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_5= ';'
                    {
                    // InternalSasDsl.g:4153:4: ( (lv_only_0_0= ruleOnly ) )
                    // InternalSasDsl.g:4154:5: (lv_only_0_0= ruleOnly )
                    {
                    // InternalSasDsl.g:4154:5: (lv_only_0_0= ruleOnly )
                    // InternalSasDsl.g:4155:6: lv_only_0_0= ruleOnly
                    {

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getOnlyOnlyParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_only_0_0=ruleOnly();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDCDeclRule());
                    						}
                    						set(
                    							current,
                    							"only",
                    							lv_only_0_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.Only");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSasDsl.g:4172:4: ( ( ruleFQN ) )
                    // InternalSasDsl.g:4173:5: ( ruleFQN )
                    {
                    // InternalSasDsl.g:4173:5: ( ruleFQN )
                    // InternalSasDsl.g:4174:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDCDeclRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getTDCLStructureElementCrossReference_0_1_0());
                    					
                    pushFollow(FOLLOW_50);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSasDsl.g:4188:4: ( (lv_can_2_0= ruleCan ) )
                    // InternalSasDsl.g:4189:5: (lv_can_2_0= ruleCan )
                    {
                    // InternalSasDsl.g:4189:5: (lv_can_2_0= ruleCan )
                    // InternalSasDsl.g:4190:6: lv_can_2_0= ruleCan
                    {

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getCanCanParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_51);
                    lv_can_2_0=ruleCan();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDCDeclRule());
                    						}
                    						set(
                    							current,
                    							"can",
                    							lv_can_2_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.Can");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSasDsl.g:4207:4: ( (lv_elementType_3_0= ruleElementType ) )
                    // InternalSasDsl.g:4208:5: (lv_elementType_3_0= ruleElementType )
                    {
                    // InternalSasDsl.g:4208:5: (lv_elementType_3_0= ruleElementType )
                    // InternalSasDsl.g:4209:6: lv_elementType_3_0= ruleElementType
                    {

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getElementTypeElementTypeParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_elementType_3_0=ruleElementType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDCDeclRule());
                    						}
                    						set(
                    							current,
                    							"elementType",
                    							lv_elementType_3_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.ElementType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSasDsl.g:4226:4: ( ( ruleFQN ) )
                    // InternalSasDsl.g:4227:5: ( ruleFQN )
                    {
                    // InternalSasDsl.g:4227:5: ( ruleFQN )
                    // InternalSasDsl.g:4228:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDCDeclRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getTypeDCLStructureElementCrossReference_0_4_0());
                    					
                    pushFollow(FOLLOW_13);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDCDeclAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:4248:3: ( ( ( ruleFQN ) ) ( (lv_cannot_7_0= ruleCannot ) ) ( (lv_elementType_8_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_10= ';' )
                    {
                    // InternalSasDsl.g:4248:3: ( ( ( ruleFQN ) ) ( (lv_cannot_7_0= ruleCannot ) ) ( (lv_elementType_8_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_10= ';' )
                    // InternalSasDsl.g:4249:4: ( ( ruleFQN ) ) ( (lv_cannot_7_0= ruleCannot ) ) ( (lv_elementType_8_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_10= ';'
                    {
                    // InternalSasDsl.g:4249:4: ( ( ruleFQN ) )
                    // InternalSasDsl.g:4250:5: ( ruleFQN )
                    {
                    // InternalSasDsl.g:4250:5: ( ruleFQN )
                    // InternalSasDsl.g:4251:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDCDeclRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getTDCLStructureElementCrossReference_1_0_0());
                    					
                    pushFollow(FOLLOW_52);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSasDsl.g:4265:4: ( (lv_cannot_7_0= ruleCannot ) )
                    // InternalSasDsl.g:4266:5: (lv_cannot_7_0= ruleCannot )
                    {
                    // InternalSasDsl.g:4266:5: (lv_cannot_7_0= ruleCannot )
                    // InternalSasDsl.g:4267:6: lv_cannot_7_0= ruleCannot
                    {

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getCannotCannotParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_51);
                    lv_cannot_7_0=ruleCannot();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDCDeclRule());
                    						}
                    						set(
                    							current,
                    							"cannot",
                    							lv_cannot_7_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.Cannot");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSasDsl.g:4284:4: ( (lv_elementType_8_0= ruleElementType ) )
                    // InternalSasDsl.g:4285:5: (lv_elementType_8_0= ruleElementType )
                    {
                    // InternalSasDsl.g:4285:5: (lv_elementType_8_0= ruleElementType )
                    // InternalSasDsl.g:4286:6: lv_elementType_8_0= ruleElementType
                    {

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getElementTypeElementTypeParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_elementType_8_0=ruleElementType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDCDeclRule());
                    						}
                    						set(
                    							current,
                    							"elementType",
                    							lv_elementType_8_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.ElementType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSasDsl.g:4303:4: ( ( ruleFQN ) )
                    // InternalSasDsl.g:4304:5: ( ruleFQN )
                    {
                    // InternalSasDsl.g:4304:5: ( ruleFQN )
                    // InternalSasDsl.g:4305:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDCDeclRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getTypeDCLStructureElementCrossReference_1_3_0());
                    					
                    pushFollow(FOLLOW_13);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_10=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_10, grammarAccess.getDCDeclAccess().getSemicolonKeyword_1_4());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:4325:3: ( ( ( ruleFQN ) ) ( (lv_can_12_0= ruleCan ) ) ( (lv_elementType_13_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_15= ';' )
                    {
                    // InternalSasDsl.g:4325:3: ( ( ( ruleFQN ) ) ( (lv_can_12_0= ruleCan ) ) ( (lv_elementType_13_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_15= ';' )
                    // InternalSasDsl.g:4326:4: ( ( ruleFQN ) ) ( (lv_can_12_0= ruleCan ) ) ( (lv_elementType_13_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_15= ';'
                    {
                    // InternalSasDsl.g:4326:4: ( ( ruleFQN ) )
                    // InternalSasDsl.g:4327:5: ( ruleFQN )
                    {
                    // InternalSasDsl.g:4327:5: ( ruleFQN )
                    // InternalSasDsl.g:4328:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDCDeclRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getTDCLStructureElementCrossReference_2_0_0());
                    					
                    pushFollow(FOLLOW_50);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSasDsl.g:4342:4: ( (lv_can_12_0= ruleCan ) )
                    // InternalSasDsl.g:4343:5: (lv_can_12_0= ruleCan )
                    {
                    // InternalSasDsl.g:4343:5: (lv_can_12_0= ruleCan )
                    // InternalSasDsl.g:4344:6: lv_can_12_0= ruleCan
                    {

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getCanCanParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_51);
                    lv_can_12_0=ruleCan();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDCDeclRule());
                    						}
                    						set(
                    							current,
                    							"can",
                    							lv_can_12_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.Can");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSasDsl.g:4361:4: ( (lv_elementType_13_0= ruleElementType ) )
                    // InternalSasDsl.g:4362:5: (lv_elementType_13_0= ruleElementType )
                    {
                    // InternalSasDsl.g:4362:5: (lv_elementType_13_0= ruleElementType )
                    // InternalSasDsl.g:4363:6: lv_elementType_13_0= ruleElementType
                    {

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getElementTypeElementTypeParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_elementType_13_0=ruleElementType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDCDeclRule());
                    						}
                    						set(
                    							current,
                    							"elementType",
                    							lv_elementType_13_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.ElementType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSasDsl.g:4380:4: ( ( ruleFQN ) )
                    // InternalSasDsl.g:4381:5: ( ruleFQN )
                    {
                    // InternalSasDsl.g:4381:5: ( ruleFQN )
                    // InternalSasDsl.g:4382:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDCDeclRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getTypeDCLStructureElementCrossReference_2_3_0());
                    					
                    pushFollow(FOLLOW_13);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_15=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getDCDeclAccess().getSemicolonKeyword_2_4());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:4402:3: ( ( ( ruleFQN ) ) ( (lv_can_17_0= ruleCan ) ) ( (lv_elementType_18_0= ruleElementType ) ) ( (lv_only2_19_0= ruleOnly2 ) ) ( ( ruleFQN ) ) otherlv_21= ';' )
                    {
                    // InternalSasDsl.g:4402:3: ( ( ( ruleFQN ) ) ( (lv_can_17_0= ruleCan ) ) ( (lv_elementType_18_0= ruleElementType ) ) ( (lv_only2_19_0= ruleOnly2 ) ) ( ( ruleFQN ) ) otherlv_21= ';' )
                    // InternalSasDsl.g:4403:4: ( ( ruleFQN ) ) ( (lv_can_17_0= ruleCan ) ) ( (lv_elementType_18_0= ruleElementType ) ) ( (lv_only2_19_0= ruleOnly2 ) ) ( ( ruleFQN ) ) otherlv_21= ';'
                    {
                    // InternalSasDsl.g:4403:4: ( ( ruleFQN ) )
                    // InternalSasDsl.g:4404:5: ( ruleFQN )
                    {
                    // InternalSasDsl.g:4404:5: ( ruleFQN )
                    // InternalSasDsl.g:4405:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDCDeclRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getTDCLStructureElementCrossReference_3_0_0());
                    					
                    pushFollow(FOLLOW_50);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSasDsl.g:4419:4: ( (lv_can_17_0= ruleCan ) )
                    // InternalSasDsl.g:4420:5: (lv_can_17_0= ruleCan )
                    {
                    // InternalSasDsl.g:4420:5: (lv_can_17_0= ruleCan )
                    // InternalSasDsl.g:4421:6: lv_can_17_0= ruleCan
                    {

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getCanCanParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_51);
                    lv_can_17_0=ruleCan();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDCDeclRule());
                    						}
                    						set(
                    							current,
                    							"can",
                    							lv_can_17_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.Can");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSasDsl.g:4438:4: ( (lv_elementType_18_0= ruleElementType ) )
                    // InternalSasDsl.g:4439:5: (lv_elementType_18_0= ruleElementType )
                    {
                    // InternalSasDsl.g:4439:5: (lv_elementType_18_0= ruleElementType )
                    // InternalSasDsl.g:4440:6: lv_elementType_18_0= ruleElementType
                    {

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getElementTypeElementTypeParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_53);
                    lv_elementType_18_0=ruleElementType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDCDeclRule());
                    						}
                    						set(
                    							current,
                    							"elementType",
                    							lv_elementType_18_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.ElementType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSasDsl.g:4457:4: ( (lv_only2_19_0= ruleOnly2 ) )
                    // InternalSasDsl.g:4458:5: (lv_only2_19_0= ruleOnly2 )
                    {
                    // InternalSasDsl.g:4458:5: (lv_only2_19_0= ruleOnly2 )
                    // InternalSasDsl.g:4459:6: lv_only2_19_0= ruleOnly2
                    {

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getOnly2Only2ParserRuleCall_3_3_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_only2_19_0=ruleOnly2();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDCDeclRule());
                    						}
                    						set(
                    							current,
                    							"only2",
                    							lv_only2_19_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.Only2");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSasDsl.g:4476:4: ( ( ruleFQN ) )
                    // InternalSasDsl.g:4477:5: ( ruleFQN )
                    {
                    // InternalSasDsl.g:4477:5: ( ruleFQN )
                    // InternalSasDsl.g:4478:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDCDeclRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getTypeDCLStructureElementCrossReference_3_4_0());
                    					
                    pushFollow(FOLLOW_13);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_21=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_21, grammarAccess.getDCDeclAccess().getSemicolonKeyword_3_5());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalSasDsl.g:4498:3: ( ( ( ruleFQN ) ) ( (lv_must_23_0= ruleMust ) ) ( (lv_entityType_24_0= ruleEntityType ) ) ( ( ruleFQN ) ) otherlv_26= ';' )
                    {
                    // InternalSasDsl.g:4498:3: ( ( ( ruleFQN ) ) ( (lv_must_23_0= ruleMust ) ) ( (lv_entityType_24_0= ruleEntityType ) ) ( ( ruleFQN ) ) otherlv_26= ';' )
                    // InternalSasDsl.g:4499:4: ( ( ruleFQN ) ) ( (lv_must_23_0= ruleMust ) ) ( (lv_entityType_24_0= ruleEntityType ) ) ( ( ruleFQN ) ) otherlv_26= ';'
                    {
                    // InternalSasDsl.g:4499:4: ( ( ruleFQN ) )
                    // InternalSasDsl.g:4500:5: ( ruleFQN )
                    {
                    // InternalSasDsl.g:4500:5: ( ruleFQN )
                    // InternalSasDsl.g:4501:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDCDeclRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getTDCLStructureElementCrossReference_4_0_0());
                    					
                    pushFollow(FOLLOW_54);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSasDsl.g:4515:4: ( (lv_must_23_0= ruleMust ) )
                    // InternalSasDsl.g:4516:5: (lv_must_23_0= ruleMust )
                    {
                    // InternalSasDsl.g:4516:5: (lv_must_23_0= ruleMust )
                    // InternalSasDsl.g:4517:6: lv_must_23_0= ruleMust
                    {

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getMustMustParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_51);
                    lv_must_23_0=ruleMust();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDCDeclRule());
                    						}
                    						set(
                    							current,
                    							"must",
                    							lv_must_23_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.Must");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSasDsl.g:4534:4: ( (lv_entityType_24_0= ruleEntityType ) )
                    // InternalSasDsl.g:4535:5: (lv_entityType_24_0= ruleEntityType )
                    {
                    // InternalSasDsl.g:4535:5: (lv_entityType_24_0= ruleEntityType )
                    // InternalSasDsl.g:4536:6: lv_entityType_24_0= ruleEntityType
                    {

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getEntityTypeEntityTypeParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_entityType_24_0=ruleEntityType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDCDeclRule());
                    						}
                    						set(
                    							current,
                    							"entityType",
                    							lv_entityType_24_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.EntityType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSasDsl.g:4553:4: ( ( ruleFQN ) )
                    // InternalSasDsl.g:4554:5: ( ruleFQN )
                    {
                    // InternalSasDsl.g:4554:5: ( ruleFQN )
                    // InternalSasDsl.g:4555:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDCDeclRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDCDeclAccess().getTypeDCLStructureElementCrossReference_4_3_0());
                    					
                    pushFollow(FOLLOW_13);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_26=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_26, grammarAccess.getDCDeclAccess().getSemicolonKeyword_4_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDCDecl"


    // $ANTLR start "entryRuleFQN"
    // InternalSasDsl.g:4578:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalSasDsl.g:4578:43: (iv_ruleFQN= ruleFQN EOF )
            // InternalSasDsl.g:4579:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // InternalSasDsl.g:4585:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:4591:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalSasDsl.g:4592:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalSasDsl.g:4592:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalSasDsl.g:4593:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_55); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
            		
            // InternalSasDsl.g:4600:3: (kw= '.' this_ID_2= RULE_ID )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==59) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalSasDsl.g:4601:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,59,FOLLOW_3); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_55); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleOnly"
    // InternalSasDsl.g:4618:1: entryRuleOnly returns [EObject current=null] : iv_ruleOnly= ruleOnly EOF ;
    public final EObject entryRuleOnly() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOnly = null;


        try {
            // InternalSasDsl.g:4618:45: (iv_ruleOnly= ruleOnly EOF )
            // InternalSasDsl.g:4619:2: iv_ruleOnly= ruleOnly EOF
            {
             newCompositeNode(grammarAccess.getOnlyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOnly=ruleOnly();

            state._fsp--;

             current =iv_ruleOnly; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOnly"


    // $ANTLR start "ruleOnly"
    // InternalSasDsl.g:4625:1: ruleOnly returns [EObject current=null] : ( (lv_only_0_0= 'only' ) ) ;
    public final EObject ruleOnly() throws RecognitionException {
        EObject current = null;

        Token lv_only_0_0=null;


        	enterRule();

        try {
            // InternalSasDsl.g:4631:2: ( ( (lv_only_0_0= 'only' ) ) )
            // InternalSasDsl.g:4632:2: ( (lv_only_0_0= 'only' ) )
            {
            // InternalSasDsl.g:4632:2: ( (lv_only_0_0= 'only' ) )
            // InternalSasDsl.g:4633:3: (lv_only_0_0= 'only' )
            {
            // InternalSasDsl.g:4633:3: (lv_only_0_0= 'only' )
            // InternalSasDsl.g:4634:4: lv_only_0_0= 'only'
            {
            lv_only_0_0=(Token)match(input,60,FOLLOW_2); 

            				newLeafNode(lv_only_0_0, grammarAccess.getOnlyAccess().getOnlyOnlyKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getOnlyRule());
            				}
            				setWithLastConsumed(current, "only", lv_only_0_0, "only");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOnly"


    // $ANTLR start "entryRuleCan"
    // InternalSasDsl.g:4649:1: entryRuleCan returns [EObject current=null] : iv_ruleCan= ruleCan EOF ;
    public final EObject entryRuleCan() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCan = null;


        try {
            // InternalSasDsl.g:4649:44: (iv_ruleCan= ruleCan EOF )
            // InternalSasDsl.g:4650:2: iv_ruleCan= ruleCan EOF
            {
             newCompositeNode(grammarAccess.getCanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCan=ruleCan();

            state._fsp--;

             current =iv_ruleCan; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCan"


    // $ANTLR start "ruleCan"
    // InternalSasDsl.g:4656:1: ruleCan returns [EObject current=null] : ( (lv_can_0_0= 'can-' ) ) ;
    public final EObject ruleCan() throws RecognitionException {
        EObject current = null;

        Token lv_can_0_0=null;


        	enterRule();

        try {
            // InternalSasDsl.g:4662:2: ( ( (lv_can_0_0= 'can-' ) ) )
            // InternalSasDsl.g:4663:2: ( (lv_can_0_0= 'can-' ) )
            {
            // InternalSasDsl.g:4663:2: ( (lv_can_0_0= 'can-' ) )
            // InternalSasDsl.g:4664:3: (lv_can_0_0= 'can-' )
            {
            // InternalSasDsl.g:4664:3: (lv_can_0_0= 'can-' )
            // InternalSasDsl.g:4665:4: lv_can_0_0= 'can-'
            {
            lv_can_0_0=(Token)match(input,61,FOLLOW_2); 

            				newLeafNode(lv_can_0_0, grammarAccess.getCanAccess().getCanCanKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getCanRule());
            				}
            				setWithLastConsumed(current, "can", lv_can_0_0, "can-");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCan"


    // $ANTLR start "entryRuleCannot"
    // InternalSasDsl.g:4680:1: entryRuleCannot returns [EObject current=null] : iv_ruleCannot= ruleCannot EOF ;
    public final EObject entryRuleCannot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCannot = null;


        try {
            // InternalSasDsl.g:4680:47: (iv_ruleCannot= ruleCannot EOF )
            // InternalSasDsl.g:4681:2: iv_ruleCannot= ruleCannot EOF
            {
             newCompositeNode(grammarAccess.getCannotRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCannot=ruleCannot();

            state._fsp--;

             current =iv_ruleCannot; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCannot"


    // $ANTLR start "ruleCannot"
    // InternalSasDsl.g:4687:1: ruleCannot returns [EObject current=null] : ( (lv_cannot_0_0= 'cannot-' ) ) ;
    public final EObject ruleCannot() throws RecognitionException {
        EObject current = null;

        Token lv_cannot_0_0=null;


        	enterRule();

        try {
            // InternalSasDsl.g:4693:2: ( ( (lv_cannot_0_0= 'cannot-' ) ) )
            // InternalSasDsl.g:4694:2: ( (lv_cannot_0_0= 'cannot-' ) )
            {
            // InternalSasDsl.g:4694:2: ( (lv_cannot_0_0= 'cannot-' ) )
            // InternalSasDsl.g:4695:3: (lv_cannot_0_0= 'cannot-' )
            {
            // InternalSasDsl.g:4695:3: (lv_cannot_0_0= 'cannot-' )
            // InternalSasDsl.g:4696:4: lv_cannot_0_0= 'cannot-'
            {
            lv_cannot_0_0=(Token)match(input,62,FOLLOW_2); 

            				newLeafNode(lv_cannot_0_0, grammarAccess.getCannotAccess().getCannotCannotKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getCannotRule());
            				}
            				setWithLastConsumed(current, "cannot", lv_cannot_0_0, "cannot-");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCannot"


    // $ANTLR start "entryRuleOnly2"
    // InternalSasDsl.g:4711:1: entryRuleOnly2 returns [EObject current=null] : iv_ruleOnly2= ruleOnly2 EOF ;
    public final EObject entryRuleOnly2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOnly2 = null;


        try {
            // InternalSasDsl.g:4711:46: (iv_ruleOnly2= ruleOnly2 EOF )
            // InternalSasDsl.g:4712:2: iv_ruleOnly2= ruleOnly2 EOF
            {
             newCompositeNode(grammarAccess.getOnly2Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOnly2=ruleOnly2();

            state._fsp--;

             current =iv_ruleOnly2; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOnly2"


    // $ANTLR start "ruleOnly2"
    // InternalSasDsl.g:4718:1: ruleOnly2 returns [EObject current=null] : ( (lv_only2_0_0= '-only' ) ) ;
    public final EObject ruleOnly2() throws RecognitionException {
        EObject current = null;

        Token lv_only2_0_0=null;


        	enterRule();

        try {
            // InternalSasDsl.g:4724:2: ( ( (lv_only2_0_0= '-only' ) ) )
            // InternalSasDsl.g:4725:2: ( (lv_only2_0_0= '-only' ) )
            {
            // InternalSasDsl.g:4725:2: ( (lv_only2_0_0= '-only' ) )
            // InternalSasDsl.g:4726:3: (lv_only2_0_0= '-only' )
            {
            // InternalSasDsl.g:4726:3: (lv_only2_0_0= '-only' )
            // InternalSasDsl.g:4727:4: lv_only2_0_0= '-only'
            {
            lv_only2_0_0=(Token)match(input,63,FOLLOW_2); 

            				newLeafNode(lv_only2_0_0, grammarAccess.getOnly2Access().getOnly2OnlyKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getOnly2Rule());
            				}
            				setWithLastConsumed(current, "only2", lv_only2_0_0, "-only");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOnly2"


    // $ANTLR start "entryRuleMust"
    // InternalSasDsl.g:4742:1: entryRuleMust returns [EObject current=null] : iv_ruleMust= ruleMust EOF ;
    public final EObject entryRuleMust() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMust = null;


        try {
            // InternalSasDsl.g:4742:45: (iv_ruleMust= ruleMust EOF )
            // InternalSasDsl.g:4743:2: iv_ruleMust= ruleMust EOF
            {
             newCompositeNode(grammarAccess.getMustRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMust=ruleMust();

            state._fsp--;

             current =iv_ruleMust; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMust"


    // $ANTLR start "ruleMust"
    // InternalSasDsl.g:4749:1: ruleMust returns [EObject current=null] : ( (lv_must_0_0= 'must-' ) ) ;
    public final EObject ruleMust() throws RecognitionException {
        EObject current = null;

        Token lv_must_0_0=null;


        	enterRule();

        try {
            // InternalSasDsl.g:4755:2: ( ( (lv_must_0_0= 'must-' ) ) )
            // InternalSasDsl.g:4756:2: ( (lv_must_0_0= 'must-' ) )
            {
            // InternalSasDsl.g:4756:2: ( (lv_must_0_0= 'must-' ) )
            // InternalSasDsl.g:4757:3: (lv_must_0_0= 'must-' )
            {
            // InternalSasDsl.g:4757:3: (lv_must_0_0= 'must-' )
            // InternalSasDsl.g:4758:4: lv_must_0_0= 'must-'
            {
            lv_must_0_0=(Token)match(input,64,FOLLOW_2); 

            				newLeafNode(lv_must_0_0, grammarAccess.getMustAccess().getMustMustKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getMustRule());
            				}
            				setWithLastConsumed(current, "must", lv_must_0_0, "must-");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMust"


    // $ANTLR start "entryRuleElementType"
    // InternalSasDsl.g:4773:1: entryRuleElementType returns [EObject current=null] : iv_ruleElementType= ruleElementType EOF ;
    public final EObject entryRuleElementType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementType = null;


        try {
            // InternalSasDsl.g:4773:52: (iv_ruleElementType= ruleElementType EOF )
            // InternalSasDsl.g:4774:2: iv_ruleElementType= ruleElementType EOF
            {
             newCompositeNode(grammarAccess.getElementTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElementType=ruleElementType();

            state._fsp--;

             current =iv_ruleElementType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElementType"


    // $ANTLR start "ruleElementType"
    // InternalSasDsl.g:4780:1: ruleElementType returns [EObject current=null] : (this_BasicType_0= ruleBasicType | this_EntityType_1= ruleEntityType ) ;
    public final EObject ruleElementType() throws RecognitionException {
        EObject current = null;

        EObject this_BasicType_0 = null;

        EObject this_EntityType_1 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:4786:2: ( (this_BasicType_0= ruleBasicType | this_EntityType_1= ruleEntityType ) )
            // InternalSasDsl.g:4787:2: (this_BasicType_0= ruleBasicType | this_EntityType_1= ruleEntityType )
            {
            // InternalSasDsl.g:4787:2: (this_BasicType_0= ruleBasicType | this_EntityType_1= ruleEntityType )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( ((LA66_0>=65 && LA66_0<=69)) ) {
                alt66=1;
            }
            else if ( ((LA66_0>=70 && LA66_0<=74)) ) {
                alt66=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // InternalSasDsl.g:4788:3: this_BasicType_0= ruleBasicType
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getBasicTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_BasicType_0=ruleBasicType();

                    state._fsp--;


                    			current = this_BasicType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:4797:3: this_EntityType_1= ruleEntityType
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getEntityTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityType_1=ruleEntityType();

                    state._fsp--;


                    			current = this_EntityType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElementType"


    // $ANTLR start "entryRuleBasicType"
    // InternalSasDsl.g:4809:1: entryRuleBasicType returns [EObject current=null] : iv_ruleBasicType= ruleBasicType EOF ;
    public final EObject entryRuleBasicType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicType = null;


        try {
            // InternalSasDsl.g:4809:50: (iv_ruleBasicType= ruleBasicType EOF )
            // InternalSasDsl.g:4810:2: iv_ruleBasicType= ruleBasicType EOF
            {
             newCompositeNode(grammarAccess.getBasicTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBasicType=ruleBasicType();

            state._fsp--;

             current =iv_ruleBasicType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBasicType"


    // $ANTLR start "ruleBasicType"
    // InternalSasDsl.g:4816:1: ruleBasicType returns [EObject current=null] : ( ( (lv_typeName_0_1= 'access' | lv_typeName_0_2= 'declare' | lv_typeName_0_3= 'handle' | lv_typeName_0_4= 'create' | lv_typeName_0_5= 'depend' ) ) ) ;
    public final EObject ruleBasicType() throws RecognitionException {
        EObject current = null;

        Token lv_typeName_0_1=null;
        Token lv_typeName_0_2=null;
        Token lv_typeName_0_3=null;
        Token lv_typeName_0_4=null;
        Token lv_typeName_0_5=null;


        	enterRule();

        try {
            // InternalSasDsl.g:4822:2: ( ( ( (lv_typeName_0_1= 'access' | lv_typeName_0_2= 'declare' | lv_typeName_0_3= 'handle' | lv_typeName_0_4= 'create' | lv_typeName_0_5= 'depend' ) ) ) )
            // InternalSasDsl.g:4823:2: ( ( (lv_typeName_0_1= 'access' | lv_typeName_0_2= 'declare' | lv_typeName_0_3= 'handle' | lv_typeName_0_4= 'create' | lv_typeName_0_5= 'depend' ) ) )
            {
            // InternalSasDsl.g:4823:2: ( ( (lv_typeName_0_1= 'access' | lv_typeName_0_2= 'declare' | lv_typeName_0_3= 'handle' | lv_typeName_0_4= 'create' | lv_typeName_0_5= 'depend' ) ) )
            // InternalSasDsl.g:4824:3: ( (lv_typeName_0_1= 'access' | lv_typeName_0_2= 'declare' | lv_typeName_0_3= 'handle' | lv_typeName_0_4= 'create' | lv_typeName_0_5= 'depend' ) )
            {
            // InternalSasDsl.g:4824:3: ( (lv_typeName_0_1= 'access' | lv_typeName_0_2= 'declare' | lv_typeName_0_3= 'handle' | lv_typeName_0_4= 'create' | lv_typeName_0_5= 'depend' ) )
            // InternalSasDsl.g:4825:4: (lv_typeName_0_1= 'access' | lv_typeName_0_2= 'declare' | lv_typeName_0_3= 'handle' | lv_typeName_0_4= 'create' | lv_typeName_0_5= 'depend' )
            {
            // InternalSasDsl.g:4825:4: (lv_typeName_0_1= 'access' | lv_typeName_0_2= 'declare' | lv_typeName_0_3= 'handle' | lv_typeName_0_4= 'create' | lv_typeName_0_5= 'depend' )
            int alt67=5;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt67=1;
                }
                break;
            case 66:
                {
                alt67=2;
                }
                break;
            case 67:
                {
                alt67=3;
                }
                break;
            case 68:
                {
                alt67=4;
                }
                break;
            case 69:
                {
                alt67=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }

            switch (alt67) {
                case 1 :
                    // InternalSasDsl.g:4826:5: lv_typeName_0_1= 'access'
                    {
                    lv_typeName_0_1=(Token)match(input,65,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_1, grammarAccess.getBasicTypeAccess().getTypeNameAccessKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBasicTypeRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:4837:5: lv_typeName_0_2= 'declare'
                    {
                    lv_typeName_0_2=(Token)match(input,66,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_2, grammarAccess.getBasicTypeAccess().getTypeNameDeclareKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBasicTypeRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:4848:5: lv_typeName_0_3= 'handle'
                    {
                    lv_typeName_0_3=(Token)match(input,67,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_3, grammarAccess.getBasicTypeAccess().getTypeNameHandleKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBasicTypeRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:4859:5: lv_typeName_0_4= 'create'
                    {
                    lv_typeName_0_4=(Token)match(input,68,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_4, grammarAccess.getBasicTypeAccess().getTypeNameCreateKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBasicTypeRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_4, null);
                    				

                    }
                    break;
                case 5 :
                    // InternalSasDsl.g:4870:5: lv_typeName_0_5= 'depend'
                    {
                    lv_typeName_0_5=(Token)match(input,69,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_5, grammarAccess.getBasicTypeAccess().getTypeNameDependKeyword_0_4());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBasicTypeRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_5, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBasicType"


    // $ANTLR start "entryRuleEntityType"
    // InternalSasDsl.g:4886:1: entryRuleEntityType returns [EObject current=null] : iv_ruleEntityType= ruleEntityType EOF ;
    public final EObject entryRuleEntityType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityType = null;


        try {
            // InternalSasDsl.g:4886:51: (iv_ruleEntityType= ruleEntityType EOF )
            // InternalSasDsl.g:4887:2: iv_ruleEntityType= ruleEntityType EOF
            {
             newCompositeNode(grammarAccess.getEntityTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityType=ruleEntityType();

            state._fsp--;

             current =iv_ruleEntityType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityType"


    // $ANTLR start "ruleEntityType"
    // InternalSasDsl.g:4893:1: ruleEntityType returns [EObject current=null] : ( ( (lv_entity_0_1= 'extend' | lv_entity_0_2= 'implement' | lv_entity_0_3= 'derive' | lv_entity_0_4= 'throw' | lv_entity_0_5= 'useannotation' ) ) ) ;
    public final EObject ruleEntityType() throws RecognitionException {
        EObject current = null;

        Token lv_entity_0_1=null;
        Token lv_entity_0_2=null;
        Token lv_entity_0_3=null;
        Token lv_entity_0_4=null;
        Token lv_entity_0_5=null;


        	enterRule();

        try {
            // InternalSasDsl.g:4899:2: ( ( ( (lv_entity_0_1= 'extend' | lv_entity_0_2= 'implement' | lv_entity_0_3= 'derive' | lv_entity_0_4= 'throw' | lv_entity_0_5= 'useannotation' ) ) ) )
            // InternalSasDsl.g:4900:2: ( ( (lv_entity_0_1= 'extend' | lv_entity_0_2= 'implement' | lv_entity_0_3= 'derive' | lv_entity_0_4= 'throw' | lv_entity_0_5= 'useannotation' ) ) )
            {
            // InternalSasDsl.g:4900:2: ( ( (lv_entity_0_1= 'extend' | lv_entity_0_2= 'implement' | lv_entity_0_3= 'derive' | lv_entity_0_4= 'throw' | lv_entity_0_5= 'useannotation' ) ) )
            // InternalSasDsl.g:4901:3: ( (lv_entity_0_1= 'extend' | lv_entity_0_2= 'implement' | lv_entity_0_3= 'derive' | lv_entity_0_4= 'throw' | lv_entity_0_5= 'useannotation' ) )
            {
            // InternalSasDsl.g:4901:3: ( (lv_entity_0_1= 'extend' | lv_entity_0_2= 'implement' | lv_entity_0_3= 'derive' | lv_entity_0_4= 'throw' | lv_entity_0_5= 'useannotation' ) )
            // InternalSasDsl.g:4902:4: (lv_entity_0_1= 'extend' | lv_entity_0_2= 'implement' | lv_entity_0_3= 'derive' | lv_entity_0_4= 'throw' | lv_entity_0_5= 'useannotation' )
            {
            // InternalSasDsl.g:4902:4: (lv_entity_0_1= 'extend' | lv_entity_0_2= 'implement' | lv_entity_0_3= 'derive' | lv_entity_0_4= 'throw' | lv_entity_0_5= 'useannotation' )
            int alt68=5;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt68=1;
                }
                break;
            case 71:
                {
                alt68=2;
                }
                break;
            case 72:
                {
                alt68=3;
                }
                break;
            case 73:
                {
                alt68=4;
                }
                break;
            case 74:
                {
                alt68=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // InternalSasDsl.g:4903:5: lv_entity_0_1= 'extend'
                    {
                    lv_entity_0_1=(Token)match(input,70,FOLLOW_2); 

                    					newLeafNode(lv_entity_0_1, grammarAccess.getEntityTypeAccess().getEntityExtendKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityTypeRule());
                    					}
                    					setWithLastConsumed(current, "entity", lv_entity_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:4914:5: lv_entity_0_2= 'implement'
                    {
                    lv_entity_0_2=(Token)match(input,71,FOLLOW_2); 

                    					newLeafNode(lv_entity_0_2, grammarAccess.getEntityTypeAccess().getEntityImplementKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityTypeRule());
                    					}
                    					setWithLastConsumed(current, "entity", lv_entity_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:4925:5: lv_entity_0_3= 'derive'
                    {
                    lv_entity_0_3=(Token)match(input,72,FOLLOW_2); 

                    					newLeafNode(lv_entity_0_3, grammarAccess.getEntityTypeAccess().getEntityDeriveKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityTypeRule());
                    					}
                    					setWithLastConsumed(current, "entity", lv_entity_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:4936:5: lv_entity_0_4= 'throw'
                    {
                    lv_entity_0_4=(Token)match(input,73,FOLLOW_2); 

                    					newLeafNode(lv_entity_0_4, grammarAccess.getEntityTypeAccess().getEntityThrowKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityTypeRule());
                    					}
                    					setWithLastConsumed(current, "entity", lv_entity_0_4, null);
                    				

                    }
                    break;
                case 5 :
                    // InternalSasDsl.g:4947:5: lv_entity_0_5= 'useannotation'
                    {
                    lv_entity_0_5=(Token)match(input,74,FOLLOW_2); 

                    					newLeafNode(lv_entity_0_5, grammarAccess.getEntityTypeAccess().getEntityUseannotationKeyword_0_4());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityTypeRule());
                    					}
                    					setWithLastConsumed(current, "entity", lv_entity_0_5, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityType"

    // Delegated rules


    protected DFA14 dfa14 = new DFA14(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA64 dfa64 = new DFA64(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\24\1\4\1\20\2\24\6\uffff";
    static final String dfa_3s = "\1\24\1\4\1\21\2\31\6\uffff";
    static final String dfa_4s = "\5\uffff\1\6\1\5\1\4\1\3\1\2\1\1";
    static final String dfa_5s = "\13\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\2",
            "\1\3\1\4",
            "\1\12\1\11\1\10\1\7\1\6\1\5",
            "\1\12\1\11\1\10\1\7\1\6\1\5",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "473:2: ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'monitor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'monitor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'sensor' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) )";
        }
    }
    static final String dfa_7s = "\14\uffff";
    static final String dfa_8s = "\1\25\1\4\1\20\2\24\7\uffff";
    static final String dfa_9s = "\1\25\1\4\1\21\2\33\7\uffff";
    static final String dfa_10s = "\5\uffff\1\2\1\1\1\7\1\6\1\5\1\4\1\3";
    static final String dfa_11s = "\14\uffff}>";
    static final String[] dfa_12s = {
            "\1\1",
            "\1\2",
            "\1\3\1\4",
            "\1\6\1\5\1\13\1\12\1\11\1\uffff\1\10\1\7",
            "\1\6\1\5\1\13\1\12\1\11\1\uffff\1\10\1\7",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "899:2: ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'reference-input' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) | (otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'alternative' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';' ) )";
        }
    }
    static final String dfa_13s = "\1\26\1\4\1\20\2\24\6\uffff";
    static final String dfa_14s = "\1\26\1\4\1\21\2\33\6\uffff";
    static final String[] dfa_15s = {
            "\1\1",
            "\1\2",
            "\1\3\1\4",
            "\1\12\1\11\1\10\1\7\1\6\2\uffff\1\5",
            "\1\12\1\11\1\10\1\7\1\6\2\uffff\1\5",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final char[] dfa_13 = DFA.unpackEncodedStringToUnsignedChars(dfa_13s);
    static final char[] dfa_14 = DFA.unpackEncodedStringToUnsignedChars(dfa_14s);
    static final short[][] dfa_15 = unpackEncodedStringArray(dfa_15s);

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_13;
            this.max = dfa_14;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_15;
        }
        public String getDescription() {
            return "1393:2: ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'planner' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) )";
        }
    }
    static final String dfa_16s = "\1\27\1\4\1\20\2\24\6\uffff";
    static final String dfa_17s = "\1\27\1\4\1\21\2\34\6\uffff";
    static final String[] dfa_18s = {
            "\1\1",
            "\1\2",
            "\1\3\1\4",
            "\1\12\1\11\1\10\1\7\1\6\3\uffff\1\5",
            "\1\12\1\11\1\10\1\7\1\6\3\uffff\1\5",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final short[][] dfa_18 = unpackEncodedStringArray(dfa_18s);

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "1819:2: ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'executor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'executor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'effector' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) )";
        }
    }
    static final String dfa_19s = "\24\uffff";
    static final String dfa_20s = "\1\4\1\uffff\1\73\1\4\2\uffff\1\101\1\73\12\4\2\uffff";
    static final String dfa_21s = "\1\74\1\uffff\1\100\1\4\2\uffff\1\112\1\100\12\77\2\uffff";
    static final String dfa_22s = "\1\uffff\1\1\2\uffff\1\2\1\5\14\uffff\1\4\1\3";
    static final String dfa_23s = "\24\uffff}>";
    static final String[] dfa_24s = {
            "\1\2\67\uffff\1\1",
            "",
            "\1\3\1\uffff\1\6\1\4\1\uffff\1\5",
            "\1\7",
            "",
            "",
            "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21",
            "\1\3\1\uffff\1\6\1\4\1\uffff\1\5",
            "\1\23\72\uffff\1\22",
            "\1\23\72\uffff\1\22",
            "\1\23\72\uffff\1\22",
            "\1\23\72\uffff\1\22",
            "\1\23\72\uffff\1\22",
            "\1\23\72\uffff\1\22",
            "\1\23\72\uffff\1\22",
            "\1\23\72\uffff\1\22",
            "\1\23\72\uffff\1\22",
            "\1\23\72\uffff\1\22",
            "",
            ""
    };

    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final char[] dfa_20 = DFA.unpackEncodedStringToUnsignedChars(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[][] dfa_24 = unpackEncodedStringArray(dfa_24s);

    class DFA64 extends DFA {

        public DFA64(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 64;
            this.eot = dfa_19;
            this.eof = dfa_19;
            this.min = dfa_20;
            this.max = dfa_21;
            this.accept = dfa_22;
            this.special = dfa_23;
            this.transition = dfa_24;
        }
        public String getDescription() {
            return "4151:2: ( ( ( (lv_only_0_0= ruleOnly ) ) ( ( ruleFQN ) ) ( (lv_can_2_0= ruleCan ) ) ( (lv_elementType_3_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_5= ';' ) | ( ( ( ruleFQN ) ) ( (lv_cannot_7_0= ruleCannot ) ) ( (lv_elementType_8_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_10= ';' ) | ( ( ( ruleFQN ) ) ( (lv_can_12_0= ruleCan ) ) ( (lv_elementType_13_0= ruleElementType ) ) ( ( ruleFQN ) ) otherlv_15= ';' ) | ( ( ( ruleFQN ) ) ( (lv_can_17_0= ruleCan ) ) ( (lv_elementType_18_0= ruleElementType ) ) ( (lv_only2_19_0= ruleOnly2 ) ) ( ( ruleFQN ) ) otherlv_21= ';' ) | ( ( ( ruleFQN ) ) ( (lv_must_23_0= ruleMust ) ) ( (lv_entityType_24_0= ruleEntityType ) ) ( ( ruleFQN ) ) otherlv_26= ';' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000080002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x1000000003F8A010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x1000000000002010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000300002000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000200002000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x06182B0000002000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x06182A0000002000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0618280000002000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0618200000002000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000400001010L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x000000F800002000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x000000F000002000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x000000E000002000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x000000C000002000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000008000002000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000140000002000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000100000002000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000400000040000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0180000000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x00000000000007FEL});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0800000000000002L});

}