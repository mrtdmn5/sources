package com.amazonaws.util;

import com.amazonaws.internal.SdkFilterInputStream;
import com.amplifyframework.core.model.ModelIdentifier;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
class NamespaceRemovingInputStream extends SdkFilterInputStream {
    private static final int BUFFER_SIZE = 200;
    private boolean hasRemovedNamespace;
    private final byte[] lookAheadData;

    /* loaded from: classes.dex */
    public static final class StringPrefixSlicer {
        private String s;

        public StringPrefixSlicer(String str) {
            this.s = str;
        }

        public String getString() {
            return this.s;
        }

        public boolean removePrefix(String str) {
            if (!this.s.startsWith(str)) {
                return false;
            }
            this.s = this.s.substring(str.length());
            return true;
        }

        public boolean removePrefixEndingWith(String str) {
            int indexOf = this.s.indexOf(str);
            if (indexOf < 0) {
                return false;
            }
            this.s = this.s.substring(str.length() + indexOf);
            return true;
        }

        public boolean removeRepeatingPrefix(String str) {
            if (!this.s.startsWith(str)) {
                return false;
            }
            while (this.s.startsWith(str)) {
                this.s = this.s.substring(str.length());
            }
            return true;
        }
    }

    public NamespaceRemovingInputStream(InputStream inputStream) {
        super(new BufferedInputStream(inputStream));
        this.lookAheadData = new byte[200];
        this.hasRemovedNamespace = false;
    }

    private int matchXmlNamespaceAttribute(String str) {
        StringPrefixSlicer stringPrefixSlicer = new StringPrefixSlicer(str);
        if (!stringPrefixSlicer.removePrefix("xmlns")) {
            return -1;
        }
        stringPrefixSlicer.removeRepeatingPrefix(" ");
        if (!stringPrefixSlicer.removePrefix("=")) {
            return -1;
        }
        stringPrefixSlicer.removeRepeatingPrefix(" ");
        if (!stringPrefixSlicer.removePrefix(ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR) || !stringPrefixSlicer.removePrefixEndingWith(ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR)) {
            return -1;
        }
        return str.length() - stringPrefixSlicer.getString().length();
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        abortIfNeeded();
        int read = ((FilterInputStream) this).in.read();
        if (read != 120 || this.hasRemovedNamespace) {
            return read;
        }
        this.lookAheadData[0] = (byte) read;
        ((FilterInputStream) this).in.mark(this.lookAheadData.length);
        InputStream inputStream = ((FilterInputStream) this).in;
        byte[] bArr = this.lookAheadData;
        int read2 = inputStream.read(bArr, 1, bArr.length - 1);
        ((FilterInputStream) this).in.reset();
        int matchXmlNamespaceAttribute = matchXmlNamespaceAttribute(new String(this.lookAheadData, 0, read2 + 1, StringUtils.UTF8));
        if (matchXmlNamespaceAttribute <= 0) {
            return read;
        }
        for (int r3 = 0; r3 < matchXmlNamespaceAttribute - 1; r3++) {
            ((FilterInputStream) this).in.read();
        }
        int read3 = ((FilterInputStream) this).in.read();
        this.hasRemovedNamespace = true;
        return read3;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int r5, int r6) throws IOException {
        for (int r0 = 0; r0 < r6; r0++) {
            int read = read();
            if (read == -1) {
                if (r0 == 0) {
                    return -1;
                }
                return r0;
            }
            bArr[r0 + r5] = (byte) read;
        }
        return r6;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}
