package com.animaconnected.secondo.provider.labs;

import com.animaconnected.cloud.Cloud;
import com.animaconnected.cloud.amazon.lambda.SendFeedbackParams;
import com.animaconnected.future.FailCallback;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.logger.LogKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LabsProvider.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.labs.LabsProvider$setRating$1", f = "LabsProvider.kt", l = {98}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class LabsProvider$setRating$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $behaviourType;
    final /* synthetic */ String $comment;
    final /* synthetic */ int $rating;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LabsProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LabsProvider$setRating$1(String str, int r2, LabsProvider labsProvider, String str2, Continuation<? super LabsProvider$setRating$1> continuation) {
        super(2, continuation);
        this.$behaviourType = str;
        this.$rating = r2;
        this.this$0 = labsProvider;
        this.$comment = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(CoroutineScope coroutineScope, SendFeedbackParams sendFeedbackParams, Void r9) {
        LogKt.debug$default((Object) coroutineScope, "Successfully sent feedback to cloud. " + sendFeedbackParams.getFeedback(), (String) null, (Throwable) null, false, 14, (Object) null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LabsProvider$setRating$1 labsProvider$setRating$1 = new LabsProvider$setRating$1(this.$behaviourType, this.$rating, this.this$0, this.$comment, continuation);
        labsProvider$setRating$1.L$0 = obj;
        return labsProvider$setRating$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object packageFeedbackData;
        final CoroutineScope coroutineScope;
        Cloud cloud;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            LogKt.debug$default((Object) coroutineScope2, "Sending to aws: " + this.$behaviourType + ": " + this.$rating, (String) null, (Throwable) null, false, 14, (Object) null);
            LabsProvider labsProvider = this.this$0;
            String str = this.$behaviourType;
            String valueOf = String.valueOf(this.$rating);
            String str2 = this.$comment;
            this.L$0 = coroutineScope2;
            this.label = 1;
            packageFeedbackData = labsProvider.packageFeedbackData(str, valueOf, str2, this);
            if (packageFeedbackData == coroutineSingletons) {
                return coroutineSingletons;
            }
            coroutineScope = coroutineScope2;
            obj = packageFeedbackData;
        }
        final SendFeedbackParams sendFeedbackParams = (SendFeedbackParams) obj;
        cloud = this.this$0.cloud;
        cloud.sendFeedback(sendFeedbackParams).success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.labs.LabsProvider$setRating$1$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj2) {
                LabsProvider$setRating$1.invokeSuspend$lambda$0(CoroutineScope.this, sendFeedbackParams, (Void) obj2);
            }
        }).fail(new FailCallback() { // from class: com.animaconnected.secondo.provider.labs.LabsProvider$setRating$1$$ExternalSyntheticLambda1
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                LogKt.debug$default((Object) CoroutineScope.this, "Failed to send feedback to cloud", (String) null, th, false, 10, (Object) null);
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LabsProvider$setRating$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
