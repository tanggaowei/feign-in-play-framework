package api;

import bean.vo.QueryCardVo;
import bean.vto.CardVto;
import feign.QueryMap;
import feign.RequestLine;

public interface ApplicationApi {
    @RequestLine("GET /")
    CardVto fetchCard(@QueryMap QueryCardVo queryMap);
}