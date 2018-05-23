package com.example.java.androidfire.data.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by java on 2018/5/11.
 */

public class TouTiao_Bean {
    @SerializedName(value = "T1348647909107", alternate = {"T1348648756099", "T1348648141035", "T1348649079062", "T1399700447917", "T1348648517839", "T1348648650048", "T1348654060988"
            , "T1350383429665", "T1348654151579", "T1348650593803", "T1348650839000", "T1370583240249", "T1379038288239", "T1348649145984", "T1348649776727", "T1351233117091", "T1356600029035"
            , "T1348654225495", "T1349837670307", "T1348654204705", "T1348649654285", "T1349837698345", "T1348648037603", "T1348654105308", "T1397016069906", "T1397116135282", "T1348649475931"
            , "T1371543208049"})
    private List<T1348647909107Bean> T1348647909107;

    public List<T1348647909107Bean> getT1348647909107() {
        return T1348647909107;
    }

    public void setT1348647909107(List<T1348647909107Bean> T1348647909107) {
        this.T1348647909107 = T1348647909107;
    }

    public static class T1348647909107Bean {
        /**
         * template : normal1
         * skipID : 00AO0001|2293509
         * lmodify : 2018-05-14 08:31:16
         * postid : PHOT25VO5000100A
         * source : 视觉中国
         * title : 耶路撒冷美国新使馆开张 伊万卡出席
         * mtime : 2018-05-14 08:31:16
         * hasImg : 1
         * topic_background : http://img2.cache.netease.com/m/newsapp/reading/cover1/C1348646712614.jpg
         * digest :
         * photosetID : 00AO0001|2293509
         * boardid : photoview_bbs
         * alias : Top News
         * hasAD : 1
         * imgsrc : http://cms-bucket.nosdn.127.net/ed97a97766b64cf9b7d65460a379ac0020180514081259.jpeg
         * ptime : 2018-05-14 08:13:42
         * daynum : 17665
         * hasHead : 1
         * imgType : 1
         * order : 1
         * editor : []
         * votecount : 644
         * hasCover : false
         * docid : 9IG74V5H00963VRO_DHOKA7AIbjguyingupdateDoc
         * tname : 头条
         * priority : 355
         * ads : [{"subtitle":"","skipType":"photoset","skipID":"00AO0001|2293513","tag":"photoset","title":"夏威夷火山持续喷发 再现新裂缝","imgsrc":"bigimg","url":"00AO0001|2293513"},{"subtitle":"","skipType":"photoset","skipID":"00AO0001|2293509","tag":"photoset","title":"耶路撒冷美国新使馆开张 伊万卡出席","imgsrc":"bigimg","url":"00AO0001|2293509"},{"subtitle":"","skipType":"photoset","skipID":"00AP0001|2293508","tag":"photoset","title":"重庆\"五星级\"豪华公厕:有电视及WiFi","imgsrc":"bigimg","url":"00AP0001|2293508"},{"subtitle":"","skipType":"photoset","skipID":"00AO0001|2293506","tag":"photoset","title":"伊万卡抵以色列出席美使馆搬迁仪式","imgsrc":"bigimg","url":"00AO0001|2293506"},{"subtitle":"","skipType":"photoset","skipID":"00AP0001|2293505","tag":"photoset","title":"荔枝大比拼:一串\"妃子笑\"拍出9.9万","imgsrc":"bigimg","url":"00AP0001|2293505"}]
         * ename : androidnews
         * replyCount : 690
         * imgsum : 4
         * hasIcon : false
         * skipType : photoset
         * cid : C1348646712614
         * url_3w : http://news.163.com/18/0513/13/DHMJM5FM000189FH.html
         * url : http://3g.163.com/news/18/0513/13/DHMJM5FM000189FH.html
         * ltitle : 习近平和母亲
         * subtitle :
         * pixel : 1024*784
         */

