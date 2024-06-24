package aws.sdk.kotlin.runtime.config.profile;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AwsConfigParser.kt */
/* loaded from: classes.dex */
public abstract class Token {

    /* compiled from: AwsConfigParser.kt */
    /* loaded from: classes.dex */
    public static final class Profile extends Token {
        public final boolean isValidForm;
        public final String name;
        public final boolean profilePrefix;

        public Profile(boolean z, String name, boolean z2) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.profilePrefix = z;
            this.name = name;
            this.isValidForm = z2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Profile)) {
                return false;
            }
            Profile profile = (Profile) obj;
            if (this.profilePrefix == profile.profilePrefix && Intrinsics.areEqual(this.name, profile.name) && this.isValidForm == profile.isValidForm) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int hashCode() {
            int r0 = 1;
            boolean z = this.profilePrefix;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            int m = TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.name, r1 * 31, 31);
            boolean z2 = this.isValidForm;
            if (!z2) {
                r0 = z2 ? 1 : 0;
            }
            return m + r0;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Profile(profilePrefix=");
            sb.append(this.profilePrefix);
            sb.append(", name=");
            sb.append(this.name);
            sb.append(", isValidForm=");
            return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isValidForm, ')');
        }
    }

    /* compiled from: AwsConfigParser.kt */
    /* loaded from: classes.dex */
    public static final class Property extends Token {
        public final String key;
        public final String value;

        public Property(String str, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.key = str;
            this.value = value;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Property)) {
                return false;
            }
            Property property = (Property) obj;
            if (Intrinsics.areEqual(this.key, property.key) && Intrinsics.areEqual(this.value, property.value)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.value.hashCode() + (this.key.hashCode() * 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Property(key=");
            sb.append(this.key);
            sb.append(", value=");
            return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.value, ')');
        }
    }

    /* compiled from: AwsConfigParser.kt */
    /* loaded from: classes.dex */
    public static final class Unmatched extends Token {
        public final FileLine line;

        public Unmatched(FileLine line) {
            Intrinsics.checkNotNullParameter(line, "line");
            this.line = line;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Unmatched) && Intrinsics.areEqual(this.line, ((Unmatched) obj).line)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.line.hashCode();
        }

        public final String toString() {
            return "Unmatched(line=" + this.line + ')';
        }
    }
}
