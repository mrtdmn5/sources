package com.animaconnected.watch.filter;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: FilterSettingsExtension.kt */
@Serializable
/* loaded from: classes3.dex */
public final class ImportantContact {
    public static final Companion Companion = new Companion(null);
    private final String displayName;
    private final boolean isFavourite;
    private final String platformSpecificIdentifier;

    /* compiled from: FilterSettingsExtension.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ImportantContact> serializer() {
            return ImportantContact$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ ImportantContact(int r2, String str, String str2, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (r2 & 3)) {
            zzac.throwMissingFieldException(r2, 3, ImportantContact$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.platformSpecificIdentifier = str;
        this.displayName = str2;
        if ((r2 & 4) == 0) {
            this.isFavourite = false;
        } else {
            this.isFavourite = z;
        }
    }

    public static /* synthetic */ ImportantContact copy$default(ImportantContact importantContact, String str, String str2, boolean z, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = importantContact.platformSpecificIdentifier;
        }
        if ((r4 & 2) != 0) {
            str2 = importantContact.displayName;
        }
        if ((r4 & 4) != 0) {
            z = importantContact.isFavourite;
        }
        return importantContact.copy(str, str2, z);
    }

    public static final /* synthetic */ void write$Self$watch_release(ImportantContact importantContact, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z = false;
        compositeEncoder.encodeStringElement(serialDescriptor, 0, importantContact.platformSpecificIdentifier);
        compositeEncoder.encodeStringElement(serialDescriptor, 1, importantContact.displayName);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || importantContact.isFavourite) {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 2, importantContact.isFavourite);
        }
    }

    public final String component1() {
        return this.platformSpecificIdentifier;
    }

    public final String component2() {
        return this.displayName;
    }

    public final boolean component3() {
        return this.isFavourite;
    }

    public final ImportantContact copy(String platformSpecificIdentifier, String displayName, boolean z) {
        Intrinsics.checkNotNullParameter(platformSpecificIdentifier, "platformSpecificIdentifier");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        return new ImportantContact(platformSpecificIdentifier, displayName, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImportantContact)) {
            return false;
        }
        ImportantContact importantContact = (ImportantContact) obj;
        if (Intrinsics.areEqual(this.platformSpecificIdentifier, importantContact.platformSpecificIdentifier) && Intrinsics.areEqual(this.displayName, importantContact.displayName) && this.isFavourite == importantContact.isFavourite) {
            return true;
        }
        return false;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getPlatformSpecificIdentifier() {
        return this.platformSpecificIdentifier;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isFavourite) + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.displayName, this.platformSpecificIdentifier.hashCode() * 31, 31);
    }

    public final boolean isFavourite() {
        return this.isFavourite;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ImportantContact(platformSpecificIdentifier=");
        sb.append(this.platformSpecificIdentifier);
        sb.append(", displayName=");
        sb.append(this.displayName);
        sb.append(", isFavourite=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isFavourite, ')');
    }

    public ImportantContact(String platformSpecificIdentifier, String displayName, boolean z) {
        Intrinsics.checkNotNullParameter(platformSpecificIdentifier, "platformSpecificIdentifier");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        this.platformSpecificIdentifier = platformSpecificIdentifier;
        this.displayName = displayName;
        this.isFavourite = z;
    }

    public /* synthetic */ ImportantContact(String str, String str2, boolean z, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (r4 & 4) != 0 ? false : z);
    }
}
