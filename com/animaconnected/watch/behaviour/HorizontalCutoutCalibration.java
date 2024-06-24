package com.animaconnected.watch.behaviour;

import com.animaconnected.watch.behaviour.CutoutCalibration;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.strings.Static;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CutoutCalibration.kt */
/* loaded from: classes3.dex */
public final class HorizontalCutoutCalibration extends CutoutCalibration {
    public static final Companion Companion = new Companion(null);
    public static final String TYPE = "HorizontalScreenCalibration";
    private final AppId id;
    private final Static title;

    /* compiled from: CutoutCalibration.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public HorizontalCutoutCalibration(boolean z, int r4) {
        super(z, r4, CutoutCalibration.Axis.HORIZONTAL, StringsExtensionsKt.m1571static(TYPE));
        this.id = AppId.DebugHorizontalScreenCalibration;
        this.title = StringsExtensionsKt.m1571static("Horizontal Screen Cal.");
    }

    @Override // com.animaconnected.watch.behaviour.CutoutCalibration, com.animaconnected.watch.display.WatchApp
    public AppId getId() {
        return this.id;
    }

    @Override // com.animaconnected.watch.behaviour.CutoutCalibration, com.animaconnected.watch.display.WatchApp
    public Static getTitle() {
        return this.title;
    }
}
