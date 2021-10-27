package tech.rebb.val;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.Objects;

/**
 * Error listener that save error for later usage
 * @author William
 * @version 1.0.0
 */
public class RebbValErrorListener extends BaseErrorListener {
    private String error = "";

    public static final RebbValErrorListener INSTANCE = new RebbValErrorListener();

    public RebbValErrorListener() {
    }

    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        this.error = "line " + line + ":" + charPositionInLine + " " + msg;
    }

    public String getError()
    {
        return this.error;
    }

    public void clearError() { this.error = ""; }

    public boolean hasError()
    {
        return !Objects.equals(this.error, "");
    }
}
