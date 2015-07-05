package jp.ac.tama.mobilepushandrest.app.restInterface;

import jp.ac.tama.mobilepushandrest.app.entity.DeviceToken;
import retrofit.http.PUT;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by KAJIWARAYutaka on 2015/07/05.
 */
public interface DeviceRegisterAPI {
    @PUT("/api/deviceRegister")
    public Observable<Boolean> register(@Query("token") DeviceToken token);
}
