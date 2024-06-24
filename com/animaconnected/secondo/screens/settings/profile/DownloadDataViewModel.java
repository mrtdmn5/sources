package com.animaconnected.secondo.screens.settings.profile;

import com.animaconnected.watch.account.AccountApi;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.datetime.Instant;

/* compiled from: ProfileSettingsFragment.kt */
/* loaded from: classes3.dex */
public final class DownloadDataViewModel {
    public static final int $stable = 8;
    private final AccountApi accountApi;
    private final MutableStateFlow<AccountDownloadState> privateState;
    private final StateFlow<AccountDownloadState> state;

    /* compiled from: ProfileSettingsFragment.kt */
    /* loaded from: classes3.dex */
    public static abstract class AccountDownloadState {
        public static final int $stable = 0;

        /* compiled from: ProfileSettingsFragment.kt */
        /* loaded from: classes3.dex */
        public static final class DataAvailable extends AccountDownloadState {
            public static final int $stable = 8;
            private final Instant expirationDate;
            private final String url;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DataAvailable(String str, Instant expirationDate) {
                super(null);
                Intrinsics.checkNotNullParameter(expirationDate, "expirationDate");
                this.url = str;
                this.expirationDate = expirationDate;
            }

            public static /* synthetic */ DataAvailable copy$default(DataAvailable dataAvailable, String str, Instant instant, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    str = dataAvailable.url;
                }
                if ((r3 & 2) != 0) {
                    instant = dataAvailable.expirationDate;
                }
                return dataAvailable.copy(str, instant);
            }

            public final String component1() {
                return this.url;
            }

            public final Instant component2() {
                return this.expirationDate;
            }

            public final DataAvailable copy(String str, Instant expirationDate) {
                Intrinsics.checkNotNullParameter(expirationDate, "expirationDate");
                return new DataAvailable(str, expirationDate);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof DataAvailable)) {
                    return false;
                }
                DataAvailable dataAvailable = (DataAvailable) obj;
                if (Intrinsics.areEqual(this.url, dataAvailable.url) && Intrinsics.areEqual(this.expirationDate, dataAvailable.expirationDate)) {
                    return true;
                }
                return false;
            }

            public final Instant getExpirationDate() {
                return this.expirationDate;
            }

            public final String getUrl() {
                return this.url;
            }

            public int hashCode() {
                int hashCode;
                String str = this.url;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                return this.expirationDate.hashCode() + (hashCode * 31);
            }

            public String toString() {
                return "DataAvailable(url=" + this.url + ", expirationDate=" + this.expirationDate + ')';
            }
        }

        /* compiled from: ProfileSettingsFragment.kt */
        /* loaded from: classes3.dex */
        public static final class Idle extends AccountDownloadState {
            public static final int $stable = 0;
            public static final Idle INSTANCE = new Idle();

            private Idle() {
                super(null);
            }
        }

        /* compiled from: ProfileSettingsFragment.kt */
        /* loaded from: classes3.dex */
        public static final class InProgress extends AccountDownloadState {
            public static final int $stable = 0;
            public static final InProgress INSTANCE = new InProgress();

            private InProgress() {
                super(null);
            }
        }

        /* compiled from: ProfileSettingsFragment.kt */
        /* loaded from: classes3.dex */
        public static final class InitiateDownload extends AccountDownloadState {
            public static final int $stable = 0;
            public static final InitiateDownload INSTANCE = new InitiateDownload();

            private InitiateDownload() {
                super(null);
            }
        }

        /* compiled from: ProfileSettingsFragment.kt */
        /* loaded from: classes3.dex */
        public static final class Unauthorized extends AccountDownloadState {
            public static final int $stable = 0;
            public static final Unauthorized INSTANCE = new Unauthorized();

            private Unauthorized() {
                super(null);
            }
        }

        public /* synthetic */ AccountDownloadState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private AccountDownloadState() {
        }
    }

    public DownloadDataViewModel(AccountApi accountApi) {
        Intrinsics.checkNotNullParameter(accountApi, "accountApi");
        this.accountApi = accountApi;
        StateFlowImpl MutableStateFlow = StateFlowKt.MutableStateFlow(AccountDownloadState.Idle.INSTANCE);
        this.privateState = MutableStateFlow;
        this.state = MutableStateFlow;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object checkStatus(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.profile.DownloadDataViewModel.checkStatus(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final StateFlow<AccountDownloadState> getState() {
        return this.state;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendRequest(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.profile.DownloadDataViewModel.sendRequest(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
