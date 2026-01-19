package com.jon5307.blog.util;

import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.TextCollectingVisitor;
import com.vladsch.flexmark.util.data.MutableDataSet;

public class MarkdownUtil {
    private static final Parser PARSER = Parser.builder(new MutableDataSet()).build();
    public static String toPlainText(String md) {
        if (md == null) { return ""; }
        Node document = PARSER.parse(md);
        return new TextCollectingVisitor().collectAndGetText(document);
    }
}
