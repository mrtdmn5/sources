package com.animaconnected.secondo.provider.lottie;

import android.content.Context;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;
import com.animaconnected.logger.LogKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: Lottie.kt */
/* loaded from: classes3.dex */
public final class LottieKt {
    public static final String asSpec(LottieFile lottieFile) {
        Intrinsics.checkNotNullParameter(lottieFile, "<this>");
        String assetName = lottieFile.getPath();
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        return assetName;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x006c -> B:10:0x0072). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object loadLottieAnimation(android.content.Context r8, com.animaconnected.secondo.provider.lottie.LottieFile[] r9, kotlin.coroutines.Continuation<? super java.util.List<? extends com.airbnb.lottie.LottieComposition>> r10) {
        /*
            boolean r0 = r10 instanceof com.animaconnected.secondo.provider.lottie.LottieKt$loadLottieAnimation$3
            if (r0 == 0) goto L13
            r0 = r10
            com.animaconnected.secondo.provider.lottie.LottieKt$loadLottieAnimation$3 r0 = (com.animaconnected.secondo.provider.lottie.LottieKt$loadLottieAnimation$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.provider.lottie.LottieKt$loadLottieAnimation$3 r0 = new com.animaconnected.secondo.provider.lottie.LottieKt$loadLottieAnimation$3
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            int r8 = r0.I$1
            int r9 = r0.I$0
            java.lang.Object r2 = r0.L$3
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.Object r4 = r0.L$2
            java.util.Collection r4 = (java.util.Collection) r4
            java.lang.Object r5 = r0.L$1
            com.animaconnected.secondo.provider.lottie.LottieFile[] r5 = (com.animaconnected.secondo.provider.lottie.LottieFile[]) r5
            java.lang.Object r6 = r0.L$0
            android.content.Context r6 = (android.content.Context) r6
            kotlin.ResultKt.throwOnFailure(r10)
            goto L72
        L3b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L43:
            kotlin.ResultKt.throwOnFailure(r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            int r2 = r9.length
            r10.<init>(r2)
            int r2 = r9.length
            r4 = 0
            r7 = r9
            r9 = r8
            r8 = r2
            r2 = r10
            r10 = r7
        L53:
            if (r4 >= r8) goto L7d
            r5 = r10[r4]
            r0.L$0 = r9
            r0.L$1 = r10
            r0.L$2 = r2
            r0.L$3 = r2
            r0.I$0 = r4
            r0.I$1 = r8
            r0.label = r3
            java.lang.Object r5 = loadLottieAnimation(r9, r5, r0)
            if (r5 != r1) goto L6c
            return r1
        L6c:
            r6 = r9
            r9 = r4
            r4 = r2
            r7 = r5
            r5 = r10
            r10 = r7
        L72:
            com.airbnb.lottie.LottieComposition r10 = (com.airbnb.lottie.LottieComposition) r10
            r2.add(r10)
            int r9 = r9 + r3
            r2 = r4
            r10 = r5
            r4 = r9
            r9 = r6
            goto L53
        L7d:
            java.util.List r2 = (java.util.List) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.lottie.LottieKt.loadLottieAnimation(android.content.Context, com.animaconnected.secondo.provider.lottie.LottieFile[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object loadLottieAnimation(Context context, LottieFile lottieFile, Continuation<? super LottieComposition> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        LottieTask<LottieComposition> fromAsset = LottieCompositionFactory.fromAsset(context, lottieFile.getPath());
        fromAsset.addListener(new LottieListener() { // from class: com.animaconnected.secondo.provider.lottie.LottieKt$loadLottieAnimation$2$1
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(LottieComposition composition) {
                Intrinsics.checkNotNullParameter(composition, "composition");
                if (cancellableContinuationImpl.isActive()) {
                    cancellableContinuationImpl.resumeWith(composition);
                }
            }
        });
        fromAsset.addFailureListener(new LottieListener() { // from class: com.animaconnected.secondo.provider.lottie.LottieKt$loadLottieAnimation$2$2
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Throwable th) {
                Intrinsics.checkNotNull(th);
                LogKt.err$default((Object) th, "Failed to load Lottie", (String) null, th, false, 10, (Object) null);
                cancellableContinuationImpl.resumeWith(null);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return result;
    }
}
