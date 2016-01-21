package farkas.tdk.githubtest.function.Bean;

/**
 *
 * Created by tangdikun on 2016/1/21
 */
public class DataItem {

    private int resId;
    private String name;
    public DataItem(int resId) {
        this.resId = resId;
    }

    public DataItem(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getResId(){
        return resId;
    }


}