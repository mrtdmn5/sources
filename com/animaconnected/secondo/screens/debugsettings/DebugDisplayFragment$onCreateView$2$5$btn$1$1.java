package com.animaconnected.secondo.screens.debugsettings;

import android.view.View;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.display.RemoteApp;
import com.animaconnected.watch.display.view.Display;
import com.animaconnected.watch.display.view.DisplayDefinitionKt;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugDisplayFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$onCreateView$2$5$btn$1$1", f = "DebugDisplayFragment.kt", l = {118}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugDisplayFragment$onCreateView$2$5$btn$1$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ RemoteApp $app;
    int label;
    final /* synthetic */ DebugDisplayFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugDisplayFragment$onCreateView$2$5$btn$1$1(DebugDisplayFragment debugDisplayFragment, RemoteApp remoteApp, Continuation<? super DebugDisplayFragment$onCreateView$2$5$btn$1$1> continuation) {
        super(2, continuation);
        this.this$0 = debugDisplayFragment;
        this.$app = remoteApp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugDisplayFragment$onCreateView$2$5$btn$1$1(this.this$0, this.$app, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((DebugDisplayFragment$onCreateView$2$5$btn$1$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list;
        Object showApp;
        DebugDisplayView debugDisplayView;
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
            list = this.this$0.watchApps;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((RemoteApp) it.next()).deactivated(Slot.Display);
            }
            this.$app.activate(Slot.Display);
            DebugDisplayFragment debugDisplayFragment = this.this$0;
            RemoteApp remoteApp = this.$app;
            this.label = 1;
            showApp = debugDisplayFragment.showApp(remoteApp, this);
            if (showApp == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        debugDisplayView = this.this$0.debugDisplayView;
        if (debugDisplayView != null) {
            debugDisplayView.getEmulatorDisplay().setDrawCommands(DisplayDefinitionKt.toDrawCommands((Display) CollectionsKt___CollectionsKt.first((List) this.$app.getDisplays())));
            return Unit.INSTANCE;
        }
        Intrinsics.throwUninitializedPropertyAccessException("debugDisplayView");
        throw null;
    }
}
