package com.animaconnected.secondo.behaviour.call;

import android.os.Build;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.app.ImportantContactKt;
import com.animaconnected.secondo.provider.CallStateListener;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.CallHelper;
import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.behaviour.types.CallsWatchApp;
import com.animaconnected.watch.device.AppAction;
import com.animaconnected.watch.device.CallState;
import com.animaconnected.watch.filter.ImportantContact;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CallsWatchAppAndroid.kt */
/* loaded from: classes3.dex */
public final class CallsWatchAppAndroid extends CallsWatchApp implements CallStateListener {
    public static final String TYPE = "CallsDisplay";
    private final int callId;
    private DisplayWatch watch;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final String tag = "CallsWatchAppAndroid";
    private final Set<String> activeCalls = new LinkedHashSet();

    /* compiled from: CallsWatchAppAndroid.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: CallsWatchAppAndroid.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[AppAction.values().length];
            try {
                r0[AppAction.CallDecline.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[AppAction.CallHangUp.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[AppAction.CallAnswer.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[AppAction.CallLoudSpeaker.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[AppAction.CallMute.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void activate(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        super.activate(slot);
        ProviderFactory.INSTANCE.getCallStateReceiver().addListener(this);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void connected(Watch watch) {
        DisplayWatch displayWatch;
        Intrinsics.checkNotNullParameter(watch, "watch");
        super.connected(watch);
        if (watch instanceof DisplayWatch) {
            displayWatch = (DisplayWatch) watch;
        } else {
            displayWatch = null;
        }
        this.watch = displayWatch;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void deactivated(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        super.deactivated(slot);
        ProviderFactory.INSTANCE.getCallStateReceiver().removeListener(this);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void disconnected(Watch watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        super.disconnected(watch);
        this.watch = null;
    }

    @Override // com.animaconnected.watch.display.FirmwareApp, com.animaconnected.watch.display.WatchApp
    public void onAppAction(int r8, final AppAction action) {
        Object obj;
        CoroutineScope scope;
        Intrinsics.checkNotNullParameter(action, "action");
        LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.call.CallsWatchAppAndroid$onAppAction$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Got a call update! " + AppAction.this;
            }
        }, 6, (Object) null);
        int r0 = WhenMappings.$EnumSwitchMapping$0[action.ordinal()];
        if (r0 != 1 && r0 != 2) {
            if (r0 != 3) {
                if (r0 == 4 || r0 == 5) {
                    LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.call.CallsWatchAppAndroid$onAppAction$5
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Android Calls does not handle " + AppAction.this + " yet(?)";
                        }
                    }, 6, (Object) null);
                    return;
                }
                return;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                if (!CallHelper.INSTANCE.answerCall()) {
                    LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.call.CallsWatchAppAndroid$onAppAction$3
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to answer call.";
                        }
                    }, 6, (Object) null);
                    return;
                }
                return;
            }
            LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.call.CallsWatchAppAndroid$onAppAction$4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return ConstraintWidget$$ExternalSyntheticOutline0.m(new StringBuilder("Android version "), Build.VERSION.SDK_INT, " does not support Answering calls");
                }
            }, 6, (Object) null);
            return;
        }
        CallHelper.INSTANCE.dismissCall();
        Set<String> set = this.activeCalls;
        Set<String> set2 = set;
        Set<String> set3 = set;
        Intrinsics.checkNotNullParameter(set3, "<this>");
        if (set3 instanceof List) {
            List list = (List) set3;
            if (!list.isEmpty()) {
                obj = list.get(list.size() - 1);
            }
            obj = null;
        } else {
            Iterator<T> it = set3.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                while (it.hasNext()) {
                    next = it.next();
                }
                obj = next;
            }
            obj = null;
        }
        TypeIntrinsics.asMutableCollection(set2).remove(obj);
        DisplayWatch displayWatch = this.watch;
        if (displayWatch != null && (scope = displayWatch.getScope()) != null) {
            BuildersKt.launch$default(scope, null, null, new CallsWatchAppAndroid$onAppAction$2(this, null), 3);
        }
    }

    @Override // com.animaconnected.secondo.provider.CallStateListener
    public void onCallStateChanged(final CallState state, final String number) {
        boolean z;
        ImportantContact fromPhoneNumber;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(number, "number");
        LogKt.verbose$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.call.CallsWatchAppAndroid$onCallStateChanged$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                DisplayWatch displayWatch;
                StringBuilder sb = new StringBuilder("Call state: ");
                sb.append(CallState.this);
                sb.append(" number: ");
                sb.append(number);
                sb.append(" and watch ");
                displayWatch = this.watch;
                sb.append(displayWatch);
                return sb.toString();
            }
        }, 6, (Object) null);
        if (state == CallState.Idle) {
            this.activeCalls.clear();
        }
        boolean z2 = true;
        if (number.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.call.CallsWatchAppAndroid$onCallStateChanged$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Missing information from call, third party call? Ignore";
                }
            }, 6, (Object) null);
            return;
        }
        DisplayWatch displayWatch = this.watch;
        if (displayWatch == null) {
            return;
        }
        if (number.length() != 0) {
            z2 = false;
        }
        List list = EmptyList.INSTANCE;
        if (!z2 && (fromPhoneNumber = ImportantContactKt.fromPhoneNumber(ImportantContact.Companion, number)) != null) {
            list = CollectionsKt__CollectionsKt.listOf(fromPhoneNumber);
        }
        BuildersKt.launch$default(displayWatch.getScope(), null, null, new CallsWatchAppAndroid$onCallStateChanged$3(list, state, this, number, displayWatch, null), 3);
    }
}
