package io.ktor.client.engine;

import com.amazonaws.services.s3.Headers;
import io.ktor.http.HttpHeaders;
import java.util.List;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;

/* compiled from: Utils.kt */
/* loaded from: classes3.dex */
public final class UtilsKt {
    public static final Set<String> DATE_HEADERS;

    static {
        List<String> list = HttpHeaders.UnsafeHeadersList;
        DATE_HEADERS = SetsKt__SetsKt.setOf((Object[]) new String[]{"Date", Headers.EXPIRES, Headers.LAST_MODIFIED, Headers.GET_OBJECT_IF_MODIFIED_SINCE, Headers.GET_OBJECT_IF_UNMODIFIED_SINCE});
    }
}
