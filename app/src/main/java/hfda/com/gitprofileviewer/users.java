package hfda.com.gitprofileviewer;

import java.util.ArrayList;

public class users {
    private String login,avatarUrl,html_url,score;

    public String getLogin() {
        return login;
    }


    public String getAvatarUrl() {
        return avatarUrl;
    }


    public String getHtml_url() {
        return html_url;
    }


    public String getScore() {
        return score;
    }


    @Override
    public String toString() {
        return getLogin()+" "+getAvatarUrl();
    }

    public users(String avatarUrl,String login,String html_url,String score){
        this.avatarUrl=avatarUrl;
        this.login=login;
        this.html_url=html_url;
        this.score=score;
    }
}
