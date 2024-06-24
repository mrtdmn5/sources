package okhttp3;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.Headers;

/* compiled from: Response.kt */
/* loaded from: classes4.dex */
public final class Response$Builder$trailersFn$1 extends Lambda implements Function0<Headers> {
    public static final Response$Builder$trailersFn$1 INSTANCE = new Response$Builder$trailersFn$1();

    public Response$Builder$trailersFn$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Headers invoke() {
        return Headers.Companion.of(new String[0]);
    }
}
