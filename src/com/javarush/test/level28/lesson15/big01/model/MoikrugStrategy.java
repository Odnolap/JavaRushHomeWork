package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Odnolap on 15.02.2016.
 */
public class MoikrugStrategy implements Strategy
{
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";
    private static final String URL_PREFIX = "https://moikrug.ru";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        ArrayList<Vacancy> result = new ArrayList<>();
        Document doc;
        try {
            for (int page = 1; ; page++) {

                doc = Jsoup.connect(String.format(URL_FORMAT, page, searchString)).referrer("http://google.com").userAgent("Mozilla/5.0 (Windows NT 6.3; WOW64; rv:44.0) Gecko/20100101 Firefox/44.0").get();
//                doc = getDocument(searchString, page);

                List<Element> elements = doc.getElementsByClass("job");
                if (elements != null && !elements.isEmpty()) {
                    for (Element e : elements){
                        Vacancy v = new Vacancy();
                        v.setTitle(e.getElementsByClass("title").attr("title"));
                        v.setSalary(e.getElementsByClass("count").text());
                        v.setCity(e.getElementsByClass("location").text());
                        v.setCompanyName(e.getElementsByClass("company_name").first().getElementsByTag("a").text());
                        v.setSiteName("moikrug.ru");
                        v.setUrl(URL_PREFIX + e.getElementsByClass("title").first().getElementsByTag("a").attr("href"));

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

    protected Document getDocument(String searchString, int page) throws IOException
    {
        return Jsoup.connect(String.format("http://javarush.ru/testdata/big28data2.html?page=%d&q=java+%s", page, searchString)).referrer("http://google.com").userAgent("Mozilla/5.0 (Windows NT 6.3; WOW64; rv:44.0) Gecko/20100101 Firefox/44.0").get();
    }
}
