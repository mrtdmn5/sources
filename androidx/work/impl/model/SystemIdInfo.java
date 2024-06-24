package androidx.work.impl.model;

/* loaded from: classes.dex */
public final class SystemIdInfo {
    public final int systemId;
    public final String workSpecId;

    public SystemIdInfo(String workSpecId, int systemId) {
        this.workSpecId = workSpecId;
        this.systemId = systemId;
    }

    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SystemIdInfo)) {
            return false;
        }
        SystemIdInfo systemIdInfo = (SystemIdInfo) o;
        if (this.systemId != systemIdInfo.systemId) {
            return false;
        }
        return this.workSpecId.equals(systemIdInfo.workSpecId);
    }

    public final int hashCode() {
        return (this.workSpecId.hashCode() * 31) + this.systemId;
    }
}
