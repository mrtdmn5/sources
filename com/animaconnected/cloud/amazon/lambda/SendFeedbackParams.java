package com.animaconnected.cloud.amazon.lambda;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SendFeedbackParams.kt */
/* loaded from: classes.dex */
public final class SendFeedbackParams {
    private final String action;
    private final Feedback feedback;

    public SendFeedbackParams(Feedback feedback) {
        Intrinsics.checkNotNullParameter(feedback, "feedback");
        this.feedback = feedback;
        this.action = "insert";
    }

    public final Feedback getFeedback() {
        return this.feedback;
    }

    /* compiled from: SendFeedbackParams.kt */
    /* loaded from: classes.dex */
    public static final class Feedback {
        private final String appVersion;
        private final String brand;
        private final String feature;
        private final String platform;
        private final String rating;
        private final String serialNumber;
        private final String text;

        public Feedback(String serialNumber, String appVersion, String brand, String feature, String rating, String text, String platform) {
            Intrinsics.checkNotNullParameter(serialNumber, "serialNumber");
            Intrinsics.checkNotNullParameter(appVersion, "appVersion");
            Intrinsics.checkNotNullParameter(brand, "brand");
            Intrinsics.checkNotNullParameter(feature, "feature");
            Intrinsics.checkNotNullParameter(rating, "rating");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(platform, "platform");
            this.serialNumber = serialNumber;
            this.appVersion = appVersion;
            this.brand = brand;
            this.feature = feature;
            this.rating = rating;
            this.text = text;
            this.platform = platform;
        }

        public static /* synthetic */ Feedback copy$default(Feedback feedback, String str, String str2, String str3, String str4, String str5, String str6, String str7, int r13, Object obj) {
            if ((r13 & 1) != 0) {
                str = feedback.serialNumber;
            }
            if ((r13 & 2) != 0) {
                str2 = feedback.appVersion;
            }
            String str8 = str2;
            if ((r13 & 4) != 0) {
                str3 = feedback.brand;
            }
            String str9 = str3;
            if ((r13 & 8) != 0) {
                str4 = feedback.feature;
            }
            String str10 = str4;
            if ((r13 & 16) != 0) {
                str5 = feedback.rating;
            }
            String str11 = str5;
            if ((r13 & 32) != 0) {
                str6 = feedback.text;
            }
            String str12 = str6;
            if ((r13 & 64) != 0) {
                str7 = feedback.platform;
            }
            return feedback.copy(str, str8, str9, str10, str11, str12, str7);
        }

        public final String component1() {
            return this.serialNumber;
        }

        public final String component2() {
            return this.appVersion;
        }

        public final String component3() {
            return this.brand;
        }

        public final String component4() {
            return this.feature;
        }

        public final String component5() {
            return this.rating;
        }

        public final String component6() {
            return this.text;
        }

        public final String component7() {
            return this.platform;
        }

        public final Feedback copy(String serialNumber, String appVersion, String brand, String feature, String rating, String text, String platform) {
            Intrinsics.checkNotNullParameter(serialNumber, "serialNumber");
            Intrinsics.checkNotNullParameter(appVersion, "appVersion");
            Intrinsics.checkNotNullParameter(brand, "brand");
            Intrinsics.checkNotNullParameter(feature, "feature");
            Intrinsics.checkNotNullParameter(rating, "rating");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(platform, "platform");
            return new Feedback(serialNumber, appVersion, brand, feature, rating, text, platform);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Feedback)) {
                return false;
            }
            Feedback feedback = (Feedback) obj;
            if (Intrinsics.areEqual(this.serialNumber, feedback.serialNumber) && Intrinsics.areEqual(this.appVersion, feedback.appVersion) && Intrinsics.areEqual(this.brand, feedback.brand) && Intrinsics.areEqual(this.feature, feedback.feature) && Intrinsics.areEqual(this.rating, feedback.rating) && Intrinsics.areEqual(this.text, feedback.text) && Intrinsics.areEqual(this.platform, feedback.platform)) {
                return true;
            }
            return false;
        }

        public final String getAppVersion() {
            return this.appVersion;
        }

        public final String getBrand() {
            return this.brand;
        }

        public final String getFeature() {
            return this.feature;
        }

        public final String getPlatform() {
            return this.platform;
        }

        public final String getRating() {
            return this.rating;
        }

        public final String getSerialNumber() {
            return this.serialNumber;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return this.platform.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.text, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.rating, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.feature, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.brand, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.appVersion, this.serialNumber.hashCode() * 31, 31), 31), 31), 31), 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Feedback(serialNumber=");
            sb.append(this.serialNumber);
            sb.append(", appVersion=");
            sb.append(this.appVersion);
            sb.append(", brand=");
            sb.append(this.brand);
            sb.append(", feature=");
            sb.append(this.feature);
            sb.append(", rating=");
            sb.append(this.rating);
            sb.append(", text=");
            sb.append(this.text);
            sb.append(", platform=");
            return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.platform, ')');
        }

        public /* synthetic */ Feedback(String str, String str2, String str3, String str4, String str5, String str6, String str7, int r17, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, str5, str6, (r17 & 64) != 0 ? "android" : str7);
        }
    }
}
