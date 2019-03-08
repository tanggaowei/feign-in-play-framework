package api;

import bean.vto.CardVto;
import bean.vo.QueryCardVo;
import feign.QueryMap;
import feign.RequestLine;

public interface GeneralCardApi {
    @RequestLine("GET /api/v1/cards/detail")
    CardVto fethcCard(@QueryMap QueryCardVo queryMap);
}