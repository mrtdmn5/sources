package com.amazonaws.services.s3.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.regions.ServiceAbbreviations;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amazonaws.util.StringUtils;
import com.amplifyframework.core.model.ModelIdentifier;
import com.animaconnected.watch.device.Command;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes.dex */
public final class Mimetypes {
    public static final String MIMETYPE_GZIP = "application/x-gzip";
    public static final String MIMETYPE_HTML = "text/html";
    public static final String MIMETYPE_OCTET_STREAM = "application/octet-stream";
    public static final String MIMETYPE_XML = "application/xml";
    private static final Log log = LogFactory.getLog((Class<?>) Mimetypes.class);
    private static Mimetypes mimetypes = null;
    private final HashMap<String, String> extensionToMimetypeMap;

    public Mimetypes() {
        HashMap<String, String> hashMap = new HashMap<>();
        this.extensionToMimetypeMap = hashMap;
        hashMap.put("3gp", "video/3gpp");
        hashMap.put("ai", "application/postscript");
        hashMap.put("aif", "audio/x-aiff");
        hashMap.put("aifc", "audio/x-aiff");
        hashMap.put("aiff", "audio/x-aiff");
        hashMap.put("asc", "text/plain");
        hashMap.put("atom", "application/atom+xml");
        hashMap.put("au", "audio/basic");
        hashMap.put("avi", "video/x-msvideo");
        hashMap.put("bcpio", "application/x-bcpio");
        hashMap.put("bin", "application/octet-stream");
        hashMap.put("bmp", "image/bmp");
        hashMap.put("cdf", "application/x-netcdf");
        hashMap.put("cgm", "image/cgm");
        hashMap.put("class", "application/octet-stream");
        hashMap.put("cpio", "application/x-cpio");
        hashMap.put("cpt", "application/mac-compactpro");
        hashMap.put("csh", "application/x-csh");
        hashMap.put("css", "text/css");
        hashMap.put("dcr", "application/x-director");
        hashMap.put("dif", "video/x-dv");
        hashMap.put("dir", "application/x-director");
        hashMap.put("djv", "image/vnd.djvu");
        hashMap.put("djvu", "image/vnd.djvu");
        hashMap.put("dll", "application/octet-stream");
        hashMap.put("dmg", "application/octet-stream");
        hashMap.put("dms", "application/octet-stream");
        hashMap.put("doc", "application/msword");
        hashMap.put("dtd", "application/xml-dtd");
        hashMap.put("dv", "video/x-dv");
        hashMap.put("dvi", "application/x-dvi");
        hashMap.put("dxr", "application/x-director");
        hashMap.put("eps", "application/postscript");
        hashMap.put("etx", "text/x-setext");
        hashMap.put("exe", "application/octet-stream");
        hashMap.put("ez", "application/andrew-inset");
        hashMap.put("flv", "video/x-flv");
        hashMap.put("gif", "image/gif");
        hashMap.put("gram", "application/srgs");
        hashMap.put("grxml", "application/srgs+xml");
        hashMap.put("gtar", "application/x-gtar");
        hashMap.put("gz", MIMETYPE_GZIP);
        hashMap.put("hdf", "application/x-hdf");
        hashMap.put("hqx", "application/mac-binhex40");
        hashMap.put("htm", MIMETYPE_HTML);
        hashMap.put("html", MIMETYPE_HTML);
        hashMap.put("ice", "x-conference/x-cooltalk");
        hashMap.put("ico", "image/x-icon");
        hashMap.put("ics", "text/calendar");
        hashMap.put("ief", "image/ief");
        hashMap.put("ifb", "text/calendar");
        hashMap.put("iges", "model/iges");
        hashMap.put("igs", "model/iges");
        hashMap.put("jnlp", "application/x-java-jnlp-file");
        hashMap.put("jp2", "image/jp2");
        hashMap.put("jpe", "image/jpeg");
        hashMap.put("jpeg", "image/jpeg");
        hashMap.put("jpg", "image/jpeg");
        hashMap.put("js", "application/x-javascript");
        hashMap.put("kar", "audio/midi");
        hashMap.put("latex", "application/x-latex");
        hashMap.put("lha", "application/octet-stream");
        hashMap.put("lzh", "application/octet-stream");
        hashMap.put("m3u", "audio/x-mpegurl");
        hashMap.put("m4a", "audio/mp4a-latm");
        hashMap.put("m4p", "audio/mp4a-latm");
        hashMap.put("m4u", "video/vnd.mpegurl");
        hashMap.put("m4v", "video/x-m4v");
        hashMap.put("mac", "image/x-macpaint");
        hashMap.put("man", "application/x-troff-man");
        hashMap.put("mathml", "application/mathml+xml");
        hashMap.put("me", "application/x-troff-me");
        hashMap.put("mesh", "model/mesh");
        hashMap.put("mid", "audio/midi");
        hashMap.put("midi", "audio/midi");
        hashMap.put("mif", "application/vnd.mif");
        hashMap.put("mov", "video/quicktime");
        hashMap.put("movie", "video/x-sgi-movie");
        hashMap.put("mp2", "audio/mpeg");
        hashMap.put("mp3", "audio/mpeg");
        hashMap.put("mp4", "video/mp4");
        hashMap.put("mpe", "video/mpeg");
        hashMap.put("mpeg", "video/mpeg");
        hashMap.put("mpg", "video/mpeg");
        hashMap.put("mpga", "audio/mpeg");
        hashMap.put("ms", "application/x-troff-ms");
        hashMap.put("msh", "model/mesh");
        hashMap.put("mxu", "video/vnd.mpegurl");
        hashMap.put("nc", "application/x-netcdf");
        hashMap.put("oda", "application/oda");
        hashMap.put("ogg", "application/ogg");
        hashMap.put("ogv", "video/ogv");
        hashMap.put("pbm", "image/x-portable-bitmap");
        hashMap.put("pct", "image/pict");
        hashMap.put("pdb", "chemical/x-pdb");
        hashMap.put("pdf", "application/pdf");
        hashMap.put("pgm", "image/x-portable-graymap");
        hashMap.put("pgn", "application/x-chess-pgn");
        hashMap.put("pic", "image/pict");
        hashMap.put("pict", "image/pict");
        hashMap.put("png", "image/png");
        hashMap.put("pnm", "image/x-portable-anymap");
        hashMap.put("pnt", "image/x-macpaint");
        hashMap.put("pntg", "image/x-macpaint");
        hashMap.put("ppm", "image/x-portable-pixmap");
        hashMap.put("ppt", "application/vnd.ms-powerpoint");
        hashMap.put("ps", "application/postscript");
        hashMap.put("qt", "video/quicktime");
        hashMap.put("qti", "image/x-quicktime");
        hashMap.put("qtif", "image/x-quicktime");
        hashMap.put("ra", "audio/x-pn-realaudio");
        hashMap.put("ram", "audio/x-pn-realaudio");
        hashMap.put("ras", "image/x-cmu-raster");
        hashMap.put("rdf", "application/rdf+xml");
        hashMap.put("rgb", "image/x-rgb");
        hashMap.put(Command.FILE_REMOVE, "application/vnd.rn-realmedia");
        hashMap.put("roff", "application/x-troff");
        hashMap.put("rtf", "text/rtf");
        hashMap.put("rtx", "text/richtext");
        hashMap.put("sgm", "text/sgml");
        hashMap.put("sgml", "text/sgml");
        hashMap.put("sh", "application/x-sh");
        hashMap.put("shar", "application/x-shar");
        hashMap.put("silo", "model/mesh");
        hashMap.put("sit", "application/x-stuffit");
        hashMap.put("skd", "application/x-koan");
        hashMap.put("skm", "application/x-koan");
        hashMap.put("skp", "application/x-koan");
        hashMap.put("skt", "application/x-koan");
        hashMap.put("smi", "application/smil");
        hashMap.put("smil", "application/smil");
        hashMap.put("snd", "audio/basic");
        hashMap.put("so", "application/octet-stream");
        hashMap.put("spl", "application/x-futuresplash");
        hashMap.put("src", "application/x-wais-source");
        hashMap.put("sv4cpio", "application/x-sv4cpio");
        hashMap.put("sv4crc", "application/x-sv4crc");
        hashMap.put("svg", "image/svg+xml");
        hashMap.put(ServiceAbbreviations.SimpleWorkflow, "application/x-shockwave-flash");
        hashMap.put("t", "application/x-troff");
        hashMap.put("tar", "application/x-tar");
        hashMap.put("tcl", "application/x-tcl");
        hashMap.put("tex", "application/x-tex");
        hashMap.put("texi", "application/x-texinfo");
        hashMap.put("texinfo", "application/x-texinfo");
        hashMap.put("tif", "image/tiff");
        hashMap.put("tiff", "image/tiff");
        hashMap.put("tr", "application/x-troff");
        hashMap.put("tsv", "text/tab-separated-values");
        hashMap.put("txt", "text/plain");
        hashMap.put("ustar", "application/x-ustar");
        hashMap.put("vcd", "application/x-cdlink");
        hashMap.put("vrml", "model/vrml");
        hashMap.put("vxml", "application/voicexml+xml");
        hashMap.put("wav", "audio/x-wav");
        hashMap.put("wbmp", "image/vnd.wap.wbmp");
        hashMap.put("wbxml", "application/vnd.wap.wbxml");
        hashMap.put("webm", "video/webm");
        hashMap.put("wml", "text/vnd.wap.wml");
        hashMap.put("wmlc", "application/vnd.wap.wmlc");
        hashMap.put("wmls", "text/vnd.wap.wmlscript");
        hashMap.put("wmlsc", "application/vnd.wap.wmlscriptc");
        hashMap.put("wmv", "video/x-ms-wmv");
        hashMap.put("wrl", "model/vrml");
        hashMap.put("xbm", "image/x-xbitmap");
        hashMap.put("xht", "application/xhtml+xml");
        hashMap.put("xhtml", "application/xhtml+xml");
        hashMap.put("xls", "application/vnd.ms-excel");
        hashMap.put("xml", MIMETYPE_XML);
        hashMap.put("xpm", "image/x-xpixmap");
        hashMap.put("xsl", MIMETYPE_XML);
        hashMap.put("xslt", "application/xslt+xml");
        hashMap.put("xul", "application/vnd.mozilla.xul+xml");
        hashMap.put("xwd", "image/x-xwindowdump");
        hashMap.put("xyz", "chemical/x-xyz");
        hashMap.put("zip", DfuBaseService.MIME_TYPE_ZIP);
    }

