package androidx.compose.ui.text.font;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.font.TypefaceResult;
import com.google.common.collect.Platform;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
/* loaded from: classes.dex */
public final class AsyncFontListLoader implements State<Object> {
    public final AsyncTypefaceCache asyncTypefaceCache;
    public boolean cacheable;
    public final List<Font> fontList;
    public final Function1<TypefaceResult.Immutable, Unit> onCompletion;
    public final PlatformFontLoader platformFontLoader;
    public final TypefaceRequest typefaceRequest;
    public final ParcelableSnapshotMutableState value$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public AsyncFontListLoader(List<? extends Font> list, Object initialType, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, Function1<? super TypefaceResult.Immutable, Unit> onCompletion, PlatformFontLoader platformFontLoader) {
        Intrinsics.checkNotNullParameter(initialType, "initialType");
        Intrinsics.checkNotNullParameter(asyncTypefaceCache, "asyncTypefaceCache");
        Intrinsics.checkNotNullParameter(onCompletion, "onCompletion");
        this.fontList = list;
        this.typefaceRequest = typefaceRequest;
        this.asyncTypefaceCache = asyncTypefaceCache;
        this.onCompletion = onCompletion;
        this.platformFontLoader = platformFontLoader;
        this.value$delegate = Platform.mutableStateOf$default(initialType);
        this.cacheable = true;
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        return this.value$delegate.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ea, code lost:            if (0 != 0) goto L32;     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a3 A[Catch: all -> 0x00cf, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x00cf, blocks: (B:29:0x00a3, B:37:0x00d1, B:52:0x0052), top: B:51:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d1 A[Catch: all -> 0x00cf, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x00cf, blocks: (B:29:0x00a3, B:37:0x00d1, B:52:0x0052), top: B:51:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00e7 -> B:13:0x00e8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object load(kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncFontListLoader.load(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadWithTimeoutOrNull$ui_text_release(androidx.compose.ui.text.font.Font r7, kotlin.coroutines.Continuation<java.lang.Object> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1 r0 = (androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1 r0 = new androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            androidx.compose.ui.text.font.Font r7 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L49 java.util.concurrent.CancellationException -> L73
            goto L47
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L32:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$2 r8 = new androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$2     // Catch: java.lang.Exception -> L49 java.util.concurrent.CancellationException -> L73
            r8.<init>(r6, r7, r4)     // Catch: java.lang.Exception -> L49 java.util.concurrent.CancellationException -> L73
            r0.L$0 = r7     // Catch: java.lang.Exception -> L49 java.util.concurrent.CancellationException -> L73
            r0.label = r3     // Catch: java.lang.Exception -> L49 java.util.concurrent.CancellationException -> L73
            r2 = 15000(0x3a98, double:7.411E-320)
            java.lang.Object r8 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r2, r8, r0)     // Catch: java.lang.Exception -> L49 java.util.concurrent.CancellationException -> L73
            if (r8 != r1) goto L47
            return r1
        L47:
            r4 = r8
            goto L7e
        L49:
            r8 = move-exception
            kotlin.coroutines.CoroutineContext r1 = r0.getContext()
            kotlinx.coroutines.CoroutineExceptionHandler$Key r2 = kotlinx.coroutines.CoroutineExceptionHandler.Key.$$INSTANCE
            kotlin.coroutines.CoroutineContext$Element r1 = r1.get(r2)
            kotlinx.coroutines.CoroutineExceptionHandler r1 = (kotlinx.coroutines.CoroutineExceptionHandler) r1
            if (r1 == 0) goto L7e
            kotlin.coroutines.CoroutineContext r0 = r0.getContext()
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Unable to load font "
            r3.<init>(r5)
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            r2.<init>(r7, r8)
            r1.handleException(r0, r2)
            goto L7e
        L73:
            r7 = move-exception
            kotlin.coroutines.CoroutineContext r8 = r0.getContext()
            boolean r8 = kotlinx.coroutines.JobKt.isActive(r8)
            if (r8 == 0) goto L7f
        L7e:
            return r4
        L7f:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncFontListLoader.loadWithTimeoutOrNull$ui_text_release(androidx.compose.ui.text.font.Font, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
