package com.android.cast.dlna.demo;

import androidx.annotation.NonNull;

import com.android.cast.dlna.ICast;

/**
 *
 */
public class CastVideo implements ICast.ICastVideo {
    public static CastVideo newInstance(String url, String id, String name) {
        return new CastVideo(url, id, name);
    }

    public final String url;

    public final String id;

    public final String name;

    private long duration;

    public CastVideo(String url, String id, String name) {
        this.url = url;
        this.id = id;
        this.name = name;
    }

    /**
     * @param duration the total time of video (ms)
     */
    public CastVideo setDuration(long duration) {
        this.duration = duration;
        return this;
    }

    @NonNull
    @Override
    public String getId() {
        return id;
    }

    @NonNull
    @Override
    public String getUri() {
        return url;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getDurationMillSeconds() {
        return duration;
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public long getBitrate() {
        return 0;
    }
}