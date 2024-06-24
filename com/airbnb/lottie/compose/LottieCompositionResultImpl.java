package com.airbnb.lottie.compose;

import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import com.airbnb.lottie.LottieComposition;
import com.google.common.collect.Platform;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CompletableDeferredKt;

/* compiled from: LottieCompositionResult.kt */
/* loaded from: classes.dex */
public final class LottieCompositionResultImpl implements LottieCompositionResult {
    public final DerivedSnapshotState isComplete$delegate;
    public final DerivedSnapshotState isSuccess$delegate;
    public final CompletableDeferredImpl compositionDeferred = CompletableDeferredKt.CompletableDeferred$default();
    public final ParcelableSnapshotMutableState value$delegate = Platform.mutableStateOf$default(null);
    public final ParcelableSnapshotMutableState error$delegate = Platform.mutableStateOf$default(null);

    public LottieCompositionResultImpl() {
        Platform.derivedStateOf(new Function0<Boolean>() { // from class: com.airbnb.lottie.compose.LottieCompositionResultImpl$isLoading$2
            {
                super(0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z;
                LottieCompositionResultImpl lottieCompositionResultImpl = LottieCompositionResultImpl.this;
                if (((LottieComposition) lottieCompositionResultImpl.value$delegate.getValue()) == null && ((Throwable) lottieCompositionResultImpl.error$delegate.getValue()) == null) {
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
        this.isComplete$delegate = Platform.derivedStateOf(new Function0<Boolean>() { // from class: com.airbnb.lottie.compose.LottieCompositionResultImpl$isComplete$2
            {
                super(0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z;
                LottieCompositionResultImpl lottieCompositionResultImpl = LottieCompositionResultImpl.this;
                if (((LottieComposition) lottieCompositionResultImpl.value$delegate.getValue()) == null && ((Throwable) lottieCompositionResultImpl.error$delegate.getValue()) == null) {
                    z = false;
                } else {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        });
        Platform.derivedStateOf(new Function0<Boolean>() { // from class: com.airbnb.lottie.compose.LottieCompositionResultImpl$isFailure$2
            {
                super(0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z;
                if (((Throwable) LottieCompositionResultImpl.this.error$delegate.getValue()) != null) {
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
        this.isSuccess$delegate = Platform.derivedStateOf(new Function0<Boolean>() { // from class: com.airbnb.lottie.compose.LottieCompositionResultImpl$isSuccess$2
            {
                super(0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z;
                if (((LottieComposition) LottieCompositionResultImpl.this.value$delegate.getValue()) != null) {
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.State
    public final LottieComposition getValue() {
        return (LottieComposition) this.value$delegate.getValue();
    }
}
