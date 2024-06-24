package okhttp3.internal;

import aws.sdk.kotlin.runtime.config.imds.EndpointMode$Companion$$ExternalSyntheticOutline0;
import j$.util.DesugarTimeZone;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.Source;

/* compiled from: -UtilJvm.kt */
/* loaded from: classes4.dex */
public final class _UtilJvmKt {
    public static final Headers EMPTY_HEADERS = _UtilCommonKt.commonEmptyHeaders;
    public static final TimeZone UTC;
    public static final String okHttpName;

    static {
        TimeZone timeZone = DesugarTimeZone.getTimeZone("GMT");
        Intrinsics.checkNotNull(timeZone);
        UTC = timeZone;
        okHttpName = StringsKt__StringsKt.removeSuffix("Client", StringsKt__StringsKt.removePrefix("okhttp3.", OkHttpClient.class.getName()));
    }

    public static final boolean canReuseConnectionFor(HttpUrl httpUrl, HttpUrl other) {
        Intrinsics.checkNotNullParameter(httpUrl, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual(httpUrl.host, other.host) && httpUrl.port == other.port && Intrinsics.areEqual(httpUrl.scheme, other.scheme)) {
            return true;
        }
        return false;
    }

    public static final int checkDuration(long j, TimeUnit timeUnit) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            long millis = timeUnit.toMillis(j);
            if (millis <= 2147483647L) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (millis == 0 && j > 0) {
                    z3 = false;
                }
                if (z3) {
                    return (int) millis;
                }
                throw new IllegalArgumentException("timeout".concat(" too small.").toString());
            }
            throw new IllegalArgumentException("timeout".concat(" too large.").toString());
        }
        throw new IllegalStateException("timeout".concat(" < 0").toString());
    }

    public static final void closeQuietly(Socket socket) {
        try {
            socket.close();
        } catch (AssertionError e) {
            throw e;
        } catch (RuntimeException e2) {
            if (Intrinsics.areEqual(e2.getMessage(), "bio == null")) {
            } else {
                throw e2;
            }
        } catch (Exception unused) {
        }
    }

    public static final boolean discard(Source source, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        try {
            return skipAll(source, 100, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String format(String format, Object... objArr) {
        Intrinsics.checkNotNullParameter(format, "format");
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        String format2 = String.format(locale, format, Arrays.copyOf(copyOf, copyOf.length));
        Intrinsics.checkNotNullExpressionValue(format2, "format(locale, format, *args)");
        return format2;
    }

    public static final long headersContentLength(Response response) {
        String str = response.headers.get("Content-Length");
        if (str != null) {
            byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException unused) {
            }
        }
        return -1L;
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List<T> unmodifiableList = Collections.unmodifiableList(CollectionsKt__CollectionsKt.listOf(Arrays.copyOf(objArr, objArr.length)));
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return unmodifiableList;
    }

    public static final boolean skipAll(Source source, int r12, TimeUnit timeUnit) throws IOException {
        long j;
        Intrinsics.checkNotNullParameter(source, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        long nanoTime = System.nanoTime();
        if (source.timeout().hasDeadline()) {
            j = source.timeout().deadlineNanoTime() - nanoTime;
        } else {
            j = Long.MAX_VALUE;
        }
        source.timeout().deadlineNanoTime(Math.min(j, timeUnit.toNanos(r12)) + nanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.read(buffer, 8192L) != -1) {
                buffer.clear();
            }
            if (j == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + j);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (j == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + j);
            }
            return false;
        } catch (Throwable th) {
            if (j == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + j);
            }
            throw th;
        }
    }

    public static final Headers toHeaders(List<Header> list) {
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            _HeadersCommonKt.commonAddLenient(builder, header.name.utf8(), header.value.utf8());
        }
        return builder.build();
    }

    public static final String toHostHeader(HttpUrl httpUrl, boolean z) {
        int r3;
        Intrinsics.checkNotNullParameter(httpUrl, "<this>");
        String str = httpUrl.host;
        if (StringsKt__StringsKt.contains(str, ":", false)) {
            str = EndpointMode$Companion$$ExternalSyntheticOutline0.m("[", str, ']');
        }
        int r0 = httpUrl.port;
        if (!z) {
            String scheme = httpUrl.scheme;
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            if (Intrinsics.areEqual(scheme, "http")) {
                r3 = 80;
            } else if (Intrinsics.areEqual(scheme, "https")) {
                r3 = 443;
            } else {
                r3 = -1;
            }
            if (r0 == r3) {
                return str;
            }
        }
        return str + ':' + r0;
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<T> unmodifiableList = Collections.unmodifiableList(CollectionsKt___CollectionsKt.toMutableList((Collection) list));
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(toMutableList())");
        return unmodifiableList;
    }
}
