package com.amazonaws.util;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.amazonaws.AmazonClientException;
import com.amplifyframework.core.model.ModelIdentifier;
import com.animaconnected.secondo.notification.model.Contact;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.Stack;

/* loaded from: classes.dex */
public class XMLWriter {
    private static final String PROLOG = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    private Stack<String> elementStack;
    private boolean rootElement;
    private final Writer writer;
    private final String xmlns;

    public XMLWriter(Writer writer) {
        this(writer, null);
    }

    private void append(String str) {
        try {
            this.writer.append((CharSequence) str);
        } catch (IOException e) {
            throw new AmazonClientException("Unable to write XML document", e);
        }
    }

    private String escapeXMLEntities(String str) {
        if (str.contains(Contact.PHONE_NUMBERS_DELIMITER)) {
            str = str.replace("&quot;", ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR).replace("&apos;", "'").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", Contact.PHONE_NUMBERS_DELIMITER);
        }
        return str.replace(Contact.PHONE_NUMBERS_DELIMITER, "&amp;").replace(ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR, "&quot;").replace("'", "&apos;").replace("<", "&lt;").replace(">", "&gt;");
    }

    public XMLWriter endElement() {
        append(zzav$$ExternalSyntheticOutline0.m("</", this.elementStack.pop(), ">"));
        return this;
    }

    public XMLWriter startElement(String str) {
        append(ConstraintSet$$ExternalSyntheticOutline0.m("<", str));
        if (this.rootElement && this.xmlns != null) {
            append(ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(" xmlns=\""), this.xmlns, ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR));
            this.rootElement = false;
        }
        append(">");
        this.elementStack.push(str);
        return this;
    }

    public XMLWriter value(String str) {
        append(escapeXMLEntities(str));
        return this;
    }

    public XMLWriter(Writer writer, String str) {
        this.elementStack = new Stack<>();
        this.rootElement = true;
        this.writer = writer;
        this.xmlns = str;
        append(PROLOG);
    }

    public XMLWriter value(Date date) {
        append(escapeXMLEntities(StringUtils.fromDate(date)));
        return this;
    }

    public XMLWriter value(Object obj) {
        append(escapeXMLEntities(obj.toString()));
        return this;
    }
}
