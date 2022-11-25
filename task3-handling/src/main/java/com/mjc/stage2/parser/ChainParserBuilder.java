package com.mjc.stage2.parser;

import java.util.ArrayList;
import java.util.List;

public class ChainParserBuilder {
    private List<AbstractTextParser> parsers = new ArrayList<>();

    public ChainParserBuilder() {
    }

    public ChainParserBuilder setParser(AbstractTextParser abstractTextParser) {
        if (!parsers.isEmpty()) {
            parsers.get(parsers.size() - 1).setNextParser(abstractTextParser);
        }
        parsers.add(abstractTextParser);
        return this;
    }

    public AbstractTextParser build() {
        if (parsers.isEmpty()) {
            throw new RuntimeException("No parsers was set!");
        }
        return parsers.get(0);
    }
}
