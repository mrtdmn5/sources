package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Regex.kt */
/* loaded from: classes.dex */
public final class Regex implements Serializable {
    public final Pattern nativePattern;

    public Regex(Pattern pattern) {
        this.nativePattern = pattern;
    }

    public final boolean matches(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final List split(int r5, CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        StringsKt__StringsKt.requireNonNegativeLimit(r5);
        Matcher matcher = this.nativePattern.matcher(input);
        if (r5 != 1 && matcher.find()) {
            int r3 = 10;
            if (r5 > 0 && r5 <= 10) {
                r3 = r5;
            }
            ArrayList arrayList = new ArrayList(r3);
            int r52 = r5 - 1;
            int r1 = 0;
            do {
                arrayList.add(input.subSequence(r1, matcher.start()).toString());
                r1 = matcher.end();
                if (r52 >= 0 && arrayList.size() == r52) {
                    break;
                }
            } while (matcher.find());
            arrayList.add(input.subSequence(r1, input.length()).toString());
            return arrayList;
        }
        return CollectionsKt__CollectionsKt.listOf(input.toString());
    }

    public final String toString() {
        String pattern = this.nativePattern.toString();
        Intrinsics.checkNotNullExpressionValue(pattern, "toString(...)");
        return pattern;
    }

    public Regex(String str) {
        Pattern compile = Pattern.compile(str);
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        this.nativePattern = compile;
    }
}
