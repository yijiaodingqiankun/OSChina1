package com.jiyun.dell.oschina.bean;


import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/7/18.
 */

//@Root(name = "oschina")
public class ZiXun {
//    @Element(required = false)
    private String catalog;
//    @Element(required = false)
    private String pagesize;
//    @Element(required = false)
    private String newsCount;
//    @ElementList(required = false)
    private List<NewsBean> newslist;

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getPagesize() {
        return pagesize;
    }

    public void setPagesize(String pagesize) {
        this.pagesize = pagesize;
    }

    public String getNewsCount() {
        return newsCount;
    }

    public void setNewsCount(String newsCount) {
        this.newsCount = newsCount;
    }

    public List<NewsBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewsBean> newslist) {
        this.newslist = newslist;
    }

//    @Root(name = "news")
    public static class NewsBean {
//        @Element(required = false)
        private String id;
//        @Element(required = false)
        private String title;
//        @Element(required = false)
        private String body;
//        @Element(required = false)
        private String commentCount;
//        @Element(required = false)
        private String author;
//        @Element(required = false)
        private String authorid;
//        @Element(required = false)
        private String pubDate;
//        @Element(required = false)
        private String url;
//        @Element(required = false)
        private NewstypeBean newstype;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(String commentCount) {
            this.commentCount = commentCount;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAuthorid() {
            return authorid;
        }

        public void setAuthorid(String authorid) {
            this.authorid = authorid;
        }

        public String getPubDate() {
            return pubDate;
        }

        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public NewstypeBean getNewstype() {
            return newstype;
        }

        public void setNewstype(NewstypeBean newstype) {
            this.newstype = newstype;
        }

//        @Root(name = "newstype")
        public static class NewstypeBean {
//            @Element(required = false)
            private String type;
//            @Element(required = false)
            private String attachment;
//            @Element(required = false)
            private String authoruid2;
//            @Element(required = false)
            private String eventurl;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getAttachment() {
                return attachment;
            }

            public void setAttachment(String attachment) {
                this.attachment = attachment;
            }

            public String getAuthoruid2() {
                return authoruid2;
            }

            public void setAuthoruid2(String authoruid2) {
                this.authoruid2 = authoruid2;
            }

            public String getEventurl() {
                return eventurl;
            }

            public void setEventurl(String eventurl) {
                this.eventurl = eventurl;
            }
        }
    }
}
