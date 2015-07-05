package jp.ac.tama.mobilepushandrest.app.util;

import com.google.gson.*;
import jp.ac.tama.mobilepushandrest.app.entity.DeviceToken;

import java.lang.reflect.Type;

/**
 * Created by KAJIWARAYutaka on 2015/07/05.
 */
public class DeviceTokenAdapter implements JsonSerializer<DeviceToken>, JsonDeserializer<DeviceToken> {
    private static final String CLASSNAME = "CLASSNAME";
    private static final String INSTANCE = "INSTANCE";
    @Override
    public DeviceToken deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return null;
    }

    @Override
    public JsonElement serialize(DeviceToken src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject retValue = new JsonObject();
        String className = src.getClass().getSimpleName();
        retValue.addProperty(CLASSNAME,className);
        JsonElement elem = context.serialize(src);
        retValue.add(INSTANCE,elem);
        return retValue;
    }
}
