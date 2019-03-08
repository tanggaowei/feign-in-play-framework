package controllers;

import api.ApplicationApi;
import api.GeneralCardApi;
import api.GitHub;
import bean.vto.CardVto;
import bean.Contributor;
import bean.vo.QueryCardVo;
import feign.Feign;
import feign.gson.GsonDecoder;
import play.mvc.*;

import java.util.*;

/**
 * https://github.com/OpenFeign/feign
 */
public class Application extends Controller {

    public static void index() {
        CardVto vto = new CardVto();
        vto.setCardNo("8815000100079988");
        vto.setEndAt("2020-02-01 00:00:00");
        vto.setState("OK");
        renderJSON(vto);
    }

    public static void test(){
        ApplicationApi api = Feign.builder()
                .decoder(new GsonDecoder())
                .target(ApplicationApi.class, "http://localhost:9000");

        QueryCardVo form = new QueryCardVo();
        form.setCardNo("8815000100079988");
        form.setUid("1788826384409271");

        CardVto card = api.fetchCard(form);

        renderJSON(card);
    }

    public static void testSpringBoot(){
        GeneralCardApi api = Feign.builder()
                .decoder(new GsonDecoder())
                .target(GeneralCardApi.class, "http://localhost:8637");

        QueryCardVo form = new QueryCardVo();
        form.setCardNo("8815000100079988");
        form.setUid("1788826384409271");

        CardVto card = api.fethcCard(form);

        renderJSON(card);
    }

    public static void show() {
        GitHub github = Feign.builder()
                .decoder(new GsonDecoder())
                .target(GitHub.class, "https://api.github.com");

        // Fetch and print a list of the fethcCard to this library.
        List<Contributor> contributors = github.contributors("OpenFeign", "feign");
        for (Contributor contributor : contributors) {
            System.out.println(contributor.login + " (" + contributor.contributions + ")");
        }
        renderText("OK");
    }

}