package com.animaconnected.secondo.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.StringsBackendImpl;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.WatchManager;
import com.kronaby.watch.app.R;
import java.util.Locale;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LocaleChangedReceiver.kt */
/* loaded from: classes.dex */
public final class LocaleChangedReceiver extends BroadcastReceiver {
    public static final int $stable = 0;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!Intrinsics.areEqual(intent.getAction(), "android.intent.action.LOCALE_CHANGED")) {
            return;
        }
        WatchManager watchManager = ProviderFactory.getWatch().getWatchManager();
        final Watch.WatchState value = watchManager.getCurrentWatch().getState().getValue();
        Locale translationCompatibleLocale = ProviderFactory.createConfigProvider().getTranslationCompatibleLocale();
        Intrinsics.checkNotNullExpressionValue(translationCompatibleLocale, "getTranslationCompatibleLocale(...)");
        String string = context.getString(R.string.brand);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        StringsBackendImpl stringsBackendImpl = new StringsBackendImpl(context, translationCompatibleLocale, string);
        LogKt.debug$default((Object) this, "LocaleChangedReceiver", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.LocaleChangedReceiver$onReceive$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "New locale. Current watch state " + Watch.WatchState.this;
            }
        }, 6, (Object) null);
        watchManager.updateStringBackend(stringsBackendImpl);
        if (value != Watch.WatchState.Ready) {
            return;
        }
        CoroutineScope scope = watchManager.getCurrentWatch().getScope();
        BuildersKt.launch$default(scope, null, null, new LocaleChangedReceiver$onReceive$2(watchManager, null), 3);
        BuildersKt.launch$default(scope, null, null, new LocaleChangedReceiver$onReceive$3(null), 3);
    }
}
