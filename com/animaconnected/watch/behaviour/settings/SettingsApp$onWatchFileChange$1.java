package com.animaconnected.watch.behaviour.settings;

import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.device.files.WatchFile;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SettingsApp.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.settings.SettingsApp", f = "SettingsApp.kt", l = {46}, m = "onWatchFileChange$suspendImpl")
/* loaded from: classes3.dex */
public final class SettingsApp$onWatchFileChange$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingsApp this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsApp$onWatchFileChange$1(SettingsApp settingsApp, Continuation<? super SettingsApp$onWatchFileChange$1> continuation) {
        super(continuation);
        this.this$0 = settingsApp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SettingsApp.onWatchFileChange$suspendImpl(this.this$0, (WatchFile) null, (DisplayWatch) null, (Continuation<? super Unit>) this);
    }
}
