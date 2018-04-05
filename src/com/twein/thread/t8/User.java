package com.twein.thread.t8;

/**
 * Created by tweinyan on 04/04/2018.
 */
public class User {
    private String name;

    public volatile int old;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }
}
