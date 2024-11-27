package cn.iocoder.yudao.framework.security.core.util;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Bagration C
 */
public class RSAUtil {

    //签名算法名称
    private static final String RSA_KEY_ALGORITHM = "RSA";

    //公钥
    private static final String PUBLIC_KEY = "";

    //私钥
    private static final String PRIVATE_KEY =
            "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAqhHyZfSsYourNxaY" +
            "7Nt+PrgrxkiA50efORdI5U5lsW79MmFnusUA355oaSXcLhu5xxB38SMSyP2KvuKN" +
            "PuH3owIDAQABAkAfoiLyL+Z4lf4Myxk6xUDgLaWGximj20CUf+5BKKnlrK+Ed8gA" +
            "kM0HqoTt2UZwA5E2MzS4EI2gjfQhz5X28uqxAiEA3wNFxfrCZlSZHb0gn2zDpWow" +
            "cSxQAgiCstxGUoOqlW8CIQDDOerGKH5OmCJ4Z21v+F25WaHYPxCFMvwxpcw99Ecv" +
            "DQIgIdhDTIqD2jfYjPTY8Jj3EDGPbH2HHuffvflECt3Ek60CIQCFRlCkHpi7hthh" +
            "YhovyloRYsM+IS9h/0BzlEAuO0ktMQIgSPT3aFAgJYwKpqRYKlLDVcflZFCKY7u3" +
            "UP8iWi1Qw0Y=";

    //RSA密钥长度,默认密钥长度是1024,密钥长度必须是64的倍数，在512到65536位之间,不管是RSA还是RSA2长度推荐使用2048
    private static final int KEY_SIZE = 2048;

    /**
     * 公钥加密(用于数据加密)
     *
     * @param data         加密前的字符串
     * @param publicKeyStr base64编码后的公钥
     * @return base64编码后的字符串
     * @throws Exception
     */
    public static String encryptByPublicKey(String data, String publicKeyStr) throws Exception {
        //Java原生base64解码
        byte[] pubKey = Base64.getDecoder().decode(publicKeyStr);
        //创建X509编码密钥规范
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(pubKey);
        //返回转换指定算法的KeyFactory对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        //根据X509编码密钥规范产生公钥对象
        PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
        //根据转换的名称获取密码对象Cipher（转换的名称：算法/工作模式/填充模式）
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        //用公钥初始化此Cipher对象（加密模式）
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        //对数据加密
        byte[] encrypt = cipher.doFinal(data.getBytes());
        //返回base64编码后的字符串
        return Base64.getEncoder().encodeToString(encrypt);
    }


    /**
     * 私钥解密(用于数据解密)
     *
     * @param data          解密前的字符串
     * @param privateKeyStr 私钥
     * @return 解密后的字符串
     * @throws Exception
     */
    public static String decryptByPrivateKey(String data, String privateKeyStr) throws Exception {
        if (privateKeyStr == null) {
            privateKeyStr = PRIVATE_KEY;
        }

        //Java原生base64解码
        byte[] priKey = Base64.getDecoder().decode(privateKeyStr);
        //创建PKCS8编码密钥规范
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(priKey);
        //返回转换指定算法的KeyFactory对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        //根据PKCS8编码密钥规范产生私钥对象
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        //根据转换的名称获取密码对象Cipher（转换的名称：算法/工作模式/填充模式）
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        //用私钥初始化此Cipher对象（解密模式）
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        //对数据解密
        byte[] decrypt = cipher.doFinal(Base64.getDecoder().decode(data));
        //返回字符串
        return new String(decrypt);
    }



    /**
     * 私钥加密(用于数据签名)
     *
     * @param data          加密前的字符串
     * @param privateKeyStr base64编码后的私钥
     * @return base64编码后后的字符串
     * @throws Exception
     */
    public static String encryptByPrivateKey(String data, String privateKeyStr) throws Exception {
        //Java原生base64解码
        byte[] priKey = Base64.getDecoder().decode(privateKeyStr);
        //创建PKCS8编码密钥规范
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(priKey);
        //返回转换指定算法的KeyFactory对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        //根据PKCS8编码密钥规范产生私钥对象
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        //根据转换的名称获取密码对象Cipher（转换的名称：算法/工作模式/填充模式）
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        //用私钥初始化此Cipher对象（加密模式）
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        //对数据加密
        byte[] encrypt = cipher.doFinal(data.getBytes());
        //返回base64编码后的字符串
        return Base64.getEncoder().encodeToString(encrypt);
    }

    /**
     * 公钥解密(用于数据验签)
     *
     * @param data         解密前的字符串
     * @param publicKeyStr base64编码后的公钥
     * @return 解密后的字符串
     * @throws Exception
     */
    public static String decryptByPublicKey(String data, String publicKeyStr) throws Exception {
        //Java原生base64解码
        byte[] pubKey = Base64.getDecoder().decode(publicKeyStr);
        //创建X509编码密钥规范
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(pubKey);
        //返回转换指定算法的KeyFactory对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        //根据X509编码密钥规范产生公钥对象
        PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
        //根据转换的名称获取密码对象Cipher（转换的名称：算法/工作模式/填充模式）
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        //用公钥初始化此Cipher对象（解密模式）
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        //对数据解密
        byte[] decrypt = cipher.doFinal(Base64.getDecoder().decode(data));
        //返回字符串
        return new String(decrypt);
    }

}
