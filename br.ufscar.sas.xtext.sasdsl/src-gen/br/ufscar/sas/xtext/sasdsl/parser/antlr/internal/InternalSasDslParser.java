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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Architecture'", "'{'", "'}'", "'Rules'", "'loopManager'", "'must-use'", "'must-not-use'", "';'", "'loop'", "'monitor'", "'sensor'", "'knowledge'", "'analyzer'", "'planner'", "'reference-input'", "'alternative'", "'executor'", "'effector'", "'measured-output'", "'Managing'", "'Managed'", "'LoopManager'", "'Loop'", "'withDomainRules'", "'Monitor'", "'Analyzer'", "'Planner'", "'Executor'", "'Knowledge'", "'Sensor'", "'Effector'", "'ReferenceInput'", "'MeasuredOutput'", "'Alternative'"
    };
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__44=44;
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
    // InternalSasDsl.g:71:1: ruleArchitectureDefinition returns [EObject current=null] : (otherlv_0= 'Architecture' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managing_3_0= ruleDSLManaging ) )+ ( (lv_managed_4_0= ruleDSLManaged ) )+ otherlv_5= '}' otherlv_6= 'Rules' otherlv_7= '{' ( (lv_rules_8_0= ruleDSLRules ) )* otherlv_9= '}' ) ;
    public final EObject ruleArchitectureDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_managing_3_0 = null;

        EObject lv_managed_4_0 = null;

        EObject lv_rules_8_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:77:2: ( (otherlv_0= 'Architecture' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managing_3_0= ruleDSLManaging ) )+ ( (lv_managed_4_0= ruleDSLManaged ) )+ otherlv_5= '}' otherlv_6= 'Rules' otherlv_7= '{' ( (lv_rules_8_0= ruleDSLRules ) )* otherlv_9= '}' ) )
            // InternalSasDsl.g:78:2: (otherlv_0= 'Architecture' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managing_3_0= ruleDSLManaging ) )+ ( (lv_managed_4_0= ruleDSLManaged ) )+ otherlv_5= '}' otherlv_6= 'Rules' otherlv_7= '{' ( (lv_rules_8_0= ruleDSLRules ) )* otherlv_9= '}' )
            {
            // InternalSasDsl.g:78:2: (otherlv_0= 'Architecture' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managing_3_0= ruleDSLManaging ) )+ ( (lv_managed_4_0= ruleDSLManaged ) )+ otherlv_5= '}' otherlv_6= 'Rules' otherlv_7= '{' ( (lv_rules_8_0= ruleDSLRules ) )* otherlv_9= '}' )
            // InternalSasDsl.g:79:3: otherlv_0= 'Architecture' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managing_3_0= ruleDSLManaging ) )+ ( (lv_managed_4_0= ruleDSLManaged ) )+ otherlv_5= '}' otherlv_6= 'Rules' otherlv_7= '{' ( (lv_rules_8_0= ruleDSLRules ) )* otherlv_9= '}'
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

                if ( (LA3_0==15||(LA3_0>=19 && LA3_0<=21)||(LA3_0>=23 && LA3_0<=24)||LA3_0==27) ) {
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

            otherlv_9=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getArchitectureDefinitionAccess().getRightCurlyBracketKeyword_9());
            		

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
    // InternalSasDsl.g:182:1: entryRuleDSLRules returns [EObject current=null] : iv_ruleDSLRules= ruleDSLRules EOF ;
    public final EObject entryRuleDSLRules() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRules = null;


        try {
            // InternalSasDsl.g:182:49: (iv_ruleDSLRules= ruleDSLRules EOF )
            // InternalSasDsl.g:183:2: iv_ruleDSLRules= ruleDSLRules EOF
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
    // InternalSasDsl.g:189:1: ruleDSLRules returns [EObject current=null] : (this_DSLRuleController_0= ruleDSLRuleController | this_DSLRuleMonitor_1= ruleDSLRuleMonitor | this_DSLRuleAnalyzer_2= ruleDSLRuleAnalyzer | this_DSLRulePlanner_3= ruleDSLRulePlanner | this_DSLRuleExecutor_4= ruleDSLRuleExecutor | this_DSLRuleMO_5= ruleDSLRuleMO | this_DSLRuleMController_6= ruleDSLRuleMController ) ;
    public final EObject ruleDSLRules() throws RecognitionException {
        EObject current = null;

        EObject this_DSLRuleController_0 = null;

        EObject this_DSLRuleMonitor_1 = null;

        EObject this_DSLRuleAnalyzer_2 = null;

        EObject this_DSLRulePlanner_3 = null;

        EObject this_DSLRuleExecutor_4 = null;

        EObject this_DSLRuleMO_5 = null;

        EObject this_DSLRuleMController_6 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:195:2: ( (this_DSLRuleController_0= ruleDSLRuleController | this_DSLRuleMonitor_1= ruleDSLRuleMonitor | this_DSLRuleAnalyzer_2= ruleDSLRuleAnalyzer | this_DSLRulePlanner_3= ruleDSLRulePlanner | this_DSLRuleExecutor_4= ruleDSLRuleExecutor | this_DSLRuleMO_5= ruleDSLRuleMO | this_DSLRuleMController_6= ruleDSLRuleMController ) )
            // InternalSasDsl.g:196:2: (this_DSLRuleController_0= ruleDSLRuleController | this_DSLRuleMonitor_1= ruleDSLRuleMonitor | this_DSLRuleAnalyzer_2= ruleDSLRuleAnalyzer | this_DSLRulePlanner_3= ruleDSLRulePlanner | this_DSLRuleExecutor_4= ruleDSLRuleExecutor | this_DSLRuleMO_5= ruleDSLRuleMO | this_DSLRuleMController_6= ruleDSLRuleMController )
            {
            // InternalSasDsl.g:196:2: (this_DSLRuleController_0= ruleDSLRuleController | this_DSLRuleMonitor_1= ruleDSLRuleMonitor | this_DSLRuleAnalyzer_2= ruleDSLRuleAnalyzer | this_DSLRulePlanner_3= ruleDSLRulePlanner | this_DSLRuleExecutor_4= ruleDSLRuleExecutor | this_DSLRuleMO_5= ruleDSLRuleMO | this_DSLRuleMController_6= ruleDSLRuleMController )
            int alt4=7;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt4=1;
                }
                break;
            case 20:
                {
                alt4=2;
                }
                break;
            case 23:
                {
                alt4=3;
                }
                break;
            case 24:
                {
                alt4=4;
                }
                break;
            case 27:
                {
                alt4=5;
                }
                break;
            case 21:
                {
                alt4=6;
                }
                break;
            case 15:
                {
                alt4=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalSasDsl.g:197:3: this_DSLRuleController_0= ruleDSLRuleController
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
                    // InternalSasDsl.g:206:3: this_DSLRuleMonitor_1= ruleDSLRuleMonitor
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
                    // InternalSasDsl.g:215:3: this_DSLRuleAnalyzer_2= ruleDSLRuleAnalyzer
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
                    // InternalSasDsl.g:224:3: this_DSLRulePlanner_3= ruleDSLRulePlanner
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
                    // InternalSasDsl.g:233:3: this_DSLRuleExecutor_4= ruleDSLRuleExecutor
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
                    // InternalSasDsl.g:242:3: this_DSLRuleMO_5= ruleDSLRuleMO
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
                    // InternalSasDsl.g:251:3: this_DSLRuleMController_6= ruleDSLRuleMController
                    {

                    			newCompositeNode(grammarAccess.getDSLRulesAccess().getDSLRuleMControllerParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_DSLRuleMController_6=ruleDSLRuleMController();

                    state._fsp--;


                    			current = this_DSLRuleMController_6;
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
    // InternalSasDsl.g:263:1: entryRuleDSLRuleMController returns [EObject current=null] : iv_ruleDSLRuleMController= ruleDSLRuleMController EOF ;
    public final EObject entryRuleDSLRuleMController() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleMController = null;


        try {
            // InternalSasDsl.g:263:59: (iv_ruleDSLRuleMController= ruleDSLRuleMController EOF )
            // InternalSasDsl.g:264:2: iv_ruleDSLRuleMController= ruleDSLRuleMController EOF
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
    // InternalSasDsl.g:270:1: ruleDSLRuleMController returns [EObject current=null] : (otherlv_0= 'loopManager' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loopManager' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) ;
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
            // InternalSasDsl.g:276:2: ( (otherlv_0= 'loopManager' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loopManager' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) )
            // InternalSasDsl.g:277:2: (otherlv_0= 'loopManager' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loopManager' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            {
            // InternalSasDsl.g:277:2: (otherlv_0= 'loopManager' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loopManager' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            // InternalSasDsl.g:278:3: otherlv_0= 'loopManager' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loopManager' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLRuleMControllerAccess().getLoopManagerKeyword_0());
            		
            // InternalSasDsl.g:282:3: ( (otherlv_1= RULE_ID ) )
            // InternalSasDsl.g:283:4: (otherlv_1= RULE_ID )
            {
            // InternalSasDsl.g:283:4: (otherlv_1= RULE_ID )
            // InternalSasDsl.g:284:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleMControllerRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(otherlv_1, grammarAccess.getDSLRuleMControllerAccess().getMcontroller1DSLManagerControllerCrossReference_1_0());
            				

            }


            }

            // InternalSasDsl.g:295:3: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
            // InternalSasDsl.g:296:4: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
            {
            // InternalSasDsl.g:296:4: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
            // InternalSasDsl.g:297:5: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
            {
            // InternalSasDsl.g:297:5: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            else if ( (LA5_0==17) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalSasDsl.g:298:6: lv_access_2_1= 'must-use'
                    {
                    lv_access_2_1=(Token)match(input,16,FOLLOW_11); 

                    						newLeafNode(lv_access_2_1, grammarAccess.getDSLRuleMControllerAccess().getAccessMustUseKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMControllerRule());
                    						}
                    						setWithLastConsumed(current, "access", lv_access_2_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:309:6: lv_access_2_2= 'must-not-use'
                    {
                    lv_access_2_2=(Token)match(input,17,FOLLOW_11); 

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
            		
            // InternalSasDsl.g:326:3: ( (otherlv_4= RULE_ID ) )
            // InternalSasDsl.g:327:4: (otherlv_4= RULE_ID )
            {
            // InternalSasDsl.g:327:4: (otherlv_4= RULE_ID )
            // InternalSasDsl.g:328:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleMControllerRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

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
    // InternalSasDsl.g:347:1: entryRuleDSLRuleController returns [EObject current=null] : iv_ruleDSLRuleController= ruleDSLRuleController EOF ;
    public final EObject entryRuleDSLRuleController() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleController = null;


        try {
            // InternalSasDsl.g:347:58: (iv_ruleDSLRuleController= ruleDSLRuleController EOF )
            // InternalSasDsl.g:348:2: iv_ruleDSLRuleController= ruleDSLRuleController EOF
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
    // InternalSasDsl.g:354:1: ruleDSLRuleController returns [EObject current=null] : (otherlv_0= 'loop' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loop' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) ;
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
            // InternalSasDsl.g:360:2: ( (otherlv_0= 'loop' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loop' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) )
            // InternalSasDsl.g:361:2: (otherlv_0= 'loop' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loop' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            {
            // InternalSasDsl.g:361:2: (otherlv_0= 'loop' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loop' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            // InternalSasDsl.g:362:3: otherlv_0= 'loop' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loop' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLRuleControllerAccess().getLoopKeyword_0());
            		
            // InternalSasDsl.g:366:3: ( (otherlv_1= RULE_ID ) )
            // InternalSasDsl.g:367:4: (otherlv_1= RULE_ID )
            {
            // InternalSasDsl.g:367:4: (otherlv_1= RULE_ID )
            // InternalSasDsl.g:368:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleControllerRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(otherlv_1, grammarAccess.getDSLRuleControllerAccess().getController1DSLControllerCrossReference_1_0());
            				

            }


            }

            // InternalSasDsl.g:379:3: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
            // InternalSasDsl.g:380:4: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
            {
            // InternalSasDsl.g:380:4: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
            // InternalSasDsl.g:381:5: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
            {
            // InternalSasDsl.g:381:5: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
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
                    // InternalSasDsl.g:382:6: lv_access_2_1= 'must-use'
                    {
                    lv_access_2_1=(Token)match(input,16,FOLLOW_13); 

                    						newLeafNode(lv_access_2_1, grammarAccess.getDSLRuleControllerAccess().getAccessMustUseKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleControllerRule());
                    						}
                    						setWithLastConsumed(current, "access", lv_access_2_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:393:6: lv_access_2_2= 'must-not-use'
                    {
                    lv_access_2_2=(Token)match(input,17,FOLLOW_13); 

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
            		
            // InternalSasDsl.g:410:3: ( (otherlv_4= RULE_ID ) )
            // InternalSasDsl.g:411:4: (otherlv_4= RULE_ID )
            {
            // InternalSasDsl.g:411:4: (otherlv_4= RULE_ID )
            // InternalSasDsl.g:412:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleControllerRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

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
    // InternalSasDsl.g:431:1: entryRuleDSLRuleMonitor returns [EObject current=null] : iv_ruleDSLRuleMonitor= ruleDSLRuleMonitor EOF ;
    public final EObject entryRuleDSLRuleMonitor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleMonitor = null;


        try {
            // InternalSasDsl.g:431:55: (iv_ruleDSLRuleMonitor= ruleDSLRuleMonitor EOF )
            // InternalSasDsl.g:432:2: iv_ruleDSLRuleMonitor= ruleDSLRuleMonitor EOF
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
    // InternalSasDsl.g:438:1: ruleDSLRuleMonitor returns [EObject current=null] : ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'sensor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'knowledge' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'analyzer' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'monitor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) ) ;
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


        	enterRule();

        try {
            // InternalSasDsl.g:444:2: ( ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'sensor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'knowledge' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'analyzer' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'monitor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) ) )
            // InternalSasDsl.g:445:2: ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'sensor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'knowledge' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'analyzer' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'monitor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) )
            {
            // InternalSasDsl.g:445:2: ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'sensor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'knowledge' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'analyzer' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'monitor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) )
            int alt11=4;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==RULE_ID) ) {
                    int LA11_2 = input.LA(3);

                    if ( (LA11_2==16) ) {
                        switch ( input.LA(4) ) {
                        case 22:
                            {
                            alt11=2;
                            }
                            break;
                        case 21:
                            {
                            alt11=1;
                            }
                            break;
                        case 20:
                            {
                            alt11=4;
                            }
                            break;
                        case 23:
                            {
                            alt11=3;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 11, 3, input);

                            throw nvae;
                        }

                    }
                    else if ( (LA11_2==17) ) {
                        switch ( input.LA(4) ) {
                        case 20:
                            {
                            alt11=4;
                            }
                            break;
                        case 23:
                            {
                            alt11=3;
                            }
                            break;
                        case 22:
                            {
                            alt11=2;
                            }
                            break;
                        case 21:
                            {
                            alt11=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 11, 4, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalSasDsl.g:446:3: (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'sensor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:446:3: (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'sensor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:447:4: otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'sensor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_0_0());
                    			
                    // InternalSasDsl.g:451:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:452:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:452:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:453:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:464:4: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:465:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:465:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    // InternalSasDsl.g:466:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:466:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
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
                            // InternalSasDsl.g:467:7: lv_access_2_1= 'must-use'
                            {
                            lv_access_2_1=(Token)match(input,16,FOLLOW_14); 

                            							newLeafNode(lv_access_2_1, grammarAccess.getDSLRuleMonitorAccess().getAccessMustUseKeyword_0_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_2_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:478:7: lv_access_2_2= 'must-not-use'
                            {
                            lv_access_2_2=(Token)match(input,17,FOLLOW_14); 

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

                    otherlv_3=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDSLRuleMonitorAccess().getSensorKeyword_0_3());
                    			
                    // InternalSasDsl.g:495:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:496:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:496:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:497:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRuleMonitorAccess().getSensorDSLSensorCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRuleMonitorAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:514:3: (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'knowledge' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:514:3: (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'knowledge' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:515:4: otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'knowledge' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_1_0());
                    			
                    // InternalSasDsl.g:519:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:520:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:520:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:521:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:532:4: ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:533:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:533:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    // InternalSasDsl.g:534:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:534:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
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
                            // InternalSasDsl.g:535:7: lv_access_8_1= 'must-use'
                            {
                            lv_access_8_1=(Token)match(input,16,FOLLOW_15); 

                            							newLeafNode(lv_access_8_1, grammarAccess.getDSLRuleMonitorAccess().getAccessMustUseKeyword_1_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_8_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:546:7: lv_access_8_2= 'must-not-use'
                            {
                            lv_access_8_2=(Token)match(input,17,FOLLOW_15); 

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

                    otherlv_9=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getDSLRuleMonitorAccess().getKnowledgeKeyword_1_3());
                    			
                    // InternalSasDsl.g:563:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:564:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:564:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:565:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRuleMonitorAccess().getKnowledgeDSLKnowledgeCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRuleMonitorAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:582:3: (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'analyzer' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:582:3: (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'analyzer' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:583:4: otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'analyzer' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_2_0());
                    			
                    // InternalSasDsl.g:587:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:588:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:588:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:589:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:600:4: ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:601:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:601:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    // InternalSasDsl.g:602:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:602:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
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
                            // InternalSasDsl.g:603:7: lv_access_14_1= 'must-use'
                            {
                            lv_access_14_1=(Token)match(input,16,FOLLOW_16); 

                            							newLeafNode(lv_access_14_1, grammarAccess.getDSLRuleMonitorAccess().getAccessMustUseKeyword_2_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_14_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:614:7: lv_access_14_2= 'must-not-use'
                            {
                            lv_access_14_2=(Token)match(input,17,FOLLOW_16); 

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

                    otherlv_15=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getDSLRuleMonitorAccess().getAnalyzerKeyword_2_3());
                    			
                    // InternalSasDsl.g:631:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:632:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:632:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:633:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRuleMonitorAccess().getAnalyzerDSLAnalyzerCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRuleMonitorAccess().getSemicolonKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:650:3: (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'monitor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    {
                    // InternalSasDsl.g:650:3: (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'monitor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    // InternalSasDsl.g:651:4: otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'monitor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';'
                    {
                    otherlv_18=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_3_0());
                    			
                    // InternalSasDsl.g:655:4: ( (otherlv_19= RULE_ID ) )
                    // InternalSasDsl.g:656:5: (otherlv_19= RULE_ID )
                    {
                    // InternalSasDsl.g:656:5: (otherlv_19= RULE_ID )
                    // InternalSasDsl.g:657:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_19, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:668:4: ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:669:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:669:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    // InternalSasDsl.g:670:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:670:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
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
                            // InternalSasDsl.g:671:7: lv_access_20_1= 'must-use'
                            {
                            lv_access_20_1=(Token)match(input,16,FOLLOW_17); 

                            							newLeafNode(lv_access_20_1, grammarAccess.getDSLRuleMonitorAccess().getAccessMustUseKeyword_3_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_20_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:682:7: lv_access_20_2= 'must-not-use'
                            {
                            lv_access_20_2=(Token)match(input,17,FOLLOW_17); 

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

                    otherlv_21=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_21, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_3_3());
                    			
                    // InternalSasDsl.g:699:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSasDsl.g:700:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSasDsl.g:700:5: (otherlv_22= RULE_ID )
                    // InternalSasDsl.g:701:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_22, grammarAccess.getDSLRuleMonitorAccess().getMonitor2DSLMonitorCrossReference_3_4_0());
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_23, grammarAccess.getDSLRuleMonitorAccess().getSemicolonKeyword_3_5());
                    			

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
    // InternalSasDsl.g:721:1: entryRuleDSLRuleAnalyzer returns [EObject current=null] : iv_ruleDSLRuleAnalyzer= ruleDSLRuleAnalyzer EOF ;
    public final EObject entryRuleDSLRuleAnalyzer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleAnalyzer = null;


        try {
            // InternalSasDsl.g:721:56: (iv_ruleDSLRuleAnalyzer= ruleDSLRuleAnalyzer EOF )
            // InternalSasDsl.g:722:2: iv_ruleDSLRuleAnalyzer= ruleDSLRuleAnalyzer EOF
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
    // InternalSasDsl.g:728:1: ruleDSLRuleAnalyzer returns [EObject current=null] : ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'analyzer' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) | (otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'executor' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';' ) ) ;
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
            // InternalSasDsl.g:734:2: ( ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'analyzer' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) | (otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'executor' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';' ) ) )
            // InternalSasDsl.g:735:2: ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'analyzer' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) | (otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'executor' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';' ) )
            {
            // InternalSasDsl.g:735:2: ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'analyzer' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) | (otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'executor' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';' ) )
            int alt19=7;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // InternalSasDsl.g:736:3: (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:736:3: (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:737:4: otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_0_0());
                    			
                    // InternalSasDsl.g:741:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:742:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:742:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:743:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:754:4: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:755:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:755:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    // InternalSasDsl.g:756:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:756:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
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
                            // InternalSasDsl.g:757:7: lv_access_2_1= 'must-use'
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
                            // InternalSasDsl.g:768:7: lv_access_2_2= 'must-not-use'
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

                    otherlv_3=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDSLRuleAnalyzerAccess().getKnowledgeKeyword_0_3());
                    			
                    // InternalSasDsl.g:785:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:786:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:786:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:787:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRuleAnalyzerAccess().getKnowledgeDSLKnowledgeCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:804:3: (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:804:3: (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:805:4: otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_1_0());
                    			
                    // InternalSasDsl.g:809:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:810:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:810:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:811:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:822:4: ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:823:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:823:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    // InternalSasDsl.g:824:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:824:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
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
                            // InternalSasDsl.g:825:7: lv_access_8_1= 'must-use'
                            {
                            lv_access_8_1=(Token)match(input,16,FOLLOW_17); 

                            							newLeafNode(lv_access_8_1, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustUseKeyword_1_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_8_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:836:7: lv_access_8_2= 'must-not-use'
                            {
                            lv_access_8_2=(Token)match(input,17,FOLLOW_17); 

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

                    otherlv_9=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getDSLRuleAnalyzerAccess().getMonitorKeyword_1_3());
                    			
                    // InternalSasDsl.g:853:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:854:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:854:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:855:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRuleAnalyzerAccess().getMonitorDSLMonitorCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:872:3: (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:872:3: (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:873:4: otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_2_0());
                    			
                    // InternalSasDsl.g:877:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:878:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:878:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:879:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:890:4: ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:891:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:891:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    // InternalSasDsl.g:892:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:892:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==16) ) {
                        alt14=1;
                    }
                    else if ( (LA14_0==17) ) {
                        alt14=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalSasDsl.g:893:7: lv_access_14_1= 'must-use'
                            {
                            lv_access_14_1=(Token)match(input,16,FOLLOW_18); 

                            							newLeafNode(lv_access_14_1, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustUseKeyword_2_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_14_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:904:7: lv_access_14_2= 'must-not-use'
                            {
                            lv_access_14_2=(Token)match(input,17,FOLLOW_18); 

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

                    otherlv_15=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getDSLRuleAnalyzerAccess().getPlannerKeyword_2_3());
                    			
                    // InternalSasDsl.g:921:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:922:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:922:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:923:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRuleAnalyzerAccess().getPlannerDSLPlannerCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:940:3: (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    {
                    // InternalSasDsl.g:940:3: (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    // InternalSasDsl.g:941:4: otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';'
                    {
                    otherlv_18=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_3_0());
                    			
                    // InternalSasDsl.g:945:4: ( (otherlv_19= RULE_ID ) )
                    // InternalSasDsl.g:946:5: (otherlv_19= RULE_ID )
                    {
                    // InternalSasDsl.g:946:5: (otherlv_19= RULE_ID )
                    // InternalSasDsl.g:947:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_19, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:958:4: ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:959:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:959:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    // InternalSasDsl.g:960:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:960:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
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
                            // InternalSasDsl.g:961:7: lv_access_20_1= 'must-use'
                            {
                            lv_access_20_1=(Token)match(input,16,FOLLOW_19); 

                            							newLeafNode(lv_access_20_1, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustUseKeyword_3_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_20_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:972:7: lv_access_20_2= 'must-not-use'
                            {
                            lv_access_20_2=(Token)match(input,17,FOLLOW_19); 

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

                    otherlv_21=(Token)match(input,25,FOLLOW_3); 

                    				newLeafNode(otherlv_21, grammarAccess.getDSLRuleAnalyzerAccess().getReferenceInputKeyword_3_3());
                    			
                    // InternalSasDsl.g:989:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSasDsl.g:990:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSasDsl.g:990:5: (otherlv_22= RULE_ID )
                    // InternalSasDsl.g:991:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_22, grammarAccess.getDSLRuleAnalyzerAccess().getRreferenceDSLReferenceInputCrossReference_3_4_0());
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_23, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_3_5());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalSasDsl.g:1008:3: (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'analyzer' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    {
                    // InternalSasDsl.g:1008:3: (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'analyzer' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    // InternalSasDsl.g:1009:4: otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'analyzer' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';'
                    {
                    otherlv_24=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_24, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_4_0());
                    			
                    // InternalSasDsl.g:1013:4: ( (otherlv_25= RULE_ID ) )
                    // InternalSasDsl.g:1014:5: (otherlv_25= RULE_ID )
                    {
                    // InternalSasDsl.g:1014:5: (otherlv_25= RULE_ID )
                    // InternalSasDsl.g:1015:6: otherlv_25= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_25=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_25, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_4_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1026:4: ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1027:5: ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1027:5: ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1028:6: (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1028:6: (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1029:7: lv_access_26_1= 'must-use'
                            {
                            lv_access_26_1=(Token)match(input,16,FOLLOW_16); 

                            							newLeafNode(lv_access_26_1, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustUseKeyword_4_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_26_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1040:7: lv_access_26_2= 'must-not-use'
                            {
                            lv_access_26_2=(Token)match(input,17,FOLLOW_16); 

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

                    otherlv_27=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_27, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_4_3());
                    			
                    // InternalSasDsl.g:1057:4: ( (otherlv_28= RULE_ID ) )
                    // InternalSasDsl.g:1058:5: (otherlv_28= RULE_ID )
                    {
                    // InternalSasDsl.g:1058:5: (otherlv_28= RULE_ID )
                    // InternalSasDsl.g:1059:6: otherlv_28= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_28=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_28, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzer2DSLAnalyzerCrossReference_4_4_0());
                    					

                    }


                    }

                    otherlv_29=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_29, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_4_5());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalSasDsl.g:1076:3: (otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' )
                    {
                    // InternalSasDsl.g:1076:3: (otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' )
                    // InternalSasDsl.g:1077:4: otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';'
                    {
                    otherlv_30=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_30, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_5_0());
                    			
                    // InternalSasDsl.g:1081:4: ( (otherlv_31= RULE_ID ) )
                    // InternalSasDsl.g:1082:5: (otherlv_31= RULE_ID )
                    {
                    // InternalSasDsl.g:1082:5: (otherlv_31= RULE_ID )
                    // InternalSasDsl.g:1083:6: otherlv_31= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_31=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_31, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_5_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1094:4: ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1095:5: ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1095:5: ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1096:6: (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1096:6: (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1097:7: lv_access_32_1= 'must-use'
                            {
                            lv_access_32_1=(Token)match(input,16,FOLLOW_20); 

                            							newLeafNode(lv_access_32_1, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustUseKeyword_5_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_32_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1108:7: lv_access_32_2= 'must-not-use'
                            {
                            lv_access_32_2=(Token)match(input,17,FOLLOW_20); 

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

                    				newLeafNode(otherlv_33, grammarAccess.getDSLRuleAnalyzerAccess().getAlternativeKeyword_5_3());
                    			
                    // InternalSasDsl.g:1125:4: ( (otherlv_34= RULE_ID ) )
                    // InternalSasDsl.g:1126:5: (otherlv_34= RULE_ID )
                    {
                    // InternalSasDsl.g:1126:5: (otherlv_34= RULE_ID )
                    // InternalSasDsl.g:1127:6: otherlv_34= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_34=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_34, grammarAccess.getDSLRuleAnalyzerAccess().getShaltDSLAlternativeCrossReference_5_4_0());
                    					

                    }


                    }

                    otherlv_35=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_35, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_5_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalSasDsl.g:1144:3: (otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'executor' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';' )
                    {
                    // InternalSasDsl.g:1144:3: (otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'executor' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';' )
                    // InternalSasDsl.g:1145:4: otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'executor' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';'
                    {
                    otherlv_36=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_36, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_6_0());
                    			
                    // InternalSasDsl.g:1149:4: ( (otherlv_37= RULE_ID ) )
                    // InternalSasDsl.g:1150:5: (otherlv_37= RULE_ID )
                    {
                    // InternalSasDsl.g:1150:5: (otherlv_37= RULE_ID )
                    // InternalSasDsl.g:1151:6: otherlv_37= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_37=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_37, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_6_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1162:4: ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1163:5: ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1163:5: ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1164:6: (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1164:6: (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1165:7: lv_access_38_1= 'must-use'
                            {
                            lv_access_38_1=(Token)match(input,16,FOLLOW_21); 

                            							newLeafNode(lv_access_38_1, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustUseKeyword_6_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_38_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1176:7: lv_access_38_2= 'must-not-use'
                            {
                            lv_access_38_2=(Token)match(input,17,FOLLOW_21); 

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

                    				newLeafNode(otherlv_39, grammarAccess.getDSLRuleAnalyzerAccess().getExecutorKeyword_6_3());
                    			
                    // InternalSasDsl.g:1193:4: ( (otherlv_40= RULE_ID ) )
                    // InternalSasDsl.g:1194:5: (otherlv_40= RULE_ID )
                    {
                    // InternalSasDsl.g:1194:5: (otherlv_40= RULE_ID )
                    // InternalSasDsl.g:1195:6: otherlv_40= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_40=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_40, grammarAccess.getDSLRuleAnalyzerAccess().getExecutorDSLExecutorCrossReference_6_4_0());
                    					

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
    // InternalSasDsl.g:1215:1: entryRuleDSLRulePlanner returns [EObject current=null] : iv_ruleDSLRulePlanner= ruleDSLRulePlanner EOF ;
    public final EObject entryRuleDSLRulePlanner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRulePlanner = null;


        try {
            // InternalSasDsl.g:1215:55: (iv_ruleDSLRulePlanner= ruleDSLRulePlanner EOF )
            // InternalSasDsl.g:1216:2: iv_ruleDSLRulePlanner= ruleDSLRulePlanner EOF
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
    // InternalSasDsl.g:1222:1: ruleDSLRulePlanner returns [EObject current=null] : ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'planner' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'alternative' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) ) ;
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


        	enterRule();

        try {
            // InternalSasDsl.g:1228:2: ( ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'planner' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'alternative' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) ) )
            // InternalSasDsl.g:1229:2: ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'planner' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'alternative' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) )
            {
            // InternalSasDsl.g:1229:2: ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'planner' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'alternative' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) )
            int alt25=5;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // InternalSasDsl.g:1230:3: (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:1230:3: (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:1231:4: otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_0_0());
                    			
                    // InternalSasDsl.g:1235:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:1236:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:1236:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:1237:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1248:4: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1249:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1249:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1250:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1250:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1251:7: lv_access_2_1= 'must-use'
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
                            // InternalSasDsl.g:1262:7: lv_access_2_2= 'must-not-use'
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

                    otherlv_3=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDSLRulePlannerAccess().getKnowledgeKeyword_0_3());
                    			
                    // InternalSasDsl.g:1279:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:1280:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:1280:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:1281:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRulePlannerAccess().getKnowledgeDSLKnowledgeCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:1298:3: (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:1298:3: (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:1299:4: otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_1_0());
                    			
                    // InternalSasDsl.g:1303:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:1304:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:1304:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:1305:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1316:4: ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1317:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1317:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1318:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1318:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1319:7: lv_access_8_1= 'must-use'
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
                            // InternalSasDsl.g:1330:7: lv_access_8_2= 'must-not-use'
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

                    otherlv_9=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getDSLRulePlannerAccess().getAnalyzerKeyword_1_3());
                    			
                    // InternalSasDsl.g:1347:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:1348:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:1348:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:1349:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRulePlannerAccess().getAnalyzerDSLAnalyzerCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:1366:3: (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:1366:3: (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:1367:4: otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_2_0());
                    			
                    // InternalSasDsl.g:1371:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:1372:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:1372:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:1373:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1384:4: ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1385:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1385:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1386:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1386:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==16) ) {
                        alt22=1;
                    }
                    else if ( (LA22_0==17) ) {
                        alt22=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);

                        throw nvae;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalSasDsl.g:1387:7: lv_access_14_1= 'must-use'
                            {
                            lv_access_14_1=(Token)match(input,16,FOLLOW_21); 

                            							newLeafNode(lv_access_14_1, grammarAccess.getDSLRulePlannerAccess().getAccessMustUseKeyword_2_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_14_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1398:7: lv_access_14_2= 'must-not-use'
                            {
                            lv_access_14_2=(Token)match(input,17,FOLLOW_21); 

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

                    otherlv_15=(Token)match(input,27,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getDSLRulePlannerAccess().getExecutorKeyword_2_3());
                    			
                    // InternalSasDsl.g:1415:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:1416:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:1416:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:1417:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRulePlannerAccess().getExecutorDSLExecutorCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:1434:3: (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'planner' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    {
                    // InternalSasDsl.g:1434:3: (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'planner' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    // InternalSasDsl.g:1435:4: otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'planner' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';'
                    {
                    otherlv_18=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_3_0());
                    			
                    // InternalSasDsl.g:1439:4: ( (otherlv_19= RULE_ID ) )
                    // InternalSasDsl.g:1440:5: (otherlv_19= RULE_ID )
                    {
                    // InternalSasDsl.g:1440:5: (otherlv_19= RULE_ID )
                    // InternalSasDsl.g:1441:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_19, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1452:4: ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1453:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1453:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1454:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1454:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1455:7: lv_access_20_1= 'must-use'
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
                            // InternalSasDsl.g:1466:7: lv_access_20_2= 'must-not-use'
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

                    otherlv_21=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_21, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_3_3());
                    			
                    // InternalSasDsl.g:1483:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSasDsl.g:1484:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSasDsl.g:1484:5: (otherlv_22= RULE_ID )
                    // InternalSasDsl.g:1485:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_22, grammarAccess.getDSLRulePlannerAccess().getPlanner2DSLPlannerCrossReference_3_4_0());
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_23, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_3_5());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalSasDsl.g:1502:3: (otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'alternative' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    {
                    // InternalSasDsl.g:1502:3: (otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'alternative' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    // InternalSasDsl.g:1503:4: otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'alternative' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';'
                    {
                    otherlv_24=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_24, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_4_0());
                    			
                    // InternalSasDsl.g:1507:4: ( (otherlv_25= RULE_ID ) )
                    // InternalSasDsl.g:1508:5: (otherlv_25= RULE_ID )
                    {
                    // InternalSasDsl.g:1508:5: (otherlv_25= RULE_ID )
                    // InternalSasDsl.g:1509:6: otherlv_25= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_25=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_25, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_4_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1520:4: ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1521:5: ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1521:5: ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1522:6: (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1522:6: (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1523:7: lv_access_26_1= 'must-use'
                            {
                            lv_access_26_1=(Token)match(input,16,FOLLOW_20); 

                            							newLeafNode(lv_access_26_1, grammarAccess.getDSLRulePlannerAccess().getAccessMustUseKeyword_4_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_26_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1534:7: lv_access_26_2= 'must-not-use'
                            {
                            lv_access_26_2=(Token)match(input,17,FOLLOW_20); 

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

                    otherlv_27=(Token)match(input,26,FOLLOW_3); 

                    				newLeafNode(otherlv_27, grammarAccess.getDSLRulePlannerAccess().getAlternativeKeyword_4_3());
                    			
                    // InternalSasDsl.g:1551:4: ( (otherlv_28= RULE_ID ) )
                    // InternalSasDsl.g:1552:5: (otherlv_28= RULE_ID )
                    {
                    // InternalSasDsl.g:1552:5: (otherlv_28= RULE_ID )
                    // InternalSasDsl.g:1553:6: otherlv_28= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_28=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_28, grammarAccess.getDSLRulePlannerAccess().getShaltDSLAlternativeCrossReference_4_4_0());
                    					

                    }


                    }

                    otherlv_29=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_29, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_4_5());
                    			

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
    // InternalSasDsl.g:1573:1: entryRuleDSLRuleExecutor returns [EObject current=null] : iv_ruleDSLRuleExecutor= ruleDSLRuleExecutor EOF ;
    public final EObject entryRuleDSLRuleExecutor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleExecutor = null;


        try {
            // InternalSasDsl.g:1573:56: (iv_ruleDSLRuleExecutor= ruleDSLRuleExecutor EOF )
            // InternalSasDsl.g:1574:2: iv_ruleDSLRuleExecutor= ruleDSLRuleExecutor EOF
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
    // InternalSasDsl.g:1580:1: ruleDSLRuleExecutor returns [EObject current=null] : ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'effector' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'planner' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'knowledge' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) ) ;
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


        	enterRule();

        try {
            // InternalSasDsl.g:1586:2: ( ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'effector' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'planner' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'knowledge' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) ) )
            // InternalSasDsl.g:1587:2: ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'effector' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'planner' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'knowledge' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) )
            {
            // InternalSasDsl.g:1587:2: ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'effector' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'planner' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'knowledge' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) )
            int alt30=4;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==27) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==RULE_ID) ) {
                    int LA30_2 = input.LA(3);

                    if ( (LA30_2==16) ) {
                        switch ( input.LA(4) ) {
                        case 27:
                            {
                            alt30=4;
                            }
                            break;
                        case 22:
                            {
                            alt30=3;
                            }
                            break;
                        case 24:
                            {
                            alt30=2;
                            }
                            break;
                        case 28:
                            {
                            alt30=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 30, 3, input);

                            throw nvae;
                        }

                    }
                    else if ( (LA30_2==17) ) {
                        switch ( input.LA(4) ) {
                        case 27:
                            {
                            alt30=4;
                            }
                            break;
                        case 22:
                            {
                            alt30=3;
                            }
                            break;
                        case 24:
                            {
                            alt30=2;
                            }
                            break;
                        case 28:
                            {
                            alt30=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 30, 4, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // InternalSasDsl.g:1588:3: (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'effector' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:1588:3: (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'effector' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:1589:4: otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'effector' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,27,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_0_0());
                    			
                    // InternalSasDsl.g:1593:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:1594:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:1594:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:1595:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1606:4: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1607:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1607:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1608:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1608:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1609:7: lv_access_2_1= 'must-use'
                            {
                            lv_access_2_1=(Token)match(input,16,FOLLOW_22); 

                            							newLeafNode(lv_access_2_1, grammarAccess.getDSLRuleExecutorAccess().getAccessMustUseKeyword_0_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_2_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1620:7: lv_access_2_2= 'must-not-use'
                            {
                            lv_access_2_2=(Token)match(input,17,FOLLOW_22); 

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

                    otherlv_3=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDSLRuleExecutorAccess().getEffectorKeyword_0_3());
                    			
                    // InternalSasDsl.g:1637:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:1638:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:1638:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:1639:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRuleExecutorAccess().getEffectorDSLEffectorCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRuleExecutorAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:1656:3: (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'planner' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:1656:3: (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'planner' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:1657:4: otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'planner' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,27,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_1_0());
                    			
                    // InternalSasDsl.g:1661:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:1662:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:1662:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:1663:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1674:4: ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1675:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1675:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1676:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1676:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1677:7: lv_access_8_1= 'must-use'
                            {
                            lv_access_8_1=(Token)match(input,16,FOLLOW_18); 

                            							newLeafNode(lv_access_8_1, grammarAccess.getDSLRuleExecutorAccess().getAccessMustUseKeyword_1_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_8_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1688:7: lv_access_8_2= 'must-not-use'
                            {
                            lv_access_8_2=(Token)match(input,17,FOLLOW_18); 

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

                    otherlv_9=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getDSLRuleExecutorAccess().getPlannerKeyword_1_3());
                    			
                    // InternalSasDsl.g:1705:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:1706:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:1706:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:1707:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRuleExecutorAccess().getPlannerDSLPlannerCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRuleExecutorAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:1724:3: (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'knowledge' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:1724:3: (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'knowledge' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:1725:4: otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'knowledge' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,27,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_2_0());
                    			
                    // InternalSasDsl.g:1729:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:1730:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:1730:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:1731:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1742:4: ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1743:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1743:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1744:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1744:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1745:7: lv_access_14_1= 'must-use'
                            {
                            lv_access_14_1=(Token)match(input,16,FOLLOW_15); 

                            							newLeafNode(lv_access_14_1, grammarAccess.getDSLRuleExecutorAccess().getAccessMustUseKeyword_2_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_14_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1756:7: lv_access_14_2= 'must-not-use'
                            {
                            lv_access_14_2=(Token)match(input,17,FOLLOW_15); 

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

                    				newLeafNode(otherlv_15, grammarAccess.getDSLRuleExecutorAccess().getKnowledgeKeyword_2_3());
                    			
                    // InternalSasDsl.g:1773:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:1774:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:1774:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:1775:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRuleExecutorAccess().getKnowledgeDSLKnowledgeCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRuleExecutorAccess().getSemicolonKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:1792:3: (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    {
                    // InternalSasDsl.g:1792:3: (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    // InternalSasDsl.g:1793:4: otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';'
                    {
                    otherlv_18=(Token)match(input,27,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_3_0());
                    			
                    // InternalSasDsl.g:1797:4: ( (otherlv_19= RULE_ID ) )
                    // InternalSasDsl.g:1798:5: (otherlv_19= RULE_ID )
                    {
                    // InternalSasDsl.g:1798:5: (otherlv_19= RULE_ID )
                    // InternalSasDsl.g:1799:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_19, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1810:4: ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1811:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1811:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1812:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1812:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==16) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==17) ) {
                        alt29=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 0, input);

                        throw nvae;
                    }
                    switch (alt29) {
                        case 1 :
                            // InternalSasDsl.g:1813:7: lv_access_20_1= 'must-use'
                            {
                            lv_access_20_1=(Token)match(input,16,FOLLOW_21); 

                            							newLeafNode(lv_access_20_1, grammarAccess.getDSLRuleExecutorAccess().getAccessMustUseKeyword_3_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_20_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1824:7: lv_access_20_2= 'must-not-use'
                            {
                            lv_access_20_2=(Token)match(input,17,FOLLOW_21); 

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

                    otherlv_21=(Token)match(input,27,FOLLOW_3); 

                    				newLeafNode(otherlv_21, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_3_3());
                    			
                    // InternalSasDsl.g:1841:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSasDsl.g:1842:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSasDsl.g:1842:5: (otherlv_22= RULE_ID )
                    // InternalSasDsl.g:1843:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_22, grammarAccess.getDSLRuleExecutorAccess().getExecutor2DSLExecutorCrossReference_3_4_0());
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_23, grammarAccess.getDSLRuleExecutorAccess().getSemicolonKeyword_3_5());
                    			

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


    // $ANTLR start "entryRuleDSLRuleMO"
    // InternalSasDsl.g:1863:1: entryRuleDSLRuleMO returns [EObject current=null] : iv_ruleDSLRuleMO= ruleDSLRuleMO EOF ;
    public final EObject entryRuleDSLRuleMO() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleMO = null;


        try {
            // InternalSasDsl.g:1863:50: (iv_ruleDSLRuleMO= ruleDSLRuleMO EOF )
            // InternalSasDsl.g:1864:2: iv_ruleDSLRuleMO= ruleDSLRuleMO EOF
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
    // InternalSasDsl.g:1870:1: ruleDSLRuleMO returns [EObject current=null] : (otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) ;
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
            // InternalSasDsl.g:1876:2: ( (otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) )
            // InternalSasDsl.g:1877:2: (otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            {
            // InternalSasDsl.g:1877:2: (otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            // InternalSasDsl.g:1878:3: otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLRuleMOAccess().getSensorKeyword_0());
            		
            // InternalSasDsl.g:1882:3: ( (otherlv_1= RULE_ID ) )
            // InternalSasDsl.g:1883:4: (otherlv_1= RULE_ID )
            {
            // InternalSasDsl.g:1883:4: (otherlv_1= RULE_ID )
            // InternalSasDsl.g:1884:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleMORule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(otherlv_1, grammarAccess.getDSLRuleMOAccess().getSensorDSLSensorCrossReference_1_0());
            				

            }


            }

            // InternalSasDsl.g:1895:3: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
            // InternalSasDsl.g:1896:4: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
            {
            // InternalSasDsl.g:1896:4: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
            // InternalSasDsl.g:1897:5: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
            {
            // InternalSasDsl.g:1897:5: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
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
                    // InternalSasDsl.g:1898:6: lv_access_2_1= 'must-use'
                    {
                    lv_access_2_1=(Token)match(input,16,FOLLOW_23); 

                    						newLeafNode(lv_access_2_1, grammarAccess.getDSLRuleMOAccess().getAccessMustUseKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMORule());
                    						}
                    						setWithLastConsumed(current, "access", lv_access_2_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:1909:6: lv_access_2_2= 'must-not-use'
                    {
                    lv_access_2_2=(Token)match(input,17,FOLLOW_23); 

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
            		
            // InternalSasDsl.g:1926:3: ( (otherlv_4= RULE_ID ) )
            // InternalSasDsl.g:1927:4: (otherlv_4= RULE_ID )
            {
            // InternalSasDsl.g:1927:4: (otherlv_4= RULE_ID )
            // InternalSasDsl.g:1928:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleMORule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

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
    // InternalSasDsl.g:1947:1: entryRuleDSLManaging returns [EObject current=null] : iv_ruleDSLManaging= ruleDSLManaging EOF ;
    public final EObject entryRuleDSLManaging() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLManaging = null;


        try {
            // InternalSasDsl.g:1947:52: (iv_ruleDSLManaging= ruleDSLManaging EOF )
            // InternalSasDsl.g:1948:2: iv_ruleDSLManaging= ruleDSLManaging EOF
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
    // InternalSasDsl.g:1954:1: ruleDSLManaging returns [EObject current=null] : (otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )* otherlv_5= '}' ) ;
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
            // InternalSasDsl.g:1960:2: ( (otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )* otherlv_5= '}' ) )
            // InternalSasDsl.g:1961:2: (otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )* otherlv_5= '}' )
            {
            // InternalSasDsl.g:1961:2: (otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )* otherlv_5= '}' )
            // InternalSasDsl.g:1962:3: otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLManagingAccess().getManagingKeyword_0());
            		
            // InternalSasDsl.g:1966:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:1967:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:1967:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:1968:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,12,FOLLOW_24); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLManagingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalSasDsl.g:1988:3: ( (lv_managerController_3_0= ruleDSLManagerController ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==32) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalSasDsl.g:1989:4: (lv_managerController_3_0= ruleDSLManagerController )
            	    {
            	    // InternalSasDsl.g:1989:4: (lv_managerController_3_0= ruleDSLManagerController )
            	    // InternalSasDsl.g:1990:5: lv_managerController_3_0= ruleDSLManagerController
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagingAccess().getManagerControllerDSLManagerControllerParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_24);
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
            	    break loop32;
                }
            } while (true);

            // InternalSasDsl.g:2007:3: ( (lv_controller_4_0= ruleDSLController ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==33) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalSasDsl.g:2008:4: (lv_controller_4_0= ruleDSLController )
            	    {
            	    // InternalSasDsl.g:2008:4: (lv_controller_4_0= ruleDSLController )
            	    // InternalSasDsl.g:2009:5: lv_controller_4_0= ruleDSLController
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagingAccess().getControllerDSLControllerParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_25);
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
            	    break loop33;
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
    // InternalSasDsl.g:2034:1: entryRuleDSLManaged returns [EObject current=null] : iv_ruleDSLManaged= ruleDSLManaged EOF ;
    public final EObject entryRuleDSLManaged() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLManaged = null;


        try {
            // InternalSasDsl.g:2034:51: (iv_ruleDSLManaged= ruleDSLManaged EOF )
            // InternalSasDsl.g:2035:2: iv_ruleDSLManaged= ruleDSLManaged EOF
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
    // InternalSasDsl.g:2041:1: ruleDSLManaged returns [EObject current=null] : (otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )* ( (lv_effector_4_0= ruleDSLEffector ) )* ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )* otherlv_6= '}' ) ;
    public final EObject ruleDSLManaged() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_sensor_3_0 = null;

        EObject lv_effector_4_0 = null;

        EObject lv_measuredOutput_5_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:2047:2: ( (otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )* ( (lv_effector_4_0= ruleDSLEffector ) )* ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )* otherlv_6= '}' ) )
            // InternalSasDsl.g:2048:2: (otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )* ( (lv_effector_4_0= ruleDSLEffector ) )* ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )* otherlv_6= '}' )
            {
            // InternalSasDsl.g:2048:2: (otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )* ( (lv_effector_4_0= ruleDSLEffector ) )* ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )* otherlv_6= '}' )
            // InternalSasDsl.g:2049:3: otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )* ( (lv_effector_4_0= ruleDSLEffector ) )* ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLManagedAccess().getManagedKeyword_0());
            		
            // InternalSasDsl.g:2053:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2054:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2054:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2055:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,12,FOLLOW_26); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLManagedAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalSasDsl.g:2075:3: ( (lv_sensor_3_0= ruleDSLSensor ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==40) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalSasDsl.g:2076:4: (lv_sensor_3_0= ruleDSLSensor )
            	    {
            	    // InternalSasDsl.g:2076:4: (lv_sensor_3_0= ruleDSLSensor )
            	    // InternalSasDsl.g:2077:5: lv_sensor_3_0= ruleDSLSensor
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagedAccess().getSensorDSLSensorParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_26);
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
            	    break loop34;
                }
            } while (true);

            // InternalSasDsl.g:2094:3: ( (lv_effector_4_0= ruleDSLEffector ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==41) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalSasDsl.g:2095:4: (lv_effector_4_0= ruleDSLEffector )
            	    {
            	    // InternalSasDsl.g:2095:4: (lv_effector_4_0= ruleDSLEffector )
            	    // InternalSasDsl.g:2096:5: lv_effector_4_0= ruleDSLEffector
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagedAccess().getEffectorDSLEffectorParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_27);
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
            	    break loop35;
                }
            } while (true);

            // InternalSasDsl.g:2113:3: ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==43) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalSasDsl.g:2114:4: (lv_measuredOutput_5_0= ruleDSLMeasuredOutput )
            	    {
            	    // InternalSasDsl.g:2114:4: (lv_measuredOutput_5_0= ruleDSLMeasuredOutput )
            	    // InternalSasDsl.g:2115:5: lv_measuredOutput_5_0= ruleDSLMeasuredOutput
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagedAccess().getMeasuredOutputDSLMeasuredOutputParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_28);
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
            	    break loop36;
                }
            } while (true);

            otherlv_6=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getDSLManagedAccess().getRightCurlyBracketKeyword_6());
            		

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
    // InternalSasDsl.g:2140:1: entryRuleDSLManagerController returns [EObject current=null] : iv_ruleDSLManagerController= ruleDSLManagerController EOF ;
    public final EObject entryRuleDSLManagerController() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLManagerController = null;


        try {
            // InternalSasDsl.g:2140:61: (iv_ruleDSLManagerController= ruleDSLManagerController EOF )
            // InternalSasDsl.g:2141:2: iv_ruleDSLManagerController= ruleDSLManagerController EOF
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
    // InternalSasDsl.g:2147:1: ruleDSLManagerController returns [EObject current=null] : (otherlv_0= 'LoopManager' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_controller_3_0= ruleDSLController ) )+ otherlv_4= '}' ) ;
    public final EObject ruleDSLManagerController() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_controller_3_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:2153:2: ( (otherlv_0= 'LoopManager' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_controller_3_0= ruleDSLController ) )+ otherlv_4= '}' ) )
            // InternalSasDsl.g:2154:2: (otherlv_0= 'LoopManager' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_controller_3_0= ruleDSLController ) )+ otherlv_4= '}' )
            {
            // InternalSasDsl.g:2154:2: (otherlv_0= 'LoopManager' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_controller_3_0= ruleDSLController ) )+ otherlv_4= '}' )
            // InternalSasDsl.g:2155:3: otherlv_0= 'LoopManager' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_controller_3_0= ruleDSLController ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLManagerControllerAccess().getLoopManagerKeyword_0());
            		
            // InternalSasDsl.g:2159:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2160:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2160:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2161:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,12,FOLLOW_29); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLManagerControllerAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalSasDsl.g:2181:3: ( (lv_controller_3_0= ruleDSLController ) )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==33) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalSasDsl.g:2182:4: (lv_controller_3_0= ruleDSLController )
            	    {
            	    // InternalSasDsl.g:2182:4: (lv_controller_3_0= ruleDSLController )
            	    // InternalSasDsl.g:2183:5: lv_controller_3_0= ruleDSLController
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagerControllerAccess().getControllerDSLControllerParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_25);
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
            	    if ( cnt37 >= 1 ) break loop37;
                        EarlyExitException eee =
                            new EarlyExitException(37, input);
                        throw eee;
                }
                cnt37++;
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
    // InternalSasDsl.g:2208:1: entryRuleDSLController returns [EObject current=null] : iv_ruleDSLController= ruleDSLController EOF ;
    public final EObject entryRuleDSLController() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLController = null;


        try {
            // InternalSasDsl.g:2208:54: (iv_ruleDSLController= ruleDSLController EOF )
            // InternalSasDsl.g:2209:2: iv_ruleDSLController= ruleDSLController EOF
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
    // InternalSasDsl.g:2215:1: ruleDSLController returns [EObject current=null] : (otherlv_0= 'Loop' ( (lv_name_1_0= RULE_ID ) ) ( (lv_domain_2_0= ruleDSLDomainRule ) )? otherlv_3= '{' ( (lv_monitor_4_0= ruleDSLMonitor ) )+ ( (lv_analyzer_5_0= ruleDSLAnalyzer ) )+ ( (lv_planner_6_0= ruleDSLPlanner ) )* ( (lv_executor_7_0= ruleDSLExecutor ) )+ ( (lv_knowledge_8_0= ruleDSLKnowledge ) )* otherlv_9= '}' ) ;
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
            // InternalSasDsl.g:2221:2: ( (otherlv_0= 'Loop' ( (lv_name_1_0= RULE_ID ) ) ( (lv_domain_2_0= ruleDSLDomainRule ) )? otherlv_3= '{' ( (lv_monitor_4_0= ruleDSLMonitor ) )+ ( (lv_analyzer_5_0= ruleDSLAnalyzer ) )+ ( (lv_planner_6_0= ruleDSLPlanner ) )* ( (lv_executor_7_0= ruleDSLExecutor ) )+ ( (lv_knowledge_8_0= ruleDSLKnowledge ) )* otherlv_9= '}' ) )
            // InternalSasDsl.g:2222:2: (otherlv_0= 'Loop' ( (lv_name_1_0= RULE_ID ) ) ( (lv_domain_2_0= ruleDSLDomainRule ) )? otherlv_3= '{' ( (lv_monitor_4_0= ruleDSLMonitor ) )+ ( (lv_analyzer_5_0= ruleDSLAnalyzer ) )+ ( (lv_planner_6_0= ruleDSLPlanner ) )* ( (lv_executor_7_0= ruleDSLExecutor ) )+ ( (lv_knowledge_8_0= ruleDSLKnowledge ) )* otherlv_9= '}' )
            {
            // InternalSasDsl.g:2222:2: (otherlv_0= 'Loop' ( (lv_name_1_0= RULE_ID ) ) ( (lv_domain_2_0= ruleDSLDomainRule ) )? otherlv_3= '{' ( (lv_monitor_4_0= ruleDSLMonitor ) )+ ( (lv_analyzer_5_0= ruleDSLAnalyzer ) )+ ( (lv_planner_6_0= ruleDSLPlanner ) )* ( (lv_executor_7_0= ruleDSLExecutor ) )+ ( (lv_knowledge_8_0= ruleDSLKnowledge ) )* otherlv_9= '}' )
            // InternalSasDsl.g:2223:3: otherlv_0= 'Loop' ( (lv_name_1_0= RULE_ID ) ) ( (lv_domain_2_0= ruleDSLDomainRule ) )? otherlv_3= '{' ( (lv_monitor_4_0= ruleDSLMonitor ) )+ ( (lv_analyzer_5_0= ruleDSLAnalyzer ) )+ ( (lv_planner_6_0= ruleDSLPlanner ) )* ( (lv_executor_7_0= ruleDSLExecutor ) )+ ( (lv_knowledge_8_0= ruleDSLKnowledge ) )* otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLControllerAccess().getLoopKeyword_0());
            		
            // InternalSasDsl.g:2227:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2228:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2228:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2229:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_30); 

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

            // InternalSasDsl.g:2245:3: ( (lv_domain_2_0= ruleDSLDomainRule ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID||LA38_0==34) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalSasDsl.g:2246:4: (lv_domain_2_0= ruleDSLDomainRule )
                    {
                    // InternalSasDsl.g:2246:4: (lv_domain_2_0= ruleDSLDomainRule )
                    // InternalSasDsl.g:2247:5: lv_domain_2_0= ruleDSLDomainRule
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

            otherlv_3=(Token)match(input,12,FOLLOW_31); 

            			newLeafNode(otherlv_3, grammarAccess.getDSLControllerAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalSasDsl.g:2268:3: ( (lv_monitor_4_0= ruleDSLMonitor ) )+
            int cnt39=0;
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==35) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalSasDsl.g:2269:4: (lv_monitor_4_0= ruleDSLMonitor )
            	    {
            	    // InternalSasDsl.g:2269:4: (lv_monitor_4_0= ruleDSLMonitor )
            	    // InternalSasDsl.g:2270:5: lv_monitor_4_0= ruleDSLMonitor
            	    {

            	    					newCompositeNode(grammarAccess.getDSLControllerAccess().getMonitorDSLMonitorParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_32);
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
            	    if ( cnt39 >= 1 ) break loop39;
                        EarlyExitException eee =
                            new EarlyExitException(39, input);
                        throw eee;
                }
                cnt39++;
            } while (true);

            // InternalSasDsl.g:2287:3: ( (lv_analyzer_5_0= ruleDSLAnalyzer ) )+
            int cnt40=0;
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==36) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalSasDsl.g:2288:4: (lv_analyzer_5_0= ruleDSLAnalyzer )
            	    {
            	    // InternalSasDsl.g:2288:4: (lv_analyzer_5_0= ruleDSLAnalyzer )
            	    // InternalSasDsl.g:2289:5: lv_analyzer_5_0= ruleDSLAnalyzer
            	    {

            	    					newCompositeNode(grammarAccess.getDSLControllerAccess().getAnalyzerDSLAnalyzerParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_33);
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
            	    if ( cnt40 >= 1 ) break loop40;
                        EarlyExitException eee =
                            new EarlyExitException(40, input);
                        throw eee;
                }
                cnt40++;
            } while (true);

            // InternalSasDsl.g:2306:3: ( (lv_planner_6_0= ruleDSLPlanner ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==37) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalSasDsl.g:2307:4: (lv_planner_6_0= ruleDSLPlanner )
            	    {
            	    // InternalSasDsl.g:2307:4: (lv_planner_6_0= ruleDSLPlanner )
            	    // InternalSasDsl.g:2308:5: lv_planner_6_0= ruleDSLPlanner
            	    {

            	    					newCompositeNode(grammarAccess.getDSLControllerAccess().getPlannerDSLPlannerParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_34);
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
            	    break loop41;
                }
            } while (true);

            // InternalSasDsl.g:2325:3: ( (lv_executor_7_0= ruleDSLExecutor ) )+
            int cnt42=0;
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==38) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalSasDsl.g:2326:4: (lv_executor_7_0= ruleDSLExecutor )
            	    {
            	    // InternalSasDsl.g:2326:4: (lv_executor_7_0= ruleDSLExecutor )
            	    // InternalSasDsl.g:2327:5: lv_executor_7_0= ruleDSLExecutor
            	    {

            	    					newCompositeNode(grammarAccess.getDSLControllerAccess().getExecutorDSLExecutorParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_35);
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
            	    if ( cnt42 >= 1 ) break loop42;
                        EarlyExitException eee =
                            new EarlyExitException(42, input);
                        throw eee;
                }
                cnt42++;
            } while (true);

            // InternalSasDsl.g:2344:3: ( (lv_knowledge_8_0= ruleDSLKnowledge ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==39) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalSasDsl.g:2345:4: (lv_knowledge_8_0= ruleDSLKnowledge )
            	    {
            	    // InternalSasDsl.g:2345:4: (lv_knowledge_8_0= ruleDSLKnowledge )
            	    // InternalSasDsl.g:2346:5: lv_knowledge_8_0= ruleDSLKnowledge
            	    {

            	    					newCompositeNode(grammarAccess.getDSLControllerAccess().getKnowledgeDSLKnowledgeParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_36);
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
            	    break loop43;
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
    // InternalSasDsl.g:2371:1: entryRuleDSLDomainRule returns [EObject current=null] : iv_ruleDSLDomainRule= ruleDSLDomainRule EOF ;
    public final EObject entryRuleDSLDomainRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLDomainRule = null;


        try {
            // InternalSasDsl.g:2371:54: (iv_ruleDSLDomainRule= ruleDSLDomainRule EOF )
            // InternalSasDsl.g:2372:2: iv_ruleDSLDomainRule= ruleDSLDomainRule EOF
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
    // InternalSasDsl.g:2378:1: ruleDSLDomainRule returns [EObject current=null] : ( ( (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' ) ) ) ;
    public final EObject ruleDSLDomainRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_1=null;
        Token lv_value_0_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2384:2: ( ( ( (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' ) ) ) )
            // InternalSasDsl.g:2385:2: ( ( (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' ) ) )
            {
            // InternalSasDsl.g:2385:2: ( ( (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' ) ) )
            // InternalSasDsl.g:2386:3: ( (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' ) )
            {
            // InternalSasDsl.g:2386:3: ( (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' ) )
            // InternalSasDsl.g:2387:4: (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' )
            {
            // InternalSasDsl.g:2387:4: (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID) ) {
                alt44=1;
            }
            else if ( (LA44_0==34) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // InternalSasDsl.g:2388:5: lv_value_0_1= RULE_ID
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
                    // InternalSasDsl.g:2403:5: lv_value_0_2= 'withDomainRules'
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
    // InternalSasDsl.g:2419:1: entryRuleDSLMonitor returns [EObject current=null] : iv_ruleDSLMonitor= ruleDSLMonitor EOF ;
    public final EObject entryRuleDSLMonitor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLMonitor = null;


        try {
            // InternalSasDsl.g:2419:51: (iv_ruleDSLMonitor= ruleDSLMonitor EOF )
            // InternalSasDsl.g:2420:2: iv_ruleDSLMonitor= ruleDSLMonitor EOF
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
    // InternalSasDsl.g:2426:1: ruleDSLMonitor returns [EObject current=null] : (otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLMonitor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2432:2: ( (otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2433:2: (otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2433:2: (otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2434:3: otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLMonitorAccess().getMonitorKeyword_0());
            		
            // InternalSasDsl.g:2438:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2439:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2439:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2440:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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
    // InternalSasDsl.g:2464:1: entryRuleDSLAnalyzer returns [EObject current=null] : iv_ruleDSLAnalyzer= ruleDSLAnalyzer EOF ;
    public final EObject entryRuleDSLAnalyzer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLAnalyzer = null;


        try {
            // InternalSasDsl.g:2464:52: (iv_ruleDSLAnalyzer= ruleDSLAnalyzer EOF )
            // InternalSasDsl.g:2465:2: iv_ruleDSLAnalyzer= ruleDSLAnalyzer EOF
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
    // InternalSasDsl.g:2471:1: ruleDSLAnalyzer returns [EObject current=null] : (otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLAnalyzer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2477:2: ( (otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2478:2: (otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2478:2: (otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2479:3: otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLAnalyzerAccess().getAnalyzerKeyword_0());
            		
            // InternalSasDsl.g:2483:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2484:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2484:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2485:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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
    // InternalSasDsl.g:2509:1: entryRuleDSLPlanner returns [EObject current=null] : iv_ruleDSLPlanner= ruleDSLPlanner EOF ;
    public final EObject entryRuleDSLPlanner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLPlanner = null;


        try {
            // InternalSasDsl.g:2509:51: (iv_ruleDSLPlanner= ruleDSLPlanner EOF )
            // InternalSasDsl.g:2510:2: iv_ruleDSLPlanner= ruleDSLPlanner EOF
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
    // InternalSasDsl.g:2516:1: ruleDSLPlanner returns [EObject current=null] : (otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLPlanner() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2522:2: ( (otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2523:2: (otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2523:2: (otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2524:3: otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLPlannerAccess().getPlannerKeyword_0());
            		
            // InternalSasDsl.g:2528:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2529:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2529:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2530:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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
    // InternalSasDsl.g:2554:1: entryRuleDSLExecutor returns [EObject current=null] : iv_ruleDSLExecutor= ruleDSLExecutor EOF ;
    public final EObject entryRuleDSLExecutor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLExecutor = null;


        try {
            // InternalSasDsl.g:2554:52: (iv_ruleDSLExecutor= ruleDSLExecutor EOF )
            // InternalSasDsl.g:2555:2: iv_ruleDSLExecutor= ruleDSLExecutor EOF
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
    // InternalSasDsl.g:2561:1: ruleDSLExecutor returns [EObject current=null] : (otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLExecutor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2567:2: ( (otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2568:2: (otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2568:2: (otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2569:3: otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLExecutorAccess().getExecutorKeyword_0());
            		
            // InternalSasDsl.g:2573:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2574:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2574:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2575:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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
    // InternalSasDsl.g:2599:1: entryRuleDSLKnowledge returns [EObject current=null] : iv_ruleDSLKnowledge= ruleDSLKnowledge EOF ;
    public final EObject entryRuleDSLKnowledge() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLKnowledge = null;


        try {
            // InternalSasDsl.g:2599:53: (iv_ruleDSLKnowledge= ruleDSLKnowledge EOF )
            // InternalSasDsl.g:2600:2: iv_ruleDSLKnowledge= ruleDSLKnowledge EOF
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
    // InternalSasDsl.g:2606:1: ruleDSLKnowledge returns [EObject current=null] : (otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )* ( (lv_shalt_4_0= ruleDSLAlternative ) )* otherlv_5= '}' ) ;
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
            // InternalSasDsl.g:2612:2: ( (otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )* ( (lv_shalt_4_0= ruleDSLAlternative ) )* otherlv_5= '}' ) )
            // InternalSasDsl.g:2613:2: (otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )* ( (lv_shalt_4_0= ruleDSLAlternative ) )* otherlv_5= '}' )
            {
            // InternalSasDsl.g:2613:2: (otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )* ( (lv_shalt_4_0= ruleDSLAlternative ) )* otherlv_5= '}' )
            // InternalSasDsl.g:2614:3: otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )* ( (lv_shalt_4_0= ruleDSLAlternative ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLKnowledgeAccess().getKnowledgeKeyword_0());
            		
            // InternalSasDsl.g:2618:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2619:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2619:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2620:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,12,FOLLOW_37); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLKnowledgeAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalSasDsl.g:2640:3: ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==42) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalSasDsl.g:2641:4: (lv_referenceInput_3_0= ruleDSLReferenceInput )
            	    {
            	    // InternalSasDsl.g:2641:4: (lv_referenceInput_3_0= ruleDSLReferenceInput )
            	    // InternalSasDsl.g:2642:5: lv_referenceInput_3_0= ruleDSLReferenceInput
            	    {

            	    					newCompositeNode(grammarAccess.getDSLKnowledgeAccess().getReferenceInputDSLReferenceInputParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_37);
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
            	    break loop45;
                }
            } while (true);

            // InternalSasDsl.g:2659:3: ( (lv_shalt_4_0= ruleDSLAlternative ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==44) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalSasDsl.g:2660:4: (lv_shalt_4_0= ruleDSLAlternative )
            	    {
            	    // InternalSasDsl.g:2660:4: (lv_shalt_4_0= ruleDSLAlternative )
            	    // InternalSasDsl.g:2661:5: lv_shalt_4_0= ruleDSLAlternative
            	    {

            	    					newCompositeNode(grammarAccess.getDSLKnowledgeAccess().getShaltDSLAlternativeParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_38);
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
            	    break loop46;
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
    // InternalSasDsl.g:2686:1: entryRuleDSLSensor returns [EObject current=null] : iv_ruleDSLSensor= ruleDSLSensor EOF ;
    public final EObject entryRuleDSLSensor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLSensor = null;


        try {
            // InternalSasDsl.g:2686:50: (iv_ruleDSLSensor= ruleDSLSensor EOF )
            // InternalSasDsl.g:2687:2: iv_ruleDSLSensor= ruleDSLSensor EOF
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
    // InternalSasDsl.g:2693:1: ruleDSLSensor returns [EObject current=null] : (otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLSensor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2699:2: ( (otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2700:2: (otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2700:2: (otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2701:3: otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLSensorAccess().getSensorKeyword_0());
            		
            // InternalSasDsl.g:2705:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2706:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2706:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2707:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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
    // InternalSasDsl.g:2731:1: entryRuleDSLEffector returns [EObject current=null] : iv_ruleDSLEffector= ruleDSLEffector EOF ;
    public final EObject entryRuleDSLEffector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLEffector = null;


        try {
            // InternalSasDsl.g:2731:52: (iv_ruleDSLEffector= ruleDSLEffector EOF )
            // InternalSasDsl.g:2732:2: iv_ruleDSLEffector= ruleDSLEffector EOF
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
    // InternalSasDsl.g:2738:1: ruleDSLEffector returns [EObject current=null] : (otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLEffector() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2744:2: ( (otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2745:2: (otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2745:2: (otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2746:3: otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLEffectorAccess().getEffectorKeyword_0());
            		
            // InternalSasDsl.g:2750:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2751:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2751:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2752:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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
    // InternalSasDsl.g:2776:1: entryRuleDSLReferenceInput returns [EObject current=null] : iv_ruleDSLReferenceInput= ruleDSLReferenceInput EOF ;
    public final EObject entryRuleDSLReferenceInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLReferenceInput = null;


        try {
            // InternalSasDsl.g:2776:58: (iv_ruleDSLReferenceInput= ruleDSLReferenceInput EOF )
            // InternalSasDsl.g:2777:2: iv_ruleDSLReferenceInput= ruleDSLReferenceInput EOF
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
    // InternalSasDsl.g:2783:1: ruleDSLReferenceInput returns [EObject current=null] : (otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLReferenceInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2789:2: ( (otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2790:2: (otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2790:2: (otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2791:3: otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLReferenceInputAccess().getReferenceInputKeyword_0());
            		
            // InternalSasDsl.g:2795:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2796:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2796:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2797:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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
    // InternalSasDsl.g:2821:1: entryRuleDSLMeasuredOutput returns [EObject current=null] : iv_ruleDSLMeasuredOutput= ruleDSLMeasuredOutput EOF ;
    public final EObject entryRuleDSLMeasuredOutput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLMeasuredOutput = null;


        try {
            // InternalSasDsl.g:2821:58: (iv_ruleDSLMeasuredOutput= ruleDSLMeasuredOutput EOF )
            // InternalSasDsl.g:2822:2: iv_ruleDSLMeasuredOutput= ruleDSLMeasuredOutput EOF
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
    // InternalSasDsl.g:2828:1: ruleDSLMeasuredOutput returns [EObject current=null] : (otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLMeasuredOutput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2834:2: ( (otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2835:2: (otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2835:2: (otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2836:3: otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLMeasuredOutputAccess().getMeasuredOutputKeyword_0());
            		
            // InternalSasDsl.g:2840:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2841:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2841:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2842:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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
    // InternalSasDsl.g:2866:1: entryRuleDSLAlternative returns [EObject current=null] : iv_ruleDSLAlternative= ruleDSLAlternative EOF ;
    public final EObject entryRuleDSLAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLAlternative = null;


        try {
            // InternalSasDsl.g:2866:55: (iv_ruleDSLAlternative= ruleDSLAlternative EOF )
            // InternalSasDsl.g:2867:2: iv_ruleDSLAlternative= ruleDSLAlternative EOF
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
    // InternalSasDsl.g:2873:1: ruleDSLAlternative returns [EObject current=null] : (otherlv_0= 'Alternative' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLAlternative() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2879:2: ( (otherlv_0= 'Alternative' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2880:2: (otherlv_0= 'Alternative' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2880:2: (otherlv_0= 'Alternative' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2881:3: otherlv_0= 'Alternative' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLAlternativeAccess().getAlternativeKeyword_0());
            		
            // InternalSasDsl.g:2885:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2886:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2886:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2887:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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

    // Delegated rules


    protected DFA19 dfa19 = new DFA19(this);
    protected DFA25 dfa25 = new DFA25(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\1\27\1\4\1\20\2\24\7\uffff";
    static final String dfa_3s = "\1\27\1\4\1\21\2\33\7\uffff";
    static final String dfa_4s = "\5\uffff\1\7\1\6\1\5\1\4\1\3\1\2\1\1";
    static final String dfa_5s = "\14\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\2",
            "\1\3\1\4",
            "\1\12\1\uffff\1\13\1\7\1\11\1\10\1\6\1\5",
            "\1\12\1\uffff\1\13\1\7\1\11\1\10\1\6\1\5",
            "",
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

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "735:2: ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'analyzer' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) | (otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'executor' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';' ) )";
        }
    }
    static final String dfa_7s = "\12\uffff";
    static final String dfa_8s = "\1\30\1\4\1\20\2\26\5\uffff";
    static final String dfa_9s = "\1\30\1\4\1\21\2\33\5\uffff";
    static final String dfa_10s = "\5\uffff\1\5\1\4\1\3\1\2\1\1";
    static final String dfa_11s = "\12\uffff}>";
    static final String[] dfa_12s = {
            "\1\1",
            "\1\2",
            "\1\3\1\4",
            "\1\11\1\10\1\6\1\uffff\1\5\1\7",
            "\1\11\1\10\1\6\1\uffff\1\5\1\7",
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

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "1229:2: ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'planner' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'alternative' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) )";
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
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000009B8A000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000300002000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000200002000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00000B0000002000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x00000A0000002000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000080000002000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000400001010L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000007000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000006000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x000000E000002000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000008000002000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000140000002000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000100000002000L});

}