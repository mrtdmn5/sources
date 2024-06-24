package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Base64;
import android.util.Xml;
import androidx.core.R$styleable;
import androidx.core.provider.FontRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class FontResourcesParserCompat {

    /* loaded from: classes.dex */
    public static class Api21Impl {
        public static int getType(TypedArray typedArray, int r1) {
            return typedArray.getType(r1);
        }
    }

    /* loaded from: classes.dex */
    public interface FamilyResourceEntry {
    }

    /* loaded from: classes.dex */
    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {
        public final FontFileResourceEntry[] mEntries;

        public FontFamilyFilesResourceEntry(FontFileResourceEntry[] fontFileResourceEntryArr) {
            this.mEntries = fontFileResourceEntryArr;
        }
    }

    /* loaded from: classes.dex */
    public static final class FontFileResourceEntry {
        public final String mFileName;
        public final boolean mItalic;
        public final int mResourceId;
        public final int mTtcIndex;
        public final String mVariationSettings;
        public final int mWeight;

        public FontFileResourceEntry(int r1, int r2, int r3, String str, String str2, boolean z) {
            this.mFileName = str;
            this.mWeight = r1;
            this.mItalic = z;
            this.mVariationSettings = str2;
            this.mTtcIndex = r2;
            this.mResourceId = r3;
        }
    }

    /* loaded from: classes.dex */
    public static final class ProviderResourceEntry implements FamilyResourceEntry {
        public final FontRequest mRequest;
        public final int mStrategy;
        public final String mSystemFontFamilyName;
        public final int mTimeoutMs;

        public ProviderResourceEntry(FontRequest fontRequest, int r2, int r3, String str) {
            this.mRequest = fontRequest;
            this.mStrategy = r2;
            this.mTimeoutMs = r3;
            this.mSystemFontFamilyName = str;
        }
    }

    public static FamilyResourceEntry parse(XmlResourceParser xmlResourceParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        int r8;
        boolean z;
        int r82;
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            xmlResourceParser.require(2, null, "font-family");
            if (xmlResourceParser.getName().equals("font-family")) {
                TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.FontFamily);
                String string = obtainAttributes.getString(0);
                String string2 = obtainAttributes.getString(4);
                String string3 = obtainAttributes.getString(5);
                int resourceId = obtainAttributes.getResourceId(1, 0);
                int integer = obtainAttributes.getInteger(2, 1);
                int integer2 = obtainAttributes.getInteger(3, 500);
                String string4 = obtainAttributes.getString(6);
                obtainAttributes.recycle();
                if (string != null && string2 != null && string3 != null) {
                    while (xmlResourceParser.next() != 3) {
                        skip(xmlResourceParser);
                    }
                    return new ProviderResourceEntry(new FontRequest(string, string2, string3, readCerts(resources, resourceId)), integer, integer2, string4);
                }
                ArrayList arrayList = new ArrayList();
                while (xmlResourceParser.next() != 3) {
                    if (xmlResourceParser.getEventType() == 2) {
                        if (xmlResourceParser.getName().equals("font")) {
                            TypedArray obtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.FontFamilyFont);
                            int r83 = 8;
                            if (!obtainAttributes2.hasValue(8)) {
                                r83 = 1;
                            }
                            int r17 = obtainAttributes2.getInt(r83, 400);
                            if (obtainAttributes2.hasValue(6)) {
                                r8 = 6;
                            } else {
                                r8 = 2;
                            }
                            if (1 == obtainAttributes2.getInt(r8, 0)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            int r84 = 9;
                            if (!obtainAttributes2.hasValue(9)) {
                                r84 = 3;
                            }
                            int r9 = 7;
                            if (!obtainAttributes2.hasValue(7)) {
                                r9 = 4;
                            }
                            String string5 = obtainAttributes2.getString(r9);
                            int r18 = obtainAttributes2.getInt(r84, 0);
                            if (obtainAttributes2.hasValue(5)) {
                                r82 = 5;
                            } else {
                                r82 = 0;
                            }
                            int resourceId2 = obtainAttributes2.getResourceId(r82, 0);
                            String string6 = obtainAttributes2.getString(r82);
                            obtainAttributes2.recycle();
                            while (xmlResourceParser.next() != 3) {
                                skip(xmlResourceParser);
                            }
                            arrayList.add(new FontFileResourceEntry(r17, r18, resourceId2, string6, string5, z));
                        } else {
                            skip(xmlResourceParser);
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) arrayList.toArray(new FontFileResourceEntry[0]));
                }
            } else {
                skip(xmlResourceParser);
            }
            return null;
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> readCerts(Resources resources, int r9) {
        if (r9 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(r9);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (Api21Impl.getType(obtainTypedArray, 0) == 1) {
                for (int r92 = 0; r92 < obtainTypedArray.length(); r92++) {
                    int resourceId = obtainTypedArray.getResourceId(r92, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArray) {
                            arrayList2.add(Base64.decode(str, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(r9);
                ArrayList arrayList3 = new ArrayList();
                for (String str2 : stringArray2) {
                    arrayList3.add(Base64.decode(str2, 0));
                }
                arrayList.add(arrayList3);
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    public static void skip(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        int r0 = 1;
        while (r0 > 0) {
            int next = xmlResourceParser.next();
            if (next != 2) {
                if (next == 3) {
                    r0--;
                }
            } else {
                r0++;
            }
        }
    }
}
