package com.animaconnected.secondo.behaviour.weather;

import android.content.Context;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.types.WeatherApp;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WeatherPlugin.kt */
/* loaded from: classes3.dex */
public final class WeatherPlugin implements BehaviourPlugin<WeatherApp> {
    public static final int $stable = 8;
    private WeatherApp weatherApp;
    private final int iconResourceId = R.drawable.ic_weather;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<WeatherApp>() { // from class: com.animaconnected.secondo.behaviour.weather.WeatherPlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WeatherApp invoke() {
            WeatherApp weatherApp;
            weatherApp = WeatherPlugin.this.weatherApp;
            if (weatherApp != null) {
                return weatherApp;
            }
            Intrinsics.throwUninitializedPropertyAccessException("weatherApp");
            throw null;
        }
    });
    private final String type = WeatherApp.TYPE;
    private final int nameId = -1;

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getIconResourceId() {
        return this.iconResourceId;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getNameId() {
        return this.nameId;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public void initBehaviour(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.weatherApp = new WeatherApp(new Function0<FitnessProvider.Profile.Temperature>() { // from class: com.animaconnected.secondo.behaviour.weather.WeatherPlugin$initBehaviour$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FitnessProvider.Profile.Temperature invoke() {
                return ProviderFactory.getWatch().fitness().getProfile().getTemperatureUnit();
            }
        });
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public BaseDetailsFragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return WeatherFragment.Companion.newInstance(slot);
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public WeatherApp getBehaviour() {
        return (WeatherApp) this.behaviour$delegate.getValue();
    }
}
