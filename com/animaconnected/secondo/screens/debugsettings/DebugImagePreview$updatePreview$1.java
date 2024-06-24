package com.animaconnected.secondo.screens.debugsettings;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.animaconnected.secondo.R;
import com.animaconnected.watch.display.AndroidGraphicsKt;
import com.animaconnected.watch.image.GraphicsKt;
import com.animaconnected.watch.image.Mitmap;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DebugImagePreview.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugImagePreview$updatePreview$1", f = "DebugImagePreview.kt", l = {R.styleable.AppTheme_stepsHistoryColumnTodayColorActivity, R.styleable.AppTheme_stepsHistoryLineLegendColorActivity}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugImagePreview$updatePreview$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Pair<String, Bitmap> $currentImage;
    final /* synthetic */ ImageView $image;
    Object L$0;
    int label;
    final /* synthetic */ DebugImagePreview this$0;

    /* compiled from: DebugImagePreview.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugImagePreview$updatePreview$1$1", f = "DebugImagePreview.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugImagePreview$updatePreview$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        final /* synthetic */ Mitmap $newMitmap;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Mitmap mitmap, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$newMitmap = mitmap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$newMitmap, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return AndroidGraphicsKt.toBitmap$default(GraphicsKt.toMitmap(GraphicsKt.toImageCommand$default(this.$newMitmap, 0, 0, null, null, 12, null)), null, 1, null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugImagePreview$updatePreview$1(DebugImagePreview debugImagePreview, ImageView imageView, Pair<String, Bitmap> pair, Continuation<? super DebugImagePreview$updatePreview$1> continuation) {
        super(2, continuation);
        this.this$0 = debugImagePreview;
        this.$image = imageView;
        this.$currentImage = pair;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugImagePreview$updatePreview$1(this.this$0, this.$image, this.$currentImage, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0139 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x013a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugImagePreview$updatePreview$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DebugImagePreview$updatePreview$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
