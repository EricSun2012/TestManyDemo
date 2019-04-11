package com.robot.anyDemo.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.support.annotation.NonNull;

/**
 * 缓存的模型与表结构对照表
 */

@Entity(primaryKeys = "file_name",
        tableName = "audio_cache",
        indices = {@Index(value = "file_name", unique = true), @Index(value = "folder_name")})
public class AudioCache {

    @NonNull
    @ColumnInfo(name = "file_name")
    private String fileName;

    @ColumnInfo(name = "folder_name")
    private String folderName;

    public String getFileName() {
        return fileName == null ? "" : fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }
}
