package aws.smithy.kotlin.runtime.time;

import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.time.Needed;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

/* compiled from: ParserCombinators.kt */
/* loaded from: classes.dex */
public final class ParserCombinatorsKt$takeWhileMN$1 extends Lambda implements Function2<String, Integer, ParseResult<? extends IntRange>> {
    public final /* synthetic */ int $m;
    public final /* synthetic */ int $n;
    public final /* synthetic */ Function1<Character, Boolean> $predicate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ParserCombinatorsKt$takeWhileMN$1(int r1, int r2, Function1<? super Character, Boolean> function1) {
        super(2);
        this.$n = r1;
        this.$m = r2;
        this.$predicate = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final ParseResult<? extends IntRange> invoke(String str, Integer num) {
        boolean z;
        String str2 = str;
        int intValue = num.intValue();
        Intrinsics.checkNotNullParameter(str2, "str");
        int r1 = this.$n;
        int r2 = this.$m;
        if (r1 >= r2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ParserCombinatorsKt.precond(intValue, 0, str2);
            int r0 = intValue;
            while (r0 < str2.length() && r0 - intValue < r1) {
                if (!this.$predicate.invoke(Character.valueOf(str2.charAt(r0))).booleanValue()) {
                    break;
                }
                r0++;
            }
            int r12 = r0 - intValue;
            if (r12 < r2) {
                if (r0 >= str2.length()) {
                    throw new IncompleteException(str2, new Needed.Size(r2 - r12));
                }
                throw new TakeWhileMNException(str2, r0, r2, r12);
            }
            return new ParseResult<>(r0, new IntRange(intValue, r0 - 1));
        }
        throw new IllegalArgumentException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("min m=", r2, " cannot be greater than max=", r1).toString());
    }
}
