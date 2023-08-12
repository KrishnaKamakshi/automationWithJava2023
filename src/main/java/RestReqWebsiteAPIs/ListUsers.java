package RestReqWebsiteAPIs;

import java.util.List;

public class ListUsers {
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getPer_page() {
        return per_page;
    }
    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public int getTotal_pages() {
        return total_pages;
    }
    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }
    public List<DataUsers> getData() {
        return data;
    }
    public void setData(List<DataUsers> data) {
        this.data = data;
    }
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<DataUsers> data;
    public SupportClass getSupport() {
        return support;
    }    public void setSupport(SupportClass support) {
        this.support = support;
    }
    private SupportClass support;
}
