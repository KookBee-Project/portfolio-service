package com.KookBee.portfolioservice.repository;

import com.KookBee.portfolioservice.domain.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
