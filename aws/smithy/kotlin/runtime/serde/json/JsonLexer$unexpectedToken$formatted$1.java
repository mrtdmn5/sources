package aws.smithy.kotlin.runtime.serde.json;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: JsonLexer.kt */
/* loaded from: classes.dex */
public final class JsonLexer$unexpectedToken$formatted$1 extends Lambda implements Function1<String, CharSequence> {
    public static final JsonLexer$unexpectedToken$formatted$1 INSTANCE = new JsonLexer$unexpectedToken$formatted$1();

    public JsonLexer$unexpectedToken$formatted$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(String str) {
        String it = str;
        Intrinsics.checkNotNullParameter(it, "it");
        return "`" + it + '`';
    }
}
