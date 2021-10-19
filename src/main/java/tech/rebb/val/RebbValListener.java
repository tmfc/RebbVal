// Generated from RebbVal.g4 by ANTLR 4.9
package tech.rebb.val;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RebbValParser}.
 */
public interface RebbValListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link RebbValParser#unaryTests}.
	 * @param ctx the parse tree
	 */
	void enterDisjunction(RebbValParser.DisjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link RebbValParser#unaryTests}.
	 * @param ctx the parse tree
	 */
	void exitDisjunction(RebbValParser.DisjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Conjunction}
	 * labeled alternative in {@link RebbValParser#unaryTests}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(RebbValParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Conjunction}
	 * labeled alternative in {@link RebbValParser#unaryTests}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(RebbValParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleTest}
	 * labeled alternative in {@link RebbValParser#unaryTests}.
	 * @param ctx the parse tree
	 */
	void enterSingleTest(RebbValParser.SingleTestContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleTest}
	 * labeled alternative in {@link RebbValParser#unaryTests}.
	 * @param ctx the parse tree
	 */
	void exitSingleTest(RebbValParser.SingleTestContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NormalUnaryTest}
	 * labeled alternative in {@link RebbValParser#unaryTest}.
	 * @param ctx the parse tree
	 */
	void enterNormalUnaryTest(RebbValParser.NormalUnaryTestContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NormalUnaryTest}
	 * labeled alternative in {@link RebbValParser#unaryTest}.
	 * @param ctx the parse tree
	 */
	void exitNormalUnaryTest(RebbValParser.NormalUnaryTestContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegationUnaryTest}
	 * labeled alternative in {@link RebbValParser#unaryTest}.
	 * @param ctx the parse tree
	 */
	void enterNegationUnaryTest(RebbValParser.NegationUnaryTestContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegationUnaryTest}
	 * labeled alternative in {@link RebbValParser#unaryTest}.
	 * @param ctx the parse tree
	 */
	void exitNegationUnaryTest(RebbValParser.NegationUnaryTestContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IgnoreUnaryTest}
	 * labeled alternative in {@link RebbValParser#unaryTest}.
	 * @param ctx the parse tree
	 */
	void enterIgnoreUnaryTest(RebbValParser.IgnoreUnaryTestContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IgnoreUnaryTest}
	 * labeled alternative in {@link RebbValParser#unaryTest}.
	 * @param ctx the parse tree
	 */
	void exitIgnoreUnaryTest(RebbValParser.IgnoreUnaryTestContext ctx);
	/**
	 * Enter a parse tree produced by {@link RebbValParser#positiveUnaryTest}.
	 * @param ctx the parse tree
	 */
	void enterPositiveUnaryTest(RebbValParser.PositiveUnaryTestContext ctx);
	/**
	 * Exit a parse tree produced by {@link RebbValParser#positiveUnaryTest}.
	 * @param ctx the parse tree
	 */
	void exitPositiveUnaryTest(RebbValParser.PositiveUnaryTestContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCompare(RebbValParser.CompareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCompare(RebbValParser.CompareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Between}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBetween(RebbValParser.BetweenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Between}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBetween(RebbValParser.BetweenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code In}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIn(RebbValParser.InContext ctx);
	/**
	 * Exit a parse tree produced by the {@code In}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIn(RebbValParser.InContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Contains}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterContains(RebbValParser.ContainsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Contains}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitContains(RebbValParser.ContainsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotEmpty}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotEmpty(RebbValParser.NotEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotEmpty}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotEmpty(RebbValParser.NotEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MaxLength}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMaxLength(RebbValParser.MaxLengthContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MaxLength}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMaxLength(RebbValParser.MaxLengthContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Is}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIs(RebbValParser.IsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Is}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIs(RebbValParser.IsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IsHex}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIsHex(RebbValParser.IsHexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IsHex}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIsHex(RebbValParser.IsHexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IsCustom}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIsCustom(RebbValParser.IsCustomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IsCustom}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIsCustom(RebbValParser.IsCustomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Match}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMatch(RebbValParser.MatchContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Match}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMatch(RebbValParser.MatchContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AgeCompare}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAgeCompare(RebbValParser.AgeCompareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AgeCompare}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAgeCompare(RebbValParser.AgeCompareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringPosition}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringPosition(RebbValParser.StringPositionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringPosition}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringPosition(RebbValParser.StringPositionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Interval}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInterval(RebbValParser.IntervalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Interval}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInterval(RebbValParser.IntervalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Array}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArray(RebbValParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Array}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArray(RebbValParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterString(RebbValParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitString(RebbValParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumber(RebbValParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumber(RebbValParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code date}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDate(RebbValParser.DateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code date}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDate(RebbValParser.DateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code time}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTime(RebbValParser.TimeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code time}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTime(RebbValParser.TimeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RebbValParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(RebbValParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link RebbValParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(RebbValParser.ArrayLiteralContext ctx);
}