    public static synchronized Mimetypes getInstance() {
        synchronized (Mimetypes.class) {
            Mimetypes mimetypes2 = mimetypes;
            if (mimetypes2 != null) {
                return mimetypes2;
            }
            mimetypes = new Mimetypes();
            if (log.isDebugEnabled()) {
                HashMap<String, String> hashMap = mimetypes.extensionToMimetypeMap;
                for (String str : hashMap.keySet()) {
                    log.debug("Setting mime type for extension '" + str + "' to '" + hashMap.get(str) + "'");
                }
            }
            return mimetypes;
        }
    }

    public String getMimetype(String str) {
        int r0;
        int lastIndexOf = str.lastIndexOf(InstructionFileId.DOT);
        if (lastIndexOf > 0 && (r0 = lastIndexOf + 1) < str.length()) {
            String lowerCase = StringUtils.lowerCase(str.substring(r0));
            if (this.extensionToMimetypeMap.containsKey(lowerCase)) {
                String str2 = this.extensionToMimetypeMap.get(lowerCase);
                Log log2 = log;
                if (log2.isDebugEnabled()) {
                    log2.debug("Recognised extension '" + lowerCase + "', mimetype is: '" + str2 + "'");
                }
                return str2;
            }
            Log log3 = log;
            if (!log3.isDebugEnabled()) {
                return "application/octet-stream";
            }
            log3.debug("Extension '" + lowerCase + "' is unrecognized in mime type listing, using default mime type: 'application/octet-stream'");
            return "application/octet-stream";
        }
        Log log4 = log;
        if (!log4.isDebugEnabled()) {
            return "application/octet-stream";
        }
        log4.debug("File name has no extension, mime type cannot be recognised for: ".concat(str));
        return "application/octet-stream";
    }

