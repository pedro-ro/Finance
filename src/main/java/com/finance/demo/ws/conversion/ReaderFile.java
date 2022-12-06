package com.finance.demo.ws.conversion;

import io.micrometer.common.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class ReaderFile {
    protected FileReader fileReader;
    protected BufferedReader bufferedReader;
    protected final static String SEPARATOR_LINES = ",";
    protected final static String PATTERN_DATE = "dd/MM/yyyy";

    protected void init(String path) {
        Optional.of(path).filter(StringUtils::isNotBlank).ifPresent(it -> {
            try {
                this.fileReader = new FileReader(it);
                this.bufferedReader = new BufferedReader(fileReader);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    protected List<String> read(int skipLines) {
        return Optional.of(this.bufferedReader).map(it -> {
            try {
                for (int i = 0; i < skipLines; i++) {
                    it.readLine();
                }
                String line = it.readLine();
                final List<String> lines = new ArrayList<>(20);
                while (line != null) {
                    lines.add(line);
                    line = it.readLine();
                }
                return lines;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).orElse(Collections.emptyList());
    }

}
