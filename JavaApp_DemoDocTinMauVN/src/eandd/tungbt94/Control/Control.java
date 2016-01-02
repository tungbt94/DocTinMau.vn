/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eandd.tungbt94.Control;

import eandd.tungbt94.View.*;
import eandd.tungbt94.Model.*;

/**
 *
 * @author Bui Thanh Tung
 */
public class Control {
    private FrameHome frHome;
    private FrameTitlePrimary frTitlePrimary;
    private FramePost frPost;

    public Control() {
    }

    public Control(String url) {
        frHome = new FrameHome();
        frHome.setConnection(new Connection(url));
        frHome.loadTable();
        frTitlePrimary = new FrameTitlePrimary();
        frPost = new FramePost();
        frHome.setControl(this);
        frTitlePrimary.setControl(this);
        frHome.setVisible(true);
    }

    public FrameHome getFrHome() {
        return frHome;
    }

    public void setFrHome(FrameHome frHome) {
        this.frHome = frHome;
    }

    public FrameTitlePrimary getFrTitlePrimary() {
        return frTitlePrimary;
    }

    public void setFrTitlePrimary(FrameTitlePrimary frTitlePrimary) {
        this.frTitlePrimary = frTitlePrimary;
    }

    public FramePost getFrPost() {
        return frPost;
    }

    public void setFrPost(FramePost frPost) {
        this.frPost = frPost;
    }
    
    public void loadTitlePrimary(TitlePrimary titlePrimary){
//        System.out.println("load title pri");
        frTitlePrimary.setConnection(new Connection(titlePrimary.getHref()));
        frTitlePrimary.loadName(titlePrimary.getTitlePost());
        frTitlePrimary.loadTable(titlePrimary);
        frTitlePrimary.setVisible(true);
    }
    
    public void loadPost(Title title){
        frPost.setConnection(new Connection(title.getHref()));
        frPost.loadName(title.getTitlePost());
        frPost.loadContent();
        frPost.setVisible(true);
    }
}
