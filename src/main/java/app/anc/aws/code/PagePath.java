package app.anc.aws.code;

/**
 * The enum Page path.
 */
public enum PagePath {
    LOGIN("login"),
    LOG_SUCCESS("login_success");

    public String path;

    PagePath(String path){
        this.path = path;
    }
}
