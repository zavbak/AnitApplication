package ru.a799000.android.anitapplication.repository.net.auth;

/**
 * Return String autorithation Russin
 */

public class AutoritationManager {

    public static String getStringAutorization(String username,String pass){

        if (username != null && pass != null) {
            StringBuffer buf = new StringBuffer(username);
            buf.append(':').append(pass);
            byte[] raw = buf.toString().getBytes();
            buf.setLength(0);
            buf.append("Basic ");
            org.kobjects.base64.Base64.encode(raw, 0, raw.length, buf);

            //android.util.Base64.encode( auth.getBytes(), Base64.NO_WRAP);
            return buf.toString();
        }

        return null;
    }



}
