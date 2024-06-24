package aws.smithy.kotlin.runtime.time;

import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

/* compiled from: Parsers.kt */
/* loaded from: classes.dex */
public final class ParsersKt {
    public static final Regex exponentialNotationNumber;

    static {
        RegexOption option = RegexOption.IGNORE_CASE;
        Intrinsics.checkNotNullParameter(option, "option");
        int value = option.getValue();
        if ((value & 2) != 0) {
            value |= 64;
        }
        Pattern compile = Pattern.compile("(-)?(\\d+(.(\\d+))?)E(-?\\d+)", value);
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        exponentialNotationNumber = new Regex(compile);
    }
}
