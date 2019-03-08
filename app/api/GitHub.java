package api;

import bean.Contributor;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface GitHub {
    @RequestLine("GET /repos/{owner}/{repo}/fethcCard")
    List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);
}