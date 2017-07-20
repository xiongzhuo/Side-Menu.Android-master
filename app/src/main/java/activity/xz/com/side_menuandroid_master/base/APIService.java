package activity.xz.com.side_menuandroid_master.base;

import activity.xz.com.side_menuandroid_master.bean.IPHttpResult;
import activity.xz.com.side_menuandroid_master.bean.IpInfo;
import activity.xz.com.side_menuandroid_master.bean.Movies;
import activity.xz.com.side_menuandroid_master.bean.TokenResult;
import activity.xz.com.side_menuandroid_master.bean.UserHttpResult;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/7/13.
 */

public interface APIService {
    /**
     * 用户登录的接口
     *
     * @param username 用户名
     * @param pwd      密码
     * @return RxJava 对象
     */
    @POST("okhttp/UserInfoServlert")
    Observable<UserHttpResult<TokenResult>> userLogin(@Query("username") String username, @Query("pwd") String pwd);

    /**
     * 查询ip地址信息的接口
     *
     * @param ip 需查询的ip
     * @return RxJava 对象
     */
    @GET("service/getIpInfo.php")
    Observable<IPHttpResult<IpInfo>> queryIp(@Query("ip") String ip);

    /**
     * 查询豆瓣排名前250的电影
     *
     * @param start 从第几部开始
     * @param count 几页(一页有12部)
     * @return
     */
    @GET("v2/movie/top250")
    Observable<Movies> getMovies(@Query("start") int start, @Query("count") int count);
}
