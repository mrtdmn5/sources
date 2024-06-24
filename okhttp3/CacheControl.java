package okhttp3;

import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: CacheControl.kt */
/* loaded from: classes4.dex */
public final class CacheControl {
    public static final /* synthetic */ int $r8$clinit = 0;
    public String headerValue;
    public final boolean immutable;
    public final boolean isPrivate;
    public final boolean isPublic;
    public final int maxAgeSeconds;
    public final int maxStaleSeconds;
    public final int minFreshSeconds;
    public final boolean mustRevalidate;
    public final boolean noCache;
    public final boolean noStore;
    public final boolean noTransform;
    public final boolean onlyIfCached;
    public final int sMaxAgeSeconds;

    /* compiled from: CacheControl.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static okhttp3.CacheControl parse(okhttp3.Headers r25) {
            /*
                Method dump skipped, instructions count: 442
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.CacheControl.Companion.parse(okhttp3.Headers):okhttp3.CacheControl");
        }
    }

    static {
        DurationUnit timeUnit = DurationUnit.SECONDS;
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        Duration.m1679getInWholeSecondsimpl(DurationKt.toDuration(Integer.MAX_VALUE, timeUnit));
    }

    public CacheControl(boolean z, boolean z2, int r3, int r4, boolean z3, boolean z4, boolean z5, int r8, int r9, boolean z6, boolean z7, boolean z8, String str) {
        this.noCache = z;
        this.noStore = z2;
        this.maxAgeSeconds = r3;
        this.sMaxAgeSeconds = r4;
        this.isPrivate = z3;
        this.isPublic = z4;
        this.mustRevalidate = z5;
        this.maxStaleSeconds = r8;
        this.minFreshSeconds = r9;
        this.onlyIfCached = z6;
        this.noTransform = z7;
        this.immutable = z8;
        this.headerValue = str;
    }

    public final String toString() {
        boolean z;
        String str = this.headerValue;
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            if (this.noCache) {
                sb.append("no-cache, ");
            }
            if (this.noStore) {
                sb.append("no-store, ");
            }
            int r3 = this.maxAgeSeconds;
            if (r3 != -1) {
                sb.append("max-age=");
                sb.append(r3);
                sb.append(", ");
            }
            int r32 = this.sMaxAgeSeconds;
            if (r32 != -1) {
                sb.append("s-maxage=");
                sb.append(r32);
                sb.append(", ");
            }
            if (this.isPrivate) {
                sb.append("private, ");
            }
            if (this.isPublic) {
                sb.append("public, ");
            }
            if (this.mustRevalidate) {
                sb.append("must-revalidate, ");
            }
            int r33 = this.maxStaleSeconds;
            if (r33 != -1) {
                sb.append("max-stale=");
                sb.append(r33);
                sb.append(", ");
            }
            int r34 = this.minFreshSeconds;
            if (r34 != -1) {
                sb.append("min-fresh=");
                sb.append(r34);
                sb.append(", ");
            }
            if (this.onlyIfCached) {
                sb.append("only-if-cached, ");
            }
            if (this.noTransform) {
                sb.append("no-transform, ");
            }
            if (this.immutable) {
                sb.append("immutable, ");
            }
            if (sb.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return "";
            }
            Intrinsics.checkNotNullExpressionValue(sb.delete(sb.length() - 2, sb.length()), "this.delete(startIndex, endIndex)");
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            this.headerValue = sb2;
            return sb2;
        }
        return str;
    }
}
