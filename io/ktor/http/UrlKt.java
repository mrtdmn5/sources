package io.ktor.http;

import android.util.Log;
import app.cash.sqldelight.SimpleQuery;
import app.cash.sqldelight.db.SqlDriver;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.Segment;

/* compiled from: Url.kt */
/* loaded from: classes3.dex */
public final class UrlKt {
    public static final UrlKt DEFAULT_LOGGER = new UrlKt();

    public static final SimpleQuery Query(int r9, String[] strArr, SqlDriver driver, String str, String str2, String str3, Function1 mapper) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new SimpleQuery(r9, strArr, driver, str, str2, str3, mapper);
    }

    /* renamed from: getSegment-impl, reason: not valid java name */
    public static final Segment m1649getSegmentimpl(Object obj) {
        if (obj != ConcurrentLinkedListKt.CLOSED) {
            return (Segment) obj;
        }
        throw new IllegalStateException("Does not contain segment".toString());
    }

    /* renamed from: isClosed-impl, reason: not valid java name */
    public static final boolean m1650isClosedimpl(Object obj) {
        if (obj == ConcurrentLinkedListKt.CLOSED) {
            return true;
        }
        return false;
    }

    public static byte zza(Boolean bool) {
        if (bool != null) {
            if (!bool.booleanValue()) {
                return (byte) 0;
            }
            return (byte) 1;
        }
        return (byte) -1;
    }

    public static Boolean zzb(byte b) {
        if (b != 0) {
            if (b != 1) {
                return null;
            }
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public boolean canLog(int r2) {
        if (4 > r2 && !Log.isLoggable("FirebaseCrashlytics", r2)) {
            return false;
        }
        return true;
    }

    public void d(String str) {
        if (canLog(3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
    }

    public void v(String str) {
        if (canLog(2)) {
            Log.v("FirebaseCrashlytics", str, null);
        }
    }

    public void w(String str, Exception exc) {
        if (canLog(5)) {
            Log.w("FirebaseCrashlytics", str, exc);
        }
    }
}
