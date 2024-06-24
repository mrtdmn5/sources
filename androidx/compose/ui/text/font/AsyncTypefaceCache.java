package androidx.compose.ui.text.font;

import androidx.compose.ui.text.caches.LruCache;
import androidx.compose.ui.text.caches.SimpleArrayMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExecutorsKt;

/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
/* loaded from: classes.dex */
public final class AsyncTypefaceCache {
    public final LruCache<Key, AsyncTypefaceResult> resultCache = new LruCache<>();
    public final SimpleArrayMap<Key, AsyncTypefaceResult> permanentCache = new SimpleArrayMap<>(0);
    public final ExecutorsKt cacheLock = new ExecutorsKt();

    /* compiled from: FontListFontFamilyTypefaceAdapter.kt */
    /* loaded from: classes.dex */
    public static final class AsyncTypefaceResult {
        public final Object result;

        public /* synthetic */ AsyncTypefaceResult(Object obj) {
            this.result = obj;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof AsyncTypefaceResult)) {
                return false;
            }
            if (!Intrinsics.areEqual(this.result, ((AsyncTypefaceResult) obj).result)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            Object obj = this.result;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public final String toString() {
            return "AsyncTypefaceResult(result=" + this.result + ')';
        }
    }

    /* compiled from: FontListFontFamilyTypefaceAdapter.kt */
    /* loaded from: classes.dex */
    public static final class Key {
        public final Font font;
        public final Object loaderKey;

        public Key(Font font, Object obj) {
            Intrinsics.checkNotNullParameter(font, "font");
            this.font = font;
            this.loaderKey = obj;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (Intrinsics.areEqual(this.font, key.font) && Intrinsics.areEqual(this.loaderKey, key.loaderKey)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int hashCode;
            int hashCode2 = this.font.hashCode() * 31;
            Object obj = this.loaderKey;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            return hashCode2 + hashCode;
        }

        public final String toString() {
            return "Key(font=" + this.font + ", loaderKey=" + this.loaderKey + ')';
        }
    }

    public static void put$default(AsyncTypefaceCache asyncTypefaceCache, Font font, PlatformFontLoader platformFontLoader, Object obj) {
        platformFontLoader.getCacheKey();
        Object obj2 = null;
        Key key = new Key(font, null);
        synchronized (asyncTypefaceCache.cacheLock) {
            try {
                if (obj == null) {
                } else {
                    asyncTypefaceCache.resultCache.put(key, new AsyncTypefaceResult(obj));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object runCached(androidx.compose.ui.text.font.Font r7, androidx.compose.ui.text.font.PlatformFontLoader r8, androidx.compose.ui.text.font.AsyncFontListLoader$load$2$typeface$1 r9, kotlin.coroutines.Continuation r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1 r0 = (androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1 r0 = new androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            boolean r7 = r0.Z$0
            androidx.compose.ui.text.font.AsyncTypefaceCache$Key r8 = r0.L$1
            androidx.compose.ui.text.font.AsyncTypefaceCache r9 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L73
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            kotlin.ResultKt.throwOnFailure(r10)
            androidx.compose.ui.text.font.AsyncTypefaceCache$Key r10 = new androidx.compose.ui.text.font.AsyncTypefaceCache$Key
            r8.getCacheKey()
            r10.<init>(r7, r3)
            kotlinx.coroutines.ExecutorsKt r7 = r6.cacheLock
            monitor-enter(r7)
            androidx.compose.ui.text.caches.LruCache<androidx.compose.ui.text.font.AsyncTypefaceCache$Key, androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult> r8 = r6.resultCache     // Catch: java.lang.Throwable -> La2
            java.lang.Object r8 = r8.get(r10)     // Catch: java.lang.Throwable -> La2
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r8 = (androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult) r8     // Catch: java.lang.Throwable -> La2
            if (r8 != 0) goto L56
            androidx.compose.ui.text.caches.SimpleArrayMap<androidx.compose.ui.text.font.AsyncTypefaceCache$Key, androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult> r8 = r6.permanentCache     // Catch: java.lang.Throwable -> La2
            java.lang.Object r8 = r8.get(r10)     // Catch: java.lang.Throwable -> La2
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r8 = (androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult) r8     // Catch: java.lang.Throwable -> La2
        L56:
            if (r8 == 0) goto L5c
            java.lang.Object r8 = r8.result     // Catch: java.lang.Throwable -> La2
            monitor-exit(r7)
            return r8
        L5c:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> La2
            monitor-exit(r7)
            r0.L$0 = r6
            r0.L$1 = r10
            r7 = 0
            r0.Z$0 = r7
            r0.label = r4
            java.lang.Object r8 = r9.invoke(r0)
            if (r8 != r1) goto L6f
            return r1
        L6f:
            r9 = r6
            r5 = r10
            r10 = r8
            r8 = r5
        L73:
            kotlinx.coroutines.ExecutorsKt r0 = r9.cacheLock
            monitor-enter(r0)
            if (r10 != 0) goto L85
            androidx.compose.ui.text.caches.SimpleArrayMap<androidx.compose.ui.text.font.AsyncTypefaceCache$Key, androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult> r7 = r9.permanentCache     // Catch: java.lang.Throwable -> L83
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r9 = new androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult     // Catch: java.lang.Throwable -> L83
            r9.<init>(r3)     // Catch: java.lang.Throwable -> L83
            r7.put(r8, r9)     // Catch: java.lang.Throwable -> L83
            goto L9c
        L83:
            r7 = move-exception
            goto La0
        L85:
            if (r7 == 0) goto L92
            androidx.compose.ui.text.caches.SimpleArrayMap<androidx.compose.ui.text.font.AsyncTypefaceCache$Key, androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult> r7 = r9.permanentCache     // Catch: java.lang.Throwable -> L83
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r9 = new androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult     // Catch: java.lang.Throwable -> L83
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L83
            r7.put(r8, r9)     // Catch: java.lang.Throwable -> L83
            goto L9c
        L92:
            androidx.compose.ui.text.caches.LruCache<androidx.compose.ui.text.font.AsyncTypefaceCache$Key, androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult> r7 = r9.resultCache     // Catch: java.lang.Throwable -> L83
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r9 = new androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult     // Catch: java.lang.Throwable -> L83
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L83
            r7.put(r8, r9)     // Catch: java.lang.Throwable -> L83
        L9c:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L83
            monitor-exit(r0)
            return r10
        La0:
            monitor-exit(r0)
            throw r7
        La2:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncTypefaceCache.runCached(androidx.compose.ui.text.font.Font, androidx.compose.ui.text.font.PlatformFontLoader, androidx.compose.ui.text.font.AsyncFontListLoader$load$2$typeface$1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
