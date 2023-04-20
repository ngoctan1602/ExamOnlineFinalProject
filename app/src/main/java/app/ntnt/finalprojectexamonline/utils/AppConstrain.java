package app.ntnt.finalprojectexamonline.utils;

import android.content.Context;
import android.net.Uri;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class AppConstrain {
    public static MultipartBody.Part toPart(Context context, Uri uri){
        String IMAGE_PATH = RealPathUtil.getRealPath(context, uri);
        File file = new File(IMAGE_PATH);
        byte[] fileBytes;
        try (FileInputStream inputStream = new FileInputStream(file)) {
            fileBytes = new byte[(int) file.length()];
            inputStream.read(fileBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        RequestBody requestFile = RequestBody.create(file, MediaType.parse("image/*"));
        return MultipartBody.Part.createFormData("avatar", file.getName(), requestFile);
    }
}
