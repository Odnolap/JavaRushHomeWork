package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Odnolap on 07.02.2016.
 */
public class HtmlView implements View
{
    private Controller controller;

    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies)
    {
        try
        {
            String newVacanciesHTMLFile = getUpdatedFileContent(vacancies);
            updateFile(newVacanciesHTMLFile);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Saint-Petersburg");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies){
        String s = null;

        try
        {
            Document htmlFile = getDocument();
            Element templateElement = htmlFile.getElementsByClass("template").first();
            Element clearTemplateElement = templateElement.clone();
            clearTemplateElement.removeClass("template").removeAttr("style");

            for (Element e : htmlFile.getElementsByTag("tr")) {
                if ("vacancy".equals(e.attr("class")))
                    e.remove();
            }

            for (Vacancy vacancy : vacancies){
                Element newVacancyElement = clearTemplateElement.clone();
                // !!! Вот как надо! Запрос в формате CSS!
                // !!! Отличная статья про селекторы CSS тут: http://stepbystep.htmlbook.ru/?id=54
//                newVacancyElement.select("[class=\"city\"]").first().text(vacancy.getCity());
                newVacancyElement.getElementsByClass("city").first().text(vacancy.getCity());
//                newVacancyElement.select("[class=\"companyName\"]").first().text(vacancy.getCompanyName());
                newVacancyElement.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
//                newVacancyElement.select("[class=\"salary\"]").first().text(vacancy.getSalary());
                newVacancyElement.getElementsByClass("salary").first().text(vacancy.getSalary());
//                Element link = newVacancyElement.select("a").first();
//                link.text(vacancy.getTitle());
//                link.attr("href", vacancy.getUrl());
                newVacancyElement.getElementsByTag("a").first().text(vacancy.getTitle()).attr("href", vacancy.getUrl());
                templateElement.before(newVacancyElement);
            }

            s = htmlFile.outerHtml();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            s = "Some exception occurred";
        }

        return s;
    }

    private void updateFile(String fileHTML){
        try
        {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.append(fileHTML);
            fileWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    protected Document getDocument() throws IOException{
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
