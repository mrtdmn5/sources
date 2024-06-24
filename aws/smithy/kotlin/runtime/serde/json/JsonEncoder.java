package aws.smithy.kotlin.runtime.serde.json;

import com.amplifyframework.core.model.ModelIdentifier;
import java.util.ArrayList;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.EventLoop_commonKt;

/* compiled from: JsonEncoder.kt */
/* loaded from: classes.dex */
public final class JsonEncoder {
    public int depth;
    public final boolean pretty;
    public final StringBuilder buffer = new StringBuilder();
    public final ArrayList state = CollectionsKt__CollectionsKt.mutableListOf(LexerState.Initial);

    /* compiled from: JsonEncoder.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[LexerState.values().length];
            try {
                r0[LexerState.ArrayFirstValueOrEnd.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[LexerState.ArrayNextValueOrEnd.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[LexerState.ObjectFieldValue.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public JsonEncoder(boolean z) {
        this.pretty = z;
    }

    public final void closeStructure(String str, LexerState... lexerStateArr) {
        boolean z = this.pretty;
        StringBuilder sb = this.buffer;
        if (z) {
            sb.append('\n');
        }
        this.depth--;
        writeIndent();
        sb.append(str);
        ArrayList arrayList = this.state;
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        LexerState lexerState = (LexerState) CollectionsKt__ReversedViewsKt.removeLast(arrayList);
        if (ArraysKt___ArraysKt.contains(lexerStateArr, lexerState)) {
            return;
        }
        throw new IllegalStateException(("Invalid JSON encoder state " + lexerState + "; expected one of " + ArraysKt___ArraysKt.joinToString$default(lexerStateArr, null, null, 63)).toString());
    }

    public final void encodeValue(String str) {
        ArrayList arrayList = this.state;
        int r1 = WhenMappings.$EnumSwitchMapping$0[((LexerState) EventLoop_commonKt.top(arrayList)).ordinal()];
        StringBuilder sb = this.buffer;
        if (r1 != 1) {
            boolean z = this.pretty;
            if (r1 != 2) {
                if (r1 == 3) {
                    sb.append(":");
                    if (z) {
                        sb.append(" ");
                    }
                    EventLoop_commonKt.replaceTop(LexerState.ObjectNextKeyOrEnd, arrayList);
                }
            } else {
                sb.append(",");
                if (z) {
                    sb.append('\n');
                }
                writeIndent();
            }
        } else {
            EventLoop_commonKt.replaceTop(LexerState.ArrayNextValueOrEnd, arrayList);
            writeIndent();
        }
        sb.append(str);
    }

    public final void writeIndent() {
        int r0;
        if (this.pretty && (r0 = this.depth) > 0) {
            this.buffer.append(StringsKt__StringsJVMKt.repeat(r0 * 4, " "));
        }
    }

    public final void writeName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        ArrayList arrayList = this.state;
        Object pVar = EventLoop_commonKt.top(arrayList);
        LexerState lexerState = LexerState.ObjectNextKeyOrEnd;
        StringBuilder sb = this.buffer;
        if (pVar == lexerState) {
            sb.append(",");
            if (this.pretty) {
                sb.append('\n');
            }
        }
        writeIndent();
        String escape = JsonEncoderKt.escape(name);
        sb.append(ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR);
        sb.append(escape);
        sb.append(ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR);
        EventLoop_commonKt.replaceTop(LexerState.ObjectFieldValue, arrayList);
    }
}
