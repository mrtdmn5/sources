package com.animaconnected.watch.display;

import com.animaconnected.watch.display.view.BottomPusher;
import com.animaconnected.watch.display.view.Display;
import com.animaconnected.watch.strings.KeyString;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RemoteAppViews.kt */
/* loaded from: classes3.dex */
public final class BasicView {
    private Function1<? super Display, Unit> actions;
    private Function1<? super BottomPusher, Unit> bottomPusher;
    private KeyString description;
    private boolean progressBar;
    private final KeyString title;

    public BasicView(KeyString title, KeyString keyString, boolean z, Function1<? super Display, Unit> function1, Function1<? super BottomPusher, Unit> bottomPusher) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(bottomPusher, "bottomPusher");
        this.title = title;
        this.description = keyString;
        this.progressBar = z;
        this.actions = function1;
        this.bottomPusher = bottomPusher;
    }

    public final Function1<Display, Unit> getActions() {
        return this.actions;
    }

    public final Function1<BottomPusher, Unit> getBottomPusher() {
        return this.bottomPusher;
    }

    public final KeyString getDescription() {
        return this.description;
    }

    public final boolean getProgressBar() {
        return this.progressBar;
    }

    public final KeyString getTitle() {
        return this.title;
    }

    public final void setActions(Function1<? super Display, Unit> function1) {
        this.actions = function1;
    }

    public final void setBottomPusher(Function1<? super BottomPusher, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.bottomPusher = function1;
    }

    public final void setDescription(KeyString keyString) {
        this.description = keyString;
    }

    public final void setProgressBar(boolean z) {
        this.progressBar = z;
    }

    public /* synthetic */ BasicView(KeyString keyString, KeyString keyString2, boolean z, Function1 function1, Function1 function12, int r13, DefaultConstructorMarker defaultConstructorMarker) {
        this(keyString, (r13 & 2) != 0 ? null : keyString2, (r13 & 4) != 0 ? false : z, (r13 & 8) != 0 ? null : function1, (r13 & 16) != 0 ? new Function1<BottomPusher, Unit>() { // from class: com.animaconnected.watch.display.BasicView.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BottomPusher bottomPusher) {
                Intrinsics.checkNotNullParameter(bottomPusher, "$this$null");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BottomPusher bottomPusher) {
                invoke2(bottomPusher);
                return Unit.INSTANCE;
            }
        } : function12);
    }
}
