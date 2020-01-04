package com.p2p.model;

public class Cart {
    private Integer cid;

    private Integer uid;

    private String cartId;

    private String ctype;

    private String cname;

    public Cart(Integer cid, Integer uid, String cartId, String ctype, String cname) {
        this.cid = cid;
        this.uid = uid;
        this.cartId = cartId;
        this.ctype = ctype;
        this.cname = cname;
    }

    public Cart() {
        super();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}