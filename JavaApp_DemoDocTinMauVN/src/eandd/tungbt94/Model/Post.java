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
public class Post extends Title{
    private String content;

    public Post() {
        super(null, null);
    }

    public Post(String content, String lead, String avatar, String href, String titlePost) {
        super(lead, avatar, href, titlePost);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
