package com.cbt.cbtspring24;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "userdetail_view")
public class UserdetailView {
    @Id
    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "fullname", length = Integer.MAX_VALUE)
    private String fullname;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "location", length = Integer.MAX_VALUE)
    private String location;

    @Column(name = "balance")
    private Integer balance;

    @Column(name = "types", length = Integer.MAX_VALUE)
    private String types;

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public Integer getBalance() {
        return balance;
    }

    public String getTypes() {
        return types;
    }

    protected UserdetailView() {
    }
}