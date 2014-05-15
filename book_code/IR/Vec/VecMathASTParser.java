// $ANTLR 3.2 Sep 23, 2009 12:02:23 VecMathAST.g 2014-05-15 18:43:32

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class VecMathASTParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "VEC", "ID", "INT", "WS", "'='", "'print'", "'+'", "'*'", "'.'", "'['", "','", "']'"
    };
    public static final int VEC=4;
    public static final int WS=7;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int INT=6;
    public static final int ID=5;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;

    // delegates
    // delegators


        public VecMathASTParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public VecMathASTParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return VecMathASTParser.tokenNames; }
    public String getGrammarFileName() { return "VecMathAST.g"; }


    public static class statlist_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statlist"
    // VecMathAST.g:8:1: statlist : ( stat )+ ;
    public final VecMathASTParser.statlist_return statlist() throws RecognitionException {
        VecMathASTParser.statlist_return retval = new VecMathASTParser.statlist_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        VecMathASTParser.stat_return stat1 = null;



        try {
            // VecMathAST.g:8:10: ( ( stat )+ )
            // VecMathAST.g:8:12: ( stat )+
            {
            root_0 = (Object)adaptor.nil();

            // VecMathAST.g:8:12: ( stat )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID||LA1_0==9) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // VecMathAST.g:8:12: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_statlist27);
            	    stat1=stat();

            	    state._fsp--;

            	    adaptor.addChild(root_0, stat1.getTree());

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


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statlist"

    public static class stat_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stat"
    // VecMathAST.g:9:1: stat : ( ID '=' expr -> ^( '=' ID expr ) | 'print' expr -> ^( 'print' expr ) );
    public final VecMathASTParser.stat_return stat() throws RecognitionException {
        VecMathASTParser.stat_return retval = new VecMathASTParser.stat_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID2=null;
        Token char_literal3=null;
        Token string_literal5=null;
        VecMathASTParser.expr_return expr4 = null;

        VecMathASTParser.expr_return expr6 = null;


        Object ID2_tree=null;
        Object char_literal3_tree=null;
        Object string_literal5_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_9=new RewriteRuleTokenStream(adaptor,"token 9");
        RewriteRuleTokenStream stream_8=new RewriteRuleTokenStream(adaptor,"token 8");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // VecMathAST.g:9:5: ( ID '=' expr -> ^( '=' ID expr ) | 'print' expr -> ^( 'print' expr ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==9) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // VecMathAST.g:9:7: ID '=' expr
                    {
                    ID2=(Token)match(input,ID,FOLLOW_ID_in_stat55);  
                    stream_ID.add(ID2);

                    char_literal3=(Token)match(input,8,FOLLOW_8_in_stat57);  
                    stream_8.add(char_literal3);

                    pushFollow(FOLLOW_expr_in_stat59);
                    expr4=expr();

                    state._fsp--;

                    stream_expr.add(expr4.getTree());


                    // AST REWRITE
                    // elements: 8, ID, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 9:20: -> ^( '=' ID expr )
                    {
                        // VecMathAST.g:9:23: ^( '=' ID expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_8.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // VecMathAST.g:10:7: 'print' expr
                    {
                    string_literal5=(Token)match(input,9,FOLLOW_9_in_stat80);  
                    stream_9.add(string_literal5);

                    pushFollow(FOLLOW_expr_in_stat82);
                    expr6=expr();

                    state._fsp--;

                    stream_expr.add(expr6.getTree());


                    // AST REWRITE
                    // elements: 9, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 10:20: -> ^( 'print' expr )
                    {
                        // VecMathAST.g:10:23: ^( 'print' expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_9.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "stat"

    public static class expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // VecMathAST.g:15:1: expr : multExpr ( '+' multExpr )* ;
    public final VecMathASTParser.expr_return expr() throws RecognitionException {
        VecMathASTParser.expr_return retval = new VecMathASTParser.expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal8=null;
        VecMathASTParser.multExpr_return multExpr7 = null;

        VecMathASTParser.multExpr_return multExpr9 = null;


        Object char_literal8_tree=null;

        try {
            // VecMathAST.g:15:5: ( multExpr ( '+' multExpr )* )
            // VecMathAST.g:15:9: multExpr ( '+' multExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_multExpr_in_expr107);
            multExpr7=multExpr();

            state._fsp--;

            adaptor.addChild(root_0, multExpr7.getTree());
            // VecMathAST.g:15:18: ( '+' multExpr )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==10) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // VecMathAST.g:15:19: '+' multExpr
            	    {
            	    char_literal8=(Token)match(input,10,FOLLOW_10_in_expr110); 
            	    char_literal8_tree = (Object)adaptor.create(char_literal8);
            	    root_0 = (Object)adaptor.becomeRoot(char_literal8_tree, root_0);

            	    pushFollow(FOLLOW_multExpr_in_expr113);
            	    multExpr9=multExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, multExpr9.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class multExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multExpr"
    // VecMathAST.g:16:1: multExpr : primary ( ( '*' | '.' ) primary )* ;
    public final VecMathASTParser.multExpr_return multExpr() throws RecognitionException {
        VecMathASTParser.multExpr_return retval = new VecMathASTParser.multExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal11=null;
        Token char_literal12=null;
        VecMathASTParser.primary_return primary10 = null;

        VecMathASTParser.primary_return primary13 = null;


        Object char_literal11_tree=null;
        Object char_literal12_tree=null;

        try {
            // VecMathAST.g:16:9: ( primary ( ( '*' | '.' ) primary )* )
            // VecMathAST.g:16:11: primary ( ( '*' | '.' ) primary )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_primary_in_multExpr130);
            primary10=primary();

            state._fsp--;

            adaptor.addChild(root_0, primary10.getTree());
            // VecMathAST.g:16:19: ( ( '*' | '.' ) primary )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=11 && LA5_0<=12)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // VecMathAST.g:16:20: ( '*' | '.' ) primary
            	    {
            	    // VecMathAST.g:16:20: ( '*' | '.' )
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==11) ) {
            	        alt4=1;
            	    }
            	    else if ( (LA4_0==12) ) {
            	        alt4=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // VecMathAST.g:16:21: '*'
            	            {
            	            char_literal11=(Token)match(input,11,FOLLOW_11_in_multExpr134); 
            	            char_literal11_tree = (Object)adaptor.create(char_literal11);
            	            root_0 = (Object)adaptor.becomeRoot(char_literal11_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            // VecMathAST.g:16:26: '.'
            	            {
            	            char_literal12=(Token)match(input,12,FOLLOW_12_in_multExpr137); 
            	            char_literal12_tree = (Object)adaptor.create(char_literal12);
            	            root_0 = (Object)adaptor.becomeRoot(char_literal12_tree, root_0);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_primary_in_multExpr141);
            	    primary13=primary();

            	    state._fsp--;

            	    adaptor.addChild(root_0, primary13.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "multExpr"

    public static class primary_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primary"
    // VecMathAST.g:17:1: primary : ( INT | ID | '[' expr ( ',' expr )* ']' -> ^( VEC ( expr )+ ) );
    public final VecMathASTParser.primary_return primary() throws RecognitionException {
        VecMathASTParser.primary_return retval = new VecMathASTParser.primary_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token INT14=null;
        Token ID15=null;
        Token char_literal16=null;
        Token char_literal18=null;
        Token char_literal20=null;
        VecMathASTParser.expr_return expr17 = null;

        VecMathASTParser.expr_return expr19 = null;


        Object INT14_tree=null;
        Object ID15_tree=null;
        Object char_literal16_tree=null;
        Object char_literal18_tree=null;
        Object char_literal20_tree=null;
        RewriteRuleTokenStream stream_15=new RewriteRuleTokenStream(adaptor,"token 15");
        RewriteRuleTokenStream stream_13=new RewriteRuleTokenStream(adaptor,"token 13");
        RewriteRuleTokenStream stream_14=new RewriteRuleTokenStream(adaptor,"token 14");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // VecMathAST.g:18:5: ( INT | ID | '[' expr ( ',' expr )* ']' -> ^( VEC ( expr )+ ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt7=1;
                }
                break;
            case ID:
                {
                alt7=2;
                }
                break;
            case 13:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // VecMathAST.g:18:9: INT
                    {
                    root_0 = (Object)adaptor.nil();

                    INT14=(Token)match(input,INT,FOLLOW_INT_in_primary158); 
                    INT14_tree = (Object)adaptor.create(INT14);
                    adaptor.addChild(root_0, INT14_tree);


                    }
                    break;
                case 2 :
                    // VecMathAST.g:19:9: ID
                    {
                    root_0 = (Object)adaptor.nil();

                    ID15=(Token)match(input,ID,FOLLOW_ID_in_primary171); 
                    ID15_tree = (Object)adaptor.create(ID15);
                    adaptor.addChild(root_0, ID15_tree);


                    }
                    break;
                case 3 :
                    // VecMathAST.g:20:9: '[' expr ( ',' expr )* ']'
                    {
                    char_literal16=(Token)match(input,13,FOLLOW_13_in_primary185);  
                    stream_13.add(char_literal16);

                    pushFollow(FOLLOW_expr_in_primary187);
                    expr17=expr();

                    state._fsp--;

                    stream_expr.add(expr17.getTree());
                    // VecMathAST.g:20:18: ( ',' expr )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==14) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // VecMathAST.g:20:19: ',' expr
                    	    {
                    	    char_literal18=(Token)match(input,14,FOLLOW_14_in_primary190);  
                    	    stream_14.add(char_literal18);

                    	    pushFollow(FOLLOW_expr_in_primary192);
                    	    expr19=expr();

                    	    state._fsp--;

                    	    stream_expr.add(expr19.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    char_literal20=(Token)match(input,15,FOLLOW_15_in_primary196);  
                    stream_15.add(char_literal20);



                    // AST REWRITE
                    // elements: expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 20:34: -> ^( VEC ( expr )+ )
                    {
                        // VecMathAST.g:20:37: ^( VEC ( expr )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VEC, "VEC"), root_1);

                        if ( !(stream_expr.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_expr.hasNext() ) {
                            adaptor.addChild(root_1, stream_expr.nextTree());

                        }
                        stream_expr.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "primary"

    // Delegated rules


 

    public static final BitSet FOLLOW_stat_in_statlist27 = new BitSet(new long[]{0x0000000000000222L});
    public static final BitSet FOLLOW_ID_in_stat55 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_stat57 = new BitSet(new long[]{0x0000000000002060L});
    public static final BitSet FOLLOW_expr_in_stat59 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_stat80 = new BitSet(new long[]{0x0000000000002060L});
    public static final BitSet FOLLOW_expr_in_stat82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multExpr_in_expr107 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_expr110 = new BitSet(new long[]{0x0000000000002060L});
    public static final BitSet FOLLOW_multExpr_in_expr113 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_primary_in_multExpr130 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_11_in_multExpr134 = new BitSet(new long[]{0x0000000000002060L});
    public static final BitSet FOLLOW_12_in_multExpr137 = new BitSet(new long[]{0x0000000000002060L});
    public static final BitSet FOLLOW_primary_in_multExpr141 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_INT_in_primary158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_primary171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_primary185 = new BitSet(new long[]{0x0000000000002060L});
    public static final BitSet FOLLOW_expr_in_primary187 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_primary190 = new BitSet(new long[]{0x0000000000002060L});
    public static final BitSet FOLLOW_expr_in_primary192 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_primary196 = new BitSet(new long[]{0x0000000000000002L});

}