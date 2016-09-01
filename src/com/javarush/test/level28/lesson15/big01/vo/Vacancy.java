package com.javarush.test.level28.lesson15.big01.vo;

/**
 * Created by Odnolap on 26.01.2016.
 */
public class Vacancy
{
    private String title;
    private String salary;
    private String city;
    private String companyName;
    private String siteName;
    private String url;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getSalary()
    {
        return salary;
    }

    public void setSalary(String salary)
    {
        this.salary = salary;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public String getSiteName()
    {
        return siteName;
    }

    public void setSiteName(String siteName)
    {
        this.siteName = siteName;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    @Override
    public int hashCode()
    {
        int result = 0;

        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (siteName != null ? siteName.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);

        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;

        if (!this.getClass().getName().equals(obj.getClass().getName()))
            return false;

        Vacancy o = (Vacancy)obj;
        boolean result = true;
        result = (o.title == null && this.title == null ||
                  o.title != null && this.title != null && o.title.equals(this.title)) &&
                 (o.companyName == null && this.companyName == null ||
                  o.companyName != null && this.companyName != null && o.companyName.equals(this.companyName)) &&
                 (o.city == null && this.city == null ||
                  o.city != null && this.city != null && o.city.equals(this.city)) &&
                 (o.siteName == null && this.siteName == null ||
                  o.siteName != null && this.siteName != null && o.siteName.equals(this.siteName)) &&
                 (o.salary == null && this.salary == null ||
                  o.salary != null && this.salary != null && o.salary.equals(this.salary)) &&
                 (o.url == null && this.url == null ||
                  o.url != null && this.url != null && o.url.equals(this.url));


        return result;
    }
}
