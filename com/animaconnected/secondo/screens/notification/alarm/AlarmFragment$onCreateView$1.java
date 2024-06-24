package com.animaconnected.secondo.screens.notification.alarm;

import android.content.Context;
import com.animaconnected.secondo.provider.notification.configuration.item.NotificationItemConstants;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingStorage;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.behaviour.alarms.AlarmsViewModel;
import com.animaconnected.watch.provider.WatchAlarm;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: AlarmFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.notification.alarm.AlarmFragment$onCreateView$1", f = "AlarmFragment.kt", l = {24}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AlarmFragment$onCreateView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AlarmFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlarmFragment$onCreateView$1(AlarmFragment alarmFragment, Continuation<? super AlarmFragment$onCreateView$1> continuation) {
        super(2, continuation);
        this.this$0 = alarmFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AlarmFragment$onCreateView$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AlarmsViewModel alarmsViewModel;
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
            alarmsViewModel = this.this$0.viewModel;
            CommonFlow<List<WatchAlarm>> alarmsFlow = alarmsViewModel.getAlarmsFlow();
            final AlarmFragment alarmFragment = this.this$0;
            FlowCollector<? super List<WatchAlarm>> flowCollector = new FlowCollector() { // from class: com.animaconnected.secondo.screens.notification.alarm.AlarmFragment$onCreateView$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((List<WatchAlarm>) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(List<WatchAlarm> list, Continuation<? super Unit> continuation) {
                    Context context = AlarmFragment.this.getContext();
                    List<WatchAlarm> list2 = list;
                    boolean z = false;
                    if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                        Iterator<T> it = list2.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (((WatchAlarm) it.next()).getEnabled()) {
                                z = true;
                                break;
                            }
                        }
                    }
                    MiniOnboardingStorage.setConfigured(context, z, NotificationItemConstants.getNotificationName(5));
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (alarmsFlow.collect(flowCollector, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AlarmFragment$onCreateView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
