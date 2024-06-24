package com.animaconnected.secondo.behaviour.distress;

import android.content.Context;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.R;
import com.animaconnected.secondo.behaviour.distress.api.DistressApi;
import com.animaconnected.secondo.behaviour.distress.api.request.UserStateResponse;
import com.animaconnected.secondo.behaviour.distress.model.DistressModel;
import com.animaconnected.secondo.behaviour.distress.service.DistressService;
import com.animaconnected.secondo.behaviour.distress.utils.VibratorHelper;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.behaviour.distress.WalkMeHomeState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.HttpException;

/* compiled from: DistressPlugin.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.distress.DistressPlugin$startWalk$2", f = "DistressPlugin.kt", l = {R.styleable.AppTheme_stepsHistoryBackgroundDetail, R.styleable.AppTheme_stepsHistoryGoalLineColorActivity, R.styleable.AppTheme_stepsHistoryLineColorActivity}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DistressPlugin$startWalk$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistressPlugin$startWalk$2(Context context, Continuation<? super DistressPlugin$startWalk$2> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DistressPlugin$startWalk$2 distressPlugin$startWalk$2 = new DistressPlugin$startWalk$2(this.$context, continuation);
        distressPlugin$startWalk$2.L$0 = obj;
        return distressPlugin$startWalk$2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        DistressModel companion;
        int r14;
        DistressModel distressModel;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Object obj2 = this.label;
        try {
            try {
            } catch (Exception e) {
                str = DistressPlugin.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                LogKt.err$default(obj2, str, (Throwable) e, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.distress.DistressPlugin$startWalk$2.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Fail to start walk.";
                    }
                }, 4, (Object) null);
                DistressService.Companion.stop(this.$context);
                VibratorHelper.getInstance().error();
                Context context = this.$context;
                String string = context.getString(com.kronaby.watch.app.R.string.distress_unavailable);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                ViewKt.toast$default(context, string, false, 2, (Object) null);
                companion = DistressModel.Companion.getInstance(this.$context);
                if ((e instanceof HttpException) && ((HttpException) e).code == 409) {
                    DistressApi companion2 = DistressApi.Companion.getInstance(this.$context);
                    this.L$0 = companion;
                    this.label = 2;
                    obj = companion2.getUserState(this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    Context context2 = this.$context;
                    String string2 = context2.getString(com.kronaby.watch.app.R.string.distress_unavailable);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    ViewKt.toast$default(context2, string2, false, 2, (Object) null);
                    companion.notifyChanged();
                }
            }
        } catch (Exception e2) {
            if ((e2 instanceof HttpException) && ((r14 = ((HttpException) e2).code) == 404 || r14 == 403)) {
                DistressApi companion3 = DistressApi.Companion.getInstance(this.$context);
                this.L$0 = obj2;
                this.label = 3;
                if (companion3.removeObserver(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                distressModel = obj2;
            }
        }
        if (obj2 != 0) {
            if (obj2 != 1) {
                if (obj2 != 2) {
                    if (obj2 == 3) {
                        distressModel = (DistressModel) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        ProviderFactory.getDistressProvider().setNotConfigured();
                        distressModel.setObserver(null);
                        distressModel.setState(WalkMeHomeState.Registered);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                companion = (DistressModel) this.L$0;
                ResultKt.throwOnFailure(obj);
                WalkMeHomeState fromString = WalkMeHomeState.Companion.fromString(((UserStateResponse) obj).getState());
                if (WalkMeHomeState.Active == fromString) {
                    DistressService.Companion.start(this.$context);
                }
                companion.setState(fromString);
                return Unit.INSTANCE;
            }
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = coroutineScope;
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            DistressService.Companion.start(this.$context);
            DistressApi companion4 = DistressApi.Companion.getInstance(this.$context);
            this.L$0 = coroutineScope2;
            this.label = 1;
            obj2 = coroutineScope2;
            if (companion4.startWalk(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DistressPlugin$startWalk$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
