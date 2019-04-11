package com.robot.anyDemo.room;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * 缓存的操作接口
 */
@Dao
public interface AudioDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAudioFile(AudioCache userjava);

    @Query("select * from audio_cache where file_name=:name")
    AudioCache getAudioFileFromSync(String name);

    @Query("delete from audio_cache where file_name=:name")
    int deleteFileUrl(String name);

    @Query("delete from audio_cache where folder_name=:folderName")
    int deleteFolder(String folderName);


    @Query("select count(*) from audio_cache")
    int sizeOfAudio();

    @Query("select * from audio_cache")
    List<AudioCache> getAllData();

}
