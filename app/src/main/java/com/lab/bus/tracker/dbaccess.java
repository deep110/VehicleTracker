package com.lab.bus.tracker;

/**
 * Created by ravi on 03-May-16.
 */
public class dbaccess {
    private int _id;
    private String _studentname;
    private int _enroll;
    private String _fname;
    private String _username;
    private String _password;

    public dbaccess(){
    }

    public dbaccess(String id,String studentname,int enroll,String fname,String username,String password){
        this._studentname =studentname;
        this._enroll=enroll;
        this._fname = fname;
        this._username = username;
        this._password = password;
    }

    public int get_enroll() {
        return _enroll;
    }

    public String get_username() {
        return _username;
    }

    public String get_studentname() {
        return _studentname;
    }

    public int get_id() {
        return _id;
    }

    public String get_fname() {
        return _fname;
    }

    public String get_password() {
        return _password;
    }

    public void set_fname(String _fname) {
        this._fname = _fname;
    }

    public void set_enroll(int _enroll) {
        this._enroll = _enroll;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_studentname(String _studentname) {
        this._studentname = _studentname;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public void set_username(String _username) {
        this._username = _username;
    }
}
