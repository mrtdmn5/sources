package com.animaconnected.secondo.screens.debugsettings;

import androidx.core.graphics.drawable.DrawableKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.notification.picker.AppInfo;
import com.animaconnected.watch.display.AndroidGraphicsKt;
import com.animaconnected.watch.image.GraphicsKt;
import com.animaconnected.watch.image.Mitmap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;

/* compiled from: DebugDisplayFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$LvglIcon$getKronabyIconAsMitmap$2", f = "DebugDisplayFragment.kt", l = {238}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugDisplayFragment$LvglIcon$getKronabyIconAsMitmap$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Mitmap>, Object> {
    int label;

    /* compiled from: DebugDisplayFragment.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$LvglIcon$getKronabyIconAsMitmap$2$1", f = "DebugDisplayFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$LvglIcon$getKronabyIconAsMitmap$2$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Mitmap>, Object> {
        final /* synthetic */ AppInfo $appInfo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AppInfo appInfo, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$appInfo = appInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$appInfo, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return AndroidGraphicsKt.toMitmap$default(DrawableKt.toBitmap$default(this.$appInfo.getAppIcon(), 64, 64, 4), null, 1, null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Mitmap> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public DebugDisplayFragment$LvglIcon$getKronabyIconAsMitmap$2(Continuation<? super DebugDisplayFragment$LvglIcon$getKronabyIconAsMitmap$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugDisplayFragment$LvglIcon$getKronabyIconAsMitmap$2(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            AppInfo appInfo = ProviderFactory.getImportantAppsProvider().getAppInfo("com.kronaby.watch.debug");
            if (appInfo == null) {
                return GraphicsKt.emptyMitmap();
            }
            DefaultIoScheduler defaultIoScheduler = Dispatchers.IO;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(appInfo, null);
            this.label = 1;
            obj = BuildersKt.withContext(defaultIoScheduler, anonymousClass1, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Mitmap> continuation) {
        return ((DebugDisplayFragment$LvglIcon$getKronabyIconAsMitmap$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
