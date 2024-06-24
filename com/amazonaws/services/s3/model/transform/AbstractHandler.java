package com.amazonaws.services.s3.model.transform;

import java.util.Iterator;
import java.util.LinkedList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes.dex */
abstract class AbstractHandler extends DefaultHandler {
    private final StringBuilder text = new StringBuilder();
    private final LinkedList<String> context = new LinkedList<>();

    public final boolean atTopLevel() {
        return this.context.isEmpty();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void characters(char[] cArr, int r3, int r4) {
        this.text.append(cArr, r3, r4);
    }

    public abstract void doEndElement(String str, String str2, String str3);

    public abstract void doStartElement(String str, String str2, String str3, Attributes attributes);

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void endElement(String str, String str2, String str3) {
        this.context.removeLast();
        doEndElement(str, str2, str3);
    }

    public final String getText() {
        return this.text.toString();
    }

    public final boolean in(String... strArr) {
        if (strArr.length != this.context.size()) {
            return false;
        }
        Iterator<String> it = this.context.iterator();
        int r1 = 0;
        while (it.hasNext()) {
            String next = it.next();
            String str = strArr[r1];
            if (!str.equals("*") && !str.equals(next)) {
                return false;
            }
            r1++;
        }
        return true;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void startElement(String str, String str2, String str3, Attributes attributes) {
        this.text.setLength(0);
        doStartElement(str, str2, str3, attributes);
        this.context.add(str2);
    }
}
