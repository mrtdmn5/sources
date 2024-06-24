package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes3.dex */
public final class TextFormatEscaper {
    public static String escapeBytes(ByteString byteString) {
        StringBuilder sb = new StringBuilder(byteString.size());
        for (int r1 = 0; r1 < byteString.size(); r1++) {
            byte byteAt = byteString.byteAt(r1);
            if (byteAt != 34) {
                if (byteAt != 39) {
                    if (byteAt != 92) {
                        switch (byteAt) {
                            case 7:
                                sb.append("\\a");
                                break;
                            case 8:
                                sb.append("\\b");
                                break;
                            case 9:
                                sb.append("\\t");
                                break;
                            case 10:
                                sb.append("\\n");
                                break;
                            case 11:
                                sb.append("\\v");
                                break;
                            case 12:
                                sb.append("\\f");
                                break;
                            case 13:
                                sb.append("\\r");
                                break;
                            default:
                                if (byteAt >= 32 && byteAt <= 126) {
                                    sb.append((char) byteAt);
                                    break;
                                } else {
                                    sb.append('\\');
                                    sb.append((char) (((byteAt >>> 6) & 3) + 48));
                                    sb.append((char) (((byteAt >>> 3) & 7) + 48));
                                    sb.append((char) ((byteAt & 7) + 48));
                                    break;
                                }
                                break;
                        }
                    } else {
                        sb.append("\\\\");
                    }
                } else {
                    sb.append("\\'");
                }
            } else {
                sb.append("\\\"");
            }
        }
        return sb.toString();
    }
}
