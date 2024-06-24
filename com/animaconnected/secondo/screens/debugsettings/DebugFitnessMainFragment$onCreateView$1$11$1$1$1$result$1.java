package com.animaconnected.secondo.screens.debugsettings;

import android.content.Context;
import android.net.Uri;
import android.widget.Button;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DebugFitnessMainFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreateView$1$11$1$1$1$result$1", f = "DebugFitnessMainFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugFitnessMainFragment$onCreateView$1$11$1$1$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $filename;
    final /* synthetic */ Button $this_apply;
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ DebugFitnessMainFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugFitnessMainFragment$onCreateView$1$11$1$1$1$result$1(String str, DebugFitnessMainFragment debugFitnessMainFragment, Button button, Uri uri, Continuation<? super DebugFitnessMainFragment$onCreateView$1$11$1$1$1$result$1> continuation) {
        super(2, continuation);
        this.$filename = str;
        this.this$0 = debugFitnessMainFragment;
        this.$this_apply = button;
        this.$uri = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugFitnessMainFragment$onCreateView$1$11$1$1$1$result$1(this.$filename, this.this$0, this.$this_apply, this.$uri, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean importDatabase;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (!StringsKt__StringsJVMKt.endsWith(this.$filename, "db", true)) {
                importDatabase = false;
                if (!StringsKt__StringsKt.contains(this.$filename, "database", false)) {
                    if (StringsKt__StringsJVMKt.endsWith(this.$filename, "json", true)) {
                        DebugFitnessMainFragment debugFitnessMainFragment = this.this$0;
                        Context context = this.$this_apply.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                        importDatabase = debugFitnessMainFragment.importJson(context, this.$uri);
                    }
                    return Boolean.valueOf(importDatabase);
                }
            }
            DebugFitnessMainFragment debugFitnessMainFragment2 = this.this$0;
            Context context2 = this.$this_apply.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            importDatabase = debugFitnessMainFragment2.importDatabase(context2, this.$uri);
            return Boolean.valueOf(importDatabase);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((DebugFitnessMainFragment$onCreateView$1$11$1$1$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
