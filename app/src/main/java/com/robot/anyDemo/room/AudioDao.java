package com.robot.anyDemo.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

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
