package com.animaconnected.watch.image;

import com.animaconnected.watch.image.pickers.PalettePicker;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Graphics.kt */
@DebugMetadata(c = "com.animaconnected.watch.image.ImageBuilder$compress$2", f = "Graphics.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ImageBuilder$compress$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
    final /* synthetic */ boolean $allowChromaKey;
    final /* synthetic */ int $height;
    final /* synthetic */ PalettePicker $palettePicker;
    final /* synthetic */ List<Kolor> $pixels;
    final /* synthetic */ FormatType $type;
    final /* synthetic */ int $width;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageBuilder$compress$2(int r1, int r2, List<Kolor> list, FormatType formatType, PalettePicker palettePicker, boolean z, Continuation<? super ImageBuilder$compress$2> continuation) {
        super(2, continuation);
        this.$width = r1;
        this.$height = r2;
        this.$pixels = list;
        this.$type = formatType;
        this.$palettePicker = palettePicker;
        this.$allowChromaKey = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImageBuilder$compress$2(this.$width, this.$height, this.$pixels, this.$type, this.$palettePicker, this.$allowChromaKey, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return ImageBuilder.INSTANCE.compressBlocking$graphics_release(this.$width, this.$height, this.$pixels, this.$type, this.$palettePicker, this.$allowChromaKey);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
        return ((ImageBuilder$compress$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
