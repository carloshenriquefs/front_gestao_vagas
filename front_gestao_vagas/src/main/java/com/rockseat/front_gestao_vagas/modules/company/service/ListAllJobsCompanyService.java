package com.rockseat.front_gestao_vagas.modules.company.service;

import com.rockseat.front_gestao_vagas.modules.candidate.dto.JobDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Service
public class ListAllJobsCompanyService {

    @Value("${host.api.gestao.vagas}")
    private String hostAPIGestaoVagas;

    public List<JobDTO> execute(String token) {
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        var httpEntity = new HttpEntity<>(headers);

        ParameterizedTypeReference<List<JobDTO>> responseType = new ParameterizedTypeReference<List<JobDTO>>() {};

        var url = hostAPIGestaoVagas.concat("/company/job/");

        var result = rt.exchange(url, GET, httpEntity, responseType);

        return result.getBody();
    }
}
