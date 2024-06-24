package com.google.firebase.platforminfo;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;

/* loaded from: classes3.dex */
public final class AutoValue_LibraryVersion extends LibraryVersion {
    public final String libraryName;
    public final String version;

    public AutoValue_LibraryVersion(String str, String str2) {
        if (str != null) {
            this.libraryName = str;
            if (str2 != null) {
                this.version = str2;
                return;
            }
            throw new NullPointerException("Null version");
        }
        throw new NullPointerException("Null libraryName");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LibraryVersion)) {
            return false;
        }
        LibraryVersion libraryVersion = (LibraryVersion) obj;
        if (this.libraryName.equals(libraryVersion.getLibraryName()) && this.version.equals(libraryVersion.getVersion())) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersion
    public final String getLibraryName() {
        return this.libraryName;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersion
    public final String getVersion() {
        return this.version;
    }

    public final int hashCode() {
        return ((this.libraryName.hashCode() ^ 1000003) * 1000003) ^ this.version.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LibraryVersion{libraryName=");
        sb.append(this.libraryName);
        sb.append(", version=");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.version, "}");
    }
}
