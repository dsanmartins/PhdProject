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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Architecture'", "'{'", "'}'", "'Rules'", "'mcontroller'", "';'", "'controller'", "'monitor'", "'sensor'", "'knowledge'", "'analyzer'", "'planner'", "'reference-input'", "'executor'", "'effector'", "'measured-output'", "'can-access'", "'cannot-access'", "'Managing'", "'Managed'", "'ManagerController'", "'typeOf'", "'Synchronized'", "'Coordinated'", "'Independent'", "'Controller'", "'Monitor'", "'Analyzer'", "'Planner'", "'Executor'", "'Knowledge'", "'Sensor'", "'Effector'", "'ReferenceInput'", "'MeasuredOutput'"
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
    public static final int T__45=45;
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

                if ( (LA1_0==29) ) {
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

                if ( (LA2_0==30) ) {
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

                if ( (LA3_0==15||(LA3_0>=17 && LA3_0<=19)||(LA3_0>=21 && LA3_0<=22)||LA3_0==24) ) {
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
            case 17:
                {
                alt4=1;
                }
                break;
            case 18:
                {
                alt4=2;
                }
                break;
            case 21:
                {
                alt4=3;
                }
                break;
            case 22:
                {
                alt4=4;
                }
                break;
            case 24:
                {
                alt4=5;
                }
                break;
            case 19:
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
    // InternalSasDsl.g:270:1: ruleDSLRuleMController returns [EObject current=null] : (otherlv_0= 'mcontroller' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'mcontroller' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) ;
    public final EObject ruleDSLRuleMController() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_access_2_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:276:2: ( (otherlv_0= 'mcontroller' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'mcontroller' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) )
            // InternalSasDsl.g:277:2: (otherlv_0= 'mcontroller' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'mcontroller' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            {
            // InternalSasDsl.g:277:2: (otherlv_0= 'mcontroller' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'mcontroller' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            // InternalSasDsl.g:278:3: otherlv_0= 'mcontroller' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'mcontroller' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLRuleMControllerAccess().getMcontrollerKeyword_0());
            		
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

            // InternalSasDsl.g:295:3: ( (lv_access_2_0= ruleDSLAccess ) )
            // InternalSasDsl.g:296:4: (lv_access_2_0= ruleDSLAccess )
            {
            // InternalSasDsl.g:296:4: (lv_access_2_0= ruleDSLAccess )
            // InternalSasDsl.g:297:5: lv_access_2_0= ruleDSLAccess
            {

            					newCompositeNode(grammarAccess.getDSLRuleMControllerAccess().getAccessDSLAccessParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_11);
            lv_access_2_0=ruleDSLAccess();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSLRuleMControllerRule());
            					}
            					set(
            						current,
            						"access",
            						lv_access_2_0,
            						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getDSLRuleMControllerAccess().getMcontrollerKeyword_3());
            		
            // InternalSasDsl.g:318:3: ( (otherlv_4= RULE_ID ) )
            // InternalSasDsl.g:319:4: (otherlv_4= RULE_ID )
            {
            // InternalSasDsl.g:319:4: (otherlv_4= RULE_ID )
            // InternalSasDsl.g:320:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleMControllerRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_4, grammarAccess.getDSLRuleMControllerAccess().getMcontroller2DSLManagerControllerCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,16,FOLLOW_2); 

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
    // InternalSasDsl.g:339:1: entryRuleDSLRuleController returns [EObject current=null] : iv_ruleDSLRuleController= ruleDSLRuleController EOF ;
    public final EObject entryRuleDSLRuleController() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleController = null;


        try {
            // InternalSasDsl.g:339:58: (iv_ruleDSLRuleController= ruleDSLRuleController EOF )
            // InternalSasDsl.g:340:2: iv_ruleDSLRuleController= ruleDSLRuleController EOF
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
    // InternalSasDsl.g:346:1: ruleDSLRuleController returns [EObject current=null] : (otherlv_0= 'controller' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'controller' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) ;
    public final EObject ruleDSLRuleController() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_access_2_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:352:2: ( (otherlv_0= 'controller' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'controller' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) )
            // InternalSasDsl.g:353:2: (otherlv_0= 'controller' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'controller' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            {
            // InternalSasDsl.g:353:2: (otherlv_0= 'controller' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'controller' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            // InternalSasDsl.g:354:3: otherlv_0= 'controller' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'controller' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLRuleControllerAccess().getControllerKeyword_0());
            		
            // InternalSasDsl.g:358:3: ( (otherlv_1= RULE_ID ) )
            // InternalSasDsl.g:359:4: (otherlv_1= RULE_ID )
            {
            // InternalSasDsl.g:359:4: (otherlv_1= RULE_ID )
            // InternalSasDsl.g:360:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleControllerRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(otherlv_1, grammarAccess.getDSLRuleControllerAccess().getController1DSLControllerCrossReference_1_0());
            				

            }


            }

            // InternalSasDsl.g:371:3: ( (lv_access_2_0= ruleDSLAccess ) )
            // InternalSasDsl.g:372:4: (lv_access_2_0= ruleDSLAccess )
            {
            // InternalSasDsl.g:372:4: (lv_access_2_0= ruleDSLAccess )
            // InternalSasDsl.g:373:5: lv_access_2_0= ruleDSLAccess
            {

            					newCompositeNode(grammarAccess.getDSLRuleControllerAccess().getAccessDSLAccessParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_13);
            lv_access_2_0=ruleDSLAccess();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSLRuleControllerRule());
            					}
            					set(
            						current,
            						"access",
            						lv_access_2_0,
            						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getDSLRuleControllerAccess().getControllerKeyword_3());
            		
            // InternalSasDsl.g:394:3: ( (otherlv_4= RULE_ID ) )
            // InternalSasDsl.g:395:4: (otherlv_4= RULE_ID )
            {
            // InternalSasDsl.g:395:4: (otherlv_4= RULE_ID )
            // InternalSasDsl.g:396:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleControllerRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_4, grammarAccess.getDSLRuleControllerAccess().getController2DSLControllerCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,16,FOLLOW_2); 

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
    // InternalSasDsl.g:415:1: entryRuleDSLRuleMonitor returns [EObject current=null] : iv_ruleDSLRuleMonitor= ruleDSLRuleMonitor EOF ;
    public final EObject entryRuleDSLRuleMonitor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleMonitor = null;


        try {
            // InternalSasDsl.g:415:55: (iv_ruleDSLRuleMonitor= ruleDSLRuleMonitor EOF )
            // InternalSasDsl.g:416:2: iv_ruleDSLRuleMonitor= ruleDSLRuleMonitor EOF
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
    // InternalSasDsl.g:422:1: ruleDSLRuleMonitor returns [EObject current=null] : ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'sensor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'knowledge' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'analyzer' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'monitor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) ) ;
    public final EObject ruleDSLRuleMonitor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        AntlrDatatypeRuleToken lv_access_2_0 = null;

        AntlrDatatypeRuleToken lv_access_8_0 = null;

        AntlrDatatypeRuleToken lv_access_14_0 = null;

        AntlrDatatypeRuleToken lv_access_20_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:428:2: ( ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'sensor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'knowledge' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'analyzer' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'monitor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) ) )
            // InternalSasDsl.g:429:2: ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'sensor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'knowledge' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'analyzer' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'monitor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) )
            {
            // InternalSasDsl.g:429:2: ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'sensor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'knowledge' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'analyzer' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'monitor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) )
            int alt5=4;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==RULE_ID) ) {
                    int LA5_2 = input.LA(3);

                    if ( (LA5_2==27) ) {
                        switch ( input.LA(4) ) {
                        case 18:
                            {
                            alt5=4;
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
                        case 19:
                            {
                            alt5=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 3, input);

                            throw nvae;
                        }

                    }
                    else if ( (LA5_2==28) ) {
                        switch ( input.LA(4) ) {
                        case 18:
                            {
                            alt5=4;
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
                        case 19:
                            {
                            alt5=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 4, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalSasDsl.g:430:3: (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'sensor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:430:3: (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'sensor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:431:4: otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'sensor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,18,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_0_0());
                    			
                    // InternalSasDsl.g:435:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:436:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:436:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:437:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:448:4: ( (lv_access_2_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:449:5: (lv_access_2_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:449:5: (lv_access_2_0= ruleDSLAccess )
                    // InternalSasDsl.g:450:6: lv_access_2_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleMonitorAccess().getAccessDSLAccessParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_access_2_0=ruleDSLAccess();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    						set(
                    							current,
                    							"access",
                    							lv_access_2_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,19,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDSLRuleMonitorAccess().getSensorKeyword_0_3());
                    			
                    // InternalSasDsl.g:471:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:472:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:472:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:473:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRuleMonitorAccess().getSensorDSLSensorCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRuleMonitorAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:490:3: (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'knowledge' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:490:3: (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'knowledge' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:491:4: otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'knowledge' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,18,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_1_0());
                    			
                    // InternalSasDsl.g:495:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:496:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:496:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:497:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:508:4: ( (lv_access_8_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:509:5: (lv_access_8_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:509:5: (lv_access_8_0= ruleDSLAccess )
                    // InternalSasDsl.g:510:6: lv_access_8_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleMonitorAccess().getAccessDSLAccessParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_access_8_0=ruleDSLAccess();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    						set(
                    							current,
                    							"access",
                    							lv_access_8_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getDSLRuleMonitorAccess().getKnowledgeKeyword_1_3());
                    			
                    // InternalSasDsl.g:531:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:532:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:532:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:533:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRuleMonitorAccess().getKnowledgeDSLKnowledgeCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRuleMonitorAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:550:3: (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'analyzer' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:550:3: (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'analyzer' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:551:4: otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'analyzer' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,18,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_2_0());
                    			
                    // InternalSasDsl.g:555:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:556:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:556:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:557:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:568:4: ( (lv_access_14_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:569:5: (lv_access_14_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:569:5: (lv_access_14_0= ruleDSLAccess )
                    // InternalSasDsl.g:570:6: lv_access_14_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleMonitorAccess().getAccessDSLAccessParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_access_14_0=ruleDSLAccess();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    						set(
                    							current,
                    							"access",
                    							lv_access_14_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_15=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getDSLRuleMonitorAccess().getAnalyzerKeyword_2_3());
                    			
                    // InternalSasDsl.g:591:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:592:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:592:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:593:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRuleMonitorAccess().getAnalyzerDSLAnalyzerCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRuleMonitorAccess().getSemicolonKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:610:3: (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'monitor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    {
                    // InternalSasDsl.g:610:3: (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'monitor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    // InternalSasDsl.g:611:4: otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'monitor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';'
                    {
                    otherlv_18=(Token)match(input,18,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_3_0());
                    			
                    // InternalSasDsl.g:615:4: ( (otherlv_19= RULE_ID ) )
                    // InternalSasDsl.g:616:5: (otherlv_19= RULE_ID )
                    {
                    // InternalSasDsl.g:616:5: (otherlv_19= RULE_ID )
                    // InternalSasDsl.g:617:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_19, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:628:4: ( (lv_access_20_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:629:5: (lv_access_20_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:629:5: (lv_access_20_0= ruleDSLAccess )
                    // InternalSasDsl.g:630:6: lv_access_20_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleMonitorAccess().getAccessDSLAccessParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_17);
                    lv_access_20_0=ruleDSLAccess();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    						set(
                    							current,
                    							"access",
                    							lv_access_20_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_21=(Token)match(input,18,FOLLOW_3); 

                    				newLeafNode(otherlv_21, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_3_3());
                    			
                    // InternalSasDsl.g:651:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSasDsl.g:652:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSasDsl.g:652:5: (otherlv_22= RULE_ID )
                    // InternalSasDsl.g:653:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_22, grammarAccess.getDSLRuleMonitorAccess().getMonitor2DSLMonitorCrossReference_3_4_0());
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,16,FOLLOW_2); 

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
    // InternalSasDsl.g:673:1: entryRuleDSLRuleAnalyzer returns [EObject current=null] : iv_ruleDSLRuleAnalyzer= ruleDSLRuleAnalyzer EOF ;
    public final EObject entryRuleDSLRuleAnalyzer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleAnalyzer = null;


        try {
            // InternalSasDsl.g:673:56: (iv_ruleDSLRuleAnalyzer= ruleDSLRuleAnalyzer EOF )
            // InternalSasDsl.g:674:2: iv_ruleDSLRuleAnalyzer= ruleDSLRuleAnalyzer EOF
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
    // InternalSasDsl.g:680:1: ruleDSLRuleAnalyzer returns [EObject current=null] : ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( (lv_access_26_0= ruleDSLAccess ) ) otherlv_27= 'analyzer' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) ) ;
    public final EObject ruleDSLRuleAnalyzer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        AntlrDatatypeRuleToken lv_access_2_0 = null;

        AntlrDatatypeRuleToken lv_access_8_0 = null;

        AntlrDatatypeRuleToken lv_access_14_0 = null;

        AntlrDatatypeRuleToken lv_access_20_0 = null;

        AntlrDatatypeRuleToken lv_access_26_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:686:2: ( ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( (lv_access_26_0= ruleDSLAccess ) ) otherlv_27= 'analyzer' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) ) )
            // InternalSasDsl.g:687:2: ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( (lv_access_26_0= ruleDSLAccess ) ) otherlv_27= 'analyzer' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) )
            {
            // InternalSasDsl.g:687:2: ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( (lv_access_26_0= ruleDSLAccess ) ) otherlv_27= 'analyzer' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) )
            int alt6=5;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalSasDsl.g:688:3: (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:688:3: (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:689:4: otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_0_0());
                    			
                    // InternalSasDsl.g:693:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:694:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:694:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:695:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:706:4: ( (lv_access_2_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:707:5: (lv_access_2_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:707:5: (lv_access_2_0= ruleDSLAccess )
                    // InternalSasDsl.g:708:6: lv_access_2_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleAnalyzerAccess().getAccessDSLAccessParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_access_2_0=ruleDSLAccess();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    						set(
                    							current,
                    							"access",
                    							lv_access_2_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDSLRuleAnalyzerAccess().getKnowledgeKeyword_0_3());
                    			
                    // InternalSasDsl.g:729:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:730:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:730:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:731:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRuleAnalyzerAccess().getKnowledgeDSLKnowledgeCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:748:3: (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:748:3: (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:749:4: otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_1_0());
                    			
                    // InternalSasDsl.g:753:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:754:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:754:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:755:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:766:4: ( (lv_access_8_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:767:5: (lv_access_8_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:767:5: (lv_access_8_0= ruleDSLAccess )
                    // InternalSasDsl.g:768:6: lv_access_8_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleAnalyzerAccess().getAccessDSLAccessParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_17);
                    lv_access_8_0=ruleDSLAccess();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    						set(
                    							current,
                    							"access",
                    							lv_access_8_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,18,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getDSLRuleAnalyzerAccess().getMonitorKeyword_1_3());
                    			
                    // InternalSasDsl.g:789:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:790:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:790:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:791:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRuleAnalyzerAccess().getMonitorDSLMonitorCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:808:3: (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:808:3: (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:809:4: otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_2_0());
                    			
                    // InternalSasDsl.g:813:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:814:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:814:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:815:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:826:4: ( (lv_access_14_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:827:5: (lv_access_14_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:827:5: (lv_access_14_0= ruleDSLAccess )
                    // InternalSasDsl.g:828:6: lv_access_14_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleAnalyzerAccess().getAccessDSLAccessParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_access_14_0=ruleDSLAccess();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    						set(
                    							current,
                    							"access",
                    							lv_access_14_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_15=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getDSLRuleAnalyzerAccess().getPlannerKeyword_2_3());
                    			
                    // InternalSasDsl.g:849:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:850:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:850:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:851:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRuleAnalyzerAccess().getPlannerDSLPlannerCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:868:3: (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    {
                    // InternalSasDsl.g:868:3: (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    // InternalSasDsl.g:869:4: otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';'
                    {
                    otherlv_18=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_3_0());
                    			
                    // InternalSasDsl.g:873:4: ( (otherlv_19= RULE_ID ) )
                    // InternalSasDsl.g:874:5: (otherlv_19= RULE_ID )
                    {
                    // InternalSasDsl.g:874:5: (otherlv_19= RULE_ID )
                    // InternalSasDsl.g:875:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_19, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:886:4: ( (lv_access_20_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:887:5: (lv_access_20_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:887:5: (lv_access_20_0= ruleDSLAccess )
                    // InternalSasDsl.g:888:6: lv_access_20_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleAnalyzerAccess().getAccessDSLAccessParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_19);
                    lv_access_20_0=ruleDSLAccess();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    						set(
                    							current,
                    							"access",
                    							lv_access_20_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_21=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_21, grammarAccess.getDSLRuleAnalyzerAccess().getReferenceInputKeyword_3_3());
                    			
                    // InternalSasDsl.g:909:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSasDsl.g:910:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSasDsl.g:910:5: (otherlv_22= RULE_ID )
                    // InternalSasDsl.g:911:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_22, grammarAccess.getDSLRuleAnalyzerAccess().getRreferenceDSLReferenceInputCrossReference_3_4_0());
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_23, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_3_5());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalSasDsl.g:928:3: (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( (lv_access_26_0= ruleDSLAccess ) ) otherlv_27= 'analyzer' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    {
                    // InternalSasDsl.g:928:3: (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( (lv_access_26_0= ruleDSLAccess ) ) otherlv_27= 'analyzer' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    // InternalSasDsl.g:929:4: otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( (lv_access_26_0= ruleDSLAccess ) ) otherlv_27= 'analyzer' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';'
                    {
                    otherlv_24=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_24, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_4_0());
                    			
                    // InternalSasDsl.g:933:4: ( (otherlv_25= RULE_ID ) )
                    // InternalSasDsl.g:934:5: (otherlv_25= RULE_ID )
                    {
                    // InternalSasDsl.g:934:5: (otherlv_25= RULE_ID )
                    // InternalSasDsl.g:935:6: otherlv_25= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_25=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_25, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_4_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:946:4: ( (lv_access_26_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:947:5: (lv_access_26_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:947:5: (lv_access_26_0= ruleDSLAccess )
                    // InternalSasDsl.g:948:6: lv_access_26_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleAnalyzerAccess().getAccessDSLAccessParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_access_26_0=ruleDSLAccess();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    						set(
                    							current,
                    							"access",
                    							lv_access_26_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_27=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_27, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_4_3());
                    			
                    // InternalSasDsl.g:969:4: ( (otherlv_28= RULE_ID ) )
                    // InternalSasDsl.g:970:5: (otherlv_28= RULE_ID )
                    {
                    // InternalSasDsl.g:970:5: (otherlv_28= RULE_ID )
                    // InternalSasDsl.g:971:6: otherlv_28= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_28=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_28, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzer2DSLAnalyzerCrossReference_4_4_0());
                    					

                    }


                    }

                    otherlv_29=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_29, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_4_5());
                    			

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
    // InternalSasDsl.g:991:1: entryRuleDSLRulePlanner returns [EObject current=null] : iv_ruleDSLRulePlanner= ruleDSLRulePlanner EOF ;
    public final EObject entryRuleDSLRulePlanner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRulePlanner = null;


        try {
            // InternalSasDsl.g:991:55: (iv_ruleDSLRulePlanner= ruleDSLRulePlanner EOF )
            // InternalSasDsl.g:992:2: iv_ruleDSLRulePlanner= ruleDSLRulePlanner EOF
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
    // InternalSasDsl.g:998:1: ruleDSLRulePlanner returns [EObject current=null] : ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'planner' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) ) ;
    public final EObject ruleDSLRulePlanner() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        AntlrDatatypeRuleToken lv_access_2_0 = null;

        AntlrDatatypeRuleToken lv_access_8_0 = null;

        AntlrDatatypeRuleToken lv_access_14_0 = null;

        AntlrDatatypeRuleToken lv_access_20_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:1004:2: ( ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'planner' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) ) )
            // InternalSasDsl.g:1005:2: ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'planner' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) )
            {
            // InternalSasDsl.g:1005:2: ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'planner' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) )
            int alt7=4;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==22) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_ID) ) {
                    int LA7_2 = input.LA(3);

                    if ( (LA7_2==27) ) {
                        switch ( input.LA(4) ) {
                        case 24:
                            {
                            alt7=3;
                            }
                            break;
                        case 20:
                            {
                            alt7=1;
                            }
                            break;
                        case 22:
                            {
                            alt7=4;
                            }
                            break;
                        case 21:
                            {
                            alt7=2;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 3, input);

                            throw nvae;
                        }

                    }
                    else if ( (LA7_2==28) ) {
                        switch ( input.LA(4) ) {
                        case 24:
                            {
                            alt7=3;
                            }
                            break;
                        case 20:
                            {
                            alt7=1;
                            }
                            break;
                        case 22:
                            {
                            alt7=4;
                            }
                            break;
                        case 21:
                            {
                            alt7=2;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 4, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalSasDsl.g:1006:3: (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:1006:3: (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:1007:4: otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_0_0());
                    			
                    // InternalSasDsl.g:1011:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:1012:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:1012:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:1013:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1024:4: ( (lv_access_2_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:1025:5: (lv_access_2_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:1025:5: (lv_access_2_0= ruleDSLAccess )
                    // InternalSasDsl.g:1026:6: lv_access_2_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRulePlannerAccess().getAccessDSLAccessParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_access_2_0=ruleDSLAccess();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSLRulePlannerRule());
                    						}
                    						set(
                    							current,
                    							"access",
                    							lv_access_2_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDSLRulePlannerAccess().getKnowledgeKeyword_0_3());
                    			
                    // InternalSasDsl.g:1047:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:1048:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:1048:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:1049:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRulePlannerAccess().getKnowledgeDSLKnowledgeCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:1066:3: (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:1066:3: (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:1067:4: otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_1_0());
                    			
                    // InternalSasDsl.g:1071:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:1072:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:1072:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:1073:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1084:4: ( (lv_access_8_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:1085:5: (lv_access_8_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:1085:5: (lv_access_8_0= ruleDSLAccess )
                    // InternalSasDsl.g:1086:6: lv_access_8_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRulePlannerAccess().getAccessDSLAccessParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_access_8_0=ruleDSLAccess();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSLRulePlannerRule());
                    						}
                    						set(
                    							current,
                    							"access",
                    							lv_access_8_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getDSLRulePlannerAccess().getAnalyzerKeyword_1_3());
                    			
                    // InternalSasDsl.g:1107:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:1108:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:1108:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:1109:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRulePlannerAccess().getAnalyzerDSLAnalyzerCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:1126:3: (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:1126:3: (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:1127:4: otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_2_0());
                    			
                    // InternalSasDsl.g:1131:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:1132:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:1132:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:1133:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1144:4: ( (lv_access_14_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:1145:5: (lv_access_14_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:1145:5: (lv_access_14_0= ruleDSLAccess )
                    // InternalSasDsl.g:1146:6: lv_access_14_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRulePlannerAccess().getAccessDSLAccessParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_access_14_0=ruleDSLAccess();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSLRulePlannerRule());
                    						}
                    						set(
                    							current,
                    							"access",
                    							lv_access_14_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_15=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getDSLRulePlannerAccess().getExecutorKeyword_2_3());
                    			
                    // InternalSasDsl.g:1167:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:1168:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:1168:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:1169:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRulePlannerAccess().getExecutorDSLExecutorCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:1186:3: (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'planner' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    {
                    // InternalSasDsl.g:1186:3: (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'planner' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    // InternalSasDsl.g:1187:4: otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'planner' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';'
                    {
                    otherlv_18=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_3_0());
                    			
                    // InternalSasDsl.g:1191:4: ( (otherlv_19= RULE_ID ) )
                    // InternalSasDsl.g:1192:5: (otherlv_19= RULE_ID )
                    {
                    // InternalSasDsl.g:1192:5: (otherlv_19= RULE_ID )
                    // InternalSasDsl.g:1193:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_19, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1204:4: ( (lv_access_20_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:1205:5: (lv_access_20_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:1205:5: (lv_access_20_0= ruleDSLAccess )
                    // InternalSasDsl.g:1206:6: lv_access_20_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRulePlannerAccess().getAccessDSLAccessParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_access_20_0=ruleDSLAccess();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSLRulePlannerRule());
                    						}
                    						set(
                    							current,
                    							"access",
                    							lv_access_20_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_21=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_21, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_3_3());
                    			
                    // InternalSasDsl.g:1227:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSasDsl.g:1228:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSasDsl.g:1228:5: (otherlv_22= RULE_ID )
                    // InternalSasDsl.g:1229:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_22, grammarAccess.getDSLRulePlannerAccess().getPlanner2DSLPlannerCrossReference_3_4_0());
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_23, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_3_5());
                    			

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
    // InternalSasDsl.g:1249:1: entryRuleDSLRuleExecutor returns [EObject current=null] : iv_ruleDSLRuleExecutor= ruleDSLRuleExecutor EOF ;
    public final EObject entryRuleDSLRuleExecutor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleExecutor = null;


        try {
            // InternalSasDsl.g:1249:56: (iv_ruleDSLRuleExecutor= ruleDSLRuleExecutor EOF )
            // InternalSasDsl.g:1250:2: iv_ruleDSLRuleExecutor= ruleDSLRuleExecutor EOF
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
    // InternalSasDsl.g:1256:1: ruleDSLRuleExecutor returns [EObject current=null] : ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'effector' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'planner' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'knowledge' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) ) ;
    public final EObject ruleDSLRuleExecutor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        AntlrDatatypeRuleToken lv_access_2_0 = null;

        AntlrDatatypeRuleToken lv_access_8_0 = null;

        AntlrDatatypeRuleToken lv_access_14_0 = null;

        AntlrDatatypeRuleToken lv_access_20_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:1262:2: ( ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'effector' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'planner' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'knowledge' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) ) )
            // InternalSasDsl.g:1263:2: ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'effector' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'planner' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'knowledge' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) )
            {
            // InternalSasDsl.g:1263:2: ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'effector' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'planner' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'knowledge' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) )
            int alt8=4;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==24) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==RULE_ID) ) {
                    int LA8_2 = input.LA(3);

                    if ( (LA8_2==27) ) {
                        switch ( input.LA(4) ) {
                        case 22:
                            {
                            alt8=2;
                            }
                            break;
                        case 20:
                            {
                            alt8=3;
                            }
                            break;
                        case 25:
                            {
                            alt8=1;
                            }
                            break;
                        case 24:
                            {
                            alt8=4;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 8, 3, input);

                            throw nvae;
                        }

                    }
                    else if ( (LA8_2==28) ) {
                        switch ( input.LA(4) ) {
                        case 24:
                            {
                            alt8=4;
                            }
                            break;
                        case 22:
                            {
                            alt8=2;
                            }
                            break;
                        case 20:
                            {
                            alt8=3;
                            }
                            break;
                        case 25:
                            {
                            alt8=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 8, 4, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalSasDsl.g:1264:3: (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'effector' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:1264:3: (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'effector' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:1265:4: otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'effector' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_0_0());
                    			
                    // InternalSasDsl.g:1269:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:1270:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:1270:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:1271:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1282:4: ( (lv_access_2_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:1283:5: (lv_access_2_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:1283:5: (lv_access_2_0= ruleDSLAccess )
                    // InternalSasDsl.g:1284:6: lv_access_2_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleExecutorAccess().getAccessDSLAccessParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_access_2_0=ruleDSLAccess();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    						set(
                    							current,
                    							"access",
                    							lv_access_2_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,25,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDSLRuleExecutorAccess().getEffectorKeyword_0_3());
                    			
                    // InternalSasDsl.g:1305:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:1306:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:1306:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:1307:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRuleExecutorAccess().getEffectorDSLEffectorCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRuleExecutorAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:1324:3: (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'planner' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:1324:3: (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'planner' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:1325:4: otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'planner' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_1_0());
                    			
                    // InternalSasDsl.g:1329:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:1330:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:1330:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:1331:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1342:4: ( (lv_access_8_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:1343:5: (lv_access_8_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:1343:5: (lv_access_8_0= ruleDSLAccess )
                    // InternalSasDsl.g:1344:6: lv_access_8_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleExecutorAccess().getAccessDSLAccessParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_access_8_0=ruleDSLAccess();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    						set(
                    							current,
                    							"access",
                    							lv_access_8_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getDSLRuleExecutorAccess().getPlannerKeyword_1_3());
                    			
                    // InternalSasDsl.g:1365:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:1366:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:1366:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:1367:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRuleExecutorAccess().getPlannerDSLPlannerCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRuleExecutorAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:1384:3: (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'knowledge' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:1384:3: (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'knowledge' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:1385:4: otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'knowledge' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_2_0());
                    			
                    // InternalSasDsl.g:1389:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:1390:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:1390:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:1391:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1402:4: ( (lv_access_14_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:1403:5: (lv_access_14_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:1403:5: (lv_access_14_0= ruleDSLAccess )
                    // InternalSasDsl.g:1404:6: lv_access_14_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleExecutorAccess().getAccessDSLAccessParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_access_14_0=ruleDSLAccess();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    						set(
                    							current,
                    							"access",
                    							lv_access_14_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_15=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getDSLRuleExecutorAccess().getKnowledgeKeyword_2_3());
                    			
                    // InternalSasDsl.g:1425:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:1426:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:1426:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:1427:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRuleExecutorAccess().getKnowledgeDSLKnowledgeCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRuleExecutorAccess().getSemicolonKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:1444:3: (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    {
                    // InternalSasDsl.g:1444:3: (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    // InternalSasDsl.g:1445:4: otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';'
                    {
                    otherlv_18=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_3_0());
                    			
                    // InternalSasDsl.g:1449:4: ( (otherlv_19= RULE_ID ) )
                    // InternalSasDsl.g:1450:5: (otherlv_19= RULE_ID )
                    {
                    // InternalSasDsl.g:1450:5: (otherlv_19= RULE_ID )
                    // InternalSasDsl.g:1451:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_19, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1462:4: ( (lv_access_20_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:1463:5: (lv_access_20_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:1463:5: (lv_access_20_0= ruleDSLAccess )
                    // InternalSasDsl.g:1464:6: lv_access_20_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleExecutorAccess().getAccessDSLAccessParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_access_20_0=ruleDSLAccess();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    						set(
                    							current,
                    							"access",
                    							lv_access_20_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_21=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_21, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_3_3());
                    			
                    // InternalSasDsl.g:1485:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSasDsl.g:1486:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSasDsl.g:1486:5: (otherlv_22= RULE_ID )
                    // InternalSasDsl.g:1487:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_22, grammarAccess.getDSLRuleExecutorAccess().getExecutor2DSLExecutorCrossReference_3_4_0());
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,16,FOLLOW_2); 

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
    // InternalSasDsl.g:1507:1: entryRuleDSLRuleMO returns [EObject current=null] : iv_ruleDSLRuleMO= ruleDSLRuleMO EOF ;
    public final EObject entryRuleDSLRuleMO() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleMO = null;


        try {
            // InternalSasDsl.g:1507:50: (iv_ruleDSLRuleMO= ruleDSLRuleMO EOF )
            // InternalSasDsl.g:1508:2: iv_ruleDSLRuleMO= ruleDSLRuleMO EOF
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
    // InternalSasDsl.g:1514:1: ruleDSLRuleMO returns [EObject current=null] : (otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) ;
    public final EObject ruleDSLRuleMO() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_access_2_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:1520:2: ( (otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) )
            // InternalSasDsl.g:1521:2: (otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            {
            // InternalSasDsl.g:1521:2: (otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            // InternalSasDsl.g:1522:3: otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLRuleMOAccess().getSensorKeyword_0());
            		
            // InternalSasDsl.g:1526:3: ( (otherlv_1= RULE_ID ) )
            // InternalSasDsl.g:1527:4: (otherlv_1= RULE_ID )
            {
            // InternalSasDsl.g:1527:4: (otherlv_1= RULE_ID )
            // InternalSasDsl.g:1528:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleMORule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(otherlv_1, grammarAccess.getDSLRuleMOAccess().getSensorDSLSensorCrossReference_1_0());
            				

            }


            }

            // InternalSasDsl.g:1539:3: ( (lv_access_2_0= ruleDSLAccess ) )
            // InternalSasDsl.g:1540:4: (lv_access_2_0= ruleDSLAccess )
            {
            // InternalSasDsl.g:1540:4: (lv_access_2_0= ruleDSLAccess )
            // InternalSasDsl.g:1541:5: lv_access_2_0= ruleDSLAccess
            {

            					newCompositeNode(grammarAccess.getDSLRuleMOAccess().getAccessDSLAccessParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_22);
            lv_access_2_0=ruleDSLAccess();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDSLRuleMORule());
            					}
            					set(
            						current,
            						"access",
            						lv_access_2_0,
            						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getDSLRuleMOAccess().getMeasuredOutputKeyword_3());
            		
            // InternalSasDsl.g:1562:3: ( (otherlv_4= RULE_ID ) )
            // InternalSasDsl.g:1563:4: (otherlv_4= RULE_ID )
            {
            // InternalSasDsl.g:1563:4: (otherlv_4= RULE_ID )
            // InternalSasDsl.g:1564:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleMORule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_4, grammarAccess.getDSLRuleMOAccess().getMeasuredDSLMeasuredOutputCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,16,FOLLOW_2); 

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


    // $ANTLR start "entryRuleDSLAccess"
    // InternalSasDsl.g:1583:1: entryRuleDSLAccess returns [String current=null] : iv_ruleDSLAccess= ruleDSLAccess EOF ;
    public final String entryRuleDSLAccess() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDSLAccess = null;


        try {
            // InternalSasDsl.g:1583:49: (iv_ruleDSLAccess= ruleDSLAccess EOF )
            // InternalSasDsl.g:1584:2: iv_ruleDSLAccess= ruleDSLAccess EOF
            {
             newCompositeNode(grammarAccess.getDSLAccessRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLAccess=ruleDSLAccess();

            state._fsp--;

             current =iv_ruleDSLAccess.getText(); 
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
    // $ANTLR end "entryRuleDSLAccess"


    // $ANTLR start "ruleDSLAccess"
    // InternalSasDsl.g:1590:1: ruleDSLAccess returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'can-access' | kw= 'cannot-access' ) ;
    public final AntlrDatatypeRuleToken ruleDSLAccess() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSasDsl.g:1596:2: ( (kw= 'can-access' | kw= 'cannot-access' ) )
            // InternalSasDsl.g:1597:2: (kw= 'can-access' | kw= 'cannot-access' )
            {
            // InternalSasDsl.g:1597:2: (kw= 'can-access' | kw= 'cannot-access' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==27) ) {
                alt9=1;
            }
            else if ( (LA9_0==28) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalSasDsl.g:1598:3: kw= 'can-access'
                    {
                    kw=(Token)match(input,27,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getDSLAccessAccess().getCanAccessKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:1604:3: kw= 'cannot-access'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getDSLAccessAccess().getCannotAccessKeyword_1());
                    		

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
    // $ANTLR end "ruleDSLAccess"


    // $ANTLR start "entryRuleDSLManaging"
    // InternalSasDsl.g:1613:1: entryRuleDSLManaging returns [EObject current=null] : iv_ruleDSLManaging= ruleDSLManaging EOF ;
    public final EObject entryRuleDSLManaging() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLManaging = null;


        try {
            // InternalSasDsl.g:1613:52: (iv_ruleDSLManaging= ruleDSLManaging EOF )
            // InternalSasDsl.g:1614:2: iv_ruleDSLManaging= ruleDSLManaging EOF
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
    // InternalSasDsl.g:1620:1: ruleDSLManaging returns [EObject current=null] : (otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )* otherlv_5= '}' ) ;
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
            // InternalSasDsl.g:1626:2: ( (otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )* otherlv_5= '}' ) )
            // InternalSasDsl.g:1627:2: (otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )* otherlv_5= '}' )
            {
            // InternalSasDsl.g:1627:2: (otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )* otherlv_5= '}' )
            // InternalSasDsl.g:1628:3: otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLManagingAccess().getManagingKeyword_0());
            		
            // InternalSasDsl.g:1632:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:1633:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:1633:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:1634:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,12,FOLLOW_23); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLManagingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalSasDsl.g:1654:3: ( (lv_managerController_3_0= ruleDSLManagerController ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==31) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalSasDsl.g:1655:4: (lv_managerController_3_0= ruleDSLManagerController )
            	    {
            	    // InternalSasDsl.g:1655:4: (lv_managerController_3_0= ruleDSLManagerController )
            	    // InternalSasDsl.g:1656:5: lv_managerController_3_0= ruleDSLManagerController
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagingAccess().getManagerControllerDSLManagerControllerParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_23);
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
            	    break loop10;
                }
            } while (true);

            // InternalSasDsl.g:1673:3: ( (lv_controller_4_0= ruleDSLController ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==36) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalSasDsl.g:1674:4: (lv_controller_4_0= ruleDSLController )
            	    {
            	    // InternalSasDsl.g:1674:4: (lv_controller_4_0= ruleDSLController )
            	    // InternalSasDsl.g:1675:5: lv_controller_4_0= ruleDSLController
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagingAccess().getControllerDSLControllerParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_24);
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
            	    break loop11;
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
    // InternalSasDsl.g:1700:1: entryRuleDSLManaged returns [EObject current=null] : iv_ruleDSLManaged= ruleDSLManaged EOF ;
    public final EObject entryRuleDSLManaged() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLManaged = null;


        try {
            // InternalSasDsl.g:1700:51: (iv_ruleDSLManaged= ruleDSLManaged EOF )
            // InternalSasDsl.g:1701:2: iv_ruleDSLManaged= ruleDSLManaged EOF
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
    // InternalSasDsl.g:1707:1: ruleDSLManaged returns [EObject current=null] : (otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )+ ( (lv_effector_4_0= ruleDSLEffector ) )+ ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )+ otherlv_6= '}' ) ;
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
            // InternalSasDsl.g:1713:2: ( (otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )+ ( (lv_effector_4_0= ruleDSLEffector ) )+ ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )+ otherlv_6= '}' ) )
            // InternalSasDsl.g:1714:2: (otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )+ ( (lv_effector_4_0= ruleDSLEffector ) )+ ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )+ otherlv_6= '}' )
            {
            // InternalSasDsl.g:1714:2: (otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )+ ( (lv_effector_4_0= ruleDSLEffector ) )+ ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )+ otherlv_6= '}' )
            // InternalSasDsl.g:1715:3: otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )+ ( (lv_effector_4_0= ruleDSLEffector ) )+ ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )+ otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLManagedAccess().getManagedKeyword_0());
            		
            // InternalSasDsl.g:1719:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:1720:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:1720:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:1721:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,12,FOLLOW_25); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLManagedAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalSasDsl.g:1741:3: ( (lv_sensor_3_0= ruleDSLSensor ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==42) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalSasDsl.g:1742:4: (lv_sensor_3_0= ruleDSLSensor )
            	    {
            	    // InternalSasDsl.g:1742:4: (lv_sensor_3_0= ruleDSLSensor )
            	    // InternalSasDsl.g:1743:5: lv_sensor_3_0= ruleDSLSensor
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
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            // InternalSasDsl.g:1760:3: ( (lv_effector_4_0= ruleDSLEffector ) )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==43) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalSasDsl.g:1761:4: (lv_effector_4_0= ruleDSLEffector )
            	    {
            	    // InternalSasDsl.g:1761:4: (lv_effector_4_0= ruleDSLEffector )
            	    // InternalSasDsl.g:1762:5: lv_effector_4_0= ruleDSLEffector
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
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            // InternalSasDsl.g:1779:3: ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==45) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalSasDsl.g:1780:4: (lv_measuredOutput_5_0= ruleDSLMeasuredOutput )
            	    {
            	    // InternalSasDsl.g:1780:4: (lv_measuredOutput_5_0= ruleDSLMeasuredOutput )
            	    // InternalSasDsl.g:1781:5: lv_measuredOutput_5_0= ruleDSLMeasuredOutput
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
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
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
    // InternalSasDsl.g:1806:1: entryRuleDSLManagerController returns [EObject current=null] : iv_ruleDSLManagerController= ruleDSLManagerController EOF ;
    public final EObject entryRuleDSLManagerController() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLManagerController = null;


        try {
            // InternalSasDsl.g:1806:61: (iv_ruleDSLManagerController= ruleDSLManagerController EOF )
            // InternalSasDsl.g:1807:2: iv_ruleDSLManagerController= ruleDSLManagerController EOF
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
    // InternalSasDsl.g:1813:1: ruleDSLManagerController returns [EObject current=null] : (otherlv_0= 'ManagerController' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'typeOf' ruleDSLTypeMC otherlv_4= '{' ( (lv_controller_5_0= ruleDSLController ) )+ otherlv_6= '}' ) ;
    public final EObject ruleDSLManagerController() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_controller_5_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:1819:2: ( (otherlv_0= 'ManagerController' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'typeOf' ruleDSLTypeMC otherlv_4= '{' ( (lv_controller_5_0= ruleDSLController ) )+ otherlv_6= '}' ) )
            // InternalSasDsl.g:1820:2: (otherlv_0= 'ManagerController' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'typeOf' ruleDSLTypeMC otherlv_4= '{' ( (lv_controller_5_0= ruleDSLController ) )+ otherlv_6= '}' )
            {
            // InternalSasDsl.g:1820:2: (otherlv_0= 'ManagerController' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'typeOf' ruleDSLTypeMC otherlv_4= '{' ( (lv_controller_5_0= ruleDSLController ) )+ otherlv_6= '}' )
            // InternalSasDsl.g:1821:3: otherlv_0= 'ManagerController' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'typeOf' ruleDSLTypeMC otherlv_4= '{' ( (lv_controller_5_0= ruleDSLController ) )+ otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLManagerControllerAccess().getManagerControllerKeyword_0());
            		
            // InternalSasDsl.g:1825:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:1826:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:1826:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:1827:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_29); 

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

            otherlv_2=(Token)match(input,32,FOLLOW_30); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLManagerControllerAccess().getTypeOfKeyword_2());
            		

            			newCompositeNode(grammarAccess.getDSLManagerControllerAccess().getDSLTypeMCParserRuleCall_3());
            		
            pushFollow(FOLLOW_4);
            ruleDSLTypeMC();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            otherlv_4=(Token)match(input,12,FOLLOW_31); 

            			newLeafNode(otherlv_4, grammarAccess.getDSLManagerControllerAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalSasDsl.g:1858:3: ( (lv_controller_5_0= ruleDSLController ) )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==36) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalSasDsl.g:1859:4: (lv_controller_5_0= ruleDSLController )
            	    {
            	    // InternalSasDsl.g:1859:4: (lv_controller_5_0= ruleDSLController )
            	    // InternalSasDsl.g:1860:5: lv_controller_5_0= ruleDSLController
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagerControllerAccess().getControllerDSLControllerParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_24);
            	    lv_controller_5_0=ruleDSLController();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSLManagerControllerRule());
            	    					}
            	    					add(
            	    						current,
            	    						"controller",
            	    						lv_controller_5_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLController");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);

            otherlv_6=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getDSLManagerControllerAccess().getRightCurlyBracketKeyword_6());
            		

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


    // $ANTLR start "entryRuleDSLTypeMC"
    // InternalSasDsl.g:1885:1: entryRuleDSLTypeMC returns [String current=null] : iv_ruleDSLTypeMC= ruleDSLTypeMC EOF ;
    public final String entryRuleDSLTypeMC() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDSLTypeMC = null;


        try {
            // InternalSasDsl.g:1885:49: (iv_ruleDSLTypeMC= ruleDSLTypeMC EOF )
            // InternalSasDsl.g:1886:2: iv_ruleDSLTypeMC= ruleDSLTypeMC EOF
            {
             newCompositeNode(grammarAccess.getDSLTypeMCRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDSLTypeMC=ruleDSLTypeMC();

            state._fsp--;

             current =iv_ruleDSLTypeMC.getText(); 
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
    // $ANTLR end "entryRuleDSLTypeMC"


    // $ANTLR start "ruleDSLTypeMC"
    // InternalSasDsl.g:1892:1: ruleDSLTypeMC returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Synchronized' | kw= 'Coordinated' | kw= 'Independent' ) ;
    public final AntlrDatatypeRuleToken ruleDSLTypeMC() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSasDsl.g:1898:2: ( (kw= 'Synchronized' | kw= 'Coordinated' | kw= 'Independent' ) )
            // InternalSasDsl.g:1899:2: (kw= 'Synchronized' | kw= 'Coordinated' | kw= 'Independent' )
            {
            // InternalSasDsl.g:1899:2: (kw= 'Synchronized' | kw= 'Coordinated' | kw= 'Independent' )
            int alt16=3;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt16=1;
                }
                break;
            case 34:
                {
                alt16=2;
                }
                break;
            case 35:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalSasDsl.g:1900:3: kw= 'Synchronized'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getDSLTypeMCAccess().getSynchronizedKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:1906:3: kw= 'Coordinated'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getDSLTypeMCAccess().getCoordinatedKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:1912:3: kw= 'Independent'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getDSLTypeMCAccess().getIndependentKeyword_2());
                    		

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
    // $ANTLR end "ruleDSLTypeMC"


    // $ANTLR start "entryRuleDSLController"
    // InternalSasDsl.g:1921:1: entryRuleDSLController returns [EObject current=null] : iv_ruleDSLController= ruleDSLController EOF ;
    public final EObject entryRuleDSLController() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLController = null;


        try {
            // InternalSasDsl.g:1921:54: (iv_ruleDSLController= ruleDSLController EOF )
            // InternalSasDsl.g:1922:2: iv_ruleDSLController= ruleDSLController EOF
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
    // InternalSasDsl.g:1928:1: ruleDSLController returns [EObject current=null] : (otherlv_0= 'Controller' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_monitor_3_0= ruleDSLMonitor ) )+ ( (lv_analyzer_4_0= ruleDSLAnalyzer ) )+ ( (lv_planner_5_0= ruleDSLPlanner ) )+ ( (lv_executor_6_0= ruleDSLExecutor ) )+ ( (lv_knowledge_7_0= ruleDSLKnowledge ) )+ otherlv_8= '}' ) ;
    public final EObject ruleDSLController() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_8=null;
        EObject lv_monitor_3_0 = null;

        EObject lv_analyzer_4_0 = null;

        EObject lv_planner_5_0 = null;

        EObject lv_executor_6_0 = null;

        EObject lv_knowledge_7_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:1934:2: ( (otherlv_0= 'Controller' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_monitor_3_0= ruleDSLMonitor ) )+ ( (lv_analyzer_4_0= ruleDSLAnalyzer ) )+ ( (lv_planner_5_0= ruleDSLPlanner ) )+ ( (lv_executor_6_0= ruleDSLExecutor ) )+ ( (lv_knowledge_7_0= ruleDSLKnowledge ) )+ otherlv_8= '}' ) )
            // InternalSasDsl.g:1935:2: (otherlv_0= 'Controller' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_monitor_3_0= ruleDSLMonitor ) )+ ( (lv_analyzer_4_0= ruleDSLAnalyzer ) )+ ( (lv_planner_5_0= ruleDSLPlanner ) )+ ( (lv_executor_6_0= ruleDSLExecutor ) )+ ( (lv_knowledge_7_0= ruleDSLKnowledge ) )+ otherlv_8= '}' )
            {
            // InternalSasDsl.g:1935:2: (otherlv_0= 'Controller' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_monitor_3_0= ruleDSLMonitor ) )+ ( (lv_analyzer_4_0= ruleDSLAnalyzer ) )+ ( (lv_planner_5_0= ruleDSLPlanner ) )+ ( (lv_executor_6_0= ruleDSLExecutor ) )+ ( (lv_knowledge_7_0= ruleDSLKnowledge ) )+ otherlv_8= '}' )
            // InternalSasDsl.g:1936:3: otherlv_0= 'Controller' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_monitor_3_0= ruleDSLMonitor ) )+ ( (lv_analyzer_4_0= ruleDSLAnalyzer ) )+ ( (lv_planner_5_0= ruleDSLPlanner ) )+ ( (lv_executor_6_0= ruleDSLExecutor ) )+ ( (lv_knowledge_7_0= ruleDSLKnowledge ) )+ otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLControllerAccess().getControllerKeyword_0());
            		
            // InternalSasDsl.g:1940:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:1941:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:1941:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:1942:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

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

            otherlv_2=(Token)match(input,12,FOLLOW_32); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLControllerAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalSasDsl.g:1962:3: ( (lv_monitor_3_0= ruleDSLMonitor ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==37) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalSasDsl.g:1963:4: (lv_monitor_3_0= ruleDSLMonitor )
            	    {
            	    // InternalSasDsl.g:1963:4: (lv_monitor_3_0= ruleDSLMonitor )
            	    // InternalSasDsl.g:1964:5: lv_monitor_3_0= ruleDSLMonitor
            	    {

            	    					newCompositeNode(grammarAccess.getDSLControllerAccess().getMonitorDSLMonitorParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_33);
            	    lv_monitor_3_0=ruleDSLMonitor();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSLControllerRule());
            	    					}
            	    					add(
            	    						current,
            	    						"monitor",
            	    						lv_monitor_3_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLMonitor");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);

            // InternalSasDsl.g:1981:3: ( (lv_analyzer_4_0= ruleDSLAnalyzer ) )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==38) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalSasDsl.g:1982:4: (lv_analyzer_4_0= ruleDSLAnalyzer )
            	    {
            	    // InternalSasDsl.g:1982:4: (lv_analyzer_4_0= ruleDSLAnalyzer )
            	    // InternalSasDsl.g:1983:5: lv_analyzer_4_0= ruleDSLAnalyzer
            	    {

            	    					newCompositeNode(grammarAccess.getDSLControllerAccess().getAnalyzerDSLAnalyzerParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_34);
            	    lv_analyzer_4_0=ruleDSLAnalyzer();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSLControllerRule());
            	    					}
            	    					add(
            	    						current,
            	    						"analyzer",
            	    						lv_analyzer_4_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAnalyzer");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);

            // InternalSasDsl.g:2000:3: ( (lv_planner_5_0= ruleDSLPlanner ) )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==39) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalSasDsl.g:2001:4: (lv_planner_5_0= ruleDSLPlanner )
            	    {
            	    // InternalSasDsl.g:2001:4: (lv_planner_5_0= ruleDSLPlanner )
            	    // InternalSasDsl.g:2002:5: lv_planner_5_0= ruleDSLPlanner
            	    {

            	    					newCompositeNode(grammarAccess.getDSLControllerAccess().getPlannerDSLPlannerParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_35);
            	    lv_planner_5_0=ruleDSLPlanner();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSLControllerRule());
            	    					}
            	    					add(
            	    						current,
            	    						"planner",
            	    						lv_planner_5_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLPlanner");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);

            // InternalSasDsl.g:2019:3: ( (lv_executor_6_0= ruleDSLExecutor ) )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==40) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalSasDsl.g:2020:4: (lv_executor_6_0= ruleDSLExecutor )
            	    {
            	    // InternalSasDsl.g:2020:4: (lv_executor_6_0= ruleDSLExecutor )
            	    // InternalSasDsl.g:2021:5: lv_executor_6_0= ruleDSLExecutor
            	    {

            	    					newCompositeNode(grammarAccess.getDSLControllerAccess().getExecutorDSLExecutorParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_36);
            	    lv_executor_6_0=ruleDSLExecutor();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSLControllerRule());
            	    					}
            	    					add(
            	    						current,
            	    						"executor",
            	    						lv_executor_6_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLExecutor");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);

            // InternalSasDsl.g:2038:3: ( (lv_knowledge_7_0= ruleDSLKnowledge ) )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==41) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalSasDsl.g:2039:4: (lv_knowledge_7_0= ruleDSLKnowledge )
            	    {
            	    // InternalSasDsl.g:2039:4: (lv_knowledge_7_0= ruleDSLKnowledge )
            	    // InternalSasDsl.g:2040:5: lv_knowledge_7_0= ruleDSLKnowledge
            	    {

            	    					newCompositeNode(grammarAccess.getDSLControllerAccess().getKnowledgeDSLKnowledgeParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_37);
            	    lv_knowledge_7_0=ruleDSLKnowledge();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDSLControllerRule());
            	    					}
            	    					add(
            	    						current,
            	    						"knowledge",
            	    						lv_knowledge_7_0,
            	    						"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLKnowledge");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);

            otherlv_8=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getDSLControllerAccess().getRightCurlyBracketKeyword_8());
            		

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


    // $ANTLR start "entryRuleDSLMonitor"
    // InternalSasDsl.g:2065:1: entryRuleDSLMonitor returns [EObject current=null] : iv_ruleDSLMonitor= ruleDSLMonitor EOF ;
    public final EObject entryRuleDSLMonitor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLMonitor = null;


        try {
            // InternalSasDsl.g:2065:51: (iv_ruleDSLMonitor= ruleDSLMonitor EOF )
            // InternalSasDsl.g:2066:2: iv_ruleDSLMonitor= ruleDSLMonitor EOF
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
    // InternalSasDsl.g:2072:1: ruleDSLMonitor returns [EObject current=null] : (otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLMonitor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2078:2: ( (otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2079:2: (otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2079:2: (otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2080:3: otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLMonitorAccess().getMonitorKeyword_0());
            		
            // InternalSasDsl.g:2084:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2085:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2085:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2086:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_2); 

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
    // InternalSasDsl.g:2110:1: entryRuleDSLAnalyzer returns [EObject current=null] : iv_ruleDSLAnalyzer= ruleDSLAnalyzer EOF ;
    public final EObject entryRuleDSLAnalyzer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLAnalyzer = null;


        try {
            // InternalSasDsl.g:2110:52: (iv_ruleDSLAnalyzer= ruleDSLAnalyzer EOF )
            // InternalSasDsl.g:2111:2: iv_ruleDSLAnalyzer= ruleDSLAnalyzer EOF
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
    // InternalSasDsl.g:2117:1: ruleDSLAnalyzer returns [EObject current=null] : (otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLAnalyzer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2123:2: ( (otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2124:2: (otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2124:2: (otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2125:3: otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLAnalyzerAccess().getAnalyzerKeyword_0());
            		
            // InternalSasDsl.g:2129:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2130:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2130:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2131:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_2); 

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
    // InternalSasDsl.g:2155:1: entryRuleDSLPlanner returns [EObject current=null] : iv_ruleDSLPlanner= ruleDSLPlanner EOF ;
    public final EObject entryRuleDSLPlanner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLPlanner = null;


        try {
            // InternalSasDsl.g:2155:51: (iv_ruleDSLPlanner= ruleDSLPlanner EOF )
            // InternalSasDsl.g:2156:2: iv_ruleDSLPlanner= ruleDSLPlanner EOF
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
    // InternalSasDsl.g:2162:1: ruleDSLPlanner returns [EObject current=null] : (otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLPlanner() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2168:2: ( (otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2169:2: (otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2169:2: (otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2170:3: otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLPlannerAccess().getPlannerKeyword_0());
            		
            // InternalSasDsl.g:2174:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2175:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2175:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2176:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_2); 

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
    // InternalSasDsl.g:2200:1: entryRuleDSLExecutor returns [EObject current=null] : iv_ruleDSLExecutor= ruleDSLExecutor EOF ;
    public final EObject entryRuleDSLExecutor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLExecutor = null;


        try {
            // InternalSasDsl.g:2200:52: (iv_ruleDSLExecutor= ruleDSLExecutor EOF )
            // InternalSasDsl.g:2201:2: iv_ruleDSLExecutor= ruleDSLExecutor EOF
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
    // InternalSasDsl.g:2207:1: ruleDSLExecutor returns [EObject current=null] : (otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLExecutor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2213:2: ( (otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2214:2: (otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2214:2: (otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2215:3: otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLExecutorAccess().getExecutorKeyword_0());
            		
            // InternalSasDsl.g:2219:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2220:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2220:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2221:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_2); 

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
    // InternalSasDsl.g:2245:1: entryRuleDSLKnowledge returns [EObject current=null] : iv_ruleDSLKnowledge= ruleDSLKnowledge EOF ;
    public final EObject entryRuleDSLKnowledge() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLKnowledge = null;


        try {
            // InternalSasDsl.g:2245:53: (iv_ruleDSLKnowledge= ruleDSLKnowledge EOF )
            // InternalSasDsl.g:2246:2: iv_ruleDSLKnowledge= ruleDSLKnowledge EOF
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
    // InternalSasDsl.g:2252:1: ruleDSLKnowledge returns [EObject current=null] : (otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )+ otherlv_4= '}' ) ;
    public final EObject ruleDSLKnowledge() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_referenceInput_3_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:2258:2: ( (otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )+ otherlv_4= '}' ) )
            // InternalSasDsl.g:2259:2: (otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )+ otherlv_4= '}' )
            {
            // InternalSasDsl.g:2259:2: (otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )+ otherlv_4= '}' )
            // InternalSasDsl.g:2260:3: otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLKnowledgeAccess().getKnowledgeKeyword_0());
            		
            // InternalSasDsl.g:2264:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2265:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2265:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2266:5: lv_name_1_0= RULE_ID
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
            		
            // InternalSasDsl.g:2286:3: ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==44) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalSasDsl.g:2287:4: (lv_referenceInput_3_0= ruleDSLReferenceInput )
            	    {
            	    // InternalSasDsl.g:2287:4: (lv_referenceInput_3_0= ruleDSLReferenceInput )
            	    // InternalSasDsl.g:2288:5: lv_referenceInput_3_0= ruleDSLReferenceInput
            	    {

            	    					newCompositeNode(grammarAccess.getDSLKnowledgeAccess().getReferenceInputDSLReferenceInputParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_39);
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
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getDSLKnowledgeAccess().getRightCurlyBracketKeyword_4());
            		

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
    // InternalSasDsl.g:2313:1: entryRuleDSLSensor returns [EObject current=null] : iv_ruleDSLSensor= ruleDSLSensor EOF ;
    public final EObject entryRuleDSLSensor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLSensor = null;


        try {
            // InternalSasDsl.g:2313:50: (iv_ruleDSLSensor= ruleDSLSensor EOF )
            // InternalSasDsl.g:2314:2: iv_ruleDSLSensor= ruleDSLSensor EOF
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
    // InternalSasDsl.g:2320:1: ruleDSLSensor returns [EObject current=null] : (otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLSensor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2326:2: ( (otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2327:2: (otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2327:2: (otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2328:3: otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLSensorAccess().getSensorKeyword_0());
            		
            // InternalSasDsl.g:2332:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2333:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2333:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2334:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_2); 

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
    // InternalSasDsl.g:2358:1: entryRuleDSLEffector returns [EObject current=null] : iv_ruleDSLEffector= ruleDSLEffector EOF ;
    public final EObject entryRuleDSLEffector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLEffector = null;


        try {
            // InternalSasDsl.g:2358:52: (iv_ruleDSLEffector= ruleDSLEffector EOF )
            // InternalSasDsl.g:2359:2: iv_ruleDSLEffector= ruleDSLEffector EOF
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
    // InternalSasDsl.g:2365:1: ruleDSLEffector returns [EObject current=null] : (otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLEffector() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2371:2: ( (otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2372:2: (otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2372:2: (otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2373:3: otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLEffectorAccess().getEffectorKeyword_0());
            		
            // InternalSasDsl.g:2377:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2378:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2378:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2379:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_2); 

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
    // InternalSasDsl.g:2403:1: entryRuleDSLReferenceInput returns [EObject current=null] : iv_ruleDSLReferenceInput= ruleDSLReferenceInput EOF ;
    public final EObject entryRuleDSLReferenceInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLReferenceInput = null;


        try {
            // InternalSasDsl.g:2403:58: (iv_ruleDSLReferenceInput= ruleDSLReferenceInput EOF )
            // InternalSasDsl.g:2404:2: iv_ruleDSLReferenceInput= ruleDSLReferenceInput EOF
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
    // InternalSasDsl.g:2410:1: ruleDSLReferenceInput returns [EObject current=null] : (otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLReferenceInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2416:2: ( (otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2417:2: (otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2417:2: (otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2418:3: otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLReferenceInputAccess().getReferenceInputKeyword_0());
            		
            // InternalSasDsl.g:2422:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2423:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2423:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2424:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_2); 

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
    // InternalSasDsl.g:2448:1: entryRuleDSLMeasuredOutput returns [EObject current=null] : iv_ruleDSLMeasuredOutput= ruleDSLMeasuredOutput EOF ;
    public final EObject entryRuleDSLMeasuredOutput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLMeasuredOutput = null;


        try {
            // InternalSasDsl.g:2448:58: (iv_ruleDSLMeasuredOutput= ruleDSLMeasuredOutput EOF )
            // InternalSasDsl.g:2449:2: iv_ruleDSLMeasuredOutput= ruleDSLMeasuredOutput EOF
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
    // InternalSasDsl.g:2455:1: ruleDSLMeasuredOutput returns [EObject current=null] : (otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLMeasuredOutput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2461:2: ( (otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2462:2: (otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2462:2: (otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2463:3: otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLMeasuredOutputAccess().getMeasuredOutputKeyword_0());
            		
            // InternalSasDsl.g:2467:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2468:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2468:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2469:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_2); 

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

    // Delegated rules


    protected DFA6 dfa6 = new DFA6(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\25\1\4\1\33\2\22\5\uffff";
    static final String dfa_3s = "\1\25\1\4\1\34\2\27\5\uffff";
    static final String dfa_4s = "\5\uffff\1\3\1\1\1\4\1\2\1\5";
    static final String dfa_5s = "\12\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\2",
            "\1\3\1\4",
            "\1\10\1\uffff\1\6\1\11\1\5\1\7",
            "\1\10\1\uffff\1\6\1\11\1\5\1\7",
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

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "687:2: ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( (lv_access_26_0= ruleDSLAccess ) ) otherlv_27= 'analyzer' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000040002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000016EA000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000001080002000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000001000002000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000280000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000200000002000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000E00000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000006000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000018000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000020000002000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000100000002000L});

}