    public void loadAndReplaceMimetypes(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StringUtils.UTF8));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String trim = readLine.trim();
                if (!trim.startsWith(ModelIdentifier.Helper.PRIMARY_KEY_DELIMITER) && trim.length() != 0) {
                    StringTokenizer stringTokenizer = new StringTokenizer(trim, " \t");
                    if (stringTokenizer.countTokens() > 1) {
                        String nextToken = stringTokenizer.nextToken();
                        while (stringTokenizer.hasMoreTokens()) {
                            String nextToken2 = stringTokenizer.nextToken();
                            this.extensionToMimetypeMap.put(StringUtils.lowerCase(nextToken2), nextToken);
                            Log log2 = log;
                            if (log2.isDebugEnabled()) {
                                log2.debug("Setting mime type for extension '" + StringUtils.lowerCase(nextToken2) + "' to '" + nextToken + "'");
                            }
                        }
                    } else {
                        Log log3 = log;
                        if (log3.isDebugEnabled()) {
                            log3.debug("Ignoring mimetype with no associated file extensions: '" + trim + "'");
                        }
                    }
                } else {
                    log.debug("Ignoring comments and empty lines.");
                }
            } else {
                return;
            }
        }
    }

    public void registerMimetype(String str, String str2) {
        this.extensionToMimetypeMap.put(StringUtils.lowerCase(str), str2);
    }

    public String getMimetype(File file) {
        return getMimetype(file.getName());
    }
}
