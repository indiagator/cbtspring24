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
@Table(name = "usertypebalance_view")
public class UsertypebalanceView {
    @Id
    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "types", length = Integer.MAX_VALUE)
    private String types;

    @Column(name = "balance")
    private Integer balance;

    public String getUsername() {
        return username;
    }

    public String getTypes() {
        return types;
    }

    public Integer getBalance() {
        return balance;
    }

    protected UsertypebalanceView() {
    }
}