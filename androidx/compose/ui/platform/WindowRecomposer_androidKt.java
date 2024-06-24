package androidx.compose.ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import androidx.compose.runtime.CompositionContext;
import androidx.core.os.HandlerCompat;
import com.kronaby.watch.app.R;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorJobImpl;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowKt__ShareKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.flow.SharingConfig;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StartedWhileSubscribed;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: WindowRecomposer.android.kt */
/* loaded from: classes.dex */
public final class WindowRecomposer_androidKt {
    public static final LinkedHashMap animationScale = new LinkedHashMap();

    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1] */
    public static final StateFlow access$getAnimationScaleFlowFor(Context context) {
        StateFlow stateFlow;
        LinkedHashMap linkedHashMap = animationScale;
        synchronized (linkedHashMap) {
            Object obj = linkedHashMap.get(context);
            if (obj == null) {
                ContentResolver contentResolver = context.getContentResolver();
                Uri uriFor = Settings.Global.getUriFor("animator_duration_scale");
                final BufferedChannel Channel$default = ChannelKt.Channel$default(-1, null, 6);
                SafeFlow safeFlow = new SafeFlow(new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(contentResolver, uriFor, new ContentObserver(HandlerCompat.createAsync(Looper.getMainLooper())) { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1
                    @Override // android.database.ContentObserver
                    public final void onChange(boolean z, Uri uri) {
                        Channel$default.mo1701trySendJP2dKIU(Unit.INSTANCE);
                    }
                }, Channel$default, context, null));
                SupervisorJobImpl SupervisorJob$default = SupervisorKt.SupervisorJob$default();
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                ContextScope contextScope = new ContextScope(SupervisorJob$default.plus(MainDispatcherLoader.dispatcher));
                StartedWhileSubscribed WhileSubscribed$default = SharingStarted.Companion.WhileSubscribed$default();
                Float valueOf = Float.valueOf(Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f));
                SharingConfig configureSharing$FlowKt__ShareKt = FlowKt__ShareKt.configureSharing$FlowKt__ShareKt(safeFlow, 1);
                StateFlowImpl MutableStateFlow = StateFlowKt.MutableStateFlow(valueOf);
                ReadonlyStateFlow readonlyStateFlow = new ReadonlyStateFlow(MutableStateFlow, FlowKt__ShareKt.launchSharing$FlowKt__ShareKt(contextScope, configureSharing$FlowKt__ShareKt.context, configureSharing$FlowKt__ShareKt.upstream, MutableStateFlow, WhileSubscribed$default, valueOf));
                linkedHashMap.put(context, readonlyStateFlow);
                obj = readonlyStateFlow;
            }
            stateFlow = (StateFlow) obj;
        }
        return stateFlow;
    }

    public static final CompositionContext getCompositionContext(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(R.id.androidx_compose_ui_view_composition_context);
        if (tag instanceof CompositionContext) {
            return (CompositionContext) tag;
        }
        return null;
    }
}
