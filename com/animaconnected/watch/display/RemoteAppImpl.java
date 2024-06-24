package com.animaconnected.watch.display;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.HybridWatch;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.device.AppAction;
import com.animaconnected.watch.device.WatchAppAnimation;
import com.animaconnected.watch.display.view.BottomPusher;
import com.animaconnected.watch.display.view.Button;
import com.animaconnected.watch.display.view.Display;
import com.animaconnected.watch.display.view.Element;
import com.animaconnected.watch.display.view.Rectangle;
import com.animaconnected.watch.display.view.ScrollContainer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: RemoteAppImpl.kt */
/* loaded from: classes3.dex */
public abstract class RemoteAppImpl implements RemoteApp {
    private Integer currentDisplay;
    private Integer navigatingToDisplayId;
    private Watch watch;
    private final WatchFonts paint = ServiceLocator.INSTANCE.getWatchFonts();
    private Function0<Boolean> checkPermissions = new Function0<Boolean>() { // from class: com.animaconnected.watch.display.RemoteAppImpl$checkPermissions$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    };
    private Function0<Boolean> checkSetupNeeded = new Function0<Boolean>() { // from class: com.animaconnected.watch.display.RemoteAppImpl$checkSetupNeeded$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    };
    private final VisibilityState onStartState = VisibilityState.Persistent;

    /* compiled from: RemoteAppImpl.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[AppAction.values().length];
            try {
                r0[AppAction.Button1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[AppAction.Button2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[AppAction.Button3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[AppAction.Button4.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[AppAction.Button5.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[AppAction.BottomPusher.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    private final int buttonToIndex(AppAction appAction) {
        switch (WhenMappings.$EnumSwitchMapping$0[appAction.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return AppAction.BottomPusher.getId();
            default:
                return -1;
        }
    }

    public static /* synthetic */ Object changeView$default(RemoteAppImpl remoteAppImpl, int r1, WatchAppAnimation watchAppAnimation, Continuation continuation, int r4, Object obj) {
        if (obj == null) {
            if ((r4 & 2) != 0) {
                watchAppAnimation = WatchAppAnimation.None;
            }
            return remoteAppImpl.changeView(r1, watchAppAnimation, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeView");
    }

    private final void handleAppAction(final int r11, final AppAction appAction, List<Display> list) {
        if (r11 >= list.size()) {
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.display.RemoteAppImpl$handleAppAction$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return ConstraintWidget$$ExternalSyntheticOutline0.m(new StringBuilder("displayId ("), r11, ") isn't defined");
                }
            }, 7, (Object) null);
            return;
        }
        final List<Button> searchButtons = searchButtons(list.get(r11).getChildren());
        final int buttonToIndex = buttonToIndex(appAction);
        if (appAction == AppAction.AppStart) {
            this.navigatingToDisplayId = null;
        }
        this.currentDisplay = Integer.valueOf(r11);
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.display.RemoteAppImpl$handleAppAction$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "App action, currentDisplay " + RemoteAppImpl.this.getCurrentDisplay();
            }
        }, 7, (Object) null);
        if (buttonToIndex == -1) {
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.display.RemoteAppImpl$handleAppAction$3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "App action " + AppAction.this + " not handled by RemoteAppImpl";
                }
            }, 7, (Object) null);
            return;
        }
        if (buttonToIndex == AppAction.BottomPusher.getId()) {
            List<Element> children = list.get(r11).getChildren();
            ArrayList arrayList = new ArrayList();
            for (Object obj : children) {
                if (obj instanceof BottomPusher) {
                    arrayList.add(obj);
                }
            }
            final BottomPusher bottomPusher = (BottomPusher) CollectionsKt___CollectionsKt.firstOrNull((List) arrayList);
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.display.RemoteAppImpl$handleAppAction$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder("Back button pressed on display: ");
                    sb.append(r11);
                    sb.append(". Nav command ");
                    BottomPusher bottomPusher2 = bottomPusher;
                    sb.append(bottomPusher2 != null ? Integer.valueOf(bottomPusher2.getNavCommand()) : null);
                    sb.append(" handled by watch");
                    return sb.toString();
                }
            }, 7, (Object) null);
            return;
        }
        if (buttonToIndex >= searchButtons.size()) {
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.display.RemoteAppImpl$handleAppAction$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "App action " + AppAction.this + " had index " + buttonToIndex + " and couldn't be matched with a draw command: " + searchButtons;
                }
            }, 7, (Object) null);
            return;
        }
        searchButtons.get(buttonToIndex).getOnClick().invoke();
        this.navigatingToDisplayId = searchButtons.get(buttonToIndex).getNavCommand();
        LogKt.debug$default((Object) this, "Display " + r11 + " got a press on button " + appAction + ' ', (String) null, (Throwable) null, false, 14, (Object) null);
    }

    private final List<Button> searchButtons(List<? extends Element> list) {
        List<Button> list2;
        List<? extends Element> list3 = list;
        ArrayList arrayList = new ArrayList();
        for (Element element : list) {
            if (element instanceof ScrollContainer) {
                list2 = searchButtons(((ScrollContainer) element).getChildren());
            } else if (element instanceof Rectangle) {
                list2 = searchButtons(((Rectangle) element).getChildren());
            } else {
                list2 = EmptyList.INSTANCE;
            }
            CollectionsKt__ReversedViewsKt.addAll(list2, arrayList);
        }
        ArrayList plus = CollectionsKt___CollectionsKt.plus((Iterable) arrayList, (Collection) list3);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = plus.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof Button) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    public final Object changeView(final int r9, WatchAppAnimation watchAppAnimation, Continuation<? super Unit> continuation) {
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.display.RemoteAppImpl$changeView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Change view requested. currentdisplay: " + RemoteAppImpl.this.getCurrentDisplay() + ", requested: " + r9;
            }
        }, 7, (Object) null);
        Integer num = this.currentDisplay;
        if (num != null && num.intValue() == r9 && this.navigatingToDisplayId == null) {
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.display.RemoteAppImpl$changeView$3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "No view change is needed";
                }
            }, 7, (Object) null);
        } else {
            DisplayWatch displayWatch$watch_release = getDisplayWatch$watch_release();
            if (displayWatch$watch_release != null) {
                Object changeView = displayWatch$watch_release.changeView(this, r9, watchAppAnimation, continuation);
                if (changeView == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return changeView;
                }
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public Slot[] compatibleSlots() {
        return new Slot[]{Slot.Display};
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void connected(final Watch watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.display.RemoteAppImpl$connected$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "App connected to: " + Watch.this;
            }
        }, 7, (Object) null);
        this.watch = watch;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void disconnected(Watch watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        this.watch = null;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public Function0<Boolean> getCheckPermissions() {
        return this.checkPermissions;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public Function0<Boolean> getCheckSetupNeeded() {
        return this.checkSetupNeeded;
    }

    public final Integer getCurrentDisplay() {
        return this.currentDisplay;
    }

    public final DisplayWatch getDisplayWatch$watch_release() {
        Watch watch = this.watch;
        if (watch instanceof DisplayWatch) {
            return (DisplayWatch) watch;
        }
        return null;
    }

    public final HybridWatch getHybridWatch() {
        Watch watch = this.watch;
        if (watch instanceof HybridWatch) {
            return (HybridWatch) watch;
        }
        return null;
    }

    public final Integer getNavigatingToDisplayId() {
        return this.navigatingToDisplayId;
    }

    @Override // com.animaconnected.watch.display.RemoteApp
    public VisibilityState getOnStartState() {
        return this.onStartState;
    }

    public final WatchFonts getPaint() {
        return this.paint;
    }

    public final Object invalidate(Continuation<? super Unit> continuation) {
        LogKt.debug$default((Object) this, "invalidate()", (String) null, (Throwable) null, false, 14, (Object) null);
        DisplayWatch displayWatch$watch_release = getDisplayWatch$watch_release();
        if (displayWatch$watch_release != null) {
            Object updateApp = displayWatch$watch_release.updateApp(this, continuation);
            if (updateApp == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return updateApp;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public void onAppAction(int r2, AppAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        handleAppAction(r2, action, getDisplays());
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public void onStateChanged(final VisibilityState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == VisibilityState.Stopped) {
            this.currentDisplay = null;
        }
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.display.RemoteAppImpl$onStateChanged$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "App state changed to " + VisibilityState.this + ", currentDisplay " + this.getCurrentDisplay();
            }
        }, 7, (Object) null);
    }

    @Override // com.animaconnected.watch.display.RemoteApp
    public void requestState(VisibilityState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        LogKt.warn$default((Object) this, "TODO call set app state started, send state request to watch " + getDisplayWatch$watch_release(), (String) null, (Throwable) null, false, 14, (Object) null);
        DisplayWatch displayWatch$watch_release = getDisplayWatch$watch_release();
        if (displayWatch$watch_release == null) {
            return;
        }
        if (state != VisibilityState.Glanceable && state != VisibilityState.Persistent) {
            if (state == VisibilityState.Stopped) {
                BuildersKt.launch$default(displayWatch$watch_release.getScope(), null, null, new RemoteAppImpl$requestState$2(displayWatch$watch_release, this, state, null), 3);
                return;
            }
            return;
        }
        BuildersKt.launch$default(displayWatch$watch_release.getScope(), null, null, new RemoteAppImpl$requestState$1(displayWatch$watch_release, this, null), 3);
    }

    public void setCheckPermissions(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.checkPermissions = function0;
    }

    public void setCheckSetupNeeded(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.checkSetupNeeded = function0;
    }

    public final void setCurrentDisplay(Integer num) {
        this.currentDisplay = num;
    }

    public final void setNavigatingToDisplayId(Integer num) {
        this.navigatingToDisplayId = num;
    }
}
