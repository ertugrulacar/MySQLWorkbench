package com.mysql.dbeditor.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<ServerInfo> serverInfos;

    public User(){}
    public User(String name, String lastname, String email, String password, Set<ServerInfo> serverInfos) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.serverInfos = serverInfos;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<ServerInfo> getServerInfos() {
        return serverInfos;
    }

    public void setServerInfos(Set<ServerInfo> serverInfos) {
        this.serverInfos = serverInfos;
    }
}
