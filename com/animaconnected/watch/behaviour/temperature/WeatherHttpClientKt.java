package com.animaconnected.watch.behaviour.temperature;

import com.animaconnected.watch.assets.WatchAsset;
import com.animaconnected.watch.provider.weather.WeatherViewModel;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: WeatherHttpClient.kt */
/* loaded from: classes3.dex */
public final class WeatherHttpClientKt {
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";

    /* compiled from: WeatherHttpClient.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[WeatherViewModel.Weather.values().length];
            try {
                r0[WeatherViewModel.Weather.Clear_Sky.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[WeatherViewModel.Weather.Clear_Sky_Night.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[WeatherViewModel.Weather.Few_Clouds.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[WeatherViewModel.Weather.Few_Clouds_Night.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[WeatherViewModel.Weather.Scattered_Clouds.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[WeatherViewModel.Weather.Broken_Clouds.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r0[WeatherViewModel.Weather.Shower_Rain.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                r0[WeatherViewModel.Weather.Rain.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                r0[WeatherViewModel.Weather.Thunderstorm.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                r0[WeatherViewModel.Weather.Snow.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                r0[WeatherViewModel.Weather.Mist.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                r0[WeatherViewModel.Weather.Unknown.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WatchAsset getWeatherSmallWatchAsset(WeatherViewModel.Weather weather) {
        switch (WhenMappings.$EnumSwitchMapping$0[weather.ordinal()]) {
            case 1:
                return WatchAsset.Weather_App_Clear_Sky_Small_Icon;
            case 2:
                return WatchAsset.Weather_App_Clear_Sky_Night_Small_Icon;
            case 3:
                return WatchAsset.Weather_App_Few_Clouds_Small_Icon;
            case 4:
                return WatchAsset.Weather_App_Few_Clouds_Night_Small_Icon;
            case 5:
                return WatchAsset.Weather_App_Scattered_Clouds_Small_Icon;
            case 6:
                return WatchAsset.Weather_App_Broken_Clouds_Small_Icon;
            case 7:
                return WatchAsset.Weather_App_Shower_Rain_Small_Icon;
            case 8:
                return WatchAsset.Weather_App_Rain_Small_Icon;
            case 9:
                return WatchAsset.Weather_App_Thunderstorm_Small_Icon;
            case 10:
                return WatchAsset.Weather_App_Snow_Small_Icon;
            case 11:
                return WatchAsset.Weather_App_Mist_Small_Icon;
            case 12:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WatchAsset getWeatherWatchAsset(WeatherViewModel.Weather weather) {
        switch (WhenMappings.$EnumSwitchMapping$0[weather.ordinal()]) {
            case 1:
                return WatchAsset.Weather_App_Clear_Sky_Icon;
            case 2:
                return WatchAsset.Weather_App_Clear_Sky_Night_Icon;
            case 3:
                return WatchAsset.Weather_App_Few_Clouds_Icon;
            case 4:
                return WatchAsset.Weather_App_Few_Clouds_Night_Icon;
            case 5:
                return WatchAsset.Weather_App_Scattered_Clouds_Icon;
            case 6:
                return WatchAsset.Weather_App_Broken_Clouds_Icon;
            case 7:
                return WatchAsset.Weather_App_Shower_Rain_Icon;
            case 8:
                return WatchAsset.Weather_App_Rain_Icon;
            case 9:
                return WatchAsset.Weather_App_Thunderstorm_Icon;
            case 10:
                return WatchAsset.Weather_App_Snow_Icon;
            case 11:
                return WatchAsset.Weather_App_Mist_Icon;
            case 12:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:            if (r1.equals("50d") == false) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:            if (r1.equals("13n") == false) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:            return com.animaconnected.watch.provider.weather.WeatherViewModel.Weather.Snow;     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:            if (r1.equals("13d") == false) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:            if (r1.equals("11n") == false) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:            return com.animaconnected.watch.provider.weather.WeatherViewModel.Weather.Thunderstorm;     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:            if (r1.equals("11d") == false) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0059, code lost:            if (r1.equals("10n") == false) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:            return com.animaconnected.watch.provider.weather.WeatherViewModel.Weather.Rain;     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0063, code lost:            if (r1.equals("10d") == false) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0071, code lost:            if (r1.equals("09n") == false) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:            return com.animaconnected.watch.provider.weather.WeatherViewModel.Weather.Shower_Rain;     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007b, code lost:            if (r1.equals("09d") == false) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0089, code lost:            if (r1.equals("04n") == false) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:            return com.animaconnected.watch.provider.weather.WeatherViewModel.Weather.Broken_Clouds;     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0092, code lost:            if (r1.equals("04d") == false) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009e, code lost:            if (r1.equals("03n") == false) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:            return com.animaconnected.watch.provider.weather.WeatherViewModel.Weather.Scattered_Clouds;     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a7, code lost:            if (r1.equals("03d") == false) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:            if (r1.equals("50n") == false) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:7:?, code lost:            return com.animaconnected.watch.provider.weather.WeatherViewModel.Weather.Mist;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0006. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.animaconnected.watch.provider.weather.WeatherViewModel.Weather mapIdToWeather(java.lang.String r1) {
        /*
            if (r1 == 0) goto Ldd
            int r0 = r1.hashCode()
            switch(r0) {
                case 47747: goto Ld1;
                case 47757: goto Lc5;
                case 47778: goto Lb9;
                case 47788: goto Lad;
                case 47809: goto La1;
                case 47819: goto L98;
                case 47840: goto L8c;
                case 47850: goto L83;
                case 47995: goto L75;
                case 48005: goto L6b;
                case 48677: goto L5d;
                case 48687: goto L53;
                case 48708: goto L45;
                case 48718: goto L3b;
                case 48770: goto L2d;
                case 48780: goto L23;
                case 52521: goto L15;
                case 52531: goto Lb;
                default: goto L9;
            }
        L9:
            goto Ldd
        Lb:
            java.lang.String r0 = "50n"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L1f
            goto Ldd
        L15:
            java.lang.String r0 = "50d"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L1f
            goto Ldd
        L1f:
            com.animaconnected.watch.provider.weather.WeatherViewModel$Weather r1 = com.animaconnected.watch.provider.weather.WeatherViewModel.Weather.Mist
            goto Ldf
        L23:
            java.lang.String r0 = "13n"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L37
            goto Ldd
        L2d:
            java.lang.String r0 = "13d"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L37
            goto Ldd
        L37:
            com.animaconnected.watch.provider.weather.WeatherViewModel$Weather r1 = com.animaconnected.watch.provider.weather.WeatherViewModel.Weather.Snow
            goto Ldf
        L3b:
            java.lang.String r0 = "11n"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L4f
            goto Ldd
        L45:
            java.lang.String r0 = "11d"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L4f
            goto Ldd
        L4f:
            com.animaconnected.watch.provider.weather.WeatherViewModel$Weather r1 = com.animaconnected.watch.provider.weather.WeatherViewModel.Weather.Thunderstorm
            goto Ldf
        L53:
            java.lang.String r0 = "10n"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L67
            goto Ldd
        L5d:
            java.lang.String r0 = "10d"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L67
            goto Ldd
        L67:
            com.animaconnected.watch.provider.weather.WeatherViewModel$Weather r1 = com.animaconnected.watch.provider.weather.WeatherViewModel.Weather.Rain
            goto Ldf
        L6b:
            java.lang.String r0 = "09n"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L7f
            goto Ldd
        L75:
            java.lang.String r0 = "09d"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L7f
            goto Ldd
        L7f:
            com.animaconnected.watch.provider.weather.WeatherViewModel$Weather r1 = com.animaconnected.watch.provider.weather.WeatherViewModel.Weather.Shower_Rain
            goto Ldf
        L83:
            java.lang.String r0 = "04n"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L95
            goto Ldd
        L8c:
            java.lang.String r0 = "04d"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L95
            goto Ldd
        L95:
            com.animaconnected.watch.provider.weather.WeatherViewModel$Weather r1 = com.animaconnected.watch.provider.weather.WeatherViewModel.Weather.Broken_Clouds
            goto Ldf
        L98:
            java.lang.String r0 = "03n"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto Laa
            goto Ldd
        La1:
            java.lang.String r0 = "03d"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto Laa
            goto Ldd
        Laa:
            com.animaconnected.watch.provider.weather.WeatherViewModel$Weather r1 = com.animaconnected.watch.provider.weather.WeatherViewModel.Weather.Scattered_Clouds
            goto Ldf
        Lad:
            java.lang.String r0 = "02n"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto Lb6
            goto Ldd
        Lb6:
            com.animaconnected.watch.provider.weather.WeatherViewModel$Weather r1 = com.animaconnected.watch.provider.weather.WeatherViewModel.Weather.Few_Clouds_Night
            goto Ldf
        Lb9:
            java.lang.String r0 = "02d"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto Lc2
            goto Ldd
        Lc2:
            com.animaconnected.watch.provider.weather.WeatherViewModel$Weather r1 = com.animaconnected.watch.provider.weather.WeatherViewModel.Weather.Few_Clouds
            goto Ldf
        Lc5:
            java.lang.String r0 = "01n"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto Lce
            goto Ldd
        Lce:
            com.animaconnected.watch.provider.weather.WeatherViewModel$Weather r1 = com.animaconnected.watch.provider.weather.WeatherViewModel.Weather.Clear_Sky_Night
            goto Ldf
        Ld1:
            java.lang.String r0 = "01d"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto Lda
            goto Ldd
        Lda:
            com.animaconnected.watch.provider.weather.WeatherViewModel$Weather r1 = com.animaconnected.watch.provider.weather.WeatherViewModel.Weather.Clear_Sky
            goto Ldf
        Ldd:
            com.animaconnected.watch.provider.weather.WeatherViewModel$Weather r1 = com.animaconnected.watch.provider.weather.WeatherViewModel.Weather.Unknown
        Ldf:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.temperature.WeatherHttpClientKt.mapIdToWeather(java.lang.String):com.animaconnected.watch.provider.weather.WeatherViewModel$Weather");
    }
}
