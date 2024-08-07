package org.has.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class JwtTokenManager {

    @Value("${my-application-secretary.secret-key}")
    private  String SECRETKEY;
    private final String ISSUER = "Java11BoostAuth";
    private final Long EXDATE = 1000L*60*5; // 5 Dakika

    public Optional<String> createToken(Long authId){
        String token;
        try{
            token = JWT.create()
                    .withAudience()
                    .withClaim("authId",authId) // DİKKAT!!! buralara(Claim) eklediğiniz datalar şifrelenmez
                    .withClaim("howtopage","AuthMicroService")
                    .withClaim("kendimeNot","buralara istediğin gibi veri ekleyebilirim.")
                    .withClaim("listeeklesek", List.of("bu listemi"))
                    .withIssuer(ISSUER) // jwt yi üreten sahiplik
                    .withIssuedAt(new Date()) // jwt üretilme zamanı
                    .withExpiresAt(new Date(System.currentTimeMillis()+EXDATE))// jwt nin sona erme tarihi
                    .sign(Algorithm.HMAC512(SECRETKEY));
            return Optional.of(token);
        }catch (Exception exception){
            return Optional.empty();
        }
    }


    public boolean validateToken(String token){
        try{

            Algorithm algorithm = Algorithm.HMAC512(SECRETKEY);

            JWTVerifier verifier = JWT.require(algorithm)
                                      .withIssuer(ISSUER).build();

            DecodedJWT decodedJWT = verifier.verify(token);

            if(decodedJWT==null)
                return false;
        }catch (Exception exception){
            return false;
        }
        return  true;
    }


    public Optional<Long> getIdByToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC512(SECRETKEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUER).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            if(decodedJWT == null)
                return Optional.empty();
            Long authId = decodedJWT.getClaim("authId").asLong();
            return Optional.of(authId);
        }catch (Exception exception){
            return  Optional.empty();
        }
    }
}
