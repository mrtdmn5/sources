package com.animaconnected.watch.behaviour.types;

import com.animaconnected.secondo.R;
import com.animaconnected.watch.behaviour.interfaces.Music;
import com.animaconnected.watch.behaviour.interfaces.PlayResult;
import com.animaconnected.watch.display.RemoteAppImpl;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FindPhone.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.types.FindPhone$playMusic$1", f = "FindPhone.kt", l = {R.styleable.AppTheme_stepsHistoryGoalLineColorDetail}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FindPhone$playMusic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref$IntRef $currentRepeat;
    final /* synthetic */ Music $music;
    final /* synthetic */ Ref$ObjectRef<PlayResult> $result;
    Object L$0;
    int label;
    final /* synthetic */ FindPhone this$0;

    /* compiled from: FindPhone.kt */
    @DebugMetadata(c = "com.animaconnected.watch.behaviour.types.FindPhone$playMusic$1$2", f = "FindPhone.kt", l = {R.styleable.AppTheme_stepsHistoryFontDetail}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.watch.behaviour.types.FindPhone$playMusic$1$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FindPhone this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(FindPhone findPhone, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = findPhone;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
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
                FindPhone findPhone = this.this$0;
                this.label = 1;
                if (RemoteAppImpl.changeView$default(findPhone, 1, null, this, 2, null) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FindPhone$playMusic$1(FindPhone findPhone, Ref$IntRef ref$IntRef, Ref$ObjectRef<PlayResult> ref$ObjectRef, Music music, Continuation<? super FindPhone$playMusic$1> continuation) {
        super(2, continuation);
        this.this$0 = findPhone;
        this.$currentRepeat = ref$IntRef;
        this.$result = ref$ObjectRef;
        this.$music = music;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FindPhone$playMusic$1(this.this$0, this.$currentRepeat, this.$result, this.$music, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0044, code lost:            r9 = r8.this$0.getCurrentDisplay();     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x007b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x00a6 -> B:5:0x00ab). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r8.label
            r2 = 1
            if (r1 == 0) goto L1d
            if (r1 != r2) goto L15
            java.lang.Object r1 = r8.L$0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref$ObjectRef) r1
            kotlin.ResultKt.throwOnFailure(r9)
            r3 = r1
            r1 = r0
            r0 = r8
            goto Lab
        L15:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.animaconnected.watch.behaviour.types.FindPhone r9 = r8.this$0
            java.util.Set r9 = com.animaconnected.watch.behaviour.types.FindPhone.access$getFindPhoneListeners$p(r9)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L2c:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L3c
            java.lang.Object r1 = r9.next()
            com.animaconnected.watch.behaviour.interfaces.FindPhoneListener r1 = (com.animaconnected.watch.behaviour.interfaces.FindPhoneListener) r1
            r1.onFindPhoneStarted()
            goto L2c
        L3c:
            com.animaconnected.watch.behaviour.types.FindPhone r9 = r8.this$0
            java.lang.Integer r9 = com.animaconnected.watch.behaviour.types.FindPhone.access$getCurrentDisplay(r9)
            if (r9 == 0) goto L6d
            com.animaconnected.watch.behaviour.types.FindPhone r9 = r8.this$0
            java.lang.Integer r9 = com.animaconnected.watch.behaviour.types.FindPhone.access$getCurrentDisplay(r9)
            if (r9 != 0) goto L4d
            goto L53
        L4d:
            int r9 = r9.intValue()
            if (r9 == r2) goto L6d
        L53:
            com.animaconnected.watch.behaviour.types.FindPhone r9 = r8.this$0
            com.animaconnected.watch.DisplayWatch r9 = r9.getDisplayWatch$watch_release()
            if (r9 == 0) goto L6d
            kotlinx.coroutines.CoroutineScope r9 = r9.getScope()
            if (r9 == 0) goto L6d
            com.animaconnected.watch.behaviour.types.FindPhone$playMusic$1$2 r1 = new com.animaconnected.watch.behaviour.types.FindPhone$playMusic$1$2
            com.animaconnected.watch.behaviour.types.FindPhone r3 = r8.this$0
            r4 = 0
            r1.<init>(r3, r4)
            r3 = 3
            kotlinx.coroutines.BuildersKt.launch$default(r9, r4, r4, r1, r3)
        L6d:
            r9 = r8
        L6e:
            kotlin.jvm.internal.Ref$IntRef r1 = r9.$currentRepeat
            int r1 = r1.element
            com.animaconnected.watch.behaviour.types.FindPhone r3 = r9.this$0
            java.lang.Float[] r3 = com.animaconnected.watch.behaviour.types.FindPhone.access$getVolumeModel$p(r3)
            int r3 = r3.length
            if (r1 >= r3) goto Lb7
            kotlin.jvm.internal.Ref$ObjectRef<com.animaconnected.watch.behaviour.interfaces.PlayResult> r1 = r9.$result
            T r3 = r1.element
            com.animaconnected.watch.behaviour.interfaces.PlayResult r4 = com.animaconnected.watch.behaviour.interfaces.PlayResult.Finished
            if (r3 != r4) goto Lb7
            com.animaconnected.watch.behaviour.types.FindPhone r3 = r9.this$0
            com.animaconnected.watch.behaviour.interfaces.FindPhoneMusicPlayer r3 = com.animaconnected.watch.behaviour.types.FindPhone.access$getMusicPlayer$p(r3)
            com.animaconnected.watch.behaviour.interfaces.Music r4 = r9.$music
            com.animaconnected.watch.behaviour.types.FindPhone r5 = r9.this$0
            java.lang.Float[] r5 = com.animaconnected.watch.behaviour.types.FindPhone.access$getVolumeModel$p(r5)
            kotlin.jvm.internal.Ref$IntRef r6 = r9.$currentRepeat
            int r6 = r6.element
            r5 = r5[r6]
            float r5 = r5.floatValue()
            r9.L$0 = r1
            r9.label = r2
            java.lang.Object r3 = r3.play(r4, r5, r9)
            if (r3 != r0) goto La6
            return r0
        La6:
            r7 = r0
            r0 = r9
            r9 = r3
            r3 = r1
            r1 = r7
        Lab:
            r3.element = r9
            kotlin.jvm.internal.Ref$IntRef r9 = r0.$currentRepeat
            int r3 = r9.element
            int r3 = r3 + r2
            r9.element = r3
            r9 = r0
            r0 = r1
            goto L6e
        Lb7:
            com.animaconnected.watch.behaviour.types.FindPhone r0 = r9.this$0
            r0.stopMusic()
            kotlin.jvm.internal.Ref$ObjectRef<com.animaconnected.watch.behaviour.interfaces.PlayResult> r0 = r9.$result
            T r0 = r0.element
            com.animaconnected.watch.behaviour.interfaces.PlayResult r1 = com.animaconnected.watch.behaviour.interfaces.PlayResult.Finished
            if (r0 == r1) goto Lc8
            com.animaconnected.watch.behaviour.interfaces.PlayResult r1 = com.animaconnected.watch.behaviour.interfaces.PlayResult.Stopped
            if (r0 != r1) goto Ld1
        Lc8:
            com.animaconnected.watch.behaviour.types.FindPhone r9 = r9.this$0
            long r0 = com.animaconnected.info.DateTimeUtilsKt.currentTimeMillis()
            com.animaconnected.watch.behaviour.types.FindPhone.access$setLastTimestampMusicEnded$p(r9, r0)
        Ld1:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.types.FindPhone$playMusic$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FindPhone$playMusic$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
