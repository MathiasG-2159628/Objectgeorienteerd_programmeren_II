package website;

public class WebsiteUpdate {
    private String url;
    private BrowserAction action;

    public WebsiteUpdate(String url, BrowserAction action){
        this.url = url;
        this.action = action;
    }

    public String getUrl() {
        return url;
    }

    public BrowserAction getAction() {
        return action;
    }
}
