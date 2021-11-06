package persistence;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PooledDataSource {
    private static BasicDataSource basicDS; //싱글톤 패턴 밑에도 static으로 감쌌으므로 컴파일 시점에 메모리에 로딩됨
    //static은 jvm의 stactic메모리 영역에 올라가므로 new없이 사용할 수 있음.

    static {
        try {
            basicDS = new BasicDataSource();
            Properties properties = new Properties();
            //InputStream inputStream = new FileInputStream("src/main/resources/config/db.yml");
            Class<PooledDataSource> pooledDataSourceClass = PooledDataSource.class;
            InputStream inputStream = pooledDataSourceClass.getClassLoader().getResourceAsStream("config/db.yml"); //jar파일 최상위 기준으로 경로를 입력

            //resources에 추가된 폴더들을 최상위로 올려버림 그래서 실제 jar파일의 경로는 여기서 보이는것과 다르기때문에 FileInputStream은 이식성이 없기에 사용하지않는게 좋다.
//            InputStream inputStream = new FileInputStream("src/main/resources/config/db.yml");
            properties.load(inputStream);
            basicDS.setDriverClassName(properties.getProperty("DRIVER_CLASS")); //loads the jdbc driver
            basicDS.setUrl(properties.getProperty("DB_CONNECTION_URL"));
            basicDS.setUsername(properties.getProperty("DB_USER"));
            basicDS.setPassword(properties.getProperty("DB_PWD"));
// Parameters for connection pooling
            basicDS.setInitialSize(10);
            basicDS.setMaxTotal(10);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return basicDS;
    }
}
