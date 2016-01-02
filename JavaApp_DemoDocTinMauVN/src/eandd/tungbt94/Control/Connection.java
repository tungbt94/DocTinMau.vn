/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eandd.tungbt94.Control;

import eandd.tungbt94.Model.*;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

/**
 *
 * @author Bui Thanh Tung
 */
public class Connection {

    private Document document = null;

    public Connection(String url) {
        try {
            document = Jsoup.connect(url).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(url);
    }

    public ArrayList<TitlePrimary> getListTitlePrimary() {
        ArrayList<TitlePrimary> arrTitlePrimary = new ArrayList<TitlePrimary>();
        Elements arrElement = document.getElementsByClass("titleprimary");
        for (Element element : arrElement) {
            String elementTitlePost = element.text();
            String elementHref = element.select("a").attr("href");
            TitlePrimary titlePrimary = new TitlePrimary(elementHref, elementTitlePost);
            arrTitlePrimary.add(titlePrimary);
//            System.out.println(titlePrimary.toString());
        }
        return arrTitlePrimary;
    }

    public ArrayList<Title> getListTitle() {
        ArrayList<Title> arrTinTuc = new ArrayList<Title>();
        Element elementListTitle = document.getElementById("ctl00_ContentPlaceHolder1_DataList1");
        Elements arrElementTitleLeft = elementListTitle.getElementsByClass("baiviettrai");
        Elements arrElementTitleRight = elementListTitle.getElementsByClass("baivietphai");
        int size = arrElementTitleLeft.size();
        for (int i = 0; i < size; i++) {
            Element element = null;
            element = arrElementTitleLeft.get(i);
            arrTinTuc.add(getTitleFromElement(element));
            element = arrElementTitleRight.get(i);
            arrTinTuc.add(getTitleFromElement(element));
        }
//        System.out.println(arrTinTuc.size());
        return arrTinTuc;
    }

    public Title getTitleFromElement(Element element) {
        String href = element.select("a").attr("href");
        String titlePost = element.getElementsByClass("tieudebaiviet").text();
        String lead = element.getElementsByClass("noidungtomtatbaiviet").text();
        String avatar = element.getElementsByClass("anhbaivietList").select("img").attr("src");
        Title title = new Title(lead, avatar, href, titlePost);
//        System.out.println(title.toString());
        return title;
    }

    public Post getPost() {
        Post post = new Post();
        Elements arrElement = document.getElementsByClass("noidungchitietbaiviet");
        Elements arrContent = arrElement.get(0).select("p");
        String content = "";
        for (Element element : arrContent) {
            if (element.select("img").size() > 0) {
                content += "img:" + element.select("img").attr("src") + "\n";
            } else {
                content += element.text() + "\n";
            }
        }
        post.setContent(content);
        return post;
    }

}
