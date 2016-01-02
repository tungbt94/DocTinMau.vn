/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eandd.tungbt94.Model;

/**
 *
 * @author Bui Thanh Tung
 */
public class TitlePrimary {
    protected String href;
    protected String titlePost;

    public TitlePrimary(String href, String titlePost) {
        this.href = href;
        this.titlePost = titlePost;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTitlePost() {
        return titlePost;
    }

    public void setTitlePost(String titlePost) {
        this.titlePost = titlePost;
    }

    @Override
    public String toString() {
        return titlePost+"\t"+href;
    }
    
    
}
