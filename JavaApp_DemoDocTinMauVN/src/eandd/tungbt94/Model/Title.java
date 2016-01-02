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
public class Title extends TitlePrimary{
    protected String lead;
    private String avatar;

    public Title(String href, String titlePost) {
        super(href, titlePost);
    }

    public Title(String lead, String avatar, String href, String titlePost) {
        super(href, titlePost);
        this.lead = lead;
        this.avatar = avatar;
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

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return avatar + "\n" + titlePost + "\t " + href + "\n" + lead;
    }

}
