package org.has.service;


import lombok.RequiredArgsConstructor;
import org.has.dto.request.LoginRequestDto;
import org.has.dto.request.PatienceSaveRequestDto;
import org.has.dto.request.RegisterRequestDto;
import org.has.exception.AuthException;
import org.has.exception.ErrorType;
import org.has.manager.PatienceManager;
import org.has.mapper.AuthMapper;
import org.has.repository.AuthRepository;
import org.has.repository.entity.Auth;
import org.has.utility.JwtTokenManager;
import org.has.utility.enums.State;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository repository;
    private final JwtTokenManager jwtTokenManager;
    private final PatienceManager patienceManager;
    public void register(RegisterRequestDto dto){

        repository.findOptionalByTcNumber(dto.getTcNumber())
                .ifPresent(auth->{
                    throw new AuthException(ErrorType.KAYITLI_KULLANICI_ADI);
                });
        Auth auth = AuthMapper.INSTANCE.fromDto(dto);
        repository.save(auth);
                patienceManager.save(PatienceSaveRequestDto.builder()
                        .patienceId(auth.getId())
                        .tcNumber(auth.getTcNumber())
                                .email(dto.getEmail())
                                .name(dto.getName())
                                .phone(dto.getPhone())
                                .password(dto.getPassword())
                                .surname(dto.getSurname())
                .build());
         patienceManager.save(AuthMapper.INSTANCE.fromAuth(auth));
    }

    public String login(LoginRequestDto dto){
        Optional<Auth> auth = repository.findOptionalByTcNumberAndPassword(dto.getTcNumber(),dto.getPassword());
        if(auth.isEmpty()) throw new AuthException(ErrorType.USERNAME_PASSWORD_ERROR);

        Optional<String> jwtToken = jwtTokenManager.createToken(auth.get().getId());
        if(jwtToken.isEmpty())
            throw new AuthException(ErrorType.TOKEN_ERROR);
        return jwtToken.get();
    }
}
