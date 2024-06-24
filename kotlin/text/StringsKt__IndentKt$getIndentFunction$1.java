package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Indent.kt */
/* loaded from: classes.dex */
public final class StringsKt__IndentKt$getIndentFunction$1 extends Lambda implements Function1<String, String> {
    public static final StringsKt__IndentKt$getIndentFunction$1 INSTANCE = new StringsKt__IndentKt$getIndentFunction$1();

    public StringsKt__IndentKt$getIndentFunction$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(String str) {
        String line = str;
        Intrinsics.checkNotNullParameter(line, "line");
        return line;
    }
}
