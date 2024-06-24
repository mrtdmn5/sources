package com.animaconnected.watch.filter;

import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.animaconnected.watch.filter.Ancs;
import com.google.android.gms.tasks.zzac;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: FilterSettingsExtension.kt */
@Serializable
/* loaded from: classes3.dex */
public final class AncsFilter {
    private final Ancs.Attribute ancsAttribute;
    private final Set<Ancs.Category> ancsCategory;
    private final int index;
    private final String searchString;
    private Ancs.VibrationPattern vibration;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new LinkedHashSetSerializer(EnumsKt.createSimpleEnumSerializer("com.animaconnected.watch.filter.Ancs.Category", Ancs.Category.values())), EnumsKt.createSimpleEnumSerializer("com.animaconnected.watch.filter.Ancs.Attribute", Ancs.Attribute.values()), null, EnumsKt.createSimpleEnumSerializer("com.animaconnected.watch.filter.Ancs.VibrationPattern", Ancs.VibrationPattern.values())};

    /* compiled from: FilterSettingsExtension.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<AncsFilter> serializer() {
            return AncsFilter$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ AncsFilter(int r2, int r3, Set set, Ancs.Attribute attribute, String str, Ancs.VibrationPattern vibrationPattern, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (r2 & 31)) {
            zzac.throwMissingFieldException(r2, 31, AncsFilter$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.index = r3;
        this.ancsCategory = set;
        this.ancsAttribute = attribute;
        this.searchString = str;
        this.vibration = vibrationPattern;
    }

    public static /* synthetic */ AncsFilter copy$default(AncsFilter ancsFilter, int r4, Set set, Ancs.Attribute attribute, String str, Ancs.VibrationPattern vibrationPattern, int r9, Object obj) {
        if ((r9 & 1) != 0) {
            r4 = ancsFilter.index;
        }
        if ((r9 & 2) != 0) {
            set = ancsFilter.ancsCategory;
        }
        Set set2 = set;
        if ((r9 & 4) != 0) {
            attribute = ancsFilter.ancsAttribute;
        }
        Ancs.Attribute attribute2 = attribute;
        if ((r9 & 8) != 0) {
            str = ancsFilter.searchString;
        }
        String str2 = str;
        if ((r9 & 16) != 0) {
            vibrationPattern = ancsFilter.vibration;
        }
        return ancsFilter.copy(r4, set2, attribute2, str2, vibrationPattern);
    }

    public static final /* synthetic */ void write$Self$watch_release(AncsFilter ancsFilter, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.encodeIntElement(0, ancsFilter.index, serialDescriptor);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, kSerializerArr[1], ancsFilter.ancsCategory);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, kSerializerArr[2], ancsFilter.ancsAttribute);
        compositeEncoder.encodeStringElement(serialDescriptor, 3, ancsFilter.searchString);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], ancsFilter.vibration);
    }

    public final int component1() {
        return this.index;
    }

    public final Set<Ancs.Category> component2() {
        return this.ancsCategory;
    }

    public final Ancs.Attribute component3() {
        return this.ancsAttribute;
    }

    public final String component4() {
        return this.searchString;
    }

    public final Ancs.VibrationPattern component5() {
        return this.vibration;
    }

    public final AncsFilter copy(int r8, Set<? extends Ancs.Category> set, Ancs.Attribute attribute, String searchString, Ancs.VibrationPattern vibration) {
        Intrinsics.checkNotNullParameter(searchString, "searchString");
        Intrinsics.checkNotNullParameter(vibration, "vibration");
        return new AncsFilter(r8, set, attribute, searchString, vibration);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AncsFilter)) {
            return false;
        }
        AncsFilter ancsFilter = (AncsFilter) obj;
        if (this.index == ancsFilter.index && Intrinsics.areEqual(this.ancsCategory, ancsFilter.ancsCategory) && this.ancsAttribute == ancsFilter.ancsAttribute && Intrinsics.areEqual(this.searchString, ancsFilter.searchString) && this.vibration == ancsFilter.vibration) {
            return true;
        }
        return false;
    }

    public final Ancs.Attribute getAncsAttribute() {
        return this.ancsAttribute;
    }

    public final Set<Ancs.Category> getAncsCategory() {
        return this.ancsCategory;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getSearchString() {
        return this.searchString;
    }

    public final Ancs.VibrationPattern getVibration() {
        return this.vibration;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = Integer.hashCode(this.index) * 31;
        Set<Ancs.Category> set = this.ancsCategory;
        int r2 = 0;
        if (set == null) {
            hashCode = 0;
        } else {
            hashCode = set.hashCode();
        }
        int r0 = (hashCode2 + hashCode) * 31;
        Ancs.Attribute attribute = this.ancsAttribute;
        if (attribute != null) {
            r2 = attribute.hashCode();
        }
        return this.vibration.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.searchString, (r0 + r2) * 31, 31);
    }

    public final void setVibration(Ancs.VibrationPattern vibrationPattern) {
        Intrinsics.checkNotNullParameter(vibrationPattern, "<set-?>");
        this.vibration = vibrationPattern;
    }

    public String toString() {
        return "AncsFilter(index=" + this.index + ", ancsCategory=" + this.ancsCategory + ", ancsAttribute=" + this.ancsAttribute + ", searchString=" + this.searchString + ", vibration=" + this.vibration + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AncsFilter(int r2, Set<? extends Ancs.Category> set, Ancs.Attribute attribute, String searchString, Ancs.VibrationPattern vibration) {
        Intrinsics.checkNotNullParameter(searchString, "searchString");
        Intrinsics.checkNotNullParameter(vibration, "vibration");
        this.index = r2;
        this.ancsCategory = set;
        this.ancsAttribute = attribute;
        this.searchString = searchString;
        this.vibration = vibration;
    }
}
