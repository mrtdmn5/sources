package com.animaconnected.secondo.screens.watchupdate.updateinfo;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import com.animaconnected.watch.device.FirmwareUpdate;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Update.kt */
/* loaded from: classes3.dex */
public final class Update {
    public static final int $stable = 0;
    public static final String LATEST_LIVE_DFU15_FW = "20180101";
    private final int updateAsStringRes;
    private final int updatesAsLayoutRes;
    private final String versionPrefix;
    public static final Companion Companion = new Companion(null);
    private static final Update GENERAL_UPDATE = new Update(null, R.layout.update_general, R.string.watch_update_general_changelog_settings);
    public static final String LATEST_LIVE_DFU8_FW = "20180515";
    private static final List<Update> DFU_UPDATES = Collections.unmodifiableList(CollectionsKt__CollectionsKt.listOf((Object[]) new Update[]{new Update(LATEST_LIVE_DFU8_FW, R.layout.update_20180515_20180911, R.string.watch_update_20180515_20180911_changelog_settings), new Update("20171207", R.layout.update_20171207, R.string.watch_update_20171207_changelog_settings)}));
    public static final String LATEST_LIVE_FOTA_FW = "20180911";
    private static final List<Update> FOTA_UPDATES = Collections.unmodifiableList(CollectionsKt__CollectionsKt.listOf(new Update(LATEST_LIVE_FOTA_FW, R.layout.update_20180515_20180911, R.string.watch_update_20180515_20180911_changelog_settings)));

    /* compiled from: Update.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* compiled from: Update.kt */
        /* loaded from: classes3.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] r0 = new int[FirmwareUpdate.values().length];
                try {
                    r0[FirmwareUpdate.DFU.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    r0[FirmwareUpdate.DFU15.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    r0[FirmwareUpdate.FOTA.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = r0;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Update getGENERAL_UPDATE() {
            return Update.GENERAL_UPDATE;
        }

        public final List<Update> getUpdates(FirmwareUpdate firmwareUpdate) {
            int r2;
            if (firmwareUpdate == null) {
                r2 = -1;
            } else {
                r2 = WhenMappings.$EnumSwitchMapping$0[firmwareUpdate.ordinal()];
            }
            if (r2 == 1) {
                return Update.DFU_UPDATES;
            }
            if (r2 != 2) {
                if (r2 == 3) {
                    return Update.FOTA_UPDATES;
                }
                return null;
            }
            return Collections.unmodifiableList(new ArrayList());
        }

        private Companion() {
        }
    }

    public Update(String str, int r2, int r3) {
        this.versionPrefix = str;
        this.updatesAsLayoutRes = r2;
        this.updateAsStringRes = r3;
    }

    private final String component1() {
        return this.versionPrefix;
    }

    public static /* synthetic */ Update copy$default(Update update, String str, int r2, int r3, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = update.versionPrefix;
        }
        if ((r4 & 2) != 0) {
            r2 = update.updatesAsLayoutRes;
        }
        if ((r4 & 4) != 0) {
            r3 = update.updateAsStringRes;
        }
        return update.copy(str, r2, r3);
    }

    public final int component2() {
        return this.updatesAsLayoutRes;
    }

    public final int component3() {
        return this.updateAsStringRes;
    }

    public final Update copy(String str, int r3, int r4) {
        return new Update(str, r3, r4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Update)) {
            return false;
        }
        Update update = (Update) obj;
        if (Intrinsics.areEqual(this.versionPrefix, update.versionPrefix) && this.updatesAsLayoutRes == update.updatesAsLayoutRes && this.updateAsStringRes == update.updateAsStringRes) {
            return true;
        }
        return false;
    }

    public final Date getDate() {
        return UpdateHelper.firmwareRevisionToDate(this.versionPrefix);
    }

    public final int getUpdateAsStringRes() {
        return this.updateAsStringRes;
    }

    public final int getUpdatesAsLayoutRes() {
        return this.updatesAsLayoutRes;
    }

    public int hashCode() {
        int hashCode;
        String str = this.versionPrefix;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return Integer.hashCode(this.updateAsStringRes) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.updatesAsLayoutRes, hashCode * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Update(versionPrefix=");
        sb.append(this.versionPrefix);
        sb.append(", updatesAsLayoutRes=");
        sb.append(this.updatesAsLayoutRes);
        sb.append(", updateAsStringRes=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.updateAsStringRes, ')');
    }
}
