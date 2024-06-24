package aws.smithy.kotlin.runtime.net;

import com.animaconnected.secondo.notification.model.Contact;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QueryParameters.kt */
/* loaded from: classes.dex */
public final class QueryParametersKt {
    public static final void urlEncodeQueryParametersTo(Set entries, StringBuilder sb, Function1 encodeFn) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(encodeFn, "encodeFn");
        int r1 = 0;
        for (Object obj : CollectionsKt___CollectionsKt.sortedWith(entries, new QueryParametersKt$urlEncodeQueryParametersTo$$inlined$sortedBy$1())) {
            int r3 = r1 + 1;
            if (r1 >= 0) {
                Map.Entry entry = (Map.Entry) obj;
                int r6 = 0;
                for (Object obj2 : (Iterable) entry.getValue()) {
                    int r8 = r6 + 1;
                    if (r6 >= 0) {
                        String str = (String) obj2;
                        if (r1 > 0 || r6 > 0) {
                            sb.append(Contact.PHONE_NUMBERS_DELIMITER);
                        }
                        sb.append((CharSequence) entry.getKey());
                        sb.append("=");
                        sb.append((CharSequence) encodeFn.invoke(str));
                        r6 = r8;
                    } else {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                        throw null;
                    }
                }
                r1 = r3;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
    }
}
