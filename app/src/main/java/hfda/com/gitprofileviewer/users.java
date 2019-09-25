package hfda.com.gitprofileviewer;

import java.util.ArrayList;

public class users {
    private String login,avatarUrl,html_url,score;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return getLogin()+" "+getAvatarUrl();
    }

    //    static ArrayList<users> githubUsers=new ArrayList<>();
    public users(String avatarUrl,String login,String html_url,String score){
        this.avatarUrl=avatarUrl;
        this.login=login;
        this.html_url=html_url;
        this.score=score;
    }
}
