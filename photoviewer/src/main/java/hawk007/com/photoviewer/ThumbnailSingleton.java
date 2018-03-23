package hawk007.com.photoviewer;

/**
 * Created by hawk on 2018/3/23.
 * 缩略图传输类
 */

public class ThumbnailSingleton {
    private ThumbnailSingleton(){}
    private static class SingletonLoader{
        private static final ThumbnailSingleton INSTANCE = new ThumbnailSingleton();
    }

    public static ThumbnailSingleton getInstance(){
        return SingletonLoader.INSTANCE;
    }

}
