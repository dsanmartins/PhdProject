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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Architecture'", "'{'", "'}'", "'Rules'", "'controller'", "'monitor'", "';'", "'analyzer'", "'planner'", "'executor'", "'sensor'", "'knowledge'", "'reference-input'", "'effector'", "'measured-output'", "'can-access'", "'cannot-access'", "'Managing'", "'Managed'", "'ManagerController'", "'typeOf'", "'Synchronized'", "'Coordinated'", "'Independent'", "'Controller'", "'Monitor'", "'Analyzer'", "'Planner'", "'Executor'", "'Knowledge'", "'Sensor'", "'Effector'", "'ReferenceInput'", "'MeasuredOutput'"
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

                if ( (LA1_0==28) ) {
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

                if ( (LA2_0==29) ) {
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

                if ( ((LA3_0>=15 && LA3_0<=16)||(LA3_0>=18 && LA3_0<=21)) ) {
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
    // InternalSasDsl.g:189:1: ruleDSLRules returns [EObject current=null] : (this_DSLRuleController_0= ruleDSLRuleController | this_DSLRuleMonitor_1= ruleDSLRuleMonitor | this_DSLRuleAnalyzer_2= ruleDSLRuleAnalyzer | this_DSLRulePlanner_3= ruleDSLRulePlanner | this_DSLRuleExecutor_4= ruleDSLRuleExecutor | this_DSLRuleMO_5= ruleDSLRuleMO ) ;
    public final EObject ruleDSLRules() throws RecognitionException {
        EObject current = null;

        EObject this_DSLRuleController_0 = null;

        EObject this_DSLRuleMonitor_1 = null;

        EObject this_DSLRuleAnalyzer_2 = null;

        EObject this_DSLRulePlanner_3 = null;

        EObject this_DSLRuleExecutor_4 = null;

        EObject this_DSLRuleMO_5 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:195:2: ( (this_DSLRuleController_0= ruleDSLRuleController | this_DSLRuleMonitor_1= ruleDSLRuleMonitor | this_DSLRuleAnalyzer_2= ruleDSLRuleAnalyzer | this_DSLRulePlanner_3= ruleDSLRulePlanner | this_DSLRuleExecutor_4= ruleDSLRuleExecutor | this_DSLRuleMO_5= ruleDSLRuleMO ) )
            // InternalSasDsl.g:196:2: (this_DSLRuleController_0= ruleDSLRuleController | this_DSLRuleMonitor_1= ruleDSLRuleMonitor | this_DSLRuleAnalyzer_2= ruleDSLRuleAnalyzer | this_DSLRulePlanner_3= ruleDSLRulePlanner | this_DSLRuleExecutor_4= ruleDSLRuleExecutor | this_DSLRuleMO_5= ruleDSLRuleMO )
            {
            // InternalSasDsl.g:196:2: (this_DSLRuleController_0= ruleDSLRuleController | this_DSLRuleMonitor_1= ruleDSLRuleMonitor | this_DSLRuleAnalyzer_2= ruleDSLRuleAnalyzer | this_DSLRulePlanner_3= ruleDSLRulePlanner | this_DSLRuleExecutor_4= ruleDSLRuleExecutor | this_DSLRuleMO_5= ruleDSLRuleMO )
            int alt4=6;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt4=1;
                }
                break;
            case 16:
                {
                alt4=2;
                }
                break;
            case 18:
                {
                alt4=3;
                }
                break;
            case 19:
                {
                alt4=4;
                }
                break;
            case 20:
                {
                alt4=5;
                }
                break;
            case 21:
                {
                alt4=6;
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


    // $ANTLR start "entryRuleDSLRuleController"
    // InternalSasDsl.g:254:1: entryRuleDSLRuleController returns [EObject current=null] : iv_ruleDSLRuleController= ruleDSLRuleController EOF ;
    public final EObject entryRuleDSLRuleController() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleController = null;


        try {
            // InternalSasDsl.g:254:58: (iv_ruleDSLRuleController= ruleDSLRuleController EOF )
            // InternalSasDsl.g:255:2: iv_ruleDSLRuleController= ruleDSLRuleController EOF
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
    // InternalSasDsl.g:261:1: ruleDSLRuleController returns [EObject current=null] : ( (otherlv_0= 'controller' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'controller' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'controller' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'controller' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) ) ;
    public final EObject ruleDSLRuleController() throws RecognitionException {
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
            // InternalSasDsl.g:267:2: ( ( (otherlv_0= 'controller' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'controller' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'controller' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'controller' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) ) )
            // InternalSasDsl.g:268:2: ( (otherlv_0= 'controller' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'controller' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'controller' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'controller' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) )
            {
            // InternalSasDsl.g:268:2: ( (otherlv_0= 'controller' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'controller' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'controller' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'controller' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) )
            int alt5=4;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==RULE_ID) ) {
                    int LA5_2 = input.LA(3);

                    if ( (LA5_2==26) ) {
                        switch ( input.LA(4) ) {
                        case 20:
                            {
                            alt5=4;
                            }
                            break;
                        case 18:
                            {
                            alt5=2;
                            }
                            break;
                        case 19:
                            {
                            alt5=3;
                            }
                            break;
                        case 16:
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
                    else if ( (LA5_2==27) ) {
                        switch ( input.LA(4) ) {
                        case 16:
                            {
                            alt5=1;
                            }
                            break;
                        case 20:
                            {
                            alt5=4;
                            }
                            break;
                        case 18:
                            {
                            alt5=2;
                            }
                            break;
                        case 19:
                            {
                            alt5=3;
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
                    // InternalSasDsl.g:269:3: (otherlv_0= 'controller' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:269:3: (otherlv_0= 'controller' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:270:4: otherlv_0= 'controller' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRuleControllerAccess().getControllerKeyword_0_0());
                    			
                    // InternalSasDsl.g:274:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:275:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:275:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:276:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleControllerRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRuleControllerAccess().getControllerDSLControllerCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:287:4: ( (lv_access_2_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:288:5: (lv_access_2_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:288:5: (lv_access_2_0= ruleDSLAccess )
                    // InternalSasDsl.g:289:6: lv_access_2_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleControllerAccess().getAccessDSLAccessParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_11);
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

                    otherlv_3=(Token)match(input,16,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDSLRuleControllerAccess().getMonitorKeyword_0_3());
                    			
                    // InternalSasDsl.g:310:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:311:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:311:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:312:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleControllerRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRuleControllerAccess().getMonitorDSLMonitorCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRuleControllerAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:329:3: (otherlv_6= 'controller' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:329:3: (otherlv_6= 'controller' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:330:4: otherlv_6= 'controller' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRuleControllerAccess().getControllerKeyword_1_0());
                    			
                    // InternalSasDsl.g:334:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:335:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:335:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:336:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleControllerRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRuleControllerAccess().getControllerDSLControllerCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:347:4: ( (lv_access_8_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:348:5: (lv_access_8_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:348:5: (lv_access_8_0= ruleDSLAccess )
                    // InternalSasDsl.g:349:6: lv_access_8_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleControllerAccess().getAccessDSLAccessParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_access_8_0=ruleDSLAccess();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSLRuleControllerRule());
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

                    				newLeafNode(otherlv_9, grammarAccess.getDSLRuleControllerAccess().getAnalyzerKeyword_1_3());
                    			
                    // InternalSasDsl.g:370:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:371:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:371:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:372:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleControllerRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRuleControllerAccess().getAnalyzerDSLAnalyzerCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRuleControllerAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:389:3: (otherlv_12= 'controller' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:389:3: (otherlv_12= 'controller' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:390:4: otherlv_12= 'controller' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRuleControllerAccess().getControllerKeyword_2_0());
                    			
                    // InternalSasDsl.g:394:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:395:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:395:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:396:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleControllerRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRuleControllerAccess().getControllerDSLControllerCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:407:4: ( (lv_access_14_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:408:5: (lv_access_14_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:408:5: (lv_access_14_0= ruleDSLAccess )
                    // InternalSasDsl.g:409:6: lv_access_14_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleControllerAccess().getAccessDSLAccessParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_access_14_0=ruleDSLAccess();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSLRuleControllerRule());
                    						}
                    						set(
                    							current,
                    							"access",
                    							lv_access_14_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_15=(Token)match(input,19,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getDSLRuleControllerAccess().getPlannerKeyword_2_3());
                    			
                    // InternalSasDsl.g:430:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:431:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:431:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:432:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleControllerRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRuleControllerAccess().getPlannerDSLPlannerCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRuleControllerAccess().getSemicolonKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:449:3: (otherlv_18= 'controller' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    {
                    // InternalSasDsl.g:449:3: (otherlv_18= 'controller' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    // InternalSasDsl.g:450:4: otherlv_18= 'controller' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';'
                    {
                    otherlv_18=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getDSLRuleControllerAccess().getControllerKeyword_3_0());
                    			
                    // InternalSasDsl.g:454:4: ( (otherlv_19= RULE_ID ) )
                    // InternalSasDsl.g:455:5: (otherlv_19= RULE_ID )
                    {
                    // InternalSasDsl.g:455:5: (otherlv_19= RULE_ID )
                    // InternalSasDsl.g:456:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleControllerRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_19, grammarAccess.getDSLRuleControllerAccess().getControllerDSLControllerCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:467:4: ( (lv_access_20_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:468:5: (lv_access_20_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:468:5: (lv_access_20_0= ruleDSLAccess )
                    // InternalSasDsl.g:469:6: lv_access_20_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleControllerAccess().getAccessDSLAccessParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_access_20_0=ruleDSLAccess();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDSLRuleControllerRule());
                    						}
                    						set(
                    							current,
                    							"access",
                    							lv_access_20_0,
                    							"br.ufscar.sas.xtext.sasdsl.SasDsl.DSLAccess");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_21=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_21, grammarAccess.getDSLRuleControllerAccess().getExecutorKeyword_3_3());
                    			
                    // InternalSasDsl.g:490:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSasDsl.g:491:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSasDsl.g:491:5: (otherlv_22= RULE_ID )
                    // InternalSasDsl.g:492:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleControllerRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_22, grammarAccess.getDSLRuleControllerAccess().getExecutorDSLExecutorCrossReference_3_4_0());
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_23, grammarAccess.getDSLRuleControllerAccess().getSemicolonKeyword_3_5());
                    			

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
    // $ANTLR end "ruleDSLRuleController"


    // $ANTLR start "entryRuleDSLRuleMonitor"
    // InternalSasDsl.g:512:1: entryRuleDSLRuleMonitor returns [EObject current=null] : iv_ruleDSLRuleMonitor= ruleDSLRuleMonitor EOF ;
    public final EObject entryRuleDSLRuleMonitor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleMonitor = null;


        try {
            // InternalSasDsl.g:512:55: (iv_ruleDSLRuleMonitor= ruleDSLRuleMonitor EOF )
            // InternalSasDsl.g:513:2: iv_ruleDSLRuleMonitor= ruleDSLRuleMonitor EOF
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
    // InternalSasDsl.g:519:1: ruleDSLRuleMonitor returns [EObject current=null] : ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'sensor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'knowledge' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'analyzer' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) ) ;
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
        AntlrDatatypeRuleToken lv_access_2_0 = null;

        AntlrDatatypeRuleToken lv_access_8_0 = null;

        AntlrDatatypeRuleToken lv_access_14_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:525:2: ( ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'sensor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'knowledge' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'analyzer' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) ) )
            // InternalSasDsl.g:526:2: ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'sensor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'knowledge' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'analyzer' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) )
            {
            // InternalSasDsl.g:526:2: ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'sensor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'knowledge' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'analyzer' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) )
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==RULE_ID) ) {
                    int LA6_2 = input.LA(3);

                    if ( (LA6_2==26) ) {
                        switch ( input.LA(4) ) {
                        case 18:
                            {
                            alt6=3;
                            }
                            break;
                        case 21:
                            {
                            alt6=1;
                            }
                            break;
                        case 22:
                            {
                            alt6=2;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 3, input);

                            throw nvae;
                        }

                    }
                    else if ( (LA6_2==27) ) {
                        switch ( input.LA(4) ) {
                        case 22:
                            {
                            alt6=2;
                            }
                            break;
                        case 18:
                            {
                            alt6=3;
                            }
                            break;
                        case 21:
                            {
                            alt6=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 4, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalSasDsl.g:527:3: (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'sensor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:527:3: (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'sensor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:528:4: otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'sensor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,16,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_0_0());
                    			
                    // InternalSasDsl.g:532:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:533:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:533:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:534:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:545:4: ( (lv_access_2_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:546:5: (lv_access_2_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:546:5: (lv_access_2_0= ruleDSLAccess )
                    // InternalSasDsl.g:547:6: lv_access_2_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleMonitorAccess().getAccessDSLAccessParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_16);
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

                    otherlv_3=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDSLRuleMonitorAccess().getSensorKeyword_0_3());
                    			
                    // InternalSasDsl.g:568:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:569:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:569:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:570:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRuleMonitorAccess().getSensorDSLSensorCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRuleMonitorAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:587:3: (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'knowledge' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:587:3: (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'knowledge' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:588:4: otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'knowledge' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,16,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_1_0());
                    			
                    // InternalSasDsl.g:592:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:593:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:593:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:594:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:605:4: ( (lv_access_8_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:606:5: (lv_access_8_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:606:5: (lv_access_8_0= ruleDSLAccess )
                    // InternalSasDsl.g:607:6: lv_access_8_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleMonitorAccess().getAccessDSLAccessParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_17);
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

                    otherlv_9=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getDSLRuleMonitorAccess().getKnowledgeKeyword_1_3());
                    			
                    // InternalSasDsl.g:628:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:629:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:629:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:630:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRuleMonitorAccess().getKnowledgeDSLKnowledgeCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRuleMonitorAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:647:3: (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'analyzer' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:647:3: (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'analyzer' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:648:4: otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'analyzer' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,16,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_2_0());
                    			
                    // InternalSasDsl.g:652:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:653:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:653:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:654:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:665:4: ( (lv_access_14_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:666:5: (lv_access_14_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:666:5: (lv_access_14_0= ruleDSLAccess )
                    // InternalSasDsl.g:667:6: lv_access_14_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleMonitorAccess().getAccessDSLAccessParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_13);
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

                    otherlv_15=(Token)match(input,18,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getDSLRuleMonitorAccess().getAnalyzerKeyword_2_3());
                    			
                    // InternalSasDsl.g:688:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:689:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:689:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:690:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRuleMonitorAccess().getAnalyzerDSLAnalyzerCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRuleMonitorAccess().getSemicolonKeyword_2_5());
                    			

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
    // InternalSasDsl.g:710:1: entryRuleDSLRuleAnalyzer returns [EObject current=null] : iv_ruleDSLRuleAnalyzer= ruleDSLRuleAnalyzer EOF ;
    public final EObject entryRuleDSLRuleAnalyzer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleAnalyzer = null;


        try {
            // InternalSasDsl.g:710:56: (iv_ruleDSLRuleAnalyzer= ruleDSLRuleAnalyzer EOF )
            // InternalSasDsl.g:711:2: iv_ruleDSLRuleAnalyzer= ruleDSLRuleAnalyzer EOF
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
    // InternalSasDsl.g:717:1: ruleDSLRuleAnalyzer returns [EObject current=null] : ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) ) ;
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
        AntlrDatatypeRuleToken lv_access_2_0 = null;

        AntlrDatatypeRuleToken lv_access_8_0 = null;

        AntlrDatatypeRuleToken lv_access_14_0 = null;

        AntlrDatatypeRuleToken lv_access_20_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:723:2: ( ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) ) )
            // InternalSasDsl.g:724:2: ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) )
            {
            // InternalSasDsl.g:724:2: ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) )
            int alt7=4;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_ID) ) {
                    int LA7_2 = input.LA(3);

                    if ( (LA7_2==26) ) {
                        switch ( input.LA(4) ) {
                        case 19:
                            {
                            alt7=3;
                            }
                            break;
                        case 22:
                            {
                            alt7=1;
                            }
                            break;
                        case 23:
                            {
                            alt7=4;
                            }
                            break;
                        case 16:
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
                    else if ( (LA7_2==27) ) {
                        switch ( input.LA(4) ) {
                        case 16:
                            {
                            alt7=2;
                            }
                            break;
                        case 19:
                            {
                            alt7=3;
                            }
                            break;
                        case 22:
                            {
                            alt7=1;
                            }
                            break;
                        case 23:
                            {
                            alt7=4;
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
                    // InternalSasDsl.g:725:3: (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:725:3: (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:726:4: otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,18,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_0_0());
                    			
                    // InternalSasDsl.g:730:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:731:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:731:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:732:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:743:4: ( (lv_access_2_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:744:5: (lv_access_2_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:744:5: (lv_access_2_0= ruleDSLAccess )
                    // InternalSasDsl.g:745:6: lv_access_2_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleAnalyzerAccess().getAccessDSLAccessParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_17);
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

                    otherlv_3=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDSLRuleAnalyzerAccess().getKnowledgeKeyword_0_3());
                    			
                    // InternalSasDsl.g:766:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:767:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:767:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:768:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRuleAnalyzerAccess().getKnowledgeDSLKnowledgeCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:785:3: (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:785:3: (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:786:4: otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'monitor' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,18,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_1_0());
                    			
                    // InternalSasDsl.g:790:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:791:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:791:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:792:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:803:4: ( (lv_access_8_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:804:5: (lv_access_8_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:804:5: (lv_access_8_0= ruleDSLAccess )
                    // InternalSasDsl.g:805:6: lv_access_8_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleAnalyzerAccess().getAccessDSLAccessParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_11);
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

                    otherlv_9=(Token)match(input,16,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getDSLRuleAnalyzerAccess().getMonitorKeyword_1_3());
                    			
                    // InternalSasDsl.g:826:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:827:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:827:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:828:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRuleAnalyzerAccess().getMonitorDSLMonitorCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:845:3: (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:845:3: (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:846:4: otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,18,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_2_0());
                    			
                    // InternalSasDsl.g:850:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:851:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:851:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:852:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:863:4: ( (lv_access_14_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:864:5: (lv_access_14_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:864:5: (lv_access_14_0= ruleDSLAccess )
                    // InternalSasDsl.g:865:6: lv_access_14_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleAnalyzerAccess().getAccessDSLAccessParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_14);
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

                    otherlv_15=(Token)match(input,19,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getDSLRuleAnalyzerAccess().getPlannerKeyword_2_3());
                    			
                    // InternalSasDsl.g:886:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:887:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:887:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:888:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRuleAnalyzerAccess().getPlannerDSLPlannerCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:905:3: (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    {
                    // InternalSasDsl.g:905:3: (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    // InternalSasDsl.g:906:4: otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( (lv_access_20_0= ruleDSLAccess ) ) otherlv_21= 'reference-input' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';'
                    {
                    otherlv_18=(Token)match(input,18,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_3_0());
                    			
                    // InternalSasDsl.g:910:4: ( (otherlv_19= RULE_ID ) )
                    // InternalSasDsl.g:911:5: (otherlv_19= RULE_ID )
                    {
                    // InternalSasDsl.g:911:5: (otherlv_19= RULE_ID )
                    // InternalSasDsl.g:912:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_19, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:923:4: ( (lv_access_20_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:924:5: (lv_access_20_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:924:5: (lv_access_20_0= ruleDSLAccess )
                    // InternalSasDsl.g:925:6: lv_access_20_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleAnalyzerAccess().getAccessDSLAccessParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_18);
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
                    			
                    // InternalSasDsl.g:946:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSasDsl.g:947:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSasDsl.g:947:5: (otherlv_22= RULE_ID )
                    // InternalSasDsl.g:948:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_22, grammarAccess.getDSLRuleAnalyzerAccess().getRreferenceDSLReferenceInputCrossReference_3_4_0());
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_23, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_3_5());
                    			

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
    // InternalSasDsl.g:968:1: entryRuleDSLRulePlanner returns [EObject current=null] : iv_ruleDSLRulePlanner= ruleDSLRulePlanner EOF ;
    public final EObject entryRuleDSLRulePlanner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRulePlanner = null;


        try {
            // InternalSasDsl.g:968:55: (iv_ruleDSLRulePlanner= ruleDSLRulePlanner EOF )
            // InternalSasDsl.g:969:2: iv_ruleDSLRulePlanner= ruleDSLRulePlanner EOF
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
    // InternalSasDsl.g:975:1: ruleDSLRulePlanner returns [EObject current=null] : ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) ) ;
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
        AntlrDatatypeRuleToken lv_access_2_0 = null;

        AntlrDatatypeRuleToken lv_access_8_0 = null;

        AntlrDatatypeRuleToken lv_access_14_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:981:2: ( ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) ) )
            // InternalSasDsl.g:982:2: ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) )
            {
            // InternalSasDsl.g:982:2: ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) )
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==RULE_ID) ) {
                    int LA8_2 = input.LA(3);

                    if ( (LA8_2==26) ) {
                        switch ( input.LA(4) ) {
                        case 18:
                            {
                            alt8=2;
                            }
                            break;
                        case 20:
                            {
                            alt8=3;
                            }
                            break;
                        case 22:
                            {
                            alt8=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 8, 3, input);

                            throw nvae;
                        }

                    }
                    else if ( (LA8_2==27) ) {
                        switch ( input.LA(4) ) {
                        case 20:
                            {
                            alt8=3;
                            }
                            break;
                        case 22:
                            {
                            alt8=1;
                            }
                            break;
                        case 18:
                            {
                            alt8=2;
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
                    // InternalSasDsl.g:983:3: (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:983:3: (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:984:4: otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,19,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_0_0());
                    			
                    // InternalSasDsl.g:988:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:989:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:989:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:990:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1001:4: ( (lv_access_2_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:1002:5: (lv_access_2_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:1002:5: (lv_access_2_0= ruleDSLAccess )
                    // InternalSasDsl.g:1003:6: lv_access_2_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRulePlannerAccess().getAccessDSLAccessParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_17);
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

                    otherlv_3=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDSLRulePlannerAccess().getKnowledgeKeyword_0_3());
                    			
                    // InternalSasDsl.g:1024:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:1025:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:1025:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:1026:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRulePlannerAccess().getKnowledgeDSLKnowledgeCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:1043:3: (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:1043:3: (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:1044:4: otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,19,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_1_0());
                    			
                    // InternalSasDsl.g:1048:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:1049:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:1049:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:1050:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1061:4: ( (lv_access_8_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:1062:5: (lv_access_8_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:1062:5: (lv_access_8_0= ruleDSLAccess )
                    // InternalSasDsl.g:1063:6: lv_access_8_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRulePlannerAccess().getAccessDSLAccessParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_13);
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

                    otherlv_9=(Token)match(input,18,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getDSLRulePlannerAccess().getAnalyzerKeyword_1_3());
                    			
                    // InternalSasDsl.g:1084:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:1085:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:1085:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:1086:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRulePlannerAccess().getAnalyzerDSLAnalyzerCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:1103:3: (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:1103:3: (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:1104:4: otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'executor' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,19,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_2_0());
                    			
                    // InternalSasDsl.g:1108:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:1109:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:1109:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:1110:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1121:4: ( (lv_access_14_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:1122:5: (lv_access_14_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:1122:5: (lv_access_14_0= ruleDSLAccess )
                    // InternalSasDsl.g:1123:6: lv_access_14_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRulePlannerAccess().getAccessDSLAccessParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_15);
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

                    otherlv_15=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getDSLRulePlannerAccess().getExecutorKeyword_2_3());
                    			
                    // InternalSasDsl.g:1144:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:1145:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:1145:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:1146:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRulePlannerAccess().getExecutorDSLExecutorCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_2_5());
                    			

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
    // InternalSasDsl.g:1166:1: entryRuleDSLRuleExecutor returns [EObject current=null] : iv_ruleDSLRuleExecutor= ruleDSLRuleExecutor EOF ;
    public final EObject entryRuleDSLRuleExecutor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleExecutor = null;


        try {
            // InternalSasDsl.g:1166:56: (iv_ruleDSLRuleExecutor= ruleDSLRuleExecutor EOF )
            // InternalSasDsl.g:1167:2: iv_ruleDSLRuleExecutor= ruleDSLRuleExecutor EOF
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
    // InternalSasDsl.g:1173:1: ruleDSLRuleExecutor returns [EObject current=null] : ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'effector' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'planner' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'knowledge' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) ) ;
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
        AntlrDatatypeRuleToken lv_access_2_0 = null;

        AntlrDatatypeRuleToken lv_access_8_0 = null;

        AntlrDatatypeRuleToken lv_access_14_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:1179:2: ( ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'effector' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'planner' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'knowledge' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) ) )
            // InternalSasDsl.g:1180:2: ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'effector' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'planner' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'knowledge' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) )
            {
            // InternalSasDsl.g:1180:2: ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'effector' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'planner' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'knowledge' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) )
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==20) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==RULE_ID) ) {
                    int LA9_2 = input.LA(3);

                    if ( (LA9_2==26) ) {
                        switch ( input.LA(4) ) {
                        case 19:
                            {
                            alt9=2;
                            }
                            break;
                        case 22:
                            {
                            alt9=3;
                            }
                            break;
                        case 24:
                            {
                            alt9=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 3, input);

                            throw nvae;
                        }

                    }
                    else if ( (LA9_2==27) ) {
                        switch ( input.LA(4) ) {
                        case 22:
                            {
                            alt9=3;
                            }
                            break;
                        case 24:
                            {
                            alt9=1;
                            }
                            break;
                        case 19:
                            {
                            alt9=2;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 4, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalSasDsl.g:1181:3: (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'effector' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:1181:3: (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'effector' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:1182:4: otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'effector' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_0_0());
                    			
                    // InternalSasDsl.g:1186:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:1187:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:1187:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:1188:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1199:4: ( (lv_access_2_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:1200:5: (lv_access_2_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:1200:5: (lv_access_2_0= ruleDSLAccess )
                    // InternalSasDsl.g:1201:6: lv_access_2_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleExecutorAccess().getAccessDSLAccessParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_19);
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

                    otherlv_3=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDSLRuleExecutorAccess().getEffectorKeyword_0_3());
                    			
                    // InternalSasDsl.g:1222:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:1223:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:1223:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:1224:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRuleExecutorAccess().getEffectorDSLEffectorCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRuleExecutorAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:1241:3: (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'planner' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:1241:3: (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'planner' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:1242:4: otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( (lv_access_8_0= ruleDSLAccess ) ) otherlv_9= 'planner' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_1_0());
                    			
                    // InternalSasDsl.g:1246:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:1247:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:1247:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:1248:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1259:4: ( (lv_access_8_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:1260:5: (lv_access_8_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:1260:5: (lv_access_8_0= ruleDSLAccess )
                    // InternalSasDsl.g:1261:6: lv_access_8_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleExecutorAccess().getAccessDSLAccessParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_14);
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

                    otherlv_9=(Token)match(input,19,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getDSLRuleExecutorAccess().getPlannerKeyword_1_3());
                    			
                    // InternalSasDsl.g:1282:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:1283:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:1283:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:1284:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRuleExecutorAccess().getPlannerDSLPlannerCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRuleExecutorAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:1301:3: (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'knowledge' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:1301:3: (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'knowledge' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:1302:4: otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( (lv_access_14_0= ruleDSLAccess ) ) otherlv_15= 'knowledge' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_2_0());
                    			
                    // InternalSasDsl.g:1306:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:1307:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:1307:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:1308:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1319:4: ( (lv_access_14_0= ruleDSLAccess ) )
                    // InternalSasDsl.g:1320:5: (lv_access_14_0= ruleDSLAccess )
                    {
                    // InternalSasDsl.g:1320:5: (lv_access_14_0= ruleDSLAccess )
                    // InternalSasDsl.g:1321:6: lv_access_14_0= ruleDSLAccess
                    {

                    						newCompositeNode(grammarAccess.getDSLRuleExecutorAccess().getAccessDSLAccessParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_17);
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

                    otherlv_15=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getDSLRuleExecutorAccess().getKnowledgeKeyword_2_3());
                    			
                    // InternalSasDsl.g:1342:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:1343:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:1343:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:1344:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRuleExecutorAccess().getKnowledgeDSLKnowledgeCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRuleExecutorAccess().getSemicolonKeyword_2_5());
                    			

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
    // InternalSasDsl.g:1364:1: entryRuleDSLRuleMO returns [EObject current=null] : iv_ruleDSLRuleMO= ruleDSLRuleMO EOF ;
    public final EObject entryRuleDSLRuleMO() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleMO = null;


        try {
            // InternalSasDsl.g:1364:50: (iv_ruleDSLRuleMO= ruleDSLRuleMO EOF )
            // InternalSasDsl.g:1365:2: iv_ruleDSLRuleMO= ruleDSLRuleMO EOF
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
    // InternalSasDsl.g:1371:1: ruleDSLRuleMO returns [EObject current=null] : (otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) ;
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
            // InternalSasDsl.g:1377:2: ( (otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) )
            // InternalSasDsl.g:1378:2: (otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            {
            // InternalSasDsl.g:1378:2: (otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            // InternalSasDsl.g:1379:3: otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( (lv_access_2_0= ruleDSLAccess ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLRuleMOAccess().getSensorKeyword_0());
            		
            // InternalSasDsl.g:1383:3: ( (otherlv_1= RULE_ID ) )
            // InternalSasDsl.g:1384:4: (otherlv_1= RULE_ID )
            {
            // InternalSasDsl.g:1384:4: (otherlv_1= RULE_ID )
            // InternalSasDsl.g:1385:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleMORule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(otherlv_1, grammarAccess.getDSLRuleMOAccess().getSensorDSLSensorCrossReference_1_0());
            				

            }


            }

            // InternalSasDsl.g:1396:3: ( (lv_access_2_0= ruleDSLAccess ) )
            // InternalSasDsl.g:1397:4: (lv_access_2_0= ruleDSLAccess )
            {
            // InternalSasDsl.g:1397:4: (lv_access_2_0= ruleDSLAccess )
            // InternalSasDsl.g:1398:5: lv_access_2_0= ruleDSLAccess
            {

            					newCompositeNode(grammarAccess.getDSLRuleMOAccess().getAccessDSLAccessParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_20);
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

            otherlv_3=(Token)match(input,25,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getDSLRuleMOAccess().getMeasuredOutputKeyword_3());
            		
            // InternalSasDsl.g:1419:3: ( (otherlv_4= RULE_ID ) )
            // InternalSasDsl.g:1420:4: (otherlv_4= RULE_ID )
            {
            // InternalSasDsl.g:1420:4: (otherlv_4= RULE_ID )
            // InternalSasDsl.g:1421:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleMORule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_4, grammarAccess.getDSLRuleMOAccess().getMeasuredDSLMeasuredOutputCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,17,FOLLOW_2); 

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
    // InternalSasDsl.g:1440:1: entryRuleDSLAccess returns [String current=null] : iv_ruleDSLAccess= ruleDSLAccess EOF ;
    public final String entryRuleDSLAccess() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDSLAccess = null;


        try {
            // InternalSasDsl.g:1440:49: (iv_ruleDSLAccess= ruleDSLAccess EOF )
            // InternalSasDsl.g:1441:2: iv_ruleDSLAccess= ruleDSLAccess EOF
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
    // InternalSasDsl.g:1447:1: ruleDSLAccess returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'can-access' | kw= 'cannot-access' ) ;
    public final AntlrDatatypeRuleToken ruleDSLAccess() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSasDsl.g:1453:2: ( (kw= 'can-access' | kw= 'cannot-access' ) )
            // InternalSasDsl.g:1454:2: (kw= 'can-access' | kw= 'cannot-access' )
            {
            // InternalSasDsl.g:1454:2: (kw= 'can-access' | kw= 'cannot-access' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==26) ) {
                alt10=1;
            }
            else if ( (LA10_0==27) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalSasDsl.g:1455:3: kw= 'can-access'
                    {
                    kw=(Token)match(input,26,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getDSLAccessAccess().getCanAccessKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:1461:3: kw= 'cannot-access'
                    {
                    kw=(Token)match(input,27,FOLLOW_2); 

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
    // InternalSasDsl.g:1470:1: entryRuleDSLManaging returns [EObject current=null] : iv_ruleDSLManaging= ruleDSLManaging EOF ;
    public final EObject entryRuleDSLManaging() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLManaging = null;


        try {
            // InternalSasDsl.g:1470:52: (iv_ruleDSLManaging= ruleDSLManaging EOF )
            // InternalSasDsl.g:1471:2: iv_ruleDSLManaging= ruleDSLManaging EOF
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
    // InternalSasDsl.g:1477:1: ruleDSLManaging returns [EObject current=null] : (otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )+ otherlv_5= '}' ) ;
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
            // InternalSasDsl.g:1483:2: ( (otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )+ otherlv_5= '}' ) )
            // InternalSasDsl.g:1484:2: (otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )+ otherlv_5= '}' )
            {
            // InternalSasDsl.g:1484:2: (otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )+ otherlv_5= '}' )
            // InternalSasDsl.g:1485:3: otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLManagingAccess().getManagingKeyword_0());
            		
            // InternalSasDsl.g:1489:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:1490:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:1490:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:1491:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,12,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLManagingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalSasDsl.g:1511:3: ( (lv_managerController_3_0= ruleDSLManagerController ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==30) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalSasDsl.g:1512:4: (lv_managerController_3_0= ruleDSLManagerController )
            	    {
            	    // InternalSasDsl.g:1512:4: (lv_managerController_3_0= ruleDSLManagerController )
            	    // InternalSasDsl.g:1513:5: lv_managerController_3_0= ruleDSLManagerController
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagingAccess().getManagerControllerDSLManagerControllerParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_21);
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
            	    break loop11;
                }
            } while (true);

            // InternalSasDsl.g:1530:3: ( (lv_controller_4_0= ruleDSLController ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==35) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalSasDsl.g:1531:4: (lv_controller_4_0= ruleDSLController )
            	    {
            	    // InternalSasDsl.g:1531:4: (lv_controller_4_0= ruleDSLController )
            	    // InternalSasDsl.g:1532:5: lv_controller_4_0= ruleDSLController
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagingAccess().getControllerDSLControllerParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_22);
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
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
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
    // InternalSasDsl.g:1557:1: entryRuleDSLManaged returns [EObject current=null] : iv_ruleDSLManaged= ruleDSLManaged EOF ;
    public final EObject entryRuleDSLManaged() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLManaged = null;


        try {
            // InternalSasDsl.g:1557:51: (iv_ruleDSLManaged= ruleDSLManaged EOF )
            // InternalSasDsl.g:1558:2: iv_ruleDSLManaged= ruleDSLManaged EOF
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
    // InternalSasDsl.g:1564:1: ruleDSLManaged returns [EObject current=null] : (otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )+ ( (lv_effector_4_0= ruleDSLEffector ) )+ ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )+ otherlv_6= '}' ) ;
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
            // InternalSasDsl.g:1570:2: ( (otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )+ ( (lv_effector_4_0= ruleDSLEffector ) )+ ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )+ otherlv_6= '}' ) )
            // InternalSasDsl.g:1571:2: (otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )+ ( (lv_effector_4_0= ruleDSLEffector ) )+ ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )+ otherlv_6= '}' )
            {
            // InternalSasDsl.g:1571:2: (otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )+ ( (lv_effector_4_0= ruleDSLEffector ) )+ ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )+ otherlv_6= '}' )
            // InternalSasDsl.g:1572:3: otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )+ ( (lv_effector_4_0= ruleDSLEffector ) )+ ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )+ otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLManagedAccess().getManagedKeyword_0());
            		
            // InternalSasDsl.g:1576:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:1577:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:1577:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:1578:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,12,FOLLOW_23); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLManagedAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalSasDsl.g:1598:3: ( (lv_sensor_3_0= ruleDSLSensor ) )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==41) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalSasDsl.g:1599:4: (lv_sensor_3_0= ruleDSLSensor )
            	    {
            	    // InternalSasDsl.g:1599:4: (lv_sensor_3_0= ruleDSLSensor )
            	    // InternalSasDsl.g:1600:5: lv_sensor_3_0= ruleDSLSensor
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagedAccess().getSensorDSLSensorParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_24);
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
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            // InternalSasDsl.g:1617:3: ( (lv_effector_4_0= ruleDSLEffector ) )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==42) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalSasDsl.g:1618:4: (lv_effector_4_0= ruleDSLEffector )
            	    {
            	    // InternalSasDsl.g:1618:4: (lv_effector_4_0= ruleDSLEffector )
            	    // InternalSasDsl.g:1619:5: lv_effector_4_0= ruleDSLEffector
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagedAccess().getEffectorDSLEffectorParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_25);
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
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);

            // InternalSasDsl.g:1636:3: ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==44) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalSasDsl.g:1637:4: (lv_measuredOutput_5_0= ruleDSLMeasuredOutput )
            	    {
            	    // InternalSasDsl.g:1637:4: (lv_measuredOutput_5_0= ruleDSLMeasuredOutput )
            	    // InternalSasDsl.g:1638:5: lv_measuredOutput_5_0= ruleDSLMeasuredOutput
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagedAccess().getMeasuredOutputDSLMeasuredOutputParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_26);
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
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
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
    // InternalSasDsl.g:1663:1: entryRuleDSLManagerController returns [EObject current=null] : iv_ruleDSLManagerController= ruleDSLManagerController EOF ;
    public final EObject entryRuleDSLManagerController() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLManagerController = null;


        try {
            // InternalSasDsl.g:1663:61: (iv_ruleDSLManagerController= ruleDSLManagerController EOF )
            // InternalSasDsl.g:1664:2: iv_ruleDSLManagerController= ruleDSLManagerController EOF
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
    // InternalSasDsl.g:1670:1: ruleDSLManagerController returns [EObject current=null] : (otherlv_0= 'ManagerController' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'typeOf' ruleDSLTypeMC otherlv_4= '{' ( (lv_controller_5_0= ruleDSLController ) )+ otherlv_6= '}' ) ;
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
            // InternalSasDsl.g:1676:2: ( (otherlv_0= 'ManagerController' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'typeOf' ruleDSLTypeMC otherlv_4= '{' ( (lv_controller_5_0= ruleDSLController ) )+ otherlv_6= '}' ) )
            // InternalSasDsl.g:1677:2: (otherlv_0= 'ManagerController' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'typeOf' ruleDSLTypeMC otherlv_4= '{' ( (lv_controller_5_0= ruleDSLController ) )+ otherlv_6= '}' )
            {
            // InternalSasDsl.g:1677:2: (otherlv_0= 'ManagerController' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'typeOf' ruleDSLTypeMC otherlv_4= '{' ( (lv_controller_5_0= ruleDSLController ) )+ otherlv_6= '}' )
            // InternalSasDsl.g:1678:3: otherlv_0= 'ManagerController' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'typeOf' ruleDSLTypeMC otherlv_4= '{' ( (lv_controller_5_0= ruleDSLController ) )+ otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLManagerControllerAccess().getManagerControllerKeyword_0());
            		
            // InternalSasDsl.g:1682:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:1683:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:1683:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:1684:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_27); 

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

            otherlv_2=(Token)match(input,31,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLManagerControllerAccess().getTypeOfKeyword_2());
            		

            			newCompositeNode(grammarAccess.getDSLManagerControllerAccess().getDSLTypeMCParserRuleCall_3());
            		
            pushFollow(FOLLOW_4);
            ruleDSLTypeMC();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            otherlv_4=(Token)match(input,12,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getDSLManagerControllerAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalSasDsl.g:1715:3: ( (lv_controller_5_0= ruleDSLController ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==35) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalSasDsl.g:1716:4: (lv_controller_5_0= ruleDSLController )
            	    {
            	    // InternalSasDsl.g:1716:4: (lv_controller_5_0= ruleDSLController )
            	    // InternalSasDsl.g:1717:5: lv_controller_5_0= ruleDSLController
            	    {

            	    					newCompositeNode(grammarAccess.getDSLManagerControllerAccess().getControllerDSLControllerParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_22);
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
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
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
    // InternalSasDsl.g:1742:1: entryRuleDSLTypeMC returns [String current=null] : iv_ruleDSLTypeMC= ruleDSLTypeMC EOF ;
    public final String entryRuleDSLTypeMC() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDSLTypeMC = null;


        try {
            // InternalSasDsl.g:1742:49: (iv_ruleDSLTypeMC= ruleDSLTypeMC EOF )
            // InternalSasDsl.g:1743:2: iv_ruleDSLTypeMC= ruleDSLTypeMC EOF
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
    // InternalSasDsl.g:1749:1: ruleDSLTypeMC returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Synchronized' | kw= 'Coordinated' | kw= 'Independent' ) ;
    public final AntlrDatatypeRuleToken ruleDSLTypeMC() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSasDsl.g:1755:2: ( (kw= 'Synchronized' | kw= 'Coordinated' | kw= 'Independent' ) )
            // InternalSasDsl.g:1756:2: (kw= 'Synchronized' | kw= 'Coordinated' | kw= 'Independent' )
            {
            // InternalSasDsl.g:1756:2: (kw= 'Synchronized' | kw= 'Coordinated' | kw= 'Independent' )
            int alt17=3;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt17=1;
                }
                break;
            case 33:
                {
                alt17=2;
                }
                break;
            case 34:
                {
                alt17=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalSasDsl.g:1757:3: kw= 'Synchronized'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getDSLTypeMCAccess().getSynchronizedKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:1763:3: kw= 'Coordinated'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getDSLTypeMCAccess().getCoordinatedKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:1769:3: kw= 'Independent'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); 

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
    // InternalSasDsl.g:1778:1: entryRuleDSLController returns [EObject current=null] : iv_ruleDSLController= ruleDSLController EOF ;
    public final EObject entryRuleDSLController() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLController = null;


        try {
            // InternalSasDsl.g:1778:54: (iv_ruleDSLController= ruleDSLController EOF )
            // InternalSasDsl.g:1779:2: iv_ruleDSLController= ruleDSLController EOF
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
    // InternalSasDsl.g:1785:1: ruleDSLController returns [EObject current=null] : (otherlv_0= 'Controller' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_monitor_3_0= ruleDSLMonitor ) )+ ( (lv_analyzer_4_0= ruleDSLAnalyzer ) )+ ( (lv_planner_5_0= ruleDSLPlanner ) )+ ( (lv_executor_6_0= ruleDSLExecutor ) )+ ( (lv_knowledge_7_0= ruleDSLKnowledge ) )+ otherlv_8= '}' ) ;
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
            // InternalSasDsl.g:1791:2: ( (otherlv_0= 'Controller' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_monitor_3_0= ruleDSLMonitor ) )+ ( (lv_analyzer_4_0= ruleDSLAnalyzer ) )+ ( (lv_planner_5_0= ruleDSLPlanner ) )+ ( (lv_executor_6_0= ruleDSLExecutor ) )+ ( (lv_knowledge_7_0= ruleDSLKnowledge ) )+ otherlv_8= '}' ) )
            // InternalSasDsl.g:1792:2: (otherlv_0= 'Controller' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_monitor_3_0= ruleDSLMonitor ) )+ ( (lv_analyzer_4_0= ruleDSLAnalyzer ) )+ ( (lv_planner_5_0= ruleDSLPlanner ) )+ ( (lv_executor_6_0= ruleDSLExecutor ) )+ ( (lv_knowledge_7_0= ruleDSLKnowledge ) )+ otherlv_8= '}' )
            {
            // InternalSasDsl.g:1792:2: (otherlv_0= 'Controller' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_monitor_3_0= ruleDSLMonitor ) )+ ( (lv_analyzer_4_0= ruleDSLAnalyzer ) )+ ( (lv_planner_5_0= ruleDSLPlanner ) )+ ( (lv_executor_6_0= ruleDSLExecutor ) )+ ( (lv_knowledge_7_0= ruleDSLKnowledge ) )+ otherlv_8= '}' )
            // InternalSasDsl.g:1793:3: otherlv_0= 'Controller' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_monitor_3_0= ruleDSLMonitor ) )+ ( (lv_analyzer_4_0= ruleDSLAnalyzer ) )+ ( (lv_planner_5_0= ruleDSLPlanner ) )+ ( (lv_executor_6_0= ruleDSLExecutor ) )+ ( (lv_knowledge_7_0= ruleDSLKnowledge ) )+ otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLControllerAccess().getControllerKeyword_0());
            		
            // InternalSasDsl.g:1797:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:1798:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:1798:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:1799:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,12,FOLLOW_29); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLControllerAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalSasDsl.g:1819:3: ( (lv_monitor_3_0= ruleDSLMonitor ) )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==36) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalSasDsl.g:1820:4: (lv_monitor_3_0= ruleDSLMonitor )
            	    {
            	    // InternalSasDsl.g:1820:4: (lv_monitor_3_0= ruleDSLMonitor )
            	    // InternalSasDsl.g:1821:5: lv_monitor_3_0= ruleDSLMonitor
            	    {

            	    					newCompositeNode(grammarAccess.getDSLControllerAccess().getMonitorDSLMonitorParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_30);
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
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);

            // InternalSasDsl.g:1838:3: ( (lv_analyzer_4_0= ruleDSLAnalyzer ) )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==37) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalSasDsl.g:1839:4: (lv_analyzer_4_0= ruleDSLAnalyzer )
            	    {
            	    // InternalSasDsl.g:1839:4: (lv_analyzer_4_0= ruleDSLAnalyzer )
            	    // InternalSasDsl.g:1840:5: lv_analyzer_4_0= ruleDSLAnalyzer
            	    {

            	    					newCompositeNode(grammarAccess.getDSLControllerAccess().getAnalyzerDSLAnalyzerParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_31);
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
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);

            // InternalSasDsl.g:1857:3: ( (lv_planner_5_0= ruleDSLPlanner ) )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==38) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalSasDsl.g:1858:4: (lv_planner_5_0= ruleDSLPlanner )
            	    {
            	    // InternalSasDsl.g:1858:4: (lv_planner_5_0= ruleDSLPlanner )
            	    // InternalSasDsl.g:1859:5: lv_planner_5_0= ruleDSLPlanner
            	    {

            	    					newCompositeNode(grammarAccess.getDSLControllerAccess().getPlannerDSLPlannerParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_32);
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
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);

            // InternalSasDsl.g:1876:3: ( (lv_executor_6_0= ruleDSLExecutor ) )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==39) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalSasDsl.g:1877:4: (lv_executor_6_0= ruleDSLExecutor )
            	    {
            	    // InternalSasDsl.g:1877:4: (lv_executor_6_0= ruleDSLExecutor )
            	    // InternalSasDsl.g:1878:5: lv_executor_6_0= ruleDSLExecutor
            	    {

            	    					newCompositeNode(grammarAccess.getDSLControllerAccess().getExecutorDSLExecutorParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_33);
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
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);

            // InternalSasDsl.g:1895:3: ( (lv_knowledge_7_0= ruleDSLKnowledge ) )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==40) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalSasDsl.g:1896:4: (lv_knowledge_7_0= ruleDSLKnowledge )
            	    {
            	    // InternalSasDsl.g:1896:4: (lv_knowledge_7_0= ruleDSLKnowledge )
            	    // InternalSasDsl.g:1897:5: lv_knowledge_7_0= ruleDSLKnowledge
            	    {

            	    					newCompositeNode(grammarAccess.getDSLControllerAccess().getKnowledgeDSLKnowledgeParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_34);
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
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
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
    // InternalSasDsl.g:1922:1: entryRuleDSLMonitor returns [EObject current=null] : iv_ruleDSLMonitor= ruleDSLMonitor EOF ;
    public final EObject entryRuleDSLMonitor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLMonitor = null;


        try {
            // InternalSasDsl.g:1922:51: (iv_ruleDSLMonitor= ruleDSLMonitor EOF )
            // InternalSasDsl.g:1923:2: iv_ruleDSLMonitor= ruleDSLMonitor EOF
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
    // InternalSasDsl.g:1929:1: ruleDSLMonitor returns [EObject current=null] : (otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLMonitor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:1935:2: ( (otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:1936:2: (otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:1936:2: (otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:1937:3: otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLMonitorAccess().getMonitorKeyword_0());
            		
            // InternalSasDsl.g:1941:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:1942:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:1942:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:1943:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,17,FOLLOW_2); 

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
    // InternalSasDsl.g:1967:1: entryRuleDSLAnalyzer returns [EObject current=null] : iv_ruleDSLAnalyzer= ruleDSLAnalyzer EOF ;
    public final EObject entryRuleDSLAnalyzer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLAnalyzer = null;


        try {
            // InternalSasDsl.g:1967:52: (iv_ruleDSLAnalyzer= ruleDSLAnalyzer EOF )
            // InternalSasDsl.g:1968:2: iv_ruleDSLAnalyzer= ruleDSLAnalyzer EOF
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
    // InternalSasDsl.g:1974:1: ruleDSLAnalyzer returns [EObject current=null] : (otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLAnalyzer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:1980:2: ( (otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:1981:2: (otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:1981:2: (otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:1982:3: otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLAnalyzerAccess().getAnalyzerKeyword_0());
            		
            // InternalSasDsl.g:1986:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:1987:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:1987:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:1988:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,17,FOLLOW_2); 

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
    // InternalSasDsl.g:2012:1: entryRuleDSLPlanner returns [EObject current=null] : iv_ruleDSLPlanner= ruleDSLPlanner EOF ;
    public final EObject entryRuleDSLPlanner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLPlanner = null;


        try {
            // InternalSasDsl.g:2012:51: (iv_ruleDSLPlanner= ruleDSLPlanner EOF )
            // InternalSasDsl.g:2013:2: iv_ruleDSLPlanner= ruleDSLPlanner EOF
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
    // InternalSasDsl.g:2019:1: ruleDSLPlanner returns [EObject current=null] : (otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLPlanner() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2025:2: ( (otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2026:2: (otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2026:2: (otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2027:3: otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLPlannerAccess().getPlannerKeyword_0());
            		
            // InternalSasDsl.g:2031:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2032:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2032:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2033:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,17,FOLLOW_2); 

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
    // InternalSasDsl.g:2057:1: entryRuleDSLExecutor returns [EObject current=null] : iv_ruleDSLExecutor= ruleDSLExecutor EOF ;
    public final EObject entryRuleDSLExecutor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLExecutor = null;


        try {
            // InternalSasDsl.g:2057:52: (iv_ruleDSLExecutor= ruleDSLExecutor EOF )
            // InternalSasDsl.g:2058:2: iv_ruleDSLExecutor= ruleDSLExecutor EOF
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
    // InternalSasDsl.g:2064:1: ruleDSLExecutor returns [EObject current=null] : (otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLExecutor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2070:2: ( (otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2071:2: (otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2071:2: (otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2072:3: otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLExecutorAccess().getExecutorKeyword_0());
            		
            // InternalSasDsl.g:2076:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2077:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2077:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2078:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,17,FOLLOW_2); 

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
    // InternalSasDsl.g:2102:1: entryRuleDSLKnowledge returns [EObject current=null] : iv_ruleDSLKnowledge= ruleDSLKnowledge EOF ;
    public final EObject entryRuleDSLKnowledge() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLKnowledge = null;


        try {
            // InternalSasDsl.g:2102:53: (iv_ruleDSLKnowledge= ruleDSLKnowledge EOF )
            // InternalSasDsl.g:2103:2: iv_ruleDSLKnowledge= ruleDSLKnowledge EOF
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
    // InternalSasDsl.g:2109:1: ruleDSLKnowledge returns [EObject current=null] : (otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )+ otherlv_4= '}' ) ;
    public final EObject ruleDSLKnowledge() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_referenceInput_3_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:2115:2: ( (otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )+ otherlv_4= '}' ) )
            // InternalSasDsl.g:2116:2: (otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )+ otherlv_4= '}' )
            {
            // InternalSasDsl.g:2116:2: (otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )+ otherlv_4= '}' )
            // InternalSasDsl.g:2117:3: otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLKnowledgeAccess().getKnowledgeKeyword_0());
            		
            // InternalSasDsl.g:2121:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2122:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2122:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2123:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,12,FOLLOW_35); 

            			newLeafNode(otherlv_2, grammarAccess.getDSLKnowledgeAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalSasDsl.g:2143:3: ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==43) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalSasDsl.g:2144:4: (lv_referenceInput_3_0= ruleDSLReferenceInput )
            	    {
            	    // InternalSasDsl.g:2144:4: (lv_referenceInput_3_0= ruleDSLReferenceInput )
            	    // InternalSasDsl.g:2145:5: lv_referenceInput_3_0= ruleDSLReferenceInput
            	    {

            	    					newCompositeNode(grammarAccess.getDSLKnowledgeAccess().getReferenceInputDSLReferenceInputParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_36);
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
            	    if ( cnt23 >= 1 ) break loop23;
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
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
    // InternalSasDsl.g:2170:1: entryRuleDSLSensor returns [EObject current=null] : iv_ruleDSLSensor= ruleDSLSensor EOF ;
    public final EObject entryRuleDSLSensor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLSensor = null;


        try {
            // InternalSasDsl.g:2170:50: (iv_ruleDSLSensor= ruleDSLSensor EOF )
            // InternalSasDsl.g:2171:2: iv_ruleDSLSensor= ruleDSLSensor EOF
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
    // InternalSasDsl.g:2177:1: ruleDSLSensor returns [EObject current=null] : (otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLSensor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2183:2: ( (otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2184:2: (otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2184:2: (otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2185:3: otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLSensorAccess().getSensorKeyword_0());
            		
            // InternalSasDsl.g:2189:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2190:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2190:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2191:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,17,FOLLOW_2); 

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
    // InternalSasDsl.g:2215:1: entryRuleDSLEffector returns [EObject current=null] : iv_ruleDSLEffector= ruleDSLEffector EOF ;
    public final EObject entryRuleDSLEffector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLEffector = null;


        try {
            // InternalSasDsl.g:2215:52: (iv_ruleDSLEffector= ruleDSLEffector EOF )
            // InternalSasDsl.g:2216:2: iv_ruleDSLEffector= ruleDSLEffector EOF
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
    // InternalSasDsl.g:2222:1: ruleDSLEffector returns [EObject current=null] : (otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLEffector() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2228:2: ( (otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2229:2: (otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2229:2: (otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2230:3: otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLEffectorAccess().getEffectorKeyword_0());
            		
            // InternalSasDsl.g:2234:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2235:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2235:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2236:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,17,FOLLOW_2); 

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
    // InternalSasDsl.g:2260:1: entryRuleDSLReferenceInput returns [EObject current=null] : iv_ruleDSLReferenceInput= ruleDSLReferenceInput EOF ;
    public final EObject entryRuleDSLReferenceInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLReferenceInput = null;


        try {
            // InternalSasDsl.g:2260:58: (iv_ruleDSLReferenceInput= ruleDSLReferenceInput EOF )
            // InternalSasDsl.g:2261:2: iv_ruleDSLReferenceInput= ruleDSLReferenceInput EOF
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
    // InternalSasDsl.g:2267:1: ruleDSLReferenceInput returns [EObject current=null] : (otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLReferenceInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2273:2: ( (otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2274:2: (otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2274:2: (otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2275:3: otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLReferenceInputAccess().getReferenceInputKeyword_0());
            		
            // InternalSasDsl.g:2279:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2280:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2280:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2281:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,17,FOLLOW_2); 

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
    // InternalSasDsl.g:2305:1: entryRuleDSLMeasuredOutput returns [EObject current=null] : iv_ruleDSLMeasuredOutput= ruleDSLMeasuredOutput EOF ;
    public final EObject entryRuleDSLMeasuredOutput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLMeasuredOutput = null;


        try {
            // InternalSasDsl.g:2305:58: (iv_ruleDSLMeasuredOutput= ruleDSLMeasuredOutput EOF )
            // InternalSasDsl.g:2306:2: iv_ruleDSLMeasuredOutput= ruleDSLMeasuredOutput EOF
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
    // InternalSasDsl.g:2312:1: ruleDSLMeasuredOutput returns [EObject current=null] : (otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLMeasuredOutput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:2318:2: ( (otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:2319:2: (otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:2319:2: (otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:2320:3: otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLMeasuredOutputAccess().getMeasuredOutputKeyword_0());
            		
            // InternalSasDsl.g:2324:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2325:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2325:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2326:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,17,FOLLOW_2); 

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


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000020002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000003DA000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000840000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000840002000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000100000002000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000700000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000006000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000018000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000010000002000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000080000002000L});

}