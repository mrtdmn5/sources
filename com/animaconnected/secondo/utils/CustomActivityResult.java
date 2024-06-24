package com.animaconnected.secondo.utils;

import android.content.ActivityNotFoundException;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import com.animaconnected.logger.LogKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomActivityResult.kt */
/* loaded from: classes3.dex */
public final class CustomActivityResult<Input, Result> {
    private Function1<? super Result, Unit> callback;
    private final ActivityResultLauncher<Input> launcher;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: CustomActivityResult.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <Input, Result> CustomActivityResult<Input, Result> registerForActivityResult(ActivityResultCaller caller, ActivityResultContract<Input, Result> contract) {
            Intrinsics.checkNotNullParameter(caller, "caller");
            Intrinsics.checkNotNullParameter(contract, "contract");
            return new CustomActivityResult<>(caller, contract, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ CustomActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract activityResultContract, DefaultConstructorMarker defaultConstructorMarker) {
        this(activityResultCaller, activityResultContract);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void launch$default(CustomActivityResult customActivityResult, Object obj, Function1 function1, int r3, Object obj2) {
        if ((r3 & 2) != 0) {
            function1 = new Function1<Result, Unit>() { // from class: com.animaconnected.secondo.utils.CustomActivityResult$launch$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Result result) {
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj3) {
                    invoke2((CustomActivityResult$launch$1<Result>) obj3);
                    return Unit.INSTANCE;
                }
            };
        }
        customActivityResult.launch(obj, function1);
    }

    public static final void launcher$lambda$0(CustomActivityResult this$0, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.callback.invoke(obj);
    }

    public final void launch(Input r3) {
        launch$default(this, r3, null, 2, null);
    }

    private CustomActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<Input, Result> activityResultContract) {
        this.callback = new Function1<Result, Unit>() { // from class: com.animaconnected.secondo.utils.CustomActivityResult$callback$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result result) {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2((CustomActivityResult$callback$1<Result>) obj);
                return Unit.INSTANCE;
            }
        };
        ActivityResultLauncher<Input> registerForActivityResult = activityResultCaller.registerForActivityResult(activityResultContract, new ActivityResultCallback() { // from class: com.animaconnected.secondo.utils.CustomActivityResult$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                CustomActivityResult.launcher$lambda$0(CustomActivityResult.this, obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.launcher = registerForActivityResult;
    }

    public final void launch(Input r8, Function1<? super Result, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        try {
            this.launcher.launch(r8);
        } catch (ActivityNotFoundException unused) {
            LogKt.debug$default((Object) this, "CustomActivityResult", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.CustomActivityResult$launch$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Activity can not be found to execute the given input.";
                }
            }, 6, (Object) null);
        }
    }
}
