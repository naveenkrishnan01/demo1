package com.app.demo1.util;

import com.app.demo1.model.FileInfoModel;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.defaultIfEmpty;

public class ArgumentCommandLine {

    public FileInfoModel parseArgs(String... args) throws ArgumentParserException {
        ArgumentParser parser =
                ArgumentParsers.newFor("demo1").build();
        parser.addArgument("--path").required(false).help("filepath is required");
        parser.addArgument("--name").required(false).help("filename is required");
        parser.addArgument("--sheet").required(false).help("sheetname is required");
        Namespace namespace = null;
       namespace = parser.parseArgs(args);

        Map<String, Object> argsMap = namespace.getAttrs();
        final Map<String, String> paramMap = new HashMap<>();
        argsMap.forEach((key, value) -> paramMap.put(key.toUpperCase(), defaultIfEmpty((String) value, EMPTY)));
        FileInfoModel fileInfoModel = new FileInfoModel();
        fileInfoModel.setFileName(paramMap.get("FILE_NAME"));
        fileInfoModel.setFilePath(paramMap.get("FILE_PATH"));
        fileInfoModel.setSheetName(paramMap.get("SHEET_NAME"));
        return fileInfoModel;
    }
    }


