package com.animaconnected.secondo.screens.settings;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.google.android.gms.tasks.zzac;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: OpenSourceLicenses.kt */
@Serializable
/* loaded from: classes3.dex */
public final class Project {
    private final String copyright;
    private final String copyrightSymbol;
    private final String dependency;
    private final String description;
    private final List<String> developers;
    private final String developersString;
    private final String formattedYear;
    private final List<License> licenses;
    private final String project;
    private final String projectAndVersion;
    private final String url;
    private final String version;
    private final String year;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, new ArrayListSerializer(StringSerializer.INSTANCE), null, null, new ArrayListSerializer(License$$serializer.INSTANCE), null, null, null, null, null, null};

    /* compiled from: OpenSourceLicenses.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Project> serializer() {
            return Project$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Project(int r16, String str, String str2, String str3, List list, String str4, String str5, List list2, String str6, String str7, String str8, String str9, String str10, String str11, SerializationConstructorMarker serializationConstructorMarker) {
        String str12;
        String str13;
        String str14;
        String str15 = str3;
        String str16 = str5;
        if (255 != (r16 & 255)) {
            zzac.throwMissingFieldException(r16, 255, Project$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.project = str;
        this.description = str2;
        this.version = str15;
        this.developers = list;
        this.url = str4;
        this.year = str16;
        this.licenses = list2;
        this.dependency = str6;
        String str17 = (r16 & 256) == 0 ? "©" : str7;
        this.copyrightSymbol = str17;
        if ((r16 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) == 0) {
            str12 = list != null ? CollectionsKt___CollectionsKt.joinToString$default(list, ",", null, null, null, 62) : "";
        } else {
            str12 = str8;
        }
        this.developersString = str12;
        if ((r16 & 1024) != 0) {
            str16 = str9;
        } else if (str16 == null) {
            str16 = "20xx";
        }
        this.formattedYear = str16;
        if ((r16 & 2048) == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(' ');
            sb.append(str15 == null ? null : str15);
            str13 = sb.toString();
        } else {
            str13 = str10;
        }
        this.projectAndVersion = str13;
        if ((r16 & 4096) == 0) {
            str14 = "Copyright " + str17 + ' ' + str16 + ' ' + str12;
        } else {
            str14 = str11;
        }
        this.copyright = str14;
    }

    public static /* synthetic */ Project copy$default(Project project, String str, String str2, String str3, List list, String str4, String str5, List list2, String str6, int r18, Object obj) {
        String str7;
        String str8;
        String str9;
        List list3;
        String str10;
        String str11;
        List list4;
        String str12;
        if ((r18 & 1) != 0) {
            str7 = project.project;
        } else {
            str7 = str;
        }
        if ((r18 & 2) != 0) {
            str8 = project.description;
        } else {
            str8 = str2;
        }
        if ((r18 & 4) != 0) {
            str9 = project.version;
        } else {
            str9 = str3;
        }
        if ((r18 & 8) != 0) {
            list3 = project.developers;
        } else {
            list3 = list;
        }
        if ((r18 & 16) != 0) {
            str10 = project.url;
        } else {
            str10 = str4;
        }
        if ((r18 & 32) != 0) {
            str11 = project.year;
        } else {
            str11 = str5;
        }
        if ((r18 & 64) != 0) {
            list4 = project.licenses;
        } else {
            list4 = list2;
        }
        if ((r18 & 128) != 0) {
            str12 = project.dependency;
        } else {
            str12 = str6;
        }
        return project.copy(str7, str8, str9, list3, str10, str11, list4, str12);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x010a, code lost:            if (kotlin.jvm.internal.Intrinsics.areEqual(r11.copyright, "Copyright " + r11.copyrightSymbol + ' ' + r11.formattedYear + ' ' + r11.developersString) == false) goto L54;     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void write$Self$secondo_kronabyRelease(com.animaconnected.secondo.screens.settings.Project r11, kotlinx.serialization.encoding.CompositeEncoder r12, kotlinx.serialization.descriptors.SerialDescriptor r13) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.Project.write$Self$secondo_kronabyRelease(com.animaconnected.secondo.screens.settings.Project, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    public final String component1() {
        return this.project;
    }

    public final String component2() {
        return this.description;
    }

    public final String component3() {
        return this.version;
    }

    public final List<String> component4() {
        return this.developers;
    }

    public final String component5() {
        return this.url;
    }

    public final String component6() {
        return this.year;
    }

    public final List<License> component7() {
        return this.licenses;
    }

    public final String component8() {
        return this.dependency;
    }

    public final Project copy(String project, String str, String str2, List<String> list, String str3, String str4, List<License> list2, String str5) {
        Intrinsics.checkNotNullParameter(project, "project");
        return new Project(project, str, str2, list, str3, str4, list2, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Project)) {
            return false;
        }
        Project project = (Project) obj;
        if (Intrinsics.areEqual(this.project, project.project) && Intrinsics.areEqual(this.description, project.description) && Intrinsics.areEqual(this.version, project.version) && Intrinsics.areEqual(this.developers, project.developers) && Intrinsics.areEqual(this.url, project.url) && Intrinsics.areEqual(this.year, project.year) && Intrinsics.areEqual(this.licenses, project.licenses) && Intrinsics.areEqual(this.dependency, project.dependency)) {
            return true;
        }
        return false;
    }

    public final String getCopyright() {
        return this.copyright;
    }

    public final String getDependency() {
        return this.dependency;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<String> getDevelopers() {
        return this.developers;
    }

    public final List<License> getLicenses() {
        return this.licenses;
    }

    public final String getProject() {
        return this.project;
    }

    public final String getProjectAndVersion() {
        return this.projectAndVersion;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getYear() {
        return this.year;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7 = this.project.hashCode() * 31;
        String str = this.description;
        int r2 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int r0 = (hashCode7 + hashCode) * 31;
        String str2 = this.version;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        List<String> list = this.developers;
        if (list == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = list.hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        String str3 = this.url;
        if (str3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str3.hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        String str4 = this.year;
        if (str4 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str4.hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        List<License> list2 = this.licenses;
        if (list2 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = list2.hashCode();
        }
        int r06 = (r05 + hashCode6) * 31;
        String str5 = this.dependency;
        if (str5 != null) {
            r2 = str5.hashCode();
        }
        return r06 + r2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Project(project=");
        sb.append(this.project);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", version=");
        sb.append(this.version);
        sb.append(", developers=");
        sb.append(this.developers);
        sb.append(", url=");
        sb.append(this.url);
        sb.append(", year=");
        sb.append(this.year);
        sb.append(", licenses=");
        sb.append(this.licenses);
        sb.append(", dependency=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.dependency, ')');
    }

    public Project(String project, String str, String str2, List<String> list, String str3, String str4, List<License> list2, String str5) {
        Intrinsics.checkNotNullParameter(project, "project");
        this.project = project;
        this.description = str;
        this.version = str2;
        this.developers = list;
        this.url = str3;
        this.year = str4;
        this.licenses = list2;
        this.dependency = str5;
        this.copyrightSymbol = "©";
        String joinToString$default = list != null ? CollectionsKt___CollectionsKt.joinToString$default(list, ",", null, null, null, 62) : "";
        this.developersString = joinToString$default;
        str4 = str4 == null ? "20xx" : str4;
        this.formattedYear = str4;
        StringBuilder sb = new StringBuilder();
        sb.append(project);
        sb.append(' ');
        sb.append(str2 == null ? null : str2);
        this.projectAndVersion = sb.toString();
        this.copyright = "Copyright © " + str4 + ' ' + joinToString$default;
    }
}
