package com.zsport.platform.uaaservice.tools;


import sun.misc.BASE64Encoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class CreatePublicKey {
    public static void main(String[] args) throws FileNotFoundException, CertificateException {
        CertificateFactory certificatefactory = CertificateFactory.getInstance("X.509");
        FileInputStream bais = new FileInputStream("D:\\workspace\\ideaWorkSpace\\zsport-framework\\uaa-service\\target\\classes\\public.cer");
        X509Certificate Cert = (X509Certificate) certificatefactory.generateCertificate(bais);
        PublicKey pk = Cert.getPublicKey();
        BASE64Encoder bse = new BASE64Encoder();
        String value = bse.encode(pk.getEncoded());
        System.out.println("pk:" + value);
    }

}
