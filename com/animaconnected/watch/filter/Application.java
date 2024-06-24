package com.animaconnected.watch.filter;

import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: FilterSettingsExtension.kt */
@Serializable
/* loaded from: classes3.dex */
public final class Application {
    private final String displayName;
    private final String identifier;
    private ApplicationSetting setting;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, EnumsKt.createSimpleEnumSerializer("com.animaconnected.watch.filter.ApplicationSetting", ApplicationSetting.values())};

    /* compiled from: FilterSettingsExtension.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Application> serializer() {
            return Application$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Application(int r2, String str, String str2, ApplicationSetting applicationSetting, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (r2 & 7)) {
            zzac.throwMissingFieldException(r2, 7, Application$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.identifier = str;
        this.displayName = str2;
        this.setting = applicationSetting;
    }

    public static /* synthetic */ Application copy$default(Application application, String str, String str2, ApplicationSetting applicationSetting, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = application.identifier;
        }
        if ((r4 & 2) != 0) {
            str2 = application.displayName;
        }
        if ((r4 & 4) != 0) {
            applicationSetting = application.setting;
        }
        return application.copy(str, str2, applicationSetting);
    }

    public static final /* synthetic */ void write$Self$watch_release(Application application, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.encodeStringElement(serialDescriptor, 0, application.identifier);
        compositeEncoder.encodeStringElement(serialDescriptor, 1, application.displayName);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], application.setting);
    }

    public final String component1() {
        return this.identifier;
    }

    public final String component2() {
        return this.displayName;
    }

    public final ApplicationSetting component3() {
        return this.setting;
    }

    public final Application copy(String identifier, String displayName, ApplicationSetting setting) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(setting, "setting");
        return new Application(identifier, displayName, setting);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Application)) {
            return false;
        }
        Application application = (Application) obj;
        if (Intrinsics.areEqual(this.identifier, application.identifier) && Intrinsics.areEqual(this.displayName, application.displayName) && this.setting == application.setting) {
            return true;
        }
        return false;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final ApplicationSetting getSetting() {
        return this.setting;
    }

    public int hashCode() {
        return this.setting.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.displayName, this.identifier.hashCode() * 31, 31);
    }

    public final void setSetting(ApplicationSetting applicationSetting) {
        Intrinsics.checkNotNullParameter(applicationSetting, "<set-?>");
        this.setting = applicationSetting;
    }

    public String toString() {
        return "Application(identifier=" + this.identifier + ", displayName=" + this.displayName + ", setting=" + this.setting + ')';
    }

    public Application(String identifier, String displayName, ApplicationSetting setting) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(setting, "setting");
        this.identifier = identifier;
        this.displayName = displayName;
        this.setting = setting;
    }
}
