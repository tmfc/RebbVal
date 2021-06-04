// Generated from RebbVal.g4 by ANTLR 4.9
package com.rebb.val;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RebbValParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RebbValVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link RebbValParser#unaryTests}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunction(RebbValParser.DisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Conjunction}
	 * labeled alternative in {@link RebbValParser#unaryTests}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(RebbValParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleTest}
	 * labeled alternative in {@link RebbValParser#unaryTests}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleTest(RebbValParser.SingleTestContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NormalUnaryTest}
	 * labeled alternative in {@link RebbValParser#unaryTest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalUnaryTest(RebbValParser.NormalUnaryTestContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegationUnaryTest}
	 * labeled alternative in {@link RebbValParser#unaryTest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegationUnaryTest(RebbValParser.NegationUnaryTestContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IgnoreUnaryTest}
	 * labeled alternative in {@link RebbValParser#unaryTest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnoreUnaryTest(RebbValParser.IgnoreUnaryTestContext ctx);
	/**
	 * Visit a parse tree produced by {@link RebbValParser#positiveUnaryTest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositiveUnaryTest(RebbValParser.PositiveUnaryTestContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(RebbValParser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Between}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetween(RebbValParser.BetweenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code In}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn(RebbValParser.InContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Contains}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContains(RebbValParser.ContainsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotEmpty}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEmpty(RebbValParser.NotEmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MaxLength}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxLength(RebbValParser.MaxLengthContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Is}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIs(RebbValParser.IsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IsHex}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsHex(RebbValParser.IsHexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IsCustom}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsCustom(RebbValParser.IsCustomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Match}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatch(RebbValParser.MatchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AgeCompare}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgeCompare(RebbValParser.AgeCompareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringPosition}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringPosition(RebbValParser.StringPositionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Interval}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterval(RebbValParser.IntervalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Array}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(RebbValParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(RebbValParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code number}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(RebbValParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code date}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(RebbValParser.DateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code time}
	 * labeled alternative in {@link RebbValParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime(RebbValParser.TimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RebbValParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(RebbValParser.ArrayLiteralContext ctx);
}