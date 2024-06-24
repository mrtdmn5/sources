package com.animaconnected.secondo.provider.lottie;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda2;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;
import com.animaconnected.future.Future;
import com.animaconnected.future.FutureUtils;
import com.animaconnected.future.Promise;
import com.animaconnected.logger.LogKt;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Lottie.kt */
/* loaded from: classes3.dex */
public final class Lottie {
    public static final int $stable = 0;
    public static final Lottie INSTANCE = new Lottie();

    private Lottie() {
    }

    public static final Future<LottieComposition> loadAnimation(Context context, LottieFile lottieFile) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lottieFile, "lottieFile");
        final Promise promise = new Promise();
        LottieTask<LottieComposition> fromAsset = LottieCompositionFactory.fromAsset(context, lottieFile.getPath());
        fromAsset.addListener(new LottieListener() { // from class: com.animaconnected.secondo.provider.lottie.Lottie$$ExternalSyntheticLambda1
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                Lottie.loadAnimation$lambda$1(Promise.this, (LottieComposition) obj);
            }
        });
        fromAsset.addFailureListener(new LottieListener() { // from class: com.animaconnected.secondo.provider.lottie.Lottie$$ExternalSyntheticLambda2
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                Lottie.loadAnimation$lambda$3(Promise.this, (Throwable) obj);
            }
        });
        Future<LottieComposition> future = promise.getFuture();
        Intrinsics.checkNotNullExpressionValue(future, "getFuture(...)");
        return future;
    }

    public static final void loadAnimation$lambda$1(Promise promise, LottieComposition composition) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(composition, "composition");
        try {
            promise.resolve(composition);
        } catch (IllegalStateException e) {
            LogKt.err$default((Object) e, "Failed to load Lottie. Promise issue: " + e.getMessage(), (String) null, (Throwable) null, false, 14, (Object) null);
        }
    }

    public static final void loadAnimation$lambda$3(Promise promise, Throwable th) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNull(th);
        LogKt.err$default((Object) th, "Failed to load Lottie", (String) null, th, false, 10, (Object) null);
        promise.resolve(null);
    }

    public static final void loadAnimation$lambda$5(Promise promise, LottieComposition result) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(result, "result");
        promise.resolve(result);
    }

    public static final Future<LottieComposition> loadAnimation(Uri uri, Context context) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(context, "context");
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics.checkNotNull(uri);
        InputStream openInputStream = contentResolver.openInputStream(uri);
        final Promise promise = new Promise();
        LottieCompositionFactory.cache(null, new LottieCompositionFactory$$ExternalSyntheticLambda2(openInputStream, 0, null)).addListener(new LottieListener() { // from class: com.animaconnected.secondo.provider.lottie.Lottie$$ExternalSyntheticLambda0
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                Lottie.loadAnimation$lambda$5(Promise.this, (LottieComposition) obj);
            }
        });
        Future<LottieComposition> future = promise.getFuture();
        Intrinsics.checkNotNullExpressionValue(future, "getFuture(...)");
        return future;
    }

    public static final Future<List<LottieComposition>> loadAnimation(Context context, LottieFile... lottieFiles) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lottieFiles, "lottieFiles");
        ArrayList arrayList = new ArrayList(lottieFiles.length);
        for (LottieFile lottieFile : lottieFiles) {
            arrayList.add(loadAnimation(context, lottieFile));
        }
        Future<List<LottieComposition>> merge = FutureUtils.merge(arrayList);
        Intrinsics.checkNotNullExpressionValue(merge, "merge(...)");
        return merge;
    }
}
