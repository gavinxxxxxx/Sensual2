package me.gavin.sensual.net;

import java.util.List;

import io.reactivex.Observable;
import me.gavin.sensual.app.gank.Result;
import me.gavin.sensual.app.setting.License;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * ClientAPI
 *
 * @author gavin.xiong 2016/12/9
 */
public interface ClientAPI {


    /* **************************************************************************** *
     * *********************************** 干货集中营福利 *************************** *
     * **************************************************************************** */


    /**
     * 获取福利
     *
     * @param limit 分页大小
     * @param no    页码
     * @return Result
     */
    @Headers("Cache-Control: max-stale=1800")
    @GET("http://gank.io/api/data/福利/{limit}/{no}")
    Observable<Result> getGankImage(@Path("limit") int limit, @Path("no") int no);


    /* **************************************************************************** *
     * *********************************** 设置 ************************************ *
     * **************************************************************************** */

    @Streaming
    @GET
    Observable<ResponseBody> download(@Url String url);

    @Headers("Cache-Control: max-stale=2419200")
    @GET("https://raw.githubusercontent.com/gavinxxxxxx/Sensual/master/json/license.json")
    Observable<List<License>> getLicense();

}
