package kotlinx.serialization.json.internal;

import androidx.compose.foundation.BorderStrokeKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: JsonLexer.kt */
/* loaded from: classes4.dex */
public final class ReaderJsonLexer extends AbstractJsonLexer {
    public final SerialReader reader;
    public final ArrayAsSequence source;
    public int threshold = 128;

    public ReaderJsonLexer(JavaStreamSerialReader javaStreamSerialReader, char[] cArr) {
        this.reader = javaStreamSerialReader;
        this.source = new ArrayAsSequence(cArr);
        preload(0);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final void appendRange(int r3, int r4) {
        this.escapedString.append(this.source.buffer, r3, r4 - r3);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final boolean canConsumeValue() {
        ensureHaveChars();
        int r0 = this.currentPosition;
        while (true) {
            int prefetchOrEof = prefetchOrEof(r0);
            if (prefetchOrEof != -1) {
                char c = this.source.buffer[prefetchOrEof];
                if (c != ' ' && c != '\n' && c != '\r' && c != '\t') {
                    this.currentPosition = prefetchOrEof;
                    return AbstractJsonLexer.isValidValueStart(c);
                }
                r0 = prefetchOrEof + 1;
            } else {
                this.currentPosition = prefetchOrEof;
                return false;
            }
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final String consumeKeyString() {
        char[] cArr;
        consumeNextToken('\"');
        int r1 = this.currentPosition;
        ArrayAsSequence arrayAsSequence = this.source;
        int r3 = arrayAsSequence.length;
        int r4 = r1;
        while (true) {
            cArr = arrayAsSequence.buffer;
            if (r4 < r3) {
                if (cArr[r4] == '\"') {
                    break;
                }
                r4++;
            } else {
                r4 = -1;
                break;
            }
        }
        if (r4 == -1) {
            int prefetchOrEof = prefetchOrEof(r1);
            if (prefetchOrEof != -1) {
                return consumeString(this.currentPosition, prefetchOrEof, arrayAsSequence);
            }
            fail$kotlinx_serialization_json((byte) 1);
            throw null;
        }
        for (int r0 = r1; r0 < r4; r0++) {
            if (cArr[r0] == '\\') {
                return consumeString(this.currentPosition, r0, arrayAsSequence);
            }
        }
        this.currentPosition = r4 + 1;
        return substring(r1, r4);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final String consumeLeadingMatchingValue(String keyToMatch, boolean z) {
        Intrinsics.checkNotNullParameter(keyToMatch, "keyToMatch");
        return null;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final byte consumeNextToken() {
        ensureHaveChars();
        int r0 = this.currentPosition;
        while (true) {
            int prefetchOrEof = prefetchOrEof(r0);
            if (prefetchOrEof != -1) {
                int r1 = prefetchOrEof + 1;
                byte charToTokenClass = BorderStrokeKt.charToTokenClass(this.source.buffer[prefetchOrEof]);
                if (charToTokenClass != 3) {
                    this.currentPosition = r1;
                    return charToTokenClass;
                }
                r0 = r1;
            } else {
                this.currentPosition = prefetchOrEof;
                return (byte) 10;
            }
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final void ensureHaveChars() {
        int r1 = this.source.length - this.currentPosition;
        if (r1 > this.threshold) {
            return;
        }
        preload(r1);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final CharSequence getSource() {
        return this.source;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final int prefetchOrEof(int r3) {
        boolean z;
        ArrayAsSequence arrayAsSequence = this.source;
        if (r3 < arrayAsSequence.length) {
            return r3;
        }
        this.currentPosition = r3;
        ensureHaveChars();
        if (this.currentPosition == 0) {
            if (arrayAsSequence.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return 0;
            }
            return -1;
        }
        return -1;
    }

    public final void preload(int r7) {
        ArrayAsSequence arrayAsSequence = this.source;
        char[] cArr = arrayAsSequence.buffer;
        if (r7 != 0) {
            int r3 = this.currentPosition;
            ArraysKt___ArraysJvmKt.copyInto(cArr, cArr, 0, r3, r3 + r7);
        }
        int r32 = arrayAsSequence.length;
        while (true) {
            if (r7 == r32) {
                break;
            }
            int read = this.reader.read(cArr, r7, r32 - r7);
            if (read == -1) {
                arrayAsSequence.length = Math.min(arrayAsSequence.buffer.length, r7);
                this.threshold = -1;
                break;
            }
            r7 += read;
        }
        this.currentPosition = 0;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final String substring(int r3, int r4) {
        ArrayAsSequence arrayAsSequence = this.source;
        return StringsKt__StringsJVMKt.concatToString(arrayAsSequence.buffer, r3, Math.min(r4, arrayAsSequence.length));
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final boolean tryConsumeComma() {
        int skipWhitespaces = skipWhitespaces();
        ArrayAsSequence arrayAsSequence = this.source;
        if (skipWhitespaces >= arrayAsSequence.length || skipWhitespaces == -1 || arrayAsSequence.buffer[skipWhitespaces] != ',') {
            return false;
        }
        this.currentPosition++;
        return true;
    }
}
