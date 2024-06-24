package kotlinx.serialization.json.internal;

import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.internal.Constants;
import io.ktor.http.ContentTypesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbstractJsonLexer.kt */
/* loaded from: classes4.dex */
public abstract class AbstractJsonLexer {
    public int currentPosition;
    public String peekedString;
    public final JsonPath path = new JsonPath();
    public final StringBuilder escapedString = new StringBuilder();

    public static /* synthetic */ void fail$default(AbstractJsonLexer abstractJsonLexer, String str, int r3, String str2, int r5) {
        if ((r5 & 2) != 0) {
            r3 = abstractJsonLexer.currentPosition;
        }
        if ((r5 & 4) != 0) {
            str2 = "";
        }
        abstractJsonLexer.fail(str, r3, str2);
        throw null;
    }

    public static boolean isValidValueStart(char c) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (c == '}' || c == ']') {
            z = true;
        } else {
            z = false;
        }
        if (z || c == ':') {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || c == ',') {
            z3 = true;
        }
        return !z3;
    }

    public final int appendHex(int r4, CharSequence charSequence) {
        int r0 = r4 + 4;
        if (r0 >= charSequence.length()) {
            this.currentPosition = r4;
            ensureHaveChars();
            if (this.currentPosition + 4 < charSequence.length()) {
                return appendHex(this.currentPosition, charSequence);
            }
            fail$default(this, "Unexpected EOF during unicode escape", 0, null, 6);
            throw null;
        }
        this.escapedString.append((char) (fromHexChar(r4 + 3, charSequence) + (fromHexChar(r4, charSequence) << 12) + (fromHexChar(r4 + 1, charSequence) << 8) + (fromHexChar(r4 + 2, charSequence) << 4)));
        return r0;
    }

    public void appendRange(int r3, int r4) {
        this.escapedString.append(getSource(), r3, r4);
    }

    public abstract boolean canConsumeValue();

    public final boolean consumeBoolean(int r6) {
        int prefetchOrEof = prefetchOrEof(r6);
        if (prefetchOrEof < getSource().length() && prefetchOrEof != -1) {
            int r4 = prefetchOrEof + 1;
            int charAt = getSource().charAt(prefetchOrEof) | ' ';
            if (charAt != 102) {
                if (charAt == 116) {
                    consumeBooleanLiteral(r4, "rue");
                    return true;
                }
                fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, null, 6);
                throw null;
            }
            consumeBooleanLiteral(r4, "alse");
            return false;
        }
        fail$default(this, "EOF", 0, null, 6);
        throw null;
    }

    public final void consumeBooleanLiteral(int r9, String str) {
        if (getSource().length() - r9 >= str.length()) {
            int length = str.length();
            for (int r1 = 0; r1 < length; r1++) {
                if (str.charAt(r1) != (getSource().charAt(r9 + r1) | ' ')) {
                    fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, null, 6);
                    throw null;
                }
            }
            this.currentPosition = str.length() + r9;
            return;
        }
        fail$default(this, "Unexpected end of boolean literal", 0, null, 6);
        throw null;
    }

    public abstract String consumeKeyString();

    public abstract String consumeLeadingMatchingValue(String str, boolean z);

    public abstract byte consumeNextToken();

    public final byte consumeNextToken(byte b) {
        byte consumeNextToken = consumeNextToken();
        if (consumeNextToken == b) {
            return consumeNextToken;
        }
        fail$kotlinx_serialization_json(b);
        throw null;
    }

    public final long consumeNumericLiteral() {
        boolean z;
        int r16;
        int prefetchOrEof = prefetchOrEof(skipWhitespaces());
        int r4 = 6;
        int r5 = 0;
        if (prefetchOrEof < getSource().length() && prefetchOrEof != -1) {
            if (getSource().charAt(prefetchOrEof) == '\"') {
                prefetchOrEof++;
                if (prefetchOrEof != getSource().length()) {
                    z = true;
                } else {
                    fail$default(this, "EOF", 0, null, 6);
                    throw null;
                }
            } else {
                z = false;
            }
            int r12 = prefetchOrEof;
            boolean z2 = false;
            int r11 = 1;
            long j = 0;
            while (r11 != 0) {
                char charAt = getSource().charAt(r12);
                if (charAt == '-') {
                    if (r12 == prefetchOrEof) {
                        r12++;
                        z2 = true;
                    } else {
                        fail$default(this, "Unexpected symbol '-' in numeric literal", r5, null, r4);
                        throw null;
                    }
                } else {
                    if (BorderStrokeKt.charToTokenClass(charAt) != 0) {
                        break;
                    }
                    r12++;
                    if (r12 != getSource().length()) {
                        r11 = 1;
                    } else {
                        r11 = r5;
                    }
                    int r9 = charAt - '0';
                    if (r9 >= 0 && r9 < 10) {
                        r16 = 1;
                    } else {
                        r16 = r5;
                    }
                    if (r16 != 0) {
                        j = (j * 10) - r9;
                        if (j <= 0) {
                            r4 = 6;
                            r5 = 0;
                        } else {
                            fail$default(this, "Numeric value overflow", 0, null, 6);
                            throw null;
                        }
                    } else {
                        fail$default(this, "Unexpected symbol '" + charAt + "' in numeric literal", r5, null, r4);
                        throw null;
                    }
                }
            }
            if (prefetchOrEof != r12 && (!z2 || prefetchOrEof != r12 - 1)) {
                if (z) {
                    if (r11 != 0) {
                        if (getSource().charAt(r12) == '\"') {
                            r12++;
                        } else {
                            fail$default(this, "Expected closing quotation mark", 0, null, 6);
                            throw null;
                        }
                    } else {
                        fail$default(this, "EOF", 0, null, 6);
                        throw null;
                    }
                }
                this.currentPosition = r12;
                if (!z2) {
                    if (j != Long.MIN_VALUE) {
                        return -j;
                    }
                    fail$default(this, "Numeric value overflow", 0, null, 6);
                    throw null;
                }
                return j;
            }
            fail$default(this, "Expected numeric literal", 0, null, 6);
            throw null;
        }
        fail$default(this, "EOF", 0, null, 6);
        throw null;
    }

    public final String consumeString() {
        String str = this.peekedString;
        if (str != null) {
            Intrinsics.checkNotNull(str);
            this.peekedString = null;
            return str;
        }
        return consumeKeyString();
    }

    public final String consumeStringLenient() {
        String decodedString;
        String str = this.peekedString;
        if (str != null) {
            Intrinsics.checkNotNull(str);
            this.peekedString = null;
            return str;
        }
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces < getSource().length() && skipWhitespaces != -1) {
            byte charToTokenClass = BorderStrokeKt.charToTokenClass(getSource().charAt(skipWhitespaces));
            if (charToTokenClass == 1) {
                return consumeString();
            }
            if (charToTokenClass == 0) {
                boolean z = false;
                while (BorderStrokeKt.charToTokenClass(getSource().charAt(skipWhitespaces)) == 0) {
                    skipWhitespaces++;
                    if (skipWhitespaces >= getSource().length()) {
                        appendRange(this.currentPosition, skipWhitespaces);
                        int prefetchOrEof = prefetchOrEof(skipWhitespaces);
                        if (prefetchOrEof == -1) {
                            this.currentPosition = skipWhitespaces;
                            return decodedString(0, 0);
                        }
                        skipWhitespaces = prefetchOrEof;
                        z = true;
                    }
                }
                if (!z) {
                    decodedString = substring(this.currentPosition, skipWhitespaces);
                } else {
                    decodedString = decodedString(this.currentPosition, skipWhitespaces);
                }
                this.currentPosition = skipWhitespaces;
                return decodedString;
            }
            fail$default(this, "Expected beginning of the string, but got " + getSource().charAt(skipWhitespaces), 0, null, 6);
            throw null;
        }
        fail$default(this, "EOF", skipWhitespaces, null, 4);
        throw null;
    }

    public final String consumeStringLenientNotNull() {
        String consumeStringLenient = consumeStringLenient();
        if (Intrinsics.areEqual(consumeStringLenient, Constants.NULL_VERSION_ID)) {
            boolean z = true;
            if (getSource().charAt(this.currentPosition - 1) == '\"') {
                z = false;
            }
            if (z) {
                fail$default(this, "Unexpected 'null' value instead of string literal", 0, null, 6);
                throw null;
            }
        }
        return consumeStringLenient;
    }

    public final String decodedString(int r2, int r3) {
        appendRange(r2, r3);
        StringBuilder sb = this.escapedString;
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "escapedString.toString()");
        sb.setLength(0);
        return sb2;
    }

    public final void expectEof() {
        if (consumeNextToken() == 10) {
            return;
        }
        fail$default(this, "Expected EOF after parsing, but had " + getSource().charAt(this.currentPosition - 1) + " instead", 0, null, 6);
        throw null;
    }

    public final void fail(String message, int r3, String hint) {
        boolean z;
        String concat;
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(hint, "hint");
        if (hint.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            concat = "";
        } else {
            concat = "\n".concat(hint);
        }
        StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(message, " at path: ");
        m.append(this.path.getPath());
        m.append(concat);
        throw ContentTypesKt.JsonDecodingException(r3, m.toString(), getSource());
    }

    public final void fail$kotlinx_serialization_json(byte b) {
        String str;
        String str2;
        if (b == 1) {
            str = "quotation mark '\"'";
        } else if (b == 4) {
            str = "comma ','";
        } else if (b == 5) {
            str = "colon ':'";
        } else if (b == 6) {
            str = "start of the object '{'";
        } else if (b == 7) {
            str = "end of the object '}'";
        } else if (b == 8) {
            str = "start of the array '['";
        } else if (b == 9) {
            str = "end of the array ']'";
        } else {
            str = "valid token";
        }
        if (this.currentPosition != getSource().length() && this.currentPosition > 0) {
            str2 = String.valueOf(getSource().charAt(this.currentPosition - 1));
        } else {
            str2 = "EOF";
        }
        fail$default(this, "Expected " + str + ", but had '" + str2 + "' instead", this.currentPosition - 1, null, 4);
        throw null;
    }

    public final int fromHexChar(int r4, CharSequence charSequence) {
        boolean z;
        boolean z2;
        char charAt = charSequence.charAt(r4);
        boolean z3 = true;
        if ('0' <= charAt && charAt < ':') {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return charAt - '0';
        }
        char c = 'a';
        if ('a' <= charAt && charAt < 'g') {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            c = 'A';
            if ('A' > charAt || charAt >= 'G') {
                z3 = false;
            }
            if (!z3) {
                fail$default(this, "Invalid toHexChar char '" + charAt + "' in unicode escape", 0, null, 6);
                throw null;
            }
        }
        return (charAt - c) + 10;
    }

    public abstract CharSequence getSource();

    public final byte peekNextToken() {
        CharSequence source = getSource();
        int r1 = this.currentPosition;
        while (true) {
            int prefetchOrEof = prefetchOrEof(r1);
            if (prefetchOrEof != -1) {
                char charAt = source.charAt(prefetchOrEof);
                if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                    this.currentPosition = prefetchOrEof;
                    return BorderStrokeKt.charToTokenClass(charAt);
                }
                r1 = prefetchOrEof + 1;
            } else {
                this.currentPosition = prefetchOrEof;
                return (byte) 10;
            }
        }
    }

    public abstract int prefetchOrEof(int r1);

    public int skipWhitespaces() {
        int prefetchOrEof;
        char charAt;
        int r0 = this.currentPosition;
        while (true) {
            prefetchOrEof = prefetchOrEof(r0);
            if (prefetchOrEof == -1 || !((charAt = getSource().charAt(prefetchOrEof)) == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t')) {
                break;
            }
            r0 = prefetchOrEof + 1;
        }
        this.currentPosition = prefetchOrEof;
        return prefetchOrEof;
    }

    public String substring(int r2, int r3) {
        return getSource().subSequence(r2, r3).toString();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("JsonReader(source='");
        sb.append((Object) getSource());
        sb.append("', currentPosition=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.currentPosition, ')');
    }

    public abstract boolean tryConsumeComma();

    public final boolean tryConsumeNull(boolean z) {
        int prefetchOrEof = prefetchOrEof(skipWhitespaces());
        int length = getSource().length() - prefetchOrEof;
        if (length < 4 || prefetchOrEof == -1) {
            return false;
        }
        for (int r4 = 0; r4 < 4; r4++) {
            if (Constants.NULL_VERSION_ID.charAt(r4) != getSource().charAt(prefetchOrEof + r4)) {
                return false;
            }
        }
        if (length > 4 && BorderStrokeKt.charToTokenClass(getSource().charAt(prefetchOrEof + 4)) == 0) {
            return false;
        }
        if (z) {
            this.currentPosition = prefetchOrEof + 4;
            return true;
        }
        return true;
    }

    public final void unexpectedToken(char c) {
        int r0 = this.currentPosition - 1;
        this.currentPosition = r0;
        if (r0 >= 0 && c == '\"' && Intrinsics.areEqual(consumeStringLenient(), Constants.NULL_VERSION_ID)) {
            fail("Expected string literal but 'null' literal was found", this.currentPosition - 4, "Use 'coerceInputValues = true' in 'Json {}` builder to coerce nulls to default values.");
            throw null;
        }
        fail$kotlinx_serialization_json(BorderStrokeKt.charToTokenClass(c));
        throw null;
    }

    public void consumeNextToken(char c) {
        ensureHaveChars();
        CharSequence source = getSource();
        int r1 = this.currentPosition;
        while (true) {
            int prefetchOrEof = prefetchOrEof(r1);
            if (prefetchOrEof != -1) {
                int r2 = prefetchOrEof + 1;
                char charAt = source.charAt(prefetchOrEof);
                if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                    this.currentPosition = r2;
                    if (charAt == c) {
                        return;
                    }
                    unexpectedToken(c);
                    throw null;
                }
                r1 = r2;
            } else {
                this.currentPosition = prefetchOrEof;
                unexpectedToken(c);
                throw null;
            }
        }
    }

    public final String consumeString(int r10, int r11, CharSequence source) {
        String decodedString;
        Intrinsics.checkNotNullParameter(source, "source");
        char charAt = source.charAt(r11);
        boolean z = false;
        while (charAt != '\"') {
            if (charAt == '\\') {
                appendRange(r10, r11);
                int prefetchOrEof = prefetchOrEof(r11 + 1);
                if (prefetchOrEof != -1) {
                    int r2 = prefetchOrEof + 1;
                    char charAt2 = getSource().charAt(prefetchOrEof);
                    if (charAt2 == 'u') {
                        r2 = appendHex(r2, getSource());
                    } else {
                        char c = charAt2 < 'u' ? CharMappings.ESCAPE_2_CHAR[charAt2] : (char) 0;
                        if (c != 0) {
                            this.escapedString.append(c);
                        } else {
                            fail$default(this, "Invalid escaped char '" + charAt2 + '\'', 0, null, 6);
                            throw null;
                        }
                    }
                    r10 = prefetchOrEof(r2);
                    if (r10 == -1) {
                        fail$default(this, "EOF", r10, null, 4);
                        throw null;
                    }
                } else {
                    fail$default(this, "Expected escape sequence to continue, got EOF", 0, null, 6);
                    throw null;
                }
            } else {
                r11++;
                if (r11 >= source.length()) {
                    appendRange(r10, r11);
                    r10 = prefetchOrEof(r11);
                    if (r10 == -1) {
                        fail$default(this, "EOF", r10, null, 4);
                        throw null;
                    }
                } else {
                    continue;
                    charAt = source.charAt(r11);
                }
            }
            r11 = r10;
            z = true;
            charAt = source.charAt(r11);
        }
        if (!z) {
            decodedString = substring(r10, r11);
        } else {
            decodedString = decodedString(r10, r11);
        }
        this.currentPosition = r11 + 1;
        return decodedString;
    }

    public void ensureHaveChars() {
    }
}
