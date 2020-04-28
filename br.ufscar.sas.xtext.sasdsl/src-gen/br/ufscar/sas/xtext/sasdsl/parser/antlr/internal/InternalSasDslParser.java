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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Architecture'", "'{'", "'}'", "'Rules'", "'loopManager'", "'must-use'", "'must-not-use'", "';'", "'loop'", "'monitor'", "'analyzer'", "'planner'", "'executor'", "'knowledge'", "'sensor'", "'reference-input'", "'alternative'", "'effector'", "'measured-output'", "'Managing'", "'Managed'", "'LoopManager'", "'Loop'", "'withDomainRules'", "'Monitor'", "'Analyzer'", "'Planner'", "'Executor'", "'Knowledge'", "'Sensor'", "'Effector'", "'ReferenceInput'", "'MeasuredOutput'", "'Alternative'"
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
    // InternalSasDsl.g:189:1: ruleDSLRules returns [EObject current=null] : (this_DSLRuleController_0= ruleDSLRuleController | this_DSLRuleMonitor_1= ruleDSLRuleMonitor | this_DSLRuleAnalyzer_2= ruleDSLRuleAnalyzer | this_DSLRulePlanner_3= ruleDSLRulePlanner | this_DSLRuleExecutor_4= ruleDSLRuleExecutor | this_DSLRuleMO_5= ruleDSLRuleMO | this_DSLRuleMController_6= ruleDSLRuleMController | this_DSLRuleKnowledge_7= ruleDSLRuleKnowledge ) ;
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
            // InternalSasDsl.g:195:2: ( (this_DSLRuleController_0= ruleDSLRuleController | this_DSLRuleMonitor_1= ruleDSLRuleMonitor | this_DSLRuleAnalyzer_2= ruleDSLRuleAnalyzer | this_DSLRulePlanner_3= ruleDSLRulePlanner | this_DSLRuleExecutor_4= ruleDSLRuleExecutor | this_DSLRuleMO_5= ruleDSLRuleMO | this_DSLRuleMController_6= ruleDSLRuleMController | this_DSLRuleKnowledge_7= ruleDSLRuleKnowledge ) )
            // InternalSasDsl.g:196:2: (this_DSLRuleController_0= ruleDSLRuleController | this_DSLRuleMonitor_1= ruleDSLRuleMonitor | this_DSLRuleAnalyzer_2= ruleDSLRuleAnalyzer | this_DSLRulePlanner_3= ruleDSLRulePlanner | this_DSLRuleExecutor_4= ruleDSLRuleExecutor | this_DSLRuleMO_5= ruleDSLRuleMO | this_DSLRuleMController_6= ruleDSLRuleMController | this_DSLRuleKnowledge_7= ruleDSLRuleKnowledge )
            {
            // InternalSasDsl.g:196:2: (this_DSLRuleController_0= ruleDSLRuleController | this_DSLRuleMonitor_1= ruleDSLRuleMonitor | this_DSLRuleAnalyzer_2= ruleDSLRuleAnalyzer | this_DSLRulePlanner_3= ruleDSLRulePlanner | this_DSLRuleExecutor_4= ruleDSLRuleExecutor | this_DSLRuleMO_5= ruleDSLRuleMO | this_DSLRuleMController_6= ruleDSLRuleMController | this_DSLRuleKnowledge_7= ruleDSLRuleKnowledge )
            int alt4=8;
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
            case 23:
                {
                alt4=5;
                }
                break;
            case 25:
                {
                alt4=6;
                }
                break;
            case 15:
                {
                alt4=7;
                }
                break;
            case 24:
                {
                alt4=8;
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
                case 8 :
                    // InternalSasDsl.g:260:3: this_DSLRuleKnowledge_7= ruleDSLRuleKnowledge
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
    // InternalSasDsl.g:272:1: entryRuleDSLRuleMController returns [EObject current=null] : iv_ruleDSLRuleMController= ruleDSLRuleMController EOF ;
    public final EObject entryRuleDSLRuleMController() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleMController = null;


        try {
            // InternalSasDsl.g:272:59: (iv_ruleDSLRuleMController= ruleDSLRuleMController EOF )
            // InternalSasDsl.g:273:2: iv_ruleDSLRuleMController= ruleDSLRuleMController EOF
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
    // InternalSasDsl.g:279:1: ruleDSLRuleMController returns [EObject current=null] : (otherlv_0= 'loopManager' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loopManager' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) ;
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
            // InternalSasDsl.g:285:2: ( (otherlv_0= 'loopManager' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loopManager' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) )
            // InternalSasDsl.g:286:2: (otherlv_0= 'loopManager' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loopManager' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            {
            // InternalSasDsl.g:286:2: (otherlv_0= 'loopManager' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loopManager' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            // InternalSasDsl.g:287:3: otherlv_0= 'loopManager' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loopManager' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLRuleMControllerAccess().getLoopManagerKeyword_0());
            		
            // InternalSasDsl.g:291:3: ( (otherlv_1= RULE_ID ) )
            // InternalSasDsl.g:292:4: (otherlv_1= RULE_ID )
            {
            // InternalSasDsl.g:292:4: (otherlv_1= RULE_ID )
            // InternalSasDsl.g:293:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleMControllerRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(otherlv_1, grammarAccess.getDSLRuleMControllerAccess().getMcontroller1DSLManagerControllerCrossReference_1_0());
            				

            }


            }

            // InternalSasDsl.g:304:3: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
            // InternalSasDsl.g:305:4: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
            {
            // InternalSasDsl.g:305:4: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
            // InternalSasDsl.g:306:5: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
            {
            // InternalSasDsl.g:306:5: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
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
                    // InternalSasDsl.g:307:6: lv_access_2_1= 'must-use'
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
                    // InternalSasDsl.g:318:6: lv_access_2_2= 'must-not-use'
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
            		
            // InternalSasDsl.g:335:3: ( (otherlv_4= RULE_ID ) )
            // InternalSasDsl.g:336:4: (otherlv_4= RULE_ID )
            {
            // InternalSasDsl.g:336:4: (otherlv_4= RULE_ID )
            // InternalSasDsl.g:337:5: otherlv_4= RULE_ID
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
    // InternalSasDsl.g:356:1: entryRuleDSLRuleController returns [EObject current=null] : iv_ruleDSLRuleController= ruleDSLRuleController EOF ;
    public final EObject entryRuleDSLRuleController() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleController = null;


        try {
            // InternalSasDsl.g:356:58: (iv_ruleDSLRuleController= ruleDSLRuleController EOF )
            // InternalSasDsl.g:357:2: iv_ruleDSLRuleController= ruleDSLRuleController EOF
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
    // InternalSasDsl.g:363:1: ruleDSLRuleController returns [EObject current=null] : (otherlv_0= 'loop' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loop' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) ;
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
            // InternalSasDsl.g:369:2: ( (otherlv_0= 'loop' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loop' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) )
            // InternalSasDsl.g:370:2: (otherlv_0= 'loop' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loop' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            {
            // InternalSasDsl.g:370:2: (otherlv_0= 'loop' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loop' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            // InternalSasDsl.g:371:3: otherlv_0= 'loop' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'loop' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLRuleControllerAccess().getLoopKeyword_0());
            		
            // InternalSasDsl.g:375:3: ( (otherlv_1= RULE_ID ) )
            // InternalSasDsl.g:376:4: (otherlv_1= RULE_ID )
            {
            // InternalSasDsl.g:376:4: (otherlv_1= RULE_ID )
            // InternalSasDsl.g:377:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleControllerRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(otherlv_1, grammarAccess.getDSLRuleControllerAccess().getController1DSLControllerCrossReference_1_0());
            				

            }


            }

            // InternalSasDsl.g:388:3: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
            // InternalSasDsl.g:389:4: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
            {
            // InternalSasDsl.g:389:4: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
            // InternalSasDsl.g:390:5: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
            {
            // InternalSasDsl.g:390:5: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
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
                    // InternalSasDsl.g:391:6: lv_access_2_1= 'must-use'
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
                    // InternalSasDsl.g:402:6: lv_access_2_2= 'must-not-use'
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
            		
            // InternalSasDsl.g:419:3: ( (otherlv_4= RULE_ID ) )
            // InternalSasDsl.g:420:4: (otherlv_4= RULE_ID )
            {
            // InternalSasDsl.g:420:4: (otherlv_4= RULE_ID )
            // InternalSasDsl.g:421:5: otherlv_4= RULE_ID
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
    // InternalSasDsl.g:440:1: entryRuleDSLRuleMonitor returns [EObject current=null] : iv_ruleDSLRuleMonitor= ruleDSLRuleMonitor EOF ;
    public final EObject entryRuleDSLRuleMonitor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleMonitor = null;


        try {
            // InternalSasDsl.g:440:55: (iv_ruleDSLRuleMonitor= ruleDSLRuleMonitor EOF )
            // InternalSasDsl.g:441:2: iv_ruleDSLRuleMonitor= ruleDSLRuleMonitor EOF
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
    // InternalSasDsl.g:447:1: ruleDSLRuleMonitor returns [EObject current=null] : ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'monitor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'monitor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'sensor' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) ) ;
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
            // InternalSasDsl.g:453:2: ( ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'monitor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'monitor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'sensor' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) ) )
            // InternalSasDsl.g:454:2: ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'monitor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'monitor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'sensor' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) )
            {
            // InternalSasDsl.g:454:2: ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'monitor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'monitor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'sensor' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) )
            int alt13=6;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // InternalSasDsl.g:455:3: (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:455:3: (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:456:4: otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_0_0());
                    			
                    // InternalSasDsl.g:460:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:461:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:461:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:462:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:473:4: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:474:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:474:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    // InternalSasDsl.g:475:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:475:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
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
                            // InternalSasDsl.g:476:7: lv_access_2_1= 'must-use'
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
                            // InternalSasDsl.g:487:7: lv_access_2_2= 'must-not-use'
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

                    otherlv_3=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_0_3());
                    			
                    // InternalSasDsl.g:504:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:505:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:505:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:506:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRuleMonitorAccess().getMonitor2DSLMonitorCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRuleMonitorAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:523:3: (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:523:3: (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:524:4: otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_1_0());
                    			
                    // InternalSasDsl.g:528:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:529:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:529:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:530:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:541:4: ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:542:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:542:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    // InternalSasDsl.g:543:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:543:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
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
                            // InternalSasDsl.g:544:7: lv_access_8_1= 'must-use'
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
                            // InternalSasDsl.g:555:7: lv_access_8_2= 'must-not-use'
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

                    otherlv_9=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getDSLRuleMonitorAccess().getAnalyzerKeyword_1_3());
                    			
                    // InternalSasDsl.g:572:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:573:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:573:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:574:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRuleMonitorAccess().getAnalyzerDSLAnalyzerCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRuleMonitorAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:591:3: (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:591:3: (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:592:4: otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_2_0());
                    			
                    // InternalSasDsl.g:596:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:597:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:597:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:598:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:609:4: ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:610:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:610:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    // InternalSasDsl.g:611:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:611:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
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
                            // InternalSasDsl.g:612:7: lv_access_14_1= 'must-use'
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
                            // InternalSasDsl.g:623:7: lv_access_14_2= 'must-not-use'
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

                    otherlv_15=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getDSLRuleMonitorAccess().getPlannerKeyword_2_3());
                    			
                    // InternalSasDsl.g:640:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:641:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:641:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:642:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRuleMonitorAccess().getPlannerDSLPlannerCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRuleMonitorAccess().getSemicolonKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:659:3: (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    {
                    // InternalSasDsl.g:659:3: (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    // InternalSasDsl.g:660:4: otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';'
                    {
                    otherlv_18=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_3_0());
                    			
                    // InternalSasDsl.g:664:4: ( (otherlv_19= RULE_ID ) )
                    // InternalSasDsl.g:665:5: (otherlv_19= RULE_ID )
                    {
                    // InternalSasDsl.g:665:5: (otherlv_19= RULE_ID )
                    // InternalSasDsl.g:666:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_19, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:677:4: ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:678:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:678:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    // InternalSasDsl.g:679:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:679:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
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
                            // InternalSasDsl.g:680:7: lv_access_20_1= 'must-use'
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
                            // InternalSasDsl.g:691:7: lv_access_20_2= 'must-not-use'
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

                    otherlv_21=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_21, grammarAccess.getDSLRuleMonitorAccess().getExecutorKeyword_3_3());
                    			
                    // InternalSasDsl.g:708:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSasDsl.g:709:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSasDsl.g:709:5: (otherlv_22= RULE_ID )
                    // InternalSasDsl.g:710:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_22, grammarAccess.getDSLRuleMonitorAccess().getExecutorDSLExecutorCrossReference_3_4_0());
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_23, grammarAccess.getDSLRuleMonitorAccess().getSemicolonKeyword_3_5());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalSasDsl.g:727:3: (otherlv_24= 'monitor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    {
                    // InternalSasDsl.g:727:3: (otherlv_24= 'monitor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    // InternalSasDsl.g:728:4: otherlv_24= 'monitor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';'
                    {
                    otherlv_24=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_24, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_4_0());
                    			
                    // InternalSasDsl.g:732:4: ( (otherlv_25= RULE_ID ) )
                    // InternalSasDsl.g:733:5: (otherlv_25= RULE_ID )
                    {
                    // InternalSasDsl.g:733:5: (otherlv_25= RULE_ID )
                    // InternalSasDsl.g:734:6: otherlv_25= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_25=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_25, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_4_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:745:4: ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:746:5: ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:746:5: ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) )
                    // InternalSasDsl.g:747:6: (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:747:6: (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' )
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
                            // InternalSasDsl.g:748:7: lv_access_26_1= 'must-use'
                            {
                            lv_access_26_1=(Token)match(input,16,FOLLOW_18); 

                            							newLeafNode(lv_access_26_1, grammarAccess.getDSLRuleMonitorAccess().getAccessMustUseKeyword_4_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_26_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:759:7: lv_access_26_2= 'must-not-use'
                            {
                            lv_access_26_2=(Token)match(input,17,FOLLOW_18); 

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
                    			
                    // InternalSasDsl.g:776:4: ( (otherlv_28= RULE_ID ) )
                    // InternalSasDsl.g:777:5: (otherlv_28= RULE_ID )
                    {
                    // InternalSasDsl.g:777:5: (otherlv_28= RULE_ID )
                    // InternalSasDsl.g:778:6: otherlv_28= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_28=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_28, grammarAccess.getDSLRuleMonitorAccess().getKnowledgeDSLKnowledgeCrossReference_4_4_0());
                    					

                    }


                    }

                    otherlv_29=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_29, grammarAccess.getDSLRuleMonitorAccess().getSemicolonKeyword_4_5());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalSasDsl.g:795:3: (otherlv_30= 'monitor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'sensor' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' )
                    {
                    // InternalSasDsl.g:795:3: (otherlv_30= 'monitor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'sensor' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' )
                    // InternalSasDsl.g:796:4: otherlv_30= 'monitor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'sensor' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';'
                    {
                    otherlv_30=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_30, grammarAccess.getDSLRuleMonitorAccess().getMonitorKeyword_5_0());
                    			
                    // InternalSasDsl.g:800:4: ( (otherlv_31= RULE_ID ) )
                    // InternalSasDsl.g:801:5: (otherlv_31= RULE_ID )
                    {
                    // InternalSasDsl.g:801:5: (otherlv_31= RULE_ID )
                    // InternalSasDsl.g:802:6: otherlv_31= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_31=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_31, grammarAccess.getDSLRuleMonitorAccess().getMonitorDSLMonitorCrossReference_5_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:813:4: ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:814:5: ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:814:5: ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) )
                    // InternalSasDsl.g:815:6: (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:815:6: (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' )
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
                            // InternalSasDsl.g:816:7: lv_access_32_1= 'must-use'
                            {
                            lv_access_32_1=(Token)match(input,16,FOLLOW_19); 

                            							newLeafNode(lv_access_32_1, grammarAccess.getDSLRuleMonitorAccess().getAccessMustUseKeyword_5_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_32_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:827:7: lv_access_32_2= 'must-not-use'
                            {
                            lv_access_32_2=(Token)match(input,17,FOLLOW_19); 

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
                    			
                    // InternalSasDsl.g:844:4: ( (otherlv_34= RULE_ID ) )
                    // InternalSasDsl.g:845:5: (otherlv_34= RULE_ID )
                    {
                    // InternalSasDsl.g:845:5: (otherlv_34= RULE_ID )
                    // InternalSasDsl.g:846:6: otherlv_34= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleMonitorRule());
                    						}
                    					
                    otherlv_34=(Token)match(input,RULE_ID,FOLLOW_12); 

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
    // InternalSasDsl.g:866:1: entryRuleDSLRuleAnalyzer returns [EObject current=null] : iv_ruleDSLRuleAnalyzer= ruleDSLRuleAnalyzer EOF ;
    public final EObject entryRuleDSLRuleAnalyzer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleAnalyzer = null;


        try {
            // InternalSasDsl.g:866:56: (iv_ruleDSLRuleAnalyzer= ruleDSLRuleAnalyzer EOF )
            // InternalSasDsl.g:867:2: iv_ruleDSLRuleAnalyzer= ruleDSLRuleAnalyzer EOF
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
    // InternalSasDsl.g:873:1: ruleDSLRuleAnalyzer returns [EObject current=null] : ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'reference-input' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) | (otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'alternative' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';' ) ) ;
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
            // InternalSasDsl.g:879:2: ( ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'reference-input' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) | (otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'alternative' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';' ) ) )
            // InternalSasDsl.g:880:2: ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'reference-input' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) | (otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'alternative' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';' ) )
            {
            // InternalSasDsl.g:880:2: ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'reference-input' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) | (otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'alternative' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';' ) )
            int alt21=7;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // InternalSasDsl.g:881:3: (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:881:3: (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:882:4: otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_0_0());
                    			
                    // InternalSasDsl.g:886:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:887:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:887:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:888:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:899:4: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:900:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:900:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    // InternalSasDsl.g:901:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:901:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
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
                            // InternalSasDsl.g:902:7: lv_access_2_1= 'must-use'
                            {
                            lv_access_2_1=(Token)match(input,16,FOLLOW_14); 

                            							newLeafNode(lv_access_2_1, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustUseKeyword_0_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_2_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:913:7: lv_access_2_2= 'must-not-use'
                            {
                            lv_access_2_2=(Token)match(input,17,FOLLOW_14); 

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
                    			
                    // InternalSasDsl.g:930:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:931:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:931:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:932:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRuleAnalyzerAccess().getMonitorDSLMonitorCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:949:3: (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:949:3: (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:950:4: otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_1_0());
                    			
                    // InternalSasDsl.g:954:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:955:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:955:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:956:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:967:4: ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:968:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:968:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    // InternalSasDsl.g:969:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:969:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
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
                            // InternalSasDsl.g:970:7: lv_access_8_1= 'must-use'
                            {
                            lv_access_8_1=(Token)match(input,16,FOLLOW_15); 

                            							newLeafNode(lv_access_8_1, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustUseKeyword_1_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_8_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:981:7: lv_access_8_2= 'must-not-use'
                            {
                            lv_access_8_2=(Token)match(input,17,FOLLOW_15); 

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
                    			
                    // InternalSasDsl.g:998:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:999:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:999:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:1000:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzer2DSLAnalyzerCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:1017:3: (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:1017:3: (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:1018:4: otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_2_0());
                    			
                    // InternalSasDsl.g:1022:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:1023:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:1023:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:1024:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1035:4: ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1036:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1036:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1037:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1037:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1038:7: lv_access_14_1= 'must-use'
                            {
                            lv_access_14_1=(Token)match(input,16,FOLLOW_16); 

                            							newLeafNode(lv_access_14_1, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustUseKeyword_2_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_14_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1049:7: lv_access_14_2= 'must-not-use'
                            {
                            lv_access_14_2=(Token)match(input,17,FOLLOW_16); 

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
                    			
                    // InternalSasDsl.g:1066:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:1067:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:1067:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:1068:6: otherlv_16= RULE_ID
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
                    // InternalSasDsl.g:1085:3: (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    {
                    // InternalSasDsl.g:1085:3: (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    // InternalSasDsl.g:1086:4: otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';'
                    {
                    otherlv_18=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_3_0());
                    			
                    // InternalSasDsl.g:1090:4: ( (otherlv_19= RULE_ID ) )
                    // InternalSasDsl.g:1091:5: (otherlv_19= RULE_ID )
                    {
                    // InternalSasDsl.g:1091:5: (otherlv_19= RULE_ID )
                    // InternalSasDsl.g:1092:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_19, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1103:4: ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1104:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1104:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1105:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1105:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1106:7: lv_access_20_1= 'must-use'
                            {
                            lv_access_20_1=(Token)match(input,16,FOLLOW_17); 

                            							newLeafNode(lv_access_20_1, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustUseKeyword_3_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_20_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1117:7: lv_access_20_2= 'must-not-use'
                            {
                            lv_access_20_2=(Token)match(input,17,FOLLOW_17); 

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
                    			
                    // InternalSasDsl.g:1134:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSasDsl.g:1135:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSasDsl.g:1135:5: (otherlv_22= RULE_ID )
                    // InternalSasDsl.g:1136:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_22, grammarAccess.getDSLRuleAnalyzerAccess().getExecutorDSLExecutorCrossReference_3_4_0());
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_23, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_3_5());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalSasDsl.g:1153:3: (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    {
                    // InternalSasDsl.g:1153:3: (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    // InternalSasDsl.g:1154:4: otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';'
                    {
                    otherlv_24=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_24, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_4_0());
                    			
                    // InternalSasDsl.g:1158:4: ( (otherlv_25= RULE_ID ) )
                    // InternalSasDsl.g:1159:5: (otherlv_25= RULE_ID )
                    {
                    // InternalSasDsl.g:1159:5: (otherlv_25= RULE_ID )
                    // InternalSasDsl.g:1160:6: otherlv_25= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_25=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_25, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_4_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1171:4: ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1172:5: ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1172:5: ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1173:6: (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1173:6: (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1174:7: lv_access_26_1= 'must-use'
                            {
                            lv_access_26_1=(Token)match(input,16,FOLLOW_18); 

                            							newLeafNode(lv_access_26_1, grammarAccess.getDSLRuleAnalyzerAccess().getAccessMustUseKeyword_4_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_26_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1185:7: lv_access_26_2= 'must-not-use'
                            {
                            lv_access_26_2=(Token)match(input,17,FOLLOW_18); 

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
                    			
                    // InternalSasDsl.g:1202:4: ( (otherlv_28= RULE_ID ) )
                    // InternalSasDsl.g:1203:5: (otherlv_28= RULE_ID )
                    {
                    // InternalSasDsl.g:1203:5: (otherlv_28= RULE_ID )
                    // InternalSasDsl.g:1204:6: otherlv_28= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_28=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_28, grammarAccess.getDSLRuleAnalyzerAccess().getKnowledgeDSLKnowledgeCrossReference_4_4_0());
                    					

                    }


                    }

                    otherlv_29=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_29, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_4_5());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalSasDsl.g:1221:3: (otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'reference-input' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' )
                    {
                    // InternalSasDsl.g:1221:3: (otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'reference-input' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' )
                    // InternalSasDsl.g:1222:4: otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'reference-input' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';'
                    {
                    otherlv_30=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_30, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_5_0());
                    			
                    // InternalSasDsl.g:1226:4: ( (otherlv_31= RULE_ID ) )
                    // InternalSasDsl.g:1227:5: (otherlv_31= RULE_ID )
                    {
                    // InternalSasDsl.g:1227:5: (otherlv_31= RULE_ID )
                    // InternalSasDsl.g:1228:6: otherlv_31= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_31=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_31, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_5_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1239:4: ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1240:5: ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1240:5: ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1241:6: (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1241:6: (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1242:7: lv_access_32_1= 'must-use'
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
                            // InternalSasDsl.g:1253:7: lv_access_32_2= 'must-not-use'
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

                    				newLeafNode(otherlv_33, grammarAccess.getDSLRuleAnalyzerAccess().getReferenceInputKeyword_5_3());
                    			
                    // InternalSasDsl.g:1270:4: ( (otherlv_34= RULE_ID ) )
                    // InternalSasDsl.g:1271:5: (otherlv_34= RULE_ID )
                    {
                    // InternalSasDsl.g:1271:5: (otherlv_34= RULE_ID )
                    // InternalSasDsl.g:1272:6: otherlv_34= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_34=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_34, grammarAccess.getDSLRuleAnalyzerAccess().getRreferenceDSLReferenceInputCrossReference_5_4_0());
                    					

                    }


                    }

                    otherlv_35=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_35, grammarAccess.getDSLRuleAnalyzerAccess().getSemicolonKeyword_5_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalSasDsl.g:1289:3: (otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'alternative' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';' )
                    {
                    // InternalSasDsl.g:1289:3: (otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'alternative' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';' )
                    // InternalSasDsl.g:1290:4: otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'alternative' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';'
                    {
                    otherlv_36=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_36, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerKeyword_6_0());
                    			
                    // InternalSasDsl.g:1294:4: ( (otherlv_37= RULE_ID ) )
                    // InternalSasDsl.g:1295:5: (otherlv_37= RULE_ID )
                    {
                    // InternalSasDsl.g:1295:5: (otherlv_37= RULE_ID )
                    // InternalSasDsl.g:1296:6: otherlv_37= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_37=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_37, grammarAccess.getDSLRuleAnalyzerAccess().getAnalyzerDSLAnalyzerCrossReference_6_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1307:4: ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1308:5: ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1308:5: ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1309:6: (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1309:6: (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1310:7: lv_access_38_1= 'must-use'
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
                            // InternalSasDsl.g:1321:7: lv_access_38_2= 'must-not-use'
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

                    				newLeafNode(otherlv_39, grammarAccess.getDSLRuleAnalyzerAccess().getAlternativeKeyword_6_3());
                    			
                    // InternalSasDsl.g:1338:4: ( (otherlv_40= RULE_ID ) )
                    // InternalSasDsl.g:1339:5: (otherlv_40= RULE_ID )
                    {
                    // InternalSasDsl.g:1339:5: (otherlv_40= RULE_ID )
                    // InternalSasDsl.g:1340:6: otherlv_40= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleAnalyzerRule());
                    						}
                    					
                    otherlv_40=(Token)match(input,RULE_ID,FOLLOW_12); 

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
    // InternalSasDsl.g:1360:1: entryRuleDSLRulePlanner returns [EObject current=null] : iv_ruleDSLRulePlanner= ruleDSLRulePlanner EOF ;
    public final EObject entryRuleDSLRulePlanner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRulePlanner = null;


        try {
            // InternalSasDsl.g:1360:55: (iv_ruleDSLRulePlanner= ruleDSLRulePlanner EOF )
            // InternalSasDsl.g:1361:2: iv_ruleDSLRulePlanner= ruleDSLRulePlanner EOF
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
    // InternalSasDsl.g:1367:1: ruleDSLRulePlanner returns [EObject current=null] : ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'planner' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) ) ;
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
            // InternalSasDsl.g:1373:2: ( ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'planner' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) ) )
            // InternalSasDsl.g:1374:2: ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'planner' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) )
            {
            // InternalSasDsl.g:1374:2: ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'planner' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) )
            int alt28=6;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // InternalSasDsl.g:1375:3: (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:1375:3: (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:1376:4: otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_0_0());
                    			
                    // InternalSasDsl.g:1380:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:1381:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:1381:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:1382:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1393:4: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1394:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1394:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1395:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1395:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1396:7: lv_access_2_1= 'must-use'
                            {
                            lv_access_2_1=(Token)match(input,16,FOLLOW_14); 

                            							newLeafNode(lv_access_2_1, grammarAccess.getDSLRulePlannerAccess().getAccessMustUseKeyword_0_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_2_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1407:7: lv_access_2_2= 'must-not-use'
                            {
                            lv_access_2_2=(Token)match(input,17,FOLLOW_14); 

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
                    			
                    // InternalSasDsl.g:1424:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:1425:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:1425:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:1426:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRulePlannerAccess().getMonitorDSLMonitorCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:1443:3: (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:1443:3: (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:1444:4: otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_1_0());
                    			
                    // InternalSasDsl.g:1448:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:1449:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:1449:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:1450:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1461:4: ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1462:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1462:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1463:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1463:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1464:7: lv_access_8_1= 'must-use'
                            {
                            lv_access_8_1=(Token)match(input,16,FOLLOW_15); 

                            							newLeafNode(lv_access_8_1, grammarAccess.getDSLRulePlannerAccess().getAccessMustUseKeyword_1_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_8_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1475:7: lv_access_8_2= 'must-not-use'
                            {
                            lv_access_8_2=(Token)match(input,17,FOLLOW_15); 

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
                    			
                    // InternalSasDsl.g:1492:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:1493:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:1493:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:1494:6: otherlv_10= RULE_ID
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
                    // InternalSasDsl.g:1511:3: (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:1511:3: (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:1512:4: otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_2_0());
                    			
                    // InternalSasDsl.g:1516:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:1517:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:1517:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:1518:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1529:4: ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1530:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1530:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1531:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1531:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1532:7: lv_access_14_1= 'must-use'
                            {
                            lv_access_14_1=(Token)match(input,16,FOLLOW_16); 

                            							newLeafNode(lv_access_14_1, grammarAccess.getDSLRulePlannerAccess().getAccessMustUseKeyword_2_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_14_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1543:7: lv_access_14_2= 'must-not-use'
                            {
                            lv_access_14_2=(Token)match(input,17,FOLLOW_16); 

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
                    			
                    // InternalSasDsl.g:1560:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:1561:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:1561:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:1562:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRulePlannerAccess().getPlanner2DSLPlannerCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:1579:3: (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    {
                    // InternalSasDsl.g:1579:3: (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    // InternalSasDsl.g:1580:4: otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';'
                    {
                    otherlv_18=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_3_0());
                    			
                    // InternalSasDsl.g:1584:4: ( (otherlv_19= RULE_ID ) )
                    // InternalSasDsl.g:1585:5: (otherlv_19= RULE_ID )
                    {
                    // InternalSasDsl.g:1585:5: (otherlv_19= RULE_ID )
                    // InternalSasDsl.g:1586:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_19, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1597:4: ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1598:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1598:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1599:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1599:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1600:7: lv_access_20_1= 'must-use'
                            {
                            lv_access_20_1=(Token)match(input,16,FOLLOW_17); 

                            							newLeafNode(lv_access_20_1, grammarAccess.getDSLRulePlannerAccess().getAccessMustUseKeyword_3_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_20_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1611:7: lv_access_20_2= 'must-not-use'
                            {
                            lv_access_20_2=(Token)match(input,17,FOLLOW_17); 

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
                    			
                    // InternalSasDsl.g:1628:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSasDsl.g:1629:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSasDsl.g:1629:5: (otherlv_22= RULE_ID )
                    // InternalSasDsl.g:1630:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_22, grammarAccess.getDSLRulePlannerAccess().getExecutorDSLExecutorCrossReference_3_4_0());
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_23, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_3_5());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalSasDsl.g:1647:3: (otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    {
                    // InternalSasDsl.g:1647:3: (otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    // InternalSasDsl.g:1648:4: otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';'
                    {
                    otherlv_24=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_24, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_4_0());
                    			
                    // InternalSasDsl.g:1652:4: ( (otherlv_25= RULE_ID ) )
                    // InternalSasDsl.g:1653:5: (otherlv_25= RULE_ID )
                    {
                    // InternalSasDsl.g:1653:5: (otherlv_25= RULE_ID )
                    // InternalSasDsl.g:1654:6: otherlv_25= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_25=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_25, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_4_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1665:4: ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1666:5: ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1666:5: ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1667:6: (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1667:6: (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1668:7: lv_access_26_1= 'must-use'
                            {
                            lv_access_26_1=(Token)match(input,16,FOLLOW_18); 

                            							newLeafNode(lv_access_26_1, grammarAccess.getDSLRulePlannerAccess().getAccessMustUseKeyword_4_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_26_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1679:7: lv_access_26_2= 'must-not-use'
                            {
                            lv_access_26_2=(Token)match(input,17,FOLLOW_18); 

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
                    			
                    // InternalSasDsl.g:1696:4: ( (otherlv_28= RULE_ID ) )
                    // InternalSasDsl.g:1697:5: (otherlv_28= RULE_ID )
                    {
                    // InternalSasDsl.g:1697:5: (otherlv_28= RULE_ID )
                    // InternalSasDsl.g:1698:6: otherlv_28= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_28=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_28, grammarAccess.getDSLRulePlannerAccess().getKnowledgeDSLKnowledgeCrossReference_4_4_0());
                    					

                    }


                    }

                    otherlv_29=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_29, grammarAccess.getDSLRulePlannerAccess().getSemicolonKeyword_4_5());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalSasDsl.g:1715:3: (otherlv_30= 'planner' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' )
                    {
                    // InternalSasDsl.g:1715:3: (otherlv_30= 'planner' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' )
                    // InternalSasDsl.g:1716:4: otherlv_30= 'planner' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';'
                    {
                    otherlv_30=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_30, grammarAccess.getDSLRulePlannerAccess().getPlannerKeyword_5_0());
                    			
                    // InternalSasDsl.g:1720:4: ( (otherlv_31= RULE_ID ) )
                    // InternalSasDsl.g:1721:5: (otherlv_31= RULE_ID )
                    {
                    // InternalSasDsl.g:1721:5: (otherlv_31= RULE_ID )
                    // InternalSasDsl.g:1722:6: otherlv_31= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_31=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_31, grammarAccess.getDSLRulePlannerAccess().getPlannerDSLPlannerCrossReference_5_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1733:4: ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1734:5: ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1734:5: ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1735:6: (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1735:6: (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1736:7: lv_access_32_1= 'must-use'
                            {
                            lv_access_32_1=(Token)match(input,16,FOLLOW_21); 

                            							newLeafNode(lv_access_32_1, grammarAccess.getDSLRulePlannerAccess().getAccessMustUseKeyword_5_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_32_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1747:7: lv_access_32_2= 'must-not-use'
                            {
                            lv_access_32_2=(Token)match(input,17,FOLLOW_21); 

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
                    			
                    // InternalSasDsl.g:1764:4: ( (otherlv_34= RULE_ID ) )
                    // InternalSasDsl.g:1765:5: (otherlv_34= RULE_ID )
                    {
                    // InternalSasDsl.g:1765:5: (otherlv_34= RULE_ID )
                    // InternalSasDsl.g:1766:6: otherlv_34= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRulePlannerRule());
                    						}
                    					
                    otherlv_34=(Token)match(input,RULE_ID,FOLLOW_12); 

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
    // InternalSasDsl.g:1786:1: entryRuleDSLRuleExecutor returns [EObject current=null] : iv_ruleDSLRuleExecutor= ruleDSLRuleExecutor EOF ;
    public final EObject entryRuleDSLRuleExecutor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleExecutor = null;


        try {
            // InternalSasDsl.g:1786:56: (iv_ruleDSLRuleExecutor= ruleDSLRuleExecutor EOF )
            // InternalSasDsl.g:1787:2: iv_ruleDSLRuleExecutor= ruleDSLRuleExecutor EOF
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
    // InternalSasDsl.g:1793:1: ruleDSLRuleExecutor returns [EObject current=null] : ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'executor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'executor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'effector' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) ) ;
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
            // InternalSasDsl.g:1799:2: ( ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'executor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'executor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'effector' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) ) )
            // InternalSasDsl.g:1800:2: ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'executor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'executor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'effector' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) )
            {
            // InternalSasDsl.g:1800:2: ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'executor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'executor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'effector' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) )
            int alt35=6;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // InternalSasDsl.g:1801:3: (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:1801:3: (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:1802:4: otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_0_0());
                    			
                    // InternalSasDsl.g:1806:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:1807:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:1807:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:1808:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1819:4: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1820:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1820:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1821:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1821:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1822:7: lv_access_2_1= 'must-use'
                            {
                            lv_access_2_1=(Token)match(input,16,FOLLOW_14); 

                            							newLeafNode(lv_access_2_1, grammarAccess.getDSLRuleExecutorAccess().getAccessMustUseKeyword_0_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_2_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1833:7: lv_access_2_2= 'must-not-use'
                            {
                            lv_access_2_2=(Token)match(input,17,FOLLOW_14); 

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
                    			
                    // InternalSasDsl.g:1850:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:1851:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:1851:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:1852:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRuleExecutorAccess().getMonitorDSLMonitorCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRuleExecutorAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:1869:3: (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:1869:3: (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:1870:4: otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_1_0());
                    			
                    // InternalSasDsl.g:1874:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:1875:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:1875:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:1876:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1887:4: ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1888:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1888:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1889:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1889:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1890:7: lv_access_8_1= 'must-use'
                            {
                            lv_access_8_1=(Token)match(input,16,FOLLOW_15); 

                            							newLeafNode(lv_access_8_1, grammarAccess.getDSLRuleExecutorAccess().getAccessMustUseKeyword_1_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_8_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1901:7: lv_access_8_2= 'must-not-use'
                            {
                            lv_access_8_2=(Token)match(input,17,FOLLOW_15); 

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
                    			
                    // InternalSasDsl.g:1918:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:1919:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:1919:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:1920:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRuleExecutorAccess().getAnalyzerDSLAnalyzerCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRuleExecutorAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:1937:3: (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:1937:3: (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:1938:4: otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_2_0());
                    			
                    // InternalSasDsl.g:1942:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:1943:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:1943:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:1944:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:1955:4: ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:1956:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:1956:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    // InternalSasDsl.g:1957:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:1957:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
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
                            // InternalSasDsl.g:1958:7: lv_access_14_1= 'must-use'
                            {
                            lv_access_14_1=(Token)match(input,16,FOLLOW_16); 

                            							newLeafNode(lv_access_14_1, grammarAccess.getDSLRuleExecutorAccess().getAccessMustUseKeyword_2_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_14_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:1969:7: lv_access_14_2= 'must-not-use'
                            {
                            lv_access_14_2=(Token)match(input,17,FOLLOW_16); 

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
                    			
                    // InternalSasDsl.g:1986:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:1987:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:1987:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:1988:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRuleExecutorAccess().getPlannerDSLPlannerCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRuleExecutorAccess().getSemicolonKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:2005:3: (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    {
                    // InternalSasDsl.g:2005:3: (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    // InternalSasDsl.g:2006:4: otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';'
                    {
                    otherlv_18=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_3_0());
                    			
                    // InternalSasDsl.g:2010:4: ( (otherlv_19= RULE_ID ) )
                    // InternalSasDsl.g:2011:5: (otherlv_19= RULE_ID )
                    {
                    // InternalSasDsl.g:2011:5: (otherlv_19= RULE_ID )
                    // InternalSasDsl.g:2012:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_19, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:2023:4: ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:2024:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:2024:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    // InternalSasDsl.g:2025:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:2025:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
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
                            // InternalSasDsl.g:2026:7: lv_access_20_1= 'must-use'
                            {
                            lv_access_20_1=(Token)match(input,16,FOLLOW_17); 

                            							newLeafNode(lv_access_20_1, grammarAccess.getDSLRuleExecutorAccess().getAccessMustUseKeyword_3_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_20_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:2037:7: lv_access_20_2= 'must-not-use'
                            {
                            lv_access_20_2=(Token)match(input,17,FOLLOW_17); 

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
                    			
                    // InternalSasDsl.g:2054:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSasDsl.g:2055:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSasDsl.g:2055:5: (otherlv_22= RULE_ID )
                    // InternalSasDsl.g:2056:6: otherlv_22= RULE_ID
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
                case 5 :
                    // InternalSasDsl.g:2073:3: (otherlv_24= 'executor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    {
                    // InternalSasDsl.g:2073:3: (otherlv_24= 'executor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' )
                    // InternalSasDsl.g:2074:4: otherlv_24= 'executor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';'
                    {
                    otherlv_24=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_24, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_4_0());
                    			
                    // InternalSasDsl.g:2078:4: ( (otherlv_25= RULE_ID ) )
                    // InternalSasDsl.g:2079:5: (otherlv_25= RULE_ID )
                    {
                    // InternalSasDsl.g:2079:5: (otherlv_25= RULE_ID )
                    // InternalSasDsl.g:2080:6: otherlv_25= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_25=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_25, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_4_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:2091:4: ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:2092:5: ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:2092:5: ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) )
                    // InternalSasDsl.g:2093:6: (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:2093:6: (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' )
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
                            // InternalSasDsl.g:2094:7: lv_access_26_1= 'must-use'
                            {
                            lv_access_26_1=(Token)match(input,16,FOLLOW_18); 

                            							newLeafNode(lv_access_26_1, grammarAccess.getDSLRuleExecutorAccess().getAccessMustUseKeyword_4_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_26_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:2105:7: lv_access_26_2= 'must-not-use'
                            {
                            lv_access_26_2=(Token)match(input,17,FOLLOW_18); 

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
                    			
                    // InternalSasDsl.g:2122:4: ( (otherlv_28= RULE_ID ) )
                    // InternalSasDsl.g:2123:5: (otherlv_28= RULE_ID )
                    {
                    // InternalSasDsl.g:2123:5: (otherlv_28= RULE_ID )
                    // InternalSasDsl.g:2124:6: otherlv_28= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_28=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_28, grammarAccess.getDSLRuleExecutorAccess().getKnowledgeDSLKnowledgeCrossReference_4_4_0());
                    					

                    }


                    }

                    otherlv_29=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_29, grammarAccess.getDSLRuleExecutorAccess().getSemicolonKeyword_4_5());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalSasDsl.g:2141:3: (otherlv_30= 'executor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'effector' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' )
                    {
                    // InternalSasDsl.g:2141:3: (otherlv_30= 'executor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'effector' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' )
                    // InternalSasDsl.g:2142:4: otherlv_30= 'executor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'effector' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';'
                    {
                    otherlv_30=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_30, grammarAccess.getDSLRuleExecutorAccess().getExecutorKeyword_5_0());
                    			
                    // InternalSasDsl.g:2146:4: ( (otherlv_31= RULE_ID ) )
                    // InternalSasDsl.g:2147:5: (otherlv_31= RULE_ID )
                    {
                    // InternalSasDsl.g:2147:5: (otherlv_31= RULE_ID )
                    // InternalSasDsl.g:2148:6: otherlv_31= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_31=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_31, grammarAccess.getDSLRuleExecutorAccess().getExecutorDSLExecutorCrossReference_5_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:2159:4: ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:2160:5: ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:2160:5: ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) )
                    // InternalSasDsl.g:2161:6: (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:2161:6: (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' )
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
                            // InternalSasDsl.g:2162:7: lv_access_32_1= 'must-use'
                            {
                            lv_access_32_1=(Token)match(input,16,FOLLOW_22); 

                            							newLeafNode(lv_access_32_1, grammarAccess.getDSLRuleExecutorAccess().getAccessMustUseKeyword_5_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_32_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:2173:7: lv_access_32_2= 'must-not-use'
                            {
                            lv_access_32_2=(Token)match(input,17,FOLLOW_22); 

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
                    			
                    // InternalSasDsl.g:2190:4: ( (otherlv_34= RULE_ID ) )
                    // InternalSasDsl.g:2191:5: (otherlv_34= RULE_ID )
                    {
                    // InternalSasDsl.g:2191:5: (otherlv_34= RULE_ID )
                    // InternalSasDsl.g:2192:6: otherlv_34= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleExecutorRule());
                    						}
                    					
                    otherlv_34=(Token)match(input,RULE_ID,FOLLOW_12); 

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
    // InternalSasDsl.g:2212:1: entryRuleDSLRuleKnowledge returns [EObject current=null] : iv_ruleDSLRuleKnowledge= ruleDSLRuleKnowledge EOF ;
    public final EObject entryRuleDSLRuleKnowledge() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleKnowledge = null;


        try {
            // InternalSasDsl.g:2212:57: (iv_ruleDSLRuleKnowledge= ruleDSLRuleKnowledge EOF )
            // InternalSasDsl.g:2213:2: iv_ruleDSLRuleKnowledge= ruleDSLRuleKnowledge EOF
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
    // InternalSasDsl.g:2219:1: ruleDSLRuleKnowledge returns [EObject current=null] : ( (otherlv_0= 'knowledge' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'knowledge' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'knowledge' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'knowledge' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) ) ;
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
            // InternalSasDsl.g:2225:2: ( ( (otherlv_0= 'knowledge' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'knowledge' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'knowledge' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'knowledge' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) ) )
            // InternalSasDsl.g:2226:2: ( (otherlv_0= 'knowledge' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'knowledge' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'knowledge' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'knowledge' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) )
            {
            // InternalSasDsl.g:2226:2: ( (otherlv_0= 'knowledge' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'knowledge' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'knowledge' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'knowledge' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) )
            int alt40=4;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==24) ) {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==RULE_ID) ) {
                    int LA40_2 = input.LA(3);

                    if ( (LA40_2==16) ) {
                        switch ( input.LA(4) ) {
                        case 23:
                            {
                            alt40=4;
                            }
                            break;
                        case 22:
                            {
                            alt40=3;
                            }
                            break;
                        case 21:
                            {
                            alt40=2;
                            }
                            break;
                        case 20:
                            {
                            alt40=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 40, 3, input);

                            throw nvae;
                        }

                    }
                    else if ( (LA40_2==17) ) {
                        switch ( input.LA(4) ) {
                        case 23:
                            {
                            alt40=4;
                            }
                            break;
                        case 22:
                            {
                            alt40=3;
                            }
                            break;
                        case 21:
                            {
                            alt40=2;
                            }
                            break;
                        case 20:
                            {
                            alt40=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 40, 4, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 40, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalSasDsl.g:2227:3: (otherlv_0= 'knowledge' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    {
                    // InternalSasDsl.g:2227:3: (otherlv_0= 'knowledge' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
                    // InternalSasDsl.g:2228:4: otherlv_0= 'knowledge' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
                    {
                    otherlv_0=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getDSLRuleKnowledgeAccess().getKnowledgeKeyword_0_0());
                    			
                    // InternalSasDsl.g:2232:4: ( (otherlv_1= RULE_ID ) )
                    // InternalSasDsl.g:2233:5: (otherlv_1= RULE_ID )
                    {
                    // InternalSasDsl.g:2233:5: (otherlv_1= RULE_ID )
                    // InternalSasDsl.g:2234:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_1, grammarAccess.getDSLRuleKnowledgeAccess().getKnowledgeDSLKnowledgeCrossReference_0_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:2245:4: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:2246:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:2246:5: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
                    // InternalSasDsl.g:2247:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:2247:6: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==16) ) {
                        alt36=1;
                    }
                    else if ( (LA36_0==17) ) {
                        alt36=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 36, 0, input);

                        throw nvae;
                    }
                    switch (alt36) {
                        case 1 :
                            // InternalSasDsl.g:2248:7: lv_access_2_1= 'must-use'
                            {
                            lv_access_2_1=(Token)match(input,16,FOLLOW_14); 

                            							newLeafNode(lv_access_2_1, grammarAccess.getDSLRuleKnowledgeAccess().getAccessMustUseKeyword_0_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_2_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:2259:7: lv_access_2_2= 'must-not-use'
                            {
                            lv_access_2_2=(Token)match(input,17,FOLLOW_14); 

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
                    			
                    // InternalSasDsl.g:2276:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSasDsl.g:2277:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSasDsl.g:2277:5: (otherlv_4= RULE_ID )
                    // InternalSasDsl.g:2278:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_4, grammarAccess.getDSLRuleKnowledgeAccess().getMonitorDSLMonitorCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDSLRuleKnowledgeAccess().getSemicolonKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSasDsl.g:2295:3: (otherlv_6= 'knowledge' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    {
                    // InternalSasDsl.g:2295:3: (otherlv_6= 'knowledge' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' )
                    // InternalSasDsl.g:2296:4: otherlv_6= 'knowledge' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';'
                    {
                    otherlv_6=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDSLRuleKnowledgeAccess().getKnowledgeKeyword_1_0());
                    			
                    // InternalSasDsl.g:2300:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSasDsl.g:2301:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSasDsl.g:2301:5: (otherlv_7= RULE_ID )
                    // InternalSasDsl.g:2302:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_7, grammarAccess.getDSLRuleKnowledgeAccess().getKnowledgeDSLKnowledgeCrossReference_1_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:2313:4: ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:2314:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:2314:5: ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) )
                    // InternalSasDsl.g:2315:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:2315:6: (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' )
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
                            // InternalSasDsl.g:2316:7: lv_access_8_1= 'must-use'
                            {
                            lv_access_8_1=(Token)match(input,16,FOLLOW_15); 

                            							newLeafNode(lv_access_8_1, grammarAccess.getDSLRuleKnowledgeAccess().getAccessMustUseKeyword_1_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_8_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:2327:7: lv_access_8_2= 'must-not-use'
                            {
                            lv_access_8_2=(Token)match(input,17,FOLLOW_15); 

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
                    			
                    // InternalSasDsl.g:2344:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSasDsl.g:2345:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSasDsl.g:2345:5: (otherlv_10= RULE_ID )
                    // InternalSasDsl.g:2346:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_10, grammarAccess.getDSLRuleKnowledgeAccess().getAnalyzerDSLAnalyzerCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDSLRuleKnowledgeAccess().getSemicolonKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSasDsl.g:2363:3: (otherlv_12= 'knowledge' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    {
                    // InternalSasDsl.g:2363:3: (otherlv_12= 'knowledge' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' )
                    // InternalSasDsl.g:2364:4: otherlv_12= 'knowledge' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDSLRuleKnowledgeAccess().getKnowledgeKeyword_2_0());
                    			
                    // InternalSasDsl.g:2368:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSasDsl.g:2369:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSasDsl.g:2369:5: (otherlv_13= RULE_ID )
                    // InternalSasDsl.g:2370:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_13, grammarAccess.getDSLRuleKnowledgeAccess().getKnowledgeDSLKnowledgeCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:2381:4: ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:2382:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:2382:5: ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) )
                    // InternalSasDsl.g:2383:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:2383:6: (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' )
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
                            // InternalSasDsl.g:2384:7: lv_access_14_1= 'must-use'
                            {
                            lv_access_14_1=(Token)match(input,16,FOLLOW_16); 

                            							newLeafNode(lv_access_14_1, grammarAccess.getDSLRuleKnowledgeAccess().getAccessMustUseKeyword_2_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_14_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:2395:7: lv_access_14_2= 'must-not-use'
                            {
                            lv_access_14_2=(Token)match(input,17,FOLLOW_16); 

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
                    			
                    // InternalSasDsl.g:2412:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSasDsl.g:2413:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSasDsl.g:2413:5: (otherlv_16= RULE_ID )
                    // InternalSasDsl.g:2414:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_16, grammarAccess.getDSLRuleKnowledgeAccess().getPlannerDSLPlannerCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getDSLRuleKnowledgeAccess().getSemicolonKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSasDsl.g:2431:3: (otherlv_18= 'knowledge' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    {
                    // InternalSasDsl.g:2431:3: (otherlv_18= 'knowledge' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' )
                    // InternalSasDsl.g:2432:4: otherlv_18= 'knowledge' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';'
                    {
                    otherlv_18=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getDSLRuleKnowledgeAccess().getKnowledgeKeyword_3_0());
                    			
                    // InternalSasDsl.g:2436:4: ( (otherlv_19= RULE_ID ) )
                    // InternalSasDsl.g:2437:5: (otherlv_19= RULE_ID )
                    {
                    // InternalSasDsl.g:2437:5: (otherlv_19= RULE_ID )
                    // InternalSasDsl.g:2438:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_19, grammarAccess.getDSLRuleKnowledgeAccess().getKnowledgeDSLKnowledgeCrossReference_3_1_0());
                    					

                    }


                    }

                    // InternalSasDsl.g:2449:4: ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) )
                    // InternalSasDsl.g:2450:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    {
                    // InternalSasDsl.g:2450:5: ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) )
                    // InternalSasDsl.g:2451:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
                    {
                    // InternalSasDsl.g:2451:6: (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' )
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
                            // InternalSasDsl.g:2452:7: lv_access_20_1= 'must-use'
                            {
                            lv_access_20_1=(Token)match(input,16,FOLLOW_17); 

                            							newLeafNode(lv_access_20_1, grammarAccess.getDSLRuleKnowledgeAccess().getAccessMustUseKeyword_3_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                            							}
                            							setWithLastConsumed(current, "access", lv_access_20_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSasDsl.g:2463:7: lv_access_20_2= 'must-not-use'
                            {
                            lv_access_20_2=(Token)match(input,17,FOLLOW_17); 

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
                    			
                    // InternalSasDsl.g:2480:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSasDsl.g:2481:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSasDsl.g:2481:5: (otherlv_22= RULE_ID )
                    // InternalSasDsl.g:2482:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDSLRuleKnowledgeRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_12); 

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
    // InternalSasDsl.g:2502:1: entryRuleDSLRuleMO returns [EObject current=null] : iv_ruleDSLRuleMO= ruleDSLRuleMO EOF ;
    public final EObject entryRuleDSLRuleMO() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLRuleMO = null;


        try {
            // InternalSasDsl.g:2502:50: (iv_ruleDSLRuleMO= ruleDSLRuleMO EOF )
            // InternalSasDsl.g:2503:2: iv_ruleDSLRuleMO= ruleDSLRuleMO EOF
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
    // InternalSasDsl.g:2509:1: ruleDSLRuleMO returns [EObject current=null] : (otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) ;
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
            // InternalSasDsl.g:2515:2: ( (otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) )
            // InternalSasDsl.g:2516:2: (otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            {
            // InternalSasDsl.g:2516:2: (otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            // InternalSasDsl.g:2517:3: otherlv_0= 'sensor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'measured-output' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLRuleMOAccess().getSensorKeyword_0());
            		
            // InternalSasDsl.g:2521:3: ( (otherlv_1= RULE_ID ) )
            // InternalSasDsl.g:2522:4: (otherlv_1= RULE_ID )
            {
            // InternalSasDsl.g:2522:4: (otherlv_1= RULE_ID )
            // InternalSasDsl.g:2523:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDSLRuleMORule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(otherlv_1, grammarAccess.getDSLRuleMOAccess().getSensorDSLSensorCrossReference_1_0());
            				

            }


            }

            // InternalSasDsl.g:2534:3: ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) )
            // InternalSasDsl.g:2535:4: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
            {
            // InternalSasDsl.g:2535:4: ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) )
            // InternalSasDsl.g:2536:5: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
            {
            // InternalSasDsl.g:2536:5: (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==16) ) {
                alt41=1;
            }
            else if ( (LA41_0==17) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalSasDsl.g:2537:6: lv_access_2_1= 'must-use'
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
                    // InternalSasDsl.g:2548:6: lv_access_2_2= 'must-not-use'
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
            		
            // InternalSasDsl.g:2565:3: ( (otherlv_4= RULE_ID ) )
            // InternalSasDsl.g:2566:4: (otherlv_4= RULE_ID )
            {
            // InternalSasDsl.g:2566:4: (otherlv_4= RULE_ID )
            // InternalSasDsl.g:2567:5: otherlv_4= RULE_ID
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
    // InternalSasDsl.g:2586:1: entryRuleDSLManaging returns [EObject current=null] : iv_ruleDSLManaging= ruleDSLManaging EOF ;
    public final EObject entryRuleDSLManaging() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLManaging = null;


        try {
            // InternalSasDsl.g:2586:52: (iv_ruleDSLManaging= ruleDSLManaging EOF )
            // InternalSasDsl.g:2587:2: iv_ruleDSLManaging= ruleDSLManaging EOF
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
    // InternalSasDsl.g:2593:1: ruleDSLManaging returns [EObject current=null] : (otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )* otherlv_5= '}' ) ;
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
            // InternalSasDsl.g:2599:2: ( (otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )* otherlv_5= '}' ) )
            // InternalSasDsl.g:2600:2: (otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )* otherlv_5= '}' )
            {
            // InternalSasDsl.g:2600:2: (otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )* otherlv_5= '}' )
            // InternalSasDsl.g:2601:3: otherlv_0= 'Managing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_managerController_3_0= ruleDSLManagerController ) )* ( (lv_controller_4_0= ruleDSLController ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLManagingAccess().getManagingKeyword_0());
            		
            // InternalSasDsl.g:2605:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2606:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2606:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2607:5: lv_name_1_0= RULE_ID
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
            		
            // InternalSasDsl.g:2627:3: ( (lv_managerController_3_0= ruleDSLManagerController ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==32) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalSasDsl.g:2628:4: (lv_managerController_3_0= ruleDSLManagerController )
            	    {
            	    // InternalSasDsl.g:2628:4: (lv_managerController_3_0= ruleDSLManagerController )
            	    // InternalSasDsl.g:2629:5: lv_managerController_3_0= ruleDSLManagerController
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
            	    break loop42;
                }
            } while (true);

            // InternalSasDsl.g:2646:3: ( (lv_controller_4_0= ruleDSLController ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==33) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalSasDsl.g:2647:4: (lv_controller_4_0= ruleDSLController )
            	    {
            	    // InternalSasDsl.g:2647:4: (lv_controller_4_0= ruleDSLController )
            	    // InternalSasDsl.g:2648:5: lv_controller_4_0= ruleDSLController
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
            	    break loop43;
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
    // InternalSasDsl.g:2673:1: entryRuleDSLManaged returns [EObject current=null] : iv_ruleDSLManaged= ruleDSLManaged EOF ;
    public final EObject entryRuleDSLManaged() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLManaged = null;


        try {
            // InternalSasDsl.g:2673:51: (iv_ruleDSLManaged= ruleDSLManaged EOF )
            // InternalSasDsl.g:2674:2: iv_ruleDSLManaged= ruleDSLManaged EOF
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
    // InternalSasDsl.g:2680:1: ruleDSLManaged returns [EObject current=null] : (otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )* ( (lv_effector_4_0= ruleDSLEffector ) )* ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )* otherlv_6= '}' ) ;
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
            // InternalSasDsl.g:2686:2: ( (otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )* ( (lv_effector_4_0= ruleDSLEffector ) )* ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )* otherlv_6= '}' ) )
            // InternalSasDsl.g:2687:2: (otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )* ( (lv_effector_4_0= ruleDSLEffector ) )* ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )* otherlv_6= '}' )
            {
            // InternalSasDsl.g:2687:2: (otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )* ( (lv_effector_4_0= ruleDSLEffector ) )* ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )* otherlv_6= '}' )
            // InternalSasDsl.g:2688:3: otherlv_0= 'Managed' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensor_3_0= ruleDSLSensor ) )* ( (lv_effector_4_0= ruleDSLEffector ) )* ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLManagedAccess().getManagedKeyword_0());
            		
            // InternalSasDsl.g:2692:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2693:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2693:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2694:5: lv_name_1_0= RULE_ID
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
            		
            // InternalSasDsl.g:2714:3: ( (lv_sensor_3_0= ruleDSLSensor ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==40) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalSasDsl.g:2715:4: (lv_sensor_3_0= ruleDSLSensor )
            	    {
            	    // InternalSasDsl.g:2715:4: (lv_sensor_3_0= ruleDSLSensor )
            	    // InternalSasDsl.g:2716:5: lv_sensor_3_0= ruleDSLSensor
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
            	    break loop44;
                }
            } while (true);

            // InternalSasDsl.g:2733:3: ( (lv_effector_4_0= ruleDSLEffector ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==41) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalSasDsl.g:2734:4: (lv_effector_4_0= ruleDSLEffector )
            	    {
            	    // InternalSasDsl.g:2734:4: (lv_effector_4_0= ruleDSLEffector )
            	    // InternalSasDsl.g:2735:5: lv_effector_4_0= ruleDSLEffector
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
            	    break loop45;
                }
            } while (true);

            // InternalSasDsl.g:2752:3: ( (lv_measuredOutput_5_0= ruleDSLMeasuredOutput ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==43) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalSasDsl.g:2753:4: (lv_measuredOutput_5_0= ruleDSLMeasuredOutput )
            	    {
            	    // InternalSasDsl.g:2753:4: (lv_measuredOutput_5_0= ruleDSLMeasuredOutput )
            	    // InternalSasDsl.g:2754:5: lv_measuredOutput_5_0= ruleDSLMeasuredOutput
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
            	    break loop46;
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
    // InternalSasDsl.g:2779:1: entryRuleDSLManagerController returns [EObject current=null] : iv_ruleDSLManagerController= ruleDSLManagerController EOF ;
    public final EObject entryRuleDSLManagerController() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLManagerController = null;


        try {
            // InternalSasDsl.g:2779:61: (iv_ruleDSLManagerController= ruleDSLManagerController EOF )
            // InternalSasDsl.g:2780:2: iv_ruleDSLManagerController= ruleDSLManagerController EOF
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
    // InternalSasDsl.g:2786:1: ruleDSLManagerController returns [EObject current=null] : (otherlv_0= 'LoopManager' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_controller_3_0= ruleDSLController ) )+ otherlv_4= '}' ) ;
    public final EObject ruleDSLManagerController() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_controller_3_0 = null;



        	enterRule();

        try {
            // InternalSasDsl.g:2792:2: ( (otherlv_0= 'LoopManager' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_controller_3_0= ruleDSLController ) )+ otherlv_4= '}' ) )
            // InternalSasDsl.g:2793:2: (otherlv_0= 'LoopManager' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_controller_3_0= ruleDSLController ) )+ otherlv_4= '}' )
            {
            // InternalSasDsl.g:2793:2: (otherlv_0= 'LoopManager' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_controller_3_0= ruleDSLController ) )+ otherlv_4= '}' )
            // InternalSasDsl.g:2794:3: otherlv_0= 'LoopManager' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_controller_3_0= ruleDSLController ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLManagerControllerAccess().getLoopManagerKeyword_0());
            		
            // InternalSasDsl.g:2798:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2799:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2799:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2800:5: lv_name_1_0= RULE_ID
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
            		
            // InternalSasDsl.g:2820:3: ( (lv_controller_3_0= ruleDSLController ) )+
            int cnt47=0;
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==33) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalSasDsl.g:2821:4: (lv_controller_3_0= ruleDSLController )
            	    {
            	    // InternalSasDsl.g:2821:4: (lv_controller_3_0= ruleDSLController )
            	    // InternalSasDsl.g:2822:5: lv_controller_3_0= ruleDSLController
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
            	    if ( cnt47 >= 1 ) break loop47;
                        EarlyExitException eee =
                            new EarlyExitException(47, input);
                        throw eee;
                }
                cnt47++;
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
    // InternalSasDsl.g:2847:1: entryRuleDSLController returns [EObject current=null] : iv_ruleDSLController= ruleDSLController EOF ;
    public final EObject entryRuleDSLController() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLController = null;


        try {
            // InternalSasDsl.g:2847:54: (iv_ruleDSLController= ruleDSLController EOF )
            // InternalSasDsl.g:2848:2: iv_ruleDSLController= ruleDSLController EOF
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
    // InternalSasDsl.g:2854:1: ruleDSLController returns [EObject current=null] : (otherlv_0= 'Loop' ( (lv_name_1_0= RULE_ID ) ) ( (lv_domain_2_0= ruleDSLDomainRule ) )? otherlv_3= '{' ( (lv_monitor_4_0= ruleDSLMonitor ) )+ ( (lv_analyzer_5_0= ruleDSLAnalyzer ) )+ ( (lv_planner_6_0= ruleDSLPlanner ) )* ( (lv_executor_7_0= ruleDSLExecutor ) )+ ( (lv_knowledge_8_0= ruleDSLKnowledge ) )* otherlv_9= '}' ) ;
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
            // InternalSasDsl.g:2860:2: ( (otherlv_0= 'Loop' ( (lv_name_1_0= RULE_ID ) ) ( (lv_domain_2_0= ruleDSLDomainRule ) )? otherlv_3= '{' ( (lv_monitor_4_0= ruleDSLMonitor ) )+ ( (lv_analyzer_5_0= ruleDSLAnalyzer ) )+ ( (lv_planner_6_0= ruleDSLPlanner ) )* ( (lv_executor_7_0= ruleDSLExecutor ) )+ ( (lv_knowledge_8_0= ruleDSLKnowledge ) )* otherlv_9= '}' ) )
            // InternalSasDsl.g:2861:2: (otherlv_0= 'Loop' ( (lv_name_1_0= RULE_ID ) ) ( (lv_domain_2_0= ruleDSLDomainRule ) )? otherlv_3= '{' ( (lv_monitor_4_0= ruleDSLMonitor ) )+ ( (lv_analyzer_5_0= ruleDSLAnalyzer ) )+ ( (lv_planner_6_0= ruleDSLPlanner ) )* ( (lv_executor_7_0= ruleDSLExecutor ) )+ ( (lv_knowledge_8_0= ruleDSLKnowledge ) )* otherlv_9= '}' )
            {
            // InternalSasDsl.g:2861:2: (otherlv_0= 'Loop' ( (lv_name_1_0= RULE_ID ) ) ( (lv_domain_2_0= ruleDSLDomainRule ) )? otherlv_3= '{' ( (lv_monitor_4_0= ruleDSLMonitor ) )+ ( (lv_analyzer_5_0= ruleDSLAnalyzer ) )+ ( (lv_planner_6_0= ruleDSLPlanner ) )* ( (lv_executor_7_0= ruleDSLExecutor ) )+ ( (lv_knowledge_8_0= ruleDSLKnowledge ) )* otherlv_9= '}' )
            // InternalSasDsl.g:2862:3: otherlv_0= 'Loop' ( (lv_name_1_0= RULE_ID ) ) ( (lv_domain_2_0= ruleDSLDomainRule ) )? otherlv_3= '{' ( (lv_monitor_4_0= ruleDSLMonitor ) )+ ( (lv_analyzer_5_0= ruleDSLAnalyzer ) )+ ( (lv_planner_6_0= ruleDSLPlanner ) )* ( (lv_executor_7_0= ruleDSLExecutor ) )+ ( (lv_knowledge_8_0= ruleDSLKnowledge ) )* otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLControllerAccess().getLoopKeyword_0());
            		
            // InternalSasDsl.g:2866:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:2867:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:2867:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:2868:5: lv_name_1_0= RULE_ID
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

            // InternalSasDsl.g:2884:3: ( (lv_domain_2_0= ruleDSLDomainRule ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID||LA48_0==34) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalSasDsl.g:2885:4: (lv_domain_2_0= ruleDSLDomainRule )
                    {
                    // InternalSasDsl.g:2885:4: (lv_domain_2_0= ruleDSLDomainRule )
                    // InternalSasDsl.g:2886:5: lv_domain_2_0= ruleDSLDomainRule
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
            		
            // InternalSasDsl.g:2907:3: ( (lv_monitor_4_0= ruleDSLMonitor ) )+
            int cnt49=0;
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==35) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalSasDsl.g:2908:4: (lv_monitor_4_0= ruleDSLMonitor )
            	    {
            	    // InternalSasDsl.g:2908:4: (lv_monitor_4_0= ruleDSLMonitor )
            	    // InternalSasDsl.g:2909:5: lv_monitor_4_0= ruleDSLMonitor
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
            	    if ( cnt49 >= 1 ) break loop49;
                        EarlyExitException eee =
                            new EarlyExitException(49, input);
                        throw eee;
                }
                cnt49++;
            } while (true);

            // InternalSasDsl.g:2926:3: ( (lv_analyzer_5_0= ruleDSLAnalyzer ) )+
            int cnt50=0;
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==36) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalSasDsl.g:2927:4: (lv_analyzer_5_0= ruleDSLAnalyzer )
            	    {
            	    // InternalSasDsl.g:2927:4: (lv_analyzer_5_0= ruleDSLAnalyzer )
            	    // InternalSasDsl.g:2928:5: lv_analyzer_5_0= ruleDSLAnalyzer
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
            	    if ( cnt50 >= 1 ) break loop50;
                        EarlyExitException eee =
                            new EarlyExitException(50, input);
                        throw eee;
                }
                cnt50++;
            } while (true);

            // InternalSasDsl.g:2945:3: ( (lv_planner_6_0= ruleDSLPlanner ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==37) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalSasDsl.g:2946:4: (lv_planner_6_0= ruleDSLPlanner )
            	    {
            	    // InternalSasDsl.g:2946:4: (lv_planner_6_0= ruleDSLPlanner )
            	    // InternalSasDsl.g:2947:5: lv_planner_6_0= ruleDSLPlanner
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
            	    break loop51;
                }
            } while (true);

            // InternalSasDsl.g:2964:3: ( (lv_executor_7_0= ruleDSLExecutor ) )+
            int cnt52=0;
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==38) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalSasDsl.g:2965:4: (lv_executor_7_0= ruleDSLExecutor )
            	    {
            	    // InternalSasDsl.g:2965:4: (lv_executor_7_0= ruleDSLExecutor )
            	    // InternalSasDsl.g:2966:5: lv_executor_7_0= ruleDSLExecutor
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
            	    if ( cnt52 >= 1 ) break loop52;
                        EarlyExitException eee =
                            new EarlyExitException(52, input);
                        throw eee;
                }
                cnt52++;
            } while (true);

            // InternalSasDsl.g:2983:3: ( (lv_knowledge_8_0= ruleDSLKnowledge ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==39) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalSasDsl.g:2984:4: (lv_knowledge_8_0= ruleDSLKnowledge )
            	    {
            	    // InternalSasDsl.g:2984:4: (lv_knowledge_8_0= ruleDSLKnowledge )
            	    // InternalSasDsl.g:2985:5: lv_knowledge_8_0= ruleDSLKnowledge
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
            	    break loop53;
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
    // InternalSasDsl.g:3010:1: entryRuleDSLDomainRule returns [EObject current=null] : iv_ruleDSLDomainRule= ruleDSLDomainRule EOF ;
    public final EObject entryRuleDSLDomainRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLDomainRule = null;


        try {
            // InternalSasDsl.g:3010:54: (iv_ruleDSLDomainRule= ruleDSLDomainRule EOF )
            // InternalSasDsl.g:3011:2: iv_ruleDSLDomainRule= ruleDSLDomainRule EOF
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
    // InternalSasDsl.g:3017:1: ruleDSLDomainRule returns [EObject current=null] : ( ( (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' ) ) ) ;
    public final EObject ruleDSLDomainRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_1=null;
        Token lv_value_0_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3023:2: ( ( ( (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' ) ) ) )
            // InternalSasDsl.g:3024:2: ( ( (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' ) ) )
            {
            // InternalSasDsl.g:3024:2: ( ( (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' ) ) )
            // InternalSasDsl.g:3025:3: ( (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' ) )
            {
            // InternalSasDsl.g:3025:3: ( (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' ) )
            // InternalSasDsl.g:3026:4: (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' )
            {
            // InternalSasDsl.g:3026:4: (lv_value_0_1= RULE_ID | lv_value_0_2= 'withDomainRules' )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                alt54=1;
            }
            else if ( (LA54_0==34) ) {
                alt54=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // InternalSasDsl.g:3027:5: lv_value_0_1= RULE_ID
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
                    // InternalSasDsl.g:3042:5: lv_value_0_2= 'withDomainRules'
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
    // InternalSasDsl.g:3058:1: entryRuleDSLMonitor returns [EObject current=null] : iv_ruleDSLMonitor= ruleDSLMonitor EOF ;
    public final EObject entryRuleDSLMonitor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLMonitor = null;


        try {
            // InternalSasDsl.g:3058:51: (iv_ruleDSLMonitor= ruleDSLMonitor EOF )
            // InternalSasDsl.g:3059:2: iv_ruleDSLMonitor= ruleDSLMonitor EOF
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
    // InternalSasDsl.g:3065:1: ruleDSLMonitor returns [EObject current=null] : (otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLMonitor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3071:2: ( (otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:3072:2: (otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:3072:2: (otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:3073:3: otherlv_0= 'Monitor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLMonitorAccess().getMonitorKeyword_0());
            		
            // InternalSasDsl.g:3077:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3078:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3078:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3079:5: lv_name_1_0= RULE_ID
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
    // InternalSasDsl.g:3103:1: entryRuleDSLAnalyzer returns [EObject current=null] : iv_ruleDSLAnalyzer= ruleDSLAnalyzer EOF ;
    public final EObject entryRuleDSLAnalyzer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLAnalyzer = null;


        try {
            // InternalSasDsl.g:3103:52: (iv_ruleDSLAnalyzer= ruleDSLAnalyzer EOF )
            // InternalSasDsl.g:3104:2: iv_ruleDSLAnalyzer= ruleDSLAnalyzer EOF
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
    // InternalSasDsl.g:3110:1: ruleDSLAnalyzer returns [EObject current=null] : (otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLAnalyzer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3116:2: ( (otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:3117:2: (otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:3117:2: (otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:3118:3: otherlv_0= 'Analyzer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLAnalyzerAccess().getAnalyzerKeyword_0());
            		
            // InternalSasDsl.g:3122:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3123:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3123:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3124:5: lv_name_1_0= RULE_ID
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
    // InternalSasDsl.g:3148:1: entryRuleDSLPlanner returns [EObject current=null] : iv_ruleDSLPlanner= ruleDSLPlanner EOF ;
    public final EObject entryRuleDSLPlanner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLPlanner = null;


        try {
            // InternalSasDsl.g:3148:51: (iv_ruleDSLPlanner= ruleDSLPlanner EOF )
            // InternalSasDsl.g:3149:2: iv_ruleDSLPlanner= ruleDSLPlanner EOF
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
    // InternalSasDsl.g:3155:1: ruleDSLPlanner returns [EObject current=null] : (otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLPlanner() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3161:2: ( (otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:3162:2: (otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:3162:2: (otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:3163:3: otherlv_0= 'Planner' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLPlannerAccess().getPlannerKeyword_0());
            		
            // InternalSasDsl.g:3167:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3168:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3168:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3169:5: lv_name_1_0= RULE_ID
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
    // InternalSasDsl.g:3193:1: entryRuleDSLExecutor returns [EObject current=null] : iv_ruleDSLExecutor= ruleDSLExecutor EOF ;
    public final EObject entryRuleDSLExecutor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLExecutor = null;


        try {
            // InternalSasDsl.g:3193:52: (iv_ruleDSLExecutor= ruleDSLExecutor EOF )
            // InternalSasDsl.g:3194:2: iv_ruleDSLExecutor= ruleDSLExecutor EOF
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
    // InternalSasDsl.g:3200:1: ruleDSLExecutor returns [EObject current=null] : (otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLExecutor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3206:2: ( (otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:3207:2: (otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:3207:2: (otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:3208:3: otherlv_0= 'Executor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLExecutorAccess().getExecutorKeyword_0());
            		
            // InternalSasDsl.g:3212:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3213:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3213:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3214:5: lv_name_1_0= RULE_ID
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
    // InternalSasDsl.g:3238:1: entryRuleDSLKnowledge returns [EObject current=null] : iv_ruleDSLKnowledge= ruleDSLKnowledge EOF ;
    public final EObject entryRuleDSLKnowledge() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLKnowledge = null;


        try {
            // InternalSasDsl.g:3238:53: (iv_ruleDSLKnowledge= ruleDSLKnowledge EOF )
            // InternalSasDsl.g:3239:2: iv_ruleDSLKnowledge= ruleDSLKnowledge EOF
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
    // InternalSasDsl.g:3245:1: ruleDSLKnowledge returns [EObject current=null] : (otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )* ( (lv_shalt_4_0= ruleDSLAlternative ) )* otherlv_5= '}' ) ;
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
            // InternalSasDsl.g:3251:2: ( (otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )* ( (lv_shalt_4_0= ruleDSLAlternative ) )* otherlv_5= '}' ) )
            // InternalSasDsl.g:3252:2: (otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )* ( (lv_shalt_4_0= ruleDSLAlternative ) )* otherlv_5= '}' )
            {
            // InternalSasDsl.g:3252:2: (otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )* ( (lv_shalt_4_0= ruleDSLAlternative ) )* otherlv_5= '}' )
            // InternalSasDsl.g:3253:3: otherlv_0= 'Knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )* ( (lv_shalt_4_0= ruleDSLAlternative ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLKnowledgeAccess().getKnowledgeKeyword_0());
            		
            // InternalSasDsl.g:3257:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3258:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3258:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3259:5: lv_name_1_0= RULE_ID
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
            		
            // InternalSasDsl.g:3279:3: ( (lv_referenceInput_3_0= ruleDSLReferenceInput ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==42) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalSasDsl.g:3280:4: (lv_referenceInput_3_0= ruleDSLReferenceInput )
            	    {
            	    // InternalSasDsl.g:3280:4: (lv_referenceInput_3_0= ruleDSLReferenceInput )
            	    // InternalSasDsl.g:3281:5: lv_referenceInput_3_0= ruleDSLReferenceInput
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
            	    break loop55;
                }
            } while (true);

            // InternalSasDsl.g:3298:3: ( (lv_shalt_4_0= ruleDSLAlternative ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==44) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalSasDsl.g:3299:4: (lv_shalt_4_0= ruleDSLAlternative )
            	    {
            	    // InternalSasDsl.g:3299:4: (lv_shalt_4_0= ruleDSLAlternative )
            	    // InternalSasDsl.g:3300:5: lv_shalt_4_0= ruleDSLAlternative
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
            	    break loop56;
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
    // InternalSasDsl.g:3325:1: entryRuleDSLSensor returns [EObject current=null] : iv_ruleDSLSensor= ruleDSLSensor EOF ;
    public final EObject entryRuleDSLSensor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLSensor = null;


        try {
            // InternalSasDsl.g:3325:50: (iv_ruleDSLSensor= ruleDSLSensor EOF )
            // InternalSasDsl.g:3326:2: iv_ruleDSLSensor= ruleDSLSensor EOF
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
    // InternalSasDsl.g:3332:1: ruleDSLSensor returns [EObject current=null] : (otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLSensor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3338:2: ( (otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:3339:2: (otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:3339:2: (otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:3340:3: otherlv_0= 'Sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLSensorAccess().getSensorKeyword_0());
            		
            // InternalSasDsl.g:3344:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3345:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3345:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3346:5: lv_name_1_0= RULE_ID
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
    // InternalSasDsl.g:3370:1: entryRuleDSLEffector returns [EObject current=null] : iv_ruleDSLEffector= ruleDSLEffector EOF ;
    public final EObject entryRuleDSLEffector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLEffector = null;


        try {
            // InternalSasDsl.g:3370:52: (iv_ruleDSLEffector= ruleDSLEffector EOF )
            // InternalSasDsl.g:3371:2: iv_ruleDSLEffector= ruleDSLEffector EOF
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
    // InternalSasDsl.g:3377:1: ruleDSLEffector returns [EObject current=null] : (otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLEffector() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3383:2: ( (otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:3384:2: (otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:3384:2: (otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:3385:3: otherlv_0= 'Effector' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLEffectorAccess().getEffectorKeyword_0());
            		
            // InternalSasDsl.g:3389:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3390:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3390:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3391:5: lv_name_1_0= RULE_ID
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
    // InternalSasDsl.g:3415:1: entryRuleDSLReferenceInput returns [EObject current=null] : iv_ruleDSLReferenceInput= ruleDSLReferenceInput EOF ;
    public final EObject entryRuleDSLReferenceInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLReferenceInput = null;


        try {
            // InternalSasDsl.g:3415:58: (iv_ruleDSLReferenceInput= ruleDSLReferenceInput EOF )
            // InternalSasDsl.g:3416:2: iv_ruleDSLReferenceInput= ruleDSLReferenceInput EOF
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
    // InternalSasDsl.g:3422:1: ruleDSLReferenceInput returns [EObject current=null] : (otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLReferenceInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3428:2: ( (otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:3429:2: (otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:3429:2: (otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:3430:3: otherlv_0= 'ReferenceInput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLReferenceInputAccess().getReferenceInputKeyword_0());
            		
            // InternalSasDsl.g:3434:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3435:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3435:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3436:5: lv_name_1_0= RULE_ID
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
    // InternalSasDsl.g:3460:1: entryRuleDSLMeasuredOutput returns [EObject current=null] : iv_ruleDSLMeasuredOutput= ruleDSLMeasuredOutput EOF ;
    public final EObject entryRuleDSLMeasuredOutput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLMeasuredOutput = null;


        try {
            // InternalSasDsl.g:3460:58: (iv_ruleDSLMeasuredOutput= ruleDSLMeasuredOutput EOF )
            // InternalSasDsl.g:3461:2: iv_ruleDSLMeasuredOutput= ruleDSLMeasuredOutput EOF
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
    // InternalSasDsl.g:3467:1: ruleDSLMeasuredOutput returns [EObject current=null] : (otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLMeasuredOutput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3473:2: ( (otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:3474:2: (otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:3474:2: (otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:3475:3: otherlv_0= 'MeasuredOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLMeasuredOutputAccess().getMeasuredOutputKeyword_0());
            		
            // InternalSasDsl.g:3479:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3480:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3480:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3481:5: lv_name_1_0= RULE_ID
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
    // InternalSasDsl.g:3505:1: entryRuleDSLAlternative returns [EObject current=null] : iv_ruleDSLAlternative= ruleDSLAlternative EOF ;
    public final EObject entryRuleDSLAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDSLAlternative = null;


        try {
            // InternalSasDsl.g:3505:55: (iv_ruleDSLAlternative= ruleDSLAlternative EOF )
            // InternalSasDsl.g:3506:2: iv_ruleDSLAlternative= ruleDSLAlternative EOF
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
    // InternalSasDsl.g:3512:1: ruleDSLAlternative returns [EObject current=null] : (otherlv_0= 'Alternative' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDSLAlternative() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSasDsl.g:3518:2: ( (otherlv_0= 'Alternative' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSasDsl.g:3519:2: (otherlv_0= 'Alternative' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSasDsl.g:3519:2: (otherlv_0= 'Alternative' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSasDsl.g:3520:3: otherlv_0= 'Alternative' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDSLAlternativeAccess().getAlternativeKeyword_0());
            		
            // InternalSasDsl.g:3524:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSasDsl.g:3525:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSasDsl.g:3525:4: (lv_name_1_0= RULE_ID )
            // InternalSasDsl.g:3526:5: lv_name_1_0= RULE_ID
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


    protected DFA13 dfa13 = new DFA13(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA35 dfa35 = new DFA35(this);
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

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "454:2: ( (otherlv_0= 'monitor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'monitor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'monitor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'monitor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'monitor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'monitor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'sensor' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) )";
        }
    }
    static final String dfa_7s = "\14\uffff";
    static final String dfa_8s = "\1\25\1\4\1\20\2\24\7\uffff";
    static final String dfa_9s = "\1\25\1\4\1\21\2\33\7\uffff";
    static final String dfa_10s = "\5\uffff\1\3\1\2\1\1\1\7\1\6\1\5\1\4";
    static final String dfa_11s = "\14\uffff}>";
    static final String[] dfa_12s = {
            "\1\1",
            "\1\2",
            "\1\3\1\4",
            "\1\7\1\6\1\5\1\13\1\12\1\uffff\1\11\1\10",
            "\1\7\1\6\1\5\1\13\1\12\1\uffff\1\11\1\10",
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

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "880:2: ( (otherlv_0= 'analyzer' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'analyzer' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'analyzer' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'analyzer' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'analyzer' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'analyzer' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'reference-input' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) | (otherlv_36= 'analyzer' ( (otherlv_37= RULE_ID ) ) ( ( (lv_access_38_1= 'must-use' | lv_access_38_2= 'must-not-use' ) ) ) otherlv_39= 'alternative' ( (otherlv_40= RULE_ID ) ) otherlv_41= ';' ) )";
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

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_13;
            this.max = dfa_14;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_15;
        }
        public String getDescription() {
            return "1374:2: ( (otherlv_0= 'planner' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'planner' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'planner' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'planner' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'planner' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'planner' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'alternative' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) )";
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

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "1800:2: ( (otherlv_0= 'executor' ( (otherlv_1= RULE_ID ) ) ( ( (lv_access_2_1= 'must-use' | lv_access_2_2= 'must-not-use' ) ) ) otherlv_3= 'monitor' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) | (otherlv_6= 'executor' ( (otherlv_7= RULE_ID ) ) ( ( (lv_access_8_1= 'must-use' | lv_access_8_2= 'must-not-use' ) ) ) otherlv_9= 'analyzer' ( (otherlv_10= RULE_ID ) ) otherlv_11= ';' ) | (otherlv_12= 'executor' ( (otherlv_13= RULE_ID ) ) ( ( (lv_access_14_1= 'must-use' | lv_access_14_2= 'must-not-use' ) ) ) otherlv_15= 'planner' ( (otherlv_16= RULE_ID ) ) otherlv_17= ';' ) | (otherlv_18= 'executor' ( (otherlv_19= RULE_ID ) ) ( ( (lv_access_20_1= 'must-use' | lv_access_20_2= 'must-not-use' ) ) ) otherlv_21= 'executor' ( (otherlv_22= RULE_ID ) ) otherlv_23= ';' ) | (otherlv_24= 'executor' ( (otherlv_25= RULE_ID ) ) ( ( (lv_access_26_1= 'must-use' | lv_access_26_2= 'must-not-use' ) ) ) otherlv_27= 'knowledge' ( (otherlv_28= RULE_ID ) ) otherlv_29= ';' ) | (otherlv_30= 'executor' ( (otherlv_31= RULE_ID ) ) ( ( (lv_access_32_1= 'must-use' | lv_access_32_2= 'must-not-use' ) ) ) otherlv_33= 'effector' ( (otherlv_34= RULE_ID ) ) otherlv_35= ';' ) )";
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
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000003F8A000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000800000L});
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