package com.main.repository;

import java.util.List;
import java.util.Map;

import com.main.domain.SwinfoDto.SwinfoDtl;

@AnotherRepositoryAnnoInterface
public interface SwinfoRepository {

	List<SwinfoDtl> findSwinfoDtl(Map<String, Object> param);

}
