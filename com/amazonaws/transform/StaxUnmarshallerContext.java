package com.amazonaws.transform;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class StaxUnmarshallerContext {
    private int currentEventType;
    private final Map<String, String> headers;
    private Map<String, String> metadata;
    private List<MetadataExpression> metadataExpressions;
    public final Deque<String> stack;
    private String stackString;
    private final XmlPullParser xpp;

    /* loaded from: classes.dex */
    public static class MetadataExpression {
        public String expression;
        public String key;
        public int targetDepth;

        public MetadataExpression(String str, int r2, String str2) {
            this.expression = str;
            this.targetDepth = r2;
            this.key = str2;
        }
    }

    public StaxUnmarshallerContext(XmlPullParser xmlPullParser) {
        this(xmlPullParser, null);
    }

    private void updateContext() {
        String peek;
        int r0 = this.currentEventType;
        if (r0 == 2) {
            String str = this.stackString + "/" + this.xpp.getName();
            this.stackString = str;
            this.stack.push(str);
            return;
        }
        if (r0 == 3) {
            this.stack.pop();
            if (this.stack.isEmpty()) {
                peek = "";
            } else {
                peek = this.stack.peek();
            }
            this.stackString = peek;
        }
    }

    public int getCurrentDepth() {
        return this.stack.size();
    }

    public String getHeader(String str) {
        Map<String, String> map = this.headers;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public Map<String, String> getMetadata() {
        return this.metadata;
    }

    public boolean isStartOfDocument() {
        if (this.currentEventType == 0) {
            return true;
        }
        return false;
    }

    public int nextEvent() throws XmlPullParserException, IOException {
        int next = this.xpp.next();
        this.currentEventType = next;
        if (next == 4) {
            this.currentEventType = this.xpp.next();
        }
        updateContext();
        if (this.currentEventType == 2) {
            Iterator<MetadataExpression> it = this.metadataExpressions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MetadataExpression next2 = it.next();
                if (testExpression(next2.expression, next2.targetDepth)) {
                    this.metadata.put(next2.key, readText());
                    break;
                }
            }
        }
        return this.currentEventType;
    }

    public String readText() throws XmlPullParserException, IOException {
        String nextText = this.xpp.nextText();
        if (this.xpp.getEventType() != 3) {
            this.xpp.next();
        }
        this.currentEventType = this.xpp.getEventType();
        updateContext();
        return nextText;
    }

    public void registerMetadataExpression(String str, int r4, String str2) {
        this.metadataExpressions.add(new MetadataExpression(str, r4, str2));
    }

    public boolean testExpression(String str) {
        return testExpression(str, getCurrentDepth());
    }

    public StaxUnmarshallerContext(XmlPullParser xmlPullParser, Map<String, String> map) {
        this.stack = new LinkedList();
        this.stackString = "";
        this.metadata = new HashMap();
        this.metadataExpressions = new ArrayList();
        this.xpp = xmlPullParser;
        this.headers = map;
    }

    public boolean testExpression(String str, int r7) {
        if (InstructionFileId.DOT.equals(str)) {
            return true;
        }
        int r2 = -1;
        while (true) {
            r2 = str.indexOf("/", r2 + 1);
            if (r2 <= -1) {
                break;
            }
            if (str.charAt(r2 + 1) != '@') {
                r7++;
            }
        }
        return getCurrentDepth() == r7 && this.stackString.endsWith("/".concat(str));
    }
}
