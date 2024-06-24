package kotlin.text;

import com.amazonaws.services.s3.internal.Constants;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Charsets.kt */
/* loaded from: classes.dex */
public final class Charsets {
    public static final Charset ISO_8859_1;
    public static final Charset UTF_8;

    static {
        Charset forName = Charset.forName(Constants.DEFAULT_ENCODING);
        Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
        UTF_8 = forName;
        Intrinsics.checkNotNullExpressionValue(Charset.forName("UTF-16"), "forName(...)");
        Intrinsics.checkNotNullExpressionValue(Charset.forName("UTF-16BE"), "forName(...)");
        Intrinsics.checkNotNullExpressionValue(Charset.forName("UTF-16LE"), "forName(...)");
        Intrinsics.checkNotNullExpressionValue(Charset.forName("US-ASCII"), "forName(...)");
        Charset forName2 = Charset.forName("ISO-8859-1");
        Intrinsics.checkNotNullExpressionValue(forName2, "forName(...)");
        ISO_8859_1 = forName2;
    }
}
