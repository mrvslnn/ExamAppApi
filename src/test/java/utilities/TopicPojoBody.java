package utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopicPojoBody {
    private List relations= new ArrayList();
    private Integer subjectId;
    private String titleEn;
    private String titleKz;
    private String titleRu;

    /*
    {
  "relations": [
    {
      "dostlukMonth": "JANUARY",
      "gradeLevel": "C1",
      "month": "JANUARY"
    }
  ],
  "subjectId": 0,
  "titleEn": "string",
  "titleKz": "string",
  "titleRu": "string"
}
     */

    public TopicPojoBody(){

    }


    public TopicPojoBody(List relations, int subjectId, String titleEn, String titleKz, String titleRu) {
        this.relations=relations;
        this.subjectId = subjectId;
        this.titleEn = titleEn;
        this.titleKz = titleKz;
        this.titleRu = titleRu;
    }

    public void setRelations(String dostlukMonth, String gradeLevel, String month ) {
        Map<String,Object> jsonObject= new HashMap<>();
        jsonObject.put("dostlukMonth",dostlukMonth);
        jsonObject.put("gradeLevel",gradeLevel);
        jsonObject.put("month",month);

        relations.add(jsonObject);

    }


    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public void setTitleKz(String titleKz) {
        this.titleKz = titleKz;
    }

    public void setTitleRu(String titleRu) {
        this.titleRu = titleRu;
    }

    public List getRelations() {
        return relations;
    }


    public int getSubjectId() {
        return subjectId;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public String getTitleKz() {
        return titleKz;
    }

    public String getTitleRu() {
        return titleRu;
    }

    @Override
    public String toString() {
        return "TopicBody{" +
                "relations=" + relations +
                ", subjectId=" + subjectId +
                ", titleEn='" + titleEn + '\'' +
                ", titleKz='" + titleKz + '\'' +
                ", titleRu='" + titleRu + '\'' +
                '}';
    }
}