        private String template;
        private String skipID;
        private String lmodify;
        private String postid;
        private String source;
        private String title;
        private String mtime;
        private int hasImg;
        private String topic_background;
        private String digest;
        private String photosetID;
        private String boardid;
        private String alias;
        private int hasAD;
        private String imgsrc;
        private String ptime;
        private String daynum;
        private int hasHead;
        private int imgType;
        private int order;
        private int votecount;
        private boolean hasCover;
        private String docid;
        private String tname;
        private int priority;
        private String ename;
        private int replyCount;
        private int imgsum;
        private boolean hasIcon;
        private String skipType;
        private String cid;
        private String url_3w;
        private String url;
        private String ltitle;
        private String subtitle;
        private String pixel;
        private List<?> editor;
        private List<AdsBean> ads;

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public String getSkipID() {
            return skipID;
        }

        public void setSkipID(String skipID) {
            this.skipID = skipID;
        }

        public String getLmodify() {
            return lmodify;
        }

        public void setLmodify(String lmodify) {
            this.lmodify = lmodify;
        }

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMtime() {
            return mtime;
        }

        public void setMtime(String mtime) {
            this.mtime = mtime;
        }

        public int getHasImg() {
            return hasImg;
        }

        public void setHasImg(int hasImg) {
            this.hasImg = hasImg;
        }

        public String getTopic_background() {
            return topic_background;
        }

        public void setTopic_background(String topic_background) {
            this.topic_background = topic_background;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getPhotosetID() {
            return photosetID;
        }

        public void setPhotosetID(String photosetID) {
            this.photosetID = photosetID;
        }

        public String getBoardid() {
            return boardid;
        }

        public void setBoardid(String boardid) {
            this.boardid = boardid;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public int getHasAD() {
            return hasAD;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getDaynum() {
            return daynum;
        }

        public void setDaynum(String daynum) {
            this.daynum = daynum;
        }

        public int getHasHead() {
            return hasHead;
        }

        public void setHasHead(int hasHead) {
            this.hasHead = hasHead;
        }

        public int getImgType() {
            return imgType;
        }

        public void setImgType(int imgType) {
            this.imgType = imgType;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getVotecount() {
            return votecount;
        }

        public void setVotecount(int votecount) {
            this.votecount = votecount;
        }

        public boolean isHasCover() {
            return hasCover;
        }

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public int getImgsum() {
            return imgsum;
        }

        public void setImgsum(int imgsum) {
            this.imgsum = imgsum;
        }

        public boolean isHasIcon() {
            return hasIcon;
        }

        public void setHasIcon(boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public String getSkipType() {
            return skipType;
        }

        public void setSkipType(String skipType) {
            this.skipType = skipType;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getUrl_3w() {
            return url_3w;
        }

        public void setUrl_3w(String url_3w) {
            this.url_3w = url_3w;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getLtitle() {
            return ltitle;
        }

        public void setLtitle(String ltitle) {
            this.ltitle = ltitle;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getPixel() {
            return pixel;
        }

        public void setPixel(String pixel) {
            this.pixel = pixel;
        }

        public List<?> getEditor() {
            return editor;
        }

        public void setEditor(List<?> editor) {
            this.editor = editor;
        }

        public List<AdsBean> getAds() {
            return ads;
        }

        public void setAds(List<AdsBean> ads) {
            this.ads = ads;
        }

        public static class AdsBean {
            /**
             * subtitle :
             * skipType : photoset
             * skipID : 00AO0001|2293513
             * tag : photoset
             * title : 夏威夷火山持续喷发 再现新裂缝
             * imgsrc : bigimg
             * url : 00AO0001|2293513
             */

            private String subtitle;
            private String skipType;
            private String skipID;
            private String tag;
            private String title;
            private String imgsrc;
            private String url;

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getSkipType() {
                return skipType;
            }

            public void setSkipType(String skipType) {
                this.skipType = skipType;
            }

            public String getSkipID() {
                return skipID;
            }

            public void setSkipID(String skipID) {
                this.skipID = skipID;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
