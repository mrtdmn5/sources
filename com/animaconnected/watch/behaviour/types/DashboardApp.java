package com.animaconnected.watch.behaviour.types;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.secondo.screens.dashboard.DashboardFragment;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.assets.MitmapBackend;
import com.animaconnected.watch.assets.WatchAsset;
import com.animaconnected.watch.behaviour.temperature.Hourly;
import com.animaconnected.watch.device.Command;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.ExpiringString;
import com.animaconnected.watch.display.FirmwareApp;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.image.GraphicsKt;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.provider.weather.HistoricalWeatherProvider;
import com.animaconnected.watch.provider.weather.WeatherViewModel;
import com.animaconnected.watch.strings.Static;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.Instant;

/* compiled from: Dashboard.kt */
/* loaded from: classes3.dex */
public final class DashboardApp implements FirmwareApp {
    public static final Companion Companion = new Companion(null);
    public static final String TYPE = "DashboardApp";
    private final String analyticsName;
    private Function0<Boolean> checkPermissions;
    private final String fallBackString;
    private final Mitmap icon;
    private final AppId id;
    private final boolean isHidden;
    private final Lazy mitmapBackend$delegate;
    private final HistoricalWeatherProvider provider;
    private final Function0<FitnessProvider.Profile.Temperature> temperatureUnit;
    private final Static title;
    private final String type;

    /* compiled from: Dashboard.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DashboardApp(Function0<? extends FitnessProvider.Profile.Temperature> temperatureUnit) {
        Intrinsics.checkNotNullParameter(temperatureUnit, "temperatureUnit");
        this.temperatureUnit = temperatureUnit;
        this.mitmapBackend$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MitmapBackend>() { // from class: com.animaconnected.watch.behaviour.types.DashboardApp$mitmapBackend$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MitmapBackend invoke() {
                return ServiceLocator.INSTANCE.getMitmapBackend();
            }
        });
        this.id = AppId.Dashboard;
        this.type = TYPE;
        this.analyticsName = TYPE;
        this.title = StringsExtensionsKt.m1571static(DashboardFragment.name);
        this.icon = GraphicsKt.emptyMitmap();
        this.isHidden = true;
        this.checkPermissions = new Function0<Boolean>() { // from class: com.animaconnected.watch.behaviour.types.DashboardApp$checkPermissions$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.TRUE;
            }
        };
        this.provider = ServiceLocator.INSTANCE.getWeatherProvider();
        this.fallBackString = "";
    }

    private final MitmapBackend getMitmapBackend() {
        return (MitmapBackend) this.mitmapBackend$delegate.getValue();
    }

    private final String getTemperature() {
        Double d;
        Object obj;
        WeatherViewModel.Companion companion = WeatherViewModel.Companion;
        Iterator<T> it = this.provider.getHourly().iterator();
        while (true) {
            d = null;
            if (it.hasNext()) {
                obj = it.next();
                Hourly hourly = (Hourly) obj;
                Instant instant = hourly.getInstant();
                Instant instant2 = hourly.getInstant();
                int r6 = Duration.$r8$clinit;
                boolean z = true;
                Instant m1706plusLRDsOJo = instant2.m1706plusLRDsOJo(DurationKt.toDuration(1, DurationUnit.HOURS));
                Instant now = DateTimeUtilsKt.now();
                if (now.compareTo(instant) < 0 || now.compareTo(m1706plusLRDsOJo) > 0) {
                    z = false;
                }
                if (z) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Hourly hourly2 = (Hourly) obj;
        if (hourly2 != null) {
            d = Double.valueOf(hourly2.getTemp());
        }
        String convertTempToString = companion.convertTempToString(d, this.temperatureUnit.invoke());
        if (convertTempToString == null) {
            return this.fallBackString;
        }
        return convertTempToString;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public Function0<Boolean> getCheckPermissions() {
        return this.checkPermissions;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public Mitmap getIcon() {
        return this.icon;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public AppId getId() {
        return this.id;
    }

    @Override // com.animaconnected.watch.display.FirmwareApp
    public Map<String, Mitmap> getImages() {
        return MapsKt__MapsKt.mapOf(new Pair("heart", MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Dashboard_Heart, null, 2, null)), new Pair(Command.DND, MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Dashboard_DND, null, 2, null)));
    }

    @Override // com.animaconnected.watch.display.FirmwareApp
    public Map<String, ExpiringString> getStrings() {
        String temperature = getTemperature();
        String str = this.fallBackString;
        Instant lastFetched = this.provider.getLastFetched();
        int r4 = Duration.$r8$clinit;
        return MapsKt__MapsJVMKt.mapOf(new Pair("temperature", new ExpiringString(temperature, str, lastFetched.m1706plusLRDsOJo(DurationKt.toDuration(6, DurationUnit.HOURS)))));
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public boolean isHidden() {
        return this.isHidden;
    }

    public void setCheckPermissions(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.checkPermissions = function0;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public Static getTitle() {
        return this.title;
    }
}
