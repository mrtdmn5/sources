package androidx.compose.ui.window;

import com.amazonaws.services.s3.internal.Constants;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidPopup.android.kt */
@DebugMetadata(c = "androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5", f = "AndroidPopup.android.kt", l = {Constants.BUCKET_REDIRECT_STATUS_CODE}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AndroidPopup_androidKt$Popup$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ PopupLayout $popupLayout;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidPopup_androidKt$Popup$5(PopupLayout popupLayout, Continuation<? super AndroidPopup_androidKt$Popup$5> continuation) {
        super(2, continuation);
        this.$popupLayout = popupLayout;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidPopup_androidKt$Popup$5 androidPopup_androidKt$Popup$5 = new AndroidPopup_androidKt$Popup$5(this.$popupLayout, continuation);
        androidPopup_androidKt$Popup$5.L$0 = obj;
        return androidPopup_androidKt$Popup$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AndroidPopup_androidKt$Popup$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:            if (r3.onInfiniteOperation() == r0) goto L16;     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r9.label
            r2 = 1
            if (r1 == 0) goto L1a
            if (r1 != r2) goto L12
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            goto L4f
        L12:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1a:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            r1 = r10
            r10 = r9
        L23:
            boolean r3 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
            if (r3 == 0) goto L69
            r10.L$0 = r1
            r10.label = r2
            kotlin.coroutines.CoroutineContext r3 = r10.getContext()
            androidx.compose.ui.platform.InfiniteAnimationPolicy$Key r4 = androidx.compose.ui.platform.InfiniteAnimationPolicy.Key.$$INSTANCE
            kotlin.coroutines.CoroutineContext$Element r3 = r3.get(r4)
            androidx.compose.ui.platform.InfiniteAnimationPolicy r3 = (androidx.compose.ui.platform.InfiniteAnimationPolicy) r3
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5$1 r4 = new kotlin.jvm.functions.Function1<java.lang.Long, kotlin.Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5.1
                static {
                    /*
                        androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5$1 r0 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5$1) androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5.1.INSTANCE androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5.AnonymousClass1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5.AnonymousClass1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.Long r1) {
                    /*
                        r0 = this;
                        java.lang.Number r1 = (java.lang.Number) r1
                        r1.longValue()
                        kotlin.Unit r1 = kotlin.Unit.INSTANCE
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5.AnonymousClass1.invoke(java.lang.Object):java.lang.Object");
                }
            }
            if (r3 != 0) goto L42
            java.lang.Object r3 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameNanos(r4, r10)
            goto L4c
        L42:
            androidx.compose.ui.platform.InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2 r5 = new androidx.compose.ui.platform.InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2
            r6 = 0
            r5.<init>(r4, r6)
            java.lang.Object r3 = r3.onInfiniteOperation()
        L4c:
            if (r3 != r0) goto L4f
            return r0
        L4f:
            androidx.compose.ui.window.PopupLayout r3 = r10.$popupLayout
            int[] r4 = r3.locationOnScreen
            r5 = 0
            r6 = r4[r5]
            r7 = r4[r2]
            android.view.View r8 = r3.composeView
            r8.getLocationOnScreen(r4)
            r5 = r4[r5]
            if (r6 != r5) goto L65
            r4 = r4[r2]
            if (r7 == r4) goto L23
        L65:
            r3.updateParentBounds$ui_release()
            goto L23
        L69:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
