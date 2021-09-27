package com.app.demo1.Services.impl;

import com.app.demo1.model.FileInfoModel;
import com.app.demo1.model.RecordModel;

import java.io.IOException;
import java.util.List;

public interface ExcelFileInterface {

    List<RecordModel> processExcel(FileInfoModel fileInfoModel) throws IOException;
}
