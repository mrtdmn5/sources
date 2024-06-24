package androidx.work.impl.constraints;

/* loaded from: classes.dex */
public final class NetworkState {
    public final boolean mIsConnected;
    public final boolean mIsMetered;
    public final boolean mIsNotRoaming;
    public final boolean mIsValidated;

    public NetworkState(boolean isConnected, boolean isValidated, boolean isMetered, boolean isNotRoaming) {
        this.mIsConnected = isConnected;
        this.mIsValidated = isValidated;
        this.mIsMetered = isMetered;
        this.mIsNotRoaming = isNotRoaming;
    }

    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NetworkState)) {
            return false;
        }
        NetworkState networkState = (NetworkState) o;
        if (this.mIsConnected == networkState.mIsConnected && this.mIsValidated == networkState.mIsValidated && this.mIsMetered == networkState.mIsMetered && this.mIsNotRoaming == networkState.mIsNotRoaming) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [boolean, int] */
    public final int hashCode() {
        boolean z = this.mIsValidated;
        ?? r1 = this.mIsConnected;
        int r12 = r1;
        if (z) {
            r12 = r1 + 16;
        }
        int r13 = r12;
        if (this.mIsMetered) {
            r13 = r12 + 256;
        }
        if (this.mIsNotRoaming) {
            return r13 + 4096;
        }
        return r13;
    }

    public final String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", Boolean.valueOf(this.mIsConnected), Boolean.valueOf(this.mIsValidated), Boolean.valueOf(this.mIsMetered), Boolean.valueOf(this.mIsNotRoaming));
    }
}
