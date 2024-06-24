package androidx.media;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import java.util.Arrays;

/* loaded from: classes.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {
    public int mUsage = 0;
    public int mContentType = 0;
    public int mFlags = 0;
    public int mLegacyStream = -1;

    public final boolean equals(Object obj) {
        int r9;
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.mContentType != audioAttributesImplBase.mContentType) {
            return false;
        }
        int r0 = this.mFlags;
        int r2 = audioAttributesImplBase.mFlags;
        int r3 = audioAttributesImplBase.mLegacyStream;
        if (r3 != -1) {
            r9 = r3;
        } else {
            int r5 = audioAttributesImplBase.mUsage;
            int r8 = AudioAttributesCompat.$r8$clinit;
            if ((r2 & 1) == 1) {
                r9 = 7;
            } else {
                r9 = 4;
                if ((r2 & 4) == 4) {
                    r9 = 6;
                } else {
                    switch (r5) {
                        case 2:
                            r9 = 0;
                            break;
                        case 3:
                            r9 = 8;
                            break;
                        case 4:
                            break;
                        case 5:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                            r9 = 5;
                            break;
                        case 6:
                            r9 = 2;
                            break;
                        case 11:
                            r9 = 10;
                            break;
                        case 12:
                        default:
                            r9 = 3;
                            break;
                        case 13:
                            r9 = 1;
                            break;
                    }
                }
            }
        }
        if (r9 == 6) {
            r2 |= 4;
        } else if (r9 == 7) {
            r2 |= 1;
        }
        if (r0 != (r2 & 273) || this.mUsage != audioAttributesImplBase.mUsage || this.mLegacyStream != r3) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mContentType), Integer.valueOf(this.mFlags), Integer.valueOf(this.mUsage), Integer.valueOf(this.mLegacyStream)});
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.mLegacyStream != -1) {
            sb.append(" stream=");
            sb.append(this.mLegacyStream);
            sb.append(" derived");
        }
        sb.append(" usage=");
        int r1 = this.mUsage;
        int r2 = AudioAttributesCompat.$r8$clinit;
        switch (r1) {
            case 0:
                str = "USAGE_UNKNOWN";
                break;
            case 1:
                str = "USAGE_MEDIA";
                break;
            case 2:
                str = "USAGE_VOICE_COMMUNICATION";
                break;
            case 3:
                str = "USAGE_VOICE_COMMUNICATION_SIGNALLING";
                break;
            case 4:
                str = "USAGE_ALARM";
                break;
            case 5:
                str = "USAGE_NOTIFICATION";
                break;
            case 6:
                str = "USAGE_NOTIFICATION_RINGTONE";
                break;
            case 7:
                str = "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
                break;
            case 8:
                str = "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
                break;
            case 9:
                str = "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
                break;
            case 10:
                str = "USAGE_NOTIFICATION_EVENT";
                break;
            case 11:
                str = "USAGE_ASSISTANCE_ACCESSIBILITY";
                break;
            case 12:
                str = "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
                break;
            case 13:
                str = "USAGE_ASSISTANCE_SONIFICATION";
                break;
            case 14:
                str = "USAGE_GAME";
                break;
            case 15:
            default:
                str = SubMenuBuilder$$ExternalSyntheticOutline0.m("unknown usage ", r1);
                break;
            case 16:
                str = "USAGE_ASSISTANT";
                break;
        }
        sb.append(str);
        sb.append(" content=");
        sb.append(this.mContentType);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.mFlags).toUpperCase());
        return sb.toString();
    }
}
