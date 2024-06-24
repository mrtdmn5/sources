package com.animaconnected.watch.behaviour.temperature;

import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: WeatherHttpClient.kt */
@Serializable
/* loaded from: classes3.dex */
public final class OpenWeatherApiResponse {
    public static final Companion Companion = new Companion(null);
    private final int cod;
    private final Main main;

    /* compiled from: WeatherHttpClient.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<OpenWeatherApiResponse> serializer() {
            return OpenWeatherApiResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ OpenWeatherApiResponse(int r2, int r3, Main main, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (r2 & 3)) {
            zzac.throwMissingFieldException(r2, 3, OpenWeatherApiResponse$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.cod = r3;
        this.main = main;
    }

    public static /* synthetic */ OpenWeatherApiResponse copy$default(OpenWeatherApiResponse openWeatherApiResponse, int r1, Main main, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            r1 = openWeatherApiResponse.cod;
        }
        if ((r3 & 2) != 0) {
            main = openWeatherApiResponse.main;
        }
        return openWeatherApiResponse.copy(r1, main);
    }

    public static final /* synthetic */ void write$Self$watch_release(OpenWeatherApiResponse openWeatherApiResponse, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeIntElement(0, openWeatherApiResponse.cod, serialDescriptor);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, OpenWeatherApiResponse$Main$$serializer.INSTANCE, openWeatherApiResponse.main);
    }

    public final int component1() {
        return this.cod;
    }

    public final Main component2() {
        return this.main;
    }

    public final OpenWeatherApiResponse copy(int r2, Main main) {
        Intrinsics.checkNotNullParameter(main, "main");
        return new OpenWeatherApiResponse(r2, main);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenWeatherApiResponse)) {
            return false;
        }
        OpenWeatherApiResponse openWeatherApiResponse = (OpenWeatherApiResponse) obj;
        if (this.cod == openWeatherApiResponse.cod && Intrinsics.areEqual(this.main, openWeatherApiResponse.main)) {
            return true;
        }
        return false;
    }

    public final int getCod() {
        return this.cod;
    }

    public final Main getMain() {
        return this.main;
    }

    public int hashCode() {
        return this.main.hashCode() + (Integer.hashCode(this.cod) * 31);
    }

    public String toString() {
        return "OpenWeatherApiResponse(cod=" + this.cod + ", main=" + this.main + ')';
    }

    /* compiled from: WeatherHttpClient.kt */
    @Serializable
    /* loaded from: classes3.dex */
    public static final class Main {
        public static final Companion Companion = new Companion(null);
        private final double temp;

        /* compiled from: WeatherHttpClient.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Main> serializer() {
                return OpenWeatherApiResponse$Main$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public Main(double d) {
            this.temp = d;
        }

        public static /* synthetic */ Main copy$default(Main main, double d, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                d = main.temp;
            }
            return main.copy(d);
        }

        public final double component1() {
            return this.temp;
        }

        public final Main copy(double d) {
            return new Main(d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Main) && Double.compare(this.temp, ((Main) obj).temp) == 0) {
                return true;
            }
            return false;
        }

        public final double getTemp() {
            return this.temp;
        }

        public int hashCode() {
            return Double.hashCode(this.temp);
        }

        public String toString() {
            return "Main(temp=" + this.temp + ')';
        }

        public /* synthetic */ Main(int r2, double d, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 == (r2 & 1)) {
                this.temp = d;
            } else {
                zzac.throwMissingFieldException(r2, 1, OpenWeatherApiResponse$Main$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
        }
    }

    public OpenWeatherApiResponse(int r2, Main main) {
        Intrinsics.checkNotNullParameter(main, "main");
        this.cod = r2;
        this.main = main;
    }
}
