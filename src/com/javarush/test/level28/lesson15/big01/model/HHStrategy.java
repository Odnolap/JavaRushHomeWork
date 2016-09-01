package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Odnolap on 26.01.2016.
 */
public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        ArrayList<Vacancy> result = new ArrayList<>();
        Document doc;
        try {
            for (int page = 0; ; page++) {

                doc = Jsoup.connect(String.format(URL_FORMAT, searchString, page)).referrer("http://google.com").userAgent("Mozilla/5.0 (Windows NT 6.3; WOW64; rv:44.0) Gecko/20100101 Firefox/44.0").get();
//                doc = getDocument(searchString, page);
                List<Element> elements = doc.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy");
                if (elements != null && !elements.isEmpty()) {
                    for (Element e : elements){
                        Vacancy v = new Vacancy();
                        v.setTitle(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
                        v.setSalary(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text());
                        v.setCity(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                        v.setCompanyName(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                        v.setSiteName("hh.ru");
                        v.setUrl(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href"));

                        result.add(v);
                    }
                } else
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception ignored) {}

        return result;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format("http://javarush.ru/testdata/big28data.html?text=java+%s&page=%d", searchString, page)).referrer("http://google.com").userAgent("Mozilla/5.0 (Windows NT 6.3; WOW64; rv:44.0) Gecko/20100101 Firefox/44.0").get();
    }
}
