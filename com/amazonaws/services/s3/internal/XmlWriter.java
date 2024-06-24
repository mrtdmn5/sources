package com.amazonaws.services.s3.internal;

import com.amazonaws.util.StringUtils;
import com.amplifyframework.core.model.ModelIdentifier;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class XmlWriter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    List<String> tags = new ArrayList();
    StringBuilder sb = new StringBuilder();

    private void appendEscapedString(String str, StringBuilder sb) {
        String str2;
        if (str == null) {
            str = "";
        }
        int length = str.length();
        int r1 = 0;
        int r2 = 0;
        while (r1 < length) {
            char charAt = str.charAt(r1);
            if (charAt != '\t') {
                if (charAt != '\n') {
                    if (charAt != '\r') {
                        if (charAt != '\"') {
                            if (charAt != '&') {
                                if (charAt != '<') {
                                    if (charAt != '>') {
                                        str2 = null;
                                    } else {
                                        str2 = "&gt;";
                                    }
                                } else {
                                    str2 = "&lt;";
                                }
                            } else {
                                str2 = "&amp;";
                            }
                        } else {
                            str2 = "&quot;";
                        }
                    } else {
                        str2 = "&#13;";
                    }
                } else {
                    str2 = "&#10;";
                }
            } else {
                str2 = "&#9;";
            }
            if (str2 != null) {
                if (r2 < r1) {
                    sb.append((CharSequence) str, r2, r1);
                }
                this.sb.append(str2);
                r2 = r1 + 1;
            }
            r1++;
        }
        if (r2 < r1) {
            this.sb.append((CharSequence) str, r2, r1);
        }
    }

    private void writeAttr(String str, String str2) {
        StringBuilder sb = this.sb;
        sb.append(' ');
        sb.append(str);
        sb.append("=\"");
        appendEscapedString(str2, this.sb);
        this.sb.append(ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR);
    }

    public XmlWriter end() {
        String remove = this.tags.remove(r0.size() - 1);
        StringBuilder sb = this.sb;
        sb.append("</");
        sb.append(remove);
        sb.append(">");
        return this;
    }

    public byte[] getBytes() {
        return toString().getBytes(StringUtils.UTF8);
    }

    public XmlWriter start(String str) {
        StringBuilder sb = this.sb;
        sb.append("<");
        sb.append(str);
        sb.append(">");
        this.tags.add(str);
        return this;
    }

    public String toString() {
        return this.sb.toString();
    }

    public XmlWriter value(String str) {
        appendEscapedString(str, this.sb);
        return this;
    }

    public XmlWriter start(String str, String str2, String str3) {
        StringBuilder sb = this.sb;
        sb.append("<");
        sb.append(str);
        writeAttr(str2, str3);
        this.sb.append(">");
        this.tags.add(str);
        return this;
    }

    public XmlWriter start(String str, String[] strArr, String[] strArr2) {
        StringBuilder sb = this.sb;
        sb.append("<");
        sb.append(str);
        for (int r0 = 0; r0 < Math.min(strArr.length, strArr2.length); r0++) {
            writeAttr(strArr[r0], strArr2[r0]);
        }
        this.sb.append(">");
        this.tags.add(str);
        return this;
    }
}
