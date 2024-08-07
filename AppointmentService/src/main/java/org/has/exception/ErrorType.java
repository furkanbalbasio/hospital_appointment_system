package org.has.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    SIFRE_UYUSMUYOR(1001,"Girilen şifreler uyuşmuyor",HttpStatus.BAD_REQUEST),
    USERNAME_PASSWORD_ERROR(1001,"Kullanıcı adı ya da şifre hatalıdır.",HttpStatus.BAD_REQUEST),
    BAD_REQUEST_ERROR(3001,"Girilen bilgiler Hatalı, kontrol ederek tekar giriniz.", HttpStatus.BAD_REQUEST),
    TOKEN_ERROR(1004,"Token üretilemedi, lütfen tekrar giriş yapmayı deneyiniz.", HttpStatus.INTERNAL_SERVER_ERROR),
    KAYITLI_KULLANICI_ADI(1003,"Bu kullanıcı adı zaten kayıtlıdır",HttpStatus.BAD_REQUEST),
    RANDEVU_DOLU(1005,"Bu randevu doludur",HttpStatus.BAD_REQUEST),
    HASTA_BULUNMAMAKTADIR(1007,"Hasta bulunmamaktadir",HttpStatus.BAD_REQUEST),
    DOKTOR_BULUNMAMAKTADIR(1006,"Doktor Bulunmamaktadır.",HttpStatus.BAD_REQUEST);


    private int code;
    private String message;
    private HttpStatus httpStatus;

//    ErrorType(int code, String message, HttpStatus httpStatus){
//        this.code = code;
//        this.httpStatus = httpStatus;
//        this.message = message;
//    }
}
