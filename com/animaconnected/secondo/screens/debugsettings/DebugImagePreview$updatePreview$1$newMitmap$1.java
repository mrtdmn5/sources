package com.animaconnected.secondo.screens.debugsettings;

import android.content.Context;
import com.animaconnected.watch.image.ImageBuilder;
import com.animaconnected.watch.image.Mitmap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DebugImagePreview.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugImagePreview$updatePreview$1$newMitmap$1", f = "DebugImagePreview.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugImagePreview$updatePreview$1$newMitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Mitmap>, Object> {
    final /* synthetic */ String $name;
    int label;
    final /* synthetic */ DebugImagePreview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugImagePreview$updatePreview$1$newMitmap$1(String str, DebugImagePreview debugImagePreview, Continuation<? super DebugImagePreview$updatePreview$1$newMitmap$1> continuation) {
        super(2, continuation);
        this.$name = str;
        this.this$0 = debugImagePreview;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugImagePreview$updatePreview$1$newMitmap$1(this.$name, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ImageBuilder imageBuilder = ImageBuilder.INSTANCE;
            Storage storage = Storage.INSTANCE;
            String str = this.$name;
            Context requireContext = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            return imageBuilder.decodeToMitmap(storage.getBytes(str, requireContext));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Mitmap> continuation) {
        return ((DebugImagePreview$updatePreview$1$newMitmap$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
