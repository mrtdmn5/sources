package kotlinx.serialization.json.internal;

import androidx.compose.foundation.BorderStrokeKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: StringJsonLexer.kt */
/* loaded from: classes4.dex */
public final class StringJsonLexer extends AbstractJsonLexer {
    public final String source;

    public StringJsonLexer(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final boolean canConsumeValue() {
        int r0 = this.currentPosition;
        if (r0 == -1) {
            return false;
        }
        while (true) {
            String str = this.source;
            if (r0 < str.length()) {
                char charAt = str.charAt(r0);
                if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                    this.currentPosition = r0;
                    return AbstractJsonLexer.isValidValueStart(charAt);
                }
                r0++;
            } else {
                this.currentPosition = r0;
                return false;
            }
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final String consumeKeyString() {
        consumeNextToken('\"');
        int r1 = this.currentPosition;
        String str = this.source;
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '\"', r1, false, 4);
        if (indexOf$default != -1) {
            for (int r2 = r1; r2 < indexOf$default; r2++) {
                if (str.charAt(r2) == '\\') {
                    return consumeString(this.currentPosition, r2, str);
                }
            }
            this.currentPosition = indexOf$default + 1;
            String substring = str.substring(r1, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        fail$kotlinx_serialization_json((byte) 1);
        throw null;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final String consumeLeadingMatchingValue(String keyToMatch, boolean z) {
        String consumeStringLenientNotNull;
        String consumeStringLenientNotNull2;
        Intrinsics.checkNotNullParameter(keyToMatch, "keyToMatch");
        int r0 = this.currentPosition;
        try {
            if (consumeNextToken() != 6) {
                return null;
            }
            if (z) {
                consumeStringLenientNotNull = consumeKeyString();
            } else {
                consumeStringLenientNotNull = consumeStringLenientNotNull();
            }
            if (!Intrinsics.areEqual(consumeStringLenientNotNull, keyToMatch)) {
                return null;
            }
            if (consumeNextToken() != 5) {
                return null;
            }
            if (z) {
                consumeStringLenientNotNull2 = consumeString();
            } else {
                consumeStringLenientNotNull2 = consumeStringLenientNotNull();
            }
            return consumeStringLenientNotNull2;
        } finally {
            this.currentPosition = r0;
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final byte consumeNextToken() {
        byte charToTokenClass;
        do {
            int r0 = this.currentPosition;
            if (r0 == -1) {
                return (byte) 10;
            }
            String str = this.source;
            if (r0 >= str.length()) {
                return (byte) 10;
            }
            int r02 = this.currentPosition;
            this.currentPosition = r02 + 1;
            charToTokenClass = BorderStrokeKt.charToTokenClass(str.charAt(r02));
        } while (charToTokenClass == 3);
        return charToTokenClass;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final CharSequence getSource() {
        return this.source;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final int prefetchOrEof(int r2) {
        if (r2 >= this.source.length()) {
            return -1;
        }
        return r2;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final int skipWhitespaces() {
        char charAt;
        int r0 = this.currentPosition;
        if (r0 == -1) {
            return r0;
        }
        while (true) {
            String str = this.source;
            if (r0 >= str.length() || !((charAt = str.charAt(r0)) == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t')) {
                break;
            }
            r0++;
        }
        this.currentPosition = r0;
        return r0;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final boolean tryConsumeComma() {
        int skipWhitespaces = skipWhitespaces();
        String str = this.source;
        if (skipWhitespaces == str.length() || skipWhitespaces == -1 || str.charAt(skipWhitespaces) != ',') {
            return false;
        }
        this.currentPosition++;
        return true;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final void consumeNextToken(char c) {
        if (this.currentPosition == -1) {
            unexpectedToken(c);
            throw null;
        }
        while (true) {
            int r0 = this.currentPosition;
            String str = this.source;
            if (r0 < str.length()) {
                int r02 = this.currentPosition;
                this.currentPosition = r02 + 1;
                char charAt = str.charAt(r02);
                if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                    if (charAt == c) {
                        return;
                    }
                    unexpectedToken(c);
                    throw null;
                }
            } else {
                unexpectedToken(c);
                throw null;
            }
        }
    }
}
