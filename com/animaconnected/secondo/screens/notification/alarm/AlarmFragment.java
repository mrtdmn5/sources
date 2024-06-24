package com.animaconnected.secondo.screens.notification.alarm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.LifecycleCoroutineScope$launchWhenResumed$1;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.notification.NotificationDetailsFragment;
import com.animaconnected.secondo.widget.compose.ComponentsKt;
import com.animaconnected.watch.behaviour.alarms.AlarmsViewModel;
import com.animaconnected.watch.provider.WeekDayFormatter;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: AlarmFragment.kt */
/* loaded from: classes3.dex */
public final class AlarmFragment extends NotificationDetailsFragment {
    public static final int $stable = 8;
    private final WeekDayFormatter weekDayFormatter = new WeekDayFormatter();
    private final AlarmsViewModel viewModel = new AlarmsViewModel();

    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [com.animaconnected.secondo.screens.notification.alarm.AlarmFragment$onCreateView$view$1$1$1, kotlin.jvm.internal.Lambda] */
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        LifecycleCoroutineScopeImpl lifecycleScope = Hashing.getLifecycleScope(this);
        BuildersKt.launch$default(lifecycleScope, null, null, new LifecycleCoroutineScope$launchWhenResumed$1(lifecycleScope, new AlarmFragment$onCreateView$1(this, null), null), 3);
        View inflate = inflater.inflate(R.layout.fragment_alarm, viewGroup, false);
        ((ComposeView) inflate.findViewById(R.id.alarm_layout)).setContent(ComposableLambdaKt.composableLambdaInstance(591491630, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.notification.alarm.AlarmFragment$onCreateView$view$1$1$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r3v3, types: [com.animaconnected.secondo.screens.notification.alarm.AlarmFragment$onCreateView$view$1$1$1$1, kotlin.jvm.internal.Lambda] */
            public final void invoke(Composer composer, int r3) {
                if ((r3 & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                final AlarmFragment alarmFragment = AlarmFragment.this;
                ComponentsKt.BrandTheme(ComposableLambdaKt.composableLambda(composer, 1321134845, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.notification.alarm.AlarmFragment$onCreateView$view$1$1$1.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int r5) {
                        AlarmsViewModel alarmsViewModel;
                        WeekDayFormatter weekDayFormatter;
                        if ((r5 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        alarmsViewModel = AlarmFragment.this.viewModel;
                        AlarmFragment alarmFragment2 = AlarmFragment.this;
                        weekDayFormatter = alarmFragment2.weekDayFormatter;
                        AlarmViewsKt.AlarmsList(alarmsViewModel, alarmFragment2, weekDayFormatter, composer2, 584);
                    }
                }), composer, 6);
            }
        }, true));
        initView(inflate);
        return inflate;
    }
}
