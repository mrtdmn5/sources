package aws.smithy.kotlin.runtime.serde.json;

import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.json.JsonToken;
import com.amplifyframework.core.model.ModelIdentifier;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.EventLoop_commonKt;

/* compiled from: JsonLexer.kt */
/* loaded from: classes.dex */
public final class JsonLexer implements JsonStreamReader {
    public final byte[] data;
    public int idx;
    public JsonToken peeked;
    public final StateManager state;

    /* compiled from: JsonLexer.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[LexerState.values().length];
            try {
                r0[LexerState.Initial.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[LexerState.ArrayFirstValueOrEnd.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[LexerState.ArrayNextValueOrEnd.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[LexerState.ObjectFirstKeyOrEnd.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[LexerState.ObjectNextKeyOrEnd.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[LexerState.ObjectFieldValue.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public JsonLexer(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.state = new StateManager(null);
    }

    public static void fail$default(JsonLexer jsonLexer, String str, int r3, int r4) {
        if ((r4 & 2) != 0) {
            r3 = jsonLexer.idx;
        }
        jsonLexer.getClass();
        throw new DeserializationException("Unexpected JSON token at offset " + r3 + "; " + str, null);
    }

    public final void consume(char c) {
        boolean z;
        int r0 = this.idx;
        char c2 = (char) this.data[r0];
        if (c2 == c) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.idx = r0 + 1;
            return;
        }
        fail$default(this, ("Unexpected char `" + c2 + "` expected `" + c + '`').toString(), r0, 4);
        throw null;
    }

    public final JsonToken.EndArray endArray() {
        boolean z;
        consume(']');
        StateManager stateManager = this.state;
        LexerState lexerState = (LexerState) EventLoop_commonKt.top(stateManager.state);
        if (lexerState != LexerState.ArrayFirstValueOrEnd && lexerState != LexerState.ArrayNextValueOrEnd) {
            z = false;
        } else {
            z = true;
        }
        int r2 = this.idx - 1;
        if (z) {
            stateManager.mutate(new Function1<List<LexerState>, Unit>() { // from class: aws.smithy.kotlin.runtime.serde.json.JsonLexer$endArray$2
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(List<LexerState> list) {
                    List<LexerState> it = list;
                    Intrinsics.checkNotNullParameter(it, "it");
                    CollectionsKt__ReversedViewsKt.removeLast(it);
                    return Unit.INSTANCE;
                }
            });
            return JsonToken.EndArray.INSTANCE;
        }
        fail$default(this, "Unexpected close `]` encountered".toString(), r2, 4);
        throw null;
    }

    public final JsonToken.EndObject endObject() {
        boolean z;
        consume('}');
        StateManager stateManager = this.state;
        LexerState lexerState = (LexerState) EventLoop_commonKt.top(stateManager.state);
        if (lexerState != LexerState.ObjectFirstKeyOrEnd && lexerState != LexerState.ObjectNextKeyOrEnd) {
            z = false;
        } else {
            z = true;
        }
        int r2 = this.idx - 1;
        if (z) {
            stateManager.mutate(new Function1<List<LexerState>, Unit>() { // from class: aws.smithy.kotlin.runtime.serde.json.JsonLexer$endObject$2
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(List<LexerState> list) {
                    List<LexerState> it = list;
                    Intrinsics.checkNotNullParameter(it, "it");
                    CollectionsKt__ReversedViewsKt.removeLast(it);
                    return Unit.INSTANCE;
                }
            });
            return JsonToken.EndObject.INSTANCE;
        }
        fail$default(this, "Unexpected close `}` encountered".toString(), r2, 4);
        throw null;
    }

    public final Character nextNonWhitespace() {
        boolean z;
        while (true) {
            Character peekChar = peekChar();
            if (peekChar != null && CharsKt__CharKt.isWhitespace(peekChar.charValue())) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.idx++;
            } else {
                return peekChar();
            }
        }
    }

    public final char nextOrThrow() {
        char peekOrThrow = peekOrThrow();
        this.idx++;
        return peekOrThrow;
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamReader
    public final JsonToken nextToken() {
        JsonToken peek = peek();
        this.peeked = null;
        StateManager stateManager = this.state;
        List<Function1<List<LexerState>, Unit>> list = stateManager.pendingMutations;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(stateManager.state);
        }
        list.clear();
        return peek;
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamReader
    public final JsonToken peek() {
        JsonToken jsonToken = this.peeked;
        if (jsonToken == null) {
            StateManager stateManager = this.state;
            try {
                switch (WhenMappings.$EnumSwitchMapping$0[((LexerState) EventLoop_commonKt.top(stateManager.state)).ordinal()]) {
                    case 1:
                        jsonToken = readToken();
                        break;
                    case 2:
                        Character nextNonWhitespace = nextNonWhitespace();
                        if (nextNonWhitespace != null && nextNonWhitespace.charValue() == ']') {
                            jsonToken = endArray();
                            break;
                        }
                        stateManager.mutate(new Function1<List<LexerState>, Unit>() { // from class: aws.smithy.kotlin.runtime.serde.json.JsonLexer$stateArrayFirstValueOrEnd$1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(List<LexerState> list) {
                                List<LexerState> it = list;
                                Intrinsics.checkNotNullParameter(it, "it");
                                EventLoop_commonKt.replaceTop(LexerState.ArrayNextValueOrEnd, it);
                                return Unit.INSTANCE;
                            }
                        });
                        jsonToken = readToken();
                        break;
                    case 3:
                        jsonToken = stateArrayNextValueOrEnd();
                        break;
                    case 4:
                        jsonToken = stateObjectFirstKeyOrEnd();
                        break;
                    case 5:
                        jsonToken = stateObjectNextKeyOrEnd();
                        break;
                    case 6:
                        jsonToken = stateObjectFieldValue();
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                this.peeked = jsonToken;
            } catch (DeserializationException e) {
                throw e;
            } catch (Exception e2) {
                throw new DeserializationException(e2);
            }
        }
        return jsonToken;
    }

    public final Character peekChar() {
        Byte b;
        int r0 = this.idx;
        byte[] bArr = this.data;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (r0 >= 0 && r0 <= bArr.length - 1) {
            b = Byte.valueOf(bArr[r0]);
        } else {
            b = null;
        }
        if (b == null) {
            return null;
        }
        return Character.valueOf((char) b.byteValue());
    }

    public final char peekOrThrow() {
        Character peekChar = peekChar();
        if (peekChar != null) {
            return peekChar.charValue();
        }
        throw new IllegalStateException("Unexpected EOF");
    }

    public final void readDigits(StringBuilder sb) {
        while (CollectionsKt___CollectionsKt.contains(JsonLexerKt.DIGITS, peekChar())) {
            sb.append(nextOrThrow());
        }
    }

    public final void readLiteral(String str, JsonToken jsonToken) {
        for (int r3 = 0; r3 < str.length(); r3++) {
            consume(str.charAt(r3));
        }
    }

    public final JsonToken.Name readName() {
        char peekOrThrow = peekOrThrow();
        if (peekOrThrow == '\"') {
            String readQuoted = readQuoted();
            this.state.mutate(new Function1<List<LexerState>, Unit>() { // from class: aws.smithy.kotlin.runtime.serde.json.JsonLexer$readName$1
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(List<LexerState> list) {
                    List<LexerState> it = list;
                    Intrinsics.checkNotNullParameter(it, "it");
                    EventLoop_commonKt.replaceTop(LexerState.ObjectFieldValue, it);
                    return Unit.INSTANCE;
                }
            });
            return new JsonToken.Name(readQuoted);
        }
        unexpectedToken(Character.valueOf(peekOrThrow), ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR);
        throw null;
    }

    public final String readQuoted() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        consume('\"');
        int r1 = this.idx;
        char peekOrThrow = peekOrThrow();
        boolean z9 = false;
        while (true) {
            byte[] bArr = this.data;
            if (peekOrThrow != '\"') {
                if (peekOrThrow == '\\') {
                    nextOrThrow();
                    char nextOrThrow = nextOrThrow();
                    if (nextOrThrow == 'u') {
                        int r2 = this.idx;
                        int r4 = r2 + 4;
                        if (r4 < bArr.length) {
                            this.idx = r4;
                        } else {
                            fail$default(this, "Unexpected EOF reading escaped unicode string", r2, 4);
                            throw null;
                        }
                    } else {
                        if (nextOrThrow == '\\' || nextOrThrow == '/') {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2 || nextOrThrow == '\"') {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3 || nextOrThrow == 'b') {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4 || nextOrThrow == 'f') {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z5 || nextOrThrow == 'r') {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (z6 || nextOrThrow == 'n') {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (z7 || nextOrThrow == 't') {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (!z8) {
                            fail$default(this, "Invalid escape character: `" + nextOrThrow + '`', this.idx - 1, 4);
                            throw null;
                        }
                    }
                    z9 = true;
                } else {
                    Set<Character> set = JsonLexerKt.DIGITS;
                    if (peekOrThrow >= 0 && peekOrThrow < ' ') {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        this.idx++;
                    } else {
                        fail$default(this, "Unexpected control character: `" + peekOrThrow + '`', 0, 6);
                        throw null;
                    }
                }
                peekOrThrow = peekOrThrow();
            } else {
                String decodeToString$default = StringsKt__StringsJVMKt.decodeToString$default(bArr, r1, this.idx, 4);
                consume('\"');
                if (z9) {
                    try {
                        return JsonLexerKt.access$unescape(decodeToString$default);
                    } catch (Exception e) {
                        String message = e.getMessage();
                        if (message == null) {
                            message = "Invalid escaped string";
                        }
                        fail$default(this, message, r1 - 1, 4);
                        throw null;
                    }
                }
                return decodeToString$default;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0181  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final aws.smithy.kotlin.runtime.serde.json.JsonToken readToken() {
        /*
            Method dump skipped, instructions count: 414
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.serde.json.JsonLexer.readToken():aws.smithy.kotlin.runtime.serde.json.JsonToken");
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamReader
    public final void skipNext() {
        StateManager stateManager = this.state;
        int size = stateManager.state.size();
        nextToken();
        while (stateManager.state.size() > size) {
            nextToken();
        }
    }

    public final JsonToken stateArrayNextValueOrEnd() {
        Character nextNonWhitespace = nextNonWhitespace();
        if (nextNonWhitespace != null && nextNonWhitespace.charValue() == ']') {
            return endArray();
        }
        if (nextNonWhitespace != null && nextNonWhitespace.charValue() == ',') {
            consume(',');
            return readToken();
        }
        unexpectedToken(nextNonWhitespace, ",", "]");
        throw null;
    }

    public final JsonToken stateObjectFieldValue() {
        Character nextNonWhitespace = nextNonWhitespace();
        if (nextNonWhitespace != null && nextNonWhitespace.charValue() == ':') {
            consume(':');
            this.state.mutate(new Function1<List<LexerState>, Unit>() { // from class: aws.smithy.kotlin.runtime.serde.json.JsonLexer$stateObjectFieldValue$1
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(List<LexerState> list) {
                    List<LexerState> it = list;
                    Intrinsics.checkNotNullParameter(it, "it");
                    EventLoop_commonKt.replaceTop(LexerState.ObjectNextKeyOrEnd, it);
                    return Unit.INSTANCE;
                }
            });
            return readToken();
        }
        unexpectedToken(nextNonWhitespace, ":");
        throw null;
    }

    public final JsonToken stateObjectFirstKeyOrEnd() {
        Character nextNonWhitespace = nextNonWhitespace();
        if (nextNonWhitespace != null && nextNonWhitespace.charValue() == '}') {
            return endObject();
        }
        if (nextNonWhitespace != null && nextNonWhitespace.charValue() == '\"') {
            return readName();
        }
        unexpectedToken(nextNonWhitespace, ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR, "}");
        throw null;
    }

    public final JsonToken stateObjectNextKeyOrEnd() {
        Character nextNonWhitespace = nextNonWhitespace();
        if (nextNonWhitespace != null && nextNonWhitespace.charValue() == '}') {
            return endObject();
        }
        if (nextNonWhitespace != null && nextNonWhitespace.charValue() == ',') {
            consume(',');
            nextNonWhitespace();
            return readName();
        }
        unexpectedToken(nextNonWhitespace, ",", "}");
        throw null;
    }

    public final void unexpectedToken(Character ch, String... strArr) {
        String str;
        if (strArr.length > 1) {
            str = " one of";
        } else {
            str = "";
        }
        fail$default(this, "found `" + ch + "`, expected" + str + ' ' + ArraysKt___ArraysKt.joinToString$default(strArr, ", ", JsonLexer$unexpectedToken$formatted$1.INSTANCE, 30), 0, 6);
        throw null;
    }
}
