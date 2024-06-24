package com.animaconnected.secondo.screens.workout.utils;

import com.animaconnected.secondo.R;
import com.animaconnected.watch.fitness.LocationEntry;
import com.animaconnected.widget.ImageLoadingState;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: GoogleMapsGenerator.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.utils.GoogleMapsGeneratorKt$generateMapImage$2", f = "GoogleMapsGenerator.kt", l = {99, 128, R.styleable.AppTheme_statusTopStripeSetup}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class GoogleMapsGeneratorKt$generateMapImage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageLoadingState>, Object> {
    final /* synthetic */ long $imageSize;
    final /* synthetic */ List<LocationEntry> $locations;
    final /* synthetic */ long $pathColor;
    final /* synthetic */ int $resIdMapStyle;
    final /* synthetic */ long $timestamp;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleMapsGeneratorKt$generateMapImage$2(List<LocationEntry> list, long j, long j2, long j3, int r8, Continuation<? super GoogleMapsGeneratorKt$generateMapImage$2> continuation) {
        super(2, continuation);
        this.$locations = list;
        this.$timestamp = j;
        this.$imageSize = j2;
        this.$pathColor = j3;
        this.$resIdMapStyle = r8;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GoogleMapsGeneratorKt$generateMapImage$2 googleMapsGeneratorKt$generateMapImage$2 = new GoogleMapsGeneratorKt$generateMapImage$2(this.$locations, this.$timestamp, this.$imageSize, this.$pathColor, this.$resIdMapStyle, continuation);
        googleMapsGeneratorKt$generateMapImage$2.L$0 = obj;
        return googleMapsGeneratorKt$generateMapImage$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x014e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.workout.utils.GoogleMapsGeneratorKt$generateMapImage$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImageLoadingState> continuation) {
        return ((GoogleMapsGeneratorKt$generateMapImage$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
