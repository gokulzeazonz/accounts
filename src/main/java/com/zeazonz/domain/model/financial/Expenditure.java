package com.zeazonz.domain.model.financial;

import com.zeazonz.domain.model.category.Category;
import com.zeazonz.domain.model.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "expense")
public class Expenditure {

    /*
    @Column(name  = "category_id")
    private Long category_id;

    @Column(name  = "user_id")
    private Long user_id;

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
    */

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //////////////////////////////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name  = "date")
    private Date date;

    @Column(name  = "amount")
    private Long amount;

    public Expenditure() {
    }

    public Long getId() {
        return id;
    }

    public Expenditure(Date date, Long amount) {
//        this.category_id = category_id;
//        this.user_id = user_id;
        this.date = date;
        this.amount = amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

}
